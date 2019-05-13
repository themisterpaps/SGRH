import java.io.*;
import java.util.*;
public class Tarefas {
    private Funcionario fun;
    private Vector vt;
    private int nr,cont;
    private Validar v;
    
    
    public Tarefas(){
      vt= new Vector();
      cont=0;
    }
    public void CriarFuncionario(){
     fun=new Funcionario();
     vt.add(cont, fun);
     System.out.println(fun);
     cont++;
    }
    public void escreverFicheiroTXT(){
         try{
        FileWriter fw=new FileWriter("funcionarios.txt",true);
        BufferedWriter bw=new BufferedWriter(fw);
        for(int i=0; i<cont; i++){
            fun=(Funcionario)(vt.elementAt(i));
            bw.write(fun.dadosFich());
            bw.newLine();
        }
         bw.close();
        }catch(IOException io){System.out.print(io.getMessage());} 
       
    }
        public void escreverFicheiroOdj(String fichOd){
try{
    FileOutputStream fos= new FileOutputStream(fichOd);
    ObjectOutputStream oos= new ObjectOutputStream(fos);
     oos.writeObject(v);
     oos.close();
     }catch(IOException ios){System.out.print(ios.getMessage());}
    
    }
    
}
