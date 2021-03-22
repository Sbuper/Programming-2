package PEX4;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

/**
 *
 * @author Andrew
 */
public class TitlePanel extends JPanel {

    private Boolean kill = false;

    public TitlePanel() {

        setBackground(Color.BLACK);
        GridBagLayout gridbag = new GridBagLayout();
        GridBagConstraints c = new GridBagConstraints();
        setLayout(gridbag);
        c.fill = GridBagConstraints.HORIZONTAL;

        JRadioButton flower = new JRadioButton("Flower", false);
        flower.setBackground(Color.BLACK);
        flower.setForeground(Color.PINK);
        flower.setFont(new Font("Chiller", Font.PLAIN, 30));
        flower.setActionCommand("F");

        JRadioButton easy = new JRadioButton("Easy", false);
        easy.setBackground(Color.BLACK);
        easy.setForeground(Color.GREEN);
        easy.setFont(new Font("Chiller", Font.PLAIN, 30));
        easy.setActionCommand("E");

        JRadioButton normal = new JRadioButton("Normal", false);
        normal.setBackground(Color.BLACK);
        normal.setForeground(Color.YELLOW);
        normal.setFont(new Font("Chiller", Font.PLAIN, 30));
        normal.setActionCommand("N");

        JRadioButton hard = new JRadioButton("Hard", false);
        hard.setBackground(Color.BLACK);
        hard.setForeground(Color.RED);
        hard.setFont(new Font("Chiller", Font.PLAIN, 30));
        hard.setActionCommand("H");

        JRadioButton hardUP = new JRadioButton("Bulblax Kingdom", false);
        hardUP.setBackground(Color.BLACK);
        hardUP.setForeground(Color.orange);
        hardUP.setFont(new Font("Chiller", Font.PLAIN, 30));
        hardUP.setActionCommand("HU");

        ButtonGroup difficulty = new ButtonGroup();
        difficulty.add(flower);
        difficulty.add(easy);
        difficulty.add(normal);
        difficulty.add(hard);
        difficulty.add(hardUP);

        Box choiceBox = Box.createHorizontalBox();
        choiceBox.add(flower, c);
        choiceBox.add(easy, c);
        choiceBox.add(normal, c);
        choiceBox.add(hard, c);
        choiceBox.add(hardUP, c);
        add(choiceBox);

        ButtonHandler myHandler = new ButtonHandler();
        flower.addActionListener(myHandler);
        easy.addActionListener(myHandler);
        normal.addActionListener(myHandler);
        hard.addActionListener(myHandler);
        hardUP.addActionListener(myHandler);

        setVisible(true);
    }

    public Boolean killFrame() {
        try {
            wait(100000);
            //Honestly not sure why this method isn't
            //working unless I include either this random
            //useless try-catch or any random println...
            //Well, at least it works I geuss?
        } catch (Exception e) {

        }
        return kill;
    }

    private class ButtonHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent event) {
            new Board(event.getActionCommand());
            kill = true;
            System.out.println(kill);
        }
    }
}
