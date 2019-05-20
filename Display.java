import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Display extends Thread,JPanel implements ActionListener ,KeyListener
{
   private Image backgroundImage;
   private int mode = 0; 

   private int yMin = 0;
   
   private boolean[][] buttons = new boolean[2][6];
   private boolean right = false;
   private boolean left = false;
   private boolean up = false;
   private boolean down = false;
   private Timer timer;
   

   private Fighter[] dFs = new Fighter[2];


   public Display()
   {
      addKeyListener(this);
      setFocusable(true);
      setFocusTraversalKeysEnabled(false);
      
      try {
         backgroundImage = ImageIO.read(new File("space.jpg"));
      } 
      catch (Exception e) {
         System.out.println("Image not found");
      }
      
   
      timer = new Timer(8, this);
      timer.start();
   }

   public void paint(Graphics g)
   {
      
      super.paint(g);
      g.drawImage(backgroundImage, 0, 0, null);
      if(mode == 0)
      {
         g.setColor(Color.red);
         g.setFont(new Font("serif", Font.BOLD, 30));
         g.drawString("Yeet Fighter",100,100);
      }
      else if(mode == 1)
      {
         g.setColor(Color.white);
         g.fillRect(0,yMin, 1000, 10);
         double[] p1 = dFs[0].getHitBox();
         double[] p2 = dFs[1].getHitBox();
         g.fillRect((int)p1[0],(int)p1[1],(int)(p1[3] - p1[0]),dFs[0].getSize());
         g.setColor(Color.blue);
         g.fillRect((int)p2[0],(int)p2[1],(int)(p2[3] - p2[0]),dFs[1].getSize());
      
      } 
      g.dispose();
   }

   @Override
   public void actionPerformed(ActionEvent e)
   {
      timer.start();        
      repaint();
   }


   
   @Override
   public void keyTyped(KeyEvent e)
   {
      
   }

   @Override
   public void keyPressed(KeyEvent e)
   {
      if(mode == 1)
      {
         if(e.getKeyChar() == 'w')
         {
            buttons[0][0] = true;
         }
         if(e.getKeyChar() == 'a')
         {
            buttons[0][1] = true;
         }
         if(e.getKeyChar() == 's')
         {
            buttons[0][2] = true;
         }
         if(e.getKeyChar() == 'd')
         {
            buttons[0][3] = true;
         }
         if(e.getKeyChar() == 'f')
         {
            buttons[0][4] = true;
         }
         if(e.getKeyChar() == 'g')
         {
            buttons[0][5] = true;
         }
         if(e.getKeyCode() == KeyEvent.VK_UP)
         {
            buttons[1][0] = true;
         }
         if(e.getKeyCode() == KeyEvent.VK_LEFT)
         {
            buttons[1][1] = true;
         }
         if(e.getKeyCode() == KeyEvent.VK_DOWN)
         {
            buttons[1][2] = true;
         }
         if(e.getKeyCode() == KeyEvent.VK_RIGHT)
         {
            buttons[1][3] = true;
         }
         if(e.getKeyChar() == '.')
         {
            buttons[1][4] = true;
         }
         if(e.getKeyChar() == '/')
         {
            buttons[1][5] = true;
         }
      }
   }

   @Override
   public void keyReleased(KeyEvent e)
   {
      if(mode == 1)
      {
         if(e.getKeyChar() == 'w')
         {
            buttons[0][0] = false;
         }
         if(e.getKeyChar() == 'a')
         {
            buttons[0][1] = false;
         }
         if(e.getKeyChar() == 's')
         {
            buttons[0][2] = false;
         }
         if(e.getKeyChar() == 'd')
         {
            buttons[0][3] = false;
         }
         if(e.getKeyChar() == 'f')
         {
            buttons[0][4] = false;
         }
         if(e.getKeyChar() == 'g')
         {
            buttons[0][5] = false;
         }
         if(e.getKeyCode() == KeyEvent.VK_UP)
         {
            buttons[1][0] = false;
         }
         if(e.getKeyCode() == KeyEvent.VK_LEFT)
         {
            buttons[1][1] = false;
         }
         if(e.getKeyCode() == KeyEvent.VK_DOWN)
         {
            buttons[1][2] = false;
         }
         if(e.getKeyCode() == KeyEvent.VK_RIGHT)
         {
            buttons[1][3] = false;
         }
         if(e.getKeyChar() == '.')
         {
            buttons[1][4] = false;
         }
         if(e.getKeyChar() == '/')
         {
            buttons[1][5] = false;
         }
      }
   }

  
   public Fighter[] loadGame(Platform p)
   {
      yMin = p.getY();
      Fighter fs[] = new Fighter[2];
      System.out.println("loading Game");
      int h = 100;
      int s = 50;
      fs[0] = new Fighter(h,10,10,s);
      fs[1] = new Fighter(h,1,1,s);
      mode = 1;
      return fs;
   }
   /*
   public boolean[] getInputs()
   {
       boolean out[] = new boolean[1];
       System.out.println("getting inputs");
       return out;
   }
   */
   public Fighter[] update(Fighter[] fs, Platform plat, boolean[] inputs)
   {
      double s = .00007;
      if (buttons[0][0] == true)
      {
         fs[0].setPos(fs[0].getHitBox()[0],fs[0].getHitBox()[1]-s);
      }
      if (buttons[0][1] == true)
      {
         fs[0].setPos(fs[0].getHitBox()[0]-s,fs[0].getHitBox()[1]);
      }
      if (buttons[0][2] == true)
      {
         fs[0].setPos(fs[0].getHitBox()[0],fs[0].getHitBox()[1]+s);
      }
      if (buttons[0][3] == true)
      {
         fs[0].setPos(fs[0].getHitBox()[0]+s,fs[0].getHitBox()[1]);
      }
      
      if (buttons[1][0] == true)
      {
         fs[1].setPos(fs[1].getHitBox()[0],fs[1].getHitBox()[1]-s);
      }
      if (buttons[1][1] == true)
      {
         fs[1].setPos(fs[1].getHitBox()[0]-s,fs[1].getHitBox()[1]);
      }
      if (buttons[1][2] == true)
      {
         fs[1].setPos(fs[1].getHitBox()[0],fs[1].getHitBox()[1]+s);
      }
      if (buttons[1][3] == true)
      {
         fs[1].setPos(fs[1].getHitBox()[0]+s,fs[1].getHitBox()[1]);
      }
      
      /*
      System.out.println("moving fighters");
      System.out.println("putting fighters above platform");
      System.out.println("all players are above " + plat.getY());
      System.out.println("incrementing buffers");
      System.out.println("setting players to attacking, blocking, or neither");
      System.out.println("checking player hitboxes with attack hitboxes");
      System.out.println("setting new player healths");
      //fs[0].setHealth(fs[0]);
      */
      
      if(fs[0].getHitBox()[1] + fs[0].getSize() > plat.getY())
      {
         fs[0].setPos(fs[0].getHitBox()[0],plat.getY() - fs[0].getSize());
         
      }
      if(fs[1].getHitBox()[1] + fs[1].getSize() > plat.getY())
      {
         fs[1].setPos(fs[1].getHitBox()[0],plat.getY() - fs[1].getSize());
         
      }
      return fs; 
   
   }
   
   public void draw(Fighter[] fs)
   {
      this.dFs = fs;
   }
   /*
   public void endGame(Fighter[] fs)
   {
       System.out.println("displaying winner");
       System.out.println("waiting for end button");
       System.out.println("end button is pressed");
   } 
   */
}