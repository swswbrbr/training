package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import service.Employee;

public class SkillDao {
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	//insert Skill
	public ArrayList<Skill> insertSkill(Connection conn, String employeeName, String[] skillName) throws SQLException{
		System.out.println("insertSkill 메서드 실행 Skilldao.java");
		int insertresult = 0;
		int employeeNo = 0;
		
		
		String employeeNosql = "select employee_no from employee where employee_name=?";
		pstmt = conn.prepareStatement(employeeNosql);
		pstmt.setString(1, employeeName);
		rs = pstmt.executeQuery();
		while(rs.next()){
			employeeNo = rs.getInt("employee_no");
		}
		
		
		for(int i = 0; i<skillName.length; i++){
		String skill = skillName[i];
		String sql2 = "INSERT INTO skill (skill_no, employee_no, skill_name) VALUES (NULL, ?, ?)";
		pstmt = conn.prepareStatement(sql2);
		pstmt.setInt(1, employeeNo);
		pstmt.setString(2, skill);
		insertresult = pstmt.executeUpdate();
		System.out.println(insertresult+" <-- insert query 실행결과 skilldao");
		}
		
		
		String sql3 = "select skill_name from skill where employee_no=?";
		pstmt = conn.prepareStatement(sql3);
		pstmt.setInt(1, employeeNo);
		rs = pstmt.executeQuery();
		
		ArrayList<Skill> arrskill = new ArrayList<Skill>();
		for(int i = 0; i < rs.getRow(); i++){
			Skill skill = new Skill();
			arrskill.set(i, skill).setSkillName(rs.getString("skill_name"));
			arrskill.add(skill);
		}
		return arrskill;
	}
	
	//join employee and skill 메서드 선언
	public ArrayList<Employee> selectEmployeeAndSkill(Connection conn, ArrayList<Skill> sinsertresult) throws SQLException{
		System.out.println("selectEmployeeAndSkill 메서드 실행 Skilldao.java");
		ArrayList<Employee> returnlist = new ArrayList<Employee>();
		String sql = "select e.employee_no, e.employee_name, e.employee_gender from employee e left join skill s on e.employee_no = s.employee_no group by e.employee_no order by employee_no";
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();
		while(rs.next()){
			Employee e = new Employee();
			e.setEmployeeNo(rs.getInt("employee_no"));
			e.setEmployeeName(rs.getString("employee_name"));
			e.setEmployeeGender(rs.getString("employee_gender"));
			e.setSkill(e.getSkill());
			//s.setSkillName(rs.getString("skill_name"));
			returnlist.add(e);
		}
		return returnlist;
	}
}
