import java.io.*;

public class Validar {   
    public Validar(){}
   private BufferedReader br= new BufferedReader( new InputStreamReader(System.in));
   public int validarInt(String k, int x, int y) throws IOException {
       int c=0;
       System.out.println(" Introduza "+k+":");
        c=Integer.parseInt(br.readLine()); 
       do{
           if(c<x || c>y){
             System.out.print("Tente Novamente: ");
             c=Integer.parseInt(br.readLine());
           }
           }while(c<x || c>y);  
       return c;
   }
   public byte validarByte(String k, int x, int y) throws IOException {
       byte c=0;
       System.out.println(" Introduza  "+k+":");
        c=Byte.parseByte(br.readLine()); 
       do{
           if(c<x || c>y){
             System.out.print("Tente Novamente: ");
             c=Byte.parseByte(br.readLine());
           }
           }while(c<x || c>y);  
       return c;
   }
   public long validarLong(String k, long x, long y) throws IOException {
       long c=0;
       System.out.println(" Introduza o "+k+":");
        c=Long.parseLong(br.readLine()); 
       do{
           if(c<x || c>y){
             System.out.print("Tente Novamente: ");
             c=Long.parseLong(br.readLine());
           }
           }while(c<x || c>y);  
       return c;
   }
    public float validarFloat(String f, float g, float h) throws IOException {
        float w=0;
        System.out.println(" Introduza o "+f+":");
        w=Float.parseFloat(br.readLine()); 
       do{
           if(w<g || w>h){
             System.out.print("Tente Novamente: ");
             w=Integer.parseInt(br.readLine());
           }
           }while(w<g || w>h);  
       return w;
   }
    public double validarDouble(String f, double g, double h) throws IOException {
        double c=0;
        System.out.println(" Introduza o "+f+":");
        c=Double.parseDouble(br.readLine()); 
       do{
           if(c<g || c>h){
             System.out.print("Tente Novamente: ");
             c=Integer.parseInt(br.readLine());
           }
           }while(c<g || c>h);  
       return c;
   }
    public String validarNome(String f,int y, int z) throws IOException {
        char c;
        short b;
        String txt;
        int l=0;
        
        System.out.println(" Introduza o "+f+":");
        txt=br.readLine(); 
       do{
           b=(short)txt.length();
           l=0;
           for(int i=0; i<txt.length(); i++){
                c=txt.charAt(i);
                if(Character.isLetter(c)){
                    l++;}
           }
           if((l!=txt.length()) || (b<y || b>z)){ 
                System.out.print(b+"Tente Novamente: ");
                txt=br.readLine();}
         }while((l!=txt.length()) || (b<y || b>z));
       
       return txt;
  }
    public String validarBI(String f,int y, int z) throws IOException {
        char c;
        short b;
        String txt;
        int nrS=0,nr=0;
        System.out.println(" Introduza o "+f+":");
        txt=br.readLine();
       do{
           b=(short)txt.length();
           nrS=0;
           for(int i=0; i<txt.length()-2; i++){
                c=txt.charAt(i);
                if(Character.isDigit(c)){
                    nrS++;}
           }
           if(Character.isLetter(txt.charAt(b-1))){nr++;}
           if((nrS!=txt.length()-2) || (b<y || b>z) ||(nr!=1)){ 
                System.out.print("Tente Novamente: ");
                txt=br.readLine();}
         }while((nrS!=txt.length()-2) || (b<y || b>z)||(nr!=1));
       
       return txt;
    }
    
    public String validarGenero() throws IOException{
        int op;
        String s;
        
        System.out.println("Escolha o seu genero: \n1 - Masculino \n2 - Feminino \n3 - Prefiro nao dizer");
        op=Integer.parseInt(br.readLine());
        while(op<1 || op>3){
            System.out.println("Opcao invalida! Por favor, tente novamente");
            op=Integer.parseInt(br.readLine());
        }
        
        if(op==1){
            s="Masculino";
        }
        else if(op==2){
            s="Femenino";
        }
        else{
            s="Prefiro nao dizer";
        }
        
        return s;
    }
    
    public String validarEstado() throws IOException{
        int op;
        String s;
        
        System.out.println("Escolha o seu estado civil: \n1 - Casado(a) \n2 - Solteiro(a) \n3 - Viuvo(a)");
        op=Integer.parseInt(br.readLine());
        while(op<1 || op>3){
            System.out.println("Opcao invalida! Por favor, tente novamente");
            op=Integer.parseInt(br.readLine());
        }
        
        if(op==1){
            s="Casado(a)";
        }
        else if(op==2){
            s="Solteiro(a)";
        }
        else{
            s="Viuvo(a)";
        }
        
        return s;
        }
    public String validarCategoria()throws IOException{
        String a="";
        int op;
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Digite a categoria\n 1-Director\n 2-Gestor\n 3-Advogado\n 4-Chefe \n 5-Tecnico\n 6-Estagiario");
        op=Integer.parseInt(br.readLine());
        switch(op){
            case 1:
              a="Director(a)";
            break;
            case 2:
              a="Gestor(a)";
            break;
            case 3:
              a="Advogado(a)";
            break;
            case 4:
              a="Chefe";
            break;
            case 5:
              a="Tecnico(a)";
            break;
            case 6:
              a="Estagiario(a)";
            break;
            default:
              a="Funcionario";
            break;    } return a;    
    }
  public String validarArea()throws IOException{
     String a="";
     int op;
     BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
     System.out.println("Digite a sua Area de Formacao\n 1-Administracao\n 2-Dierito\n 3-Economia\n 4-Educacao\n 5-Engenharia \n 6-Gestao\n 7-Psicologia\n 8-Publicidade\n 9-Saude\n 10-Sociologia\n 11-Transportes ");
     op=Integer.parseInt(br.readLine());
     switch(op){
         case 1:
             a="Administracao";
        break;
         case 2:
             a="Direito";
        break;
         case 3:
             a="Economia";
             
        break;
         case 4:
            a="Educacao";
        break;
         case 5:
            a="Engenharia";
        break;
         case 6:
            a="Gestao";
        break;
         case 7:
            a="Psicologia";
        break;
         case 8:
            a="Publicidade";
        break;
         case 9:
            a="Saude";
        break;
         case 10:
            a="Sociologia";
        break;
         case 11:
             a="Transportes";
         default :
             a="Nenhuma";}
                    
                    
     return a; 
  
  }
}