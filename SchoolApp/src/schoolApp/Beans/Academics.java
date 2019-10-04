package schoolApp.Beans;

import java.io.Serializable;

public class Academics implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4961671679732148614L;

	private int id;
	private int classId;
	private int studentId;
	private int year;

	public Academics() {
		setId(0);
		setClassId(0);
		setStudentId(0);
		setYear(0);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getClassId() {
		return classId;
	}

	public void setClassId(int classId) {
		this.classId = classId;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}
}
