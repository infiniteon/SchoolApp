package schoolApp.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import my.poc.conn.SqlServerConn;
import schoolApp.Beans.*;
import schoolApp.Beans.Class;

public class Accounts {
//returns total students details
	public List<Student> getStudentDetails() throws SQLException {
		Connection conn = SqlServerConn.getConnection();
		String SQL = "SELECT * FROM StudentDetails";
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery(SQL);
		List<Student> list = new ArrayList<>();
		while (rs.next()) {
			Student s = new Student();
			s.setId(rs.getInt("id"));
			s.setAddress(rs.getString("address"));
			s.setDateOfJoining(rs.getString("yearOfJoining"));
			s.setDob(rs.getString("dob"));
			s.setName(rs.getString("name"));
			s.setOccupation(rs.getString("occupation"));
			s.setParentName(rs.getString("fatherName"));
			s.setPhone(rs.getString("phone"));
			list.add(s);
		}
		return list;
	}

	// returns total students details with matching id
	public List<Student> getStudentDetails(int id) throws SQLException {
		Connection conn = SqlServerConn.getConnection();
		String SQL = "SELECT * FROM StudentDetails where id = ?";
		PreparedStatement pst = conn.prepareStatement(SQL);
		pst.setInt(1, id);
		ResultSet rs = pst.executeQuery();
		List<Student> list = new ArrayList<>();
		while (rs.next()) {
			Student s = new Student();
			s.setId(rs.getInt("id"));
			s.setAddress(rs.getString("address"));
			s.setDateOfJoining(rs.getString("yearOfJoining"));
			s.setDob(rs.getString("dob"));
			s.setName(rs.getString("name"));
			s.setOccupation(rs.getString("occupation"));
			s.setParentName(rs.getString("fatherName"));
			s.setPhone(rs.getString("phone"));
			list.add(s);
		}
		return list;
	}

	// returns total students details with matching name
	public List<Student> getStudentDetails(String key) throws SQLException {
		Connection conn = SqlServerConn.getConnection();
		String SQL = "SELECT * FROM StudentDetails where name like '%" + key + "%'";
		PreparedStatement pst = conn.prepareStatement(SQL);
		ResultSet rs = pst.executeQuery();
		List<Student> list = new ArrayList<>();
		while (rs.next()) {
			Student s = new Student();
			s.setId(rs.getInt("id"));
			s.setAddress(rs.getString("address"));
			s.setDateOfJoining(rs.getString("yearOfJoining"));
			s.setDob(rs.getString("dob"));
			s.setName(rs.getString("name"));
			s.setOccupation(rs.getString("occupation"));
			s.setParentName(rs.getString("fatherName"));
			s.setPhone(rs.getString("phone"));
			list.add(s);
		}
		return list;
	}

	// returns total fees details
	public List<Payment> getFeeDetails() throws SQLException {
		Connection conn = SqlServerConn.getConnection();
		String SQL = "SELECT * FROM FeeDetails";
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery(SQL);
		List<Payment> list = new ArrayList<>();
		while (rs.next()) {
			Payment p = new Payment();
			p.setId(rs.getInt("id"));
			p.setAmount(rs.getInt("amountPaid"));
			p.setPaidForMonth(rs.getInt("PaidForMonth"));
			p.setStudentId(rs.getInt("studentId"));
			p.setDate(rs.getString("paymentDate"));
			list.add(p);
		}
		return list;
	}

	// returns total fees details for particular id
	public List<Payment> getFeeDetails(int id) throws SQLException {
		Connection conn = SqlServerConn.getConnection();
		String SQL = "SELECT * FROM FeeDetails where studentId = ?";
		PreparedStatement pst = conn.prepareStatement(SQL);
		pst.setInt(1, id);
		ResultSet rs = pst.executeQuery();
		List<Payment> list = new ArrayList<>();
		while (rs.next()) {
			Payment p = new Payment();
			p.setId(rs.getInt("id"));
			p.setAmount(rs.getInt("amountPaid"));
			p.setPaidForMonth(rs.getInt("PaidForMonth"));
			p.setStudentId(rs.getInt("studentId"));
			p.setDate(rs.getString("paymentDate"));
			list.add(p);
		}
		return list;
	}

	// returns total Academic details
	public List<Academics> getAcademicDetails() throws SQLException {
		Connection conn = SqlServerConn.getConnection();
		String SQL = "SELECT * FROM Academics";
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery(SQL);
		List<Academics> list = new ArrayList<>();
		while (rs.next()) {
			Academics a = new Academics();
			a.setId(rs.getInt("id"));
			a.setClassId(rs.getInt("classId"));
			a.setStudentId(rs.getInt("studentId"));
			a.setYear(rs.getInt("year"));
			list.add(a);
		}
		return list;
	}

	// returns total Academic details for particular id
	public List<Academics> getAcademicDetails(int id) throws SQLException {
		Connection conn = SqlServerConn.getConnection();
		String SQL = "SELECT * FROM Academics where studentId = ?";
		PreparedStatement pst = conn.prepareStatement(SQL);
		pst.setInt(1, id);
		ResultSet rs = pst.executeQuery();
		List<Academics> list = new ArrayList<>();
		while (rs.next()) {
			Academics a = new Academics();
			a.setId(rs.getInt("id"));
			a.setClassId(rs.getInt("classId"));
			a.setStudentId(rs.getInt("studentId"));
			a.setYear(rs.getInt("year"));
			list.add(a);
		}
		return list;
	}

	// returns total class details
	public List<Class> getClassDetails() throws SQLException {
		Connection conn = SqlServerConn.getConnection();
		String SQL = "SELECT * FROM ClassDetails";
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery(SQL);
		List<Class> list = new ArrayList<>();
		while (rs.next()) {
			Class c = new Class();
			c.setId(rs.getInt("id"));
			c.setName(rs.getString("name"));
			c.setFee(rs.getInt("fee"));
			list.add(c);
		}
		return list;
	}

	// returns total class details for particular id
	/*
	 * public List<Class> getClassDetails(int id) throws SQLException { Connection
	 * conn = SqlServerConn.getConnection(); String SQL =
	 * "SELECT * FROM ClassDetails where studentId = ?"; PreparedStatement pst =
	 * conn.prepareStatement(SQL); pst.setInt(1, id); ResultSet rs =
	 * pst.executeQuery(); List<Class> list = new ArrayList<>(); while (rs.next()) {
	 * Class c = new Class(); c.setId(rs.getInt("id"));
	 * c.setName(rs.getString("name")); c.setFee(rs.getInt("fee")); list.add(c); }
	 * return list; }
	 */

//return search results
	public Search findStudent(int id, String key) throws SQLException {
		Search search = new Search();
		if (id == 0) {
			search.setSD(getStudentDetails(key));
			return search;
		}
		search.setSD(getStudentDetails(id));
		search.setAD(getAcademicDetails(id));
		// search.setCD(getClassDetails(id));
		search.setFD(getFeeDetails(id));
		return search;
	}
}
