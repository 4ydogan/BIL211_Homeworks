
public class MatMul {
	
	public static void main(String[] args) {
		
		Double[][] M = new Double[3][5];
		Short[][] N = new Short[5][7];
		
		Double x = 0.0;
		
		for (int i = 0; i < M.length; i++) {
			for (int j = 0; j < M[0].length; j++) {
				M[i][j] = x;
				x++;
			}
		}	
		
		short y = 0;
		
		for (int i = 0; i < N.length; i++) {
			for (int j = 0; j < N[0].length; j++) {
				N[i][j] = y;
				y++;
			}
		}	
		try {
			
			Double[][] A = MatMul.<Double,Short>multiply(M,N);
			
			for (int i = 0; i < A.length; i++) {
				for (int j = 0; j < A[0].length; j++) {
					System.out.print(A[i][j] + " \t");
				}
				System.out.println();
			}

		}catch(CannotBeMultiplied e) {
			System.out.println(e.getMessage());
			System.exit(0);
		}catch(Exception e) {
			System.out.println("Error!");
			System.exit(0);
		}
		
			
	}
	
	
	public static <E, F> Double[][] multiply(E[][] e, F[][] f) throws CannotBeMultiplied{
		Double[][] eArray = convertDouble(e);
		Double[][] fArray = convertDouble(f);
		
		int length1 = eArray.length;
		int length2 = fArray[0].length;
		int length3 = eArray[0].length;
		int length4 = fArray.length;
		
		Double[][] myArray = new Double[length1][length2];
		
		if(!canMultiply(eArray, fArray)) {
			throw new CannotBeMultiplied();
		}
		
		Double c = 0.0;
		
		for(int i=0; i<length1; i++) {
	       
			for(int j=0; j<length2; j++) {  
	        
				for (int k=0; k<length4; k++) { 
	                c= c + eArray[i][k] * fArray[k][j];  
	            }
	          
				myArray[i][j] = c;
	            c = 0.0;
	        }
	    }
		
		return myArray;
	}
	
	public static <T> Double[][] convertDouble(T[][] t ) {
		Double[][] tArray = new Double[t.length][t[0].length];
		
		for (int i = 0; i < tArray.length; i++) {
			for (int j = 0; j < tArray[0].length; j++) {
				tArray[i][j] = Double.valueOf("" + t[i][j]);
			}
		}
		
		return tArray;
	}
	
	public static boolean canMultiply(Double[][] a, Double[][] b) {
		if(a[0].length == b.length)
			return true;
		return false;
	}
}
