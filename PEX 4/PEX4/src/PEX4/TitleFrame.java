package PEX4;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Andrew
 */
public class TitleFrame extends JFrame{
    private TitlePanel title;
    private BufferedImage img;
    private MusicPlayer song;

    public TitleFrame() {
        setBackground(Color.BLACK);
        setTitle("PIK-Sweeper!");
        setDefaultCloseOperation((JFrame.EXIT_ON_CLOSE));
        //Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
        setLayout(new BorderLayout());
        pack();
        setSize(1000, 750);
        //setSize((int) (screensize.width * .50), (int) (screensize.height * .40));
        
        title = new TitlePanel();
        add(title, BorderLayout.SOUTH); 
        
        song = new MusicPlayer();
        song.setSong("../resources/music/Title.wav");
        song.run("N");
        try {
            img = ImageIO.read(getClass().getResource("/resources/images/Title.png"));
            
        } catch(IOException e) { 
            System.out.println("Image loading failed - " + e);
        }
        JLabel background = new JLabel(new ImageIcon(img));
        add(background, BorderLayout.NORTH);
        setVisible(true);
        setResizable(false);
        
        while(title.killFrame() == false) {
            
        }
        song.stopMusic();
        dispose();
    }
    

}
