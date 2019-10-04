package schoolApp.Beans;

import java.io.Serializable;

public class Class implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2614424045525171349L;
	private String name;
	private int fee;
	private int id;

	public Class() {
		setFee(0);
		setId(0);
		setName("");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getFee() {
		return fee;
	}

	public void setFee(int fee) {
		this.fee = fee;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
