/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author aakov-dy
 */
public class Driver {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ModelCalendarTable calendarModel = new ModelCalendarTable();
        CalendarViewer cp = new CalendarViewer(calendarModel);
        CalendarViewerListeners actionListeners = new CalendarViewerListeners(cp);
        cp.addListeners(actionListeners, actionListeners);
    }
    
}


