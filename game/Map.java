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
import java.util.ArrayList;
import javax.swing.*;
public class Map extends JFrame
{
    static ArrayList<Sprite> arr = new ArrayList<Sprite>();
    static ArrayList<Tanks> tank = new ArrayList<Tanks>();
    static ArrayList<Bonus> bons = new ArrayList<Bonus>();
    static ArrayList<Bullets> buls = new ArrayList<Bullets>();
    static ArrayList<Wall> walls = new ArrayList<Wall>();
    private static int actions = 0;
       
    public Map(String input)
    {
        super(input);
        Tanks one = new Tanks(1);
        Tanks two = new Tanks(2);
        Wall wall1 = new Wall(false, 12, "RIGHT", 0, 128);
        Wall wall2 = new Wall(false, 9, "DOWN", 480, 0);
        Wall wall3 = new Wall(false, 11, "RIGHT", 608, 128);
        Wall wall4 = new Wall(false, 5, "DOWN", 1056, 0);
        Wall wall5 = new Wall(false, 1, "RIGHT", 768, 128);
        Wall wall6 = new Wall(false, 9, "DOWN", 928, 0);
        Wall wall7 = new Wall(false, 3, "DOWN", 352, 128);
        Wall wall8 = new Wall(false, 8, "RIGHT", 128, 224);
        Wall wall9 = new Wall(false, 8, "RIGHT", 608, 224);
        Wall wall10 = new Wall(false, 8, "RIGHT", 928, 256);
        Wall wall11 = new Wall(false, 4, "DOWN", 1152, 128);
        Wall wall12 = new Wall(false, 8, "RIGHT", 0, 384);
        Wall wall13 = new Wall(false, 8, "RIGHT", 416, 384);
        Wall wall14 = new Wall(false, 8, "DOWN", 768, 352);
        Wall wall15 = new Wall(false, 8, "RIGHT", 928, 352);
        Wall wall16 = new Wall(false, 3, "DOWN", 128, 512);
        Wall wall17 = new Wall(false, 4, "DOWN", 160, 576);
        Wall wall18 = new Wall(false, 6, "RIGHT", 192, 576);
        Wall wall19 = new Wall(false, 8, "RIGHT", 416, 480);
        Wall wall20 = new Wall(false, 4, "DOWN", 512, 576);
        Wall wall21 = new Wall(false, 6, "DOWN", 640, 512);
        Wall wall22 = new Wall(false, 8, "RIGHT", 768, 480);
        Wall wall23 = new Wall(false, 11, "RIGHT", 768, 576);
        Wall wall24 = new Wall(false, 7, "DOWN", 1120, 480);
        Wall wall25 = new Wall(true, 3, "RIGHT", 1184, 352);
        Wall wall26 = new Wall(true, 3, "RIGHT", 384, 128);
        Wall wall27 = new Wall(true, 3, "RIGHT", 384, 160);
        Wall wall28 = new Wall(true, 3, "RIGHT", 384, 192);
        Wall wall29 = new Wall(true, 3, "RIGHT", 384, 224);
        Wall wall30 = new Wall(true, 5, "RIGHT", 256, 384);
        Wall wall31 = new Wall(true, 3, "RIGHT", 512, 128);
        Wall wall32 = new Wall(true, 3, "RIGHT", 512, 160);
        Wall wall33 = new Wall(true, 3, "RIGHT", 512, 192);
        Wall wall34 = new Wall(true, 3, "RIGHT", 512, 224);
        Wall wall35 = new Wall(true, 3, "RIGHT", 672, 256);
        Wall wall36 = new Wall(true, 3, "RIGHT", 672, 288);
        Wall wall37 = new Wall(true, 3, "RIGHT", 672, 320);
        Wall wall38 = new Wall(true, 3, "RIGHT", 672, 352);
        Wall wall39 = new Wall(true, 3, "RIGHT", 672, 384);
        Wall wall40 = new Wall(true, 3, "RIGHT", 544, 576);
        Wall wall41 = new Wall(true, 3, "RIGHT", 992, 160);
        Wall wall42 = new Wall(true, 4, "RIGHT", 1152, 480);
        Wall wall43 = new Wall(true, 3, "RIGHT", 928, 384);
        Wall wall44 = new Wall(true, 3, "RIGHT", 928, 416);
        Wall wall45 = new Wall(true, 3, "RIGHT", 928, 448);
        createWalls(wall1);
        createWalls(wall2);
        createWalls(wall3);
        createWalls(wall4);
        createWalls(wall5);
        createWalls(wall6);
        createWalls(wall7);
        createWalls(wall8);
        createWalls(wall9);
        createWalls(wall10);
        createWalls(wall11);
        createWalls(wall12);
        createWalls(wall13);
        createWalls(wall14);
        createWalls(wall15);
        createWalls(wall16);
        createWalls(wall17);
        createWalls(wall18);
        createWalls(wall19);
        createWalls(wall20);
        createWalls(wall21);
        createWalls(wall22);
        createWalls(wall23);
        createWalls(wall24);
        createWalls(wall25);
        createWalls(wall26);
        createWalls(wall27);
        createWalls(wall28);
        createWalls(wall29);
        createWalls(wall30);
        createWalls(wall31);
        createWalls(wall32);
        createWalls(wall33);
        createWalls(wall34);
        createWalls(wall35);
        createWalls(wall36);
        createWalls(wall37);
        createWalls(wall38);
        createWalls(wall39);
        createWalls(wall40);
        createWalls(wall41);
        createWalls(wall42);
        createWalls(wall43);
        createWalls(wall44);
        createWalls(wall45);
        tank.add(one);
        tank.add(two);
        InputHandler s = new InputHandler(one, two);
        this.add(s);
    }
    
