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
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;


public class Tanks extends Sprite {
    private int score;
    private int health;
    private int shield;
    private int tankID;
    private double angle;
    private int lives = 3;
    private int[] position = new int [2];
    private int[] velocity = {0 , 0};
    String sep = System.getProperty("file.separator");
    Image img = null;
    
    
    public Tanks(int id)
    {
        health = 100;
        shield = 0;
        score = 0;
        tankID = id;
        if (tankID == 1)
        {
           position[0] = 0;
           position[1] = 0; 
        }
        else
        {
            position[0] = 1280-70;
            position[1] = 720-70;
        }
        
    }
    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }
    public int getShield() {
        return shield;
    }

    public void setShield(int shield) {
        this.shield = shield;
    }

    public int getTankID() {
        return tankID;
    }

    public void setTankID(int tankID) {
        this.tankID = tankID;
    }

    public int[] getPosition() {
        return position;
    }

    public void setPosition(int[] position) {
        this.position = position;
    }

    public int[] getVelocity() {
        return velocity;
    }

    public void setVelocity(int[] velocity) {
        this.velocity = velocity;
    }
    
    public int getLives() {
        return lives;
    }

    public void setLives(int lives) {
        this.lives = lives;
    }
    
    public void hit()
    {
        if (shield >= 0)
        {
            health -= 20;
        }
        else
        {
            shield -= 20;
            health -= 5;
        }
    }
    public void releaseBullet()
    {
        Bullets a = new Bullets(tankID);
        a.getVelocity()[0] = (int)(10* Math.cos(angle));
        a.getVelocity()[1] = (int)(10* Math.sin(angle));
        a.getPosition()[0] = this.position[0] + (this.getImage().getWidth(null)/2) - (a.getImage().getWidth(null)/2);
        a.getPosition()[1] = this.position[1] + (this.getImage().getHeight(null)/2) - (a.getImage().getHeight(null)/2);
        a.getPosition()[0] += (6)*(a.getVelocity()[0]);
        a.getPosition()[1] += (6)*(a.getVelocity()[1]);
        
        Map.buls.add(a);
    }
  
    public void respawn(int tankID)
    {
        if (tankID == 1)
        {
           position[0] = 0;
           position[1] = 0; 
        }
        else
        {
            position[0] = 1280-70;
            position[1] = 720-70;
        }
        this.setHealth(100);
        this.setLives(this.getLives()-1);
    }

    public Image getImage(){
            if (img == null)
            {
                img = new ImageIcon("images"+ sep +"tank"+ this.getTankID() +"Right.png").getImage();
                angle = Math.atan2(velocity[1], velocity[0]);
                
            }
            //tank moves down right
            else if((this.getVelocity()[1]> 0)&&(this.getVelocity()[0] > 0 ))
            {
                angle = Math.atan2(velocity[1], velocity[0]);
                img = new ImageIcon("images"+ sep +"tank"+ this.getTankID() +"DR.png").getImage();
            }
            //tank moves up right
            else if((this.getVelocity()[1]< 0)&&(this.getVelocity()[0] > 0))
            {
                img = new ImageIcon("images"+ sep +"tank"+ this.getTankID() +"UR.png").getImage();
                angle = Math.atan2(velocity[1], velocity[0]);
            }
                
            //tank moves down left
            else if((this.getVelocity()[1] > 0)&&(this.getVelocity()[0]< 0))
            {
                img = new ImageIcon("images"+ sep +"tank"+ this.getTankID() +"DL.png").getImage();
                angle = Math.atan2(velocity[1], velocity[0]);
            }
            //tank moves up left
            else if((this.getVelocity()[0]< 0)&&(this.getVelocity()[1]<0))
            {
                img = new ImageIcon("images"+ sep +"tank"+ this.getTankID() +"UL.png").getImage();
                angle = Math.atan2( velocity[1], velocity[0]);
            }
            //tank moves down
            else if(this.getVelocity()[1] > 0)
            {
                img = new ImageIcon("images"+ sep +"tank"+ this.getTankID() +"Down.png").getImage();
                angle = Math.atan2(velocity[1], velocity[0]);
            }
            //tank moves left
            else if(this.getVelocity()[0]< 0)
            {
                img = new ImageIcon("images"+ sep +"tank"+ this.getTankID() +"Left.png").getImage();
                angle = Math.atan2(velocity[1] , velocity[0]);
            }
            
            //tank moves up
            else if(this.getVelocity()[1]<0)
            {        
                img = new ImageIcon("images"+ sep +"tank"+ this.getTankID() +"Up.png").getImage();
                angle = Math.atan2( velocity[1] , velocity[0]);
            }
            
            //tank moves right
            else if(this.getVelocity()[0] > 0)
            {
                img = new ImageIcon("images"+ sep +"tank"+ this.getTankID() +"Right.png").getImage();
                angle = Math.atan2( velocity[1] ,velocity[0]);
            }
            else if(this.getHealth()==0){
                img = new ImageIcon("images"+ sep +"Explosion_large.gif").getImage();
                img.flush();
              
                respawn(this.tankID);
            }
            return img;
    }    
    
    
}