
package sgrh;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Vector;

public class Adpt_Ficheiro {

    public Adpt_Ficheiro() {
    }
        public void esc_VectorEmTXT( String nomeFich, Vector vt, boolean delete){
        try{
            Funcionario fun;
            FileWriter fw=new FileWriter(nomeFich,delete);
            BufferedWriter bw=new BufferedWriter(fw);
            for(int i=0; i<vt.size(); i++){
                fun=(Funcionario)(vt.elementAt(i));
                bw.write(fun.dadosFich());
                bw.newLine();
            }
            bw.close();
        }catch(IOException io){System.out.print(io.getMessage());}        
    }
        public void esc_VectorEmDAT(String fichOd,  Vector vt){
        try{
            FileOutputStream fos= new FileOutputStream(fichOd);
            ObjectOutputStream oos= new ObjectOutputStream(fos);
            oos.writeObject(vt);
            oos.close();
        }catch(IOException ios){System.out.print(ios.getMessage());}
    }
}
