public class Fighter
{
   double health;
   double pos[] = new double[2];
   int size;
   double[] mvntVel = new double[2];
   double[] knockBackVel = new double[2];
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
      return this.health;
   }

   public void setHealth(double h)
   {
      this.health = h;
   }
   
   public double[] getMvmtVel()
   {
      return this.mvntVel;
   }
   public void setMvmtVel(double x, double y)
   {
      this.mvntVel[0] = x;
      this.mvntVel[1] = y;
   }

   public double[] getKnockBackVel()
   {
      return this.knockBackVel;
   }
   public void setKnockBackVel(double x, double y)
   {
      this.knockBackVel[0] = x;
      this.knockBackVel[1] = y;
   }

   public int getSize()
   {
      return this.size;
   }

   public double[] getPos()
   {
      return this.pos;
   }

   public void setPos(double x, double y)
   {
      this.pos[0] = x;
      this.pos[1] = y;
   }

   public void setJumping(boolean j){
      this.jumping = j;
   }

   public boolean getJumping(){
      return this.jumping;
   }






   /*
   public double[] getHitBox()
   {
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
   */
   








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