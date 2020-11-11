
package br.com.projetoDAO.conexao;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {
    
    static final private String USER = "root";
    static final private String PASS = "1234";
    static final private String URL = "jdbc:mysql://localhost:3306/projetodao?useTimezone=true&serverTimezone=UTC";
    
    
    public static Connection conectar(){
        
        Connection conn = null;
        
        try{
            conn = DriverManager.getConnection(URL, USER, PASS);
            return conn;
        } catch(Exception e) {
            System.out.println("Não foi possível conectar!"+e);
            return null;
        }        
    }
    
    public static void desconectar(Connection conexao){
        try{
            conexao.close();            
        } catch(Exception e){
            System.out.println("Não foi possível desconectar!"+e);
        }
    }
    
}
