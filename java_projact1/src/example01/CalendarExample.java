package example01;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;


public class CalendarExample extends JFrame {
    private JButton[] dateButtons;
    private JLabel monthLabel;

    public CalendarExample() {
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);

        JPanel calendarPanel = new JPanel(new GridLayout(0, 7));
        dateButtons = new JButton[42];

        for (int i = 0; i < 42; i++) {
            dateButtons[i] = new JButton();
            calendarPanel.add(dateButtons[i]);
        }

        // �߾� ��ܿ� ���� ǥ���� ���̺� ����
        monthLabel = new JLabel("", SwingConstants.CENTER);
        monthLabel.setFont(new Font("SansSerif", Font.BOLD, 16));
        updateMonthLabel(); // �ʱ⿡ �� ���̺� ������Ʈ

        JPanel labelPanel = new JPanel(new BorderLayout());
        labelPanel.add(monthLabel, BorderLayout.CENTER);

        // �����ϴܿ� ��ư �߰�
        JButton additionalButton = new JButton("��ǥ Ȯ��");
        additionalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Goal_gui frame = new Goal_gui();
				frame.setVisible(true);
            }
        });

        JPanel additionalButtonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        additionalButtonPanel.add(additionalButton);

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(labelPanel, BorderLayout.NORTH); // ���̺� �г� �߰�
        mainPanel.add(additionalButtonPanel, BorderLayout.SOUTH);
        mainPanel.add(calendarPanel, BorderLayout.CENTER);

        setLayout(new BorderLayout());
        add(mainPanel, BorderLayout.CENTER);

        // �ʱ⿡ �޷� �׸���
        drawCalendar();

        setVisible(true);
    }

    private void drawCalendar() {
    	Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_MONTH, 1);

        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);

        setTitle("Life Style");

        int startDayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        int maximumDayOfMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);

        // ���� ���� ������ ��¥ ���
        Calendar prevMonthCalendar = (Calendar) calendar.clone();
        prevMonthCalendar.add(Calendar.MONTH, -1);
        int prevMonthMaximumDay = prevMonthCalendar.getActualMaximum(Calendar.DAY_OF_MONTH);

        // ���� ���� ù ��¥ ���
        Calendar nextMonthCalendar = (Calendar) calendar.clone();
        nextMonthCalendar.add(Calendar.MONTH, 1);

        int day = 1;
        for (int i = 0; i < 42; i++) {
            if (i < startDayOfWeek - 1) {
                int prevMonthDay = prevMonthMaximumDay - (startDayOfWeek - 2 - i);
                dateButtons[i].setText(prevMonthDay + "");
                dateButtons[i].setEnabled(false);
            } else if (day <= maximumDayOfMonth) {
                dateButtons[i].setText(day + "");
                dateButtons[i].setEnabled(true);
                final int selectedYear = year; // ������ ��¥ ���� ����
                final int selectedMonth = month + 1;
                final int selectedDay = day;
                dateButtons[i].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JOptionPane.showMessageDialog(null, "������ ��¥: " + selectedYear + "�� " + selectedMonth + "�� " + selectedDay + "��");//���� Ȯ�� �޼�
                        Schedule frame = new Schedule(selectedYear, selectedMonth, selectedDay);
        				frame.setVisible(true);
                    }
                });
                day++;
            } else {
                int nextMonthDay = i - (startDayOfWeek - 1) - maximumDayOfMonth + 1;
                dateButtons[i].setText(nextMonthDay + "");
                dateButtons[i].setEnabled(false);
            }
        }
    }
    private void updateMonthLabel() {
    	Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;
        monthLabel.setText(year + "�� " + month + "��");
    }

    public static void main(String[] args) {
    
    	new CalendarExample();
    	
    }
}
