import java.io.*;
public class Salario {
    private int quantFunc=0, cont=0;
    private float salFunc=0, totalSal=0, mediaSal=0;
    private BufferedReader z= new BufferedReader( new InputStreamReader(System.in));
    
    public Salario () throws  IOException{
	Validar v=new Validar();
	quantFunc=v.validarInt("Introduza a quantidade de funcionarios",1,100);
	while (cont<quantFunc){
	  cont++;
	  salFunc=v.validarFloat("Introduza o salario do" +cont+ "-o funcionario",1000,50000);
          totalSal+=salFunc;
	}
        mediaSal=totalSal/quantFunc;
    }

    public int getQuantFunc(){
	return quantFunc;
    }
    public Float getSalFunc(){
	return salFunc; 
    }
    public Float getMediaSal(){
        return mediaSal;
    }
	
    
}
