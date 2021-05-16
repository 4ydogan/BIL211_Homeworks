import java.io.File;
import java.util.Scanner;

public class KthReader {

	private static Scanner scan;

	public static void main(String[] args) {
		
		String fileName, number;
		int k;
		
		try {
			
			fileName = args[1];
			number = args[3];
			k = Integer.parseInt(number);
			
		}catch (Exception e) {
			
			fileName = args[3];
			number = args[1];
			k = Integer.parseInt(number);
			
		}
		
		int m = 1;
		int n = 0;
			
		try {
			File file = new File(fileName);
			scan = new Scanner(file);
			while(scan.hasNext()) {
				String keyword = scan.next();
				if(m % k == 0){
					System.out.println(keyword);
					n++;
				}
				m++;
			}
		}catch(Exception e) {
			System.exit(0);
		}
		
		System.out.println("==========");
		System.out.println("In total " + n + " words have been printed.");
	}
}
