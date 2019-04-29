//Name______________________________ Date_____________
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
public class Panel1 extends JPanel
{
   private JLabel label1;
   public Panel1()
   {
      setLayout(new FlowLayout());
   
      label1 = new JLabel("Yeet Fighter");
      label1.setFont(new Font("Serif", Font.BOLD, 100));
      label1.setForeground(Color.red);
      add(label1);
   
      JPanel panel = new JPanel();
      panel.setLayout(new FlowLayout());
      add(panel);
   
      JButton button2 = new JButton("Play");
      button2.addActionListener(new Listener1());
      panel.add(button2);
   
      JButton button3 = new JButton("Quit");
      button3.addActionListener(new Listener2());
      panel.add(button3);
   

   }
   @Override
  protected void paintComponent(Graphics g) {
Image wall;

    try 
        {wall = ImageIO.read(new File("space.jpg"));
        super.paintComponent(g);
        g.drawImage(wall, 0, 0, null);
        }
    catch (IOException e)
        {e.printStackTrace();}
    
}

   private class Listener1 implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
    	   removeAll();
         revalidate();
         repaint();
      }
      
   }
   private class Listener2 implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         System.exit(0);
      
      }
   }
}
