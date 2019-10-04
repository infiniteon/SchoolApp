package schoolApp.Beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Search implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -264812147243105793L;

	private List<Student> SD;
	private List<Class> CD;
	private List<Academics> AD;
	private List<Payment> FD;

	public Search() {
		setSD(new ArrayList<>());
		setCD(new ArrayList<>());
		setFD(new ArrayList<>());
		setAD(new ArrayList<>());
	}

	public List<Student> getSD() {
		return SD;
	}

	public void setSD(List<Student> sD) {
		SD = sD;
	}

	public List<Class> getCD() {
		return CD;
	}

	public void setCD(List<Class> cD) {
		CD = cD;
	}

	public List<Academics> getAD() {
		return AD;
	}

	public void setAD(List<Academics> aD) {
		AD = aD;
	}

	public List<Payment> getFD() {
		return FD;
	}

	public void setFD(List<Payment> fD) {
		FD = fD;
	}
}
