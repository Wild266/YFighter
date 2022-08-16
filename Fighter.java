
/** A the box men that the player controls throughout the game. They move around, they jump, they hit eachother, they block hits, and they take damage
 * @param newHealth The fighter's starting health
 * @param newX The fighter's starting x position
 * @param newY The fighter's starting y position
 * @param newSize The fighter's starting size in pixels
*/
public class Fighter
{
   double health;                           //the health of the player
   double pos[] = new double[2];            //the position (x,y) of the player
   int size;                                //the size in pixels of the player
   double[] mvntVel = new double[2];        //the velocity of the player from their own movement (x,y)
   double[] knockBackVel = new double[2];   //the velocity of the player from knockback (x,y)
   boolean right = false;                   //whether or not they are facing right
   int attacking = 0;                       //the state of attacking they are in (0 = can attack, 1 = attacking, 2 = cooldown)
   int attackT = 0;                         //the timer used for attacks
   int blocking = 0;                        //the state of blocking they are in (0 = can block, 1 = blocking, 2 = cooldown)
   int blockT = 0;                          //the timer used for blocks
   Fighter.Attack attack;                   //the attack that the fighter is performing
   

   Fighter(double newHealth, double newX, double newY, int newSize)
   {
      this.health = newHealth;
      this.pos[0] = newX;
      this.pos[1] = newY;
      this.size = newSize;   
   }
   
   /** sets the fighter's current attack
   * @param a The new attack the fighter is going to perform
   */
   public void setAttack(Attack a)
   {
      this.attack = a;
   }

   /** gets the fighter's current attack
   * @return The current attack
   */
   public Attack getAttack()
   {
      return this.attack;
   }

   /** gets the fighter's current health
   * @return The current health
   */
   public double getHealth()
   {
      return this.health;
   }
   
   /** sets the fighter's current health
   * @param h The new health of the fighter
   */
   public void setHealth(double h)
   {
      this.health = h;
   }

   /** gets the fighter's current movement velocity
   * @return The current velocity (x,y)
   */
   public double[] getMvmtVel()
   {
      return this.mvntVel;
   }

   /** sets the fighter's current movement velocity 
   * @param x The horizontal velocity
   * @param y The vertical velocity
   */
   public void setMvmtVel(double x, double y)
   {
      this.mvntVel[0] = x;
      this.mvntVel[1] = y;
   }

   /** gets the fighter's current knockback velocity
   * @return The current velocity (x,y)
   */
   public double[] getKnockBackVel()
   {
      return this.knockBackVel;
   }

   /** sets the fighter's current knockback velocity 
   * @param x The horizontal velocity
   * @param y The vertical velocity
   */
   public void setKnockBackVel(double x, double y)
   {
      this.knockBackVel[0] = x;
      this.knockBackVel[1] = y;
   }

   /** gets the fighter's size
   * @return The size in pixels
   */
   public int getSize()
   {
      return this.size;
   }

   /** gets the fighter's current position
   * @return The current position (x,y)
   */
   public double[] getPos()
   {
      return this.pos;
   }

   /** sets the fighter's current position 
   * @param x The x position
   * @param y The y position
   */
   public void setPos(double x, double y)
   {
      this.pos[0] = x;
      this.pos[1] = y;
   }

   /** sets the fighter's current attack mode
   * @param a The new attack mode
   */
   public void setAttacking(int a)
   {
      this.attacking = a;
   }
   
   /** gets the fighter's current attack mode
   * @return The current attack mode
   */
   public int getAttacking()
   {
      return this.attacking;
   }

   /** sets the fighter's current block mode
   * @param a The new block mode
   */
   public void setBlocking(int a)
   {
      this.blocking = a;
   }
   
   /** gets the fighter's current block mode
   * @return The current block mode
   */
   public int getBlocking()
   {
      return this.blocking;
   }
   
   /** sets whether or not the fighter is facing right
   * @param r is the fighter facing right
   */
   public void setRight(boolean r)
   {
      this.right = r;
   }
   
   /** gets whether or not the fighter is facing right
   * @return is the fighter facing right
   */
   public boolean getRight()
   {
      return this.right;
   }
   
    /** sets the fighter's current attack timer
   * @param a The new timer count
   */
   public void setAttackT(int a)
   {
      this.attackT = a;
   }
   
