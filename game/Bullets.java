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

public class Bullets extends Sprite
{
    private int[] velocity = new int [2];
    private int[] position = new int [2];
    private final int damage = 10;
    private int health;
    private int id;
    String sep = System.getProperty("file.separator");
    Image img = null;
    public Bullets( int id)
    {
        this.id = id;
    }
    public int getID()
    {
        return id;
    }

    public int[] getVelocity()
    {
        return velocity;
    }

    public void setVelocity(int[] velocity)
    {
        this.velocity = velocity;
    }

    public int[] getPosition()
    {
        return position;
    }

    public void setPosition(int[] position)
    {
        this.position = position;
    }

    public int getDamage()
    {
        return damage;
    }
    
    public int getHealth()
    {
        return health;
    }
    
    public Image getImage(){
        if ((this.getVelocity()[1] > 0) && (this.getVelocity()[0] > 0)) {
            img = new ImageIcon("images" + sep + "rocketDR.png").getImage();
        } //tank 1 moves up right
        else if ((this.getVelocity()[1] < 0) && (this.getVelocity()[0] > 0)) {
            img = new ImageIcon("images" + sep + "rocketUR.png").getImage();
        } //tank 1 moves down left
        else if ((this.getVelocity()[1] > 0) && (this.getVelocity()[0] < 0)) {
            img = new ImageIcon("images" + sep + "rocketDL.png").getImage();
        } //tank 1 moves up left
        else if ((this.getVelocity()[0] < 0) && (this.getVelocity()[1] < 0)) {
            img = new ImageIcon("images" + sep + "rocketUL.png").getImage();
        } //tank 1 moves down
        else if (this.getVelocity()[1] > 0) {
            img = new ImageIcon("images" + sep + "rocketD.png").getImage();
        } //tank 1 moves left
        else if (this.getVelocity()[0] < 0) {
            img = new ImageIcon("images" + sep + "rocketL.png").getImage();
        } //tank 1 moves up
        else if (this.getVelocity()[1] < 0) {
            img = new ImageIcon("images" + sep + "rocketU.png").getImage();
        } else if (this.getVelocity()[0] > 0) {
            img = new ImageIcon("images" + sep + "rocketR.png").getImage();
        }
        return img;
        }
    
}