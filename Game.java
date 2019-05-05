import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.Random;

public class Game extends Canvas implements Runnable {
	public static final int WIDTH = 640, HEIGHT = WIDTH / 12 * 9;
//	private static final long serialVersionUID = -1442798787354930462L;
	private Thread thread;
	private boolean running = false;
	private Menu menu;
	private Random r= new Random(); 
	
	
	private Handler handler;
	private HUD hud;
	private Spawn spawner;
	
	
	
	public States gameState = States.Menu;
	
	public Game() {
		handler = new Handler();
		menu = new Menu(this, handler);
		this.addKeyListener(new KeyInput(handler));
		this.addMouseListener(menu);
		
		new Window();
		
		hud = new HUD();
		spawner = new Spawn(handler, hud);
		
		if(gameState == States.Game) {
		handler.addObject(new Player(WIDTH/2-32, HEIGHT/2-32 , ID.Player, handler));	
//		handler.addObject(new BasicEnemy((r.nextInt(Game.WIDTH)), (r.nextInt(Game.HEIGHT)), ID.BasicEnemy, handler));
		}
		
		
	}

	public synchronized void start() {
		thread = new Thread(this);
		thread.start();
		running = true;
	}
	public synchronized void stop() {
		try {
			thread.join();
			running = false;
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	public void run() {
		this.requestFocus();
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000/ amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int frames = 0;
		while(running) {
			long now = System.nanoTime();
			delta +=(now-lastTime)/ns;
			lastTime = now;
			while(delta>= 1) {
				tick();
				delta--;
			}
			if(running) 
				render();
			frames++;
			
			if(System.currentTimeMillis() - timer>1000) {
				timer+= 1000;
				System.out.println("FPS " + frames);
			}
		}
		stop();
	}
	private void tick() {
		handler.tick();
		if(gameState == States.Game) {
			hud.tick();
			spawner.tick();
		}
		else if(gameState == States.Menu) {
			menu.tick();
		}
		
	}
	private void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if(bs==null) {
			this.createBufferStrategy(3);
			return;
		}
		Graphics g = bs.getDrawGraphics();
		
		g.setColor(Color.black);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		handler.render(g);
		if(gameState == States.Game) {
		hud.render(g);
		}
		else if(gameState == States.Menu || gameState == States.Help) {
			menu.render(g);
		}
		
		g.dispose();
		bs.show();
	}
	
	public static float clamp(float var, float min, float max) {
		if(var>=max)
			return var = max;
		else if(var<=min) {
			return var = min;
		}
		else {
			return var;
		}
	}

//	public static void main(String[] args) {
//		new Game();
//	}
}
