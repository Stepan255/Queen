package Queen;

public class Program {
	public static void main(String[] args) {
		int sizeBoard = 8;
		QueenPlaceholder qp = new QueenPlaceholder(sizeBoard);
		qp.findPlacement();
		System.out.println(qp.repository.read());
		System.out.println("Всего: " + qp.repository.getPlacementList().size() + " возможные расстановоки");
	}
}
