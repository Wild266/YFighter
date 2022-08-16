import javax.swing.*;
import java.io.*;
public class Driver
{
    public static void main(String[] args)
    {   
        // making the frame that contains the game and changing various settings
        JFrame frame = new JFrame("Yeet Fighter");
        frame.setSize(965, 640);
        frame.setLocation(200,100);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Display disp = new Display();
        frame.add(disp);
        frame.setVisible(true);
        
        // the line on the screen that the players can't go past
        Platform plat = new Platform(550);     // at 550 pixels down from the top of the screen
        Fighter fighters[] = new Fighter[2];   // making the two players
        while(disp.getMode() == 0){}           // mode goes to 1 when any button is pressed
        fighters = disp.loadGame(plat);        // instatiates the fighters and starts the game

        int fps = 60;                          // the number of times that the code updates every second
        double timePerTick = 1000000000 / fps; // one second in nanoseconds divided by the frames per second: the time between each frame
        double delta = 0;                      
        long now;
        long lastTime = System.nanoTime();

        while (fighters[0].getHealth() > 0 && fighters[1].getHealth() > 0) // while both players have full health
        {
            now = System.nanoTime(); 
            delta += (now - lastTime) / timePerTick;        // percentage of time passed before a new update is needed
            lastTime = now;

            if(delta >= 1)
            {                                 // if the total number of time inbetween frames has passed
                boolean ins[][] = disp.getInputs();         // checks all of the buttons used in the game
                fighters = disp.update(fighters,plat,ins);  // does all of the calculations for one frame
                disp.draw(fighters);                        // redraws everything on the screen
                delta--;                                    // sets the percentage to 0 + however much extra time passed before the frame updated
            }
        }
        disp.endGame();                             // sets the game to the final screen
    }
}
