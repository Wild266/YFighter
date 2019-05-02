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
    public void endGame()
    {
        System.out.println("endGame");
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
        }
        public class AirDown implements Attack
        {
        }
        public class AirNeutral implements Attack
        {
        }
        public class CrouchDirection implements Attack
        {
        }
        public class CrouchUp implements Attack
        {
        }
        public class CrouchNeutral implements Attack
        {
        }
        public class BasicDirection implements Attack
        {
        }
        public class BasicNeutral implements Attack
        {
        }
        public class BasicUp implements Attack
        {
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
    }

}

