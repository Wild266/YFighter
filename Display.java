import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.AffineTransform;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Display extends JPanel implements KeyListener
{
   private Image backgroundImage;
   private volatile int mode = 0; 

   private int yMin = 0;
   private int totalH = 1000;
   private boolean[][] buttons = new boolean[2][6];  
   
   private double s  = 2;
   private double j  = 20;
   private double mX = 10;
   private double g  = 1.5;
   private double f = 1.3;
   private double kf = 1.09;

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
      
   }
   
   public int getMode()
   { 
      return this.mode;
   }

   public int[] attackHitBox(Fighter f1)
   {
      int[] i = new int[4];

      Fighter.Attack b = f1.getAttack();

      if(f1.getRight()){
         i[0] = (int)(b.getPos()[0] + f1.getPos()[0]);        
      }else
      {
         i[0] = (int)(f1.getPos()[0] - b.getPos()[0] - b.getSize()[0] + f1.getSize());
      }
      i[1] = (int)(b.getPos()[1]+ f1.getPos()[1]);
      i[2] = b.getSize()[0];
      i[3] = b.getSize()[1];
      return i;
   }

   public void paint(Graphics g)
   {
      
      super.paint(g);
      g.drawImage(backgroundImage, 0, 0, null);
      
      if(mode == 0)
      {
         g.setColor(Color.magenta);
         g.setFont(new Font("Copperplate Gothic Bold", Font.BOLD, 50));
         g.drawString("Yeet Fighter",37,300);
         
         
         g.setColor(Color.gray);
         g.setFont(new Font("Impact", Font.ITALIC, 20));
         g.drawString("Press any key to start",700,550);
      }
      else if(mode == 1)
      {
         g.setColor(Color.white);
         g.fillRect(0,yMin, 1000, 10);
         g.setColor(Color.red);
         
         g.fillRect(10,10,(int)((dFs[0].getHealth()/totalH) * 465),10);
         g.fillRect(480,10,(int)((dFs[1].getHealth()/totalH) * 465),10);
         
         g.fillRect((int)dFs[0].getPos()[0],(int)dFs[0].getPos()[1],dFs[0].getSize(),dFs[0].getSize());

         if (dFs[0].getBlocking()) {
        	 g.setColor(Color.white);
        	 g.fillRect((int)dFs[1].getPos()[0]+10, (int)dFs[1].getPos()[1]+10, 30, 30);
         }  
         if(dFs[0].getAttacking() == 1){
            g.setColor(Color.red);
            //g.setColor(Color.green);
            
            int[] i = new int[4];
            i = attackHitBox(dFs[0]);

            g.fillRect(i[0],i[1],i[2],i[3]);
         }
         if (dFs[1].getBlocking()) {
        	 g.setColor(Color.white);
        	 g.fillRect((int)dFs[0].getPos()[0]+10, (int)dFs[0].getPos()[1]+10, 30, 30);
         }  
         g.setColor(Color.cyan);
         g.fillRect((int)dFs[1].getPos()[0],(int)dFs[1].getPos()[1],dFs[1].getSize(),dFs[1].getSize());
         if (dFs[0].getBlocking()) {
        	 g.setColor(Color.white);
        	 g.fillRect((int)dFs[1].getPos()[0]+10, (int)dFs[1].getPos()[1]+10, 30, 30);
         }
         
         if(dFs[1].getAttacking() == 1){
            g.setColor(Color.cyan);
            //g.setColor(Color.green);
            
            int[] i = new int[4];
            i = attackHitBox(dFs[1]);

            g.fillRect(i[0],i[1],i[2],i[3]);
         }

      }else if(mode == 2)
      {
    	  g.setFont(new Font("Agency FB", Font.BOLD, 30));
          g.setColor(Color.white);
          g.drawString("Developed By Joseph Rother & Akshan Sameullah",470,570);
         if(dFs[0].getHealth() > 0)
         {
            g.setFont(new Font("Agency FB", Font.BOLD, 190));
            g.setColor(Color.red);
            g.drawString("Red Wins",360,200);
            
            
            Graphics2D g2 = (Graphics2D) g;
            AffineTransform at = new AffineTransform();
            at.setToRotation(Math.toRadians(270), 440, 380);
            g2.setTransform(at);
            g2.setColor(Color.magenta);
            g2.setFont(new Font("Magneto", Font.BOLD, 170));
            g2.drawString("Game",250,80);
            g2.drawString("Over",300,250);
         }else
         {
            g.setFont(new Font("Magneto", Font.BOLD, 200));
            g.setColor(Color.magenta);
            g.drawString("Game",270,180);
            g.drawString("Over",320,380);

            Graphics2D g2 = (Graphics2D) g;
            AffineTransform at = new AffineTransform();
            at.setToRotation(Math.toRadians(270), 440, 380);
            g2.setTransform(at);
            g2.setColor(Color.cyan);
            g2.setFont(new Font("Agency FB", Font.BOLD, 170));
            g2.drawString("Blue Wins",250,130);
         }
         
      }
      
      g.dispose();
   }
   
   @Override
   public void keyTyped(KeyEvent e)
   {   
   }

   @Override
   public void keyPressed(KeyEvent e)
   {
      if (mode == 0){
         mode = 1;
      }else 
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
         if(e.getKeyChar() == '/')
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
         if(e.getKeyChar() == 'g')
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
         if(e.getKeyChar() == '/')
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
         if(e.getKeyChar() == 'g')
         {
            buttons[1][5] = false;
         }
      }
   }

   public Fighter[] loadGame(Platform p)
   {
      yMin = p.getY();
      Fighter fs[] = new Fighter[2];
      int s = 50;
      fs[0] = new Fighter(totalH,0,10,s);
      fs[1] = new Fighter(totalH,1000,10,s);
      mode = 1;
      return fs;
   }
   
   public boolean[][] getInputs()
   {
      return buttons;
   }

   public Fighter[] update(Fighter[] fs, Platform plat, boolean[][] inputs)
   {
      setAttacking(fs[0],plat,inputs[0]);
      setAttacking(fs[1],plat,inputs[1]);

      incrementAttack(fs[0],fs[1]);
      incrementAttack(fs[1],fs[0]);
      
      if(fs[0].getAttacking() != 1)
      {
         setVels(fs[0],inputs[0],plat);
      }
      if(fs[1].getAttacking() != 1)
      {
         setVels(fs[1],inputs[1],plat);
      }

      fs[0].setPos(fs[0].getPos()[0] + fs[0].getKnockBackVel()[0],fs[0].getPos()[1] + fs[0].getKnockBackVel()[1]);
      fs[1].setPos(fs[1].getPos()[0] + fs[1].getKnockBackVel()[0],fs[1].getPos()[1] + fs[1].getKnockBackVel()[1]);

      fs[0].setKnockBackVel(fs[0].getKnockBackVel()[0]/kf, fs[0].getKnockBackVel()[1]/kf);
      fs[1].setKnockBackVel(fs[1].getKnockBackVel()[0]/kf, fs[1].getKnockBackVel()[1]/kf);

      bringAbove(fs[0], plat);
      bringAbove(fs[1], plat);

      bringBack(fs[0]);
      bringBack(fs[1]);
      
      return fs; 
   }

   public void setVels(Fighter f1,boolean[] inputs, Platform plat)
   {
      if (inputs[0] == true && f1.getPos()[1] == plat.getY()- f1.getSize())
      {
         f1.setMvmtVel(f1.getMvmtVel()[0],  -j);
      }
      if (inputs[3] == true)
      {
         f1.setRight(true);
         if (f1.getMvmtVel()[0] < 0){
            f1.setMvmtVel(s, f1.getMvmtVel()[1]);
         }
         else{
            f1.setMvmtVel(f1.getMvmtVel()[0] + s, f1.getMvmtVel()[1]);
         }
         
      }
      else if (inputs[1] == true)
      {
         f1.setRight(false);
         if (f1.getMvmtVel()[0] > 0){
            f1.setMvmtVel(-s, f1.getMvmtVel()[1]);
         }
         else{
            f1.setMvmtVel(f1.getMvmtVel()[0] - s, f1.getMvmtVel()[1]);
         }
      }

      f1.setPos(f1.getPos()[0] + f1.getMvmtVel()[0],f1.getPos()[1] + f1.getMvmtVel()[1]);
      f1.setMvmtVel(f1.getMvmtVel()[0]/f, f1.getMvmtVel()[1] + g);


   }

   public void bringAbove(Fighter f1, Platform plat)
   {
      if(f1.getPos()[1] + f1.getSize() > plat.getY())
      {
         f1.setPos(f1.getPos()[0],plat.getY() - f1.getSize());
         f1.setMvmtVel(f1.getMvmtVel()[0], 0);
         f1.setKnockBackVel(f1.getKnockBackVel()[0], 0);
         
      }
   }

   public void bringBack(Fighter f1)
   {
      if(f1.getPos()[0] + f1.getSize() > 950)
      {
         f1.setPos(950 - f1.getSize(),f1.getPos()[1]);
         f1.setMvmtVel(0,f1.getMvmtVel()[1]);
         f1.setKnockBackVel(0,f1.getKnockBackVel()[1]);
         
      }
      if(f1.getPos()[0] < 0)
      {
         f1.setPos(0,f1.getPos()[1]);
         f1.setMvmtVel(0,f1.getMvmtVel()[1]);
         f1.setKnockBackVel(0,f1.getKnockBackVel()[1]);
         
      }
   }

   public void setAttacking (Fighter f1 , Platform plat, boolean[] inputs)
   {

    	  f1.setBlocking(inputs[5]);
    	  if (inputs[4] == true)
      {
         if(f1.getAttacking() == 0)
         {
            Fighter.Attack b;

            if(f1.getPos()[1] + f1.getSize() < plat.getY())
            {
               if(inputs[2] == true)
               {
                  b = f1.new AirDown();
               }else if(inputs[1] == true || inputs[3] == true)
               {
                  b = f1.new AirDirection();                  
               }else
               {
                  b = f1.new AirNeutral();
               }
            }else
            {  
               if(inputs[2] == true)
               {
                  b = f1.new BasicUp();
               }else if(inputs[1] == true || inputs[3] == true)
               {
                  b = f1.new BasicDirection();
               }else
               {
                  b = f1.new BasicNeutral();
               }
            }

            f1.setAttack(b);
            f1.setAttacking(1);
         }
      }
      
   }

   public void incrementAttack(Fighter f1, Fighter f2)
   {
     
	   if(f1.getAttacking() == 1)
      {
         if(f1.getAttackT() == 5)
         {
            int[] i = new int[4];
            i = attackHitBox(f1);
            
            if ( i[0] <= f2.getPos()[0] + f2.getSize() && i[0] + i[2] >= f2.getPos()[0] && i[1] <= f2.getPos()[1] + f2.getSize() && i[1] + i[3] >= f2.getPos()[1])
            {
               if (!f1.getBlocking()) {
            	f2.setHealth(f2.getHealth() - f1.getAttack().getDamage());
               } else {
            	   f2.setHealth(f2.getHealth());
               }
               if(f1.getRight() == true){
                  f2.setKnockBackVel(f1.getAttack().getKnockBack()[0],f1.getAttack().getKnockBack()[1]);
               }else
               {
                  f2.setKnockBackVel(-f1.getAttack().getKnockBack()[0],f1.getAttack().getKnockBack()[1]);
               }
            }
            f1.setAttackT(0);
            f1.setAttacking(2);
         }else
         {
            f1.setAttackT(f1.getAttackT() + 1);
         }
      }

      if(f1.getAttacking() == 2)
      {
         if(f1.getAttackT() == f1.getAttack().getTime())
         {
            f1.setAttackT(0);
            f1.setAttacking(0);
         }
         else
         {
            f1.setAttackT(f1.getAttackT() + 1);
         }
      }
   }

   public void draw(Fighter[] fs)
   {
      this.dFs = fs;       
      repaint();
   }
   
   public void endGame(Fighter[] fs)
   {
       mode = 2;
   } 

}