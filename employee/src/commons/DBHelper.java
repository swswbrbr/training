package commons;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBHelper {
	private final String DRIVER = "com.mysql.jdbc.Driver";
	private final String URL = "jdbc:mysql://localhost:3306/jjdev?useUnicode=true&characterEncoding=utf8";
	private final String DB_USER = "root";
	private final String DB_PW = "java0000";
	
	public DBHelper(){
		
		try {
			Class.forName(this.DRIVER);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Connection getConnection() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(this.URL, this.DB_USER, this.DB_PW);
		} catch (SQLException e) {
			System.out.println("DB연결 실패!");
			e.printStackTrace();
		}
		return conn;
	}
			
	public void close(Connection conn, PreparedStatement pstmt, ResultSet rs) {
		if(rs != null) {
			try {rs.close();} catch (SQLException e) {e.printStackTrace();}
		}
		if(pstmt != null) {
			try {rs.close();} catch (SQLException e) {e.printStackTrace();}
		}
		if(conn != null) {
			try {rs.close();} catch (SQLException e) {e.printStackTrace();}
		}
	}
}
