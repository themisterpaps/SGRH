import java.io.*;
import java.util.StringTokenizer;
public class Menu {
    private byte op;
    public Menu(){
   
    }   
    public void menuOP(){
         int op;
         try{
        Validar v=new Validar();
        Tarefas t;
        System.out.println("-----------------Menu-----------------");
        do{
            System.out.println(" 1 - Cadastrar funcionarios e Visualizar os funcionarios \n 2 - Lista de Funcionarios da Empresa 3-Sair");
            op=v.validarInt("a opcao",1,2);
            switch(op){
                case 1: 
                    t=new Tarefas();
                    t.escreverFicheiro();
                    t.visualizar();break;
                case 2:
                    lerFicheiro();  
                break;
                default: System.out.println("Opcao invalida! Tente novamente.");
                break;
            }
        }while(op!=2);
        }catch(NumberFormatException nfe){System.out.print(nfe.getMessage());}
         catch(IOException io){System.out.print(io.getMessage());} 
    }
    public void lerFicheiro(){
        StringTokenizer str;
        String linha="", nome, genero,bi,endereco;
        long  telefone;
        try{
        FileReader fr= new FileReader("funcionarios.txt");
        BufferedReader br= new BufferedReader(fr);
        linha=br.readLine();
        while(linha!=null){
            str= new StringTokenizer(linha,"-");
            nome=str.nextToken();
            genero=str.nextToken();
            telefone=Long.parseLong(str.nextToken());
            bi=str.nextToken();
            endereco=str.nextToken();
            System.out.println("____________________________\nNome: "+nome+"\nGenero: "+genero+"\nTelefone: "+telefone+"\nBI: "+bi+"\nEndereço: "+endereco);
            linha=br.readLine();
        }br.close(); 
        }catch(FileNotFoundException fne){System.out.print("--------------------Sem funcionarios Cadastrados--------------------");}
        catch(NumberFormatException nfe){System.out.print(nfe.getMessage());}
        catch(IOException io){System.out.print(io.getMessage());}
       }
}