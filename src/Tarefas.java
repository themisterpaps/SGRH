import java.io.*;
import java.util.Locale;
import java.util.StringTokenizer;
public class Tarefas {
    private Funcionario fun[];
    private int nr;
    private Validar v;
    
    
    public Tarefas() throws IOException{
        try{
        v=new Validar();
        nr=v.validarInt(" numero de funcionarios", 0, 100);
        fun= new Funcionario[nr];
        
        for(int i=0; i<nr; i++){
            fun[i]=new Funcionario();
        }
         }catch(IndexOutOfBoundsException nfe){System.out.print(nfe.getMessage());}
         catch(NumberFormatException nfe){System.out.print(nfe.getMessage());}
         catch(IOException io){System.out.print(io.getMessage());} 
    }
    public void visualizar(){
        for(int i=0; i<nr; i++){
            System.out.println(fun[i].toString());
        }
    }
    public void lerFicheiro(){
        StringTokenizer str;
        String linha="", nome, genero,auxAuto;
        long auxAno, telefone;
        try{
        FileReader fr= new FileReader("funcionarios.txt");
        BufferedReader br= new BufferedReader(fr);
        linha=br.readLine();
        while(linha!=null){
            str= new StringTokenizer(linha,";");
            nome=str.nextToken();
            genero=str.nextToken();
            telefone=Long.parseLong(str.nextToken());
            System.out.print("Nome: "+nome+"Genro"+genero);
            linha=br.readLine();
        }br.close(); 
        }catch(FileNotFoundException fne){System.out.print("Sem funcionarios Cadastrados");}
        catch(NumberFormatException nfe){System.out.print(nfe.getMessage());}
        catch(IOException io){System.out.print(io.getMessage());}
       }
    public void escreverFicheiro(){
         try{
        FileWriter fw=new FileWriter("funcionarios.txt");
        BufferedWriter bw=new BufferedWriter(fw);
        for(int i=0; i<nr; i++){
            bw.write(fun[i].getNome()+"-"+fun[i].getGenero()+"-"+fun[i].getLong()+"-"+fun[i].getBI()+"-"+fun[i].getEndereco());
            bw.newLine();
        }
         bw.close();
        }catch(NumberFormatException nfe){System.out.print(nfe.getMessage());}
         catch(IOException io){System.out.print(io.getMessage());} 
       
    }
    public void consultas(){   
    }
    public void trabalhadoras(){
    
    }
    
}
