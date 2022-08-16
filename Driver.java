import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.io.*;
import sun.audio.*;
public class Driver
{
    public static void main(String[] args)
    {   
        playMusicInALoop("CoolBeats/IMG_0035.wav");       //Plays music from location "CoolBeats/Spectre.wav"


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
        long StartTime = System.nanoTime();
        String[] planets = new String[]{
                                        "imgs/mercuryd.png",
                                        "imgs/venusd.png", 
                                        "imgs/earthd.png",
                                        "imgs/marsd.png",
                                        "imgs/Jupiterd.png",
                                        "imgs/saturnd.png",
                                        "imgs/uranusd.png", 
                                        "imgs/neptuned.png", 
                                        "imgs/plutod.png",
                                        "imgs/spacedd.png"};
        double[] gravities = new double[]{
                                          0.38,
                                          0.907,
                                          1,
                                          0.377,
                                          2.4,
                                          1.07,
                                          0.907,
                                          1.1,
                                          0.08,
                                          0.001};
        long[] travel = new long[]{1000000000L,
                                   5029000000L,
                                   4140000000L,
                                   7834000000L,
                                   55039000000L,
                                   64627000000L,
                                   144895000000L,
                                   162745000000L,
                                   2800000000L,
                                   1000000000L};
        int planetCycle = 0;
        
        
        while ((fighters[0].getHealth() > 0 && fighters[1].getHealth() > 0) && (fighters[0].getPos()[1] < 600 && fighters[1].getPos()[1] < 600)) // while both players have full health
        {
            now = System.nanoTime(); 
            delta += (now - lastTime) / timePerTick;        // percentage of time passed before a new update is needed
            lastTime = now;
            if (planetCycle >= planets.length)
                  planetCycle = 0;
            if ((System.nanoTime()-StartTime)>travel[planetCycle]){
               disp.setBG(planets[planetCycle]);
               
               disp.setGravity(gravities[planetCycle]);
               StartTime = System.nanoTime();
               planetCycle++;
            }
            if (planetCycle >= planets.length)
                  planetCycle = 0;

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
  
    /***************************************************************
   	* Plays the music once using AudioStream and AudioPlayer
   	* @param	 filename   Plays music once from file with name filename
   	**************************************************************/    
       public static void playMusic(String filename)
       {
           try{                                                  //tries to find .wav file of filename
           InputStream music;
               System.out.println("Playing Audio Once");
              AudioStream aud = new AudioStream(new FileInputStream(new File(filename)));   //File input Stream is used to to create AudioStream
              AudioPlayer.player.start(aud);                     //plays file filename once using AudioPlayer.player
           }  
           catch(Exception e)
           {                                   //if file is not found console is notified
               System.out.println("Playing Music failed");
           }
        }
     
            /***************************************************************
            * Plays the music repeatedly forever using AudioStream and AudioPlayer
            * @param	 filename   Plays music from file with name filename unless error occurs, in that case music is played once.
            **************************************************************/    
     
        public static void playMusicInALoop(String filename){
           try{                                               //tries to find .wav file of filename
               Clip c = AudioSystem.getClip();                //creates clip c
               c.open(AudioSystem.getAudioInputStream(new File(filename)));  //opens filename file AudioInputStream with clip
               c.loop(Clip.LOOP_CONTINUOUSLY);                           //clip loops continuously
           }
           catch(Exception e)
           {                                //if error occurs error is printed to console and attempt to play once is made
               System.out.println(e.toString());               
               playMusic(filename);
           }
       }
}
