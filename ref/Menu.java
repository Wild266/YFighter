import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

public class Menu extends MouseAdapter {
	private Game game;
	private Handler handler;
	private Random r = new Random();

	public Menu(Game game, Handler handler) {
		this.game = game;
		this.handler = handler;

	}

	public void mousePressed(MouseEvent e) {
		int mx = e.getX();
		int my = e.getY();
		if (game.gameState == STATE.Menu) {

			// play button
			if (mouseOver(mx, my, 210, 150, 200, 64)) {
				game.gameState = STATE.Game;
				handler.addObject(new Player(Game.WIDTH / 2 - 32, Game.HEIGHT / 2 - 32, ID.Player, handler));
				handler.addObject(
						new BasicEnemy((r.nextInt(Game.WIDTH)), (r.nextInt(Game.HEIGHT)), ID.BasicEnemy, handler));
			}
			// help button
			if (mouseOver(mx, my, 210, 250, 200, 64)) {
				game.gameState = STATE.Help;
			}

			// quit button
			if (mouseOver(mx, my, 210, 350, 200, 64)) {
				System.exit(1);
			}
		}
		// back button for help
		if (game.gameState == STATE.Help) {
			if (mouseOver(mx, my, 210, 350, 200, 64)) {
				game.gameState = STATE.Menu;
				return;
			}
		}

	}

	public void mouseReleased(MouseEvent e) {

	}

	private boolean mouseOver(int mx, int my, int x, int y, int width, int height) {
		if (mx > x && mx < (x + width)) {
			if (my > y && my < (y + height)) {
				return true;
			} else
				return false;
		} else
			return false;
	}

	public void tick() {

	}

	public void render(Graphics g) {
		if (game.gameState == STATE.Menu) {

			Font fnt = new Font("arial", 1, 50);
			Font fnt2 = new Font("arial", 1, 35);

			g.setFont(fnt);
			g.setColor(Color.white);
			g.drawString("Menu", 240, 75);

			g.setFont(fnt2);

			g.drawRect(210, 150, 200, 64);
			g.drawString("Play", 270, 195);

			g.drawRect(210, 250, 200, 64);
			g.drawString("Help", 270, 295);

			g.drawRect(210, 350, 200, 64);
			g.drawString("Quit", 270, 395);
		} else if (game.gameState == STATE.Help) {
			Font fnt = new Font("arial", 1, 50);
			Font fnt2 = new Font("arial", 1, 35);
			Font fnt3 = new Font("arial", 1, 30);
			g.setFont(fnt);
			g.setColor(Color.white);
			g.drawString("Help", 240, 75);

			g.setFont(fnt3);
			g.drawString("Dogde enemy bullets using the WASD keys", 10, 200);

			g.setFont(fnt2);
			g.drawRect(210, 350, 200, 64);
			g.drawString("Back", 270, 395);
		}
	}

}
