import java.util.Arrays;

public class Piece {
	
	private String position;
	private String color;
	
	public Piece(String color) {
		setColor(color);
	}
	
	public Piece() {}
	
	public boolean canMove(String newPosition){
		
		String[] list = getAllMoves();
		
		for (int i = 0; i < list.length; i++) {
			if(list[i].equals(newPosition)) {
				return true;
			}
		}
		
		return false;
	}
	
	//Hamleleri alfabetik sirada doner
	public String[] getAllMoves() {
		String[] emptyBoard = new String[64];
		
		int index = 0;
		
		while (index < 64) {
			
			for (int j = 0; j < 8; j++) {
				for (int k = 0; k < 8; k++) {
					emptyBoard[index] = String.valueOf('a'+j) + String.valueOf(k);
					index++;
				}
			}
		}
		
		Arrays.sort(emptyBoard);
		
		return emptyBoard;
	}
	
	public void setPosition(String newPosition){
		position = newPosition;
	}
	
	public void setColor(String color){
		this.color = color;
	}
	
	
	public String getPosition(){
		return position;
	}
	
	
	public String getColor(){
		return color;
	}
	
	public int[] indexOfPosition(String position) {
		
		int[] result = new int[2];
		
		result[0] = position.charAt(0) - 'a' ;
		result[1] = 8 - Integer.parseInt(position.substring(1));
		
		return result;
	}
	
	public String[] editArray(String[] arr){
		
		int k = 0;
		
		for (int i = 0; i < arr.length; i++) {
			if(arr[i] == null) {
				k++;
			}
		}
		
		String[] result = new String[arr.length-k];
		k = 0;
		
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != null) {
				result[k] = arr[i];
				k++;
			}
		}
		
		return result;
	}
	
	public String valueOf(int x) {
		
		String result = String.valueOf((char)x);
		return result;
	}

}
