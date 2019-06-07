import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.AffineTransform;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/** The JPanel that holds all of the calculations done for playing the game and drawing on the screen
*/
public class Display extends JPanel implements KeyListener
{
   private Image backgroundImage;                    // the image that is displayed behind all of the game
   private volatile int mode = 0;                    // the stage in the game it is in (0 = start screen, 1 = gameplay, 2 = end screen)

   private int yMin = 0;                             // the position of the platform
   private int totalH = 1000;                        // starting health of players
   private boolean[][] buttons = new boolean[2][6];  // array of whether or not each button is pressed
   
   private double s  = 2;                            // player's acceleration
   private double j  = 20;                           // the force at which the player jumps
   private double g  = 1.5;                          // the force of gravity
   private double f  = 1.3;                          // the force of friction/air resistance on the player
   private double kf = 1.09;                         // the rate at which knockback speed decreases

   private Fighter[] dFs = new Fighter[2];           // array of fighters used for drawing to the screen


   public Display()
   {
      
      addKeyListener(this); 
      setFocusable(true);
      setFocusTraversalKeysEnabled(false);
      
      try {
         backgroundImage = ImageIO.read(new File("space.jpg")); //sets the background image to "space.jpg"
      } 
      catch (Exception e) {
         System.out.println("Image not found");                 //there is no "space.jpg"
      }
    
   }

   /** Returns the current mode of the game.
   * @return mode The current state that the game is in
   */
   public int getMode()
   { 
      return this.mode;   // used at the beginning to check if the game has started yet
   }

   /** Returns the position (x,y), width, and height of the attack from a given fighter
   * @param f1 The fighter whose attack you want to find the hitbox of
   * @return box The current state that the game is in
   */
   public int[] attackHitBox(Fighter f1)
   {
      int[] box = new int[4];

      Fighter.Attack b = f1.getAttack();

      if(f1.getRight()){
         //if the player is facing right, the x position is normal
         box[0] = (int)(b.getPos()[0] + f1.getPos()[0]);    
      }else
      {
         //if the player is facing left, the x position is on the opposite side of the attack
         box[0] = (int)(f1.getPos()[0] - b.getPos()[0] - b.getSize()[0] + f1.getSize()); 
      }
      box[1] = (int)(b.getPos()[1]+ f1.getPos()[1]);
      box[2] = b.getSize()[0];
      box[3] = b.getSize()[1];

      return box;
   }

