// Brijesh Patel 3670789
// Two player Pong game
import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

public class Pong extends Canvas implements Runnable{
	
	public static Paddle player;
	public static Player2 player2;
	public static Ball ball;
	GrabKeys input;
	
	JFrame frame;
	public final int width = 700;
	public final int height = 700;
	public final Dimension sizeOfWindow = new Dimension(width, height);
	public final String titleOfGame = "Assignment 5";
	// creates visible image on canvas.
	BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
	static boolean gameStarted = false;
	int player1Score = 0, player1Hits = 0, player2Score = 0, player2Hits = 0;
	Thread thread;
	
	public void run() {
		
		while(gameStarted  == true)
		{
			change();
			generate();
			
			// Slow down paddle
			try{
				Thread.sleep(5);
			}catch(Exception e)
			{
				e.printStackTrace();
			}
		}		
		
	}
	
	public void startGame()
	{
		gameStarted = true;
		thread = new Thread(this);
		thread.start();
	}
	
	public static void stopGame()
	{
		gameStarted = false;
		System.exit(0);
	}
	
	private void generate() {
		Graphics g;
		
		
		BufferStrategy strategy =  getBufferStrategy();
		
		if(strategy == null)
		{
		   createBufferStrategy(3);
			return;	
		}
		
		g = strategy.getDrawGraphics();
		
		g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
		
		g.setColor(Color.WHITE);

		// Put text in front of background
		// This text keeps out score
		g.drawString("<-ScoreBoard->", 250, 10);
		g.drawString("Player1-Hits:" + player1Hits, 122, 10);
		g.drawString("Player1Score: " + player1Score, 0, 10);
		g.drawString("Player2: Score: " + player2Score, 450, 10);
		g.drawString("Player2-Hits: " + player2Hits, 604, 10);
		
		
		// Put paddles in front of Background
		//Create Image on canvas, of paddles, and ball
		player.generate(g);
		player2.generate(g);
		ball.generate(g);
			
		g.dispose();
		strategy.show();
		
	}
	// Keep game updating 
	private void change() {
		player.change(this);
		player2.change(this);
		ball.change(this);
	}

	public Pong()
	{
		frame = new JFrame();
		setMinimumSize(sizeOfWindow);
		setPreferredSize(sizeOfWindow);
		setMaximumSize(sizeOfWindow);
		
		frame.add(this, BorderLayout.CENTER);
		frame.pack();
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setVisible(true);
		frame.setTitle(titleOfGame);

		// Create our two players 
		player = new Paddle(0, 40);
		player2 = new Player2(684, 40);
		
		// start ball of at center of the screen
		ball = new Ball(getWidth() / 2, getHeight() / 2);
		
		// We need to capture the keystrokes of the players 
		input = new GrabKeys(this);
		frame.addKeyListener(input);
				
	}
	
	public static void main(String[]args)
	{
		// start game(pong class)
		Pong pong =  new Pong();
		pong.startGame();
	}

}
