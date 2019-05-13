import java.io.*;
public class Tarefas {
    private Funcionario fun[];
    private int nr;
    private Validar v;
    
    
    public Tarefas() throws IOException{
        v=new Validar();
        nr=v.validarInt(" numero de funcionarios", 0, 100);
        fun= new Funcionario[nr];
        
        for(int i=0; i<nr; i++){
            fun[i]=new Funcionario();
        }
    }
    public void visualizar(){
        for(int i=0; i<nr; i++){
            System.out.println(fun[i].toString());
        }
    }
    
    public void escreverFicheiro()throws IOException{
        FileWriter fw=new FileWriter("funcionarios.txt");
        BufferedWriter bw=new BufferedWriter(fw);
        for(int i=0; i<nr; i++){
            bw.write(fun[i].getNome()+"-"+fun[i].getGenero()+"-"+fun[i].getLong()+"-"+fun[i].getBI()+"-"+fun[i].getEndereco());
            bw.newLine();
        }
        bw.close();
    }
    
}
