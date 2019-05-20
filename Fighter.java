public class Fighter
{
   double health;
   double pos[] = new double[2];
   int size;
   double[] mvntVel = new double[2];
   double[] knckbackVel = new double[2];
   boolean crouching = false;
   boolean jumping = false;

   Fighter(double newHealth, double newX, double newY, int newSize)
   {
      this.health = newHealth;
      this.pos[0] = newX;
      this.pos[1] = newY;
      this.size = newSize;
      System.out.println("made new fighter with " + this.health + " health");
   }

   public double getHealth()
   {
      //System.out.println("getting player health");
      return health;
   }
   
   public double[] getMvmtVel()
   {
      return mvntVel;
   }

   public void setHealth(double newHealth)
   {
      System.out.println("setting player health");
      this.health = newHealth;
   }

   public int getSize()
   {
      return this.size;
   }

   public void setPos(double x, double y)
   {
      this.pos[0] = x;
      this.pos[1] = y;
   }

   public double[] getHitBox()
   {
      //System.out.println("getting corner positions of player");
      double hitbox[] = new double[4];
      hitbox[0] = this.pos[0];
      hitbox[1] = this.pos[1];
      hitbox[2] = this.pos[0] + this.size;
      hitbox[3] = this.pos[0] + this.size;
      if (this.crouching)
      {
         hitbox[3] = hitbox[3]/ 2.0;
      }
      return hitbox;
   } 
   
   public abstract class Attack
   {
      double x;
      double y;
      double width;
      double height;
      double damage;
      double knockback;
      
      public double getknockback()
      {
         System.out.println("getting knockback of attack");
         return 0;
      }
      
      public double getdamage()
      {
         System.out.println("getting damage of attack");
         return 0;
      }
      public double[] getHitBox()
      {
         double h[] = new double[4];
         System.out.println("getting corner positions of attack");
         return h;
      }
   }
   public class AirDirection extends Attack
   {
      double width;
      double height;
      double damage;
      double knockback; 
   }
   public class AirDown extends Attack
   {
      double width;
      double height;
      double damage;
      double knockback;  
   }
   public class AirNeutral extends Attack
   {
      double width;
      double height;
      double damage;
      double knockback;  
   }
   public class CrouchDirection extends Attack
   {
      double width;
      double height;
      double damage;
      double knockback; 
   }
   public class CrouchUp extends Attack
   {
      double width;
      double height;
      double damage;
      double knockback;
   }
   public class CrouchNeutral extends Attack
   {
      double width;
      double height;
      double damage;
      double knockback;   
   }
   public class BasicDirection extends Attack
   {
      double width;
      double height;
      double damage;
      double knockback;   
   }
   public class BasicNeutral extends Attack
   {
      double width;
      double height;
      double damage;
      double knockback;  
   }
   public class BasicUp extends Attack
   {
      double width;
      double height;
      double damage;
      double knockback;  
   }
   
}