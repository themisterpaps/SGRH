import java.io.*;
public class Executavel {
    public static void main(String[] args) throws IOException{
        
        Tarefas t=new Tarefas();
        t.visualizar();
        t.escreverFicheiro();
    }
}
