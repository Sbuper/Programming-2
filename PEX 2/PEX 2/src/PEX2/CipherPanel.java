package PEX2;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

/**
 *
 * @author Andrew
 */
public class CipherPanel extends JPanel{

    public CipherPanel() {
        setBackground(Color.WHITE);
        GridBagLayout gridbag = new GridBagLayout();
        GridBagConstraints c = new GridBagConstraints();
        setLayout(gridbag);
        c.fill = GridBagConstraints.HORIZONTAL;
        
        JRadioButton caesarCypher = new JRadioButton("Caesar", false);
        caesarCypher.setBackground(Color.white);
        caesarCypher.setActionCommand("Caesar");
        
        JRadioButton subCypher = new JRadioButton("General Substitution", false);
        subCypher.setBackground(Color.white);
        subCypher.setActionCommand("General Substitution");
        
        JRadioButton rotateCypher = new JRadioButton("Rotating", false);
        rotateCypher.setBackground(Color.white);
        rotateCypher.setActionCommand("Rotating");
        
        JLabel panelTitle = new JLabel();
        panelTitle.setText("ENCRYPTION TYPE");
        panelTitle.setFont(new Font("Courier New", Font.BOLD, 17));
        
        ButtonGroup cypher_choice = new ButtonGroup();
        cypher_choice.add(caesarCypher);
        cypher_choice.add(subCypher);
        cypher_choice.add(rotateCypher);
        
        Box choiceBox = Box.createVerticalBox();
        choiceBox.add(panelTitle, c);
        choiceBox.add(caesarCypher, c);
        choiceBox.add(subCypher, c);
        choiceBox.add(rotateCypher, c);
        add(choiceBox);
        
        setVisible(true);
    }
    
    
    //public String getInput() {
        
    //return (cipher_choice.getSelection().getActionCommands());
    
    //}
    
}
