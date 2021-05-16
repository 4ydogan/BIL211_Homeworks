import java.io.*;

public class TextFileUtil2 implements EncryptDecrypt{
	
	public TextFileUtil2() {	}
	
	public static void main(String[] args) {
		TextFileUtil2 text = new TextFileUtil2();
		String key = "abcf";
		text.encrypt("inputFile.txt", key);
		text.decrypt("inputFile.txt.encr", key, "outputFile.txt");
	}

	public void encrypt(String inputFileName, String key) {
		BufferedReader reader = null;
		PrintWriter writer = null;
				
		try {
			reader = new BufferedReader(new InputStreamReader(new FileInputStream(new File(inputFileName))));
			writer = new PrintWriter(new OutputStreamWriter(new FileOutputStream(inputFileName+".encr")));
			
			String line = reader.readLine();

			while(line != null) {
//				System.out.println(line);
				for (int i = 0; i < line.length(); i++) {
					String a = "" + line.charAt(i);
					String b = encryptStr(line.charAt(i), key);
					System.out.println(a + "->" + b);
					writer.write(b); 
				}
				writer.println();
				line = reader.readLine();
			}
			
			reader.close();
			writer.close();
			System.out.println(inputFileName + " dosyasýndan alýnan veriler encrypt edilerek " +
								inputFileName + ".encr dosyasýna yazýldý." );
		}catch(Exception e) {
			System.out.println("Error1!");
			System.exit(0);
		}
	}

	public void decrypt(String inputFileName, String key, String outputFileName) {
		BufferedReader reader = null;
		PrintWriter writer = null;
				
		try {
			reader = new BufferedReader(new InputStreamReader(new FileInputStream(new File(inputFileName))));
			writer = new PrintWriter(new OutputStreamWriter(new FileOutputStream(outputFileName)));
			
			String line = reader.readLine();

			while(line != null) {
//				System.out.println(line);
				for (int i = 0; i < line.length(); i++) {
					String a = "" + line.charAt(i);
					String b = decryptInt(line.charAt(i), key);
					System.out.println(a + "->" + b);
					writer.write(decryptInt(line.charAt(i), key)); 
				}
				writer.println();
				line = reader.readLine();
			}
				
			reader.close();
			writer.close();
			
		}catch(Exception e) {
			System.out.println("Error2!");
			System.exit(0);
		}
		
		System.out.println(inputFileName + " dosyasýndan alýnan veriler decrypt edilerek " +
				inputFileName + " dosyasýna yazýldý." );
	}
	
	public static String encryptStr(char in, String key) {
		System.out.println((0+in) + "->" + ((in + hashedKey(key) + 155) % 155));
		
		return String.valueOf((char)((in + hashedKey(key) + 155) % 155));
	}
	
	public static String decryptInt(char in, String key) {
		return String.valueOf((char)((in - hashedKey(key) + 155) % 155));
	}
	
	public static int hashedKey(String key) {
		return Math.abs((key.hashCode()) % 30);
	}
}
