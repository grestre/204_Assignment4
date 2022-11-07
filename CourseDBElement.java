import java.util.*; 


public class CourseDBElement implements Comparable{
	String id = ""; 
	int crn = 0; 
	int credits = 0; 
	String roomNum = ""; 
	String instructor = "";
	
	
	public CourseDBElement(String id, int crn, int credits, String roomNum, String instructor) {
		this.id = ""; 
		this.crn = 0; 
		this.credits = 0; 
		this.roomNum = ""; 
		this.instructor = ""; 
	}
	public CourseDBElement() {
		id = "";
		crn = 0; 
		credits = 0; 
		roomNum = ""; 
		instructor = ""; 
	}
	/**
	 * 
	 */
	@Override
	public int compareTo(Object o) {
		return crn - ((CourseDBElement) o).getCRN(); 
	}
	public String getID() {
		return id; 
	}
	public int getCRN() {
		return crn; 
	}
	public int getCredits() {
		return credits; 
	}
	public String getRoomNum() {
		return roomNum; 
	}
	public String getInstructor() {
		return instructor; 
	}
	public void setID(String id) {
		this.id = id; 
	}
	public void setCRN(int crn) {
		this.crn = crn; 
	} 
	public void setCredits(int credits) {
		this.credits = credits; 
	}
	public void setRoomNum(String roomNum) {
		this.roomNum = roomNum; 
	}
	public void setInstructor(String instructor) {
		this.instructor = instructor; 
	}
}
