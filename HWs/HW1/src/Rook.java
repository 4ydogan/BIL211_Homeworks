import java.util.Arrays;

public class Rook extends Piece {
	
	public Rook(String color) {
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
		
		// create an empty array 
		String[] result = new String[14];
		char a = getPosition().charAt(0);
		char b = getPosition().charAt(1);
		
		int index = 0;
		
		
		// moves to up
		try {
			while(true) {
				int k = 1;
				result[index] = valueOf(a) + valueOf(b+k);
				k++;
				index++;
				if(k >= 8 || index >=14 || b+k >= '8') {
					break;
				}
			}
		}catch(Exception e) {}
		
		// moves to down
		try {
			while(true) {
				int k = 1;
				result[index] = valueOf(a) + valueOf(b-k);
				k++;
				index++;
				if(k >= 8 || index >=14 || b-k <= '1') {
					break;
				}
			}
		}catch(Exception e) {}
		
		// moves to right
		try {
			while(true) {
				int k = 1;
				result[index] = valueOf(a+k) + valueOf(b);
				k++;
				index++;
				if(k >= 8 || index >=14 || a+k >= 'h') {
					break;
				}
			}
		}catch(Exception e) {}
		
		// moves to left
		try {
			while(true) {
				int k = 1;
				result[index] = valueOf(a-k) + valueOf(b);
				k++;
				index++;
				if(k >= 8 || index >=14 || a-k <= 'a') {
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
