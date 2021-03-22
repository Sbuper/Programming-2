package PEX2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Andrew
 */
public class TitlePanel extends JPanel{

    public TitlePanel() {
        setBackground(Color.WHITE);
        GridBagLayout gridbag = new GridBagLayout();
        GridBagConstraints c = new GridBagConstraints();
        setLayout(gridbag);
        c.fill = GridBagConstraints.HORIZONTAL;
        setSize((int) (4000), (int) (4000));
        JLabel titleLabel = new JLabel();
        titleLabel.setText("CIPHER MACHINE - TOP SECRET!!!");
        titleLabel.setFont(new Font("Courier New", Font.BOLD, 23));
                
        JLabel sorryLabel = new JLabel();
        sorryLabel.setText(" Could not figure out cross Panel/Frame communication, so buttons");
        sorryLabel.setFont(new Font("Courier New", Font.BOLD, 15));
        
        JLabel sorryLabel2 = new JLabel();
        sorryLabel2.setText(" and file inputs are disabled. Please use pop-up windows...");
        sorryLabel2.setFont(new Font("Courier New", Font.BOLD, 15));
        
        Box choiceBox = Box.createVerticalBox();
        choiceBox.add(titleLabel, c);
        choiceBox.add(sorryLabel, c);
        choiceBox.add(sorryLabel2, c);
        add(choiceBox);
        
        setVisible(true);
    }
    
}
