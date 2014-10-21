
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author aakov-dy
 */

import javax.swing.table.DefaultTableModel;

public class ModelCalendarTable extends DefaultTableModel{
    
    public boolean isCellEditable() {
        return true;
    }
    
    public int getColumnCount(){
        return 7;
    }
    
    public String getColumnName(int column){
        switch(column){
            case 1: return "Sunday";
            case 2: return "Monday";
            case 3: return "Tuesday";
            case 4: return "Wednesday";
            case 5: return "Thursday";
            case 6: return "Friday";
            case 7: return "Saturday";
            default: return "Unknown";
        }
    }
    
}
