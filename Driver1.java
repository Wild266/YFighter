import javax.swing.JFrame;


public class Driver1{
   public static void main(String[] args){
      JFrame frame = new JFrame("Yeet Fighter");
      frame.setSize(600, 300);
      frame.setLocation(200,100);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setContentPane(new Panel1());
      frame.setVisible(true);
   
   }


}