    public void run()
    {
        this.addPanel();
        this.setVisible(true);
    }
   
    public void addPanel ()
    {
        Drawer draw = new Drawer(arr);
        this.add(draw);
        
       
    }
    static public void fillArray()
    {
        arr.clear();
        
        for (Sprite a: bons)
        {
            arr.add(0, a);
        }
        for (Sprite a: tank)
        {
            arr.add(bons.size(),a);
        }
        for (Sprite a: buls)
        {
            arr.add(bons.size() + tank.size(),a);
        }
        for (Sprite a: walls)
        {
            arr.add(bons.size() + tank.size() + buls.size(), a);
        }
        actions++;
        
    }
    static public void createWalls(Wall e)
    {
        int adder[] = {0, 0};
        boolean destructible = e.getDestructable();
        int originalX = e.getPosition()[0];
        int originalY = e.getPosition()[1];
        switch(e.getDirection())
        {
                case ("UP"):
                    adder[1] = -32;
                    break;
                case ("DOWN"):
                    adder[1] = 32;
                    break;
                case ("LEFT"):
                    adder[0] = -32;
                    break;
                case ("RIGHT"):
                    adder[0] = 32;
                    break;
        }
        
        for (int i = 0; i < e.getSize(); i++)
        {
            Wall dummiWall = new Wall(destructible, originalX + (adder[0]*i), originalY + (adder[1]*i));
            
            walls.add(dummiWall);
            
        }
    
    }
    static public void Events()
    {
       if (actions % 2000 == 1000)
        {
            Bonus ran = new Bonus();
            ran.setPowerUp((int)(Math.random() *2));
            ran.getPosition()[0] = (int)(Math.random() * 1280) - ran.getImage().getWidth(null)/2;
            ran.getPosition()[1] = (int)(Math.random() * 720) - ran.getImage().getHeight(null)/2;
            bons.add(0, ran);
            arr.add(0, bons.get(0));
        }
       for (Sprite a: arr)
       {
           a.updatePos();
           a.avoidLimits();
       }
       int wallsSize = walls.size();
       int size = arr.size();
       //System.out.println(bons.size());
       //System.out.println(walls.size());
       //System.out.println(arr.size());
       for (int i = 0; i < size - wallsSize; i++)
       {
           
           for ( int j = 1 + i ; j < size ; j++)
           {
               Sprite a = arr.get(i);
               Sprite b = arr.get(j);
               double distance = a.getDistance(b);
               double minimum = a.minimumDistance(b);
               if (distance < minimum)
               {
                   
                   if (a instanceof Tanks)
                   {
                       if (b instanceof Tanks)
                       {
                           a.avoidCollision(b);
                           b.avoidCollision(a);   
                       }
                       else if (b instanceof Wall)
                       {
                           a.avoidCollision(b);
                       }
                       else if (b instanceof Bullets)
                       {
                           buls.remove(b);
                           ((Tanks) a).hit();
                           if (((Tanks) a).getTankID() != ((Bullets) b).getID())
                           {
                               Tanks c = tank.get(((Bullets) b).getID() - 1);
                               c.setScore(c.getScore() + 10);
                           }
                           else
                           {
                               ((Tanks)a).setScore(((Tanks) a).getScore() - 10);
                           }
                           
                       }
                   }
                   else if (a instanceof Bullets)
                   {
                       if (b instanceof Wall)
                       {
                           //System.out.println(arr.size());
                           buls.remove(a);
                           //System.out.println(arr.size());
                           if (((Wall) b).getDestructable())
                           {
                               walls.remove(b);
                           }
                       }
                   }
                   
                   else if (a instanceof Bonus)
                   {
                       if (b instanceof Tanks)
                       {
                           if (((Bonus) a).getPowerUp() == 1 )
                           {
                               ((Tanks) b).setHealth(b.getHealth() + 20);
                           }
                           else
                           {
                               ((Tanks) b).setShield(((Tanks) b).getShield() + 20);
                           }
                           bons.remove(a);
                       }
                       else if (b instanceof Wall)
                       {
                            a.avoidSuperposition(b);
                       }
                       else if (b instanceof Bonus)
                       {
                           a.avoidSuperposition(b);
                       }
                   }
                   
               }
           }
       }
    }
    
            
            
    
}