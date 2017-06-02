package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeDao {
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	//01 insert
	public int insertEmployee(Connection conn, String employeeName, String employeeGender) throws SQLException {
		System.out.println("insertEmployee 메서드 실행 EmployeeDao.java");
		int insertresult = 0;
		String sql = "INSERT INTO employee (employee_no, employee_name, employee_gender) VALUES (NULL, ?, ?)";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, employeeName);
		pstmt.setString(2, employeeGender);
		insertresult = pstmt.executeUpdate();
		System.out.println(insertresult+" <-- insert query 실행결과 employeedao");
		return insertresult;
	}
	
	//02 select(필요없는듯)
	/*
	public ArrayList<Employee> EmployeeListAll(DBHelper dbhelper, Connection conn) throws SQLException{
		System.out.println("EmployeeListAll 메서드 실행 EmployeeDao.java");
		ArrayList<Employee> returnlist = new ArrayList<Employee>();
		conn = dbhelper.getConnection();
		conn.setAutoCommit(false);
		String sql = "select * from employee";
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();
		conn.commit();
		while(rs.next()){
			Employee employee = new Employee();
			employee.setEmployeeNo(rs.getInt("employeeNo"));
			employee.setEmployeeName(rs.getString("employeeName"));
			employee.setEmployeeGender(rs.getString("employeeGender"));
			returnlist.add(employee);
		}
		return returnlist;
	}
	*/
}