   /** Draws everything in the game onto the screen
   * @param g The graphics to which everything is drawn onto
   */
   public void paint(Graphics g)
   {
      
      super.paint(g);
      g.drawImage(backgroundImage, 0, 0, null);                            //Draws Background image in background of panel
      
      if(mode == 0)
      {
         g.setColor(Color.magenta);                                   
         g.setFont(new Font("Copperplate Gothic Bold", Font.BOLD, 50));
         g.drawString("Yeet Fighter",37,300);                              //Draws Title in magenta in font specified
         
         
         g.setColor(Color.gray);
         g.setFont(new Font("Impact", Font.ITALIC, 20));
         g.drawString("Press any key to start",700,550);                   //Draws prompt to start specification in gray in font specified
      }
      else if(mode == 1)
      {

         g.setColor(Color.white);
         g.fillRect(0,yMin, 1000, 10);                                        //rectangle platform is drawn
         Color healthbar1 = new Color(255-(int)((dFs[0].getHealth()/totalH) * 255),(int)((dFs[0].getHealth()/totalH) * 255),0);
         g.setColor(healthbar1);                                              
         g.fillRect(10,10,(int)((dFs[0].getHealth()/totalH) * 465),10);       // health bar is drawn with color in spectrum of red through green based on red fighter health
         Color healthbar2 = new Color(255-(int)((dFs[1].getHealth()/totalH) * 255),(int)((dFs[1].getHealth()/totalH) * 255),0);
         g.setColor(healthbar2);
         g.fillRect(480+(465-(int)((dFs[1].getHealth()/totalH) * 465)),10,(int)((dFs[1].getHealth()/totalH) * 465),10);       
         // health bar is drawn with color in spectrum of red through green based on red fighter health with x coordinates so that health bar moves away from center

         g.setColor(Color.red);
         
   
         if(dFs[0].getAttacking() == 2)
         {
            g.setColor(new Color(150, 0, 0)); //the fighter is drawn darker if they are in cooldown
         }else
         {
            g.setColor(new Color(255, 0, 0));
         }

         g.fillRect((int)dFs[0].getPos()[0],(int)dFs[0].getPos()[1],dFs[0].getSize(),dFs[0].getSize()); //red fighter is drawn
          //sets color of fighter to darker color if attack is in cooldown method else in norml state

         if(dFs[0].getAttacking() == 1)
         {
            g.setColor(Color.red);
            
            int[] i = new int[4];
            i = attackHitBox(dFs[0]);

            g.fillRect(i[0],i[1],i[2],i[3]); //draws the attack onto the screen
         }

         if(dFs[0].getBlocking() != 0)
         {
            if(dFs[0].getBlocking() == 1)
            {
               g.setColor(new Color(255, 255, 255)); //draws a white box if blocking
            }else
            {
               g.setColor(new Color(150, 150, 150)); //draws a gray box if in cooldown
            }
            g.fillRect((int) (dFs[0].getPos()[0] + 10) ,(int) (dFs[0].getPos()[1] + 10), dFs[0].getSize() -20 , dFs[0].getSize() - 20);   
            //draws square used to indicate blocking on fighter that is blocking and in color based on whether block is in active state
         }


         if(dFs[1].getAttacking() == 2)
         {
            g.setColor(new Color(0, 150, 150));
         }else
         {
            g.setColor(new Color(0, 255, 255));
         }

         g.fillRect((int)dFs[1].getPos()[0],(int)dFs[1].getPos()[1],dFs[1].getSize(),dFs[1].getSize()); //blue fighter is drawn
          //sets color of fighter to darker color if attack is in cooldown method else in norml state

         if(dFs[1].getAttacking() == 1)
         {
            g.setColor(new Color(0, 255, 255));
            
            int[] i = new int[4];
            i = attackHitBox(dFs[1]);

            g.fillRect(i[0],i[1],i[2],i[3]);
         }

         if(dFs[1].getBlocking() != 0)
         {
            if(dFs[1].getBlocking() == 1)
            {
               g.setColor(new Color(255, 255, 255));
            }else
            {
               g.setColor(new Color(150, 150, 150));
            }
            g.fillRect((int) (dFs[1].getPos()[0] + 10) ,(int) (dFs[1].getPos()[1] + 10), dFs[1].getSize() -20 , dFs[1].getSize() - 20);
            //draws square used to indicate blocking on fighter that is blocking and in color based on whether block is in active state
         }




      }else if(mode == 2)
      {
      
         g.setFont(new Font("Agency FB", Font.BOLD, 30));                        
          g.setColor(Color.white);
          g.drawString("Developed By Joseph Rother & Akshan Sameullah",200,570);          //draws author label with color white and specified font
          
         if(dFs[0].getHealth() > 0)
         {
            g.setFont(new Font("Agency FB", Font.BOLD, 190));
            g.setColor(Color.red);
            g.drawString("Red",500,200);
            g.drawString("Wins",500,400);                                              //Draws Red Wins in specified font and in red if Red wins
            
            
         }else
         {
            
            
            g.setColor(Color.cyan);
            g.setFont(new Font("Agency FB", Font.BOLD, 190));
            g.drawString("Blue",500,200);
            g.drawString("Wins",500,400);                                              //Draws Blue Wins in specified font if red health is 0
            
            
         }
         Graphics2D g2 = (Graphics2D) g;
            AffineTransform at = new AffineTransform();
            at.setToRotation(Math.toRadians(270), 440, 380);
            g2.setTransform(at);
            g2.setColor(Color.magenta);
            g2.setFont(new Font("Magneto", Font.BOLD, 170));
            g2.drawString("Game",250,80);
            g2.drawString("Over",300,250);                                 //draws game over in vertical position in font specified and in pink (same color as title)
      }
      
      g.dispose();
   }
   
