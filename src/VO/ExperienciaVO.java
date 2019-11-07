package VO;

public class ExperienciaVO {
    private String nomeEmpresa, anoExperiencia, cargo, areaFormacao, dataInicio, dataFim;
    
    public ExperienciaVO(String nomeEmpresa, String anoExperiencia, String cargo, String areaFormacao, String dataInicio, String dataFim){
        this.nomeEmpresa = nomeEmpresa;
        this.anoExperiencia = anoExperiencia;
        this.cargo = cargo;
        this.areaFormacao = areaFormacao;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
    }
    
    public String getNomeEmpresa(){
        return nomeEmpresa;
    }
    
    public void setNomeEmpresa(String nomeEmpresa){
        this.nomeEmpresa = nomeEmpresa;
    }
    
    public String getAnoExperiencia(){
        return anoExperiencia;
    }
    
    public void setAnoExperiencia(String anoExperiencia){
        this.anoExperiencia = anoExperiencia;
    }
    
    public String getCargo(){
        return cargo;
    }
    
    public void setCargo(String cargo){
        this.cargo = cargo;
    }
    
    public String getAreaFormacao(){
        return areaFormacao;
    }
    
    public void setAreaFormacao(String areaFormacao){
        this.areaFormacao = areaFormacao;
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