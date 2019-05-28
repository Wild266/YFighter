public class Fighter
{
   double health;
   double pos[] = new double[2];
   int size;
   double[] mvntVel = new double[2];
   double[] knockBackVel = new double[2];
   boolean right = false;
   int attacking = 0;
   int attackT = 0;
   int blocking = 0;
   int blockT = 0;
   Fighter.Attack attack;
   

   Fighter(double newHealth, double newX, double newY, int newSize)
   {
      this.health = newHealth;
      this.pos[0] = newX;
      this.pos[1] = newY;
      this.size = newSize;   }
   
   public void setAttack(Attack a)
   {
      this.attack = a;
   }

   public Attack getAttack()
   {
      return this.attack;
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

   public void setAttacking(int a)
   {
      this.attacking = a;
   }
   
   public int getAttacking()
   {
      return this.attacking;
   }

   public void setBlocking(int a)
   {
      this.blocking = a;
   }
   
   public int getBlocking()
   {
      return this.blocking;
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

   public void setBlockT(int a)
   {
      this.blockT = a;
   }
   
   public int getBlockT()
   {
      return this.blockT;
   }








   public abstract class Attack
   {
      
      double[] pos = new double[2];
      int[] size = new int[2];
      double damage;
      double[] knockback = new double[2]; 
      int time;
      
      
      public double[] getKnockBack()
      {
         return this.knockback;
      }
      
      public double getDamage()
      {
         return this.damage;
      }
      public double[] getPos()
      {
         return this.pos;
      }
      
      public int[] getSize()
      {
         return this.size;
      }

      public int getTime()
      {
         return this.time;
      }

      public void setKnockBack(double k1, double k2)
      {
         knockback[0] = k1;
         knockback[1] = k2;
      }
      
      public void setDamage(double d)
      {
         damage = d;
      }
      public void setPos(double x, double y)
      {
         pos[0] = x;
         pos[1] = y;
      }
      
      public void setSize(int s1, int s2)
      {
         size[0] = s1;
         size[1] = s2;
      }

      public void setTime(int t)
      {
         time = t;
      }
      
   }


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