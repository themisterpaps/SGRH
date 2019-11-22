package DAO;

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

public class PlanoDeSaudeDAO {
    private Connection conexao;
    
    public PlanoDeSaudeDAO(){
        try {
            this.conexao = BDconexao.getConnection();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(PlanoDeSaudeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void inserir(PlanoDeSaudeVO pds) throws ParseException{
        try {
            String sql = "INSERT INTO planosaude(idFuncionario,dataInicio, dataFim, nrAgre) VALUES(?,?,?,?)";
            PreparedStatement ps = conexao.prepareStatement(sql);
            DadosPessoaisDAO dao = new DadosPessoaisDAO();
            ps.setInt(1, dao.getId());
            String sDate1=pds.getDataInicio();  
            Date date1=new SimpleDateFormat("dd/MM/yyyy").parse(sDate1);
            java.sql.Date sDate = new java.sql.Date(date1.getTime());
            ps.setDate(2, sDate);
            sDate1=pds.getDataFim();  
            date1=new SimpleDateFormat("dd/MM/yyyy").parse(sDate1);
            sDate = new java.sql.Date(date1.getTime());
            ps.setDate(3, sDate);
            ps.setInt(4, pds.getNrAgre());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(DadosPessoaisDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void apagar (){
        String sql = "DELETE FROM planosaude WHERE idFuncionario = ?";
        try{ 
         PreparedStatement ps = conexao.prepareStatement(sql);
            DadosPessoaisDAO dao = new DadosPessoaisDAO();
            ps.setInt(1, dao.getId());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(PlanoDeSaudeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void actualizar(PlanoDeSaudeVO pds, String id) {
        try {
            String sql = "UPDATE planosaude SET dataInicio = ?, dataFim = ? ,nrAgre = ? WHERE idFuncionario = ?";
           PreparedStatement ps = conexao.prepareStatement(sql);
            DadosPessoaisDAO dao = new DadosPessoaisDAO();
            String sDate1=pds.getDataInicio();  
            Date date1=new SimpleDateFormat("dd/MM/yyyy").parse(sDate1);
            java.sql.Date sDate = new java.sql.Date(date1.getTime());
            ps.setDate(1, sDate);
            sDate1=pds.getDataFim();  
            date1=new SimpleDateFormat("dd/MM/yyyy").parse(sDate1);
            sDate = new java.sql.Date(date1.getTime());
            ps.setDate(2, sDate);
            ps.setInt(3, pds.getNrAgre());
            ps.setInt(4,Integer.parseInt(id) );
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(PlanoDeSaudeDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(PlanoDeSaudeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
  /*  
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