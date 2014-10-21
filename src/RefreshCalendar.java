package designchallenge1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.GregorianCalendar;

public class RefreshCalendar implements ActionListener {
    
    private CalendarViewer cp; 
    private ModelCalendarTable modelCalendarTable;
    private TableRenderer tableRenderer;
    private int month, year;
    
    public RefreshCalendar (CalendarViewer cp, int month, int year, ModelCalendarTable modelCalendarTable, TableRenderer tableRenderer) {
        this.cp = cp;
        this.month = month;
        this.year = year;
        this.modelCalendarTable = modelCalendarTable;
        this.tableRenderer = tableRenderer;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        int nod, som, i, j;

        cp.getBtnPrev().setEnabled(true);
        cp.getBtnNext().setEnabled(true);
        if (month == 0 && year <= cp.getYearBound() - 10) {
            cp.getBtnPrev().setEnabled(false);
        }
        if (month == 11 && year >= cp.getYearBound() + 100) {
            cp.getBtnNext().setEnabled(false);
        }

        cp.getMonthLabel().setText(months[month]);
        cp.getMonthLabel().setBounds(320 - cp.getMonthLabel().getPreferredSize().width / 2, 50, 360, 50);

        cp.getCmbYear().setSelectedItem("" + year);

        for (i = 0; i < 6; i++) {
            for (j = 0; j < 7; j++) {
                //modelCalendarTable.setValueAt(null, i, j);
            }
        }

        GregorianCalendar cal = new GregorianCalendar(year, month, 1);
        nod = cal.getActualMaximum(GregorianCalendar.DAY_OF_MONTH);
        som = cal.get(GregorianCalendar.DAY_OF_WEEK);

        for (i = 1; i <= nod; i++) {
            int row = new Integer((i + som - 2) / 7);
            int column = (i + som - 2) % 7;
            modelCalendarTable.setValueAt(i, row, column);
        }

        cp.getCalendarTable().setDefaultRenderer(cp.getCalendarTable().getColumnClass(0), tableRenderer);
    }
}
