public class Stubs
{
    public class Driver
    {
        public static void main(String[] args)
        {
            startGUI();
            loadGame();
            while (Fighter1.getHealth() > 0 && Fighter2.getHealth > 0)
            {
                Update();
                Draw();
            }
            endGame();
        }
    }
    public void loadGame()
    {
        System.out.println("loadGame");
    }
    public bool[] getInputs()
    {
        System.out.println("getInputs");
    }
    public class Fighter
    {
        double health;
        public void getHealth()
        {
            return health;
        }
        public double[] getHitBox(double fighterX, double fighterY)
        {
            System.out.println("getHitBox");
        } 
        public double[] getKnockback()
        {
            System.out.println("getKnockback");
        }
        public class AirDirection implements Attack
        {
            System.out.println("AirDirection");
        }
        public class AirDown implements Attack
        {
            System.out.println("AirDown");
        }
        public class AirNeutral implements Attack
        {
            System.out.println("AirNeutral");
        }
        public class CrouchDirection implements Attack
        {
            System.out.println("CrouchDirection");
        }
        public class CrouchUp implements Attack
        {
            System.out.println("CrouchUp");
        }
        public class CrouchNeutral implements Attack
        {
            System.out.println("CrouchNeutral");
        }
        public class BasicDirection implements Attack
        {
            System.out.println("BasicDirection");
        }
        public class BasicNeutral implements Attack
        {
            System.out.println("BasicNeutral");
        }
        public class BasicUp implements Attack
        {
            System.out.println("BasicUp");
        }
    }
    public class Platform
    {
    }
    public class Display
    {
        public void startGUI()
        {
            System.out.println("startGUI");
        }
        public void update()
        {
            System.out.println("update");
        }
        public void draw()
        {
            System.out.println("draw");
        }
        public void endGame()
        {
            System.out.println("endGame");
        }
    }

}

