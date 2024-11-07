package Reservaion;

import java.util.Calendar;

import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;

public class HCalendar {

	// 리스트에 요일 넣기
	DefaultListModel<String> dlm = new DefaultListModel<>();
	JList<String> dayDay = new JList<>(dlm);

    Calendar c = Calendar.getInstance();
    int year, month, day;
    int daysInMonth;
    int dayNum; // 요일을 나타내는 값 (1: 일요일, 2: 월요일, ..., 7: 토요일)
   
    
    public HCalendar() {
        year = c.get(Calendar.YEAR);
        month = c.get(Calendar.MONTH) + 1;
        day = c.get(Calendar.DATE);
        c.set(year, month - 1, 1); // 해당 월의 첫 날로 설정
        dayNum = c.get(Calendar.DAY_OF_WEEK); // 그 날의 요일을 가져옴
        daysInMonth = c.getActualMaximum(Calendar.DAY_OF_MONTH);
    }


    public String getYear() {
        return Integer.toString(year);
    }

    public String getMonth() {
        return Integer.toString(month);
    }

    DefaultListModel<String> displayDatesAndDays() {
        for (int i = 1; i <= daysInMonth; i++) {
            c.set(Calendar.DAY_OF_MONTH, i); // 날짜를 i로 설정하여 요일을 가져옴
            int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
            String dayOfWeekStr = getDayOfWeek(dayOfWeek);
            String tot = String.format("%2d일  %s ",i, dayOfWeekStr);
            dlm.addElement(tot);
        }
        return dlm;
    }

    public static String getDayOfWeek(int dayOfWeek) {
        String 요일 = "";
        switch (dayOfWeek) {
            case Calendar.SATURDAY:
                요일 = "토";
                break;
            case Calendar.SUNDAY:
                요일 = "일";
                break;
            case Calendar.MONDAY:
                요일 = "월";
                break;
            case Calendar.TUESDAY:
                요일 = "화";
                break;
            case Calendar.WEDNESDAY:
                요일 = "수";
                break;
            case Calendar.THURSDAY:
                요일 = "목";
                break;
            case Calendar.FRIDAY:
                요일 = "금";
                break;
            default:
                break;
        }
        return 요일;
    }
}