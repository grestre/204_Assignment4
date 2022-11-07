import java.io.IOException;
import java.util.*;

public class CourseDBStructure implements CourseDBStructureInterface{
	
	int size; 			
	String key; 
	String value; 
	LinkedList next; 
	LinkedList <CourseDBElement> hashTable[]; 
	
	//Constructor 1
	public CourseDBStructure(int size) {
		this.size = size; 
		hashTable = new LinkedList[size]; 
	}

	//Testing constructor with a key
	public CourseDBStructure(String key, int size) {
		this.size = size; 
		this.key = key; 
		hashTable = new LinkedList[size]; 
	}

	/**
	* Adds a CourseDBElement object to the CourseDBStructure 
	* using the hashcode of the CourseDatabaseElement object's crn value.
	* If the CourseDatabaseElement already exists, exit quietly
	* 
	* @param element the CourseDBElement to be added to CourseDBStructure
	 */
	@Override
	public void add(CourseDBElement element) {
		int hashIndex = element.hashCode() % size; 
		if(hashTable[hashIndex] == null) {
			hashTable[hashIndex] = new LinkedList<CourseDBElement>(); 
		}
		else {
			hashTable[hashIndex].add(element); 
		}
	}

	/**
	 * Finds a CourseDatabaseElement based on the key (crn) of the 
	 * courseDatabaseElement If the CourseDatabaseElement is found return it 
	 * If not, throw an IOException
	 * 
	 * @param crn (key) whose associated courseDatabaseElement is to be returned
	 * @return a CourseDBElement whose crn is mapped to the key
	 * @throws IOException if key is not found
	 */
	@Override
	public CourseDBElement get(int crn) throws IOException {
		boolean found = false; 
		CourseDBElement element = null;
		String strCRN = crn + ""; 							//CRN is the key, use the key associated with the string
		int hashIndex = strCRN.hashCode() % size; 			//The index using the hashCode (string converted to int) mod size		
		if(hashTable[hashIndex] == null) {
			throw new IOException();
		}
		else {
			for(int i = 0; i < size; i++) {
				CourseDBElement temp = hashTable[hashIndex].get(i);
				if(temp.getCRN() == crn) {
					return temp;
				}
			}
			return null;
		}
	}

	
	/**
	 * @return an array list of string representation of each course in
	 * the data structure separated by a new line. 
	 * Ex: 
	 * Course:CMSC500 CRN:39999 Credits:4 Instructor:Nobody InParticular Room:SC100
	 * Course:CMSC600 CRN:4000 Credits:4 Instructor:Somebody Room:SC200
	 */
	@Override
	public ArrayList<String> showAll() {
		ArrayList<String> list = new ArrayList<String>();
		
		//Table loop
		for (int table = 0; table < size; table++) { 
			LinkedList<CourseDBElement> tableList = hashTable[table];
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


	/**
	 * return the size of the table
	 */
	@Override
	public int getTableSize() {
		return size; 
	}
}