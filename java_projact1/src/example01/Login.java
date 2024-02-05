package example01;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

public class Login extends JFrame {
	    private JTextField usernameField;
	    private JPasswordField passwordField;
	    private JButton loginButton;
	    private JButton joinButton;

	    private LoginListener loginListener;

	    public Login() {
	        setTitle("Login");
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        setSize(300, 200);
	        setResizable(false);
	        setLocationRelativeTo(null);

	        JPanel panel = new JPanel();
	        panel.setLayout(null);

	        JLabel usernameLabel = new JLabel("아이디:");
	        usernameLabel.setBounds(30, 30, 80, 25);
	        panel.add(usernameLabel);

	        usernameField = new JTextField();
	        usernameField.setBounds(110, 30, 160, 25);
	        panel.add(usernameField);

	        JLabel passwordLabel = new JLabel("비밀번호:");
	        passwordLabel.setBounds(30, 65, 80, 25);
	        panel.add(passwordLabel);

	        passwordField = new JPasswordField();
	        passwordField.setBounds(110, 65, 160, 25);
	        panel.add(passwordField);

	        loginButton = new JButton("로그인");
	        loginButton.setBounds(30, 110, 100, 25);
	        panel.add(loginButton);

	        joinButton = new JButton("회원가입");
	        joinButton.setBounds(170, 110, 100, 25);
	        panel.add(joinButton);

	        add(panel);

	        loginButton.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	DAO dao = new DAO();
	                String username = usernameField.getText();
	                String password = new String(passwordField.getPassword());

	                boolean loginSuccess = dao.login(username, password);//dao로 로그인인듯

	                if (loginSuccess) {
	                    JOptionPane.showMessageDialog(null, "Login Successful");
	                    setLoginListener(new LoginListener() {
	                        @Override
	                        public void onLoginSuccess() {
	                            CalendarExample frame = new CalendarExample();
	                            frame.setVisible(true);//새로운 창 띄우는
	                        }
	                    });
	                    dispose();
	                    if (loginListener != null) {
	                        loginListener.onLoginSuccess();
	                    }
	                } else {
	                    JOptionPane.showMessageDialog(null, "Login Failed");
	                }
	            }
	        });

	        joinButton.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                Join_form joinForm = new Join_form(); //회원가입인듯
	                joinForm.setLoginListener(new LoginListener() {
	                    @Override
	                    public void onLoginSuccess() {
	                        Login fra = new Login();
	                        fra.setVisible(true);
	                    }
	                });
	                joinForm.setVisible(true);
	                dispose();
	            }
	        });
	    }

	    public void setLoginListener(LoginListener listener) {
	        this.loginListener = listener;
	    }
	    public interface LoginListener {
	        void onLoginSuccess();
	    }


	}



