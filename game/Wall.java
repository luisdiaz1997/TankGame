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

import java.awt.Image;
import javax.swing.ImageIcon;

public class Wall extends Sprite
{
    private int[][] fixedWall = new int [40][40];
    private int[][] destWall = new int [40][40];
    private int health;
    private boolean destructable;
    private int numberOfWalls;
    private int[] velocity = new int[2];
    private int[] position = new int[2];
    private String direction = "";
    String sep = System.getProperty("file.separator");
    Image img = null;
    
    public Wall(boolean destructable, int posX, int posY)
    {
        this.destructable = destructable;
        this.position[0] = posX;
        this.position[1] = posY;
    }
    public Wall(boolean destructable, int numberOfWalls, String direction, int posX, int posY)
    {
        this(destructable, posX, posY);
        this.numberOfWalls = numberOfWalls;
        this.direction = direction;
        
    }
    public int getSize()
    {
        return numberOfWalls;
    }
    public String getDirection()
    {
        return direction;
    }
    public boolean getDestructable()
    {
        return destructable;
    }
    public int[][] getFixedWall() {
        return fixedWall;
    }

    public void setFixedWall(int[][] fixedWall) {
        this.fixedWall = fixedWall;
    }

    public int[][] getDestWall() {
        return destWall;
    }

    public void setDestWall(int[][] destWall) {
        this.destWall = destWall;
    }
    @Override
    int[] getPosition() 
    {
        
        return position;
    }

    @Override
    int getHealth() 
    {
         
        return health;
    }

    @Override
    int[] getVelocity() 
    {
        return velocity;
    }
   
    public Image getImage()
    {
        if (destructable == false)
        {
            img = new ImageIcon("images"+ sep +"Wall1.gif").getImage();
        }
        else
        {
            img = new ImageIcon("images"+ sep +"Wall2.gif").getImage();
        }
        return img;
    }
}
