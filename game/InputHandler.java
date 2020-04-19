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

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;

public class InputHandler extends JPanel implements  KeyListener {
    
        Tanks one;
        Tanks two;
    public InputHandler(Tanks one, Tanks two)
    {
        this.one = one;
        this.two = two;
        
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
    }

    public synchronized void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        //System.out.println(code);
        
        SwitcherOneA(code);
        SwitcherTwoA(code);
        
        
       
            
        
            
    }

    /**
     *
     * @param e
     */
    @Override
    public void keyTyped(KeyEvent e) 
    {
        
    }

    /**
     *
     * @param e
     */
    @Override
    public synchronized void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        //System.out.println(code);
        SwitcherOneB(code);
        SwitcherTwoB(code);
        
        
    }
    
    
    public void SwitcherTwoA(int code)
    {
        switch (code) 
        {
            case KeyEvent.VK_DOWN:
                two.getVelocity()[1] = 5;
                two.movingVertically(true);
                //velX = 0;
                break;
            case KeyEvent.VK_UP:
                two.getVelocity()[1] = -5;
                two.movingVertically(true);
                //velX = 0;
                break;
            case KeyEvent.VK_LEFT:
                //velY = 0;
                two.getVelocity()[0] = -5;
                two.movingHorizontally(true);
                break;
            case KeyEvent.VK_RIGHT:
                //velY = 0;
                two.getVelocity()[0] = 5;
                two.movingHorizontally(true);
                break;
        }
    }
    public void SwitcherOneA(int code)
    {
        switch (code)
        {
            case KeyEvent.VK_S:
                one.getVelocity()[1] = 5;
                one.movingVertically(true);
                break;
            case KeyEvent.VK_W:
                one.getVelocity()[1] = -5;
                one.movingVertically(true);
                break;
            case KeyEvent.VK_A:
                one.getVelocity()[0] = -5;
                one.movingHorizontally(true);
                break;
            case KeyEvent.VK_D:
                one.getVelocity()[0] = 5;
                one.movingHorizontally(true);
                break;
            case KeyEvent.VK_SPACE:
                one.releaseBullet();
                break;
        }
    }
    public void SwitcherTwoB(int code)
    {
        switch (code)
        {
            case KeyEvent.VK_DOWN:
                two.getVelocity()[1] = 0;
                two.movingVertically(false);
                //velX = 0;
                break;
            case KeyEvent.VK_UP:
                two.getVelocity()[1] = 0;
                two.movingVertically(false);
                //velX = 0;
                break;
            case KeyEvent.VK_LEFT:
                //velY = 0;
                two.getVelocity()[0] = 0;
                two.movingHorizontally(false);
                break;
            case KeyEvent.VK_RIGHT:
                //velY = 0;
                two.getVelocity()[0] = 0;
                two.movingHorizontally(false);
                break;
            case KeyEvent.VK_ENTER:
                two.releaseBullet();
                break;
        }
    }
    public void SwitcherOneB(int code)
    {
        switch (code)
        {
            case KeyEvent.VK_S:
                one.getVelocity()[1] = 0;
                one.movingVertically(false);
                //velX = 0;
                break;
            case KeyEvent.VK_W:
                one.getVelocity()[1] = 0;
                one.movingVertically(false);
                //velX = 0;
                break;
            case KeyEvent.VK_A:
                //velY = 0;
                one.getVelocity()[0] = 0;
                one.movingHorizontally(false);
                break;
            case KeyEvent.VK_D:
                //velY = 0;
                one.getVelocity()[0] = 0;
                one.movingHorizontally(false);
                break;
        }
    }


}
