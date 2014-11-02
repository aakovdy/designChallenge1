/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jasmin
 */
import java.awt.event.*;
import javax.swing.*;

public class CalendarButtonsControl implements ActionListener {

    private String btnName;
    private int monthToday, yearToday;
    private CalendarGUI calGUI;

    public CalendarButtonsControl(CalendarGUI calGUI) {
        this.calGUI = calGUI;
        this.monthToday = calGUI.getMonthToday();
        this.yearToday = calGUI.getYearToday();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton source = (JButton) e.getSource();
        btnName = source.getName();

        if (btnName.equals("btnPrev")) {
            //System.out.println("You clicked the previous month.");
            if (monthToday == 0) {
                monthToday = 11;
                calGUI.setMonthToday(monthToday);
                yearToday -= 1;
                calGUI.setYearToday(yearToday);
            } else {
                monthToday -= 1;
                calGUI.setMonthToday(monthToday);
            }
            calGUI.refreshCalendar(monthToday, yearToday);

        } else if (btnName.equals("btnNext")) {
            //System.out.println("Boom Panes!");
            if (monthToday == 11) {
                monthToday = 0;
                calGUI.setMonthToday(monthToday);
                yearToday += 1;
                calGUI.setYearToday(yearToday);
            } else {
                monthToday += 1;
                calGUI.setMonthToday(monthToday);
            }
            calGUI.refreshCalendar(monthToday, yearToday);
        }
    }
}
