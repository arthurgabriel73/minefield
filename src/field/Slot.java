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

	public boolean isContent() {
		return content;
	}
	public boolean getContent() {
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
}