   /** Is called when a key is typed
   * @param e The key that was typed
   */
   @Override
   public void keyTyped(KeyEvent e)
   {   
   }

   /** Is called when a key is pressed
   * @param e The key that was pressed
   */
   @Override
   public void keyPressed(KeyEvent e)
   {
      if (mode == 0){
         mode = 1;       //starts the game
      }

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

   /** Is called when a key is released
   * @param e The key that was released
   */
   @Override
   public void keyReleased(KeyEvent e)
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

   /** Sets values that are needed at the beginning of the game and creates the fighters that will be used in the game
   * @param p The main platform
   * @return fs An array of two fighters placed at opposite ends of the screeen
   */
   public Fighter[] loadGame(Platform p)
   {
      yMin = p.getY();                        //the value used to draw the platform
      Fighter fs[] = new Fighter[2];         
      int s = 50;                             //the size of the fighters: 50 pixels
      fs[0] = new Fighter(totalH,0,10,s);     //makes a fighter at 0,10
      fs[1] = new Fighter(totalH,1000,10,s);  //makes a fighter at 1000,10
      return fs;
   }

   /** Returns which buttons are pressed
   * @return buttons An array of booleans that contains whether or not each button is pressed
   */
   public boolean[][] getInputs()
   {
      return buttons;
   }

   /** Performs all of the calculations for each frame of the game. All movement, attacking, blocking, and other forces are applied here.
   * @param fs The two fighters
   * @param plat The main platform
   * @param inputs An array that contains the data of the button presses
   * @return fs The fighters after the calculations have been performed on them
   */
   public Fighter[] update(Fighter[] fs, Platform plat, boolean[][] inputs)
   {
      //check if the player is starting a block
      setBlocking(fs[0],inputs[0]);
      setBlocking(fs[1],inputs[1]);

      //increase the timers and change the state of the block
      incrementBlock(fs[0]);
      incrementBlock(fs[1]);

      //check if the player is starting an attack and set the attack
      setAttacking(fs[0],plat,inputs[0]);
      setAttacking(fs[1],plat,inputs[1]);

      //increase the timers, change the state of the attack, and deal damage/knockback to the other fighter
      incrementAttack(fs[0],fs[1]);
      incrementAttack(fs[1],fs[0]);
      
      //if they aren't currently attacking, change their velocity and move the fighter
      if(fs[0].getAttacking() != 1)
      {
         setVels(fs[0],inputs[0],plat);
      }
      if(fs[1].getAttacking() != 1)
      {
         setVels(fs[1],inputs[1],plat);
      }

      //moves them based on knockback
      fs[0].setPos(fs[0].getPos()[0] + fs[0].getKnockBackVel()[0],fs[0].getPos()[1] + fs[0].getKnockBackVel()[1]);
      fs[1].setPos(fs[1].getPos()[0] + fs[1].getKnockBackVel()[0],fs[1].getPos()[1] + fs[1].getKnockBackVel()[1]);

      //decreases knockback
      fs[0].setKnockBackVel(fs[0].getKnockBackVel()[0]/kf, fs[0].getKnockBackVel()[1]/kf);
      fs[1].setKnockBackVel(fs[1].getKnockBackVel()[0]/kf, fs[1].getKnockBackVel()[1]/kf);

      //brings the fighters above the platform
      bringAbove(fs[0], plat);
      bringAbove(fs[1], plat);

      //brings the fighters back onto the screen
      bringBack(fs[0]);
      bringBack(fs[1]);
      
      return fs; 
   }

   /** Moves the fighter based on inputs
   * @param f1 The fighter being moved
   * @param inputs An array that contains the data of the button presses
   * @param plat The main platform
   */
   public void setVels(Fighter f1,boolean[] inputs, Platform plat)
   {
      //if the fighter is on the ground and pressed the up button
      if (inputs[0] == true && f1.getPos()[1] == plat.getY()- f1.getSize())
      {
         //set the upward momentum to the jump force
         f1.setMvmtVel(f1.getMvmtVel()[0],  -j);
      }
      //if pressing the right button
      if (inputs[3] == true)
      {
         f1.setRight(true);
         //if it's moving left
         if (f1.getMvmtVel()[0] < 0){     
            f1.setMvmtVel(s, f1.getMvmtVel()[1]);                      //sets the horizontal momentum to s
         }
         else{
            f1.setMvmtVel(f1.getMvmtVel()[0] + s, f1.getMvmtVel()[1]); //sets the horizontal momentum to the current momentum + s
         }
         
      }

      //if pressing the left button
      else if (inputs[1] == true)
      {
         f1.setRight(false);
         //if it's moving right
         if (f1.getMvmtVel()[0] > 0){
            f1.setMvmtVel(-s, f1.getMvmtVel()[1]);                      //sets the horizontal momentum to -s
         }
         else{
            f1.setMvmtVel(f1.getMvmtVel()[0] - s, f1.getMvmtVel()[1]); //sets the horizontal momentum to the current momentum - s
         }
      }

      f1.setPos(f1.getPos()[0] + f1.getMvmtVel()[0],f1.getPos()[1] + f1.getMvmtVel()[1]); //changes the position based on their momentum
      f1.setMvmtVel(f1.getMvmtVel()[0]/f, f1.getMvmtVel()[1] + g);                        //decreases their momentum using friction and gravity


   }

   /** Moves the fighter above the platform
   * @param f1 The fighter being moved
   * @param plat The main platform
   */
   public void bringAbove(Fighter f1, Platform plat)
   {
      if(f1.getPos()[1] + f1.getSize() > plat.getY())          //if they are below the platform
      {
         f1.setPos(f1.getPos()[0],plat.getY() - f1.getSize()); //move them onto the platform
         f1.setMvmtVel(f1.getMvmtVel()[0], 0);                 //remove the downward momentum
         f1.setKnockBackVel(f1.getKnockBackVel()[0], 0);       //remove downward knockback
         
      }
   }

   /** Moves the fighter back onto the screen
   * @param f1 The fighter being moved
   */
   public void bringBack(Fighter f1)
   {
      if(f1.getPos()[0] + f1.getSize() > 950)            //if they are to the right of the screen
      {
         f1.setPos(950 - f1.getSize(),f1.getPos()[1]);   //move them back onto the screen
         f1.setMvmtVel(0,f1.getMvmtVel()[1]);            //remove horizontal momentum
         f1.setKnockBackVel(0,f1.getKnockBackVel()[1]);  //remove horizontal knockback
         
      }
      if(f1.getPos()[0] < 0)                             //if they are to the left of the screen
      {
         f1.setPos(0,f1.getPos()[1]);                    //move them back onto the screen
         f1.setMvmtVel(0,f1.getMvmtVel()[1]);            //remove horizontal momentum
         f1.setKnockBackVel(0,f1.getKnockBackVel()[1]);  //remove horizontal knockback
         
      }
   }

   /** Set's the fighter to blocking
   * @param f1 The fighter blocking
   * @param inputs An array that contains the data of the button presses 
   */
   public void setBlocking (Fighter f1, boolean[] inputs)
   {
      if (inputs[5] == true)        //if the blocking button is held
      {
         if(f1.getBlocking() == 0)  //if the fighter can block
         {
            f1.setBlocking(1);      //the fighter is blocking
         }
      }
   }

   /** Increments the timers for blocking and changes the state of the block
   * @param f1 The fighter blocking
   */
   public void incrementBlock(Fighter f1)
   {
      if(f1.getBlocking() == 1)                //if the fighter is blocking
      {
         if(f1.getBlockT() == 20)              //if 20 frames have passed
         {
            
            f1.setBlockT(0);                   //reset timer
            f1.setBlocking(2);                 //set fighter to cooldown
         }else
         {
            f1.setBlockT(f1.getBlockT() + 1);  //increment timer
         }
      }
 
      if(f1.getBlocking() == 2)               //if the fighter is in cooldown
      {
         if(f1.getBlockT() == 240)            //if 240 frames have passed
         {
            f1.setBlockT(0);                  //reset timer
            f1.setBlocking(0);                //set fighter to can block
         }
         else
         {
            f1.setBlockT(f1.getBlockT() + 1); //increment timer
         }
      }
   }

   /** sets the fighter to attack and sets the attack
   * @param f1 The fighter attacking
   * @param plat The main platform
   * @param inputs An array that contains the data of the button presses
   */
   public void setAttacking (Fighter f1 , Platform plat, boolean[] inputs)
   {
      //if pressing attack button and isn't blocking and can attack
      if (inputs[4] == true && f1.getBlocking() != 1 && f1.getAttacking() == 0) 
      {
         Fighter.Attack b;                                    //the fighter's new attack

         if(f1.getPos()[1] + f1.getSize() < plat.getY())      //if in the air
         {
            if(inputs[2] == true)                             //if holding down
            {
               b = f1.new AirDown();                          //the new attack is air down
            }else if(inputs[1] == true || inputs[3] == true)  //if holding a directional button
            {
               b = f1.new AirDirection();                     //the new attack is air direction
            }else
            {
               b = f1.new AirNeutral();                       //the new attack is air neutral
            }
         }else
         {  
            if(inputs[2] == true)                             //if down is held
            {
               b = f1.new BasicUp();                          //the new attack is basic up
            }else if(inputs[1] == true || inputs[3] == true)  //if holding a directional button
            {
               b = f1.new BasicDirection();                   //the new attack is basic direction
            }else
            {
               b = f1.new BasicNeutral();                     //the new attack is basic neutral
            }
         }
         f1.setAttack(b);                                     //sets this fighter's attack to b
         f1.setAttacking(1);                                  //sets this fighter to "is attacking"
      }
   }

   /** Increments the timers for attacking, changes the state of the attack, and checks if the attack has hit
   * @param f1 The fighter attacking
   * @param f2 The fighter being attacked
   */
   public void incrementAttack(Fighter f1, Fighter f2)
   {
      if(f1.getAttacking() == 1)   //if the fighter is attacking
      {
         if(f1.getAttackT() == 5)  //if 5 frames have passed
         {
            int[] i = new int[4]; 
            i = attackHitBox(f1);  //gets the x,y, height, and width of the attack
            
            //if the attack position overlapps the other fighter's position and the other fighter isn't blocking
            if (i[0] <= f2.getPos()[0] + f2.getSize() && i[0] + i[2] >= f2.getPos()[0] && i[1] <= f2.getPos()[1] + f2.getSize() && i[1] + i[3] >= f2.getPos()[1] && f2.getBlocking() != 1)
            {
               f2.setHealth(f2.getHealth() - f1.getAttack().getDamage());                                 //deal damage to the fighter
               if(f1.getRight() == true){                             
                  f2.setKnockBackVel(f1.getAttack().getKnockBack()[0],f1.getAttack().getKnockBack()[1]);  //apply knockback going right
               }else
               {
                  f2.setKnockBackVel(-f1.getAttack().getKnockBack()[0],f1.getAttack().getKnockBack()[1]); //apply knockback going left
               }
            }
            f1.setAttackT(0);      //reset attack timer
            f1.setAttacking(2);    //sets the fighter to cooldown
         }else
         {
            f1.setAttackT(f1.getAttackT() + 1); //increments timer
         }
      }

      if(f1.getAttacking() == 2) //if fighter is in cooldown
      {
         if(f1.getAttackT() == f1.getAttack().getTime()) //if the timer has waited the cooldown of the last attack
         {
            f1.setAttackT(0);     //resets the timer
            f1.setAttacking(0);   //sets the fighter to "can attack"
         }
         else
         {
            f1.setAttackT(f1.getAttackT() + 1); //increment timer
         }
      }
   }

   /** Sets the fighters being drawn to the current fighters and redraws the screen
   * @param fs The fighters being drawn
   */
   public void draw(Fighter[] fs)
   {
      this.dFs = fs;      //sets the fighters that are used for drawing to the current fighters
      repaint();          //calls calls the paint function
   }
   
   /** Sets the game to the end screen
   */
   public void endGame()
   {
      mode = 2;
   } 

}