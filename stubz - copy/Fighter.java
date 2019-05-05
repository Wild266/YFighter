public class Fighter
{
   double health;
   double pos[] = new double[2];
   double size;
   double mvntVel = 0;
   double knckbackVel = 0;

   Fighter(double newHealth, double newX,double newY, double newSize)
   {
      this.health = newHealth;
      this.pos[0] = newX;
      this.pos[1] = newY;
      this.size = newSize;
      System.out.println("made new fighter with " + this.health + " health");
   }
   public double getHealth()
   {
      System.out.println("getting player health");
      return health;
   }
   public void setHealth(double newHealth)
   {
      System.out.println("setting player health");
      this.health = newHealth;
   }
   public double[] getHitBox(double fighterX, double fighterY)
   {
      System.out.println("getting corner positions of player");
      double hitbox[] = new double[4];
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