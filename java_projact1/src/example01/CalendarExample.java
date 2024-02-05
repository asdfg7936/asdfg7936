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

        // 중앙 상단에 월을 표시할 레이블 생성
        monthLabel = new JLabel("", SwingConstants.CENTER);
        monthLabel.setFont(new Font("SansSerif", Font.BOLD, 16));
        updateMonthLabel(); // 초기에 월 레이블 업데이트

        JPanel labelPanel = new JPanel(new BorderLayout());
        labelPanel.add(monthLabel, BorderLayout.CENTER);

        // 좌측하단에 버튼 추가
        JButton additionalButton = new JButton("목표 확인");
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
        mainPanel.add(labelPanel, BorderLayout.NORTH); // 레이블 패널 추가
        mainPanel.add(additionalButtonPanel, BorderLayout.SOUTH);
        mainPanel.add(calendarPanel, BorderLayout.CENTER);

        setLayout(new BorderLayout());
        add(mainPanel, BorderLayout.CENTER);

        // 초기에 달력 그리기
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

        // 이전 달의 마지막 날짜 계산
        Calendar prevMonthCalendar = (Calendar) calendar.clone();
        prevMonthCalendar.add(Calendar.MONTH, -1);
        int prevMonthMaximumDay = prevMonthCalendar.getActualMaximum(Calendar.DAY_OF_MONTH);

        // 다음 달의 첫 날짜 계산
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
                final int selectedYear = year; // 선택한 날짜 정보 저장
                final int selectedMonth = month + 1;
                final int selectedDay = day;
                dateButtons[i].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JOptionPane.showMessageDialog(null, "선택한 날짜: " + selectedYear + "년 " + selectedMonth + "월 " + selectedDay + "일");//일자 확인 메세
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
        monthLabel.setText(year + "년 " + month + "월");
    }

    public static void main(String[] args) {
    
    	new CalendarExample();
    	
    }
}
