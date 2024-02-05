package example01;

import java.sql.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class DAO {
	private final static String url = "jdbc:sqlserver://localhost:1433;database=project3;user=sa;password=asdfg01079367020;encrypt=true;trustServerCertificate=true";
    private final static String username = "sa";
    private final static String password = "asdfg01079367020";
    static String name;
    static String pass_word;
	private static DAO _dao;

    static {
        _dao = new DAO();
    }

    public static DAO getDAO() {
        return _dao;
    }
    public boolean checkDuplicateID(String id) {//수정필요
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        boolean isDuplicate = false;
        try {
            con = DriverManager.getConnection(url, username, password);

            String sql = "SELECT ID FROM User_Info WHERE ID = ?";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, id);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                isDuplicate = true;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (rs != null)
                    rs.close();
                if (pstmt != null)
                    pstmt.close();
                if (con != null)
                    con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return isDuplicate;
    }
    public static boolean login(String user, String pass) {//수정필요
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        boolean isLoggedIn = false;
        try {
            con = DriverManager.getConnection(url, username, password);

            String sql = "select * from User_Info where ID = ? and Pass_Word = ?";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, user);
            pstmt.setString(2, pass);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                isLoggedIn = true;
                name = user;
                pass_word = pass;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (rs != null)
                    rs.close();
                if (pstmt != null)
                    pstmt.close();
                if (con != null)
                    con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return isLoggedIn;
    }
    public boolean register(String id, String pass, String kname, String gender) {//수정필요
        Connection conn = null;
        PreparedStatement pstmt = null;
        boolean isRegistered = false;
        try {
            conn = DriverManager.getConnection(url, username, password);
            String query = "INSERT INTO User_Info (Id, Pass_Word, Name, gender) VALUES (?, ?, ?, ?)";
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, id);
            pstmt.setString(2, pass);
            pstmt.setString(3, kname);
            pstmt.setString(4, gender);
            int result = pstmt.executeUpdate();
            if (result > 0) {
                isRegistered = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstmt != null)
                    pstmt.close();
                if (conn != null)
                    conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return isRegistered;
    }
   public List Insert_Goal() {
	   List<Goal_DTO> goals = new ArrayList<Goal_DTO>();
	   Connection conn = null;
       PreparedStatement pstmt = null; 
       try {
    	   conn = DriverManager.getConnection(url, username, password);
    	   String query = "SELECT Objective, Information, Low_val, High_val, Unit FROM Goal WHERE ID = ? ";
    	   pstmt = conn.prepareStatement(query);
    	   pstmt.setString(1, name);
    	   ResultSet result = pstmt.executeQuery();
    	   while(result.next()) {
    		   	Goal_DTO goal = new Goal_DTO();
    		    goal.setObjective(result.getString(1));
   				goal.setInformation(result.getString(2));
   				goal.setLow_val(result.getInt(3));
   				goal.setHigh_val((result.getInt(4)));
   				goal.setUnit(result.getString(5));
   				goals.add(goal);
    	   }
    	   
	} catch (Exception e) {
		e.printStackTrace();
	}finally {
 	   try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
    }
      return goals; 
   }
   
   public void Change_Goal(Goal_DTO goal, int Low, int High, String Unit, String Info) {
	   Connection conn = null;
       PreparedStatement pstmt = null; 
       try {
    	   conn = DriverManager.getConnection(url, username, password);
    	   String query = "UPDATE Goal set Low_val = ? , High_val = ?, Unit = ?, Information = ?  WHERE ID = ? AND Objective = ?";
    	   pstmt = conn.prepareStatement(query);
    	   pstmt.setInt(1, Low);
    	   pstmt.setInt(2, High);
    	   pstmt.setString(3, Unit);
    	   pstmt.setString(4, Info);
    	   pstmt.setString(5, name);
    	   pstmt.setString(6, goal.Objective);
    	   int res = pstmt.executeUpdate();
    	   if(res > 0) {
				System.out.println("입력 성공");
			}else {
				System.out.println("입력 실패");
			}
       	}catch (Exception e) {
    	   e.printStackTrace();
       }finally {
    	   try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
       }
       
   }
}
