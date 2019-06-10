package sgrh;
public class Estudante extends Explicador {
    private int nivelEscolar;
    private String instituicao;

    public Estudante(String nome, String apelido, String bi,int codFunc, String genero, String endereco, String nacionalidade, String estadoCivil, String dataNasc,long telefone, int nuit,String dataRegistro,float salario, String areaForm,String areaLeciona,int nivelEscolar, String instituicao) {
        super(nome,apelido, bi, codFunc, genero, endereco ,nacionalidade,estadoCivil,dataNasc,telefone,nuit,dataRegistro,salario , areaForm, areaLeciona);
        this.nivelEscolar = nivelEscolar;
        this.instituicao = instituicao;
    }
    public Estudante(){
         this(" ", " ", " ",0, " "," ", " ", " ", "",0, 0,"",0f," "," ",0,"");
    }
    public int getNivel() {return nivelEscolar;}
    public String getInstituicao() {return instituicao;}
    public void setNivel(int nivelEscolar) {this.nivelEscolar = nivelEscolar; }
    public void setInstituicao(String instituicao) {this.instituicao = instituicao;}
    
    public String toString() {return super.toString()+"\n Nivel Escolar: "+nivelEscolar+ "\n Instituicao: " + instituicao ; }
    public String dadosFich(){return super.dadosFich()+"/E"+"/"+nivelEscolar+"/"+instituicao;}
}