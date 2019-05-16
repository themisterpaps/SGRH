package sgrh;
import java.io.*;
public class Menu {
    byte op;
    public Menu(){
    }   
    public void menuOP() throws IOException, ClassNotFoundException {
         int op;
        
        Validacoes v=new Validacoes();
        Tarefas t=new Tarefas();;
        System.out.println("-----------------Menu-----------------");
        do{
            System.out.println(" 1 - Cadastrar funcionarios \n 2 - Lista de Funcionarios da Empresa \n 3 - Operações \n 0 - Sair");
            op=v.validarInt("a opcao",0,3);
            switch(op){
                case 1: 
                    t.cadastro();
                    t.escreverFicheiroTXT();
                    t.escreverFicheiroOdj("funcionario.dat");
                    break;
                case 2:
                    Consulta c = new Consulta();
                    c.menuConsultas();
                break;
                case 3:
                    Opr o=new Opr();
                    o.menuOP();
                    break;
                    default: 
                    System.out.println("Obrigado por usar nosso aplicativo!");
                    break;
            }
        }while(op!=0);   
    }
}
