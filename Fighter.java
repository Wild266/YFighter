public class Fighter
{
   double health;
   double pos[] = new double[2];
   int size;
   double[] mvntVel = new double[2];
   double[] knockBackVel = new double[2];
   boolean jumping = false;
   boolean right = false;
   int attacking = 0;
   int attackT = 0;
   

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

   public void setJumping(boolean j)
   {
      this.jumping = j;
   }

   public boolean getJumping()
   {
      return this.jumping;
   }
   
   public void setAttacking(int a)
   {
      this.attacking = a;
   }
   
   public int getAttacking()
   {
      return this.attacking;
   }
   
   public void setRight(boolean r)
   {
      this.right = r;
   }
   
   public boolean getRight()
   {
      return this.right;
   }
   
   public void setAttackT(int a)
   {
      this.attackT = a;
   }
   
   public int getAttackT()
   {
      return this.attackT;
   }








   public abstract class Attack
   {
      double[] pos;
      double[] size;
      double damage;
      double[] knockback;
      
      public double[] getknockback()
      {
         return this.knockback;
      }
      
      public double getdamage()
      {
         return this.damage;
      }
      public double[] getPos()
      {
         return this.pos;
      }
      
      public double[] getSize()
      {
         return this.size;
      }
      
   }
   public class AirDirection extends Attack
   {
      double[] pos = new double[2];
      double[] size = new double[2];
      double damage;
      double[] knockback = new double[2]; 
      
      AirDirection(double[] f){
         this.pos[0] = f[0] + 0;
         this.pos[1] = f[1] + 0;
         this.size[0] = 10;
         this.size[1] = 10;
         this.damage = 50;
         this.knockback[0] = 20;
         this.knockback[1] = -5; 
      } 
   }
   public class AirDown extends Attack
   {
      double[] pos = new double[2];
      double[] size = new double[2];
      double damage;
      double[] knockback = new double[2];
      
      AirDown(double[] f){
         this.pos[0] = f[0] + 0;
         this.pos[1] = f[1] + 0;
         this.size[0] = 10;
         this.size[1] = 10;
         this.damage = 50;
         this.knockback[0] = 20;
         this.knockback[1] = -5; 
      }   
   }
   public class AirNeutral extends Attack
   {
      double[] pos = new double[2];
      double[] size = new double[2];
      double damage;
      double[] knockback = new double[2]; 
      
      AirNeutral(double[] f){
         this.pos[0] = f[0] + 0;
         this.pos[1] = f[1] + 0;
         this.size[0] = 10;
         this.size[1] = 10;
         this.damage = 50;
         this.knockback[0] = 20;
         this.knockback[1] = -5; 
      } 
   }
   public class BasicDirection extends Attack
   {
      double[] pos = new double[2];
      double[] size = new double[2];
      double damage;
      double[] knockback = new double[2]; 
      
      BasicDirection(double[] f){
         this.pos[0] = f[0] + 0;
         this.pos[1] = f[1] + 0;
         this.size[0] = 10;
         this.size[1] = 10;
         this.damage = 50;
         this.knockback[0] = 20;
         this.knockback[1] = -5; 
      }  
   }
   public class BasicNeutral extends Attack
   {      
      double[] pos = new double[2];
      double[] size = new double[2];
      double damage;
      double[] knockback = new double[2];
            
      BasicNeutral(double[] f){
         this.pos[0] = f[0] + 0;
         this.pos[1] = f[1] + 0;
         this.size[0] = 10;
         this.size[1] = 10;
         this.damage = 50;
         this.knockback[0] = 20;
         this.knockback[1] = -5; 
      } 
   }
   public class BasicUp extends Attack
   {
      double[] pos = new double[2];
      double[] size = new double[2];
      double damage;
      double[] knockback = new double[2];
      
      BasicUp(double[] f){
         this.pos[0] = f[0] + 0;
         this.pos[1] = f[1] + 0;
         this.size[0] = 10;
         this.size[1] = 10;
         this.damage = 50;
         this.knockback[0] = 20;
         this.knockback[1] = -5; 
      } 
        
   }
   
}