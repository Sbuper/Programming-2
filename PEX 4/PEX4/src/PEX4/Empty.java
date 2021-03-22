/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PEX4;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 *
 * @author Andrew
 */
public class Empty extends Tile{

    public Empty(int x, int y) {
        String temp =  Integer.toString(x) + "," +  Integer.toString(y);
        name = temp;
        //System.out.println("Tile " + name + " was created");
        bomb = false;
            
        try 
        {
            
            BufferedImage img = ImageIO.read(getClass().getResource("/resources/images/Empty.png"));
            setIcon(new ImageIcon(img));
        } 
        catch (IOException ex) {}

        setBounds(100,100,100,100);
        
        ButtonHandler myHandler = new ButtonHandler();
        addActionListener(myHandler);
        setActionCommand("Button Pressed");
        MouseHandler mouseHandler = new MouseHandler();
        addMouseListener(mouseHandler);
        }

    public String namesay() {
        return name;
    }
    
    public void setBomb() {
        bomb = true;
    }    
    
    public void changeimg() {
        try {
                    BufferedImage img = ImageIO.read(getClass().getResource("/resources/images/Flag.png"));
                    setIcon(new ImageIcon(img));
                    //MusicPlayer song = new MusicPlayer();
                    //song.setSong("../resources/music/Bomb.wav");
                   // song.run("Y");
                } catch (IOException ex) {
                }
    }
    
//    public Boolean isOver() {
//        if(gameEnd == 'Y') {
//            return true;
//        }
//        else {
//            return false;
//        }
//    }
    
    
    private class ButtonHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent event) {
            //System.out.println(event.getActionCommand());
            //bomb = false;
           // System.out.println(bomb);
            if (bomb == true) {
                gameEnd = 'T';
                try {
                    BufferedImage img = ImageIO.read(getClass().getResource("/resources/images/Bomb.png"));
                    setIcon(new ImageIcon(img));
                    MusicPlayer song = new MusicPlayer();
                    song.setSong("../resources/music/Bomb.wav");
                    song.run("Y");
                    
                } catch (IOException ex) {
                }
            } 
            else {
                try {
                    gameEnd = 'S';
                    BufferedImage img = ImageIO.read(getClass().getResource("/resources/images/Background.png"));
                    setIcon(new ImageIcon(img));
                } catch (IOException ex) {
                }
            }
        }
    }
    private class MouseHandler implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent me) {
           
        }

        @Override
        public void mouseExited(MouseEvent me) {
            
        }

        @Override
        public void mouseEntered(MouseEvent me) {
            
        }

        @Override
        public void mousePressed(MouseEvent me) {
            //System.out.println(me.getModifiers());
            if(me.getModifiers() == 4) {
            try {
                    BufferedImage img = ImageIO.read(getClass().getResource("/resources/images/Flag.png"));
                    setIcon(new ImageIcon(img));
                } catch (IOException ex) {
                }
        } 
           
        }

        @Override
        public void mouseReleased(MouseEvent me) {
            
        }
       }
    

    }

