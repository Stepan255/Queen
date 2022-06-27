package Queen;

/**
 * @param placement позиция 0 -пережиток прошлого,
 *                  на остальных позициях хранит расположение ферзей по вертикали
 */
public class QueenPlaceholder {
	private int[] placement = {};
	Repository repository = null;

	public QueenPlaceholder(int size) {
		placement = new int[size + 1];
		repository = new Repository();
	}

	public void printPlacement() {
		for (int i = 1; i < placement.length; i++) {
			System.out.print(placement[i] + ";");
		}
	}

	public void findPlacement() {
		findPlacement(1);
	}

	private void findPlacement(int index) {
		if (index > this.placement.length - 1) {
			if (corectPosition()) {
				repository.create(placement);
			}
		} else {
			for (int i = 1; i <= 8; i++) {
				this.placement[index] = i;
				findPlacement(index + 1);
			}
		}
	}

	private Boolean corectPosition() {
		Board board = new Board(this.placement.length - 1);
		for (int i = 1; i < this.placement.length; i++) {
			QueenFigure figure = new QueenFigure(i - 1, placement[i] - 1);
			board.occupationCell(figure);
			if (board.crossingOtherFigures(figure)) {
				return false;
			}
		}
		return true;
	}

}
