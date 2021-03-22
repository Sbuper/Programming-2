package test;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JFrame;


public class Test extends JFrame{

  public static void main(String[] a){
    Test f = new Test();
    f.setSize(800,800);
    f.setVisible(true);
  }
  
  
  public void paint(Graphics g) {
    g.setColor(Color.orange);
    g.drawArc(200, 150, 400, 400, 0, 360);
    g.fillArc(300, 280, 30, 30, 0, 360);
    g.fillArc(450, 280, 30, 30, 0, 360);
    g.drawArc(300, 350, 190, 100, 180, 180);
  }
  
}