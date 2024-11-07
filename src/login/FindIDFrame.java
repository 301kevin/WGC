package login;

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
import javax.swing.JTextField;

public class FindIDFrame extends JFrame implements ActionListener {
	JTextField nameField;
	JTextField juminField;
	JButton seeIDButton;
	JButton cencel;

	ImageIcon imageIcon = new ImageIcon("img/wgv.gif");

	public FindIDFrame() {
		setTitle("아이디 찾기");
		setSize(300, 150);

		setLocationRelativeTo(null); // 화면 중앙에 창 표시
		init();
		start();
		setIconImage(imageIcon.getImage());
	}

	private void init() {
		JPanel panel = new JPanel(new GridLayout(3, 1));

		JLabel nameLabel = new JLabel("성함 : ");
		panel.add(nameLabel);
		nameField = new JTextField();
		panel.add(nameField);

		JLabel juminLabel = new JLabel("주민번호를 (-) 없이 입력 : ");
		panel.add(juminLabel);
		juminField = new JTextField();
		panel.add(juminField);

		seeIDButton = new JButton("아이디 찾기");
		cencel = new JButton("취소");

		panel.add(seeIDButton);
		panel.add(cencel);

		add(panel);
		setVisible(true);

	}

	private void start() {
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		seeIDButton.addActionListener(this);
		cencel.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == seeIDButton) {
			idDAO dao = new idDAO();
			String name = nameField.getText();
			String jumin = juminField.getText();

			List<idDTO> list = null;
			list = dao.findID(name, jumin);
			// 아이디가 비어있는지 확인
			if (name.isEmpty()) {
				JOptionPane.showMessageDialog(FindIDFrame.this, "성함을 입력하세요.");
				return;
			}
			// 주민번호가 비어있는지 확인
			if (jumin.isEmpty()) {
				JOptionPane.showMessageDialog(FindIDFrame.this, "주민번호를 입력하세요.");
				return;
			}

			String result = "";
			if (list.size() > 0) {
				for (int i = 0; i < list.size(); i++) {
					idDTO dto = list.get(i);
					result += dto.getId();
				}
				JOptionPane.showMessageDialog(this, result);
			}

			dispose(); // 계정 찾기 창 닫기
//		new idFrame(); // 로그인창으로 돌아가기
		} else if(e.getSource() == cencel) {
			dispose();
		}
	}

}
