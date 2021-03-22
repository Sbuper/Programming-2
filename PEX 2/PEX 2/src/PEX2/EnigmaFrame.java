package PEX2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

/**
 *
 * @author Andrew
 */
public class EnigmaFrame extends JFrame{

    private TitlePanel title_pane;
    private CipherPanel cipher_pane;
    private EncodePanel encode_pane;
    private InputPanel input_pane;
    private SubmitPanel submit_pane;
    
    private String coding;
    private String encrypt;
    private String text;
    private String key;
    
    
    public EnigmaFrame() throws HeadlessException {
        setBackground(Color.WHITE);
        setTitle("Cypher Machine");
        setDefaultCloseOperation((JFrame.EXIT_ON_CLOSE));
        Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
        setLayout(new BorderLayout());
        pack();
        setSize((int) (screensize.width * .30), (int) (screensize.height * .50));
        title_pane = new TitlePanel();
        add(title_pane, BorderLayout.NORTH);
        encode_pane = new EncodePanel();
        add(encode_pane, BorderLayout.WEST);
        cipher_pane = new CipherPanel();
        add(cipher_pane, BorderLayout.CENTER);
        input_pane = new InputPanel();
        add(input_pane, BorderLayout.EAST);
        submit_pane = new SubmitPanel();
        add(submit_pane, BorderLayout.SOUTH);  
        setVisible(true);
        
    }
    
    public void varMan() {
        Boolean finished = false;
        int num = 1;
        System.out.println(submit_pane.getSubmitted());
        
       while(finished != true) {
           if(submit_pane.getSubmitted().equals("submit")) {
               finished = true;
           }
               System.out.println(num);
               num++;
       }
       
       System.out.println("DONE!");
        }
        
    public void setEnigmaValues() {
        
    }
    
    private class ButtonHandler implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent event) {
            
            System.out.println(event.getActionCommand());           

        }
    }
    
    }
    
  