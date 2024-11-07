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

public class ReservationFrame extends JFrame implements ActionListener {
	ReservationDAO dao = new ReservationDAO();

	// seat 정보 저장 변수
	String imageSeat;
	String mvnameSeat;
	String calSeat;
	String timeSeat;
	String roomSeat;
	int countSeat;
	String idSeat;



	// 패널 바꾸기
	CardLayout cardLayout = new CardLayout();

	Color color_black = new Color(30, 30, 30);
	Color color_white = new Color(204, 204, 204);
	Color color_beige = new Color(242, 240, 229);
	Color color_boldbeige = new Color(232, 230, 219);

	// 폰트 저장
	Font font10 = new Font("맑은 고딕", Font.BOLD, 10);
	Font font18 = new Font("맑은 고딕", Font.BOLD, 18);
	Font font25 = new Font("맑은 고딕", Font.BOLD, 25);

	Container con = getContentPane();
	
	// --------------1. 전체 틀----------------//
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

	// --------------2. 서쪽----------------//
	ImageIcon WE_adr = new ImageIcon("image/adv1.png");
	JLabel l_W_adr = new JLabel(WE_adr);

	// --------------3. 동쪽----------------//
	JLabel l_E_adr = new JLabel(WE_adr);

	// --------------4. 센터 ----------------//
	// 4-1. 영화 선택 창
	JPanel p_movietot = new JPanel();
	JLabel l_moive = new JLabel("영화", JLabel.CENTER);

	/** 추후 영화 리스트 공유 받아서 DataBase에서 리스트 뽑아오기 */
	JList<String> list_movie = new JList<>(dao.popdesc());
	JScrollPane scr_movie = new JScrollPane(list_movie);

	// 4-2. 날짜 글 + 년월 / 일 요일 묶음
	JPanel p_calander = new JPanel();
	JLabel l_calander = new JLabel("날짜", JLabel.CENTER); // 1-2-1. 날짜

	JPanel p_day = new JPanel(); // 1-2-2. 년월 / 일 요일 묶음

	JPanel p_ym = new JPanel(); // 1-2-3. 년월 묶음
	JLabel l_year = new JLabel("2024", JLabel.CENTER);
	JLabel l_mon = new JLabel("4", JLabel.CENTER);

	HCalendar hc = new HCalendar();
	JList<String> list_day = new JList<String>(hc.displayDatesAndDays());
	JScrollPane scr_day = new JScrollPane(list_day);

	// 4-3. 시간
	TimeDAO timedao = new TimeDAO();

	JLabel l_time = new JLabel("시간", JLabel.CENTER);

	JPanel p_time_total = new JPanel();
	JPanel p_timetot = new JPanel();

	// 시간- 버튼 누르기 전
    boolean timeButtonClicked = false;
	
	// 4-3-1. 1관
	JPanel p_time1 = new JPanel();

	List<String> room = timedao.distroom();

	JLabel l_1관 = new JLabel(room.get(0));
	JPanel p_room1 = new JPanel();

	String[] str1 = timedao.timeasc(1);
	JButton[] b_1관 = Time.createButtons(str1);

	// 4-3-2. 2관
	JPanel p_time2 = new JPanel();

	JLabel l_2관 = new JLabel(room.get(1));
	JPanel p_room2 = new JPanel();

	String[] str2 = timedao.timeasc(2);
	JButton[] b_2관 = Time.createButtons(str2);

	// 4-3-3. 3관
	JPanel p_time3 = new JPanel();

	JLabel l_3관 = new JLabel(room.get(2));
	JPanel p_room3 = new JPanel();

	String[] str3 = timedao.timeasc(3);
	JButton[] b_3관 = Time.createButtons(str3);

	// --------------5. 남쪽----------------//
	// 
	
	JLabel S_blink1 = new JLabel(); // -> 빈칸
	JLabel S_blink2 = new JLabel(); // -> 빈칸

	//5-1 왼쪽
	JPanel p_infor_label = new JPanel();

	// 5-1-1. 영화 이미지
	String image_moive = "image/0.png";
	ImageIcon ima_movie = new ImageIcon(image_moive);
	JLabel l_pic = new JLabel(ima_movie);

	// 5-1-2. 영화 제목
	JPanel p_movieName = new JPanel();
	JTextArea area = new JTextArea(); // 영화 제목

	// 5-1-2. 영화 일시 ,상영관 , 인원
	JPanel p_movieInfo = new JPanel();

	JLabel l_날짜 = new JLabel("날짜 ");
	JLabel l_시간 = new JLabel("시간 ");
	JLabel l_상영관 = new JLabel("상영관 ");

