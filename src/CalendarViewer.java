import java.awt.Container;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.GregorianCalendar;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

public class CalendarViewer {

    private int yearBound, monthBound, dayBound, yearToday, monthToday;

    private JLabel monthLabel, yearLabel;
    private JButton btnPrev, btnNext;
    private JComboBox cmbYear;
    private JFrame frmMain;
    private Container pane;
    private JScrollPane scrollCalendarTable;
    private JPanel calendarPanel;
    private JTable calendarTable;

    public CalendarViewer(DefaultTableModel modelCalendarTable) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {

        }

        frmMain = new JFrame("Calendar Application");
        frmMain.setSize(495, 563);
        pane = frmMain.getContentPane();
        pane.setLayout(null);
        frmMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        monthLabel = new JLabel("January");
        yearLabel = new JLabel("Change year:");
        cmbYear = new JComboBox();
        btnPrev = new JButton("<<");
        btnNext = new JButton(">>");

        calendarTable = new JTable(modelCalendarTable);

        scrollCalendarTable = new JScrollPane(calendarTable);
        calendarPanel = new JPanel(null);

        calendarPanel.setBorder(BorderFactory.createTitledBorder("Calendar"));
        
        pane.add(calendarPanel);
        calendarPanel.add(monthLabel);
        calendarPanel.add(yearLabel);
        calendarPanel.add(cmbYear);
        calendarPanel.add(btnPrev);
        calendarPanel.add(btnNext);
        calendarPanel.add(scrollCalendarTable);

        calendarPanel.setBounds(0, 0, 640, 670);
        monthLabel.setBounds(320 - monthLabel.getPreferredSize().width / 2, 50, 200, 50);
        yearLabel.setBounds(20, 610, 160, 40);
        cmbYear.setBounds(460, 610, 160, 40);
        btnPrev.setBounds(20, 50, 100, 50);
        btnNext.setBounds(520, 50, 100, 50);
        scrollCalendarTable.setBounds(20, 100, 600, 500);

        frmMain.setResizable(false);
        frmMain.setVisible(true);

        GregorianCalendar cal = new GregorianCalendar();
        dayBound = cal.get(GregorianCalendar.DAY_OF_MONTH);
        monthBound = cal.get(GregorianCalendar.MONTH);
        yearBound = cal.get(GregorianCalendar.YEAR);
        monthToday = monthBound;
        yearToday = yearBound;
        
        modelCalendarTable.setColumnCount(7);
        modelCalendarTable.setRowCount(6);

        for(int i = 0; i < modelCalendarTable.getColumnCount(); i++) {
            modelCalendarTable.addColumn(modelCalendarTable.getColumnName(i));
        }

        calendarTable.getParent().setBackground(calendarTable.getBackground()); //Set background

        calendarTable.getTableHeader().setResizingAllowed(false);
        calendarTable.getTableHeader().setReorderingAllowed(false);

        calendarTable.setColumnSelectionAllowed(true);
        calendarTable.setRowSelectionAllowed(true);
        calendarTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        calendarTable.setRowHeight(76);

        for (int i = yearBound - 100; i <= yearBound + 100; i++) {
            cmbYear.addItem(String.valueOf(i));
        }
    }

    public void addListeners(ActionListener l, MouseListener ml) {
        btnPrev.addActionListener(l);
        btnNext.addActionListener(l);
        calendarTable.addMouseListener(ml);
    }
    
    public int getMonthBound() {
        return this.monthBound;
    }
    
    public int getYearBound() {
        return this.yearBound;
    }
    
    public JTable getCalendarTable() {
        return this.calendarTable;
    }
    
    public JButton getBtnPrev() {
        return this.btnPrev;
    }
    
    public JButton getBtnNext() {
        return this.btnNext;
    }
    
    public JLabel getMonthLabel() {
        return this.monthLabel;
    }
    
    public JComboBox getCmbYear() {
        return this.cmbYear;
    }
}
