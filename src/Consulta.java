package sgrh;
import java.io.*;
import java.util.StringTokenizer;
public class Consulta {
    private FileReader fr;
    BufferedReader br ;
    public Consulta() {
        
    }
    public void Principal(int op){
        int nr=0;float sal=0;
        String linha="";
        StringTokenizer str;
        try{
        fr = new FileReader("funcionarios.txt");
        br = new BufferedReader(fr);
        
        linha=br.readLine();
        nr=0;
        while(linha!=null){
            if(op==1){
               nr+=consultaGen("F",linha);
            }
             if(op==2){
               nr+=consultaGen("M",linha);
               }
             if(op==3){
                nr+=consultaTotal(linha);
             }
             if(op==4){
                sal+=consultaSalarioTotal(linha);
             }
           linha=br.readLine();
        }
        if(op==1){System.out.println("A empresa tem "+nr+" Funcionarios");}
        if(op==2){System.out.println("A empresa tem "+nr+" Funcionarias)");}
        if(op==3){System.out.println("A empresa tem "+nr+" Funcionario(s)");}
        if(op==4){System.out.println("Total de Salarios é "+sal+" MZN");}
        br.close();
         }catch(IndexOutOfBoundsException | FileNotFoundException nfe){System.out.print(nfe.getMessage());}
          catch(IOException ios){System.out.print(ios.getMessage());}
    }
    public int consultaTotal(String linha){
        int nr;
            String[] tokens = linha.split("/");
            System.out.println("Nome: "+tokens[1]+"\tApelido: "+tokens[2]+"\tCodigo do Funcionario: "+tokens[0]);
            System.out.println(); 
            nr=1;
        return nr;
        
        }
    public int consultaGen(String word,String linha){
            int nr=0;
            String[] tokens = linha.split("/");
            if(tokens[4].equalsIgnoreCase(word)){
                System.out.println("Nome: "+tokens[1]+"\tApelido: "+tokens[2]+"\tCodigo do Funcionario: "+tokens[0]);
                nr=1;
            }
    return nr;}  
         
            
      public float consultaSalarioTotal(String linha){
        float sal=0;
                String[] tokens = linha.split("/");
                sal=Float.parseFloat(tokens[12]);
                return sal;
    }
    
    
    
}