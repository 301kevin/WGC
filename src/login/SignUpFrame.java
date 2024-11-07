package login;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class SignUpFrame extends JFrame implements ActionListener {
	idDAO dao = new idDAO();

	JTextField usernameField = new JTextField(15);
	JPasswordField passwordField = new JPasswordField(23);
	JTextField nameField = new JTextField(23);
	JTextField residentNumberField = new JTextField(23);
	JTextField emailField = new JTextField(23);
	JButton idCheckButton = new JButton("중복 확인");
	JTextField confirmPasswordField = new JPasswordField(23);

	JLabel usernameLabel = new JLabel("아이디 : ");
	JLabel passwordLabel = new JLabel("비밀번호 : ");
	JLabel passwordCheakLable = new JLabel("비밀번호 확인 : ");
	JLabel nameLabel = new JLabel("이름 : ");
	JLabel residentNumberLabel = new JLabel("주민번호:");
	JLabel emailLabel = new JLabel("이메일 : ");
	JButton signUpButton = new JButton("회원가입");
	JButton cencel = new JButton("취소");

	Container container = getContentPane();
	JPanel panel_id = new JPanel();
	JPanel panel_pw = new JPanel();
	JPanel panel_pwch = new JPanel();
	JPanel panel_name = new JPanel();
	JPanel panel_jumin = new JPanel();
	JPanel panel_email = new JPanel();
	JPanel panel_button = new JPanel();

	public SignUpFrame() {
		setTitle("회원가입");
		setSize(400, 300);
		init();
		start();
		setLocationRelativeTo(null);
		setVisible(true);
		setResizable(false);
	}

	private void init() {
		container.setLayout(new GridLayout(7,1));
		container.add(panel_id);
		container.add(panel_pw);
		container.add(panel_pwch);
		container.add(panel_name);
		container.add(panel_jumin);
		container.add(panel_email);
		container.add(panel_button);

		panel_id.setLayout(new FlowLayout(FlowLayout.LEFT));
		usernameLabel.setPreferredSize(new Dimension(100, 30)); // 폭 100, 높이 30으로 설정
		panel_id.add(usernameLabel);
		panel_id.add(usernameField);
		panel_id.add(idCheckButton);

		panel_pw.setLayout(new FlowLayout(FlowLayout.LEFT));
		panel_pw.add(passwordLabel);
		panel_pw.add(passwordField);
		passwordLabel.setPreferredSize(new Dimension(100, 30)); // 폭 100, 높이 30으로 설정

		panel_pwch.setLayout(new FlowLayout(FlowLayout.LEFT));
		panel_pwch.add(passwordCheakLable);
		panel_pwch.add(confirmPasswordField);
		passwordCheakLable.setPreferredSize(new Dimension(100, 30)); // 폭 100, 높이 30으로 설정

		panel_name.setLayout(new FlowLayout(FlowLayout.LEFT));
		panel_name.add(nameLabel);
		panel_name.add(nameField);
		nameLabel.setPreferredSize(new Dimension(100, 30)); // 폭 100, 높이 30으로 설정
		

		panel_jumin.setLayout(new FlowLayout(FlowLayout.LEFT));
		panel_jumin.add(residentNumberLabel);
		panel_jumin.add(residentNumberField);
		residentNumberLabel.setPreferredSize(new Dimension(100, 30)); // 폭 100, 높이 30으로 설정

		panel_email.setLayout(new FlowLayout(FlowLayout.LEFT));
		panel_email.add(emailLabel);
		panel_email.add(emailField);
		emailLabel.setPreferredSize(new Dimension(100, 30)); // 폭 100, 높이 30으로 설정

		panel_button.setLayout(new FlowLayout(FlowLayout.CENTER));
		panel_button.add(signUpButton);
		panel_button.add(cencel);

	}

	private void start() {
		signUpButton.addActionListener(this);
		cencel.addActionListener(this);
		idCheckButton.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == signUpButton) {
			String username = usernameField.getText();
			String password = new String(passwordField.getPassword());
			String confirmPassword = new String(((JPasswordField) confirmPasswordField).getPassword());
			String name = nameField.getText();
			String residentNumber = residentNumberField.getText();
			String email = emailField.getText();

			// 모든 필드가 비어있는지 확인
			if (username.isEmpty() || password.isEmpty() || confirmPassword.isEmpty() || name.isEmpty()
					|| residentNumber.isEmpty() || email.isEmpty()) {
				JOptionPane.showMessageDialog(SignUpFrame.this, "모든 정보를 입력하세요.");
				return;
			}

			// 비밀번호와 비밀번호 확인이 일치하는지 확인
			if (!password.equals(confirmPassword)) {
				JOptionPane.showMessageDialog(SignUpFrame.this, "비밀번호와 비밀번호 확인이 일치하지 않습니다.");
				return;
			}

			idDTO dto = new idDTO();
			dto.setId(username);
			dto.setPassword(password);
			dto.setName(name);
			dto.setJumin(residentNumber);
			dto.setEmail(email);

			String result = idcheak(dto);
			JOptionPane.showMessageDialog(this, result);

			usernameField.setText("");
//			dispose(); // 회원가입 창 닫기
		} else if (e.getSource() == cencel) {
			dispose();
		} else if (e.getSource() == idCheckButton) {
			// 중복 체크 버튼이 클릭되었을 때의 동작
			String username = usernameField.getText();
			if (username.isEmpty()) {
				JOptionPane.showMessageDialog(SignUpFrame.this, "아이디를 입력하세요.");
				return;
			}
			idDTO dto = new idDTO();
			dto.setId(username);
			String result = idCheck(dto);
			JOptionPane.showMessageDialog(this, result);
		}

	}

	public String idcheak(idDTO dto) {
		List<idDTO> list = dao.selectAll();
		for (int i = 0; i < list.size(); i++) {
			idDTO idDTO = list.get(i);
			if (idDTO.getId().equals(dto.getId())) {
				return dto.getId() + " 아이디가 이미 존재하고 있습니다.";
			}
		}
		int result = dao.newMember(dto);
		dispose();
		if (result > 0)
			return dto.getName() + "님의 가입을 환영합니다.";
		else
			return "저장 실패";
	}

	public String idCheck(idDTO dto) {
		List<idDTO> list = dao.selectAll();
		for (int i = 0; i < list.size(); i++) {
			idDTO idDTO = list.get(i);
			if (idDTO.getId().equals(dto.getId())) {
				return dto.getId() + " 아이디가 이미 존재합니다.";
			}
		}
		return dto.getId() + " 아이디는 사용할 수 있습니다.";
	}

}
