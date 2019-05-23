import javax.swing.*;

public class Driver
{
    public static void main(String[] args)
    {   
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
        {

        }
        System.out.println("dang");
        fighters = disp.loadGame(plat);

        int fps = 60;
        double timePerTick = 1000000000 / fps;
        double delta = 0;
        long now;
        long lastTime = System.nanoTime();
        long timer = 0;
        int ticks = 0;



        while (fighters[0].getHealth() > 0 && fighters[1].getHealth() > 0)
        {
            now = System.nanoTime();
            delta += (now - lastTime) / timePerTick;
            timer += now - lastTime;
            lastTime = now;

            if(delta >= 1){
                boolean ins[][] = disp.getInputs();
                fighters = disp.update(fighters,plat,ins);
                disp.draw(fighters);
                ticks++;
                delta--;
            }

            if(timer >= 1000000000){
//               System.out.println(ticks);
                ticks = 0;
                timer = 0;
            }
        }
        disp.endGame(fighters);
    }
}