	JPanel p_seatInfo = new JPanel(); // 영화 좌석 번호
	JLabel l_인원 = new JLabel("인원 ");
	JLabel l_좌석 = new JLabel("좌석 ");

	// 5-3 오른쪽
	// 이미지 아이콘 생성
	ImageIcon ima_next = new ImageIcon("image/좌석선택.png");
	ImageIcon ima_nextend = new ImageIcon("image/좌석선택완.png");

	// 버튼 생성 및 이미지 아이콘 설정
	JPanel p_select = new JPanel(); // -> 버튼 이미지 2개 저장해두기
	JLabel l_infor_select = new JLabel(ima_next);
	JButton b_infor_selectend = new JButton(ima_nextend);

	public ReservationFrame() {
		setSize(1500, 1000);
		setTitle("WGV 예매");
		setLocation(250, 30);

		init();
		start();
		setVisible(true);
	}

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
		p_NWGV.add(l_Nblink); // 빈칸
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
		
		
		// --------------가운데----------------//
		// 4. 가운데
		p_center.setLayout(new GridLayout(1, 3, 3, 3));

		p_center.add(p_movietot);
		p_center.add(p_calander);

		p_center.add(p_time_total);

		// 4-1. 영화 목록
		p_movietot.setBackground(color_black);

		p_movietot.setLayout(new BorderLayout());
		p_movietot.add("North", l_moive).setForeground(color_white);
		p_movietot.add("Center", scr_movie);
		scr_movie.setPreferredSize(new Dimension(300, 500));

		// 4-1-1. 영화 목록 위
		l_moive.setFont(font25);

		// 4-1-2. 목록의 셀 렌더러 설정
		list_movie.setCellRenderer(new CustomCellRenderer());

		// 4-2. 날짜
		p_calander.setBackground(color_black);

		p_calander.setLayout(new BorderLayout());
		p_calander.add("North", l_calander).setForeground(color_white);
		p_calander.add("Center", p_day);

		l_calander.setFont(font25);

		// 4-2-1. 년월 / 일 요일 나누기
		p_day.setLayout(new BorderLayout());
		p_day.add("North", p_ym);
		p_day.add(scr_day);

		// 4-2-2. 날짜 출력 - 일 / 요일

		list_day.setCellRenderer(new CustomCellRenderer());

		// 4-2-1. 년 월 표시
		p_ym.setLayout(new GridLayout(2, 1));
		p_ym.setBackground(color_beige);

		l_year.setText(hc.getYear());
		l_mon.setText(hc.getMonth());
		p_ym.add(l_year).setForeground(color_black);
		p_ym.add(l_mon).setForeground(color_black);

		l_year.setFont(font10);
		l_mon.setFont(font18);

		// 4-3. 상영 관/ 시간
		// 4-3-1. 시간 제목
		p_time_total.setBackground(color_black);

		p_time_total.setLayout(new BorderLayout());
		p_time_total.add("North", l_time).setForeground(color_white);
		l_time.setFont(font25);
		p_time_total.add("Center", p_timetot);

		// 4-3-2. 스케줄 표 패널 p_timetot
		p_timetot.setLayout(new GridLayout(3, 1, 5, 5));
		p_timetot.setBackground(color_beige);
		p_timetot.add(p_time1);
		p_timetot.add(p_time2);
		p_timetot.add(p_time3);

		// 4-3-2-1. 1관
		p_time1.setBackground(color_boldbeige);
		p_time1.setLayout(new BorderLayout());

		p_time1.add("North", l_1관).setFont(font18);
		p_time1.add("Center", p_room1);

		// 4-3-2-1-1. 1관 버튼
		p_room1.setLayout(new GridLayout(3, 3, 3, 3)); // 시간 버튼을 담을 패널
		for (int i = 0; i < b_1관.length; i++) {
			p_room1.add(b_1관[i]);
		}
		p_room1.setBackground(color_beige);

		// 4-3-2-2. 2관
		p_time2.setBackground(color_boldbeige);
		p_time2.setLayout(new BorderLayout());

		p_time2.add("North", l_2관).setFont(font18);
		p_time2.add("Center", p_room2);

		// 4-3-2-2-1. 2관 버튼
		p_room2.setLayout(new GridLayout(3, 3, 3, 3));
		for (int i = 0; i < b_2관.length; i++) {
			p_room2.add(b_2관[i]);
		}
		p_room2.setBackground(color_beige);
		
