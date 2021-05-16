import java.util.Arrays;

public class Bishop extends Piece {
	
	public Bishop(String color) {
		setColor(color);
	}
	
	//Bos tahtada yapabilecegi hareketler
	public boolean canMove(String newPosition){
		
		String[] list = getAllMoves();
		
		for (int i = 0; i < list.length; i++) {
			if(list[i].equals(newPosition)) {
				return true;
			}
		}
		
		return false;
	}
	
	public String[] getAllMoves() {
		
		String[] result = new String[13];
		char a = getPosition().charAt(0);
		char b = getPosition().charAt(1);
		
		int index = 0;

		try {					// up and left movements
			while(true) {
				int k = 1;
				result[index] = valueOf(a-k) + valueOf(b+k);
				k++;
				index++;
				if(k >= 8 || index >= 13 || a-k <= 'a' || b+k >= '8') {
					break;
				}
			}
		}catch(Exception e) {}
		
		try {					// down and left movements
			while(true) {
				int k = 1;
				result[index] = valueOf(a-k) + valueOf(b-k);
				k++;
				index++;
				if(k >= 8 || index >= 13 || a-k <= 'a' || b-k <= '1') {
					break;
				}
			}
		}catch(Exception e) {}
		
		try {					// up and right movements
			while(true) {
				int k = 1;
				result[index] = valueOf(a+k) + valueOf(b+k);
				k++;
				index++;
				if(k >= 8 || index >= 13 || a+k >= 'h' || b+k >= '8') {
					break;
				}
			}
		}catch(Exception e) {}
		
		try {					// down and right movements
			while(true) {
				int k = 1;
				result[index] = valueOf(a+k) + valueOf(b-k);
				k++;
				index++;
				if(k >= 8 || index >= 13 || a+k >= 'h' || b-k <= '1') {
					break;
				}
			}
		}catch(Exception e) {}
		
		// throw null cell
		result = editArray(result);
		
		// to sort the array
		Arrays.sort(result);
		return result;
	}
}
