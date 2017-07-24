package com.designerdofuturo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import com.designerdofuturo.bean.Cadastro;
import com.designerdofuturo.conexaoBanco.ConexaoMySQL;
import com.designerdofuturo.bean.*;

public class CadastroDAO {

	private Connection connection;

	public CadastroDAO() {
		this.connection = ConexaoMySQL.getConexaoMySQL();
	}

	public void adicionaCadastro(Cadastro cadastro) {

		String sql = "INSERT INTO lead(email, nome, ip, stack, data_hora) VALUES(?,?,?,?,(SELECT NOW()))";

		try {

			PreparedStatement stmt = connection.prepareStatement(sql);

			stmt.setString(1, cadastro.getEmail());
			stmt.setString(2, cadastro.getNomeCompleto());
			stmt.setString(3, cadastro.getIp());
			stmt.setString(4, cadastro.getStack());

			stmt.execute();
			stmt.close();

		} catch (SQLException u) {
			throw new RuntimeException(u);
		}
	}
	
	
    public Cadastro QueryEmail(String email){
	      
   	 try {
	    	    
            Statement stmt = connection.createStatement();
            java.sql.ResultSet result;
            
            
            result = stmt.executeQuery("SELECT * FROM lead WHERE email = '"+email+"'");
            while ( result.next() ) {
            	
	     		Cadastro cadastro = new Cadastro();		
	     		cadastro.setEmail(result.getString("email"));  
	     		return cadastro;	                	                 
            }
            connection.close();
        } catch (Exception e) {
       	 System.err.println("Got an exception! ");
       	 System.err.println(e.getMessage());
        }
		return null;
        
    }
   
}