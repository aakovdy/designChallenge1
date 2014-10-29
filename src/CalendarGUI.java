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
        
        monthLabel = new JLabel("January");
        monthLabel.setBounds(320 - monthLabel.getPreferredSize().width / 2, 50, 200, 50);
        
        yearLabel = new JLabel("Change Year:");
        yearLabel.setBounds(350, 610, 160, 40);
        
        cmbYear = new JComboBox();
        cmbYear.setBounds(460, 610, 160, 40);
        
        btnPrev = new JButton("<<");
        btnPrev.setName("btnPrev");
        btnPrev.setBounds(20, 50, 100, 50);
        
        btnNext = new JButton(">>");
        btnNext.setName("btnNext");
        btnNext.setBounds(520, 50, 100, 50);
        
        btnImport = new JButton("Import Event");
        btnImport.setName("btnImport");
        btnImport.setBounds(20, 610, 100, 50);
        
        btnFBNotif = new JButton("Send notifications to Facebook");
        btnFBNotif.setName("btnFBNotif");
        btnFBNotif.setBounds(130, 610, 100, 50);
        
        btnSMSNotif = new JButton("Send notification to SMS");
        btnSMSNotif.setName("btnSMSNotif");
        btnSMSNotif.setBounds(240, 610, 100, 50);
        
        calendarPanel = new JPanel(null);
        calendarPanel.setBounds(0, 0, 640, 670);
        
        
        mainWindow.add(mainPanel);
        
        mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainWindow.setLocationRelativeTo(null);
        mainWindow.setVisible(true);
    }
}
