
import java.awt.Color;



public class Event {
    
    private int month, day, year;
    private String event, priority;
    private Color eventColor;
    
    public Event(int month, int day, int year, String event, String priority,Color color) {
        this.month = month;
        this.day = day;
        this.year = year;
        this.event = event;
        this.priority = priority;
        this.eventColor = color;
        
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
    
    public void setPriority(String priority) {
        this.priority = priority;
    }
    
    public void setEventColor(Color color) {
        this.eventColor = color;
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
    
    public String getPriority() {
        return this.priority;
    }
    
    public Color getEventColor() {
        return this.eventColor;
    }
    
}
