package StupidButton;

import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author aryan1798
 */
public class MessagePanel extends JPanel{
    
    private JLabel message;
    
    public MessagePanel(){
        
        message = new JLabel("The colts will be back.");
        add(message);
    }
    
    public void changeLabel(String newLabel){
        message.setText(newLabel);
        
    }
}
