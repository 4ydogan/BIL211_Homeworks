import java.util.Arrays;

public class Knight extends Piece{
	
	public Knight(String color) {
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
		
		String[] result = new String[8];
		char a = getPosition().charAt(0);
		char b = getPosition().charAt(1);
		
		try
		{
			result[0] = valueOf(a-2) + valueOf(b+1);
			
		}catch(Exception e){}
		
		try 
		{
			result[1] = valueOf(a-1) + valueOf(b+2);

		}catch(Exception e) {}
		
		try {
			result[2] = valueOf(a+1) + valueOf(b+2);
						
		}catch(Exception e) {}
		
		try 
		{
			result[3] = valueOf(a+2) + valueOf(b+1);
			
		}catch(Exception e) {}	
		
		try 
		{
			result[4] = valueOf(a-2) + valueOf(b-1);
			
		}catch(Exception e) {}	
		
		try 
		{
			result[5] = valueOf(a-1) + valueOf(b-2);
			
		}catch(Exception e) {}	
		
		try 
		{
			result[6] = valueOf(a+1) + valueOf(b-2);
			
		}catch(Exception e) {}	
		
		try 
		{
			result[7] = valueOf(a+2) + valueOf(b-1);
			
		}catch(Exception e) {}	
		
		// throw null cell
		result = editArray(result);
		
		// to sort the array
		Arrays.sort(result);
		return result;
	}
}
