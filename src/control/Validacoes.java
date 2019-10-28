package control;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.swing.JOptionPane;
public class Validacoes {
    public String dataActual(){
        String datas="";
        Calendar cf = Calendar.getInstance();
        Date dt=cf.getTime();
        SimpleDateFormat sdf=new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
        datas=sdf.format(dt);
        return datas;
    }
    public Boolean validarNome(String f, int x, int y, String word)  {
        char c;
        short b;
        int l=0;
        try{
            b=(short)f.length();
            l=0;
            for(int i=0; i<f.length(); i++){
                c=f.charAt(i);
                if(Character.isLetter(c)){
                    l++;
                }
            }
            if((l!=f.length())){
                JOptionPane.showMessageDialog(null, "O seu "+word+" deve conter apenas letras!", "Erro!", JOptionPane.ERROR_MESSAGE);
                return false;
            }
            if(b<x || b>y){
                JOptionPane.showMessageDialog(null, "O seu "+word+" deve ter um comprimento maior que "+x+" e menor que "+y, "Erro!", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }catch(IndexOutOfBoundsException ie){System.err.print(ie.getMessage());}
        return true;
    }
    public Boolean validarString(String f, int x, int y, String word)  {
        short b;
        try{
            b=(short)f.length();
            if(b<x || b>y){
                JOptionPane.showMessageDialog(null, "O seu "+word+" deve ter um comprimento maior que "+x+" e menor que "+y, "Erro!", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }catch(IndexOutOfBoundsException ie){System.err.print(ie.getMessage());}
        return true;
    }
    public Boolean validarBI(String txt){
        char c;
        byte b;
        int nrS=0,nr=0;
        try{
            b=(byte)txt.length();
            nrS=0;nr=0;
            for(int i=0; i<b-2; i++){
                c=txt.charAt(i);
                if(Character.isDigit(c)){
                    nrS++;
                }
            }
            if(Character.isLetter(txt.charAt(b-1))){nr++;}
            if((nrS!=b-2) ||(b!=13)||(nr!=1)){ 
                JOptionPane.showMessageDialog(null, "O seu BI contem caracteres a mais! \nDeve conter exatamente 12 numeros e 1 letra", "Erro!", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }catch(IndexOutOfBoundsException ie){System.err.print(ie.getMessage());}
        return true;
    }
    public Boolean validarInt(int c, int x, int y, String s){
        try{
            if(c<x || c>y){
                JOptionPane.showMessageDialog(null, "O valor de "+s+" deve ser maior que "+x+" e menor que "+y, "Erro!", JOptionPane.ERROR_MESSAGE);
                return false;
            } 
        }catch(NumberFormatException nfe){System.err.print(nfe.getMessage());}
        return true;
    }
    public Boolean validarSemNr(String txt, int x, int y, String word){
        char c;
        short b;
        int l=0;
        try{
            b=(short)txt.length();
            l=0;
            for(int i=0; i<txt.length(); i++){
                c=txt.charAt(i);
                if((Character.isLetter(c))||(Character.isSpaceChar(c))){
                    l++;
                }
            }
            if((l!=txt.length()) || (b<x || b>y)){
                JOptionPane.showMessageDialog(null, "O seu "+word+" Deve ter um comprimento maior que "+x+" e menor que "+y, "Erro!", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }catch(IndexOutOfBoundsException ie){System.err.print(ie.getMessage());}
        return true;
    }
    public Boolean validarData(String txt, int anoMin,int anoMax, String word){
        StringTokenizer str;
        byte dd=0, mm=0;
        int yyyy = 0;
        str= new StringTokenizer(txt,"/");
        dd=Byte.parseByte(str.nextToken());
        mm=Byte.parseByte(str.nextToken());
        yyyy=Integer.parseInt(str.nextToken());
        if(yyyy<anoMin || yyyy>anoMax){
            JOptionPane.showMessageDialog(null, word+" nao"+yyyy+" deve ser maior que "+anoMax+" ou menor que "+anoMin, "Erro!", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }
    public Boolean validarByte(String k, int x, int y, String word){
        byte c=0;
        try{
            if(c<x || c>y){
                JOptionPane.showMessageDialog(null, "O valor de "+word+" deve ser maior que "+x+" ou menor que "+y, "Erro!", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }catch(NumberFormatException nfe){System.err.print(nfe.getMessage());}
        return true;
    }
    public Boolean validarLong(String f, long x, long y, String word) {
        long c=0;
        try{
            if(c<x || c>y){
                JOptionPane.showMessageDialog(null, "O valor de "+word+" deve ser maior que "+x+" e menor que "+y, "Erro!", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }catch(NumberFormatException nfe){System.err.print(nfe.getMessage());}
        return true;
    }
    public Boolean validarIntLength(String c, int x, String s){
        int i = c.length();
        if(i!=x){
            JOptionPane.showMessageDialog(null, "O valor de "+s+" deve ter "+x+" digitos", "Erro!", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }
    
    /*public String adapatarOpcoes(String msg, String op1, String op2) {
        int op=0;
        String s = "";
        try{
        op=Integer.parseInt(JOptionPane.showInputDialog(null, "Escolha "+msg, msg, JOptionPane.INFORMATION_MESSAGE));
        while(op<1 || op>2){
            JOptionPane.showInputDialog(null, "Opcao invalida! Por favor, tente novamente", "Erro", JOptionPane.ERROR_MESSAGE);
            op=Integer.parseInt(JOptionPane.showInputDialog(null, "Escolha "+msg, msg, JOptionPane.INFORMATION_MESSAGE));
        }
        }catch(NumberFormatException nfe){nfe.getMessage();}
        if(op==1){s=op1;}
        else 
        if(op==2){s=op2;}
        return s;
    }
    public String adaptarArea(){
        String a="";
        int op;
           try{
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
                   a=validarUsername("sua area de Formação", (byte)5, (byte)20);
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
               a=validarUsername("seu cargo", (byte)5, (byte)20);
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
        txt=JOptionPane.showInputDialog(null, "Introduza o seu "+f+":", f, JOptionPane.INFORMATION_MESSAGE);
        do{
           b=(short)txt.length();
           l=0;
           for(int i=0; i<txt.length(); i++){
                c=txt.charAt(i);
                if(Character.isLetter(c)){
                    l++;
                }
           }
           if((l!=txt.length()) || (b<y || b>z)){ 
                JOptionPane.showInputDialog(null, "Erro! Por favor, tente novamente", "Erro", JOptionPane.ERROR_MESSAGE);
                txt=JOptionPane.showInputDialog(null, "Introduza o seu "+f+":", f, JOptionPane.INFORMATION_MESSAGE);
           }
         }while((l!=txt.length()) || (b<y || b>z));
        }catch(IndexOutOfBoundsException ie){System.err.print(ie.getMessage());}
       return txt;
  }
    public String validarBI(){
        char c;
        byte b;
        String txt="";
        int nrS=0,nr=0;
        try{
        txt=JOptionPane.showInputDialog(null, "Introduza o seu BI:", "BI", JOptionPane.INFORMATION_MESSAGE);
        do{
           b=(byte)txt.length();
           nrS=0;nr=0;
           for(int i=0; i<b-2; i++){
                c=txt.charAt(i);
                if(Character.isDigit(c)){
                    nrS++;}
           }
           if(Character.isLetter(txt.charAt(b-1))){nr++;}
           if((nrS!=b-2) ||(b!=13)||(nr!=1)){ 
                JOptionPane.showInputDialog(null, "Erro! Por favor, tente novamente", "Erro", JOptionPane.ERROR_MESSAGE);
                txt=JOptionPane.showInputDialog(null, "Introduza o seu BI:", "BI", JOptionPane.INFORMATION_MESSAGE);
           }
         }while((nrS!=txt.length()-2) || (b!=13)||(nr!=1));
       }catch(IndexOutOfBoundsException ie){System.err.print(ie.getMessage());}
       return txt;
    }
    public int validarInt(String k, int x, int y) {
        int c=0;
        try{
        c=Integer.parseInt(JOptionPane.showInputDialog(null, "Introduza o seu "+k+":", k, JOptionPane.INFORMATION_MESSAGE));
       do{
           if(c<x || c>y){
                JOptionPane.showInputDialog(null, "Erro! Por favor, tente novamente", "Erro", JOptionPane.ERROR_MESSAGE);
                c=Integer.parseInt(JOptionPane.showInputDialog(null, "Introduza o seu "+k+":", k, JOptionPane.INFORMATION_MESSAGE));
           }
           }while(c<x || c>y);  
       }catch(NumberFormatException nfe){System.err.print(nfe.getMessage());}
       return c;
   }
    public String validarSemNr(String f,int y, int z) {
        char c;
        short b;
        String txt="";
        int l=0;
        try{
        txt=JOptionPane.showInputDialog(null, "Introduza o seu "+f+":", f, JOptionPane.INFORMATION_MESSAGE);
       do{
           b=(short)txt.length();
           l=0;
           for(int i=0; i<txt.length(); i++){
                c=txt.charAt(i);
                if((Character.isLetter(c))||(Character.isSpaceChar(c))){
                    l++;}
           }
           if((l!=txt.length()) || (b<y || b>z)){ 
                JOptionPane.showInputDialog(null, "Erro! Por favor, tente novamente", "Erro", JOptionPane.ERROR_MESSAGE);
                txt=JOptionPane.showInputDialog(null, "Introduza o seu "+f+":", f, JOptionPane.INFORMATION_MESSAGE);
           }
         }while((l!=txt.length()) || (b<y || b>z));
        }catch(IndexOutOfBoundsException ie){System.err.print(ie.getMessage());}
       return txt;
    }
    public String validarEstCivil() {
        int op=0;
        String s;
        try{
        System.out.println("Estado Civil: \n 1 - Soleteiro(a) \n 2 - Casado(a) \n 3 - Viuvo(a)");
        op=Integer.parseInt(JOptionPane.showInputDialog(null, "Estado Civil: \n 1 - Soleteiro(a) \n 2 - Casado(a) \n 3 - Viuvo(a)", "Estado Civil", JOptionPane.INFORMATION_MESSAGE));
        while(op<1 || op>3){
            JOptionPane.showInputDialog(null, "Opcao invalida! Por favor, tente novamente", "Erro", JOptionPane.ERROR_MESSAGE);
            op=Integer.parseInt(JOptionPane.showInputDialog(null, "Estado Civil: \n 1 - Soleteiro(a) \n 2 - Casado(a) \n 3 - Viuvo(a)", "Estado Civil", JOptionPane.INFORMATION_MESSAGE));
        }
        }catch(NumberFormatException nfe){nfe.getMessage();}
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
            System.out.println(" Introduza data de "+txt+"(no Formato dd-mm-yyyy):");
            data=br.readLine(); 
            Integer.parseInt(JOptionPane.showInputDialog(null, " Introduza data de "+txt+"(no Formato dd-mm-yyyy):", txt, JOptionPane.INFORMATION_MESSAGE));
           do{
            str= new StringTokenizer(data,"-");
            dd=Byte.parseByte(str.nextToken());
            mm=Byte.parseByte(str.nextToken());
            yyyy=Integer.parseInt(str.nextToken());
           if((dd<1 || dd>31) || (mm<1 || mm>12)|| (yyyy<anoMin || yyyy>anoMax)){
             JOptionPane.showInputDialog(null, "Erro! Por favor, tente novamente", "Erro", JOptionPane.ERROR_MESSAGE);
             Integer.parseInt(JOptionPane.showInputDialog(null, " Introduza data de "+txt+"(no Formato dd-mm-yyyy):", txt, JOptionPane.INFORMATION_MESSAGE));
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
        c=Byte.parseByte(JOptionPane.showInputDialog(null, " Introduza o seu "+k, k, JOptionPane.INFORMATION_MESSAGE));
       do{
           if(c<x || c>y){
             JOptionPane.showInputDialog(null, "Erro! Por favor, tente novamente", "Erro", JOptionPane.ERROR_MESSAGE);
             c=Byte.parseByte(JOptionPane.showInputDialog(null, " Introduza o seu "+k, k, JOptionPane.INFORMATION_MESSAGE));
           }
           }while(c<x || c>y);
       }catch(NumberFormatException nfe){System.err.print(nfe.getMessage());}
       return c;
   }
    public Long validarLong(String f, long g, long h) {
        long c=0;
         try{
        c=Long.parseLong(JOptionPane.showInputDialog(null, " Introduza o seu "+f, f, JOptionPane.INFORMATION_MESSAGE));
       do{
           if(c<g || c>h){
             JOptionPane.showInputDialog(null, "Erro! Por favor, tente novamente", "Erro", JOptionPane.ERROR_MESSAGE);
             c=Long.parseLong(JOptionPane.showInputDialog(null, " Introduza o seu "+f, f, JOptionPane.INFORMATION_MESSAGE));
           }
           }while(c<g || c>h);  
       }catch(NumberFormatException nfe){System.err.print(nfe.getMessage());}
       return c;
   }*/
}
