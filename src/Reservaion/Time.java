package Reservaion;

import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.spi.DirStateFactory.Result;
import javax.swing.DefaultListModel;
import javax.swing.JButton;

public class Time {

	public static JButton[] createButtons(String[] times) {
		Color color_black = new Color(30, 30, 30);
		Color color_beige = new Color(242, 240, 229);

		JButton[] buttons = new JButton[times.length];
		for (int i = 0; i < times.length; i++) {
			JButton button = new JButton(times[i]);
			button.setForeground(color_black);
			button.setBackground(color_beige);
			
			buttons[i] = button;
		}
		return buttons;
	}
}