		// 4-3-2-3. 3관
		p_time3.setBackground(color_boldbeige);
		p_time3.setLayout(new BorderLayout());
		p_time3.add("North", l_3관).setFont(font18);
		p_time3.add("Center", p_room3);
		

		
		// 4-3-2-3-1. 3관 버튼
		p_room3.setLayout(new GridLayout(3, 3, 3, 3)); // 시간 버튼을 담을 패널
		for (int i = 0; i < b_3관.length; i++) {
			p_room3.add(b_3관[i]);
		}
		p_room3.setBackground(color_beige);


		// --------------남쪽----------------//ㅇ
		
		p_south.setBackground(color_black);
		p_south.setPreferredSize(new Dimension(1500, 160));

		p_south.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 0));
		
		p_south.add(S_blink1); // 빈칸
		p_south.add(l_pic); // 영화 이미지
		p_south.add(p_movieName); // 영화 제목 라
		p_south.add(p_movieInfo); // 영화 일시,상영관
		p_south.add(p_seatInfo); // 인원,좌석번호
		p_south.add(p_select); // 예약하기 버튼
		p_south.add(S_blink2); // 빈칸


			// 2-1-2. 영화 제목 - 고정
		p_movieName.setBackground(color_black);
		
		p_movieName.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 30));
		p_movieName.add(area).setForeground(color_white);
		area.setBackground(color_black);
		area.setLineWrap(true); // 자동 줄바꿈 활성화
		area.setWrapStyleWord(true); // 단어 단위 줄바꿈
		area.setFont(font18);
		area.setPreferredSize(new Dimension(230,145));
		
		// 2-1-3. 영화 일시, 상영관
		p_movieInfo.setBackground(color_black);
		p_movieInfo.setLayout(new GridLayout(3, 1));

		p_movieInfo.add(l_날짜).setFont(font18);
		p_movieInfo.add(l_시간).setFont(font18);
		p_movieInfo.add(l_상영관).setFont(font18);
		
		l_날짜.setForeground(color_white);
		l_시간.setForeground(color_white);
		l_상영관.setForeground(color_white);
		
		// 2-1-4. 인원+좌석 선택 
		p_seatInfo.setBackground(color_black);
		p_seatInfo.setLayout(new GridLayout(3, 1, 0, 0));
		p_seatInfo.add(l_인원).setFont(font18);
		p_seatInfo.add(l_좌석).setFont(font18);
		
		l_인원.setForeground(color_white);
		l_좌석.setForeground(color_white);

		// 2-3. 좌석 선택 버튼 -
		// 보안 필요 : 영화 선택 시 -> b_infor_selectend 으로 바꿔서 활성화 시키기
		p_select.setBackground(color_black);

		p_select.setLayout(cardLayout);
		p_select.add(l_infor_select, "select");

		b_infor_selectend.setPreferredSize(new Dimension(137, 138));
		b_infor_selectend.setBackground(color_black);
		l_infor_select.setPreferredSize(new Dimension(137, 138));

		b_infor_selectend.setBorder(new EmptyBorder(0, 0, 0, 0));
		l_infor_select.setBorder(new EmptyBorder(0, 0, 0, 0));

		// * 4. 남쪽 사이즈 셋팅
		S_blink1.setPreferredSize(new Dimension(185, 165)); // 빈칸
		l_pic.setPreferredSize(new Dimension(145, 145)); // 영화 이미지
		p_movieName.setPreferredSize(new Dimension(240, 145)); // 영화 이름
		p_movieInfo.setPreferredSize(new Dimension(300, 145)); // 영화 일시,상영관,인원
		p_seatInfo.setPreferredSize(new Dimension(210, 145)); // 영화 좌석
		p_select.setPreferredSize(new Dimension(145, 145)); // 예약하기 완 버튼
		S_blink2.setPreferredSize(new Dimension(185, 165)); // 빈칸

		p_south.setBackground(color_black);
	}

	private void start() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		// next 버튼 선택시 다른 Frame 으로 변경
		b_infor_selectend.addActionListener(this);

		// 1~3관 - 시간 버튼 눌렀을 시 데이터 출력하기
		JButton[][] theaterButtons = { b_1관, b_2관, b_3관 };
		for (JButton[] theaterButton : theaterButtons) {
			for (JButton button : theaterButton) {
				button.addActionListener(this);
			}
		}
		// 리스트 클릭시 글자 출력
		list_movie.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				JList<String> list = (JList<String>) e.getSource();
				int index = list.locationToIndex(e.getPoint());
				String selectedItem = list.getModel().getElementAt(index);

				// 텍스트 에리어에 글씨출력
				area.setText(selectedItem);
				mvnameSeat = selectedItem;

				// 리스트 클릭시 => 이미지 출력
				image_moive = dao.mvimagedesc(selectedItem);
				ImageIcon icon = new ImageIcon(image_moive);
				// System.out.println(image_moive);
				imageSeat = image_moive;
				l_pic.setIcon(icon);

				// 클랙시 추가

			}
		});

		// 리스트 클릭시 글자 출력
		list_day.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				JList<String> list = (JList<String>) e.getSource();
				int index = list.locationToIndex(e.getPoint());
				String selectedItem = list.getModel().getElementAt(index);
				l_날짜.setText("날짜     " + hc.getYear() + "년 " + hc.getMonth() + "월 " + selectedItem);
				calSeat = "날짜     " + hc.getYear() + "년 " + hc.getMonth() + "월 " + selectedItem;
				// 클랙시 추가
				checkAndSwitchPanel();

			}
		});

		b_infor_selectend.addMouseListener(new MouseAdapter() {

			public void mousePressed(MouseEvent e) {
				// 마우스를 누르는 순간 버튼에 경계가 사라지고 바탕색으로 검은색으로 채워주기
				b_infor_selectend.setBackground(color_black);
				b_infor_selectend.setContentAreaFilled(false);
				// setDefaultCloseOperation(DISPOSE_ON_CLOSE);


			}
		});
		
	      // 커서 변경 -> 마우스로
	      JButton[] allButtons = { b_login, b_join, b_mywgv, b_custom, b_tabmoive, b_tabmoiveRe, b_tabFood,b_WGV,b_infor_selectend };
	      for (JButton allButton : allButtons) {
	         allButton.addActionListener(this);
	      }

	      for (JButton allButton : allButtons) {
	         // 마우스가 올라갔을 떄 커서 변경
	         allButton.addMouseListener(new MouseAdapter() {
	            final JButton button = allButton;

	            public void mouseEntered(MouseEvent e) {
	               button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
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
		for (JButton button : b_1관) {
			if (e.getSource() == button) {
				l_시간.setText("시간     " + button.getText());
				l_상영관.setText("상영관    " + room.get(0));

				timeSeat = "시간    " + button.getText();
				roomSeat = "상영관    " + room.get(0);
				timeButtonClicked = true;
				break;
			}
		}
		for (JButton button : b_2관) {
			if (e.getSource() == button) {
				l_시간.setText("시간     " + button.getText());
				l_상영관.setText("상영관    " + room.get(1));
				timeSeat = "시간    " + button.getText();
				roomSeat = "상영관    " + room.get(1);
				timeButtonClicked = true;
				break;
			}
		}
		for (JButton button : b_3관) {
			if (e.getSource() == button) {
				l_시간.setText("시간     " + button.getText());
				l_상영관.setText("상영관    " + room.get(2));

				timeSeat = "시간    " + button.getText();
				roomSeat = "상영관    " + room.get(2);
				timeButtonClicked = true;
				break;
			}
		}


		if (e.getSource() == b_infor_selectend) {
	         // 좌석 선택 부분
	         Reservation_Seat.gettexts(l_날짜.getText(), l_시간.getText(), l_상영관.getText(), area.getText(), image_moive);
	         Reservation_Seat rs = new Reservation_Seat();
	         rs.setVisible(true); // 다른 프레임을 엽니다.
	         setVisible(false);
	      }
	      // 좌석 선택하기로 버튼 활성화
	      checkAndSwitchPanel();
	}

	// 리스트 내 텍스트 색상 및 글꼴 크기 변경
	private class CustomCellRenderer extends DefaultListCellRenderer {
		@Override
		public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected,
				boolean cellHasFocus) {
			Component c = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);

			setBorder(BorderFactory.createEmptyBorder(7, 10, 7, 10));

			c.setBackground(color_beige);
			if (isSelected) {
				c.setBackground(color_black);
				c.setForeground(color_white);
			} else {
				c.setBackground(color_beige);
				c.setForeground(color_black); // 텍스트 색상 변경
			}
			// 글꼴 크기 변경
			c.setFont(font18);
			return c;
		}
	}

	// 리스트 2개 클릭 했을 시 -> 다음 버튼 활성화
	private void checkAndSwitchPanel() {
		  boolean listSelected = list_movie.getSelectedIndex() > -1 && list_day.getSelectedIndex() > -1;

		  if (listSelected && timeButtonClicked) {
		        // Both lists are selected and at least one theater button is clicked
		        cardLayout.show(p_select, "selected");
		        p_select.add(b_infor_selectend, "selected");
		        p_select.add(l_infor_select, "select");
		    }
		}
}
