import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

public class AddEventGuiListeners implements ActionListener {

    private AddEventGui addEvent;
    
    public AddEventGuiListeners(AddEventGui addEvent) {
        this.addEvent = addEvent;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String eventName = addEvent.getNameField().getText();
        String location = addEvent.getLocationField().getText();
        String description = addEvent.getDescriptionField().getText();
    }
    
    
}
