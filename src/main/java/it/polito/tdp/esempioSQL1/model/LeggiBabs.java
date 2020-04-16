package it.polito.tdp.esempioSQL1.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LeggiBabs {

	public void run(){
		String jdbcURL="jdbc:mysql://localhost/babs?user=root&password=Giovanni96";
		
		try {
			Connection conn = DriverManager.getConnection(jdbcURL);
			String SQL="SELECT NAME FROM station WHERE landmark= ? ";
			
			PreparedStatement st= conn.prepareStatement(SQL);
			st.setString(1, "Palo Alto");
			ResultSet res=st.executeQuery();
			
			while(res.next()) {
				String nomeStazione=res.getString("name");
				System.out.println(nomeStazione);
			}
			st.close();// chiudo la prima Statement -- se ce ne solo uno la chiusaura della connessione già lo chiude
			
			Statement st2=conn.createStatement();//Posso aprirne una seconda
			
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
