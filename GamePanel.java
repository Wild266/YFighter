import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
public class GamePanel extends JPanel
{
   private JLabel label1;
   public GamePanel()
   {
      setLayout(new FlowLayout());
   
   
      JPanel panel = new JPanel();
      panel.setLayout(new FlowLayout());
      add(panel);
   

   }
   @Override
   protected void paintComponent(Graphics g) {
      super.paintComponent(g);
      // draw the rectangle here
      g.drawRect(20, 40, 50, 60); //g.drawRect(RECT_X, RECT_Y, RECT_WIDTH, RECT_HEIGHT);
   }
}
