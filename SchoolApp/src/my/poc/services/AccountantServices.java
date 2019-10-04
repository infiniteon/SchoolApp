package my.poc.services;

import java.sql.SQLException;
import java.util.List;
import schoolApp.Beans.*;
import schoolApp.Beans.Class;
import schoolApp.DAO.Accounts;

public class AccountantServices {
	private Accounts access;

	public AccountantServices() {
		access = new Accounts();
	}

	public List<Student> getStudentDetails() throws SQLException {
		return access.getStudentDetails();
	}

	public List<Payment> getFeeDetails() throws SQLException {
		return access.getFeeDetails();
	}

	public List<Academics> getAcademicDetails() throws SQLException {
		return access.getAcademicDetails();
	}

	public List<Class> getClassDetails() throws SQLException {
		return access.getClassDetails();
	}

	public Search findStudent(int id, String key) throws SQLException {
		return access.findStudent(id, key);
	}

}
