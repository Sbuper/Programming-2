package PEX2;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.Scanner;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

/**
 *
 * @author Andrew
 */
public class EncodePanel extends JPanel{

    public EncodePanel() {
        
        setBackground(Color.WHITE);
        GridBagLayout gridbag = new GridBagLayout();
        GridBagConstraints c = new GridBagConstraints();
        setLayout(gridbag);
        c.fill = GridBagConstraints.HORIZONTAL;
        
        JRadioButton decode = new JRadioButton("Decode", false);
        decode.setBackground(Color.white);
        decode.setActionCommand("decode");
        
        JRadioButton encode = new JRadioButton("Encode", false);
        decode.setBackground(Color.white);
        decode.setActionCommand("encode");
        
        JLabel panelTitle = new JLabel();
        panelTitle.setText("OPERATION TYPE");
        panelTitle.setFont(new Font("Courier New", Font.BOLD, 17));
        
        ButtonGroup encode_choice = new ButtonGroup();
        encode_choice.add(encode);
        encode_choice.add(decode);
        
        Box choiceBox = Box.createVerticalBox();
        choiceBox.add(panelTitle, c);
        choiceBox.add(encode, c);
        choiceBox.add(decode, c);
        add(choiceBox);
        
        setVisible(true);
        
                
    }
    
    //public String getInput() {
      //  return (encode_choice.getSelection().getActionCommands());
   // }
    
    
}
