package sgrh;
public class Admin extends Funcionario {
    protected String cargo;
    public Admin(String nome, String apelido, String bi,int codFunc, String genero, String endereco, String nacionalidade, String estadoCivil, String dataNasc,long telefone, int nuit,String dataRegistro, float salario, String cargo){
        super(nome,apelido, bi, codFunc, genero, endereco ,nacionalidade,estadoCivil,dataNasc,telefone,nuit,dataRegistro, salario);
        this.cargo=cargo;
    }
    public Admin(){    this(" ", " ", " ",0, " "," ", " ", " ", "",0, 0,"", 0f, "");
    }
    public String getCargo() {return cargo;}
    public void setCargo(String cargo) {this.cargo = cargo;}
    

    public String toString() {return super.toString()+"\n Cargo: "+cargo; }
    public String dadosFich(){return super.dadosFich()+"/A"+"/"+cargo;}
}
