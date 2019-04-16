//Name______________________________ Date_____________
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
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
      button2.addActionListener(new Listener2());
      panel.add(button2);
   
      JButton button3 = new JButton("Quit");
      button3.addActionListener(new Listener3());
      panel.add(button3);
   

   }

   private class Listener2 implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
    	  
      }
      
   }
   private class Listener3 implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         System.exit(0);
      
      }
   }
}
