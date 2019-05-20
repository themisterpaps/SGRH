package sgrh;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;
public class Validacoes {
    static BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
    public String dataActual(){
    String datas="";
    Calendar cf = Calendar.getInstance();
    Date dt=cf.getTime();
    SimpleDateFormat sdf=new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
    datas=sdf.format(dt);
    return datas; }
    
    public String adapatarOpcoes(String msg, String op1, String op2) {
        int op=0;
        String s = "";
        try{
        System.out.println("Escolha"+ msg);
        op=Integer.parseInt(br.readLine());
        while(op<1 || op>2){
            System.err.println("Opcao invalida! Por favor, tente novamente");
            op=Integer.parseInt(br.readLine());
        }
        }catch(NumberFormatException nfe){nfe.getMessage();}
         catch(IOException iop){iop.getMessage();}
        if(op==1){s=op1;}
        else 
        if(op==2){s=op2;}
        return s;
    }
    public String adaptarArea(){
     String a="";
     int op;
      try{
     BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
     op=validarInt("Digite a sua Area de Formacao\n 1-Administracao\n 2-Dierito\n 3-Economia\n 4-Educacao\n 5-Engenharia \n 6-Gestao\n 7-Psicologia\n 8-Publicidade\n 9-Saude\n 10-Sociologia\n 11-Transportes \n 12-Outros",1,12);
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
            a="Física";
        break;
         case 9:
            a="Saude";
        break;
         case 10:
            a="Matematica";
        break;
         case 11:
             a="Estatística";
         case 12:
                //v=new Validacoes();
                a=validarSemNr("sua area de Formação", (byte)5, (byte)20);
            break;
         default :
             a="Nenhuma";}
                    
        }catch(NumberFormatException nfe){System.err.print(nfe.getMessage());}            
     return a; 
  
  }
    public String adaptarCargo(){
        String a="";
        int op;
        try{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        op=validarInt("Digite o seu cargo\n 1-Director\n 2-Gestor\n 3-Advogado\n 4-Chefe \n 5-Tecnico\n 6-Estagiario\n 7-Outro",1,7);
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
              a="Gerente(a)";
            break;
            case 6:
              a="Supervisor";
            break;
            case 7:
               a=validarSemNr("seu cargo", (byte)5, (byte)20);
            break;
            default:
              a="Funcionario";
            break;    } 
         }catch(NumberFormatException nfe){System.err.print(nfe.getMessage());}
        return a;    
    }
    
    public String validarNome(String f,int y, int z)  {
        char c;
        short b;
        
        String txt="";
        int l=0;
           try{
        System.out.println(" Introduza o "+f+":");
        txt=br.readLine(); 
       do{
           b=(short)txt.length();
           l=0;
           for(int i=0; i<txt.length(); i++){
                c=txt.charAt(i);
                if(Character.isLetter(c)){
                    l++;}
           }
           if((l!=txt.length()) || (b<y || b>z)){ 
                System.out.print("Tente Novamente: ");
                txt=br.readLine();}
         }while((l!=txt.length()) || (b<y || b>z));
        }catch(IndexOutOfBoundsException ie){System.err.print(ie.getMessage());}
        catch(IOException io){System.err.print(io.getMessage());}
       return txt;
  }
    public String validarBI(String f, byte z){
        char c;
        byte b;
        String txt="";
        int nrS=0,nr=0;
        try{
        System.out.println(" Introduza o "+f+":");
        txt=br.readLine();
       do{
           b=(byte)txt.length();
           nrS=0;nr=0;
           for(int i=0; i<b-2; i++){
                c=txt.charAt(i);
                if(Character.isDigit(c)){
                    nrS++;}
           }
           if(Character.isLetter(txt.charAt(b-1))){nr++;}
           if((nrS!=b-2) ||(b!=z)||(nr!=1)){ 
                System.err.println("Tente Novamente: ");
                txt=br.readLine();}
         }while((nrS!=txt.length()-2) || (b!=z)||(nr!=1));
       }catch(IndexOutOfBoundsException ie){System.err.print(ie.getMessage());}
        catch(IOException io){System.err.print(io.getMessage());}
       return txt;
    }
    public int validarInt(String k, int x, int y) {
       int c=0;
       try{
       System.out.println(" Introduza o "+k+":");
        c=Integer.parseInt(br.readLine()); 
       do{
           if(c<x || c>y)
{             System.err.print("Tente Novamente: ");
             c=Integer.parseInt(br.readLine());
           }
           }while(c<x || c>y);  
       }catch(NumberFormatException nfe){System.err.print(nfe.getMessage());}
        catch(IOException io){System.err.print(io.getMessage());}
       return c;
   }
    public String validarSemNr(String f,int y, int z) {
        char c;
        short b;
        String txt="";
        int l=0;
        try{
        System.out.println(" Introduza o "+f+":");
        txt=br.readLine(); 
       do{
           b=(short)txt.length();
           l=0;
           for(int i=0; i<txt.length(); i++){
                c=txt.charAt(i);
                if((Character.isLetter(c))||(Character.isSpaceChar(c))){
                    l++;}
           }
           if((l!=txt.length()) || (b<y || b>z)){ 
                System.err.print("Tente Novamente: ");
                txt=br.readLine();}
         }while((l!=txt.length()) || (b<y || b>z));
        }catch(IndexOutOfBoundsException ie){System.err.print(ie.getMessage());}
        catch(IOException io){System.err.print(io.getMessage());}
       return txt;
    }
    public String validarEstCivil() {
        int op=0;
        String s;
        try{
        System.out.println("Estado Civil: \n 1 - Soleteiro(a) \n 2 - Casado(a) \n 3 - Viuvo(a)");
        op=Integer.parseInt(br.readLine());
        while(op<1 || op>3){
            System.err.println("Opcao invalida! Por favor, tente novamente");
            op=Integer.parseInt(br.readLine());
        }
        }catch(NumberFormatException nfe){nfe.getMessage();}
         catch(IOException iop){iop.getMessage();}
        if(op==1){s = "Solteiro";}
        else 
        if(op==2){s = "Casado";}
        else{s= "Viuvo";}
        return s;
    }
    public String validarData(String txt, int anoMin,int anoMax){
    StringTokenizer str;
    String data="";
    byte dd = 0,mm =0;
    int yyyy =0;
    do{
        try{
            System.out.println(" Introduza data de "+txt+"(no Formato dd-mm-yyyy): ");
            data=br.readLine(); 
           do{
            str= new StringTokenizer(data,"-");
            dd=Byte.parseByte(str.nextToken());
            mm=Byte.parseByte(str.nextToken());
            yyyy=Integer.parseInt(str.nextToken());
           if((dd<1 || dd>31) || (mm<1 || mm>12)|| (yyyy<anoMin || yyyy>anoMax)){
             System.err.print("Tente Novamente: ");
             data=br.readLine();
           }
           }while((dd<1 || dd>31) || (mm<1 || mm>12)|| (yyyy<anoMin || yyyy>anoMax));  
        }catch(NumberFormatException | IOException | NoSuchElementException nfe){System.err.print(" Formato Invalido!");}
    }
    while((dd<1 || dd>31) || (mm<1 || mm>12)|| (yyyy<anoMin || yyyy>anoMax));
    return data;
    }
    public byte validarByte(String k, int x, int y) {
       byte c=0;
        try{
       System.out.println(" Introduza o "+k+":");
        c=Byte.parseByte(br.readLine()); 
       do{
           if(c<x || c>y){
             System.err.print("Tente Novamente: ");
             c=Byte.parseByte(br.readLine());
           }
           }while(c<x || c>y);
       }catch(NumberFormatException nfe){System.err.print(nfe.getMessage());}
        catch(IOException io){System.err.print(io.getMessage());}
       return c;
   }
    public Long validarLong(String f, long g, long h) {
        long c=0;
         try{
        System.out.println(" Introduza o "+f+":");
        c=Long.parseLong(br.readLine()); 
       do{
           if(c<g || c>h){
             System.err.print("Tente Novamente: ");
             c=Long.parseLong(br.readLine());
           }
           }while(c<g || c>h);  
       }catch(NumberFormatException nfe){System.err.print(nfe.getMessage());}
        catch(IOException io){System.err.print(io.getMessage());}
       return c;
   }
    public String NotValid(String k) {
    String x="";
       try{
     System.out.println("Introduza "+k);
     x=br.readLine();
      }catch(IOException io){System.err.print(io.getMessage());}
     return x;
     
    }
}
