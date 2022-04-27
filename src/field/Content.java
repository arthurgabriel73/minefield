package field;

import java.util.Random;

public class Content {

	private boolean bomb;
	
	public Content() {
		
	}

	public Content(boolean bomb) {
		this.bomb = bomb;
	}

	public boolean isBomb() {
		return bomb;
	}

	public void setBomb(boolean bomb) {
		this.bomb = bomb;
	}
	
	public boolean isABomb() {
		
		Random random = new Random();
		int r = random.nextInt(6);
		
		if(r == 0) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public String toString() {
		
		if(isABomb()==true) {
			char c = 'B';
			return String.format("" + c);
		}
		else {
			char c = 'O';
			return String.format("" + c);
		}	
	}
}
