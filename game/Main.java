/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author luisf
 */
package game;
import java.awt.Dimension;
import javax.swing.*;
public class Main
{
    public static void main(String[] args)
    {
        Map map = new Map("Tank Game");
       
        map.setPreferredSize(new Dimension(1280, 744));
        map.setMaximumSize(new Dimension(1280, 744));
        map.setMinimumSize(new Dimension(1280, 744));
        //map.pack();
        
        map.setResizable(false);
        
        map.run();
        
        map.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
           
        
    }
    
}
