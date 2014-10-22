public class DesignChallenge1 {
    public static void main(String[] args) {
        // TODO code application logic here
        ModelCalendarTable calendarModel = new ModelCalendarTable();
        CalendarViewer cp = new CalendarViewer(calendarModel);
        TableRenderer tableRenderer = new TableRenderer();
        RefreshCalendar refreshCalendar = new RefreshCalendar(cp, cp.getMonthBound(), cp.getYearBound(), calendarModel, tableRenderer);
        
        AddEventGui addEvent = new AddEventGui();
        CalendarViewerListeners calendarListeners = new CalendarViewerListeners(cp, refreshCalendar, addEvent);
        AddEventGuiListeners addEventListeners = new AddEventGuiListeners(addEvent);
        addEvent.addListener(addEventListeners);
        cp.addListeners(calendarListeners, calendarListeners);
    }
}
