import java.util.Scanner;

public class Sort {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		String str = scan.nextLine();

		String[] strArray = str.split(" ");					// to separate parts 
		int[] intArray = new int[strArray.length];			// to create a integer array
		
		for(int i=0; i<strArray.length; i++) {				//to convert from string array to integer array
			intArray[i] = Integer.parseInt(strArray[i]);
		}
		
		int[] array = sort(intArray);
		
	}
	
	public static int[] sort(int[] array) {
		
		if (array.length == 1) {							// the base case
					
			System.out.println(array[0]);
			
			return array;
		}
		
		int index = 0;										// to find minimum value
		int min = Integer.MAX_VALUE;
				
		for(int i=0; i<array.length; i++) {			
			if (array[i] <= min) {
				index = i;
				min = array[i];
			}
		}
		
		for(int i=index; i>0; i--) {						// to move the minimum value
			int temp = array[i];
			array[i] = array[i-1];
			array[i-1] = temp;
		}
		
		int[] newArray = new int[array.length-1];
		
		for(int i=0; i<newArray.length; i++) {
			newArray[i] = array[i+1];
		}
		
		int[] result = new int[array.length];
		
		result[0] = array[0];								// to save minimum value
		
		System.arraycopy(sort(newArray), 0, result, 1, newArray.length);
		// recursion call
		// to concatenate array and minimum value
		
		for(int i=0; i<result.length; i++) {					// this for block is to print as using two arrays
			
			System.out.print(result[i]);
				
			if(i<result.length-1)
				System.out.print(" ");
			else
				System.out.println();		
		}
		
		return result;
	}
}
