package sgrh;
public class Licenciado extends Explicador {
private byte anosExperiencia;
    private int anoDeFormacao;

    public Licenciado(String nome, String apelido, String bi,int codFunc, String genero, String endereco, String nacionalidade, String estadoCivil, String dataNasc,long telefone, int nuit,String dataRegistro, float salario, String areaForm,String areaLeciona,byte anosExperiencia, int anoDeFormacao) {
        super(nome,apelido, bi, codFunc, genero, endereco ,nacionalidade,estadoCivil,dataNasc,telefone,nuit,dataRegistro,salario, areaForm, areaLeciona);
        this.anosExperiencia = anosExperiencia;
        this.anoDeFormacao = anoDeFormacao;
    }
    public Licenciado(){
        this(" ", " ", " ",0, " "," ", " ", " ", "",0, 0,"",0f, " "," ", (byte)0,0);
    }

    public byte getAnosExperiencia(){return anosExperiencia;}
    public int getAnoDeFormacao() {return anoDeFormacao;}
    public void setAnosExperiencia(byte anosExperiencia) {this.anosExperiencia = anosExperiencia;}
    public void setAnoDeFormacao(int anoDeFormacao) {this.anoDeFormacao = anoDeFormacao;} 
    public String toString() {return super.toString()+"\tAnos de Experiencia: "+anosExperiencia+"\tAnos de Formacao: "+anoDeFormacao; }
    public String dadosFich(){return super.dadosFich()+"/L/"+anosExperiencia+"/"+anoDeFormacao;}
}
