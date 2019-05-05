import java.awt.Canvas;
//import java.awt.Dimension;

import javax.swing.JFrame;

public class Window extends Canvas {

	
	public Window(/*, Game game*/) {
		
		JFrame frame = new JFrame("Yeet Fighter");
	        frame.setSize(600, 300);
	        frame.setLocation(200,100);
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frame.setContentPane(new Panel1());
	        frame.setVisible(true);
		frame.setResizable(false);
		
		
		
// 		frame.setPreferredSize(new Dimension(width,height));
// 		frame.setMaximumSize(new Dimension(width,height));
// 		frame.setMinimumSize(new Dimension(width,height));
		
// 		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
// 		frame.setResizable(false);
// 		frame.setLocationRelativeTo(null);
// 		frame.add(game);
// 		frame.setVisible(true);
// 		game.start();
	}
}
