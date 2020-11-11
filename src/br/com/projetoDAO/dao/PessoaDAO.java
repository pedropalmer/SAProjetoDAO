
package br.com.projetoDAO.dao;

import br.com.projetoDAO.conexao.Conexao;
import br.com.projetoDAO.model.Pessoa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class PessoaDAO {
    Connection conn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    
    public void getIdPessoa(Pessoa p){
        String sql = "SELECT MAX(id) as maxId FROM pessoa";
        
        conn = Conexao.conectar();
        
        try{
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            if(rs.next())
            {
                p.setId(rs.getInt(1));
            }
        }catch (Exception e){
            System.out.println("Não foi possível copiar o ID." +e);        
        }
    }
    
    public boolean consulta(){
        String sql = "SELECT * FROM pessoa";
        
        conn = Conexao.conectar();
        
        try {
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            System.out.printf("%-5s|%-50s|%-20s\n", "ID", "Nome", "Profissão");
            while (rs.next()){
                System.out.printf("%-5s|%-50s|%-20s\n",rs.getInt(1), rs.getString(2), rs.getString(3));
            }
            return true;
        }catch(Exception e){
            System.out.println("Não foi possível acessar os dados!"+e);
            return false;
        }finally{
            Conexao.desconectar(conn);
        }
    }
    
    public boolean cadastra(Pessoa p){
        String sql = "INSERT INTO pessoa (nome, profissao) VALUES (?, ?)";
        
        conn = Conexao.conectar();
                
        try{
            pst = conn.prepareStatement(sql);
            pst.setString(1, p.getNome());
            pst.setString(2, p.getProfissao());
            int r = pst.executeUpdate();
            if(r>0){
                System.out.println("Dados inseridos com sucesso!");
            }
            getIdPessoa(p);
            return true;
        } catch(Exception e){
            System.out.println("Não foi possível inserir!"+e);
            return false;
        }finally{
            Conexao.desconectar(conn);
        }       
    }
    
    public boolean altera(Pessoa p){
        String sql = "UPDATE pessoa SET nome = ?, profissao = ? WHERE (id = ?)";
        
        conn = Conexao.conectar();
        
        try{
            getIdPessoa(p);
            pst = conn.prepareStatement(sql);
            pst.setString(1, p.getNome());
            pst.setString(2, p.getProfissao());
            pst.setInt(3, p.getId());
            int r = pst.executeUpdate();
            if(r>0){
                System.out.println("Alterado com sucesso!");
            }
            return true;
        } catch (Exception e){
                System.out.println("Não foi possível alterar!"+e);
                return false;
            }finally{
            Conexao.desconectar(conn);
        }
    }
    
    public boolean deleta(Pessoa p){
        String sql = "DELETE from pessoa WHERE (id = ?)";
        
        conn = Conexao.conectar();
        
        try{
            getIdPessoa(p);
            pst = conn.prepareStatement(sql);
            pst.setInt(1, p.getId());
            int r = pst.executeUpdate();
            if(r>0){
                System.out.println("Deletado com sucesso!");
            }
            return true;        
        }catch (Exception e){
            System.out.println("Não foi possível deletar!"+e);
            return false;
        }finally{
            Conexao.desconectar(conn);
        }
    }
}
