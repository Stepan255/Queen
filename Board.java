package Queen;

/**
 * Board - доска для шахмат
 * @param board - горизонтальная нумерация (есть метод для перевода в буквы)
 * @param board [] - вертикальная нумерация
 */
public class Board {

	int[][] board = {};

	public Board(int sizeBoard) {
		board = new int[sizeBoard][sizeBoard];
	}
}