package StupidButton;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;


/**
 *
 * @author aryan1798
 */
public class StupidFrame extends JFrame{
    
    private MessagePanel myPanel;
    
    public StupidFrame() {
       setTitle("Hello World");
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       setSize(700, 900); 
       MessagePanel myPanel = new MessagePanel();
       add(myPanel, BorderLayout.CENTER);
       
        JButton theTruth = new JButton("The Truth Sir");
        add(theTruth, BorderLayout.SOUTH);
        
        ColtsHandler myHandler = new ColtsHandler();
        theTruth.addActionListener(myHandler);
        setVisible(true);
       
    }
    
    private class ColtsHandler implements ActionListener
    {
        public void actionPerformed(ActionEvent event) {
            System.out.println("You pressed the " + event.getActionCommand());
            myPanel.changeLabel("Not today.");
        }
    }
    
}
