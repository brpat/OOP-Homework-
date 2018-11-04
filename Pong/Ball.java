import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;


public class Ball {
	
    public int xCoord;
	public int yCoord;
	public int sizeOfBall = 20;
	
	int x;
	int y;
	
	Rectangle collisionDetector;
	
	public Ball(int xCoord, int yCoord)
	{
		this.xCoord = xCoord;
		this.yCoord = yCoord;
		
		x = 2;
		y = 2;
		
		collisionDetector = new Rectangle(xCoord, yCoord, sizeOfBall, sizeOfBall);
		collisionDetector.setBounds(xCoord, yCoord, sizeOfBall, sizeOfBall);
	}
	
	public void change(Pong pong)
	{
		// move ball right
			if (xCoord <= 0)	
			{
				pong.player2Score++;
				x = 3;
			}
			else if(xCoord >= pong.getWidth())
			{
				// The ball has gotten past player2
				pong.player1Score++;
				// move ball left
				x = -3;
			}
			
			if(yCoord <= 0)
			{
				// move ball up
				y = 2;
			}
			else if(yCoord  + sizeOfBall >= pong.getHeight())
			{
				// move ball down
				y = -2;
			}
			xCoord+= x;
			yCoord+= y;
			
			collisionDetector.setBounds(xCoord, yCoord , sizeOfBall, sizeOfBall);
			
			collision(pong);
	}
	
	private void collision(Pong pong)
	{
		// If ball hits either paddle. Update hits score and bounce the other way.
		if(collisionDetector.intersects(pong.player.collisionDetector))
			{
				x = 2;
				pong.player1Hits++;
			}
		else if(collisionDetector.intersects(pong.player2.collisionDetector))
			{	
				x = -2;
				pong.player2Hits++;
			}
		
	}		
	
	public void generate(Graphics g)
	{
		g.setColor(Color.gray);
		g.fillOval(xCoord, yCoord, sizeOfBall, sizeOfBall);
	}
}
