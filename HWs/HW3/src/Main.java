
public class Main {

	public static void main(String[] args) {
		TextFileUtil text = new TextFileUtil();
		String key = "abcabc";
		System.out.println(Math.abs(key.hashCode() % 256)); 
	}

}
