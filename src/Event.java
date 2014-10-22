

public class Event {
    
    private int month, day, year;
    private String event, priority;
    
    public Event(Object date, String event, String priority) {
        this.day = day;
        this.year = year;
        this.event = event;
        this.priority = priority;
        
    }

    Event(Object valueAt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void setMonth(int month) {
        this.month = month;
    }
    
    public void setDay(int day) {
        this.day = day;
    }
    
    public void setYear(int year) {
        this.year = year;
    }
    
    public void setEvent(String event) {
        this.event = event;
    }
    
    public int getMonth() {
        return this.month;
    }
    
    public int getDay() {
        return this.day;
    }
    
    public int getYear() {
        return this.year;
    }
    
    public String getEvent() {
        return this.event;
    }
}
