/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author aakov-dy
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CalendarGUI {
    private JFrame mainWindow;
    private JPanel mainPanel;
    private JPanel calendarPanel;
    private JLabel monthLabel, yearLabel;
    private JButton btnPrev, btnNext, btnImport, btnFBNotif, btnSMSNotif;
    private JComboBox cmbYear;
    private JTable calendarTable;
    
    public CalendarGUI(){
        mainWindow = new JFrame("Calendar Application");
        mainWindow.setSize(660, 750);
        mainWindow.setResizable(false);
        
        mainPanel = new JPanel(null);
        mainPanel.setBounds(0, 0, 640, 670);
        
        monthLabel = new JLabel("January");
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
        
        mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainWindow.setLocationRelativeTo(null);
        mainWindow.setVisible(true);
    }
    
    public void AddListener(ActionListener listener, MouseListener mListener){
        btnPrev.addActionListener(listener);
    }
    
}
