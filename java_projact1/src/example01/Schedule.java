package example01;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;

public class Schedule extends JFrame {
	private JPanel contentPane;

	public Schedule(int year, int month, int day) {
		setTitle("\uC77C\uC815 \uAE30\uB85D");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 725, 505);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\uBAA9\uD45C\uBA85");
		lblNewLabel.setBounds(44, 79, 57, 15);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\uC2DC\uC791\uC77C\uC2DC");
		lblNewLabel_1.setBounds(155, 79, 57, 15);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\uC218\uD589\uBAA9\uD45C");
		lblNewLabel_2.setBounds(376, 79, 57, 15);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("\uC218\uD589\uBAA9\uD45C\uB2EC\uC131");
		lblNewLabel_3.setBounds(475, 79, 88, 15);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("\uC885\uB8CC\uC77C\uC2DC");
		lblNewLabel_4.setBounds(262, 79, 57, 15);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("\uC218\uD589 \uC5EC\uBD80");
		lblNewLabel_5.setBounds(603, 79, 57, 15);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("" + year+"년 "+ month+"월 "+day+"일");
		lblNewLabel_6.setBounds(12, 10, 218, 59);
		contentPane.add(lblNewLabel_6);
		
		JButton btnNewButton = new JButton("\uC77C\uC815 \uC218\uC815");
		btnNewButton.setBounds(324, 433, 97, 23);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Update_Schedule frame = new Update_Schedule(year, month,day);
				frame.setVisible(true);
			}
		});
		contentPane.add(btnNewButton);
		JButton btnNewButton_2 = new JButton("<");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();//해당 ui만 창내림
			}
		});
		btnNewButton_2.setBounds(568, 10, 57, 23);
		contentPane.add(btnNewButton_2);

	}

	
}
