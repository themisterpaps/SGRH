package DAO;

import VO.ContractoVO;
import VO.DadosPessoaisVO;
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

public class ContractoDAO {
    private Connection conexao;
    
    public ContractoDAO(){
        try {
            this.conexao = BDconexao.getConnection();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(ContractoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void inserir(ContractoVO c) throws ParseException{
        try {
            String sql = "INSERT INTO contracto(idFuncionario,dataInicio, dataFim, tipo) VALUES(?,?,?,?)";
            PreparedStatement ps = conexao.prepareStatement(sql);
            DadosPessoaisDAO dao = new DadosPessoaisDAO();
            ps.setInt(1, dao.getId());
            String sDate1=c.getDataInicio();  
            Date date1=new SimpleDateFormat("dd/MM/yyyy").parse(sDate1);
            java.sql.Date sDate = new java.sql.Date(date1.getTime());
            ps.setDate(2, sDate);
            sDate1=c.getDataFim();  
            date1=new SimpleDateFormat("dd/MM/yyyy").parse(sDate1);
            sDate = new java.sql.Date(date1.getTime());
            ps.setDate(3, sDate);
            ps.setString(4, String.valueOf(c.getTipo()));
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(DadosPessoaisDAO.class.getName()).log(Level.SEVERE, null, ex);
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