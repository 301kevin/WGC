package login;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class DeleteFrame extends JFrame implements ActionListener {
	ImageIcon imageIcon = new ImageIcon("img/wgv.gif");

	JTextField usernameField;
	JButton deletebutton;
	JButton cencel;

	idDAO dao = new idDAO();

	public DeleteFrame() {
		setTitle("회원탈퇴");
		setSize(300, 150);
		setLocationRelativeTo(null); // 화면 중앙에 창 표시
		init();
		start();
		setIconImage(imageIcon.getImage());
	}

	private void init() {
		JPanel panel = new JPanel(new GridLayout(2, 1));
		// 입력
		JLabel usernameLabel = new JLabel("등록한 아이디:");
		panel.add(usernameLabel);
		usernameField = new JTextField();
		panel.add(usernameField);
		
		// 버튼
		deletebutton = new JButton("회원 탈퇴");
		panel.add(deletebutton);
		cencel = new JButton("취소");
		panel.add(cencel);
		add(panel);
		setVisible(true);

	}

	private void start() {
//		setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		deletebutton.addActionListener(this);
		cencel.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == deletebutton) {
			// 클릭 시 택스트입력칸의 내용을 받아옴
			String username = usernameField.getText();
			// 아이디 입력창이 비었을때 입력하라고 창 뜨고 돌려보냄
			if (username.isEmpty()) {
				JOptionPane.showMessageDialog(this, "아이디를 입력하세요.");
				return;
			}
			
			// 입력받은 택스트의 내용이 있으면 지움
			if (dao.findname(username) == true) {
				JOptionPane.showMessageDialog(this, "회원이 탈퇴되었습니다.");
				dao.deleteArticle(username);
				dispose(); // 로그인 창 닫기
			} else {
				JOptionPane.showMessageDialog(this, "아이디를 확인하세요.");
				return;
			}
			
		} else if(e.getSource() == cencel) {
			dispose();
		}
	}

}
