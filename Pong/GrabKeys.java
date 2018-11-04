import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GrabKeys implements KeyListener {
 // Player 1 keys : UP and DOWN. Player 2 keys A and Z
	public GrabKeys(Pong pong)
	{
		pong.addKeyListener(this);
	}
	
	public void keyPressed(KeyEvent e) {
		
	int k = e.getKeyCode();

		if (k == KeyEvent.VK_UP)	 
		 Pong.player2.moveUp = true;
		
		if(k == KeyEvent.VK_DOWN)
			Pong.player2.moveDown = true;	

		if (k == KeyEvent.VK_A)	 
		 Pong.player.moveUp = true;

		if (k == KeyEvent.VK_Z)	 
		 Pong.player.moveDown = true;
				
	}

	public void keyReleased(KeyEvent key) {
		
		int k = key.getKeyCode();
		
		if (k == KeyEvent.VK_UP)	 
			 Pong.player2.moveUp = false;
			
		if(k == KeyEvent.VK_DOWN)
			Pong.player2.moveDown = false;	

		if (k == KeyEvent.VK_A)	 
			 Pong.player.moveUp = false;

		if (k == KeyEvent.VK_Z)	 
			 Pong.player.moveDown =false;
	}

	@Override
	public void keyTyped(KeyEvent key) {
		
		// Have to keep this function, as its part of an interface
		// It serves no purpose
	}

}
