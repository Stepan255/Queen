package Queen;

import java.util.ArrayList;

public class Repository {
	private ArrayList<int[]> placementList = null;

	public Repository() {
		placementList = new ArrayList<>();
	}

	public ArrayList<int[]> getPlacementList() {
		return placementList;
	}

	public void create(int[] ... placements){
		for (int[] placement : placements) {
			int[] temp = new int[placement.length];
			System.arraycopy(placement, 0, temp, 0, placement.length);
			placementList.add(temp);
		}
	}

	public String read(){
		String text = "";
		Parsere parse = new Parsere();
		for (int[] placement : placementList) {
			text += parse.convertToString(placement) + "\n";
		}
		return text; 
	}
}
