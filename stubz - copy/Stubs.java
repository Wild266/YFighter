class Stubs
{
    public class Driver
    {
        public static void main(String[] args)
        {
            Display disp = new Display();
            disp.startGUI();
            Fighter f1;
            Fighter f2;
            Platfrom plat = new Platform(20);
            Fighter[] fighters = disp.loadGame();
            while (fighters[0].getHealth() > 0 && fighters[1].getHealth > 0)
            {
                boolean ins[] = dips.getInputs();
                disp.Update(fighters,plat,ins);
                disp.Draw(fighters);
            }
            disp.endGame(fighters);
        }
    }
    public class Display
    {
        public void startGUI()
        {
            System.out.println("Loading start GUI");
            System.out.println("Waiting for play button");
            System.out.println("Play button is pressed");
        }
        public Fighter[] loadGame()
        {
            Fighter[] fs = new Fighter[1];
            System.out.println("loading Game");
            fs[0] = new Fighter();
            fs[1] = new Fighter();
            return fs;
        }
        public boolean[] getInputs()
        {
            boolean out[] = new boolean[0];
            System.out.println("getting inputs");
            return out;
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
            System.out.println("displaying winner");
            System.out.println("waiting for end button");
            System.out.println("end button is pressed");
        } 
    }
    public class Fighter
    {
        double health;
        public double getHealth()
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
        
    }
    public class Platform
    {
        double y;
        Platform(double newY)
        {
            this.y = newY;
            System.out.println("made new platform at y: " + this.y);
        }

        public double getY()
        {
            return this.y;
        }
    }
    
}
