package field;

import java.util.Random;

public class Slot {
	
	private boolean content;
	private boolean status;

	public Slot() {

	}

	public Slot(boolean content, boolean status) {
		this.content = content;
		this.status = status;
	}

	public boolean isContent() {
		return content;
	}

	public void setContent(boolean content) {
		this.content = content;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public boolean isThereABomb() {

		Random random = new Random();
		int r = random.nextInt(6);

		if (r == 0) {
			return true;
		} else {
			return false;
		}
	}
	
	@Override
	public String toString() {

		if (isThereABomb() == true) {
			char c = 'B';
			return String.format("" + c);
		} else {
			char c = 'O';
			return String.format("" + c);
		}
	}

}