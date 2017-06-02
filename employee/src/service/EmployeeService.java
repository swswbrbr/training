package service;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import commons.DBHelper;

public class EmployeeService {
	private DBHelper dbhelper;
	private EmployeeDao employeedao;
	private SkillDao skilldao;
	
	public EmployeeService(){
		dbhelper = new DBHelper();
	}
	Connection conn = null;
	
	public ArrayList<Employee> selectEmployee(String employeeName, String employeeGender, String[] skillName) throws SQLException{
		System.out.println("employeeService selectEmployee메서드 실행");
		conn = dbhelper.getConnection();
		conn.setAutoCommit(false);
		employeedao = new EmployeeDao();
		ArrayList<Employee> list = new ArrayList<Employee>();
		skilldao = new SkillDao();
		try{
			int einsertresult = employeedao.insertEmployee(conn, employeeName, employeeGender);
			System.out.println(einsertresult+" <-- einsertresult 리턴받음 EmployeeService");
			ArrayList<Skill> sinsertresult = skilldao.insertSkill(conn, employeeName, skillName);
			System.out.println(sinsertresult+" <-- sinsertresult 리턴받음 EmployeeService");
			list = skilldao.selectEmployeeAndSkill(conn, sinsertresult);
			conn.commit();
		} catch(SQLException e){
			// TODO Auto-generated catch block
			e.printStackTrace();
			conn.rollback();
		} finally {
			conn.close();
		}
		return list;
	}
}
