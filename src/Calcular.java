import java.io.*;
public class Calcular {
    private byte cargaHoraria;
    private int nrFaltas;
    private double salario, salarioPorHora;
    private BufferedReader br= new BufferedReader( new InputStreamReader(System.in));
    
    public Calcular() throws IOException{
        Validar v=new Validar();
        cargaHoraria=v.validarByte(" a carga horaria diaria\n de 1 a 10",1,10);
        salarioPorHora=v.validarFloat(" seu salario(por hora) de 20 a 500", 20, 500);
        salario=(salarioPorHora*cargaHoraria*22);
    }
    
    public Double getSalario(){return salario;}
}
