import javax.swing.*;

public class Driver
{
    public static void main(String[] args)
    {   
        JFrame frame = new JFrame("Yeet Fighter");
        frame.setSize(960, 640);
        frame.setLocation(200,100);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Display disp = new Display();
        frame.add(disp);
        frame.setVisible(true);

        //JLabel label = new JLabel("Test text");//initialize the label
        //do some stuff with label here maybe...sdd
        //disp.add(label);

        //disp.startGUI(frame);     
        Fighter f1;
        Fighter f2;
        Platform plat = new Platform(550);
        Fighter fighters[] = new Fighter[2];
        fighters = disp.loadGame(plat);

        
        while (fighters[0].getHealth() > 0 && fighters[1].getHealth() > 0)
        {
            //boolean ins[] = disp.getInputs();
            boolean ins[] = new boolean[1];
            fighters = disp.update(fighters,plat,ins);
            disp.draw(fighters);
        }
        //disp.endGame(fighters);

    }
}