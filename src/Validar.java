
   
import java.io.*;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;

public class Validar {   
 
   private BufferedReader br= new BufferedReader( new InputStreamReader(System.in));
   public Validar(){
   }
   public int validarInt(String k, int x, int y) {
       int c=0;
       try{
       System.out.println(" Introduza o "+k+":");
        c=Integer.parseInt(br.readLine()); 
       do{
           if(c<x || c>y)
{             System.out.print("Tente Novamente: ");
             c=Integer.parseInt(br.readLine());
           }
           }while(c<x || c>y);  
       }catch(NumberFormatException nfe){System.out.print(nfe.getMessage());}
        catch(IOException io){System.out.print(io.getMessage());}
       return c;
   }
   public byte validarByte(String k, int x, int y) {
       byte c=0;
        try{
       System.out.println(" Introduza o "+k+":");
        c=Byte.parseByte(br.readLine()); 
       do{
           if(c<x || c>y){
             System.out.print("Tente Novamente: ");
             c=Byte.parseByte(br.readLine());
           }
           }while(c<x || c>y);
       }catch(NumberFormatException nfe){System.out.print(nfe.getMessage());}
        catch(IOException io){System.out.print(io.getMessage());}
       return c;
   }
   public Long validarLong(String f, long g, long h) {
        long c=0;
         try{
        System.out.println(" Introduza o "+f+":");
        c=Long.parseLong(br.readLine()); 
       do{
           if(c<g || c>h){
             System.out.print("Tente Novamente: ");
             c=Long.parseLong(br.readLine());
           }
           }while(c<g || c>h);  
       }catch(NumberFormatException nfe){System.out.print(nfe.getMessage());}
        catch(IOException io){System.out.print(io.getMessage());}
       return c;
   }
    public float validarFloat(String f, float g, float h){
        float w=0;
         try{
        System.out.println(" Introduza o "+f+":");
        w=Float.parseFloat(br.readLine()); 
       do{
           if(w<g || w>h){
             System.out.print("Tente Novamente: ");
             w=Integer.parseInt(br.readLine());
           }
           }while(w<g || w>h);  
        }catch(NumberFormatException nfe){System.out.print(nfe.getMessage());}
        catch(IOException io){System.out.print(io.getMessage());}
       return w;
   }
    public double validarDouble(String f, double g, double h){
        double c=0;
        try{
        System.out.println(" Introduza o "+f+":");
        c=Double.parseDouble(br.readLine()); 
       do{
           if(c<g || c>h){
             System.out.print("Tente Novamente: ");
             c=Integer.parseInt(br.readLine());
           }
           }while(c<g || c>h);  
         }catch(NumberFormatException nfe){System.out.print(nfe.getMessage());}
        catch(IOException io){System.out.print(io.getMessage());}
       return c;
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
        }catch(IndexOutOfBoundsException ie){System.out.print(ie.getMessage());}
        catch(IOException io){System.out.print(io.getMessage());}
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
                System.out.println("Tente Novamente: ");
                txt=br.readLine();}
         }while((nrS!=txt.length()-2) || (b!=z)||(nr!=1));
       }catch(IndexOutOfBoundsException ie){System.out.print(ie.getMessage());}
        catch(IOException io){System.out.print(io.getMessage());}
       return txt;
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
                System.out.print("Tente Novamente: ");
                txt=br.readLine();}
         }while((l!=txt.length()) || (b<y || b>z));
        }catch(IndexOutOfBoundsException ie){System.out.print(ie.getMessage());}
        catch(IOException io){System.out.print(io.getMessage());}
       return txt;
  }
    public String NotValid(String k) {
    String x="";
       try{
     System.out.println("Introduza "+k);
     x=br.readLine();
      }catch(IOException io){System.out.print(io.getMessage());}
     return x;
     
    }
    public String validarData(String txt, int anoMin,int anoMax){
    StringTokenizer str;
    String data="";
    byte dd,mm;
    int yyyy;
        try{
            System.out.println(" Introduza data de "+txt+"(no Formato dd/mm/yyyy): ");
            data=br.readLine(); 
           do{
            str= new StringTokenizer(data,"/");
            dd=Byte.parseByte(str.nextToken());
            mm=Byte.parseByte(str.nextToken());
            yyyy=Integer.parseInt(str.nextToken());
           if((dd<1 || dd>31) || (mm<1 || mm>12)|| (yyyy<anoMin || yyyy>anoMax)){
             System.out.print("Tente Novamente: ");
             data=br.readLine();
           }
           }while((dd<1 || dd>31) || (mm<1 || mm>12)|| (yyyy<2000 || yyyy>2018));  
        }catch(NumberFormatException | IOException | NoSuchElementException nfe){System.out.print(" Formato Invalido!");}
    return data;
    }
    
} 
    
    
  
