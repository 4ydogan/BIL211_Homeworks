import java.util.Arrays;

public class Queen extends Piece {

	public Queen(String color) {
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
		// queen has rook and bishop moves
		
		String[] result = new String[27];
		char a = getPosition().charAt(0);
		char b = getPosition().charAt(1);
		
		int index = 0;
		
		try {
			while(true) {
				int k = 1;
				result[index] = valueOf(a) + valueOf(b+k);
				k++;
				index++;
				if(k >= 8 || index >= 27 || b+k >= '8') {
					break;
				}
			}
		}catch(Exception e) {}
		
		try {
			while(true) {
				int k = 1;
				result[index] = valueOf(a) + valueOf(b-k);
				k++;
				index++;
				if(k >= 8 || index >= 27 || b-k <= '1') {
					break;
				}
			}
		}catch(Exception e) {}
		
		try {
			while(true) {
				int k = 1;
				result[index] = valueOf(a+k) + valueOf(b);
				k++;
				index++;
				if(k >= 8 || index >= 27 || a+k >= 'h') {
					break;
				}
			}
		}catch(Exception e) {}
		
		try {
			while(true) {
				int k = 1;
				result[index] = valueOf(a-k) + valueOf(b);
				k++;
				index++;
				if(k >= 8 || index >= 27 || a-k <= 'a') {
					break;
				}
			}
		}catch(Exception e) {}
		
		try {
			while(true) {
				int k = 1;
				result[index] = valueOf(a-k) + valueOf(b+k);
				k++;
				index++;
				if(k >= 8 || index >= 27 || a-k <= 'a' || b+k >= '8') {
					break;
				}
			}
		}catch(Exception e) {}
		
		try {
			while(true) {
				int k = 1;
				result[index] = valueOf(a-k) + valueOf(b-k);
				k++;
				index++;
				if(k >= 8 || index >= 27 || a-k <= 'a' || b-k <= '1') {
					break;
				}
			}
		}catch(Exception e) {}
		
		try {
			while(true) {
				int k = 1;
				result[index] = valueOf(a+k) + valueOf(b+k);
				k++;
				index++;
				if(k >= 8 || index >= 27 || a+k >= 'h' || b+k >= '8') {
					break;
				}
			}
		}catch(Exception e) {}
		
		try {
			while(true) {
				int k = 1;
				result[index] = valueOf(a+k) + valueOf(b-k);
				k++;
				index++;
				if(k >= 8 || index >= 27 || a+k >= 'h' || b-k <= '1') {
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
