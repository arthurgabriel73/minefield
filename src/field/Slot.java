package field;

public class Slot {
	
	private Content content;
	private Position position;
	
	public Slot() {
		
	}
	

	public Slot(Content content, Position position) {
		this.content = content;
		this.position = position;
	}


	public Content getContent() {
		return content;
	}

	public Position getPosition() {
		return position;
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
