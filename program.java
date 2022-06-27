package Queen;

public class Program {
	public static void main(String[] args) {
		int sizeBoard = 8;
		QueenPlaceholder placeholder = new QueenPlaceholder(sizeBoard);
		placeholder.findPlacement();
		System.out.println(placeholder.repository.read());
		System.out.println("Всего: " + placeholder.repository.getPlacementList().size() + " возможные расстановоки");
	}
}
