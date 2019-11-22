package view;

import control.BDconexao;
import java.awt.*;
import static java.awt.Frame.MAXIMIZED_BOTH;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

public class Relatorios extends JFrame{
    
    JButton btn[]=new JButton[4];
    JLabel menu_Label;
    JPanel p[]=new JPanel[4];
    
    //Default
    Font titulo_Font,Butoes_Font;
    Color blue,white,orange,gray;
    Dimension dimensao_Btn;
    GridBagConstraints gbc= new GridBagConstraints();
   
    public Relatorios() {
        setTitle("Relatorios || S.G.R.H");
        setLocation(250,100);
        setSize(900,700);
        setExtendedState(MAXIMIZED_BOTH);
        
        //Layout
        setLayout(new GridBagLayout());
        gbc=new GridBagConstraints() ;
        gbc.insets= new Insets(5,5,5,5);
        
        // Inicializando Variaveis
        dimensao_Btn=new Dimension(180,60);
        
        titulo_Font= new Font("SansSerif",Font.BOLD,60);
        Butoes_Font=new Font("SansSerif",Font.BOLD,13);
        
        blue=new Color(44,62,80);
        white =new Color(247,247,247);
        gray=new Color(149,156,147);
        orange=new Color(245,139,31);
        
        //Imagem
        JLabel img=new JLabel("",new ImageIcon("src/images/c-1.jpg"),JLabel.CENTER);
        img.setVerticalAlignment(JLabel.TOP);
        img.setHorizontalAlignment(JLabel.CENTER);
        
        gbc.gridwidth=2;
        gbc.gridx=0;
        gbc.gridy=0;
        add(img,gbc);
    
        //Metodo Menu 
        menuPrincipal();
        
        getContentPane().setBackground(Color.WHITE);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);  
    }

    public void menuPrincipal() {
        p[1]=new JPanel();
        btn[0]=new JButton("Lista de Funcionarios");
         btn[0].addActionListener(new ActionListener(){ 
            public void actionPerformed(ActionEvent event){
                try {
                    Connection c=BDconexao.getConnection();
                    String src="report1.jasper";
                    JasperPrint jaspertPrint=null;
                    jaspertPrint = JasperFillManager.fillReport(src, null,c);
                    JasperViewer v=new JasperViewer(jaspertPrint,false);
                    v.setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(MenuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(MenuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                } catch (JRException ex) {
                    Logger.getLogger(MenuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                }
                }
            });
     
        btn[1]=new JButton("Folha de Salário");
        btn[1].addActionListener(new ActionListener(){ 
       public void actionPerformed(ActionEvent event){
           try {
               Connection c=BDconexao.getConnection();
               String src="salario.jasper";
               JasperPrint jaspertPrint=null;
               jaspertPrint = JasperFillManager.fillReport(src, null,c);
               JasperViewer v=new JasperViewer(jaspertPrint,false);
               v.setVisible(true);
           } catch (SQLException ex) {
               Logger.getLogger(MenuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
           } catch (ClassNotFoundException ex) {
               Logger.getLogger(MenuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
           } catch (JRException ex) {
               Logger.getLogger(MenuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
           }
           }
       });
           
         btn[2]=new JButton("Voltar");
         btn[2].addActionListener(new ActionListener(){ 
            public void actionPerformed(ActionEvent event){
                setVisible(false);
                MenuPrincipal lg=new MenuPrincipal();
                }
            });
        for(int i=0;i<3;i++){
            btn[i].setPreferredSize(dimensao_Btn);
            btn[i].setFont(Butoes_Font);
            btn[i].setBackground(orange);
            btn[i].setForeground(blue);
            p[1].add(btn[i]);
            }
        
        p[1].setBackground(Color.WHITE);
        gbc.gridx=0;
        gbc.gridy=1;
        add(p[1],gbc);
        
    }
}