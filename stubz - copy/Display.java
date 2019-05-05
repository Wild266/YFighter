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
        Fighter fs[] = new Fighter[2];
        System.out.println("loading Game");
        fs[0] = new Fighter(1,1,1,1);
        fs[1] = new Fighter(1,1,1,1);
        return fs;
    }
    public boolean[] getInputs()
    {
        boolean out[] = new boolean[1];
        System.out.println("getting inputs");
        return out;
    }
    public Fighter[] update(Fighter[] fs, Platform plat, boolean[] inputs)
    {
        System.out.println("moving fighters");
        System.out.println("putting fighters above platform");
        System.out.println("all players are above " + plat.getY());
        System.out.println("incrementing buffers");
        System.out.println("setting players to attacking, blocking, or neither");
        System.out.println("checking player hitboxes with attack hitboxes");
        System.out.println("setting new player healths");
        fs[0].setHealth(0);
        return fs; 

    }
    public void draw(Fighter[] fs)
    {
        System.out.println("drawing players on screen");
    }
    public void endGame(Fighter[] fs)
    {
        System.out.println("displaying winner");
        System.out.println("waiting for end button");
        System.out.println("end button is pressed");
    } 
}