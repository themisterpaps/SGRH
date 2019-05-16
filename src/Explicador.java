package sgrh;
public class Explicador extends Funcionario {
    protected String areaForm,areaLeciona;
    public Explicador(String nome, String apelido, String bi,int codFunc, String genero, String endereco, String nacionalidade, String estadoCivil, String dataNasc,long telefone, int nuit,String dataRegistro, float salario,String areaForm,String areaLeciona){
      super(nome,apelido, bi, codFunc, genero, endereco ,nacionalidade,estadoCivil,dataNasc,telefone,nuit,dataRegistro, salario); 
      this.areaForm=areaForm;
      this.areaLeciona=areaLeciona;
    }
    public Explicador(){
        this("", "", "",0,"","", "","", "",0, 0,"",0f,"","");
    }    
    public void SetAreaForm(String areaForm){this.areaForm=areaForm;}
    public void setAreaLeciona(String areaLeciona) {  this.areaLeciona = areaLeciona;}
    public String getAreaDeForm() { return areaForm;   }
    public String getAreaLeciona() {return areaLeciona;}
    public String toString() {return super.toString()+"\tArea de Formacão: "+areaForm + "\tArea que Leciona: " + areaLeciona ; }
    public String dadosFich(){return super.dadosFich()+"/E"+"/"+areaForm+"/"+areaLeciona;}
}
    