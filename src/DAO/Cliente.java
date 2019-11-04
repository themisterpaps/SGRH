package DAO;
public class Cliente {

    private int matricula, idade;
    private String nome;
    private char sexo;

    public Cliente() {
    }

    public Cliente(int matricula, String nome, int idade, char sexo) {
        this.matricula = matricula;
        this.nome = nome;
        this.idade = idade;
        this.sexo = sexo;
    }

    public int getMatricula(){
        return matricula;
    }

    public String getNome(){
        return nome;
    }
    
    public int getIdade(){
        return idade;
    }
    
    public char getSexo(){
        return sexo;
    }
    
    public void setMatricula(int matricula){
        this.matricula = matricula;
    }

    public void setNome(String nome){
        this.nome = nome;
    }
    
    public void setIdade(int idade){
        this.idade = idade;
    }
    
    public void setSexo(char sexo){
        this.sexo = sexo;
    }
}