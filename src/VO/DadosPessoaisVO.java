package VO;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import view.MenuPrincipal;

public class DadosPessoaisVO {
    private String nome, apelido,nacionalidade, bi, estCivil, data, sexo;
    private int nib, nuit;

    public DadosPessoaisVO(String nome, String apelido, String nacionalidade, String bi, String estCivil, String data, String sexo, int nib, int nuit) {
        this.nome = nome;
        this.apelido = apelido;
        this.nacionalidade = nacionalidade;
        this.bi = bi;
        this.estCivil = estCivil;
        this.data = data;
        this.sexo = sexo;
        this.nib = nib;
        this.nuit = nuit;
    }
    
    public DadosPessoaisVO() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public String getBi() {
        return bi;
    }

    public void setBi(String bi) {
        this.bi = bi;
    }

    public String getEstCivil() {
        return estCivil;
    }

    public void setEstCivil(String estCivil) {
        this.estCivil = estCivil;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public int getNib() {
        return nib;
    }

    public void setNib(int nib) {
        this.nib = nib;
    }

    public int getNuit() {
        return nuit;
    }

    public void setNuit(int nuit) {
        this.nuit = nuit;
    }
}
