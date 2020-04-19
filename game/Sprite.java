/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.awt.Image;


public abstract class Sprite {
    
    private boolean isMovingHorizontally = false;
    private boolean isMovingVertically = false;
    
    abstract int[] getPosition();
    abstract int getHealth();
    abstract int[] getVelocity();
    abstract Image getImage();
 
    
    double minimumDistance(Sprite other)
    {
        int x = this.getImage().getWidth(null)/2 + other.getImage().getWidth(null)/2;
        int y = this.getImage().getHeight(null)/2 + other.getImage().getHeight(null)/2;
        double c = Math.pow((Math.pow(x,2) + Math.pow(y, 2)), 0.5) - 10;
        return c;
    }
    
    int distanceX(Sprite other)
    {
        return other.getPosition()[0] + (other.getImage().getWidth(null)/2) - (this.getPosition()[0]+ (this.getImage().getWidth(null)/2));  
    }
    
    int distanceY(Sprite other)
    {
        return other.getPosition()[1] + (other.getImage().getHeight(null)/2) - (this.getPosition()[1]+ (this.getImage().getHeight(null)/2));
    }
    
    double getDistance(Sprite other)
    {
        int x =distanceX(other);
        
        //System.out.println(x + " X");
        
        int y = distanceY(other);
        //System.out.println(y + " Y");
        double c = Math.pow((Math.pow(x,2) + Math.pow(y, 2)), 0.5);
        //System.out.println("Distance "+ c);
        return c;
    }
    
    void horizontalCollition(Sprite other)
    {
        int x = distanceX(other);
        int deltaX = 0;
        if (x != 0)
        {
            deltaX = x/Math.abs(x);
        }
        this.getPosition()[0] = other.getPosition()[0] + (other.getImage().getWidth(null)/2) - (this.getImage().getWidth(null)/2) - (deltaX)*(this.getImage().getWidth(null)/2 + other.getImage().getWidth(null)/2);
    }
    
    void verticalCollition(Sprite other)
    {
        int y = distanceY(other);
        int deltaY = 0;
        if (y != 0)
        {
           deltaY = y/Math.abs(y);
        }
        
        this.getPosition()[1] = other.getPosition()[1] + (other.getImage().getHeight(null)/2) - (this.getImage().getHeight(null)/2) - (deltaY)*(this.getImage().getHeight(null)/2 + other.getImage().getHeight(null)/2);
    }
    
    void movingHorizontally(boolean mov)
    {
        isMovingHorizontally = mov;
    }
    
    void movingVertically(boolean mov)
    {
        isMovingVertically = mov;
    }
    
    boolean getMovingX()
    {
        return isMovingHorizontally;
    }
            
    boolean getMovingY()
    {
        return isMovingVertically;
    }
    
    public void avoidCollision(Sprite other)
    {
        int Xlimit = (this.getImage().getWidth(null)/2) + (other.getImage().getWidth(null)/2) - 3;
        int Ylimit = (this.getImage().getHeight(null)/2) + (other.getImage().getHeight(null)/2) - 3;
        
        
        if (this.isMovingHorizontally && other.isMovingHorizontally)
        {
            this.getVelocity()[0] = 0;
            other.getVelocity()[0] = 0;
            this.movingHorizontally(false);
            other.movingHorizontally(false);
        }
        if (this.isMovingVertically && other.isMovingVertically)
        {
            this.getVelocity()[1] = 0;
            other.getVelocity()[1] = 0;
            this.movingVertically(false);
            other.movingVertically(false);
        }
        else if ( Math.abs(this.distanceX(other)) < Xlimit &&  Math.abs(this.distanceY(other)) < Ylimit)
        {
            if (this.getMovingX() && this.getMovingY())
            {
                if (Math.abs(this.distanceX(other)) >  Math.abs(this.distanceY(other)))
                {
                    this.horizontalCollition(other);
                }
                else
                {
                    this.verticalCollition(other);
                }
            }
            else if (this.getMovingX())
            {
                this.horizontalCollition(other);
            }
            else if (this.getMovingY())
            {
                this.verticalCollition(other);
            }
        }
    }
    public void avoidSuperposition(Sprite other)
    {
        int Xlimit = (this.getImage().getWidth(null)/2) + (other.getImage().getWidth(null)/2) - 3;
        int Ylimit = (this.getImage().getHeight(null)/2) + (other.getImage().getHeight(null)/2) - 3;
        
        if ( Math.abs(this.distanceX(other)) < Xlimit &&  Math.abs(this.distanceY(other)) < Ylimit)
        {
                this.horizontalCollition(other);
                this.verticalCollition(other);
            
        }
    }
    
    public void updatePos()
    {
        this.getPosition()[0] += this.getVelocity()[0];
        this.getPosition()[1] += this.getVelocity()[1];
        
    }
    public void avoidLimits()
    {
        if (this.getPosition()[0] < 0) 
        {
            this.getPosition()[0] = 0;
            if (this instanceof Bullets)
            {
                this.getVelocity()[0] = -this.getVelocity()[0];
            }
                    
        }
        if (this.getPosition()[1] < 0) 
        {
            this.getPosition()[1] = 0;
            if (this instanceof Bullets)
            {
                this.getVelocity()[1] = -this.getVelocity()[1];
            }
        }
        if (this.getPosition()[0] > 1280 - this.getImage().getWidth(null)) 
        {
            this.getPosition()[0] = 1280 - this.getImage().getWidth(null);
            if (this instanceof Bullets)
            {
                this.getVelocity()[0] = -this.getVelocity()[0];
            }
        }
        if (this.getPosition()[1] > 720 - this.getImage().getHeight(null)-10) 
        {
            this.getPosition()[1] = 720 - this.getImage().getHeight(null)-10;
            if (this instanceof Bullets)
            {
                this.getVelocity()[1] = -this.getVelocity()[1];
            }
        }
    }
}
