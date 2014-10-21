import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AddEventGui {
    
    private JFrame event;
    private Container pane;
    private JPanel panel;
    private JLabel nameLabel, locationLabel, descriptionLabel, priorityLabel;
    private JComboBox priorityBox;
    private JTextField nameField, locationField, descriptionField;
    private JButton submitBtn;
    
    public AddEventGui() {
        event = new JFrame("Add Event");
        event.setSize(300, 400);
        event.setVisible(true);
        
        pane = event.getContentPane();
        pane.setLayout(null);
        pane.setVisible(true);
        
        event.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        String[] priorityBoxItems = {"Urgent", "High", "Medium", "Low"};

        //construct components
        nameLabel = new JLabel ("Event Name:");
        locationLabel = new JLabel ("Location:");
        descriptionLabel = new JLabel ("Description: ");
        priorityLabel = new JLabel ("Priority: ");
        priorityBox = new JComboBox (priorityBoxItems);
        nameField = new JTextField (5);
        locationField = new JTextField (5);
        descriptionField = new JTextField (5);
        submitBtn = new JButton ("Submit");

        panel = new JPanel();
        panel.setVisible(true);
        //adjust size and set layout
        panel.setPreferredSize (new Dimension (225, 375));
        panel.setLayout (null);

        //add components
        panel.add (nameLabel);
        panel.add (locationLabel);
        panel.add (descriptionLabel);
        panel.add (priorityLabel);
        panel.add (priorityBox);
        panel.add (nameField);
        panel.add (locationField);
        panel.add (descriptionField);
        panel.add (submitBtn);

        //set component bounds (only needed by Absolute Positioning)
        nameLabel.setBounds (30, 25, 100, 25);
        locationLabel.setBounds (30, 70, 100, 25);
        descriptionLabel.setBounds (30, 115, 100, 25);
        priorityLabel.setBounds (30, 235, 100, 25);
        priorityBox.setBounds (125, 235, 100, 25);
        nameField.setBounds (125, 25, 200, 25);
        locationField.setBounds (125, 70, 200, 25);
        descriptionField.setBounds (125, 115, 200, 100);
        submitBtn.setBounds (95, 295, 100, 25);
        
        pane.add(panel);
    }
    
}
