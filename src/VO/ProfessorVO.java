package VO;

public class ProfessorVO {
    private String disciplina;
    private int nrTurmas;
    
    public ProfessorVO(String disciplina, int nrTurma){
        this.disciplina = disciplina;
        this.nrTurmas = nrTurma;
    }
    
    public String getDisciplina(){
        return disciplina;
    }
    
    public void setDisciplina(String disciplina){
        this.disciplina = disciplina;
    }
    
    public int getNrTurmas(){
        return nrTurmas;
    }
    
    public void setNrTurmas(int nrTurmas){
        this.nrTurmas = nrTurmas;
    }
}