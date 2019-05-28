import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.io.*;
import javafx.scene.media;
public class Driver
{
    public static void main(String[] args)
    {   
        playContinuous("Spectre.mp3");
        JFrame frame = new JFrame("Yeet Fighter");
        frame.setSize(965, 640);
        frame.setLocation(200,100);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Display disp = new Display();
        frame.add(disp);
        frame.setVisible(true);

        Fighter f1;
        Fighter f2;
        Platform plat = new Platform(550);
        Fighter fighters[] = new Fighter[2];
        int m = 0;
        while(disp.getMode() == 0)
        {}
        fighters = disp.loadGame(plat);

        int fps = 60;
        double timePerTick = 1000000000 / fps;
        double delta = 0;
        long now;
        long lastTime = System.nanoTime();



        while (fighters[0].getHealth() > 0 && fighters[1].getHealth() > 0)
        {
            now = System.nanoTime();
            delta += (now - lastTime) / timePerTick;
            lastTime = now;

            if(delta >= 1){
                boolean ins[][] = disp.getInputs();
                fighters = disp.update(fighters,plat,ins);
                disp.draw(fighters);
                delta--;
            }
        }
        disp.endGame(fighters);
    }
       public static void playMusic(String filename){
      InputStream music;
      try{
    	  System.out.println("Playing Audio Once");
         music = new FileInputStream(new File(filename));
         AudioStream aud = new AudioStream(music);
         AudioPlayer.player.start(aud);
      }
      catch(Exception e){
    	  System.out.println("Playing Music Once");
      }
   }
   public static void playMusicInALoop(String filename){
	      try{
	    	  AudioInputStream inputStream = AudioSystem.getAudioInputStream(new File(filename));
	          Clip clip = AudioSystem.getClip();
	          clip.open(inputStream);
	          clip.loop(Clip.LOOP_CONTINUOUSLY);
	      }
	      catch(Exception e){
	    	  System.out.println(e);
	         playMusic(filename);
	      }
	}
   public static void playContinuous(String filename){
	      try{
	    	  AudioInputStream inputStream = AudioSystem.getAudioInputStream(new File(filename));
           DataLine.info lineInfo = new DataLine.Info(SourceDataLine.class, inputStream.getFormat());
           SourceDataLine clip = (SourceDataLine)AudioSystem.getLine(lineInfo);
           clip.open(inputStream.getFormat());
           clip.start();
           final int BUFFERSIZE = 1024;
           byte[] buffer = new byte[BUFFERSIZE];
           int bytesRead = -1;
           bytesRead = inputStream.read(buffer);
           while (bytesRead != 1){
            clip.write(buffer, 0 ,bytesRead);
            bytesRead = inputStream.read(buffer);
           } 
           clip.drain();
           clip.close();
           inputStream.close();
	      }
	      catch(Exception e){
	    	  System.out.println(e);
// 	         playMusic(filename);
	      }
	}
}
