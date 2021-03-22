/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PEX4;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import javafx.scene.control.Alert;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


/**
 *
 * @author Andrew
 */
import java.util.Random;
public class Board extends JFrame{
private Tile tile;
private MusicPlayer song;
private BufferedImage img;
private Empty labal;
private Character ok = 'N';
private String gameOver;

    public Board(String difficulty) {
        gameOver = "F";
        setBackground(Color.WHITE);
        setTitle("PIK-SWEEPER!");
        setDefaultCloseOperation((JFrame.EXIT_ON_CLOSE));
        Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
        setSize((int) (screensize.width * .70), (int) (screensize.height * .70));
        //setResizable(false);
        JOptionPane.showMessageDialog(this, "(WARNING) Higher difficulties may take a while to load, so please be patient!"
                + "\nAlso, the game won't resize automatically for some reason, so you may have to adjust the size manually"
                 + "\nPress 'OK' to continue");

        ArrayList<Empty> tile = new ArrayList<>();
        ArrayList<ArrayList<Empty>> grid = new ArrayList<>();
        song = new MusicPlayer();
        switch (difficulty) {
            case "F": {
                setLayout(new GridLayout(3, 3));
                for (int i = 0; i < 3; i++) {
                    tile = new ArrayList<>();
                    for (int e = 0; e < 3; e++) {
                        tile.add(new Empty(i, e));
                        add(tile.get(e));
                    }
                    grid.add(tile);
                }
                for(int bomb = 0; bomb < 3; bomb++) {
                    Random bombspawn = new Random();
                    int a = bombspawn.nextInt(3);
                    int b = bombspawn.nextInt(3);
                    System.out.println("Bomb at: " + a + "-" + b);
                    grid.get(a).get(b).setBomb();
                    //Enable to see all bombs: grid.get(a).get(b).changeimg();
                    
                }
               // System.out.println("Total size: " + tile.size());
                
//                System.out.println(grid.get(0));
//                System.out.println(grid.get(1));
//                System.out.println(grid.get(2));
//                System.out.println(grid.get(1).get(0).namesay());
//                System.out.println(grid.get(1).get(1).namesay());
//                System.out.println(grid.get(1).get(2).namesay());
//                System.out.println(grid.get(2).get(0).namesay());
//                System.out.println(grid.get(2).get(1).namesay());
//                System.out.println(grid.get(2).get(2).namesay());

                
                song.setSong("../resources/music/Flower.wav");
                song.run("N");
                break;
            }
            case "E": {
                setLayout(new GridLayout(9, 9));
                for (int i = 0; i < 9; i++) {
                    tile = new ArrayList<>();
                    for (int e = 0; e < 9; e++) {
                        tile.add(new Empty(i, e));
                        add(tile.get(e));
                    }
                    grid.add(tile);
                }
                for(int bomb = 0; bomb < 10; bomb++) {
                    Random bombspawn = new Random();
                    int a = bombspawn.nextInt(9);
                    int b = bombspawn.nextInt(9);
                    System.out.println("Bomb at: " + a + "-" + b);
                    grid.get(a).get(b).setBomb();
                    //Enable to see all bombs: grid.get(a).get(b).changeimg();
                    
                }
                song.setSong("../resources/music/Easy.wav");
                song.run();
                break;
            }
            case "N": {
                setLayout(new GridLayout(16, 16));
                for (int i = 0; i < 16; i++) {
                    tile = new ArrayList<>();
                    for (int e = 0; e < 16; e++) {
                        tile.add(new Empty(i, e));
                        add(tile.get(e));
                    }
                    grid.add(tile);
                }
                for(int bomb = 0; bomb < 40; bomb++) {
                    Random bombspawn = new Random();
                    int a = bombspawn.nextInt(16);
                    int b = bombspawn.nextInt(16);
                    System.out.println("Bomb at: " + a + "-" + b);
                    grid.get(a).get(b).setBomb();
                   //Enable to see all bombs: grid.get(a).get(b).changeimg();
                    
                }
                song.setSong("../resources/music/Medium.wav");
                song.run("N");
                break;
            }
            case "H": {
                setLayout(new GridLayout(16, 30));
                for (int i = 0; i < 16; i++) {
                    tile = new ArrayList<>();
                    for (int e = 0; e < 30; e++) {
                        tile.add(new Empty(i, e));
                        add(tile.get(e));
                    }
                    grid.add(tile);
                }
                for(int bomb = 0; bomb < 99; bomb++) {
                    Random bombspawn = new Random();
                    int a = bombspawn.nextInt(16);
                    int b = bombspawn.nextInt(30);
                    System.out.println("Bomb at: " + a + "-" + b);
                    grid.get(a).get(b).setBomb();
                    //grid.get(a).get(b).changeimg();
                    
                }
                song.setSong("../resources/music/Hard.wav");
                song.run("N");

                break;
            }
            case "HU": {
                setLayout(new GridLayout(30, 30));
                for (int i = 0; i < 30; i++) {
                    tile = new ArrayList<>();
                    for (int e = 0; e < 30; e++) {
                        tile.add(new Empty(i, e));
                        add(tile.get(e));
                    }
                    grid.add(tile);
                }
                for(int bomb = 0; bomb < 400; bomb++) {
                    Random bombspawn = new Random();
                    int a = bombspawn.nextInt(30);
                    int b = bombspawn.nextInt(30);
                    System.out.println("Bomb at: " + a + "-" + b);
                    grid.get(a).get(b).setBomb();
                    
                }
                song.setSong("../resources/music/Bulbax Kingdom.wav");
                song.run("N");
                break;
            }
        }
        
        pack();
        setVisible(true);
        //Still can't figure out how to manage realtions properly between classes....
        //So, no winning or losing game functionalities
//        while(gameOver != "Y") {
//            for(int k = 0; k < grid.size(); k++) {
//                for(int j = 0; j < grid.get(k).size(); j++) {
//                    if(grid.get(k).get(j).isOver() == true) {
//                        gameOver = "Y";
//                    }
//                    else if(grid.get(k).get(j).gameEnd == 'S') {
//                    }
//                }
//            }
//        }
//        dispose();
    }
}
