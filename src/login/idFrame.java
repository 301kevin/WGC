package login;

import java.awt.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class idFrame extends JFrame implements ActionListener {

	Container container = getContentPane();

	JTextField usernameField = new JTextField(20);
	JPasswordField passwordField = new JPasswordField(20);

	JButton loginButton = new JButton("로그인");
	JButton findIDButton = new JButton("아이디 찾기");
	JButton findPasswordButton = new JButton("비밀번호 찾기");
	JButton signUpButton = new JButton("회원가입");
	JButton deleteButton = new JButton("회원탈퇴");

	JPanel panel = new JPanel();
	JPanel labelPanel = new JPanel();
	JPanel textPanel = new JPanel();
	JPanel inputPanel = new JPanel();
	JPanel buttonPanel = new JPanel();
	JPanel AllbuttonPanel = new JPanel();

	JLabel usernameLabel = new JLabel("ID              ");
	JLabel passwordLabel = new JLabel("PASSWORD");

	JPanel loginPanel = new JPanel(new BorderLayout()); // 로그인 버튼 패널 생성

//	Font font18 = new Font("맑은 고딕",Font.BOLD,18);

	ImageIcon imageIcon = new ImageIcon("img/wgv.gif");

	idDAO dao = new idDAO();

	public idFrame() {
		setTitle("로그인");
		setSize(500, 400);
		init();
		start();
		setLocationRelativeTo(null);
		setIconImage(imageIcon.getImage());
		setVisible(true);
	}

	private void init() {
		container.setLayout(new BorderLayout());
//		buttonPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // 보더 설정
//		loginPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // 보더 설정
		container.setBackground(Color.darkGray);

		container.add("North", panel);
		container.add("Center", inputPanel);
		container.add("South", AllbuttonPanel);
		panel.setBackground(Color.pink);
		inputPanel.setBackground(Color.gray);
		AllbuttonPanel.setBackground(Color.gray);
		labelPanel.setBackground(Color.gray);
		textPanel.setBackground(Color.gray);

		JLabel titleLabel = new JLabel("환영합니다!", JLabel.CENTER);
		titleLabel.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		panel.add(titleLabel, BorderLayout.NORTH);

		loginButton = new JButton("로그인");
		loginButton.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		loginButton.setPreferredSize(new Dimension(200, 40));
		loginButton.setBackground(Color.RED);
		loginButton.setForeground(Color.WHITE);
		loginButton.setFocusPainted(false);
		loginPanel.add(loginButton, BorderLayout.SOUTH); // 로그인 버튼을 로그인 버튼 패널의 남쪽에 추가

		usernameField.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.GRAY),
				BorderFactory.createEmptyBorder(5, 10, 5, 10)));
		usernameField.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		usernameField.setPreferredSize(new Dimension(200, 40));

		passwordField.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.GRAY),
				BorderFactory.createEmptyBorder(5, 10, 5, 10)));
		passwordField.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		passwordField.setPreferredSize(new Dimension(200, 40));

		inputPanel.setLayout(new GridLayout(5, 0));
		inputPanel.add(labelPanel);
		inputPanel.add(textPanel);

		labelPanel.add("West", usernameLabel);
		textPanel.add("West", passwordLabel);

		labelPanel.add("East", usernameField);
		textPanel.add("East", passwordField);

		AllbuttonPanel.setLayout(new BorderLayout());
		AllbuttonPanel.add("Center", buttonPanel);
		AllbuttonPanel.add("North", loginPanel);

		buttonPanel.setLayout(new GridLayout(1, 4, 5, 5));
//		buttonPanel.add(loginButton);
		buttonPanel.add(findIDButton);
		buttonPanel.add(findPasswordButton);
		buttonPanel.add(signUpButton);
		buttonPanel.add(deleteButton);

		usernameLabel.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		passwordLabel.setFont(new Font("맑은 고딕", Font.BOLD, 18));

//      contentPane.add(containerPanel); // contentPane에 containerPanel 추가
//		contentPane.add(loginPanel, BorderLayout.NORTH); // 로그인 버튼 패널을 contentPane의 북쪽에 추가
//		contentPane.add(buttonPanel, BorderLayout.CENTER); // 나머지 버튼 패널을 contentPane의 가운데에 추가

	}

	private void start() {
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		signUpButton.addActionListener(this);
		loginButton.addActionListener(this);
		findIDButton.addActionListener(this);
		findPasswordButton.addActionListener(this);
		deleteButton.addActionListener(this);
		usernameField.addActionListener(this);
		passwordField.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == signUpButton) {
//			dispose(); // 로그인 창 닫기
			new SignUpFrame(); // 회원가입 창 열기
		} else if (e.getSource() == loginButton || e.getSource() == usernameField || e.getSource() == passwordField) { // 로그인
			String username = usernameField.getText();
			String password = new String(passwordField.getPassword());
			
			if (username.isEmpty()) {
				JOptionPane.showMessageDialog(this, "아이디를 입력하세요.");
				return;
			} else if (password.isEmpty()) {
				JOptionPane.showMessageDialog(this, "비밀번호를 입력하세요.");
				return;
			}
			
			boolean result = dao.login(username, password);
			if (result == true) {
				JOptionPane.showMessageDialog(this, "로그인 되었습니다.");
				dispose(); // 로그인 창 닫기
			} else {
				JOptionPane.showMessageDialog(this, "아이디 또는 비밀번호를 확인하세요.");
				usernameField.setText("");
				passwordField.setText("");
			}

//			new mainFrame// 로그인 후 메인
		} else if (e.getSource() == findIDButton) {
//			dispose(); // 로그인 창 닫기
			new FindIDFrame(); // 아이디 찾는 창 열기
		} else if (e.getSource() == findPasswordButton) {
//			dispose(); // 로그인 창 닫기
			new FindPasswordFrame(); // 비밀번호 찾는 창 열기
		} else if (e.getSource() == deleteButton) {
//			dispose(); // 로그인 창 닫기
			new DeleteFrame(); // 비밀번호 찾는 창 열기
		}

	}

}
