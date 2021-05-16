abstract class Inner {
	// This method should add up the given parameters print it once then return the
	// sum.
	public abstract int printAndReturnSum(int a, int b);

	// This method calculates square of a and then prints the result.
	public abstract void printSquared(int a);

	// This method should capitalize the first character of every word then return
	// the result.
	public abstract String returnProper(String ss);

	// This method should return the string given as input in reverse.
	public abstract void printInReverse(String s);
}

public class Tangible {
	public static void main(String[] args) {
		Inner obj = new Inner() {

			public int printAndReturnSum(int a, int b) {
				System.out.println(a + b);
				return a + b;
			}

			public void printSquared(int a) {
				System.out.println(a*a);
			}

			public String returnProper(String ss) {
				String[] words = ss.split(" ");
				String result = "";
				
				for (int i = 0; i < words.length; i++) {
					words[i] = words[i].substring(0,1).toUpperCase() + words[i].substring(1);
					result = result + words[i] + " ";
				}
				
				result = result.substring(0, result.length()-1);
				
				return result;
			}

			public void printInReverse(String s) {
				System.out.print(s.charAt(s.length()-1));
				if (s.length() > 1) {
					printInReverse(s.substring(0,s.length()-1));
				}
			}
		};
		
		int sum = obj.printAndReturnSum(12, 85);
		obj.printSquared(sum);
		String proper = obj.returnProper("Lorem ipsum dolor sit amet, consectetur adipiscing elit");
		obj.printInReverse(proper);
	}
}