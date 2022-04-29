package field;


public class Slot {

	private boolean content;
	private boolean status;

	public Slot() {

	}

	public Slot(boolean content, boolean status) {
		this.content = content;
		this.status = status;
	}

	public Slot(boolean content) {
		this.content = content;
	}

	public boolean getContent() {
		return content;
	}

	public void setMine(boolean mine) {
		this.content = mine;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
}