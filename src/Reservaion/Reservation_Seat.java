package Reservaion;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListCellRenderer;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JToggleButton;
import javax.swing.border.EmptyBorder;

import MainPage.MainPageFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class Reservation_Seat extends JFrame implements ActionListener {

	// 화면 열고 닫는거 설정

	Color color_black = new Color(30, 30, 30);
	Color color_white = new Color(204, 204, 204);
	Color color_beige = new Color(242, 240, 229);
	Color color_boldbeige = new Color(232, 230, 219);

	// 폰트 저장
	Font font10 = new Font("맑은 고딕", Font.BOLD, 10);
	Font font18 = new Font("맑은 고딕", Font.BOLD, 18);
	Font font25 = new Font("맑은 고딕", Font.BOLD, 25);

	Container con = getContentPane();

	// 1. 큰 틀
	JPanel p_north = new JPanel();
	JPanel p_west = new JPanel();
	JPanel p_center = new JPanel();
	JPanel p_east = new JPanel();
	JPanel p_south = new JPanel();

	// --------------2. 북쪽----------------//
	JPanel p_NWGV = new JPanel(); // WGV 마크 & 로그인 & 회원가입 & 예약 확인 버튼
	JPanel p_NTab = new JPanel(); // 영화, 예매, 음식 버튼 -> 클릭하면 넘어감
	JPanel p_NBlink = new JPanel(); // 빈칸

	// 2-1-1. 북쪽 WGV 마크 + 광고
	JLabel l_Nblink = new JLabel(); // 빈칸
	ImageIcon WGV = new ImageIcon("image/WGV.png"); // WGV 마크
	JButton b_WGV = new JButton(WGV);
	ImageIcon N_adr = new ImageIcon("image/adv.png"); // 광고
	JLabel l_N_adr = new JLabel(N_adr);
	JPanel p_login = new JPanel(); // 로그인 버튼 묶음
	ImageIcon line1 = new ImageIcon("image/선1.png"); // 그레이선
	JLabel l_line1 = new JLabel(line1);

	// 2-1-2. 북쪽 로그인 버튼들
	ImageIcon login = new ImageIcon("image/login.png");
	JButton b_login = new JButton(login); // 로그인 버튼
	ImageIcon join = new ImageIcon("image/회원가입.png");
	JButton b_join = new JButton(join); // 회원가입 버튼
	ImageIcon mywgv = new ImageIcon("image/MY WGV.png");
	JButton b_mywgv = new JButton(mywgv); // my WGV 버튼
	ImageIcon custom = new ImageIcon("image/고객센터.png");
	JButton b_custom = new JButton(custom); // 고객센터 버튼

	// 2-2. 북쪽 탭 버튼들
	JLabel l_tabblink = new JLabel(); // 빈칸
	ImageIcon tabmoive = new ImageIcon("image/탭영화.png");
	JButton b_tabmoive = new JButton(tabmoive); // 영화 탭
	ImageIcon tabmoiveRe = new ImageIcon("image/탭예매.png");
	JButton b_tabmoiveRe = new JButton(tabmoiveRe); // 예약 탭
	ImageIcon tabFood = new ImageIcon("image/탭음식.png");
	JButton b_tabFood = new JButton(tabFood); // 음식 탭

	// 2-3. 빈화면
	ImageIcon line2 = new ImageIcon("image/선2.png"); // 그레이선
	JLabel l_line2 = new JLabel(line2);
	JLabel l_blink = new JLabel();

	// --------------3. 서쪽----------------//
	ImageIcon WE_adr = new ImageIcon("image/adv1.png");
	JLabel l_W_adr = new JLabel(WE_adr);

	// --------------3. 동쪽----------------//
	JLabel l_E_adr = new JLabel(WE_adr);

	// --------------4. 남쪽----------------//
	JLabel S_blink1 = new JLabel(); // -> 빈칸

	ImageIcon slct_movie = new ImageIcon("image/영화선택.png"); // 영화선택을 돌아가기 버튼
	JButton b_slct_movie = new JButton(slct_movie);

	static ImageIcon l_pic = new ImageIcon("image/고스트.png"); // 선택한 영화 이미지 버튼
	static String movieimagePath ; // = 데이터베이스에 저장할 값
	static JLabel l_moiveimg = new JLabel(l_pic);

	JPanel p_movieName = new JPanel(); // 영화 제목
	static JTextArea area = new JTextArea("ㅁ");

	JPanel p_movieInfo = new JPanel(); // 영화 날짜/시간/상영관/좌석선택
	static JLabel l_날짜 = new JLabel("날짜 ");
	static JLabel l_시간 = new JLabel("시간 ");
	static JLabel l_상영관 = new JLabel("상영관 ");

	JPanel p_seatInfo = new JPanel(); // 영화 좌석 번호
	JLabel l_인원 = new JLabel("인원 ");
	JLabel l_좌석 = new JLabel("좌석 ");

	ImageIcon rsvt_end = new ImageIcon("image/예약하기.png"); // 예약하기을 돌아가기 버튼
	JButton b_rsvt_end = new JButton(rsvt_end);

	JLabel S_blink2 = new JLabel(); // -> 빈칸

	// --------------5. 가운데----------------//
	JPanel p_Title = new JPanel(); // 예약하기 타이틀 패널
	JLabel l_Title = new JLabel("인원 / 좌석 선택", JLabel.CENTER); // 예약하기 타이틀 이름
	ImageIcon again = new ImageIcon("image/다시하기.png"); // 다시하기 버튼
	JButton b_again = new JButton(again);

	JPanel p_percnt = new JPanel(); // 인원 선택 패널
	JLabel l_percnt = new JLabel("인원수"); // 인원수

	JToggleButton[] b_percnts = new JToggleButton[9]; // 인원 선택하는 것
	ButtonGroup bg_person = new ButtonGroup();
	String percntStr = "";
	int percntINT = 0;

	// A~E줄
	JToggleButton[][] b_seat = new JToggleButton[4][8]; // 좌석 버튼 배열 생성
	JPanel p_seat = new JPanel();
	String seatString = "";

	public Reservation_Seat() {

		setSize(1500, 1000);
		setTitle("WGV 좌석 선택");
		setLocation(250, 30);

		init();
		start();
		setVisible(true);

	}

	/** 프레임 설정 하기 */
	private void init() {
		con.setLayout(new BorderLayout());
		// 0. 기본 틀
		con.add("North", p_north);
		con.add("West", p_west);
		con.add("Center", p_center);
		con.add("East", p_east);
		con.add("South", p_south);

		// 0-1) 동서남북 가운데 사이즈 정해주기
		p_north.setPreferredSize(new Dimension(1500, 235));
		p_center.setPreferredSize(new Dimension(1130, 600));
		p_south.setPreferredSize(new Dimension(1500, 165));
		p_west.setPreferredSize(new Dimension(185, 835));
		p_east.setPreferredSize(new Dimension(185, 835));

		// 1. 북쪽 패널 설정
		p_north.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));

		p_north.add(p_NWGV);
		p_north.add(p_NTab);
		p_north.add(p_NBlink);

		// --------------북쪽----------------//
		// * 1) 북쪽 . 패널 사이즈 설정
		p_NWGV.setPreferredSize(new Dimension(1500, 105)); // WGV 마크 쪽 사이즈
		p_NTab.setPreferredSize(new Dimension(1500, 50)); // 탭 쪽 사이즈
		p_NBlink.setPreferredSize(new Dimension(1500, 80)); // 빈칸 사이즈

		// 1-1. 북쪽 wgv 마크 & 버튼 설정
		p_NWGV.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
		p_NWGV.add(l_Nblink); // WGV 마크
		p_NWGV.add(b_WGV); // WGV 마크
		p_NWGV.add(l_N_adr);// 광고
		p_NWGV.add(p_login);// 로그인 버튼 묶음
		p_NWGV.add(l_line1);// 로그인 버튼 묶음

		// * 1-1) 북쪽 wgv 마크 & 버튼 설정 사이즈 설정
		l_Nblink.setPreferredSize(new Dimension(185, 104));
		b_WGV.setPreferredSize(new Dimension(525, 104));
		l_N_adr.setPreferredSize(new Dimension(210, 104));
		p_login.setPreferredSize(new Dimension(580, 104));
		l_line1.setPreferredSize(new Dimension(1500, 1)); // 선1 추가

		p_NWGV.setBackground(Color.white);
		b_WGV.setBackground(Color.white);
		p_NWGV.paintComponents(getGraphics());
		b_WGV.setBorder(new EmptyBorder(0, 0, 0, 0));
		// 1-1-1. 북쪽 WGV 마크 맨 오른쪽 로그인 버튼들
		p_login.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));

		p_login.add(b_login);
		p_login.add(b_join);
		p_login.add(b_mywgv);
		p_login.add(b_custom);

		p_login.setBackground(Color.white);

		// * 1-1-1.)북쪽 WGV 마크 맨 오른쪽 로그인 버튼들 사이즈 설정
		b_login.setPreferredSize(new Dimension(100, 105));
		b_join.setPreferredSize(new Dimension(100, 105));
		b_mywgv.setPreferredSize(new Dimension(100, 105));
		b_custom.setPreferredSize(new Dimension(100, 105));

		// * 버튼 테투리선 제거
		b_login.setBorder(new EmptyBorder(0, 0, 0, 0));
		b_join.setBorder(new EmptyBorder(0, 0, 0, 0));
		b_mywgv.setBorder(new EmptyBorder(0, 0, 0, 0));
		b_custom.setBorder(new EmptyBorder(0, 0, 0, 0));

		// 1-2. 북쪽 탭 설정
		p_NTab.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
		p_NTab.add(l_tabblink);
		p_NTab.add(b_tabmoive);
		p_NTab.add(b_tabmoiveRe);
		p_NTab.add(b_tabFood);

		// * 1-2) 탭 배경 색
		p_NTab.setBackground(Color.white);

		// * 1-2.)북쪽 탭 설정 버튼들 사이즈 설정
		l_tabblink.setPreferredSize(new Dimension(185, 50));
		b_tabmoive.setPreferredSize(new Dimension(180, 50));
		b_tabmoiveRe.setPreferredSize(new Dimension(180, 50));
		b_tabFood.setPreferredSize(new Dimension(180, 50));

		// * 버튼 테투리선 제거
		b_tabmoive.setBorder(new EmptyBorder(0, 0, 0, 0));
		b_tabmoiveRe.setBorder(new EmptyBorder(0, 0, 0, 0));
		b_tabFood.setBorder(new EmptyBorder(0, 0, 0, 0));

		// * 1-3.) 북쪽 블링크 생성
		p_NBlink.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
		p_NBlink.add(l_line2);
		p_NBlink.add(l_blink);

		l_line2.setPreferredSize(new Dimension(1500, 3));
		l_blink.setPreferredSize(new Dimension(1500, 77));

		p_NBlink.setBackground(Color.white);

		// --------------서쪽----------------//
		// 2. 서쪽 광고 삽입
		p_west.setLayout(new GridLayout(2, 1, 5, 5));
		p_west.add(l_W_adr);

		p_west.setBackground(Color.white);

		// --------------동쪽----------------//
		// 3. 동쪽 광고 삽입
		p_east.setLayout(new GridLayout(2, 1, 0, 0));
		p_east.add(l_E_adr);

		p_east.setBackground(Color.white);

		// --------------남쪽----------------//
		// 4. 남쪽
		p_south.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));

		// 4-1) 남쪽 각각 영역 설정
		p_south.add(S_blink1); // 빈칸
		p_south.add(b_slct_movie); // 영화선택으로 돌아가기 버튼
		p_south.add(l_moiveimg); // 영화 이미지
		p_south.add(p_movieName); // 영화 제목 라
		p_south.add(p_movieInfo); // 영화 일시,상영관
		p_south.add(p_seatInfo); // 인원,좌석번호
		p_south.add(b_rsvt_end); // 예약하기 버튼
		p_south.add(S_blink2); // 빈칸

		// 4-2) 영화 제목 텍스트 설정
		p_movieName.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 40));
		p_movieName.add(area).setForeground(color_white);
		p_movieName.setBackground(color_black);
		area.setLineWrap(true); // 자동 줄바꿈 활성화
		area.setWrapStyleWord(true); // 단어 단위 줄바꿈
		area.setFont(font18);

		// 4-3) 영화 일시,상영관 설정
		p_movieInfo.setLayout(new GridLayout(3, 1, 0, 0));
		p_movieInfo.add(l_날짜).setFont(font18);
		p_movieInfo.add(l_시간).setFont(font18);
		p_movieInfo.add(l_상영관).setFont(font18);

		// 4-4) 인원,좌석번호 설정
		p_seatInfo.setLayout(new GridLayout(3, 1, 0, 0));
		p_seatInfo.add(l_인원).setFont(font18);
		p_seatInfo.add(l_좌석).setFont(font18);

		// 4-5) 양쪽 버튼 설정 
		b_slct_movie.setBorder(new EmptyBorder(0, 0, 0, 0));
		b_rsvt_end.setBorder(new EmptyBorder(0, 0, 0, 0));

		
		
		// * 4. 남쪽 사이즈 셋팅
		S_blink1.setPreferredSize(new Dimension(185, 165)); // 빈칸
		b_slct_movie.setPreferredSize(new Dimension(145, 145)); // 영화선택 버튼
		l_moiveimg.setPreferredSize(new Dimension(185, 145)); // 영화 이미지
		p_movieName.setPreferredSize(new Dimension(220, 145)); // 영화 이름
		p_movieInfo.setPreferredSize(new Dimension(210, 145)); // 영화 일시,상영관,인원
		p_seatInfo.setPreferredSize(new Dimension(210, 145)); // 영화 좌석
		b_rsvt_end.setPreferredSize(new Dimension(145, 145)); // 예약하기 완 버튼
		S_blink2.setPreferredSize(new Dimension(185, 165)); // 빈칸

		p_south.setBackground(color_boldbeige);

		// --------------가운데----------------//
		p_center.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
		// p_center.setPreferredSize(new Dimension(1130,600));

		p_center.add(p_Title);
		p_center.add(p_percnt);

		for (int i = 0; i < 9; i++) {
			b_percnts[i] = new JToggleButton(String.valueOf(i));
			b_percnts[i].setBackground(color_beige);
			b_percnts[i].setFont(font18);
			b_percnts[i].setPreferredSize(new Dimension(50, 50));
			b_percnts[0].setSelected(true);
		}

		p_percnt.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
		p_percnt.add(l_percnt).setFont(font18);

		for (JToggleButton button : b_percnts) {
			p_percnt.add(button); // p_percnt 패널에 추가
			bg_person.add(button); // 버튼 1개만 클릭할 수 있게
		}

		// 좌석 버튼 생성 및 텍스트 설정
		for (int i = 0; i < 4; i++) {
			p_seat = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10)); // 행별로 좌석을 담을 패널 생성
			char rowChar = (char) ('A' + i); // 행 문자 계산 (A부터 시작)
			for (int j = 0; j < 8; j++) {
				String seatText = Character.toString(rowChar) + (j + 1); // 좌석 텍스트 생성 (예: A1, A2, ..., E8)
				b_seat[i][j] = new JToggleButton(seatText); // JToggleButton으로 변경
				p_seat.add(b_seat[i][j]); // 패널에 좌석 버튼 추가

				b_seat[i][j].setFont(font25);
				b_seat[i][j].setPreferredSize(new Dimension(80, 80));
				b_seat[i][j].setBackground(color_beige); // 초기 배경색 설정

				b_seat[i][j].setEnabled(false); // 처음엔 비활성화
			}
			p_center.add(p_seat); // 행별로 생성된 패널을 중앙 패널에 추가
		}

		// 5-1. 타이틀 설정
		p_Title.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
		p_Title.add(l_Title).setFont(font18);
		
		p_Title.add(b_again);

		p_Title.setBackground(Color.RED);
		l_Title.setForeground(color_white);

		// * 5-1. 타이틀 설정 사이즈
		p_Title.setPreferredSize(new Dimension(1130, 50));
		l_Title.setPreferredSize(new Dimension(984, 50));
		b_again.setPreferredSize(new Dimension(146, 50));

		// 5-2. 가운데 장소 +시간 / 인원 선택 사이즈
		p_percnt.setPreferredSize(new Dimension(1130, 100));
	}

	private void start() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		// 커서 변경 -> 마우스로
		JButton[] allButtons = { b_login, b_join, b_mywgv, b_custom, b_tabmoive, b_tabmoiveRe, b_tabFood };

		for (JButton allButton : allButtons) {
			allButton.addMouseListener(new MouseAdapter() {
				// allButton 변수가 MouseAdapter 내부에서 수정될 수 없기 때문에 오류가 발생
				// final 선언 or effectively final 해야함
				final JButton button = allButton;

				public void mouseEntered(MouseEvent e) {
					button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				}

				@Override
				public void mouseExited(MouseEvent e) {
					button.setCursor(Cursor.getDefaultCursor());
				}
			});
		}

		// 좌석 수 클릭
		for (int i = 0; i < 8; i++) {
			b_percnts[i].addActionListener(this);
		}

		// 좌석 위치 클릭
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 8; j++) {
				b_seat[i][j].addActionListener(this);
			}
		}
		// 리셋
		b_again.addActionListener(this);
		b_slct_movie.addActionListener(this);
		b_rsvt_end.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		// 리셋
		if (e.getSource() == b_again) {
			// 모든 좌석 선택 버튼 선택해제 및 활성화
			b_percnts[0].setSelected(true); // 인원수 0 으로 초기화
			l_인원.setText("인원   ");
			percntINT = 0;
			seatString = "";
			for (JToggleButton[] row : b_seat) {
				for (JToggleButton button : row) {
					button.setSelected(false);
					button.setEnabled(true);
				}
			}
		}

		// 다시 영화 선택하기 하면 창 닫기
	      if (e.getSource() == b_slct_movie) {
	         setVisible(false); // 창을 숨깁니다.
	         ReservationFrame rs  = new ReservationFrame();
	         rs.setVisible(true);
	      }

		if (e.getSource() == b_rsvt_end) {
			String confMess = "영화 : " + area.getText() + "\n" + l_날짜.getText() + "\n" + l_시간.getText() + "\n"
					+ l_상영관.getText() + "\n" + l_인원.getText() + "\n" + l_좌석.getText();

			int result = JOptionPane.showConfirmDialog(this, confMess, "예약하시겠습니까?", JOptionPane.OK_CANCEL_OPTION);
			if (result == 0) {
				SeatDAO seatdao = new SeatDAO();
				SeatDTO seatdto = new SeatDTO();
				String image = movieimagePath;
				String mvname = area.getText();
				String cal = l_날짜.getText();
				String time = l_시간.getText();
				String room = l_상영관.getText();

				int count =percntINT;
				System.out.println(image);
				System.out.println(mvname);
				System.out.println(cal);
				System.out.println(time);
				System.out.println(room);
				System.out.println(count);


				// image,mvname,cal,time,room,count
				seatdto.setImage(image);
				seatdto.setMvname(mvname);
				seatdto.setCal(cal);
				seatdto.setTime(time);
				seatdto.setRoom(room);
				seatdto.setCount(count);
				//seatdto.setName("");
				//seatdto.setId("3");
				
				int save = seatdao.imfosave(seatdto);
				System.out.println(save);
				if (save == 1) {
		               JOptionPane.showConfirmDialog(this, "예약이 완료되었습니다.", "예약완료", JOptionPane.OK_OPTION);
		               setVisible(false);
		               ReservationFrame rf = new ReservationFrame();
		               rf.setVisible(false);
		               MainPageFrame mainPage  = new MainPageFrame();
		               mainPage.setVisible(true);
		            }
				
			}
		}

		// 인원수 선택
		for (JToggleButton button : b_percnts) {
			if (button == e.getSource()) {
				percntStr = button.getText();
				percntINT = Integer.parseInt(percntStr);
				l_인원.setText("인원   " + percntStr + "명");

				for (JToggleButton[] row : b_seat) {
					for (JToggleButton button1 : row) {
						button1.setEnabled(true); // 모든 좌석 버튼을 활성화
					}
				}
			}
		}

		// 좌석 선택
		// 각 버튼의 이전 상태를 저장하는 배열
		List<String> listSeat = new ArrayList<String>();
		for (JToggleButton[] row : b_seat) {
			for (JToggleButton button : row) {
				if (button.isSelected()) { // 선택된 좌석만 고려
					listSeat.add(button.getText() + "열"); // 선택된 좌석 추가
				}
			}
		}

		if (listSeat.size() == percntINT) {
			// 인원 수 초과하지 않은 경우, 좌석 문자열 업데이트
			String seatString = String.join(" ", listSeat);
			l_좌석.setText("좌석   " + seatString);
			for (JToggleButton[] row : b_seat) {
				for (JToggleButton button : row) {
					button.setEnabled(false);
				}
			}
		}
	}

	public static void gettexts(String date, String time, String room, String movieTitle, String imagePath) {
		l_날짜.setText(date);
		l_시간.setText(time);
		l_상영관.setText(room);
		area.setText(movieTitle);
		movieimagePath = imagePath;
		ImageIcon newimagePath = new ImageIcon(imagePath);
		l_moiveimg = new JLabel(newimagePath);

	}
}