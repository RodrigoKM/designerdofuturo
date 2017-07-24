package com.designerdofuturo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import com.designerdofuturo.conexaoBanco.ConexaoMySQL;
import com.designerdofuturo.bean.Cadastro;

public class CadastroDAO {
	
    private Connection connection;    
    
    public CadastroDAO(){    
        this.connection = ConexaoMySQL.getConexaoMySQL();  
    }    
    
    public void adicionaCadastro(Cadastro cadastro){ 
    
       
        
      
    	
    	
    	String sql = "INSERT INTO lead(email, nome, ip, stack, data_hora) VALUES(?,?,?,?,(SELECT NOW()))";  
    	
        try {   

            PreparedStatement stmt = connection.prepareStatement(sql);    

            stmt.setString(1, cadastro.getEmail());    
            stmt.setString(2, cadastro.getNomeCompleto());    
            stmt.setString(3, cadastro.getIP());   
            stmt.setString(4, cadastro.getArea());    
              

            stmt.execute();    
            stmt.close();    

        } catch (SQLException u) {    
            throw new RuntimeException(u);    
        }    
        
        
    }

}
