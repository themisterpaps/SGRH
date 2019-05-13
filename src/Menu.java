import java.io.*;
public class Menu {
    public static void main(String[] args) throws IOException{
        int op;
        Validar v=new Validar();
        Tarefas t;
        
        System.out.println("-----------------Menu-----------------");
        do{
            System.out.println(" 1 - Cadastrar funcionarios e Visualizar os funcionarios \n 2 - Sair");
            op=v.validarInt("a opcao",1,2);
            
            switch(op){
                case 1: 
                    t=new Tarefas();
                    t.escreverFicheiro();
                    t.visualizar();
                ;
                break;
                
                default: System.out.println("Opcao invalida! Tente novamente.");
                break;
            }
        }while(op!=2);
    }    
}