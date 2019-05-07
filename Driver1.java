//import javax.swing.JFrame;


public class Driver1{
   public static void main(String[] args){
	   new Window();
	   Display disp = new Display();
           disp.startGUI();
           Fighter f1;
           Fighter f2;
           Platform plat = new Platform(20);
           Fighter fighters[] = new Fighter[2];
	   
           fighters = disp.loadGame();
           while (fighters[0].getHealth() > 0 && fighters[1].getHealth() > 0)
           {
               boolean ins[] = disp.getInputs();
               fighters = disp.update(fighters,plat,ins);
               disp.draw(fighters);
           }
           disp.endGame(fighters);
   }


}
