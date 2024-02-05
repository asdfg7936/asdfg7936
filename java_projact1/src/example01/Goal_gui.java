package example01;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

public class Goal_gui extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public Goal_gui() {
		List<Goal_DTO> goals = new ArrayList<Goal_DTO>();
		DAO dao = new DAO();
//		String objectValue = "목표명 예시";
		// db값을 가져와야함 DAO에 추가해야할듯
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 653, 567);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\uBAA9\uD45C\uBA85");
		lblNewLabel.setBounds(45, 123, 57, 15);
		contentPane.add(lblNewLabel);
		
		
		JLabel lblNewLabel_1 = new JLabel("\uBAA9\uD45C \uC218\uCE58(\uCD5C\uC18C)");
		lblNewLabel_1.setBounds(137, 123, 101, 15);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\uBAA9\uD45C \uC218\uCE58(\uCD5C\uB300)");
		lblNewLabel_2.setBounds(266, 123, 86, 15);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("\uB2E8\uC704");
		lblNewLabel_3.setBounds(389, 123, 57, 15);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("\uC124\uBA85");
		lblNewLabel_4.setBounds(458, 123, 36, 15);
		contentPane.add(lblNewLabel_4);
		
		JButton btnNewButton = new JButton("\uBAA9\uD45C\uC218\uC815");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Update_Goal frame = new Update_Goal();
				frame.setVisible(true);
			}
		});
		
		btnNewButton.setBounds(365, 495, 97, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\uBAA9\uD45C \uCD94\uAC00");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		btnNewButton_1.setBounds(205, 495, 97, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("<");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();//해당 ui만 창내림
			}
		});
		btnNewButton_2.setBounds(568, 10, 57, 23);
		contentPane.add(btnNewButton_2);
//		for(int i=1;i<= 3; i++){
//		 JLabel lblNewLabel1 = new JLabel("db목표명");// 목표명 db 사용 그외의 db도 이런 방식으로 사용
//		 lblNewLabel1.setBounds(45, 123+(i*40), 55, 15);
//		 contentPane.add(lblNewLabel1);
//		 }// > 성공적 양산화 필요 DAO필요
		goals = dao.Insert_Goal();
		for(int i=1; i<= goals.size();i++) {
			Goal_DTO goal = goals.get(i-1);
			JLabel lblNewLabel1 = new JLabel(goal.Objective);
			lblNewLabel1.setBounds(45, 123+(i*50), 120, 15);
			contentPane.add(lblNewLabel1);
			JLabel lblNewLabel2 = new JLabel(""+goal.Low_val+"");
			lblNewLabel2.setBounds(147, 123+(i*50), 120, 15);
			contentPane.add(lblNewLabel2);
			JLabel lblNewLabel3 = new JLabel(""+goal.High_val+"");
			lblNewLabel3.setBounds(266, 123+(i*50), 120, 15);
			contentPane.add(lblNewLabel3);
			JLabel lblNewLabel4 = new JLabel(goal.Unit);
			lblNewLabel4.setBounds(389, 123+(i*50), 120, 15);
			contentPane.add(lblNewLabel4);
			JLabel lblNewLabel5 = new JLabel(goal.Information);
			lblNewLabel5.setBounds(458, 123+(i*50), 120, 15);
			contentPane.add(lblNewLabel5);
		}
		
	}

	private String String(int low_val) {
		// TODO Auto-generated method stub
		return null;
	}
}
