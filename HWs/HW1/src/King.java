import java.util.Arrays;

public class King extends Piece {
	
	public King(String color) {
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
		
		String[] result = new String[9];
		char a = getPosition().charAt(0);
		char b = getPosition().charAt(1);
		
		int index = 0;
		
		for (int i = -1; i <= 1; i++) {
			for (int j = -1; j <= 1; j++) {
				try {
					if(i != 0 || j != 0) {
						result[index] = valueOf(a+i) + valueOf(b+j);
					}
				}catch (Exception e) {}
				index++;
			}
		}
				
		// throw null cell
		result = editArray(result);
		
		// to sort the array
		Arrays.sort(result);
		return result;
	}
	
	
}
