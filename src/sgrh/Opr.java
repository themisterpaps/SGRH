package sgrh;

import java.io.*;
import java.util.*;
public class Opr {
   private Vector vs; Funcionario f,f1;
   private Tarefas tr=new Tarefas();
   private int op;
   private Validacoes vr;
   private Adpt_Ficheiro ficheiro;
   
   public Opr(){ vs= new Vector();vr=new Validacoes();ficheiro = new  Adpt_Ficheiro();}
   public void lerFich (String nomeFich){
        //Variaveis
            String nome, apelido, bi, genero, endereco, nacionalidade, estadoCivil, dataNasc,dataRegistro, areaForm, areaLeciona,instituicao,cargo;
            long telefone;
            int codFunc, nuit,nivelEscolar,anoDeFormacao;
            byte anosExperiencia;
            float salario=0;
            char criterio;
         
        StringTokenizer str;
        String linha = "";
        try{
            BufferedReader br = new BufferedReader (new FileReader(nomeFich));
            linha = br.readLine();
            while(linha != null){
                str= new StringTokenizer (linha, "/");
                codFunc=Integer.parseInt(str.nextToken());
                nome=str.nextToken();
                apelido=str.nextToken();
                bi=str.nextToken();
                genero=str.nextToken();
                endereco=str.nextToken();
                nacionalidade=str.nextToken();
                estadoCivil=str.nextToken();
                dataNasc=str.nextToken();
                telefone=Long.parseLong(str.nextToken());
                nuit=Integer.parseInt(str.nextToken());
                dataRegistro=str.nextToken();
                salario=Float.parseFloat(str.nextToken());
                criterio = str.nextToken().charAt(0);
                if (criterio=='A' || criterio== 'a'){
                    cargo =str.nextToken();
                    criaAdmin (nome, apelido, bi, codFunc, genero, endereco, nacionalidade, estadoCivil, dataNasc,telefone,  nuit,dataRegistro,salario, cargo);
                }
                else{
                    if(criterio == 'E' || criterio == 'e'){
                        areaForm = str.nextToken();
                        areaLeciona = str.nextToken();
                        criterio = str.nextToken().charAt(0);
                        if(criterio == 'L' || criterio == 'l'){
                            anosExperiencia = Byte.parseByte(str.nextToken());
                            anoDeFormacao = Integer.parseInt(str.nextToken());
                            criaLicenciado(nome, apelido, bi, codFunc, genero, endereco, nacionalidade, estadoCivil, dataNasc,telefone, nuit, dataRegistro, salario,areaForm, areaLeciona, anosExperiencia, anoDeFormacao);
                        }
                        else{
                            if(criterio == 'E' || criterio =='e'){
                                nivelEscolar = Integer.parseInt(str.nextToken());
                                instituicao = str.nextToken();
                                criaEstudante(nome, apelido,bi, codFunc, genero, endereco, nacionalidade, estadoCivil, dataNasc,telefone,nuit, dataRegistro, salario,areaForm, areaLeciona, nivelEscolar, instituicao);
                            }
                        }
                    }
                }
                linha = br.readLine();
            }
            br.close();
        }
        catch(FileNotFoundException fn){
            System.out.println("Ficheiro não econtrado");
        }
        catch(NumberFormatException nn){
            System.out.println(nn.getMessage());
        }
        catch(IOException io){
            System.out.println(io.getMessage());
        }
    }
   
   public void criaAdmin (String nome, String apelido, String bi,int codFunc, String genero, String endereco, String nacionalidade, String estadoCivil, String dataNasc,long telefone, int nuit,String dataRegistro, float salario,String cargo) {
        Admin a= new Admin ();
        a.setNome(nome);
        a.setApelido(apelido);
        a.setBi(bi);
        a.setCodFunc(codFunc);
        a.setGenero(genero);
        a.setEndereco(endereco);
        a.setNacionalidade(nacionalidade);
        a.setEstadoCivil(estadoCivil);
        a.setDataNasc(dataNasc);
        a.setTelefone(telefone);
        a.setNuit(nuit);
        a.setDataRegistro(dataRegistro);
        a.setSalario(salario);
        a.setCargo(cargo);
        vs.addElement(a);
    }
   public void criaLicenciado(String nome, String apelido, String bi,int codFunc, String genero, String endereco, String nacionalidade, String estadoCivil, String dataNasc,long telefone, int nuit,String dataRegistro,float salario,String areaForm,String areaLeciona,byte anosExperiencia, int anoDeFormacao) {
        Licenciado l = new Licenciado ();
        l.setNome(nome);
        l.setApelido(apelido);
        l.setBi(bi);
        l.setCodFunc(codFunc);
        l.setGenero(genero);
        l.setEndereco(endereco);
        l.setNacionalidade(nacionalidade);
        l.setEstadoCivil(estadoCivil);
        l.setDataNasc(dataNasc);
        l.setTelefone(telefone);
        l.setNuit(nuit);
        l.setDataRegistro(dataRegistro);
        l.setSalario(salario);
        l.SetAreaForm(areaForm);
        l.setAreaLeciona(areaLeciona);
        l.setAnosExperiencia(anosExperiencia);
        l.setAnoDeFormacao(anoDeFormacao);
        vs.addElement(l);
           }
   public void criaEstudante(String nome, String apelido, String bi,int codFunc, String genero, String endereco, String nacionalidade, String estadoCivil, String dataNasc,long telefone, int nuit,String dataRegistro,float salario,String areaForm,String areaLeciona,int nivelEscolar, String instituicao) {
        Estudante e = new Estudante();
        e.setNome(nome);
        e.setApelido(apelido);
        e.setBi(bi);
        e.setCodFunc(codFunc);
        e.setGenero(genero);
        e.setEndereco(endereco);
        e.setNacionalidade(nacionalidade);
        e.setEstadoCivil(estadoCivil);
        e.setDataNasc(dataNasc);
        e.setTelefone(telefone);
        e.setNuit(nuit);
        e.setDataRegistro(dataRegistro);
        e.setSalario(salario);
        e.SetAreaForm(areaForm);
        e.setAreaLeciona(areaLeciona);
        e.setNivel(nivelEscolar);
        e.setInstituicao(instituicao);
        vs.addElement(e);
        
    }
  
