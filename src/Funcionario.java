package sgrh;
import java.io.*;
public class Funcionario implements Serializable{
    protected String nome, apelido, bi, genero, endereco, nacionalidade, estadoCivil, dataNasc,dataRegistro;
    protected long telefone;
    protected int codFunc, nuit;
    protected float salario;
    public Funcionario(String nome, String apelido, String bi,int codFunc, String genero, String endereco, String nacionalidade, String estadoCivil, String dataNasc,long telefone, int nuit,String dataRegistro, float salario) {
        Validacoes v = new Validacoes();
        this.nome = nome;
        this.apelido = apelido;
        this.bi = bi;
        this.codFunc = codFunc;
        this.genero = genero;
        this.endereco = endereco;
        this.nacionalidade = nacionalidade;
        this.estadoCivil = estadoCivil;
        this.dataNasc = dataNasc;
        this.telefone = telefone;
        this.nuit = nuit;
        this.dataRegistro = dataRegistro;
        this.salario = salario;
    }    
    public Funcionario(){
       this(" ", " ", " ",0, " "," ", " ", " ", "",0, 0,"",0f);
    }
    //Getters
    public String getNome(){return nome;}
    public String getApelido(){return apelido; }
    public String getBi() {return bi;}
    public String getGenero(){return genero;}
    public String getEndereco(){return endereco;}
    public String getNacionalidade(){return nacionalidade;}
    public String getEstadoCivil() {return estadoCivil;}
    public String getDataNasc() {return dataNasc;}
    public String getDataRegistro(){return dataRegistro;}
    public long getTelefone() {return telefone;}
    public int getCodFunc() {return codFunc;}
    public int getNuit() {return nuit;}
    public float getSalario() {return salario;}    
    
//Setters
    public void setNome(String nome) {this.nome = nome;}
    public void setApelido(String apelido) {this.apelido = apelido;}
    public void setBi(String bi){this.bi = bi;}
    public void setGenero(String genero) {this.genero = genero;}
    public void setEndereco(String endereco) {this.endereco = endereco;}
    public void setNacionalidade(String nacionalidade) {this.nacionalidade = nacionalidade;}
    public void setEstadoCivil(String estadoCivil) {this.estadoCivil = estadoCivil;}
    public void setDataNasc(String dataNasc) {this.dataNasc = dataNasc;}
    public void setDataRegistro(String dataRegistro) {this.dataRegistro = dataRegistro;}
    public void setTelefone(long telefone) {this.telefone = telefone;}
    public void setCodFunc(int codFunc) {this.codFunc = codFunc;}
    public void setNuit(int nuit) {this.nuit = nuit;}  
    public void setSalario(float salario) {  this.salario = salario; }
    
    //ToString
    public String dadosFich(){return codFunc+"/"+nome+"/"+apelido+"/"+bi+"/"+genero+"/"+endereco+"/"+nacionalidade+"/"+estadoCivil+"/"+telefone+"/"+nuit+"/"+dataRegistro+"/"+salario;}
    public String toString(){return "Codigo do Funcionario: "+codFunc+"\tnome: "+nome+"\nApelido: "+apelido+"\tBI: "+bi+"\tGenero: "+genero+"\tEndereco: "+endereco+"\tNacionalidade: "+nacionalidade+"\tEstado Civil: "+estadoCivil+"\tTelefone: "+telefone+"\tData de Nascimento: "+dataNasc+"\tNuit: "+nuit+"\tData de Registro: "+dataRegistro + "\tSalário: "+ salario;}
}