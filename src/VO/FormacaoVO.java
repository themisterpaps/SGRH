package VO;

public class FormacaoVO {
    private String nomeFormacao, nivel, anoI, anoF;
    
    public FormacaoVO(String nomeFormacao, String nivel, String anoI, String anoF){
        this.nomeFormacao = nomeFormacao;
        this.nivel = nivel;
        this.anoI = anoI;
        this.anoF = anoF;
    }
    
    public String getNomeFormacao(){
        return nomeFormacao;
    }
    
    public void setNomeFormacao(String nomeFormacao){
        this.nomeFormacao = nomeFormacao;
    }
    
    public String getNivel(){
        return nivel;
    }
    
    public void setNivel(String Nivel){
        this.nivel = nivel;
    }
    
    public String getAnoI(){
        return anoI;
    }
    
    public void setAnoI(String anoI){
        this.anoI = anoI;
    }
    
    public String getAnoF(){
        return anoF;
    }
    
    public void setAnoF(String anoF){
        this.anoF = anoF;
    }
}
