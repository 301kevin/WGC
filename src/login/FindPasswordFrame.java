package login;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.*;

public class FindPasswordFrame extends JFrame implements ActionListener {
	JTextField usernameField;
	JButton findPW;
	JButton cencel;

	ImageIcon imageIcon = new ImageIcon("img/wgv.gif");

	public FindPasswordFrame() {
		setTitle("비밀번호 찾기");
		setSize(300, 150);
		setLocationRelativeTo(null); // 화면 중앙에 창 표시
		init();
		start();
		setIconImage(imageIcon.getImage());
	}

	private void init() {
		JPanel panel = new JPanel(new GridLayout(2, 1));

		JLabel usernameLabel = new JLabel("등록한 아이디:");
		panel.add(usernameLabel);
		usernameField = new JTextField();
		panel.add(usernameField);

		findPW = new JButton("비밀번호 찾기");
		panel.add(findPW);
		cencel = new JButton("취소");

		panel.add(cencel);
	

		add(panel);
		setVisible(true);

	}

	private void start() {
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		findPW.addActionListener(this);
		cencel.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == findPW) {
			idDAO dao = new idDAO();
			String username = usernameField.getText();

			List<idDTO> list = null;
			String name = usernameField.getText();
			list = dao.findPW(username);
			// 입력 검사
			if (username.equals("")) {
				JOptionPane.showMessageDialog(this, "아이디를 입력하세요.");
				return;
			}
			String result = "";
			if (list.size() > 0) {
				for (int i = 0; i < list.size(); i++) {
					idDTO dto = list.get(i);
					result += dto.getPassword();
				}
				JOptionPane.showMessageDialog(this, result);
				dispose();
			} else {
				JOptionPane.showMessageDialog(this, "아이디를 확인하세요 .");
				return;
			}

//			dispose(); // 계정 찾기 창 닫기
		}else if(e.getSource() == cencel) {
			dispose();
		}
	}
}
