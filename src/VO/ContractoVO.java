package VO;

public class ContractoVO {
    private String dataInicio, dataFim;
    private char tipo;
    
    public ContractoVO(String dataInicio, String dataFim, char tipo){
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.tipo = tipo;
    }
    
    public char getTipo(){
        return tipo;
    }
    
    public void setTipo(char tipo){
        this.tipo = tipo;
    }
    
    public String getDataInicio(){
        return dataInicio;
    }
    
    public void setDataInicio(String dataInicio){
        this.dataInicio = dataInicio;
    }
    
    public String getDataFim(){
        return dataFim;
    }
    
    public void setDataFim(String dataFim){
        this.dataFim = dataFim;
    }
}
