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
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.table.DefaultTableModel;

public class CalendarViewer {
    public JFrame mainWindow;
    public Container pane;
    public JLabel monthLabel, yearLabel;
    public JComboBox cmbYear;
    public JButton btnPrev, btnNext;
    
    public CalendarViewer(DefaultTableModel modelCalendarTable){
        mainWindow = new JFrame("Calendar Application");
        mainWindow.setSize(495,563);
        pane = mainWindow.getContentPane();
        pane.setLayout(null);
        mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        monthLabel = new JLabel ("January");
	yearLabel = new JLabel ("Change year:");
	cmbYear = new JComboBox();
	btnPrev = new JButton ("<<");
	btnNext = new JButton (">>");
        
        
        
        mainWindow.setVisible(true);
    }
}
