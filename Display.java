import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Display extends JPanel implements ActionListener ,KeyListener
{
   private Image backgroundImage;
   private int mode = 0; 

   private int yMin = 0;
   
   private boolean[][] buttons = new boolean[2][6];
  // private Timer timer;
   

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
      
   
      //timer = new Timer(12, this);
      //timer.start();
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
         g.setColor(Color.red);
         g.fillRect((int)dFs[0].getPos()[0],(int)dFs[0].getPos()[1],dFs[0].getSize(),dFs[0].getSize());
         g.setColor(Color.blue);
         g.fillRect((int)dFs[1].getPos()[0],(int)dFs[1].getPos()[1],dFs[1].getSize(),dFs[1].getSize());
      
      } 
      g.dispose();
   }

   @Override
   public void actionPerformed(ActionEvent e)
   {

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
   
   public boolean[][] getInputs()
   {
      return buttons;
   }

   public Fighter[] update(Fighter[] fs, Platform plat, boolean[][] inputs)
   {
      double s  = 2;
      double j  = 20;
      double mX = 10;
      double g  = 1.5;
      double f = 1.15;
      double kf = 1.09;

      if (inputs[0][0] == true && fs[0].getPos()[1] == plat.getY()- fs[0].getSize())
      {
         fs[0].setMvmtVel(fs[0].getMvmtVel()[0],  -j);
      }
      if (inputs[0][3] == true)
      {
         if (fs[0].getMvmtVel()[0] < 0){
            fs[0].setMvmtVel(s, fs[0].getMvmtVel()[1]);
         }
         else{
            fs[0].setMvmtVel(fs[0].getMvmtVel()[0] + s, fs[0].getMvmtVel()[1]);
         }
         
      }
      else if (inputs[0][1] == true)
      {
         if (fs[0].getMvmtVel()[0] > 0){
            fs[0].setMvmtVel(-s, fs[0].getMvmtVel()[1]);
         }
         else{
            fs[0].setMvmtVel(fs[0].getMvmtVel()[0] - s, fs[0].getMvmtVel()[1]);
         }
      }
      
      
      if (inputs[1][0] == true && fs[1].getPos()[1] == plat.getY() - fs[1].getSize())
      {
         fs[1].setMvmtVel(fs[1].getMvmtVel()[0], -j);
      }
      if (inputs[1][1] == true)
      {
         if (fs[1].getMvmtVel()[0] > 0){
            fs[1].setMvmtVel(-s, fs[1].getMvmtVel()[1]);
         }
         else{
            fs[1].setMvmtVel(fs[1].getMvmtVel()[0] - s, fs[1].getMvmtVel()[1]);
         }
         
      }
      else if (inputs[1][3] == true)
      {
         if (fs[1].getMvmtVel()[0] < 0){
            fs[1].setMvmtVel(s, fs[1].getMvmtVel()[1]);
         }
         else{
            fs[1].setMvmtVel(fs[1].getMvmtVel()[0] + s, fs[1].getMvmtVel()[1]);
         }
      }

      if (inputs[0][4] == true)
      {
         fs[1].setMvmtVel(0, 0);
         fs[1].setKnockBackVel(30,-30);
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

      if(fs[0].getMvmtVel()[0] > mX)
      {
         fs[0].setMvmtVel(mX, fs[0].getMvmtVel()[1]);
      }
      if(fs[1].getMvmtVel()[0] > mX)
      {
         fs[1].setMvmtVel(mX, fs[1].getMvmtVel()[1]);
      }
      if(fs[0].getMvmtVel()[0] < -mX)
      {
         fs[0].setMvmtVel(-mX, fs[0].getMvmtVel()[1]);
      }
      if(fs[1].getMvmtVel()[0] < -mX)
      {
         fs[1].setMvmtVel(-mX, fs[1].getMvmtVel()[1]);
      }

      fs[0].setPos(fs[0].getPos()[0] + fs[0].getMvmtVel()[0] + fs[0].getKnockBackVel()[0],fs[0].getPos()[1] + fs[0].getMvmtVel()[1] + fs[0].getKnockBackVel()[1]);
      fs[1].setPos(fs[1].getPos()[0] + fs[1].getMvmtVel()[0] + fs[1].getKnockBackVel()[0],fs[1].getPos()[1] + fs[1].getMvmtVel()[1] + fs[1].getKnockBackVel()[1]);

      fs[0].setMvmtVel(fs[0].getMvmtVel()[0]/f, fs[0].getMvmtVel()[1] + g);
      fs[1].setMvmtVel(fs[1].getMvmtVel()[0]/f, fs[1].getMvmtVel()[1] + g);

      fs[0].setKnockBackVel(fs[0].getKnockBackVel()[0]/kf, fs[0].getKnockBackVel()[1]/kf);
      fs[1].setKnockBackVel(fs[1].getKnockBackVel()[0]/kf, fs[1].getKnockBackVel()[1]/kf);

      
      
      if(fs[0].getPos()[1] + fs[0].getSize() > plat.getY())
      {
         fs[0].setPos(fs[0].getPos()[0],plat.getY() - fs[0].getSize());
         fs[0].setMvmtVel(fs[0].getMvmtVel()[0], 0);
         fs[0].setKnockBackVel(fs[0].getKnockBackVel()[0], 0);
         
      }
      if(fs[1].getPos()[1] + fs[1].getSize() > plat.getY())
      {
         fs[1].setPos(fs[1].getPos()[0],plat.getY() - fs[1].getSize());
         fs[1].setMvmtVel(fs[1].getMvmtVel()[0], 0);
         fs[1].setKnockBackVel(fs[1].getKnockBackVel()[0], 0);fs[1].setKnockBackVel(fs[1].getKnockBackVel()[0], 0);
         
      }
      return fs; 
   
   }
   
   public void draw(Fighter[] fs)
   {
      this.dFs = fs;
      //timer.start();        
      repaint();
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