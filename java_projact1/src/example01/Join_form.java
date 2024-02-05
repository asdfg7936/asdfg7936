package example01;

import java.awt.EventQueue;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Join_form extends JFrame {

	private JPanel contentPane;
	private JLabel titleLabel;
    private JLabel idLabel;
    private JLabel passwordLabel;
    private JLabel nameLabel;
    private JLabel nicknameLabel;
    private JLabel genderLabel;
    private JTextField idField;
    private JPasswordField passwordField;
    private JTextField nameField;
    private JTextField nicknameField;
    private JRadioButton maleRadioButton;
    private JRadioButton femaleRadioButton;
    private JButton joinButton;
    private JButton duplicateButton;
    private boolean isIdDuplicated = false;
    private Login.LoginListener loginListener;
	public Join_form() {
		
		setTitle("ȸ������");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        setSize(600, 600);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        titleLabel = new JLabel("ȸ������", JLabel.CENTER);
        titleLabel.setFont(new Font("���ʷҵ���", Font.BOLD, 40));
        panel.add(titleLabel, BorderLayout.NORTH);

        JPanel formPanel = new JPanel();
        formPanel.setLayout(null);
        panel.add(formPanel, BorderLayout.CENTER);

        idLabel = new JLabel("ID:", JLabel.RIGHT);
        idLabel.setBounds(170, 130, 80, 30);
        formPanel.add(idLabel);

        idField = new JTextField();
        idField.setBounds(260, 130, 150, 30);
        formPanel.add(idField);

        duplicateButton = new JButton("�ߺ� Ȯ��");
        duplicateButton.setBounds(420, 130, 90, 30);
        formPanel.add(duplicateButton);

        duplicateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DAO dao = new DAO();
                if (dao != null) {
                    String id = idField.getText();
                    if (dao.checkDuplicateID(id)) {
                        JOptionPane.showMessageDialog(Join_form.this, "�̹� ��� ���� ���̵��Դϴ�.", "�ߺ�", JOptionPane.WARNING_MESSAGE);
                        isIdDuplicated = true;
                    } else {
                        JOptionPane.showMessageDialog(Join_form.this, "��� ������ ���̵��Դϴ�.", "�ߺ� ����", JOptionPane.INFORMATION_MESSAGE);
                        isIdDuplicated = false;
                    }
                }
            }
        });

        passwordLabel = new JLabel("Password:", JLabel.RIGHT);
        passwordLabel.setBounds(170, 175, 80, 30);
        formPanel.add(passwordLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(260, 175, 150, 30);
        formPanel.add(passwordField);

        nameLabel = new JLabel("�̸�:", JLabel.RIGHT);
        nameLabel.setBounds(170, 220, 80, 30);
        formPanel.add(nameLabel);

        nameField = new JTextField();
        nameField.setBounds(260, 220, 150, 30);
        formPanel.add(nameField);

        genderLabel = new JLabel("����:", JLabel.RIGHT);
        genderLabel.setBounds(170, 305, 80, 30);
        formPanel.add(genderLabel);

        maleRadioButton = new JRadioButton("����");
        maleRadioButton.setBounds(260, 305, 60, 30);
        formPanel.add(maleRadioButton);

        femaleRadioButton = new JRadioButton("����");
        femaleRadioButton.setBounds(325, 305, 60, 30);
        formPanel.add(femaleRadioButton);

        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(maleRadioButton);
        genderGroup.add(femaleRadioButton);

        joinButton = new JButton("ȸ������");
        joinButton.setBounds(250, 400, 100, 30);
        formPanel.add(joinButton);

        joinButton.addActionListener(new ActionListener() {//�г��� ���� �ʿ�
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = idField.getText();
                String password = new String(passwordField.getPassword());
                String name = nameField.getText();
                String gender = maleRadioButton.isSelected() ? "m" : "w";

                if (isIdDuplicated) {
                    JOptionPane.showMessageDialog(Join_form.this, "���̵� �ߺ� Ȯ���� ���ּ���.", "ȸ������ ����", JOptionPane.WARNING_MESSAGE);
                } else if (id.isEmpty() || password.isEmpty() || name.isEmpty() || (!maleRadioButton.isSelected() && !femaleRadioButton.isSelected())) {
                    JOptionPane.showMessageDialog(Join_form.this, "��� �׸��� �Է����ּ���.", "ȸ������ ����", JOptionPane.WARNING_MESSAGE);
                } else {
                    DAO dao= new DAO();//�� �ҷ�����
                    boolean joinSuccess = dao.register(id, password, name, gender);
                    if (joinSuccess) {
                        JOptionPane.showMessageDialog(Join_form.this, "ȸ�������� �Ϸ�Ǿ����ϴ�.", "ȸ������ ����", JOptionPane.INFORMATION_MESSAGE);
                        if (loginListener != null) {
                            loginListener.onLoginSuccess(); 
                        }
                        dispose();
                    } else {
                        JOptionPane.showMessageDialog(Join_form.this, "ȸ�����Կ� �����Ͽ����ϴ�.", "ȸ������ ����", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });

        add(panel);
	}
	 public void setLoginListener(Login.LoginListener listener) {
	        this.loginListener = listener;
	    }

}
