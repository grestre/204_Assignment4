import java.io.*;
import java.util.*;

public class CourseDBManager implements CourseDBManagerInterface{
	public CourseDBStructure CDS = new CourseDBStructure(20); 										//Database structure object with a size of 20
	/**
	 * Adds a course (CourseDBElement) with the given information
	 */
	@Override
	public void add(String id, int crn, int credits, String roomNum, String instructor) {
		CourseDBElement element = new CourseDBElement(id, crn, credits, roomNum, instructor);		//CourseDBElement object
		CDS.add(element); 																			//Add method from the CourseDBStructure class. Adds an element
	}

	/**
	 * finds  CourseDBElement based on the crn key
	 * @param crn course crn (key)
	 * @return a CourseDBElement object
	 */
	@Override
	public CourseDBElement get(int crn) {
		try {											//Try catch. Catch IOException
			return CDS.get(crn);						//Get method from the database structure class. Get the value from using the crn
		} catch (IOException e) {
			
		} 
		return null; 
	}

	/**
	 * Reads the information of courses from a test file and adds them 
	 * to the CourseDBStructure data structure
	 * @param input file
	 * @throws FileNotFoundException if the file does not exist
	 */
	@Override
	public void readFile(File input) throws FileNotFoundException {
		
			try {														//Try catch, catch FileNotFoundException if there is no file found
			Scanner file = new Scanner(input); 							//Scanner object
			String id = file.next(); 
			int crn = file.nextInt(); 
			int credits = file.nextInt(); 
			String roomNum = file.next(); 
			String instructor = file.next(); 
			add(id, crn, credits, roomNum, instructor); 				//Add method from the Manager class. Adds an element
			file.close(); 
		} catch(FileNotFoundException e) {
			
		}
	}

	/**
	 * @return an array list of string representation of each course in
	 * the data structure separated be a new line
	 * ex: 
	 * Course:CMSC500 CRN: 39999 Credits:4 Instructor:Nobody Room: SC100
	 */
	@Override
	public ArrayList<String> showAll() {
		ArrayList<String> list = new ArrayList<String>();
		
		//Table loop
		for (int table = 0; table < CDS.hashTable.length; table++) { 
			LinkedList<CourseDBElement> tableList = CDS.hashTable[table];
			if(tableList != null) {											//Checks if the table is not empty
				//Bucket loop
				for(int bucket = 0; bucket < tableList.size(); bucket++) {  
					CourseDBElement element = tableList.get(bucket);
					
					list.add(element.toString());							//Adds the element to the list
				}
			}
		}
		return list;														//Returns the list
	}
}