   //>>>>>>>>>>>>>>Actualizacao de Dados
      public void menuActualizacao() {
        byte op=0,posicao;
         System.out.println("====================== Lista de Todos Funcionarios ============================");
        System.out.println(toString());
        System.out.println("===============================================================================");
        posicao=encontrarIndice();
        f=(Funcionario)vs.elementAt(posicao);
        Explicador ex;
        Admin ad; 
        Estudante es;
        do{
            System.out.println("=================== Menu de Actualização de Dados  ===========================");
            System.out.println("==============================================================================");
            op=vr.validarByte("O que deseja actualizar: \n 1 - Estado Civil \n 2 - Endereço  \n 3 - Contacto \n 4 - Cargo (Somente para funcionarios do Corpo adminstrativo) \n 5 - Area Em Que Leciona (Somente para funcionarios que seijam Explicadores) \n 6 - Instituicão (Somente para funcionarios que seijam Explicadores e Estudantes)\n 0 - Voltar",0,6);
            switch(op){
                case 1:
                    f.setEstadoCivil(vr.validarEstCivil());
                    vs.remove(posicao);
                    vs.addElement(f);
                    break;
                case 2:
                    f.setEndereco(vr.NotValid("Introduz o seu actual endereço"));
                    vs.remove(posicao);
                    vs.add(posicao,f);
                    break;
                case 3:
                    f.setTelefone(vr.validarLong(" Número de telefone ", 820000000, 870000000));
                    vs.remove(posicao);
                    vs.add(posicao,f);
                    break;
                case 4:
                    if(f instanceof Admin ){
                        ad=(Admin)vs.elementAt(posicao);
                        ad.setCargo(vr.adaptarCargo());
                        vs.remove(posicao);
                        vs.add(posicao,ad);
                        ad=(Admin)vs.elementAt(posicao);
                        
                    }else{
                        System.out.println("Nao pode realizar essa Opeacao");
                    }
                    break;
                case 5:
                    if(f instanceof Explicador ){
                        ex=(Explicador)vs.elementAt(posicao);
                        ex.setAreaLeciona(vr.validarSemNr(" Area que Lecciona ",5, 15));
                        vs.remove(posicao);
                        vs.add(posicao,ex);
                    }else{
                        System.out.println("================================\n Nao pode realizar essa Opeacao \n =======================================");
                    }
                    break;
                case 6:
                    if(f instanceof Estudante ){
                        es=(Estudante)vs.elementAt(posicao);
                        es.setAreaLeciona(vr.validarSemNr(" Area que Lecciona ",5, 15));
                        vs.remove(posicao);
                        vs.add(posicao,es);
                    }else{
                        System.out.print("Nao pode realizar essa Opeacao");
                    }
                    break;
                default:
                    
                    break;}
            vs.trimToSize();
            System.out.println("====================== Actualização Efectuada ================================");
           }while(op!=0);
       ficheiro.esc_VectorEmTXT("funcionarios", vs,false);
    }
   //============== Vector ==============
   public void Remover(){
       int indice=0,cod;
       byte x=0;
       indice=encontrarIndice();
       if(indice!=-1){
           vs.remove(indice);
           vs.trimToSize();
           System.out.println("==========================================================");
           System.out.println("================== Removido Com Sucesso ==================");
           System.out.println("==========================================================");
       }
;
    }
   public byte encontrarIndice(){
    int cod;
    byte x=-1,y=0,c=-1;
    do{
        cod=vr.validarInt("Codigo(no formato xxxxx)", 11111, 99999);
        for(byte i=0; i<vs.size();i++){
            f=(Funcionario)vs.elementAt(i);
            if(f.getCodFunc()==cod){ x=i;y=0;c=0;}
        }
        if(c==-1){c=-1; System.err.println(">>>>>>>>>>>>>>Funcionario Nao Encontrado<<<<<<<<<<<<<<<<<<<!" );y=vr.validarByte("\n1 - Tentar Novamente \n0 - Cancelar", (byte)0, (byte)1);}
    }while(y==1);
    return x;
    }
   
   //============== Ficheiro txt=========
   public void escreverFicheiroTXT(String nomeFich){ficheiro.esc_VectorEmTXT(nomeFich, vs, false); };
   public void escreverFicheiroDAT(String nomeFich){
        ficheiro.esc_VectorEmDAT(nomeFich, vs);
    };
   public String toString(){
        String ver="";
        Funcionario f;
        for(int i = 0; i < vs.size(); i++){
            f = (Funcionario)vs.elementAt(i);
            ver+= (f.toString() + "\n ===============================================================================\n");
        }
        return ver;
    }
   

}
