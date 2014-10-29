/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author aakov-dy
 */

public class Event {
    private int month, day, year;
    private String event, priority, color;
    
    public Event (int month, int day, int year, String event, String priority, String color){
        this.month = month;
        this.day = day;
        this.year = year;
        this.event = event;
        this.priority = priority;
        this.color = color;
    }
    
    public int getMonth(){
        return month;
    }
    
    public void setMonth(int month){
        this.month = month;
    }
    
    public int getDay(){
        return day;
    }
    
    public void setDay(int Day){
        this.day = day;
    }
    
    public int getYear(){
        return year;
    }
    
    public void setYear(int year){
        this.year = year;
    }
    
    public String getEvent(){
        return event;
    }
    
    public void setEvent(String event){
        this.event = event;
    }
    
    public String getPriority(){
        return priority;
    }
    
    public void setPriority(String priority){
        this.priority = priority;
    }
    
    public String getColor(){
        return color;
    }
    
    public void setColor(String color){
        this.color = color;
    }
}
