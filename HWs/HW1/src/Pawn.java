import java.util.Arrays;

public class Pawn extends Piece {
	
	public Pawn(String color) {
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
		
		String[] result = new String[4];
		char a = getPosition().charAt(0);
		char b = getPosition().charAt(1);
		
		
		if(getColor() == "black") {	
			
			try{ 
				result[0] = valueOf(a-1) + valueOf(b+1);
				
			}catch(Exception e){}
			
			try {
				result[1] = valueOf(a) + valueOf(b+1);

			}catch(Exception e) {}
			
			try {
				if (b == 2) {
					result[2] = valueOf(a) + valueOf(b+2);
				}
				
			}catch(Exception e) {}
			
			try {
				result[4] = valueOf(a+1) + valueOf(b+1);
				
			}catch(Exception e) {}			
		}
				
		if(getColor() == "white") {
			
			try
			{
				result[0] = valueOf(a-1)   + valueOf(b-1);
				
			}catch(Exception e){}
			
			try 
			{
				result[1] = valueOf(a) + valueOf(b-1);

			}catch(Exception e) {}
			
			try {
				if (b == 7) {
					result[2] = valueOf(a) + valueOf(b+2);
				}
				
			}catch(Exception e) {}
			
			try 
			{
				result[4] = valueOf(a+1) + valueOf(b-1);
				
			}catch(Exception e) {}		
		}
		
		// throw null cell
		result = editArray(result);
		
		// to sort the array
		Arrays.sort(result);
		return result;
	
	}
}
