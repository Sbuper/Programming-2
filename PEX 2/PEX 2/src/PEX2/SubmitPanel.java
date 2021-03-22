/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PEX2;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author Andrew
 */
public class SubmitPanel extends JPanel{
    private String submitted;
    private final JButton submit;
    
    public SubmitPanel() {
        
        setBackground(Color.WHITE);
        GridBagLayout gridbag = new GridBagLayout();
        GridBagConstraints c = new GridBagConstraints();
        setLayout(gridbag);
        c.fill = GridBagConstraints.HORIZONTAL;

        submit = new JButton("Submit");
        submit.setBackground(Color.white);
        submit.setActionCommand("submit");
        
        ButtonGroup cypher_choice = new ButtonGroup();

        cypher_choice.add(submit);
        Box choiceBox = Box.createHorizontalBox();
        choiceBox.add(submit, c);
        add(choiceBox);
        
        ButtonHandler myHandler = new ButtonHandler();
        submit.addActionListener(myHandler);
        setVisible(true);
    }

    public String getSubmitted() {
        return submitted;
    }

    public void setSubmitted(String submitted) {
        this.submitted = submitted;
    }
        
    
    
    private class ButtonHandler implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent event) {
            submitted = event.getActionCommand();
            setSubmitted(submitted);
        }
    }
    
}
