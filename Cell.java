package Queen;

public class Cell {
	
	Status status = null;

	public Cell() {
		status = Status.free;
	}

	public enum Status{
		occupied,
		free
	}
	
	public void occupation() {
		status = Status.occupied;
	}

	public void toFree() {
		status = Status.free;
	}
}
