package designchallenge1;

public class DesignChallenge1 {
    public static void main(String[] args) {
        // TODO code application logic here
        ModelCalendarTable calendarModel = new ModelCalendarTable();
        CalendarViewer cp = new CalendarViewer(calendarModel);
        CalendarViewerListeners actionListeners = new CalendarViewerListeners(cp);
        cp.addListeners(actionListeners, actionListeners);
        TableRenderer tableRenderer = new TableRenderer();
        RefreshCalendar refreshCalendar = new RefreshCalendar(cp, cp.getMonthBound(), cp.getYearBound(), calendarModel, tableRenderer);
        //AddEventGui addEvent = new AddEventGui();
    }
}
