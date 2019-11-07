package VO;

public class PlanoDeSaudeVO {
    private String dataInicio, dataFim;
    private int nrAgre;
    
    public PlanoDeSaudeVO(String dataInicio, String dataFim, int nrAgre){
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.nrAgre = nrAgre;
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
    
    public int getNrAgre(){
        return nrAgre;
    }
    
    public void setNrAgre(){
        this.nrAgre = nrAgre;
    }
}
