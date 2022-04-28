package field;

public class Slot {

	private Content content;
	private boolean status;

	public Slot() {

	}

	public Slot(Content content, boolean status) {
		this.content = content;
		this.status = status;
	}

	public Content getContent() {
		return content;
	}

	public boolean getPosition() {
		return status;
	}

	public boolean isThereABomb(Content content) {
		return false;
	}

	public void howManyBombsAround(int amount) {

	}

	@Override
	public String toString() {
		Content content = new Content();

		return String.format("" + content);
	}

}