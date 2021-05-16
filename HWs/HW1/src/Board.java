
public class Board {
	
	private Piece[][] board = new Piece[8][8];
	//construct an empty board
	//set all to null
	public Board(){}
	
	public boolean putPiece(Piece p, String pos){	
		
		try {
			
			int[] indexOfPosition = indexOfPosition(pos);
			int a = indexOfPosition[0];
			int b = indexOfPosition[1];
			
			board[a][b] = p;			// puts the piece to board
			p.setPosition(pos);			// sets the position of the piece
			
			
		} catch (Exception e) {
			return false;
		}
		
		return true;
	}
	
	public Piece getPiece(String pos){	// get Piece on the given position
		
		try {
			int[] indexOfPosition = indexOfPosition(pos);
			int a = indexOfPosition[0];
			int b = indexOfPosition[1];
			
			return board[a][b];
			
		} catch (Exception e) {
			return null;
		}
	}
	
	public boolean check(String color){
		
		String kingPos = getPosOfKing(color);
			
		for (int i = 0; i < board.length; i++) {	// to check is there any threatening
			for (int j = 0; j < board.length; j++) {
				
				String posOfPiece = valueOf('a' + i) + valueOf('1' + j);
				
				try{
					if(!board[i][j].getColor().equals(color) && board[i][j].canMove(kingPos) && isWayEmpty(posOfPiece, kingPos) ) {
						
						return true;
					}
				}catch (Exception e) {}
			}
		}
		
		return false;
	}
	  
	public boolean checkMate(String color){
	  
		String kingPos = getPosOfKing(color);
		
		int[] indexOfPosition = indexOfPosition(kingPos);
		int a = indexOfPosition[0];
		int b = indexOfPosition[1];
		
		
		if(check(color)) {
			
			String[] movesOfKing = board[a][b].getAllMoves();
			
			for (int i = 0; i < movesOfKing.length; i++) {
				
				Piece[][] temp = copy();
				
				int[] index = indexOfPosition(movesOfKing[i]);
				int c = index[0];
				int d = index[1];
				
				if(isEmpty(movesOfKing[i]) || !temp[c][d].getColor().equals(color)) {
					temp[c][d] = board[a][b];
					temp[c][d].setPosition(movesOfKing[i]);
					if(!check(color)) {
						return false;
					}
				}
			}
			
			for (int i = 0; i < board.length; i++) {
				for (int j = 0; j < board.length; j++) {
					if(board[i][j].getColor().equals(color)) {
						Piece[][] temp = copy();
						
						String[] movesOfPiece = temp[a][b].getAllMoves();
						
						for (int k = 0; k < movesOfPiece.length; k++) {
							int[] index = indexOfPosition(movesOfPiece[k]);
							int c = index[0];
							int d = index[1];
							if(!temp[c][d].getColor().equals(color) || isEmpty(movesOfPiece[k])) {
								temp[c][d] = temp[i][j];
								temp[i][j] = null;
								temp[c][d].setPosition(movesOfPiece[k]);
							}
							if(!check(color))
								return false;
							
						}
					}
				}
			}
			return true;
		}
		
		return false;
	}
	  
	public boolean isEmpty(String pos) {
		
		int[] indexOfPosition = indexOfPosition(pos);
		int a = indexOfPosition[0];
		int b = indexOfPosition[1];
		
		if(board[a][b] == null) {
			return true;
		}
		
		return false;
	}
	
	public boolean isEmpty(int a, int b) {
		
		if(board[a][b] == null) {
			return true;
		}
		
		return false;
	}
	
	public int[] indexOfPosition(String position) {
		
		int[] result = new int[2];
		
		result[0] = position.charAt(0) - 'a' ;
		result[1] = 8-Integer.parseInt(position.substring(1));
		
		return result;
	}
	
	public String toString(){
		
		String screen = "";
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if(board[j][i] == null)
					screen += "o\t\t";
				else
					screen += board[j][i].getClass().getName() + "-" + board[j][i].getColor() + "\t";
			}
				screen += "\n\n";
		}
		return screen;
	}
	
	public String getPosOfKing(String color) {
		
		String kingPos = "a1";
		
		for (int i = 0; i < board.length; i++) {	// to find position of king
			for (int j = 0; j < board.length; j++) {
				try{
					if(board[i][j] instanceof King && board[i][j].getColor().equals(color)) {
						kingPos = valueOf('a'+i) + valueOf('1'+7-j);
						return kingPos;
					}
				}catch (Exception e) {}
			}
		}
		return kingPos;
	}
	
	public boolean isWayEmpty(String fromPos, String toPos) {
		
		int[] indexFromPos = indexOfPosition(fromPos);
		int a = indexFromPos[0];
		int b = indexFromPos[1];
		
		int[] indexToPos = indexOfPosition(toPos);
		int c = indexToPos[0];
		int d = indexToPos[1];
		
		if(board[a][b] instanceof Pawn) {
			if (board[a][b].getColor().equals("white")) {
				if(d-b == 2 && !isEmpty(a,b+1)){
					return false;
				}
				return true;
				
			}
			
			else if (board[a][b].getColor().equals("black")) {
				if(b-d == 2 && !isEmpty(a,b-1)){
					return false;
				}
				return true;
			}
			
			return true;
			
		}
		
		else if(board[a][b] instanceof Knight) {
			return true;
		}
		
		else if(board[a][b] instanceof King) {
			return true;
		}
		
		else {
			
			if (a > c && d == b) {
				for (int i = c+1; i < a; i++) {
					if(!isEmpty(i,d)) {
						return false;
					}
				}
				return true;
			}
			
			else if (c > a && d == b) {
				for (int i = a+1; i < c; i++) {
					if(!isEmpty(i,d)) {
						return false;
					}
				}
				return true;
			}
			
			else if (a == c && d > b) {
				for (int i = b+1; i < d; i++) {
					if(!isEmpty(a,i)) {
						return false;
					}
				}
				return true;
			}
			
			else if (a == c && b > d) {
				for (int i = d+1; i < b+1; i++) {
					if(!isEmpty(a,i)) {
						return false;
					}
				}
				return true;
			}
			
			else if (a > c && b > d) {
				try{
					for (int i = 1; i < a-c ; i++) {
						if(!isEmpty(c+i,d+i)) {
							return false;
						}
					}
				}catch (Exception e) {}
				
				return true;
			}
			
			else if (a > c && d > b) {
				try{
					for (int i = 1; i < a-c ; i++) {
						if(!isEmpty(c+i,d-i)) {
							return false;
						}
					}
				}catch (Exception e) {}
				
				return true;
			}
			
			else if (c > a && d > b) {
				try{
					for (int i = 1; i < c-a ; i++) {
						if(!isEmpty(c-i,d-i)) {
							return false;
						}
					}
				}catch (Exception e) {}
				
				return true;
			}
			
			else if (c > a && b > d) {
				try{
					for (int i = 1; i < c-a ; i++) {
						if(!isEmpty(c-i,d+i)) {
							return false;
						}
					}
				}catch (Exception e) {}
				
				return true;
			}
			
			else {
				return false;
			}
		}	
	}
	
	public Piece[][] copy(){
		Piece[][] result = new Piece[8][8];
		
		for (int i = 0; i < result.length; i++) {
			for (int j = 0; j < result.length; j++) {
				result[i][j] = board[i][j]; 
			}
		}
		return result;
	}
	
	public String valueOf(int x) {
		
		String result = String.valueOf((char)x);
		return result;
	}
}
