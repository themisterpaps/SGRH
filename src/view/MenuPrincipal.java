package view;

import control.BDconexao;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

public class MenuPrincipal extends JFrame{
    
    JButton btn[]=new JButton[5];
    JLabel menu_Label;
    JPanel p[]=new JPanel[5];
    
    //Default
    Font titulo_Font,Butoes_Font;
    Color blue,white,orange,gray;
    Dimension dimensao_Btn;
    GridBagConstraints gbc= new GridBagConstraints();
   
    public MenuPrincipal() {
        setTitle("Menu Principal || S.G.R.H");
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
        JLabel img=new JLabel("",new ImageIcon("src/images/c.jpg"),JLabel.CENTER);
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
        btn[0]=new JButton("Cadastar Funcionarios");
        btn[0].addActionListener(new ActionListener(){ 
            public void actionPerformed(ActionEvent event){
                setVisible(false);
                DadosPessoais dv=new DadosPessoais();
                }
            });
         btn[1]=new JButton("Processar salarios");
         btn[1].addActionListener(new ActionListener(){ 
            public void actionPerformed(ActionEvent event){
                setVisible(false);
                Pagamento pg =new Pagamento();
                }
            });
         btn[2]=new JButton("Relatorio");
         btn[2].addActionListener(new ActionListener(){ 
            public void actionPerformed(ActionEvent event){
               Relatorios rl =new Relatorios();
                }
            });
         btn[3]=new JButton("Actualizar Dados");
         btn[3].addActionListener(new ActionListener(){ 
            public void actionPerformed(ActionEvent event){
               Actualizar rl =new Actualizar();
                }
            });
         btn[4]=new JButton("Sair");
         btn[4].addActionListener(new ActionListener(){ 
            public void actionPerformed(ActionEvent event){
                setVisible(false);
                Login lg=new Login();
                }
            });
        for(int i=0;i<=4;i++){
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