import java.util.Scanner;

public class KAralik {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		String str = scan.nextLine();
		
		String dizi = str.substring(0, str.indexOf(","));
		int k =  Integer.parseInt(str.substring(str.indexOf(",")+2));
		
		String[] strArray = dizi.split(" ");							// to separate parts
		int[] intArray = new int[strArray.length];						// to create a integer array
		
		for(int i=0; i<strArray.length; i++) {							//to convert from string array to integer array
			intArray[i] = Integer.parseInt(strArray[i]);
		}
		
		aralikliYaz(intArray, k);
	}
	
	
	public static void aralikliYaz(int[] arr, int k) {
		
		if(k > arr.length)												//base case
			return;
		
		System.out.print(arr[arr.length-k] + " ");						// to print
		
		int[] newArray = new int[arr.length-k];							// to create a new integer array
		
		for(int i=0; i<arr.length-k; i++) {
			newArray[i] = arr[i];
		}
		
		aralikliYaz(newArray, k);
	}	
}
