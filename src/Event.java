public class Event {
    
    private int month, day, year;
    private String event, location, description;
    
    public Event(int month, int day, int year, String event, String location, String description) {
        this.month = month;
        this.day = day;
        this.year = year;
        this.event = event;
        this.location = location;
        this.description = description;
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
    
    public void setLocation(String location) {
        this.location = location;
    }
    
    public void setDescription(String description) {
        this.description = description;
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
    
    public String getLocation() {
        return this.location;
    }
    
    public String getDescription() {
        return this.description;
    }
}
