/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PEX4;

import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author Andrew
 */
public abstract class Tile extends JButton{
    public String name;
    public boolean bomb;
    public Character gameEnd;
    public ArrayList<ArrayList<Empty>> layout;
    
   // public abstract String namesay();
    
}
