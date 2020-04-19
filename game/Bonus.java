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

public class Bonus extends Sprite
{
    private int powerUp;
    int shield;
    int health;
    private int[] velocity = new int[2];
    private int[] position = new int[2];
    String sep = System.getProperty("file.separator");
    Image img = null;

    public Bonus()
    {
        
    }
    public int getPowerUp() {
        return powerUp;
    }

    public void setPowerUp(int powerUp) {
        this.powerUp = powerUp;
    }

    public int getShield() {
        return shield;
    }

    public void setShield(int shield) {
        this.shield = shield;
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

    @Override
    Image getImage() 
    {
        if (powerUp == 0)
        {
            img = new ImageIcon("images"+ sep +"shield.png").getImage();
        }
        if (powerUp == 1)
        {
            img = new ImageIcon("images"+ sep +"heart.png   ").getImage();
        }
        return img;
    }
}