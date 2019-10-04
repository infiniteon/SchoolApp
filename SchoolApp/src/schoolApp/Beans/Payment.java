package schoolApp.Beans;

import java.io.Serializable;

public class Payment implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6891178666151618564L;
	private int id;
	private int amount;
	private String date;
	private int studentId;
	private int paidForMonth;

	public Payment() {
		setId(0);
		setAmount(0);
		setDate(null);
		setStudentId(0);
		setPaidForMonth(0);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public int getPaidForMonth() {
		return paidForMonth;
	}

	public void setPaidForMonth(int paidForMonth) {
		this.paidForMonth = paidForMonth;
	}

}
