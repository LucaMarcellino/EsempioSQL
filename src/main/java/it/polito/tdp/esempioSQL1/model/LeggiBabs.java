package it.polito.tdp.esempioSQL1.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LeggiBabs {

	public void run(){
		String jdbcURL="jdbc:mysql://localhost/babs?user=root&password=Giovanni96";
		
		try {
			Connection conn = DriverManager.getConnection(jdbcURL);
			Statement st= conn.createStatement();
			String SQL="SELECT NAME FROM station";
			ResultSet res=st.executeQuery(SQL);
			
			while(res.next()) {
				String nomeStazione=res.getString("name");
				System.out.println(nomeStazione);
			}
			
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
	
	public static void main(String args[]) {
		LeggiBabs babs=new LeggiBabs();
		babs.run();
	}
	
}
