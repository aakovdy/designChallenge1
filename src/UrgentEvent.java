
import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class UrgentEvent extends DefaultTableCellRenderer implements AddEvent {

    private JTable calendarTable;
    
    @Override
    public void setEvent(JTable calendarTable) {
        this.calendarTable = calendarTable;
        calendarTable.setDefaultRenderer(calendarTable.getColumnClass(0), this);
    }
    
    public Component getTableCellRendererComponent(JTable table, Object value, boolean selected, boolean focused, int row, int column) {
        super.getTableCellRendererComponent(table, value, selected, focused, calendarTable.getSelectedRow(), calendarTable.getSelectedColumn());
        if (column == 0 || column == 6) {
            setBackground(new Color(220, 220, 255));
        } else if(column == calendarTable.getSelectedColumn() && row == calendarTable.getSelectedRow()) {
            setBackground(Color.RED);
        } else {
            setBackground(Color.WHITE);
        }
        setBorder(null);
        setForeground(Color.black);
        return this;
    }
    
}
