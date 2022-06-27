package Queen;

import java.util.ArrayList;
/**
 * Board - доска для шахмат
 */
public class Board {

	ArrayList<Cell> board = null;
	int size = 0;

	public Board(int sizeBoard) {
		this.size = sizeBoard;
		int sizeArray = sizeBoard * sizeBoard;
		board = new ArrayList<>(sizeArray);
		for (int i = 0; i < sizeArray; i++) {
			Cell cell = new Cell();
			board.add(cell);
		}
	}
		
	public void print(){
		int count = 0;
		for (Cell cell : board) {
			if (count == 8){
				count = 0;
				System.out.println();
			}
			if (cell.status == Cell.Status.occupied)
				System.out.print("X");
			else 
				System.out.print("0");
			count++;
		}
	}

	public int getIndexOfCell(int x, int y) {
		int index = x * this.size + y;
		if (index < 0 || index >= board.size()) index = - 1;
		return index;
	}

	public void occupationCell(QueenFigure figure) {
		board.get(figure.x * size + figure.y).occupation();;
	}

	public Boolean crossingOtherFigures(QueenFigure figure) {
		if (crossingOtherFiguresAsRook(figure) || crossingOtherFiguresAsElephant(figure)) 
			return true;
		return false;
	}

	public Boolean crossingOtherFiguresAsRook(QueenFigure figure) {
		if (crossingOtherFiguresAsRookRight(figure))  return true;
		if (crossingOtherFiguresAsRookLeft(figure)) return true;
		if (crossingOtherFiguresAsRookUp(figure)) return true;
		if (crossingOtherFiguresAsRookDown(figure)) return true;
		return false;
	}


	public Boolean crossingOtherFiguresAsRookRight(QueenFigure figure){
		for (int x = figure.x + 1; x < this.size; x++) {
			int index = getIndexOfCell(x, figure.y);
			if (index == -1) return false;
			if (board.get(index).status == Cell.Status.occupied) return true;
		}
		return false;
	}

	public Boolean crossingOtherFiguresAsRookLeft(QueenFigure figure){
		for (int x = figure.x - 1; x >= 0; x--) {
			int index = getIndexOfCell(x, figure.y);
			if (index == -1) return false;
			if (board.get(index).status == Cell.Status.occupied) {
				return true;
			}
		}
		return false;
	}

	public Boolean crossingOtherFiguresAsRookUp(QueenFigure figure){
		for (int y = figure.y + 1; y < this.size; y++) {
			int index = getIndexOfCell(figure.x, y);
			if (index == -1) return false;
			if (board.get(index).status == Cell.Status.occupied) {
				return true;
			}
		}
		return false;
	}

	public Boolean crossingOtherFiguresAsRookDown(QueenFigure figure){
		for (int y = figure.y - 1; y >= 0; y--) {
			int index = getIndexOfCell(figure.x, y);
			if (index == -1) return false;
			if (board.get(index).status == Cell.Status.occupied) {
				return true;
			}
		}
		return false;
	}

	

	public Boolean crossingOtherFiguresAsElephant(QueenFigure figure) {
		if (crossingOtherFiguresAsElephantUR(figure)) return true;
		if (crossingOtherFiguresAsElephantDR(figure)) return true;
		if (crossingOtherFiguresAsElephantDL(figure)) return true;
		if (crossingOtherFiguresAsElephantUL(figure)) return true;
		return false;
	}

	public Boolean crossingOtherFiguresAsElephantUR(QueenFigure figure){
		int x = figure.x + 1;
		int y = figure.y + 1;
		int index = getIndexOfCell(x, y);
		while (index != -1 && y < size && x < size) {
			if (board.get(index).status == Cell.Status.occupied) return true;
			index = getIndexOfCell(++x, ++y);
		}
		return false;
	}

	public Boolean crossingOtherFiguresAsElephantDR(QueenFigure figure){
		int x = figure.x + 1;
		int y = figure.y - 1;
		int index = getIndexOfCell(x, y);
		while (index != -1 && y >= 0 && x < size) {
			if (board.get(index).status == Cell.Status.occupied) return true;
			index = getIndexOfCell(++x, --y);
		}
		return false;
	}

	public Boolean crossingOtherFiguresAsElephantDL(QueenFigure figure){
		int x = figure.x - 1;
		int y = figure.y - 1;
		int index = getIndexOfCell(x, y);
		while (index != -1 && y >= 0 && x >= 0) {
			if (board.get(index).status == Cell.Status.occupied) return true;
			index = getIndexOfCell(--x, --y);
		}
		return false;
	}

	public Boolean crossingOtherFiguresAsElephantUL(QueenFigure figure){
		int x = figure.x - 1;
		int y = figure.y + 1;
		int index = getIndexOfCell(x, y);
		while (index != -1 && y < size && x >= 0) {
			if (board.get(index).status == Cell.Status.occupied) return true;
			index = getIndexOfCell(--x, ++y);
		}
		return false;
	}
}