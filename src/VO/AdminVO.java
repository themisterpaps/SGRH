package VO;

public class AdminVO {
    private String cargo, username, password;
    
    public AdminVO(String cargo, String username, String password){
        this.cargo = cargo;
        this.username = username;
        this.password = password;
    }
    
    public String getCargo(){
        return cargo;
    }
    
    public void setCargo(String cargo){
        this.cargo = cargo;
    }
    
    public String getUsername(){
        return username;
    }
    
    public void setUsername(String username){
        this.username = username;
    }
    
    public String getPassword(){
        return password;
    }
    
    public void setPassword(String password){
        this.password = password;
    }
}
