package com.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Select {
	public static void main(String[] args) {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try(Connection con = DriverManager.getConnection("jdbc:mysql://@localhost:3306/new_schema","root","Shrutika@123");
				Statement st = con.createStatement();)
		{
		String query = "SELECT EID,ENAME FROM EMP";
		ResultSet rs = st.executeQuery(query);
		
		while(rs.next()) {
			System.out.println(rs.getInt(1)+" "+rs.getString(2));
		}
			con.close();
		}catch (SQLException se) {
		System.out.println(se.getMessage());
		se.printStackTrace();
		}catch(Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
			
	}

}
