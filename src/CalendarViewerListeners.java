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
            cp.refreshCalendar(monthToday, yearToday);
        } else if ("btnNext".equals(btnName)) {
            if (monthToday == 11) {
                monthToday = 0;
                yearToday += 1;
            } else {
                monthToday += 1;
            }
            cp.refreshCalendar(monthToday, yearToday);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int col = cp.calendarTable.getSelectedColumn();
        int row = cp.calendarTable.getSelectedRow();
    }

    @Override
    public void mousePressed(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
}
