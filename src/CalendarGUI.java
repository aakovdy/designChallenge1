/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author aakov-dy
 */
import java.awt.event.*;
import java.util.GregorianCalendar;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class CalendarGUI {
    public int yearBound, monthBound, dayBound, yearToday, monthToday;
    
    private JFrame mainWindow;
    private JPanel mainPanel;
    private JPanel calendarPanel;
    private JLabel monthLabel, yearLabel;
    private JButton btnPrev, btnNext, btnImport, btnFBNotif, btnSMSNotif;
    private JComboBox cmbYear;
    private JScrollPane scrollCalendarTable;
    
    private JTable calendarTable;
    public DefaultTableModel modelCalendarTable;
    
    public CalendarGUI(){
        mainWindow = new JFrame("Calendar Application");
        mainWindow.setSize(660, 750);
        mainWindow.setResizable(false);
        
        mainPanel = new JPanel(null);
        mainPanel.setBounds(0, 0, 640, 670);
        
        monthLabel = new JLabel();
        monthLabel.setBounds(320 - monthLabel.getPreferredSize().width / 2, 50, 200, 50);
        mainPanel.add(monthLabel);
        
        yearLabel = new JLabel("Change Year:");
        yearLabel.setBounds(350, 610, 160, 40);
        mainPanel.add(yearLabel);
        
        cmbYear = new JComboBox();
        cmbYear.setBounds(460, 610, 160, 40);
        mainPanel.add(cmbYear);
        
        btnPrev = new JButton("<<");
        btnPrev.setName("btnPrev");
        btnPrev.setBounds(20, 50, 100, 50);
        mainPanel.add(btnPrev);
        
        btnNext = new JButton(">>");
        btnNext.setName("btnNext");
        btnNext.setBounds(520, 50, 100, 50);
        mainPanel.add(btnNext);
        
        btnImport = new JButton("<html><center>Import<br>Event</center></html>"); //Use HTML codes to format text
        btnImport.setName("btnImport");
        btnImport.setBounds(20, 610, 100, 50);
        mainPanel.add(btnImport);
        
        btnFBNotif = new JButton("<html><center>Send to<br>Facebook</center></html>");
        btnFBNotif.setName("btnFBNotif");
        btnFBNotif.setBounds(130, 610, 100, 50);
        mainPanel.add(btnFBNotif);
        
        btnSMSNotif = new JButton("<html><center>Send to<br>SMS</center></html>");
        btnSMSNotif.setName("btnSMSNotif");
        btnSMSNotif.setBounds(240, 610, 100, 50);
        mainPanel.add(btnSMSNotif);
        
        mainPanel.setBorder(BorderFactory.createTitledBorder("Calendar"));
        mainWindow.add(mainPanel);
        
        modelCalendarTable = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int rowIndex, int mColIndex) {
                return true;
            }
        };

        calendarTable = new JTable(modelCalendarTable);
        calendarTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                int col = calendarTable.getSelectedColumn();
                int row = calendarTable.getSelectedRow();
            }
        });

        scrollCalendarTable = new JScrollPane(calendarTable);
        scrollCalendarTable.setBounds(20, 100, 600, 500);
        mainPanel.add(scrollCalendarTable);
        
        GregorianCalendar cal = new GregorianCalendar();
        dayBound = cal.get(GregorianCalendar.DAY_OF_MONTH);
        monthBound = cal.get(GregorianCalendar.MONTH);
        yearBound = cal.get(GregorianCalendar.YEAR);
        monthToday = monthBound;
        yearToday = yearBound;

        String[] headers = {"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"}; //All headers
        for (int i = 0; i < 7; i++) {
            modelCalendarTable.addColumn(headers[i]);
        }

        calendarTable.getParent().setBackground(calendarTable.getBackground()); //Set background

        calendarTable.getTableHeader().setResizingAllowed(false);
        calendarTable.getTableHeader().setReorderingAllowed(false);

        calendarTable.setColumnSelectionAllowed(true);
        calendarTable.setRowSelectionAllowed(true);
        calendarTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        calendarTable.setRowHeight(76);
        modelCalendarTable.setColumnCount(7);
        modelCalendarTable.setRowCount(6);

        for (int i = yearBound - 100; i <= yearBound + 100; i++) {
            cmbYear.addItem(String.valueOf(i));
        }
        
        refreshCalendar(monthBound, yearBound); //Refresh calendar
    
        mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainWindow.setLocationRelativeTo(null);
        mainWindow.setVisible(true);
    }
    
    public void refreshCalendar(int month, int year) {
        String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        int nod, som, i, j;

        btnPrev.setEnabled(true);
        btnNext.setEnabled(true);
        if (month == 0 && year <= yearBound - 10) {
            btnPrev.setEnabled(false);
        }
        if (month == 11 && year >= yearBound + 100) {
            btnNext.setEnabled(false);
        }

        monthLabel.setText(months[month]);
        monthLabel.setBounds(320 - monthLabel.getPreferredSize().width / 2, 50, 360, 50);

        cmbYear.setSelectedItem("" + year);

        for (i = 0; i < 6; i++) {
            for (j = 0; j < 7; j++) {
                modelCalendarTable.setValueAt(null, i, j);
            }
        }

        GregorianCalendar cal = new GregorianCalendar(year, month, 1);
        nod = cal.getActualMaximum(GregorianCalendar.DAY_OF_MONTH);
        som = cal.get(GregorianCalendar.DAY_OF_WEEK);

        for (i = 1; i <= nod; i++) {
            int row = new Integer((i + som - 2) / 7);
            int column = (i + som - 2) % 7;
            modelCalendarTable.setValueAt(i, row, column);
        }

        calendarTable.setDefaultRenderer(calendarTable.getColumnClass(0), new TableRenderer());
    }
    
    public void setMonthToday(int month) {
        this.monthToday = month;
    }
    
    public int getMonthToday() {
        return this.monthToday;
    }
    
    public void setYearToday(int year) {
        this.yearToday = year;
    }
    
    public int getYearToday() {
        return this.yearToday;
    }
    
    public JComboBox getCmbYear() {
        return this.cmbYear;
    }
    
    public JTable getCalendarTable() {
        return this.calendarTable;
    }
    
    public void AddListener(ActionListener btnListener, ActionListener cmbYearListener, MouseListener mListener){
        btnPrev.addActionListener(btnListener);
        btnNext.addActionListener(btnListener);
        cmbYear.addActionListener(cmbYearListener);
    }
    
}

