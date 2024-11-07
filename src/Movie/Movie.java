package Movie;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.FileReader;
import java.security.DigestInputStream;
import java.util.List;

import javax.naming.directory.SearchControls;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Movie extends JFrame implements ActionListener {
	Container container = getContentPane();
	CardLayout cardLayout = new CardLayout();
	TextFileReader textFileReader = new TextFileReader();
	MoveDAO dao = new MoveDAO();
	List<MoveDTO> list = null;

	// 상단 (패널)
	JPanel panel_North = new JPanel();
	// 로고 영역(패널)
	JPanel panel_rogo = new JPanel();
	// 로고 (라벨)
	JLabel label_rogo = new JLabel("WGV");
	JLabel label_rogosub = new JLabel("원하는 대로 골라 보자!");
	// 카테고리(패널)
	JPanel panel_category = new JPanel();
	// 검색창
	JPanel panel_search = new JPanel();
	ImageIcon icon_search = new ImageIcon("move_img/searchIcon.png");
	JTextField textField_search = new JTextField(15);
	JButton button_search = new JButton(icon_search);

	// 중앙 (패널)
	JPanel panel_Center = new JPanel();

	// 화면전환
	JPanel panel_sceneChange = new JPanel();

	// 중앙 서브(패널)
	JPanel panel_centerborder = new JPanel();

	// 무비 차트 제목
	JPanel panel_title = new JPanel();
	// 무비 차트 (라벨)
	JLabel label_title = new JLabel("무비차트");
	// 무비 차트 (버튼)
	JPanel panel_Tbts = new JPanel();
	ImageIcon icon_r = new ImageIcon("img/right.gif");
	ImageIcon icon_l = new ImageIcon("img/left.gif");
	JButton button_left = new JButton(icon_l);
	JButton button_right = new JButton(icon_r);

	// 페이지 패널
	JPanel panel_page = new JPanel();

	// 무비리스트
	JPanel panel_MS = new JPanel();

	// 첫번째 페이지 (패널)
	JPanel panel_movies1 = new JPanel();
	// 두번째 페이지 (패널)
	JPanel panel_movies2 = new JPanel();
	// 세번째 페이지 (패널)
	JPanel panel_movies3 = new JPanel();
	// 영화포스터(0~19) (아이콘)
	ImageIcon[] icon = new ImageIcon[20]; //("move_img/move1.png");
	// 영화포스터 (버튼)
	JButton[] top = new JButton[20]; //(ImageIcon[0]);


//------------------------------------------------------------------------------------------------------------------------------------------------
//------------------------------------------------------------------------------------------------------------------------------------------------

// 영화 소개 창

	// 예매하기 버튼
	JPanel[] panel_reserve = new JPanel[20];
	JButton[] button_reserve = new JButton[20]; // ("예매 하기");

	// 영화목록 버튼
	JPanel[] panel_movelist = new JPanel[20];
	JButton[] button_movelist = new JButton[20]; // ("영화 목록");

	// top 배열
	JPanel[] panel_report = new JPanel[20];
	JPanel[] panel_Rcenter = new JPanel[20];
	JPanel[] panel_RCleft = new JPanel[20];
	ImageIcon[] plotimg = new ImageIcon[20]; // ("move_img/move1_RP.png");
	// top1 report
	JLabel[] labelplotIMG = new JLabel[20]; // (plotimg1);
	// 파일 경로 지정
	String[] filePath = new String[20]; // "plotfile/1plot.txt";
	// 텍스트 파일 읽어오기
	String[] fileContent = new String[20]; // TextFileReader.readTextFile(filePath);
	// 줄거리 창
	JTextArea[] plotArea = new JTextArea[20]; // (fileContent);
	JScrollPane[] plotScrollPane = new JScrollPane[20]; // (plotArea1);

	public Movie() {
		setSize(1500, 1000);
		setTitle("WGV");
		setLocation(200, 10);
		init();
		start();
		setResizable(false);
		setVisible(true);
	}

	private void init() {
		container.setLayout(cardLayout);

		container.setLayout(new BorderLayout());
		container.setBackground(new Color(255, 60, 60));
		container.add("North", panel_North);
		container.add("Center", panel_sceneChange);

		// North
		panel_North.setLayout(new BorderLayout());
		panel_North.setBackground(Color.white);
		panel_North.add("Center", panel_rogo);
		panel_North.add("South", panel_category);
		// rogo
		panel_rogo.setLayout(new FlowLayout(FlowLayout.LEFT));
		panel_rogo.setBackground(Color.white);
		panel_rogo.add(label_rogo);
		label_rogo.setFont(new Font("휴먼둥근헤드라인", Font.BOLD, 45));
		panel_rogo.add(label_rogosub);
		label_rogosub.setFont(new Font("맑은 고딕", 0, 10));

		// panel_category
		panel_category.setLayout(new BorderLayout());
		panel_category.setBackground(Color.RED);
		panel_category.add("East", panel_search);

		// panel_search
		panel_search.setBackground(Color.RED);
		panel_search.add(textField_search);
		panel_search.add(button_search);

		// textField_search
		textField_search.setPreferredSize(new Dimension(100, 50));
		textField_search.setFont(new Font("맑은 고딕", Font.BOLD, 25));

		// button_search
		button_search.setPreferredSize(new Dimension(50, 50));
		button_search.setBorder(new EmptyBorder(0, 0, 0, 0));
		button_search.setBackground(new Color(0, 0, 0, 0));
		button_search.setOpaque(false);

		// Center
		panel_Center.setLayout(new BorderLayout());
		panel_Center.setBackground(Color.white);
		panel_Center.add("North", panel_title);
		panel_Center.add("Center", panel_centerborder);

		// panel_title
		panel_title.setLayout(new BorderLayout());
		panel_title.setBackground(Color.white);
		panel_title.add("West", label_title);

		// title font
		label_title.setFont(new Font("맑은 고딕", Font.BOLD, 25));

		panel_title.add("East", panel_Tbts);
		panel_Tbts.setBackground(Color.white);
		panel_Tbts.add(button_left);
		panel_Tbts.add(button_right);

		button_left.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		button_right.setFont(new Font("맑은 고딕", Font.BOLD, 18));

		// title buttons color
		button_left.setBackground(Color.white);
		button_right.setBackground(Color.white);
		button_left.setBorder(new EmptyBorder(5, 5, 5, 5));
		button_right.setBorder(new EmptyBorder(5, 5, 5, 5));

		// panel_centerborder
		panel_centerborder.setLayout(new BorderLayout());
		panel_centerborder.setBackground(Color.white);
		panel_centerborder.add("Center", panel_MS);

		// panel_MS
		panel_MS.setLayout(new FlowLayout(FlowLayout.CENTER));
		panel_MS.setBackground(Color.white);
		panel_MS.add(panel_page);

		// panel_page
		panel_page.setLayout(cardLayout);
		panel_page.add(panel_movies1, "1");
		panel_page.add(panel_movies2, "2");
		panel_page.add(panel_movies3, "3");
	
		// 이미지 아이콘 생성 및 버튼에 아이콘 삽입
		for(int i=0; i<20; i++) {
			icon[i] = new ImageIcon("move_img/move"+(i+1)+".png");
			top[i] = new JButton(icon[i]);
			// 버튼 배경색 
			top[i].setBackground(Color.white);
			// 버튼 테두리 색
			top[i].setBorder(new EmptyBorder(0, 0, 0, 0));
		}
		
		// panel_movies1 버튼 입력
		panel_movies1.setLayout(new GridLayout(2, 4, 10, 10));
		panel_movies1.setBackground(Color.white);
		// panel_movies1 버튼 입력
		for(int i=0; i<8; i++) {
			panel_movies1.add(top[i]);
		}

		// panel_movies2
		panel_movies2.setLayout(new GridLayout(2, 4, 10, 10));
		panel_movies2.setBackground(Color.white);
		// panel_movies2 버튼 입력
		for(int i=0; i<8; i++) {
			panel_movies2.add(top[(i+8)]);
		}
		
		// panel_movies3
		panel_movies3.setLayout(new GridLayout(2, 4, 10, 10));
		panel_movies3.setBackground(Color.white);
		// panel_movies3 버튼 입력
		for(int i=0; i<4; i++) {
			panel_movies3.add(top[(i+16)]);
		}



//------------------------------------------------------------------------------------------------------------------------------------------------
//------------------------------------------------------------------------------------------------------------------------------------------------

// 영화 소개 창

// top

		for (int i = 0; i < 20; i++) {
			panel_report[i] = new JPanel();
			panel_Rcenter[i] = new JPanel();
			plotScrollPane[i] = new JScrollPane();
			panel_reserve[i] = new JPanel();
			panel_movelist[i] = new JPanel();
			button_movelist[i] = new JButton("영화 목록");
			button_reserve[i] = new JButton("예매 하기");

			// 이미지 삽입
			plotimg[i] = new ImageIcon("move_img/move" + (i + 1) + "_RP.png");
			labelplotIMG[i] = new JLabel(plotimg[i]);
			// 텍스트파일 경로 지정
			filePath[i] = new String("plotfile/" + (i + 1) + "plot.txt");
			// 텍스트파일 읽어오기
			fileContent[i] = new String(TextFileReader.readTextFile(filePath[i]));
			// 텍스트에리어에 삽입
			plotArea[i] = new JTextArea(fileContent[i]);
			// 스크롤페인에 텍스트에리어 삽입
			plotScrollPane[i] = new JScrollPane(plotArea[i]);
			// 패널 정렬
			panel_report[i].setLayout(new BorderLayout());
			panel_report[i].setBackground(Color.white);
			panel_report[i].add("Center", labelplotIMG[i]);
			panel_report[i].add("South", panel_Rcenter[i]);
			panel_report[i].add("West", panel_movelist[i]);
			panel_report[i].add("East", panel_reserve[i]);
			// 줄거리 칸 패널

			panel_Rcenter[i].setBackground(Color.white);
			panel_Rcenter[i].setLayout(new FlowLayout(FlowLayout.CENTER));
			panel_Rcenter[i].add(plotScrollPane[i]);

			// 텍스트에리어 셋팅
			plotArea[i].setFont(new Font("맑은 고딕", Font.BOLD, 20));
			plotArea[i].setEditable(false);

			plotScrollPane[i].setBorder(new EmptyBorder(5, 3, 5, 3));
			plotScrollPane[i].setBackground(Color.white);

			// 영화리스트 버튼
			panel_movelist[i].setLayout(new BorderLayout());
			panel_movelist[i].setBackground(Color.white);
			panel_movelist[i].add("North", button_movelist[i]);
			button_movelist[i].setFont(new Font("맑은 고딕", Font.BOLD, 25));
			panel_movelist[i].setPreferredSize(new Dimension(200, 100));
			// 예매하기 버튼
			panel_reserve[i].setLayout(new BorderLayout());
			panel_reserve[i].setBackground(Color.white);
			panel_reserve[i].add("South", button_reserve[i]);
			button_reserve[i].setFont(new Font("맑은 고딕", Font.BOLD, 25));
			button_reserve[i].setPreferredSize(new Dimension(200, 100));

		}

		// scene change
		panel_sceneChange.setLayout(cardLayout);
		panel_sceneChange.add(panel_Center, "home");
		for (int i = 0; i < 20; i++) {
			panel_sceneChange.add(panel_report[i], "top" + i);
		}

	}

	private void start() {
		// 창 닫기
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		// 무비리스트 페이지 이벤트
		button_left.addActionListener(this);
		button_right.addActionListener(this);
		// 무비리스트 와 소개페이지 이동 이벤트
		for (int i = 0; i < 20; i++) {
			button_movelist[i].addActionListener(this);
		}
		// 소개 페이지
		for(int i=0; i<20; i++) {
			top[i].addActionListener(this);
		}
		
		// 검색 버튼 이벤트
		button_search.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// 화면 전환(무비차트 & 상영예정작)
		if (e.getSource() == button_left) {
			cardLayout.previous(panel_page);
		} else if (e.getSource() == button_right) {
			cardLayout.next(panel_page);
		}
		// 화면 전환2(포스트 클릭 시)
		for(int i=0; i<20; i++) {
			if(e.getSource()==top[i]) {
				cardLayout.show(panel_sceneChange, "top"+i);
			}
		}

		

		// 영화목록으로 돌아가는 버튼
		for (int i = 0; i < 20; i++) {
			if (e.getSource() == button_movelist[i]) {
				cardLayout.show(panel_sceneChange, "home");
			}
		}

		// 검색버튼
		if (e.getSource() == button_search) {
			String name = textField_search.getText();
			list = dao.searchArticle(name);
			int result = 0;
			for (int i = 0; i < list.size(); i++) {
				MoveDTO dto = list.get(i);
				result = dto.getNum();
				System.out.println(result);
				cardLayout.show(panel_sceneChange, "top" + (result-1));
			}

		}
	}
}
