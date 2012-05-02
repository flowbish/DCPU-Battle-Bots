import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.Game;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

public class Test implements Game {
	
	public static void main(String[] args) {
		try {
			AppGameContainer container = new AppGameContainer(new Test());
			container.setDisplayMode(480, 480, false);
			container.start();
		} catch (SlickException e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean closeRequested() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public String getTitle() {
		// TODO Auto-generated method stub
		return "Test";
	}

	@Override
	public void init(GameContainer arg0) throws SlickException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(GameContainer arg0, Graphics arg1) throws SlickException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(GameContainer arg0, int arg1) throws SlickException {
		// TODO Auto-generated method stub
		
	}
}
