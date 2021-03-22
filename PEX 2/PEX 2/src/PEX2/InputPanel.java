package PEX2;

import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.BufferedReader;
import java.io.FileReader;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.plaf.basic.BasicComboBoxUI;

/**
 *
 * @author Andrew
 */
public class InputPanel extends JPanel{

   private final JRadioButton fileInput, textInput;
   private final JTextField text;
   private final JTextField key;
   public String choice;
            
    public InputPanel() {
        setBackground(Color.WHITE.WHITE);
        GridBagLayout gridbag = new GridBagLayout();
        GridBagConstraints c = new GridBagConstraints();
        setLayout(gridbag);
        c.fill = GridBagConstraints.HORIZONTAL;
        
        fileInput = new JRadioButton("Use text from file", false);
        fileInput.setBackground(Color.white);
        fileInput.setActionCommand("file");
        
        textInput = new JRadioButton("Use text from below Box:", false);
        textInput.setBackground(Color.white);
        textInput.setActionCommand("text");
        
        text = new JTextField("");
        text.setColumns(17);
        
        key = new JTextField("");
        key.setColumns(17);
        
        JLabel keyTitle = new JLabel();
        keyTitle.setText("Cipher Key to use:");
        keyTitle.setFont(new Font("Courier New", Font.BOLD, 13));
        
        JLabel panelTitle = new JLabel();
        panelTitle.setText("INPUT");
        panelTitle.setFont(new Font("Courier New", Font.BOLD, 17));
        
        
        ButtonGroup input_choice = new ButtonGroup();
        input_choice.add(fileInput);
        input_choice.add(textInput);

        
              
        Box choiceBox = Box.createVerticalBox();
        choiceBox.add(panelTitle, c);
        choiceBox.add(fileInput, c);
        choiceBox.add(textInput, c);
        choiceBox.add(text, c);
        choiceBox.add(keyTitle, c);
        choiceBox.add(key, c);
        add(choiceBox);
        
        ButtonHandler myHandler = new ButtonHandler();
        fileInput.addActionListener(myHandler);
        textInput.addActionListener(myHandler);


        
        setVisible(true);
    }
    
    
    
    public String getFileCypher() {
        final JFileChooser file_choice = new JFileChooser();
        file_choice.showOpenDialog(fileInput);
        File file = file_choice.getSelectedFile();
        String userCypher = "!";
 
            try { 
                BufferedReader in = new BufferedReader(new FileReader(file));
            while ((userCypher = in.readLine()) != null) {
            return userCypher;
            }
            } catch(Exception e) {
                    System.out.println("Error reading File");
                    }
            return userCypher;

    }

    public void setChoice(String decision) {
        choice = decision;
        System.out.println(choice);
    }

    public String getChoice() {
        //System.out.println(choice);
        return choice;
    }
    
    
    private class ButtonHandler implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent event) {
            
            setChoice(event.getActionCommand());
            //System.out.println(getChoice());
            

        }
    }
    }

