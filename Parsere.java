package Queen;

public class Parsere {

	public String convertToString(int[] data) {
		String text = "";
		for (int i = 1; i < data.length; i++) {
			text += convertNumberToLatter(i) + "-" + data[i] + ";";
		}
		return text;
	}

	public String convertNumberToLatter(int data) {
		switch (data) {
			case 1:
				return "a";
			case 2:
				return "b";
			case 3:
				return "c";
			case 4:
				return "d";
			case 5:
				return "e";
			case 6:
				return "f";
			case 7:
				return "g";
			case 8:
				return "h";
			case 9:
				return "i";
			case 10:
				return "j";
			default:
			return String.valueOf(data);
		}
	}
}
