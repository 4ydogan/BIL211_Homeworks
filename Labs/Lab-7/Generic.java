

public class Generic {

	public static <T> void printArray(T[] array ) {
		String result = "";
		for(T t : array) {
			result += t + ", ";
		}
		System.out.println(result.substring(0,result.length()-2));
	}
	
	public static <T> T[] sort(T[] array ) {
		if(array instanceof String[]) {
			for (int i = 0; i < array.length-2; i++) {
				for (int j = 0; j < array.length-i-1; j++) {
					String str1 = (String)array[j];
					String str2 = (String)array[j+1];
					if(str1.compareTo(str2) >= 0) {
						T temp = array[j];
						array[j] = array[j+1];
						array[j+1] = temp;
					}
				}
			}
		}else if ( array instanceof Double[]){
			for (int i = 0; i < array.length-2; i++) {
				for (int j = 0; j < array.length-i-1; j++) {
					if((double)array[j] >= (double)array[j+1]) {
						T temp = array[j];
						array[j] = array[j+1];
						array[j+1] = temp;
					}
				}
			}
		}else if ( array instanceof Integer[]){
			for (int i = 0; i < array.length-2; i++) {
				for (int j = 0; j < array.length-i-1; j++) {
					if((int)array[j] >= (int)array[j+1]) {
						T temp = array[j];
						array[j] = array[j+1];
						array[j+1] = temp;
					}
				}
			}
		}
		
		return array;
	}
	
	public static <T> T findMiddle(T[] array ) {
		return array[(int)Math.floor((array.length-1)/2.0)];
	}
	
	public static <T> String concatenate(T[] array ) {
		String result = "";
		for (T t : array) {
			result += t;
		}
		return result;
	}

	  public static void main(String args[]) {
	    Integer[] integerArray = { 18362, 234, -3234, 0, 334655 };
	    Double[] doubleArray = { -1.1, 0.0, 34.34534, 987.346};
	    String[] stringArray = { "error:", "bad", "operand", "types", "for", "binary", "operator" };

	    //printArray prints given array with a comma and a space between each element
	    printArray(integerArray);
	    printArray(doubleArray);
	    printArray(stringArray);

	    //sort method sorts the given array in ascending order (you can implement any sorting algorithm)
	    Integer[] sortedIntegerArray = sort(integerArray);
	    Double[] sortedDoubleArray = sort(doubleArray);
	    String[] sortedStringArray= sort(stringArray);

	    printArray(sortedIntegerArray);
	    printArray(sortedDoubleArray);
	    printArray(sortedStringArray);

	    //findMiddle finds and returns the middle element of an array. if number of elements in the array is even, print the one with the smallest index.
	    System.out.println(findMiddle(sortedIntegerArray));
	    System.out.println(findMiddle(sortedDoubleArray));
	    System.out.println(findMiddle(sortedStringArray));
	    
	    //concatenate method returns a string that has the elements of the array added back to back
	    System.out.println(concatenate(sortedIntegerArray));
	    System.out.println(concatenate(sortedDoubleArray));
	    System.out.println(concatenate(sortedStringArray));
	  }
}

