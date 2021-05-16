import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class University {
	public static void main(String[] args) {
		
		Scanner keyboard = new Scanner(System.in);
		String[] person;
		String[][] myStorage;
		Object obj;
		
		try {
			obj = keyboard.nextInt();
		}catch (Exception e) {
			obj = keyboard.nextLine();
		}
		
		keyboard.close();
		myStorage = createStorage();
		
		try {
			person = findPerson(obj, myStorage);
			String id, name, grade, department;
			
			id = person[0];
			name = person[1];
			grade = person[2];
			department = person[3];
			
			System.out.println(id + " - " + name + ": " + grade + " (" + department + ")");
		}catch(InvalidSearchException e) {
			System.out.println(e.getMessage());
		}		
	}
	
	// creates a storage that includes name, id, grade and department
	public static String[][] createStorage(){
		Scanner input;
		String[][] myStorage;
		ArrayList<String[]> clasroomList = new ArrayList<>();
		ArrayList<String[]> gradesList = new ArrayList<>();
		ArrayList<String[]> departmentsList = new ArrayList<>();
		
		
		// reads people from Clasroom.txt and write an ArrayList
		try{
			File clasroom = new File("Classroom.txt");
			input = new Scanner(clasroom);
			
			while(input.hasNext()) {
				String line = input.nextLine();
				String[] person = line.split(",");
								
				clasroomList.add(person);
			}
			input.close();
		}catch (Exception e) {
			System.out.println("Error");
			System.exit(0);
		}
		
		// reads grades from Grades.txt and write an ArrayList
		try{
			File grades = new File("Grades.txt");
			input = new Scanner(grades);
			
			while(input.hasNext()) {
				String line = input.nextLine();
				String[] person = line.split(";");
											
				for (int i = 0; i < person.length; i++) {
					String temp = person[i];
					String[] tempPerson = temp.split(":");
					gradesList.add(tempPerson);
				}
			}
			
			input.close();
		}catch (Exception e) {
			System.out.println("Error");
			System.exit(0);
		}
		
		
		// reads departments from Departments.txt and write an ArrayList
		try{
			File departmens = new File("Departments.txt");
			input = new Scanner(departmens);
			
			while(input.hasNext()) {
				String line = input.nextLine();
				String[] person = line.split("-");
												
				departmentsList.add(person);
			}
			
			input.close();
		}catch (Exception e) {
			System.out.println("Error");
			System.exit(0);
		}
		
		myStorage = new String[clasroomList.size()][4];
		
		// to add person from classroom list to my storage
		for (int i = 0; i < myStorage.length; i++) {
			for (int j = 0; j < clasroomList.get(i).length; j++) {
				myStorage[i][j] = clasroomList.get(i)[j];
			}
		}
		
		// to add grades from grades list to my storage
		for (int i = 0; i < myStorage.length; i++) {
			for (int j = 0; j < gradesList.get(i).length; j++) {
				for (int j2 = 0; j2 < myStorage.length; j2++) {
					if(myStorage[i][0].equals(gradesList.get(j2)[0]) ) {
						myStorage[i][2] = gradesList.get(j2)[1];
						break;
					}
				}
			}
		}
		
		// to add department of person from department list to my storage
		for (int i = 0; i < myStorage.length; i++) {
			for (int j = 0; j < departmentsList.get(i).length; j++) {
				for (int j2 = 0; j2 < myStorage.length; j2++) {
					if(myStorage[i][1].equals(departmentsList.get(j2)[0]) ) {
						myStorage[i][3] = departmentsList.get(j2)[1];
						break;
					}
				}
			}
		}
		
		return myStorage;
	}

	// looks for the storage and find person
	// if method don't find the person, it throws an exception
	public static String[] findPerson(Object obj, String[][] storage) throws InvalidSearchException{
		String result[] = null;
		String willFound = "";
		int index = 0;
		
		// if parameter is an integer
		if(obj instanceof Integer) {
			willFound = (int)obj + "";
			index = 0;
		}
		
		// if parameter is a string
		if(obj instanceof String) {
			willFound = obj + "";
			index = 1;
		}
		
		for (int i = 0; i < storage.length; i++) {
			if(storage[i][index].equals(willFound)) {
				result = storage[i];
			}
		}
		
		// if there are no matching students, throws an InvalidSearchException
		if(result == null)
			throw new InvalidSearchException("There are no matching students for the query " + obj + ".");
		else	
			return result;
	}
}

