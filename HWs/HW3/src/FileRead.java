import java.io.*;

public class FileRead {
	public static void main(String[] args) {
		
		BufferedReader br = null;
		
		try{
			br = new BufferedReader(new InputStreamReader(new FileInputStream(new File("inputFile.txt.encr"))));
		}catch(Exception e ) {}
		
		try {
			while(true) {
				String str = br.readLine();
				System.out.println(str);
				if(str == null)
					break;
			}
		}catch (Exception e) {}
	}
}
