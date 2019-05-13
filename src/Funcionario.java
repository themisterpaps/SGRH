import java.io.*;
public class Funcionario {
    private String nome, apelido, bi, genero, endereco, nacionalidade, estadoCivil, categoria, areaForm, data;
    private long telefone;
    private double salario;
    private int codFunc, nuit;
    private byte nivelForm;
    private BufferedReader br= new BufferedReader( new InputStreamReader(System.in));
    
    public Funcionario() throws IOException{
        Validar v=new Validar();
        nome=v.validarNome("Nome",3,20);
        apelido=v.validarNome("Apelido",3,20);
        bi=v.validarBI("BI",13,13);
        genero=v.validarGenero();
        System.out.println("Introduza o seu endereco: ");
        endereco=br.readLine();
        System.out.println("Introduza o seu nacionalidade: ");
        nacionalidade=br.readLine();
        estadoCivil=v.validarEstado();
        categoria=v.validarNome("Categoria",5,20);
        areaForm=v.validarNome("Area de formacao",5,20);
        nivelForm=v.validarByte("Nivel de formacao",1,7);
        telefone=v.validarLong("Telefone",820000000,879999999);
        codFunc=v.validarInt("Codigo do funcionario", 11111, 99999);
        nuit=v.validarInt("NUIT",100000000,999999999);
        System.out.println("Introduza a data: ");
        data=br.readLine();
        Calcular c=new Calcular();
        salario=c.getSalario();
    }
    
    public String getNome(){return nome;}
    public String getBI(){return bi;}
    public String getGenero(){return genero;}
    public String getEndereco(){return endereco;}
    public long getLong(){return telefone;}
    public String toString(){return "nome: "+nome+"\tApelido: "+apelido+"\tBI: "+bi+"\tGenero: "+genero+"\tEndereco: "+endereco+"\tNacionalidade: "+nacionalidade+"\tEstado Civil: "+estadoCivil+"\tCategoria: "+categoria+"\tArea de Formacao: "+areaForm+"\tNivel de Formacao: "+nivelForm+"\tData: "+data+"\tSalario: "+salario;}
}
