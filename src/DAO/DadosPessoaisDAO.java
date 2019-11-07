package DAO;

import VO.DadosPessoaisVO;
import control.BDconexao;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import view.Admin;
import view.MenuPrincipal;

public class DadosPessoaisDAO {
    private Connection conexao;
    
    public DadosPessoaisDAO(){
        try {
            this.conexao = BDconexao.getConnection();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(DadosPessoaisDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void inserir(DadosPessoaisVO dp) throws ParseException{
        try {
            String sql = "INSERT INTO funcionario(nome,apelido,bi,sexo,dataNasc,NIB,nacionalidade,estadoCiv) VALUES(?,?,?,?,?,?,?,?)";
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setString(1, dp.getNome());
            ps.setString(2, dp.getApelido());
            ps.setString(3, dp.getBi());
            ps.setString(4, dp.getSexo());
            String sDate1=dp.getData();  
            Date date1=new SimpleDateFormat("dd/MM/yyyy").parse(sDate1);
            java.sql.Date sDate = new java.sql.Date(date1.getTime());
            ps.setDate(5, sDate);
            ps.setInt(6, dp.getNib());
            ps.setString(7, dp.getNacionalidade());
            ps.setString(8, dp.getEstCivil());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(DadosPessoaisDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public int getId() {
        String sql = "select idFuncionario from funcionario";
        int id=-1;
        try {
            conexao = control.BDconexao.getConnection();
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps = conexao.prepareStatement(sql);
            ResultSet rs = null;
            rs = ps.executeQuery();
            while(rs.next()){
                id = rs.getInt("idFuncionario");
            }
        } catch (HeadlessException | SQLException | ClassNotFoundException e) {
            System.out.println(e);
        }
        return id;
    }
    
    /*public void actualizar(DadosPessoaisVO dp) {
        try {
            String sql = "UPDATE estudante SET nome = ?, apelido = ? WHERE cartao = ?";
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setString(1, a.getNome());
            ps.setString(2, a.getApelido());
            ps.setInt(3, a.getCartao());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(EstudanteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }*/
    
    /*public void apagar (DadosPessoaisVO dp){
        String sql = "DELETE FROM estudante WHERE cartao = ?";
        try{ 
         PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1, dp.getCartao());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(DadosPessoaisDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }*/
    
    /*public List<DadosPessoaisVO> todos(){
        try {
            String sql = "SELECT * from funcionario";
            PreparedStatement ps = conexao.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            List<DadosPessoaisVO> lista = new ArrayList<>();
            while(rs.next()){
                DadosPessoaisVO dp = new DadosPessoaisVO();
                dp.setNome(rs.getString("nome"));
                dp.setApelido(rs.getString("apelido"));
                lista.add(dp);
            }
            return lista;
        } catch (SQLException ex) {
            Logger.getLogger(DadosPessoaisDAO.class.getName()).log(Level.SEVERE, null, ex);
            return new ArrayList<>();
        }
    }*/
}