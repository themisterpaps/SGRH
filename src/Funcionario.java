import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.*;
public class Funcionario implements Serializable{
    private String nome, apelido, bi, genero, endereco, nacionalidade, estadoCivil, categoria, areaForm, dataNasc,dataRegistro,tipoSal;
    private long telefone;
    private float salario=0;
    private int codFunc, nuit;
    private byte nivelForm;
    private BufferedReader br= new BufferedReader( new InputStreamReader(System.in));
    
    public Funcionario(){
 
        Validar v=new Validar();
        nome=v.validarNome("Nome(no minimo 3 letras e no maximo 20)",3,20);
        apelido=v.validarNome("Apelido (Deve conter no minimo 3 letras e no maximo 20 e sem espaco)",3,20);
        bi=v.validarBI("BI Deve conter 12 numeros e uma letra",(byte)13);
        genero=adapatarOpcoes("o seu genero \n1 - Masculino \n2 - Feminino \n3 - Prefiro nao dizer","Masculino" ,"Feminino", "Personalizado");
        endereco=v.NotValid("O seu Endereço");
        nacionalidade=v.validarSemNr("Nacionalidade", (byte) 5, (byte)20);
        estadoCivil=adapatarOpcoes("o seu estado civil:  \n1 - Casado(a) \n2 - Solteiro(a) \n3 - Viuvo(a)", "Casado(a)", "Solteiro(a) ", "Viuvo(a)");
        categoria=adaptarCategoria();
        areaForm=adaptarArea();
        telefone=v.validarLong("Telefone: ",820000000,879999999);
        codFunc=v.validarInt("Codigo do funcionario: (Com 5 digitos)", 11111, 99999);
        nuit=v.validarInt("NUIT:(Com exatamenten 9 digitos)",100000000,999999999);
        dataNasc=v.validarData("Nascimento",(int)1960,(int)2018);
        dataRegistro=dataActual();
        //Salario
        Salario sl= new Salario();
        sl.menuSal();
        salario=sl.getSalario();
        tipoSal=sl.getTipo();
    }
    
    //Adaptadores
    public String dataActual(){
    String datas="";
    Calendar cf = Calendar.getInstance();
    Date dt=cf.getTime();
    SimpleDateFormat sdf=new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
    datas=sdf.format(dt);
    return datas;
    }
    public String adapatarOpcoes(String msg, String op1, String op2,String op3) {
        int op=0;
        String s;
        try{
        System.out.println("Escolha"+ msg);
        op=Integer.parseInt(br.readLine());
        while(op<1 || op>3){
            System.out.println("Opcao invalida! Por favor, tente novamente");
            op=Integer.parseInt(br.readLine());
        }
        }catch(NumberFormatException nfe){nfe.getMessage();}
         catch(IOException iop){iop.getMessage();}
        if(op==1){s=op1;}
        else 
        if(op==2){s=op2;}
        else{s=op3;}
        return s;
        }
    public String adaptarCategoria(){
        String a="";
        int op;
        Validar vr;
        try{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Digite o seu cargo\n 1-Director\n 2-Gestor\n 3-Advogado\n 4-Chefe \n 5-Tecnico\n 6-Estagiario\n 7-Outro");
        op=Integer.parseInt(br.readLine());
        switch(op){
            case 1:
              a="Director(a)";
            break;
            case 2:
              a="Gestor(a)";
            break;
            case 3:
              a="Advogado(a)";
            break;
            case 4:
              a="Chefe";
            break;
            case 5:
              a="Tecnico(a)";
            break;
            case 6:
              a="Estagiario(a)";
            break;
            case 7:
                vr=new Validar();
                a=vr.validarSemNr("seu cargo", (byte)5, (byte)20);
            break;
            default:
              a="Funcionario";
            break;    } 
         }catch(NumberFormatException nfe){System.out.print(nfe.getMessage());}
         catch(IOException io){System.out.print(io.getMessage());}
        return a;    
    }
    public String adaptarArea(){
     String a="";
     int op;
     Validar vr;
      try{
     BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
     System.out.println("Digite a sua Area de Formacao\n 1-Administracao\n 2-Dierito\n 3-Economia\n 4-Educacao\n 5-Engenharia \n 6-Gestao\n 7-Psicologia\n 8-Publicidade\n 9-Saude\n 10-Sociologia\n 11-Transportes \n 12-Outros ");
     op=Integer.parseInt(br.readLine());
     switch(op){
         case 1:
             a="Administracao";
        break;
         case 2:
             a="Direito";
        break;
         case 3:
             a="Economia";
             
        break;
         case 4:
            a="Educacao";
        break;
         case 5:
            a="Engenharia";
        break;
         case 6:
            a="Gestao";
        break;
         case 7:
            a="Psicologia";
        break;
         case 8:
            a="Publicidade";
        break;
         case 9:
            a="Saude";
        break;
         case 10:
            a="Sociologia";
        break;
         case 11:
             a="Transportes";
         case 12:
                vr=new Validar();
                a=vr.validarSemNr("sua area de Formação", (byte)5, (byte)20);
            break;
         default :
             a="Nenhuma";}
                    
        }catch(NumberFormatException nfe){System.out.print(nfe.getMessage());}
         catch(IOException io){System.out.print(io.getMessage());}            
     return a; 
  
  }
    
    //Getters
    public String getNome(){return nome;}
    public String getBI(){return bi;}
    public String getGenero(){return genero;}
    public String getEndereco(){return endereco;}
    public long getLong(){return telefone;}
    public String dadosFich(){return codFunc+"/"+nome+"/"+apelido+"/"+bi+"/"+genero+"/"+endereco+"/"+nacionalidade+"/"+estadoCivil+"/"+categoria+"/"+areaForm+"/"+nivelForm+"/"+telefone+"/"+nuit+"/"+dataRegistro+"/"+salario+"/"+tipoSal;}
    public String toString(){return "Codigo do Funcionario: "+codFunc+"\tnome: "+nome+"\nApelido: "+apelido+"\nBI: "+bi+"\nGenero: "+genero+"\nEndereco: "+endereco+"\nNacionalidade: "+nacionalidade+"\nEstado Civil: "+estadoCivil+"\nCategoria: "+categoria+"\nArea de Formacao: "+areaForm+"\nNivel de Formacao: "+nivelForm+"Telefone: "+telefone+"\nData de Nascimento: "+dataNasc+"\tNuit: "+nuit+"\nSalario: "+salario+"\tTipo de Remuneracao: "+tipoSal+"\nData de Registro: "+dataRegistro;}
    
}
