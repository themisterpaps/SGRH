
public class Menu {
    private byte op;
    public Menu(){
    }   
    public void menuOP(){
         int op;
        
        Validar v=new Validar();
        Tarefas t=new Tarefas();;
        System.out.println("-----------------Menu-----------------");
        do{
            System.out.println(" 1 - Cadastrar funcionarios \n 2 - Lista de Funcionarios da Empresa \n 3-Sair");
            op=v.validarInt("a opcao",1,3);
            switch(op){
                case 1: 
                    t.CriarFuncionario();
                    t.escreverFicheiroTXT();
                    t.escreverFicheiroOdj("funcionario.dat");
                    break;
                case 2:
                    Consulta c = new Consulta();
                    c.menuConsultas();
                    System.out.println("Obrigado por usar nosso aplicativo!");
                break;
                default: System.out.println("Opcao invalida! Tente novamente.");
                break;
            }
        }while(op!=3);   
    }
   
}