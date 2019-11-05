/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package temp;
import control.BDconexao;
import VO.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Chigumane
 */
public class ClienteDAO {
    private Connection conexao;
    
    public ClienteDAO() throws SQLException, ClassNotFoundException{
        this.conexao=BDconexao.getConnection();
    }
     public void inserir(Cliente c){
        String sql = "INSERT INTO Cliente(matricula,nome,idade,sexo) VALUES(?,?,?,?)";
        try {
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1, c.getMatricula());
            ps.setString(2, c.getNome());
            ps.setInt(3, c.getIdade());
            ps.setString(4, c.getSexo());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     
        public void apagar (int c){
        String sql = "DELETE FROM Cliente WHERE matticula = ?";
        try{ 
         PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1,c);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
         public List<Cliente> todos(){
        try {
            String sql = "SELECT * FROM `cliente` ORDER BY `cliente`.`nome` ASC";
            PreparedStatement ps = conexao.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            List<Cliente> lista = new ArrayList<>();
            while(rs.next()){
                Cliente ct=new Cliente();
                ct.setMatricula(rs.getInt("matricula"));
                ct.setNome(rs.getString("nome"));
                ct.setIdade(rs.getInt("idade"));
                ct.setSexo(rs.getString("sexo"));
                lista.add(ct);
            }
            return lista;
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            return new ArrayList<>();
        }
    }
           public void actualizar(Cliente c) {
        try {
            String sql = "UPDATE Cliente SET idade = ?, sexo = ?,nome = ? WHERE matricula = ?";
            try (PreparedStatement ps = conexao.prepareStatement(sql)) {
                ps.setInt(1, c.getIdade());
                ps.setString(2, c.getSexo());
                ps.setString(3, c.getNome());
                ps.setInt(4, c.getMatricula());
                ps.executeUpdate();
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
