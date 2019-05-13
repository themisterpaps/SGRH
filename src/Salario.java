import java.io.*;
public class Salario {
    private float salario;
    private int dias;
    private String tipo;
    private Validar vv=new Validar();
    public Salario(){
        salario=3000;
    }
     public void menuSal() {
        byte op;
        float sal=0 ;
                op=vv.validarByte("o tipo de contrato de  funcionario: \n 1-Contrato por hora \n 2-Contrato por Presenca \n 3-Contrato por servicos \n 4-Contrato temporario",1,4);
                switch(op){
                    case 1: System.out.println("-----Contrato hora----"); 
                            sal=salarioHora();
                            tipo="hora";
                            break;
                    case 2: System.out.println("-----Contrato por presenca-------"); 
                            sal=salarioPres();
                            tipo="Presenca";
                             break;
                    case 3: System.out.println("-----Contrato por Servicos----------");
                            sal=salarioServ();
                            tipo="servicos";
                            break;
                    case 4: System.out.println("-----Contrato temporario"); 
                            sal=salarioTemp();
                            tipo="temporario";
                            break;
                    default:
                        System.out.println("Opcao invalida. Tente again !!!!!!!!");
                }
                System.out.println("Salario: "+sal);
        
       
   }
     public float salarioHora(){
        int hr;     
        hr=vv.validarInt("Introduza as horas de trabalho:(1 - 8h)", 1, 8);
        salario=500*hr*22;
        return salario;
    }
     public float salarioPres () {
        dias=vv.validarInt("Introduza os dias em que se faz presente na empresa: (1 - 22) ", 1, 22);
        salario=1100*dias;
        return salario;
    }
     public float salarioServ (){
        int nrsp;
        dias=vv.validarInt("Introduza o numero de dias em que prestou servicos na empresa:(1 - 22h) ", 1, 22);
        nrsp=vv.validarInt("Introduza o numero de servicos prestados: (1 - 10h)",1,10);
        salario=10000*nrsp*dias;
        return salario;
    }
     public float salarioTemp () {
        int hrsp;
        float salario;
        hrsp=vv.validarInt("Introduza as horas de trabalho:(1 - 8h)", 1, 8);
        dias=vv.validarInt("Introduza o numero de dias em que presta servicos temporarios na empresa:(1 - 22h)", 1, 22);
        salario=950*hrsp*dias;
        return salario;
    }

    public float getSalario() {
        return salario;
    }

    public String getTipo() {
        return tipo;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }
     
} 