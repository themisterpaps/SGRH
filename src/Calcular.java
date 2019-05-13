import java.io.*;
public class Calcular {
    private byte cargaHoraria;
    private int nrFaltas;
    private double salario, salarioPorHora;
    private BufferedReader br= new BufferedReader( new InputStreamReader(System.in));
    
    public Calcular() throws IOException{
        Validar v=new Validar();
        cargaHoraria=v.validarByte("Introduza a carga horaria diaria",1,10);
        salarioPorHora=v.validarFloat("Introduza o seu salario(por hora)", 20, 500);
        salario=(salarioPorHora*cargaHoraria*22);
    }
    
    public Double getSalario(){return salario;}
}
