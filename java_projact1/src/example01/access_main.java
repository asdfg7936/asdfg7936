package example01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class access_main {

	static Connection conn;
	public static void main(String[] args) {
		conn = null;
		try{
		   
		    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

		    //DESKTOP-SHVH3I4
		    String url = "jdbc:sqlserver://localhost:1433;database=project3;user=sa;password=asdfg01079367020;encrypt=true;trustServerCertificate=true";
		   
		    conn = DriverManager.getConnection(url);
		    System.out.println("연결 성공");
		    Login frame = new Login();
            frame.setVisible(true);


		}
		catch(ClassNotFoundException e){
		    System.out.println("드라이버 로딩 실패");
		}
		catch(SQLException e){
			
		    System.out.println("에러: " + e);
		}
	}

}
