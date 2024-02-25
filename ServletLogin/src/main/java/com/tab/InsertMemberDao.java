package com.tab;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class InsertMemberDao {

	private String url="jdbc:mysql://localhost:3306/tree";
	private String username="root";
	private String password="Ganesh@2024";
	private String dbdriver="com.mysql.cj.Driver";
	
	public void loadDriver(String dbDriver)
	{
		try {
			Class.forName(dbDriver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Connection getConnection() {
		Connection con = null;
		try {
			con = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
	
	public String insert(InsertMember member) {
		loadDriver(dbdriver);
		Connection con = getConnection();
		String sql = "insert into employeedetail(id,name,email,dpt,salary) values(?,?,?,?,?)";
		String result="Data Entered Successfully";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, member.getId());
			ps.setString(2, member.getName());
			ps.setString(3, member.getEmail());
			ps.setString(4,member.getDepartment());
			ps.setInt(5, member.getSalary());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			result="Data Not Entered Successfully";
			e.printStackTrace();
		}
		return result;
	}
	
	/*public String verify(InsertMember member) {
		
		loadDriver(dbdriver);
		Connection con = getConnection();
		String sql = "select * from employeedetail where name=? and email=?";
		String result="Login Successfully";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setString(1, member.getName());
			ps.setString(2, member.getEmail());
			
			ResultSet res= ps.executeQuery();
			if(res.next()) {
				result="Login Successfully";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			result=" Not Login Successfully";
			e.printStackTrace();
		}
		return result;
		
	}*/
}
