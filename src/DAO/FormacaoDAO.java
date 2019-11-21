package DAO;

import VO.DadosPessoaisVO;
import VO.FormacaoVO;
import VO.PlanoDeSaudeVO;
import control.BDconexao;
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
import view.Admin;

public class FormacaoDAO {
    private Connection conexao;
    
    public FormacaoDAO(){
        try {
            this.conexao = BDconexao.getConnection();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(FormacaoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void inserir(FormacaoVO f) throws ParseException{
        try {
            String sql = "INSERT INTO formacao(idFuncionario,nivel, dataInicio, dataFim, nomeFormacao) VALUES(?,?,?,?,?)";
            PreparedStatement ps = conexao.prepareStatement(sql);
            DadosPessoaisDAO dao = new DadosPessoaisDAO();
            ps.setInt(1, dao.getId());
            ps.setString(2, f.getNivel());
            String sDate1=f.getAnoI();
            Date date1=new SimpleDateFormat("dd/MM/yyyy").parse(sDate1);
            java.sql.Date sDate = new java.sql.Date(date1.getTime());
            ps.setDate(3, sDate);
            sDate1=f.getAnoF();  
            date1=new SimpleDateFormat("dd/MM/yyyy").parse(sDate1);
            sDate = new java.sql.Date(date1.getTime());
            ps.setDate(4, sDate);
            ps.setString(5, f.getNomeFormacao());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(DadosPessoaisDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void apagar (){
        String sql = "DELETE FROM formacao WHERE idFuncionario = ?";
        try{ 
         PreparedStatement ps = conexao.prepareStatement(sql);
            DadosPessoaisDAO dao = new DadosPessoaisDAO();
            ps.setInt(1, dao.getId());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(FormacaoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
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
    }
    
    public List<DadosPessoaisVO> todos(){
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