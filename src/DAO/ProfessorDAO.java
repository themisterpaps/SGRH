package DAO;

import VO.AdminVO;
import VO.ProfessorVO;
import control.BDconexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProfessorDAO {
    private Connection conexao;
    
    public ProfessorDAO(){
        try {
            this.conexao = BDconexao.getConnection();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(ProfessorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void inserir(ProfessorVO p){
        String sql = "INSERT INTO professor(idFuncionario,disciplina, totalTurma) VALUES(?,?,?)";
        try {
            PreparedStatement ps = conexao.prepareStatement(sql);
            DadosPessoaisDAO dao = new DadosPessoaisDAO();
            ps.setInt(1, dao.getId());
            ps.setString(2, p.getDisciplina());
            ps.setInt(3, p.getNrTurmas());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(AdminDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void apagar (){
        String sql = "DELETE FROM professor WHERE idFuncionario = ?";
        try{ 
            PreparedStatement ps = conexao.prepareStatement(sql);
            DadosPessoaisDAO dao = new DadosPessoaisDAO();
            ps.setInt(1, dao.getId());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(ProfessorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /*public void actualizar(Admin a) {
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
    
    public List<Admin> todos(){
        try {
            String sql = "SELECT * from estudante";
            PreparedStatement ps = conexao.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            List<Estudante> lista = new ArrayList<>();
            while(rs.next()){
                Estudante e = new Estudante();
                e.setApelido(rs.getString("apelido"));
                e.setCartao(rs.getInt("cartao"));
                e.setNome(rs.getString("nome"));
                lista.add(e);
            }
            return lista;
        } catch (SQLException ex) {
            Logger.getLogger(EstudanteDAO.class.getName()).log(Level.SEVERE, null, ex);
            return new ArrayList<>();
        }
    }*/
    
}