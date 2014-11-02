/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author aakov-dy
 */

import java.util.ArrayList;

public class DesignChallenge1 {
    public static void main (String[] args){
        ArrayList<Event> events = new ArrayList<>();
        CalendarGUI calGUI = new CalendarGUI();
        CalendarButtonsControl btnControl = new CalendarButtonsControl(calGUI);
        CalendarCmbBoxControl cmbYearControl = new CalendarCmbBoxControl(calGUI);
        CalendarCellControl cellControl = new CalendarCellControl(calGUI.getCalendarTable());
        calGUI.AddListener(btnControl, cmbYearControl, cellControl);
    }
}
