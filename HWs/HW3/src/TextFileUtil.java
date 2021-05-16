import java.io.*;

public class TextFileUtil implements EncryptDecrypt{
	
	public TextFileUtil() {	}
	
	public static void main(String[] args) {
		TextFileUtil text = new TextFileUtil();
		
		text.encrypt("input.mustafa", "sd636434asda");
		text.decrypt("input.encr", "sd636434asda", "outputmust.txt");
	}
	
	public void encrypt(String inputFileName, String key) {
		BufferedReader reader = null;
		PrintWriter writer = null;
		
		String outputFileName = inputFileName.substring(0, inputFileName.indexOf('.')) + ".encr";
				
		try {
			reader = new BufferedReader(new InputStreamReader(new FileInputStream(new File(inputFileName))));
			System.out.println(1);
			writer = new PrintWriter(new OutputStreamWriter(new FileOutputStream(new File(outputFileName))));
			
			String line = reader.readLine();

			while(line != null) {
				System.out.println(line);
				for (int i = 0; i < line.length(); i++) {
					writer.write(encryptStr(line.charAt(i), key)); 
				}
				writer.println();
				line = reader.readLine();
			}
			
			reader.close();
			writer.close();
			System.out.println(inputFileName + " dosyasindan alinan veriler encrypt edilerek " +
								inputFileName.substring(0, inputFileName.indexOf('.')) + ".encr dosyasina yazildi." );
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
				for (int i = 0; i < line.length(); i++) {
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
		
		System.out.println(inputFileName + " dosyasindan alinan veriler decrypt edilerek " +
				outputFileName + " dosyasina yazildi." );
	}
	
	public static String encryptStr(char in, String key) {
		return String.valueOf((char)((in + hashedKey(key) + 128) % 128));
	}
	
	public static String decryptInt(char in, String key) {
		return String.valueOf((char)((in - hashedKey(key) + 128) % 128));
	}
	
	public static int hashedKey(String key) {
		return Math.abs((key.hashCode()) % 128) ;
	}
}
