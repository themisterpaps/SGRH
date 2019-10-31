package DAO;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ModuloConexao {

    public static Connection conector() {
 
            java.sql.Connection conexao = null;
            String driver = "com.mysql.cj.jdbc.Driver";
            String url = "jdbc:mysql://localhost:3306/sgrh3?useTimezone=true&serverTimezone=UTC";
            String user = "root";
            String password = "";
            
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ModuloConexao.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            conexao = DriverManager.getConnection(url, user, password);
        } catch (SQLException ex) {
            Logger.getLogger(ModuloConexao.class.getName()).log(Level.SEVERE, null, ex);
        }
            return conexao; 
}}
