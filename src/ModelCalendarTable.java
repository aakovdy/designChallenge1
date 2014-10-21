import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class ModelCalendarTable extends DefaultTableModel {
    
    private ArrayList<String> columnHeaders;
    private int columnCount, rowCount;
   
    public ModelCalendarTable() {
        
    }
    
    @Override
    public boolean isCellEditable(int rowIndex, int mColIndex) {
        return true;
    }
    
    @Override
    public void setColumnCount(int columnCount) {
        this.columnCount = columnCount;
    }
    
    @Override
    public int getColumnCount() {
        return this.columnCount;
    }
    
    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Sun";
            case 1:
                return "Mon";
            case 2:
                return "Tue";
            case 3:
                return "Wed";
            case 4:
                return "Thu";
            case 5:
                return "Fri";
            case 6:
                return "Sat";
            default:
                return "unknown";
        }
    }
    
    
}
