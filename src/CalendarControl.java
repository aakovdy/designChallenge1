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
import javax.swing.*;

public class CalendarControl implements ActionListener, MouseListener {
    
    private String btnName;
    
    @Override
    public void actionPerformed(ActionEvent e) {
        JButton source = (JButton)e.getSource();
        btnName = source.getName();
        
        if (btnName.equals("btnPrev"))
            System.out.println("You clicked the previous month.");
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
    }
    
}