   /** gets the fighter's current attack timer
   * @return The timer count
   */
   public int getAttackT()
   {
      return this.attackT;
   }

   /** sets the fighter's current block timer
   * @param a The new timer count
   */
   public void setBlockT(int a)
   {
      this.blockT = a;
   }
   
   /** gets the fighter's current block timer
   * @return The timer count
   */
   public int getBlockT()
   {
      return this.blockT;
   }







   /** An abstract class for the 6 different attacks to extend. Contains the position of the attack, the size of the attack, the damage it deals, the knockback it deals, and the cooldown time
   */
   public abstract class Attack
   {
      
      double[] pos = new double[2];        //the position (x,y)
      int[] size = new int[2];             //the size in pixels (horizontal, vertical)
      double damage;                       //the damage it deals
      double[] knockback = new double[2];  //the knockback it deals (x,y)
      int time;                            //the time in frames that the fighter must wait before it can attack again
      


      /** Gets the attack's knockback
      * @return The knockback
      */
      public double[] getKnockBack()
      {
         return this.knockback;
      }
      
      /** Gets the attack's damage
      * @return The damage
      */
      public double getDamage()
      {
         return this.damage;
      }

       /**Gets the attack's position
      * @return The position
      */
      public double[] getPos()
      {
         return this.pos;
      }
      
       /** Gets the attack's size
      * @return The size
      */
      public int[] getSize()
      {
         return this.size;
      }

       /** Gets the attack's cooldown time
      * @return The time
      */
      public int getTime()
      {
         return this.time;
      }

      /** Sets the attack's knockback
      * @param k1 The horizontal knockback
      * @param k2 The vertical knockback
      */
      public void setKnockBack(double k1, double k2)
      {
         knockback[0] = k1;
         knockback[1] = k2;
      }
      
      /** Sets the attack's damage
      * @param d The damage
      */
      public void setDamage(double d)
      {
         damage = d;
      }
      /** Sets the attack's position
      * @param x The horizontal position
      * @param y The vertical position
      */
      public void setPos(double x, double y)
      {
         pos[0] = x;
         pos[1] = y;
      }
      
      /** Sets the attack's size
      * @param k1 The horizontal size
      * @param k2 The vertical size
      */
      public void setSize(int s1, int s2)
      {
         size[0] = s1;
         size[1] = s2;
      }

      /** Sets the attack's cooldown
      * @param t The cooldown
      */
      public void setTime(int t)
      {
         time = t;
      }
      
   }


   /** The attack that is done when the fighter is in the air and holding left or right
   */
   public class AirDirection extends Attack
   {
      AirDirection(){
         setPos(10,35);
         setSize(120,10);
         setDamage(50);
         setKnockBack(120,-10);
         setTime(20);
      } 
   }

   /** The attack that is done when the fighter is in the air and holding down
   */
   public class AirDown extends Attack
   {
      AirDown(){
         setPos(10,10);
         setSize(30,120);
         setDamage(70);
         setKnockBack(0,-80);
         setTime(40);
      }   
   }

   /** The attack that is done when the fighter is in the air and not holding anything
   */
   public class AirNeutral extends Attack
   {
      AirNeutral(){
         setPos(20,20);
         setSize(50,50);
         setDamage(110);
         setKnockBack(40,-10); 
         setTime(25);
      } 
   }

   /** The attack that is done when the fighter on the ground and holding left or right
   */
   public class BasicDirection extends Attack
   {
      BasicDirection(){
         setPos(10,10);
         setSize(150,10);
         setDamage(40);
         setKnockBack(40,-10);
         setTime(20);
      }  
   }

   /** The attack that is done when the fighter on the ground and not holding anything
   */
   public class BasicNeutral extends Attack
   {      
      BasicNeutral(){
         setPos(10,10);
         setSize(70,30);
         setDamage(150);
         setKnockBack(60,-60);
         setTime(30);
      } 
   }

   /** The attack that is done when the fighter on the ground and holding down
   */
   public class BasicUp extends Attack
   {
      BasicUp(){
         setPos(20,-10);
         setSize(10,10);
         setDamage(200);
         setKnockBack(4,-200);
         setTime(50);
      } 
   }
}