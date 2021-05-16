import java.io.*;
import java.util.Scanner;

public class FindReplace {
	public static void main(String[] args) {
		String inputFile = "", outputFile = "", replace = "", find = "";
		
		try{
			String[] elementOArgs = elementOfArgs(args);
	
			replace = elementOArgs[0];
			inputFile = elementOArgs[1];
			outputFile = elementOArgs[2];
			find = elementOArgs[3];
		}catch (Exception e) {}
		
		String[] willBeReplaced = editReplace(replace);
				
		try{
			Scanner input = new Scanner(new File(inputFile));
			BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File(outputFile))));
			
			while(input.hasNext()) {
				String next = input.nextLine();
				String[] temp = next.split(" ");
				
				for (int i = 0; i < temp.length; i++) {
					
					if(find(willBeReplaced, temp[i])) {
						writer.write(next.replaceFirst(temp[i], find));
						
					}else {
						writer.write(temp[i]);
					}
				}	
			}
			
			input.close();

		}catch (Exception e) {
			System.out.println("Error!");
			System.exit(0);
		}
	}
	
	public static String[] editReplace(String replace) {
		if(replace.indexOf("?") != -1 && replace.indexOf("\\?") == -1) {
			String[] result = new String[256];
			char letter = (char)0;
			for (int i = 0; i < result.length; i++) {
				letter = (char)(letter+1);
				result[i] = replace.replace('?', letter);
			}
			return result;
		}else if(replace.indexOf("[") != -1 && replace.indexOf("\\[") == -1) {
			
			int length = replace.lastIndexOf("]") - replace.indexOf("[") + 1;
			String[] result = new String[length/2];
			
			String first = replace.substring(0, replace.indexOf("["));
			String middle = replace.substring(replace.indexOf("[") + 1, replace.indexOf("]") - 1);
			String last = replace.substring(replace.indexOf("]")+1);
			String[] letters = middle.split(",");
			
			for (int i = 0; i < result.length; i++) {
				result[i] = first + letters[i] + last;
			}
			
			return result;
		}else if(replace.indexOf("\\[") != - 1 || replace.indexOf("\\]") != -1) {
			
			String[] result = new String[1];
			replace = replace.replace("\\", "");
			
			result[0] = replace;
			
			return result;
		}else {
			String[] result = new String[1];
			result[0] = replace;
			
			return result;			
		}
	}

	public static boolean find(String[] arr, String finding) {
		for (int i = 0; i < arr.length; i++) {
			if(arr[i].equals(finding))
				return true;
		}
		
		return false;
	}
	
	public static String[] elementOfArgs(String[] args) {
		
		String[] result = new String[4]; 
		String inputFile = "", outputFile = "", replace = "", find = "";
		
		switch (args[0]) {
		case "-r":
			replace = args[1];
			break;
		case "-i":
			inputFile = args[1];
			break;
		case "-o":
			outputFile = args[1];
			break;
		case "-f":
			find = args[1];
			break;
		default:
			break;
		}
		
		switch (args[2]) {
		case "-r":
			replace = args[3];
			break;
		case "-i":
			inputFile = args[3];
			break;
		case "-o":
			outputFile = args[3];
			break;
		case "-f":
			find = args[3];
			break;
		default:
			break;
		}
		
		switch (args[4]) {
		case "-r":
			replace = args[5];
			break;
		case "-i":
			inputFile = args[5];
			break;
		case "-o":
			outputFile = args[5];
			break;
		case "-f":
			find = args[5];
			break;
		default:
			break;
		}
		
		switch (args[6]) {
		case "-r":
			replace = args[7];
			break;
		case "-i":
			inputFile = args[7];
			break;
		case "-o":
			outputFile = args[7];
			break;
		case "-f":
			find = args[7];
			break;
		default:
			break;
		}
		
		result[0] = replace;
		result[1] = inputFile;
		result[2] = outputFile;
		result[3] = find;
		
		return result;
	}
}









