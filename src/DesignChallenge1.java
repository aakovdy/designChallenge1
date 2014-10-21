public class DesignChallenge1 {
    public static void main(String[] args) {
        // TODO code application logic here
        ModelCalendarTable calendarModel = new ModelCalendarTable();
        CalendarViewer cp = new CalendarViewer(calendarModel);
        TableRenderer tableRenderer = new TableRenderer();
        RefreshCalendar refreshCalendar = new RefreshCalendar(cp, cp.getMonthBound(), cp.getYearBound(), calendarModel, tableRenderer);
        
        //AddEventGui addEvent = null;
        //AddEventGuiListeners addEventListeners = new AddEventGuiListeners(addEvent);
        CalendarViewerListeners calendarListeners = new CalendarViewerListeners(cp, refreshCalendar);
        cp.addListeners(calendarListeners, calendarListeners);
    }
}
