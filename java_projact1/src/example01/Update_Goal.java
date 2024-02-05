package example01;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JTextArea;

public class Update_Goal extends JFrame {

	private JPanel contentPane;
	public Update_Goal() {
		List<Goal_DTO> goals = new ArrayList<Goal_DTO>();
		DAO dao = new DAO();
		setTitle("\uBAA9\uD45C \uC218\uC815");
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
		lblNewLabel_2.setBounds(266, 123, 95, 15);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("\uB2E8\uC704");
		lblNewLabel_3.setBounds(389, 123, 57, 15);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("\uC124\uBA85");
		lblNewLabel_4.setBounds(458, 123, 36, 15);
		contentPane.add(lblNewLabel_4);
		
		JButton btnNewButton = new JButton("\uBAA9\uD45C \uC218\uC815 \uC644\uB8CC");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				List<Goal_DTO> goals = new ArrayList<Goal_DTO>();
				DAO dao = new DAO();
				goals = dao.Insert_Goal();
				for(int i=1; i<= goals.size();i++) {
					Goal_DTO goal = goals.get(i-1);
					JTextArea textArea2 = (JTextArea) contentPane.getComponentAt(147, 123+(i*50)); // 최소값
					JTextArea textArea3 = (JTextArea) contentPane.getComponentAt(266, 123+(i*50)); // 최대값
					JTextArea textArea4 = (JTextArea) contentPane.getComponentAt(379, 123+(i*50)); // 유닛값
					JTextArea textArea5 = (JTextArea) contentPane.getComponentAt(458, 123+(i*50)); // 정보값
					int Low_Val = Integer.parseInt(textArea2.getText());
					int High_Val = Integer.parseInt(textArea3.getText());
					String unit = textArea4.getText();
					String INfo = textArea5.getText();
					if(goal.Low_val != Low_Val) {
						dao.Change_Goal(goal, Low_Val, High_Val, unit, INfo);
						break;
					}
					else if(goal.High_val != High_Val) {
						dao.Change_Goal(goal, Low_Val, High_Val, unit, INfo);
						break;
					}
					else if(!goal.Unit.equals(unit)) {
						dao.Change_Goal(goal, Low_Val, High_Val, unit, INfo);
						break;
					}
					else if(!goal.Information.equals(INfo)) {
						dao.Change_Goal(goal, Low_Val, High_Val, unit, INfo);
						break;
					}
				}
				JOptionPane.showMessageDialog(null,"목표 수정 완료!");
				dispose();
				Goal_gui frame = new Goal_gui();
				frame.setVisible(true);
			}
		});	
		btnNewButton.setBounds(250, 495, 137, 23);
		contentPane.add(btnNewButton);
	
		goals = dao.Insert_Goal();
		for(int i=1; i<= goals.size();i++) {
			Goal_DTO goal = goals.get(i-1);
			JLabel textArea1 = new JLabel(goal.Objective);
			textArea1.setBounds(25, 123+(i*50), 120, 15);
			contentPane.add(textArea1);
			JTextArea textArea2 = new JTextArea(""+goal.Low_val+"");
			textArea2.setBounds(147, 123+(i*50), 60, 23);
			contentPane.add(textArea2);
			JTextArea textArea3 = new JTextArea(""+goal.High_val+"");
			textArea3.setBounds(266, 123+(i*50), 60, 23);
			contentPane.add(textArea3);
			JTextArea textArea4 = new JTextArea(goal.Unit);
			textArea4.setBounds(379, 123+(i*50), 60, 23);
			contentPane.add(textArea4);
			JTextArea textArea5 = new JTextArea(goal.Information);
			textArea5.setBounds(458, 123+(i*50), 86, 23);
			contentPane.add(textArea5);
		}
	}
}
