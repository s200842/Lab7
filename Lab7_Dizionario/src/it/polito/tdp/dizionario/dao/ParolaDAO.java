package it.polito.tdp.dizionario.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;
import it.polito.tdp.dizionario.model.Parola;

public class ParolaDAO {
	
	public List<Parola> findWordByLength(int l){
		
		List<Parola> listP = new ArrayList<Parola>(); 
		
		String sql = "SELECT nome FROM parola "
					+ "WHERE LENGTH(nome) = ?;";
		
		Connection c = DBConnect.getConnection();
		try{
			PreparedStatement st = c.prepareStatement(sql);
			st.setInt(1, l);
			ResultSet result = st.executeQuery();
			
			while(result.next()){
				listP.add(new Parola(result.getString("nome")));
			}
			result.close();
			c.close();
			return listP;
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return null;
	}

}
