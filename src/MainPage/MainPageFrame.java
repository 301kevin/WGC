package MainPage;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.DefaultListCellRenderer;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import Movie.Movie;
import Reservaion.ReservationFrame;
import Reservation_Con.Reservaion_Con;
import food.Snack;
import login.SignUpFrame;
import login.idFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class MainPageFrame extends JFrame implements ActionListener, KeyListener {

	CardLayout cardLayout = new CardLayout();

	
	Color color_black = new Color(30, 30, 30);
	Color color_white = new Color(204, 204, 204);
	Color color_beige = new Color(242, 240, 229);
	Color color_boldbeige = new Color(232, 230, 219);

	// 폰트 저장
	Font font25 = new Font("맑은 고딕", Font.BOLD, 25);

	Container con = getContentPane();

	// 1. 큰 틀
	JPanel p_north = new JPanel();
	JPanel p_center = new JPanel();
	JPanel p_south = new JPanel();

	// --------------2. 북쪽----------------//
	JPanel p_NWGV = new JPanel(); // WGV 마크 & 로그인 & 회원가입 & 예약 확인 버튼
	JPanel p_NTab = new JPanel(); // 영화, 예매, 음식 버튼 -> 클릭하면 넘어감

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
	
	// 로그인 시 바뀔 버튼 & 라벨 
	ImageIcon blink = new ImageIcon("image/빈칸.png");
	JLabel l_blink = new JLabel(blink); // 로그인 버튼
	ImageIcon loginout = new ImageIcon("image/로그아웃.png");
	JButton b_loginout = new JButton(loginout); // 로그인 버튼

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

	// 2-3. 빨간줄
	ImageIcon line2 = new ImageIcon("image/선2.png"); // 그레이선
	JLabel l_line2 = new JLabel(line2);

	// --------------2. 가운데----------------//
	// 영상 삽입
	ImageIcon Mimage = new ImageIcon("image/M_메인이미지.gif"); // 메인 이미지
	JLabel l_Mimage = new JLabel(Mimage);

	// --------------3. 버튼 ----------------//
	JLabel l_Wblink = new JLabel(); // 빈칸
	JPanel p_main = new JPanel(); // 메인 버튼 모음
	JLabel l_Eblink = new JLabel(); // 빈칸

	// 3-1. 메인 총
	JPanel p_mainTot = new JPanel(); // 메인 바로가기 + 버튼들

	ImageIcon mainTitle1 = new ImageIcon("image/M_영화이미지.png"); // 메인 이미지
	ImageIcon mainTitle2 = new ImageIcon("image/M_음식이미지.png"); // 메인 이미지
	ImageIcon mainTitle3 = new ImageIcon("image/M_예약이미지.png"); // 메인 이미지
	ImageIcon mainTitle4 = new ImageIcon("image/M_확인이미지.png"); // 메인 이미지
	JLabel l_mainTitle = new JLabel(mainTitle1); // 메인 바로가기

	// 3-2. 메인 버튼
	JPanel p_mainbuttons = new JPanel();

	ImageIcon movie = new ImageIcon("image/M_영화.png");
	JButton M_Movie = new JButton(movie); // 영화 버튼

	ImageIcon food = new ImageIcon("image/M_음식.png");
	JButton M_Food = new JButton(food); // 음식 버튼

	ImageIcon rsvt = new ImageIcon("image/M_예약.png");
	JButton M_Rsvt = new JButton(rsvt); // 예약 버튼

	ImageIcon check = new ImageIcon("image/M_확인.png");
	JButton M_Check = new JButton(check); // 예약 확인

	public MainPageFrame() {

		setSize(1500, 1000);
		setTitle("web으로 어디서든 즐거움을! ,WGV");
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
		con.add("Center", p_center);
		con.add("South", p_south);

		// 0-1) 동서남북 가운데 사이즈 정해주기
		p_north.setPreferredSize(new Dimension(1500, 158));
		p_center.setPreferredSize(new Dimension(1500, 460));
		p_south.setPreferredSize(new Dimension(1500, 352));

		// 1. 북쪽 패널 설정
		p_north.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
		p_north.add(p_NWGV);
		p_north.add(p_NTab);
		p_north.add(l_line2);

		// --------------북쪽----------------//
		// * 1) 북쪽 . 패널 사이즈 설정
		p_NWGV.setPreferredSize(new Dimension(1500, 105)); // WGV 마크 쪽 사이즈
		p_NTab.setPreferredSize(new Dimension(1500, 50)); // 탭 쪽 사이즈
		l_line2.setPreferredSize(new Dimension(1500, 3)); // 빈칸 사이즈

		// 1-1. 북쪽 wgv 마크 & 버튼 설정
		p_NWGV.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
		p_NWGV.add(l_Nblink); // WGV 마크
		p_NWGV.add(b_WGV); // WGV 마크
		p_NWGV.add(l_N_adr);// 광고
		p_NWGV.add(p_login);// 로그인 버튼 묶음
		p_NWGV.add(l_line1);// 줄

		// * 1-1) 북쪽 wgv 마크 & 버튼 설정 사이즈 설정
		l_Nblink.setPreferredSize(new Dimension(185, 104));
		b_WGV.setPreferredSize(new Dimension(525, 104));
		l_N_adr.setPreferredSize(new Dimension(210, 104));
		p_login.setPreferredSize(new Dimension(580, 104));
		l_line1.setPreferredSize(new Dimension(1500, 1)); // 선1 추가

		p_NWGV.setBackground(Color.white);
		p_NWGV.paintComponents(getGraphics());
		b_WGV.setBorder(new EmptyBorder(0, 0, 0, 0));
		b_WGV.setBackground(Color.white);

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
		l_blink.setPreferredSize(new Dimension(100, 105));
		b_loginout.setPreferredSize(new Dimension(100, 105));

		// * 버튼 테투리선 제거
		b_login.setBorder(new EmptyBorder(0, 0, 0, 0));
		b_join.setBorder(new EmptyBorder(0, 0, 0, 0));
		b_mywgv.setBorder(new EmptyBorder(0, 0, 0, 0));
		b_custom.setBorder(new EmptyBorder(0, 0, 0, 0));
		b_loginout.setBorder(new EmptyBorder(0, 0, 0, 0));
		l_blink.setBorder(new EmptyBorder(0, 0, 0, 0));

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
		l_line2.setPreferredSize(new Dimension(1500, 3));

		// --------------가운데----------------//
		p_center.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
		p_center.add(l_Mimage);

		l_Mimage.setPreferredSize(new Dimension(1500, 460));

		// --------------남쪽----------------//
		p_south.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));

		p_south.add(l_Wblink);
		p_south.add(p_mainTot);
		p_south.add(l_Eblink);

		l_Wblink.setPreferredSize(new Dimension(180, 352));
		l_Eblink.setPreferredSize(new Dimension(180, 352));

		p_south.setBackground(Color.white);

		// 메인 바로가기 + 버튼들
		p_mainTot.setLayout(new FlowLayout(FlowLayout.LEFT, 50, 0));
		p_mainTot.add(l_mainTitle);
		p_mainTot.add(p_mainbuttons);

		p_mainbuttons.setLayout(new GridLayout(4, 1, 0, 0));
		p_mainbuttons.add(M_Movie);
		p_mainbuttons.add(M_Food);
		p_mainbuttons.add(M_Rsvt);
		p_mainbuttons.add(M_Check);

		l_mainTitle.setPreferredSize(new Dimension(670, 352));
		M_Movie.setPreferredSize(new Dimension(270, 72));
		M_Food.setPreferredSize(new Dimension(270, 72));
		M_Rsvt.setPreferredSize(new Dimension(270, 72));
		M_Check.setPreferredSize(new Dimension(270, 72));

		p_mainTot.setBackground(Color.white);

	}

	private void start() {
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		// 커서 변경 -> 마우스로
		JButton[] allButtons = { b_login, b_join, b_mywgv, b_custom, b_tabmoive, b_tabmoiveRe, b_tabFood, M_Movie,
				M_Food, M_Rsvt, M_Check, b_WGV,b_loginout };
		for (JButton allButton : allButtons) {
			allButton.addActionListener(this);
		}

		for (JButton allButton : allButtons) {
			// 마우스가 올라갔을 떄 커서 변경
			allButton.addMouseListener(new MouseAdapter() {
				final JButton button = allButton;

				public void mouseEntered(MouseEvent e) {
					button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
					if (allButton == M_Movie) {
						l_mainTitle.setIcon(mainTitle1);
					} else if (allButton == M_Food) {
						l_mainTitle.setIcon(mainTitle2);
					} else if (allButton == M_Rsvt) {
						l_mainTitle.setIcon(mainTitle3);
					} else if (allButton == M_Check) {
						l_mainTitle.setIcon(mainTitle4);
					}
				}

				// 마우스가 화면 벗어날떄 커서 원상 복귀
				@Override
				public void mouseExited(MouseEvent e) {
					button.setCursor(Cursor.getDefaultCursor());
				}
			});
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// 각 버튼 누르면 해당 페이지 뜨도록 하기

		if (e.getSource() == M_Movie) { // 영화 선택
			new Movie();
		} else if (e.getSource() == b_tabmoive) { // 영화 선택
			new Movie();
		} else if (e.getSource() == M_Food) { // 음식 선택
			dispose();
			new Snack();
		} else if (e.getSource() == b_tabFood) { // 음식 선택
			dispose();
			new Snack();
		} else if (e.getSource() == M_Check) { // 예매 확인
			new Reservaion_Con();
			setVisible(false);
		} else if (e.getSource() == b_mywgv) { // 예매 확인
			new Reservaion_Con();
			setVisible(false);
		} else if (e.getSource() == M_Rsvt) { // 영화 예매
			new ReservationFrame();
			setVisible(false);

		} else if (e.getSource() == b_tabmoiveRe) { // 영화 예매
			new ReservationFrame();
			setVisible(false);

		} else if (e.getSource() == b_login) { // 로그인 창
			new idFrame();
			loginchange();											// changebutton 함수로 바꿈
		} else if (e.getSource() == b_join) { // 회원가입창
			new SignUpFrame();
		} else if (e.getSource() == b_WGV) {
//	          System.out.println("F5 키가 눌렸습니다.");
			restartApplication();
		} else if (e.getSource() == b_loginout) {
			logoutchange();
		}

	}

	private void loginchange() {
	    p_login.remove(b_login);
	    p_login.remove(b_join);
	    p_login.remove(b_custom);
	    p_login.remove(b_mywgv);
	    p_login.add(l_blink);
	    p_login.add(b_loginout);
	    p_login.add(b_mywgv);
	    p_login.add(b_custom);
	    revalidate(); // 컨테이너를 재구성하여 변경 사항을 적용
	    repaint(); // 변경 사항을 다시 그려줌
	}
	private void logoutchange() {
	    p_login.remove(l_blink);
	    p_login.remove(b_loginout);
	    p_login.remove(b_custom);
	    p_login.remove(b_mywgv);
	    p_login.add(b_login);
	    p_login.add(b_join);
	    p_login.add(b_mywgv);
	    p_login.add(b_custom);
	    revalidate(); // 컨테이너를 재구성하여 변경 사항을 적용
	    repaint(); // 변경 사항을 다시 그려줌
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_F5) {
//	          System.out.println("F5 키가 눌렸습니다.");
			restartApplication();
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {

	}

	private void restartApplication() {
		dispose(); // 기존 창 닫기
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				new MainPageFrame().setVisible(true); // 새로운 창 열기
			}
		});
	}

}