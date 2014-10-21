import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;

public class CalendarViewerListeners implements ActionListener, MouseListener {

    public JButton btnPrev, btnNext;
    public int monthToday, yearToday;
    public CalendarViewer cp;

    public CalendarViewerListeners(CalendarViewer cp) {
        this.cp = cp;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton source = (JButton) e.getSource();
        String btnName = source.getName();

        if ("btnPrev".equals(btnName)) {
            if (monthToday == 0) {
                monthToday = 11;
                yearToday -= 1;
            } else {
                monthToday -= 1;
            }
            //refreshCalendar.setMonth(monthToday);
            //refreshCalendar.setYear(yearToday);
        } else if ("btnNext".equals(btnName)) {
            if (monthToday == 11) {
                monthToday = 0;
                yearToday += 1;
            } else {
                monthToday += 1;
            }
            //refreshCalendar.setMonth(monthToday);
            //refreshCalendar.setYear(yearToday);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int col = cp.getCalendarTable().getSelectedColumn();
        int row = cp.getCalendarTable().getSelectedRow();
        
        AddEventGui gui = new AddEventGui();
    }

    @Override
    public void mousePressed(MouseEvent e) {
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
    }

   
}
