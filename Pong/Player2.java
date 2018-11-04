import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;


public class Player2 {
	int xCoord;
	int yCoord;
	int width = 15;
	// make paddle a third of the height of the window
	int height = 700 / 3;
	float speed = (float) 1.90;
	
	Rectangle collisionDetector;
	
	boolean moveUp  = false;
	boolean moveDown = false;
	
	public Player2(int xCoord, int yCoord)
	{
		this.xCoord = xCoord;
		this.yCoord = yCoord;
		collisionDetector = new Rectangle(xCoord, yCoord, width, height);
		collisionDetector.setBounds(xCoord, yCoord, width, height);
	}
	
	public void change(Pong pong)
	{collisionDetector.setBounds(xCoord, yCoord, width, height);
		// move paddle up and down
		// this also prevents paddle from going out of the screen
	
		if(moveUp == true && yCoord > 0)
			yCoord-=2;
		
		if(moveDown == true && yCoord + height < pong.height)
			yCoord+=2;
		
	}
	
	public void generate(Graphics g)
	{
		// color in computer's paddle
		g.setColor(Color.CYAN);
		g.fillRect(xCoord, yCoord, width, height);
	}
}