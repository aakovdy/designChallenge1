
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class CalendarProgram {

    private int yearBound, monthBound, dayBound, yearToday, monthToday;

    private JLabel monthLabel, yearLabel;
    private JButton btnPrev, btnNext, btnImport, btnFbView, btnSmsView;
    private JComboBox cmbYear;
    private JFrame frmMain;
    private Container pane;
    private JScrollPane scrollCalendarTable;
    private JPanel calendarPanel;

    private JTable calendarTable;
    private DefaultTableModel modelCalendarTable;

    private String[] priorities;
    private String event, eventLevel;

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

    public CalendarProgram() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
        }

        frmMain = new JFrame("Calendar Application");
        frmMain.setSize(660, 750);
        pane = frmMain.getContentPane();
        pane.setLayout(null);
        frmMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        monthLabel = new JLabel("January");
        yearLabel = new JLabel("Change year:");
        cmbYear = new JComboBox();
        btnPrev = new JButton("<<");
        btnNext = new JButton(">>");
        btnImport = new JButton("Import Event");
        btnFbView = new JButton("FB View");
        btnSmsView = new JButton("SMS View");

        btnPrev.setName("btnPrev");
        btnNext.setName("btnNext");
        btnImport.setName("btnImport");
        btnFbView.setName("btnFbView");
        btnSmsView.setName("btnSmsView");

        modelCalendarTable = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int rowIndex, int mColIndex) {
                return true;
            }
        };

        calendarTable = new JTable(modelCalendarTable);
        calendarTable.addMouseListener(new MouseAdapter() {
            @Override
            @SuppressWarnings("empty-statement")
            public void mouseClicked(MouseEvent evt) {
                int col = calendarTable.getSelectedColumn();
                int row = calendarTable.getSelectedRow();

                String[] priorities = {"Urgent", "High", "Medium", "Low"};
                JComboBox priorityBox = new JComboBox(priorities);
                event = JOptionPane.showInputDialog("Event Name:");
                JOptionPane.showMessageDialog(null, priorityBox, "Priority Level", JOptionPane.QUESTION_MESSAGE);
                eventLevel = (String) priorityBox.getSelectedItem();
               
                if(eventLevel.equals("Urgent")) {
                    /*AddEvent addEvent = new UrgentEvent();
                    addEvent.setEvent(calendarTable);
                    modelCalendarTable.setValueAt(pane, calendarTable.getSelectedRow(), calendarTable.getSelectedRow());
                    modelCalendarTable.fireTableCellUpdated(calendarTable.getSelectedRow(), calendarTable.getSelectedColumn());*/
                } else if(eventLevel.equals("High")) {
                    AddEvent addEvent = (AddEvent) new HighEvent();
                } else if(eventLevel.equals("Medium")) {
                    AddEvent addEvent = (AddEvent) new MediumEvent();
                } else if(eventLevel.equals("Low")) {
                    AddEvent addEvent = (AddEvent) new LowEvent();
                }
            }
        });

        scrollCalendarTable = new JScrollPane(calendarTable);
        calendarPanel = new JPanel(null);

        calendarPanel.setBorder(BorderFactory.createTitledBorder("Calendar"));

        btnPrev.addActionListener(new btnPrev_Action());
        btnNext.addActionListener(new btnNext_Action());
        cmbYear.addActionListener(new cmbYear_Action());

        pane.add(calendarPanel);
        calendarPanel.add(monthLabel);
        calendarPanel.add(yearLabel);
        calendarPanel.add(cmbYear);
        calendarPanel.add(btnPrev);
        calendarPanel.add(btnNext);
        calendarPanel.add(btnImport);
        calendarPanel.add(btnFbView);
        calendarPanel.add(btnSmsView);
        calendarPanel.add(scrollCalendarTable);

        calendarPanel.setBounds(0, 0, 640, 670);
        monthLabel.setBounds(320 - monthLabel.getPreferredSize().width / 2, 50, 200, 50);
        yearLabel.setBounds(350, 610, 160, 40);
        cmbYear.setBounds(460, 610, 160, 40);
        btnPrev.setBounds(20, 50, 100, 50);
        btnNext.setBounds(520, 50, 100, 50);
        btnImport.setBounds(20, 610, 100, 50);
        btnFbView.setBounds(130, 610, 100, 50);
        btnSmsView.setBounds(240, 610, 100, 50);
        scrollCalendarTable.setBounds(20, 100, 600, 500);

        frmMain.setResizable(false);
        frmMain.setVisible(true);

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
    }

    class btnPrev_Action implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (monthToday == 0) {
                monthToday = 11;
                yearToday -= 1;
            } else {
                monthToday -= 1;
            }
            refreshCalendar(monthToday, yearToday);
        }
    }

    class btnNext_Action implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (monthToday == 11) {
                monthToday = 0;
                yearToday += 1;
            } else {
                monthToday += 1;
            }
            refreshCalendar(monthToday, yearToday);
        }
    }

    class cmbYear_Action implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (cmbYear.getSelectedItem() != null) {
                String b = cmbYear.getSelectedItem().toString();
                yearToday = Integer.parseInt(b);
                refreshCalendar(monthToday, yearToday);
            }
        }
    }

    public String getEventName() {
        return this.event;
    }
    
    public String getEventLevel() {
        return this.eventLevel;
    }
    
    public int getSelectedRow() {
        return calendarTable.getSelectedRow();
    }
    
    public int getSelectedColumn() {
        return calendarTable.getSelectedColumn();
    }
    
    public JTable getCalendarTable() {
        return this.calendarTable;
    }
}
