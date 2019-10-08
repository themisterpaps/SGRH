package view;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author CHIGUMANE
 */
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import javax.swing.*;

public class DadosPessoais extends JFrame{
    JButton b[]=new JButton[4];
    JPanel p[]= new JPanel[8];
    JLabel l[]=new JLabel[10];
    JTextField tf[]=new JTextField[5];
    JRadioButton rb[]=new JRadioButton[6];
    ButtonGroup bg[]=new ButtonGroup[2];
    JSpinner sp[]=new JSpinner[5];
    JComboBox cb[]=new JComboBox[5];
    //Default
    Font titulo_Font,Butoes_Font,label_Font,ComboBox_Font;
    Color blue,white,orange,gray;
    Dimension dimensao_Btn;
    GridBagConstraints gbc= new GridBagConstraints();
    
    public DadosPessoais() {
        setTitle("Cadastro || S.G.R.H");
        setLocation(250,100);
        setSize(900,700);
        setExtendedState(MAXIMIZED_BOTH);
        
        //Layout
        setLayout(new GridBagLayout());
        gbc=new GridBagConstraints() ;
        gbc.insets= new Insets(10,5,10,5);
        
        //Incializando Variaveis
        dimensao_Btn=new Dimension(180,60);
        titulo_Font= new Font("SansSerif",Font.BOLD,60);
        Butoes_Font=new Font("SansSerif",Font.BOLD,13);
        label_Font=new Font("SansSerif",Font.BOLD,14);
        ComboBox_Font=new Font("SansSerif",Font.BOLD,12);
        
        blue=new Color(44,62,80);
        white =new Color(255,255,255);
        gray=new Color(149,156,147);
        orange=new Color(245,139,31);
          
        //Imagem 
        JLabel img=new JLabel("",new ImageIcon("src/images/d.jpg"),JLabel.CENTER);
     
        gbc.gridwidth=0;
        gbc.gridx=0;
        gbc.gridy=0;
        add(img,gbc);
        
        //Imagem 2
        gbc.gridwidth=2;
        gbc.fill=GridBagConstraints.HORIZONTAL;
        JLabel img2=new JLabel("",new ImageIcon("src/images/e.jpg"),JLabel.LEFT);
        
        gbc.gridwidth=0;
        gbc.gridx=0;
        gbc.gridy=1;
        add(img2,gbc);
        
        
        dadosPessoais();
        
        getContentPane().setBackground(Color.WHITE);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true); 
    }

    private void dadosPessoais() {
        //Todas As Labels
        l[0] = new JLabel("Username: ");
        l[1] = new JLabel("Apelido: ");
        l[2] = new JLabel("Bilhete de Identidade: "); 
        l[3] = new JLabel("Sexo");
        l[4] = new JLabel("Data de Nascimento:"); 
        l[5] = new JLabel("NIB");
        l[6] = new JLabel("Nacionalidade:");
        l[7] = new JLabel("NUIT");
        l[8] = new JLabel("Estado Civil");
        //Label Propriedade
        for(int i=0;i<=8;i++){
         l[i].setFont(label_Font);
         l[i].setForeground(blue);
         l[i].setBackground(white);
        }
        
        // Linha 1
        tf[0]=new JTextField("Username ",16);
        tf[1]=new JTextField("Apelido ",16);
        p[1]=new JPanel(new FlowLayout(FlowLayout.LEFT,10,5));
        
        for(int i=0;i<2;i++){
            tf[i].setForeground(gray);
            p[1].add(l[i]);
            p[1].add(tf[i]);      
        }
        
        
        p[1].setBackground(white);
        gbc.gridx=0;
        gbc.gridy=2;
        add(p[1],gbc);
        
        // Linha 2
        p[2]=new JPanel(new FlowLayout(FlowLayout.LEFT,10,5));
        tf[2]=new JTextField("Número de Bilhete de Identidade ",20);
        tf[2].setForeground(gray);
           
        p[2].add(l[2]);
        p[2].add(tf[2]);
        

        l[3].setFont(label_Font);
        l[3].setForeground(blue);
        
        p[2].add(l[3]);
        
        rb[0] = new JRadioButton("M");rb[1] = new JRadioButton("F");
        rb[1].setSelected(true);
        
        bg[0] = new ButtonGroup();
        for(int i=0; i<2;i++){
            rb[i].setFont(label_Font);
            rb[i].setBackground(white);
            rb[i].setForeground(blue);
            
            bg[0].add(rb[i]);
            p[2].add(rb[i]);
           
        }
      
      
        l[4].setFont(label_Font);
        l[4].setForeground(blue);

       
       
         
        p[2].setBackground(white);

       gbc.gridx=0;
       gbc.gridy=3;
       add(p[2],gbc);
       
       
       //Linha 3
       p[3]=new JPanel(new FlowLayout(FlowLayout.LEFT,16,5));
       
        sp[0]= new JSpinner(new SpinnerDateModel());
        SimpleDateFormat model = new SimpleDateFormat("dd/MM/yyyy");
        sp[0].setEditor(new JSpinner.DateEditor(sp[0], model.toPattern()));
        sp[0].setFont(label_Font);
        sp[0].setForeground(blue);
        
        
        p[3].add(l[4]);
        p[3].add(sp[0]);
 
        
        tf[3]=new JTextField("NIB  ",20);
        tf[3].setForeground(gray);
        
        p[3].add(l[5]);
        p[3].add(tf[3]);

  
       p[3].setBackground(white);
       gbc.gridx=0;
       gbc.gridy=4;
       add(p[3],gbc);
       
       //Linha 4
        p[4]=new JPanel(new FlowLayout(FlowLayout.LEFT,10,5));     
        String nacionalidades[] = {"Seleccione uma opção","Alemão","Angolano",
            "Brasileiro","Chinês","Cubano","Dinamarquês","Espanhol","Francês","Grego",
            "Holandês","Indiano","Inglês","Japonês","Mexicano","Moçambicano","Português",
            "Russo","Sul-Africano"};
        cb[0] = new JComboBox(nacionalidades);
        cb[0].setFont(ComboBox_Font);
        cb[0].setForeground(blue);
        cb[0].setBackground(white);
        
        p[4].add(l[6]);
        p[4].add(cb[0]);

        tf[4] = new JTextField("NUIT ", 20);
        p[4].add(l[7]);
        p[4].add(tf[4]);
        tf[4].setForeground(gray);
        
        p[4].setBackground(white);
        gbc.gridx=0;
        gbc.gridy=5;
        add(p[4],gbc);
        
        //linha 5
        p[5]=new JPanel(new FlowLayout(FlowLayout.LEFT,10,5));
        p[5].add(l[8]);
        rb[3] = new JRadioButton("Solteiro");
        rb[3].setSelected(true);
        rb[4] = new JRadioButton("Casado");
        rb[5] = new JRadioButton("Outros");
        for(int i=3;i<=5;i++){
            rb[i].setFont(label_Font);
            rb[i].setForeground(blue);
            rb[i].setBackground(white);
            p[5].add(rb[i]);
        }
        bg[1] = new ButtonGroup();
        gbc.fill=GridBagConstraints.VERTICAL;
        p[5].setBackground(white);
        gbc.gridx=0;
        gbc.gridy=6;
        add(p[5],gbc); 
        
        //Butoes
        p[6]=new JPanel(new FlowLayout(FlowLayout.CENTER,50,25));
        JButton cancelar=new JButton("Cancelar");
        cancelar.setBackground(orange);
        cancelar.setPreferredSize(new Dimension(120,32));
        cancelar.setFont(new Font("Sans Serif",Font.BOLD,14));
        cancelar.addActionListener(new ActionListener(){ 
            public void actionPerformed(ActionEvent event){
                setVisible(false);
                MenuPrincipal m=new MenuPrincipal();
                }
            });
        

        JButton proximo=new JButton("Proximo");
        proximo.setBackground(blue);
        proximo.setForeground(white);
        proximo.setPreferredSize(new Dimension(120,32));
        proximo.setFont(new Font("Sans Serif",Font.BOLD,14));
        proximo.addActionListener(new ActionListener(){ 
            public void actionPerformed(ActionEvent event){
                 setVisible(false);
                 PlanoDeSaude pn=new PlanoDeSaude();
                }
            }); 
        p[6].add(cancelar);
        p[6].add(proximo);
      
        
        p[6].setBackground(white);
        gbc.fill=GridBagConstraints.NONE;
        gbc.gridwidth=0;
        gbc.gridx=0;
        gbc.gridy=7;
        add(p[6],gbc);
    }
    
    
    
}
