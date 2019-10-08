
package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Pagamento extends JFrame {

    JLabel l[]= new JLabel[8];
    JComboBox cb[]=new JComboBox[8];
    JPanel p[]= new JPanel[8];
    JSpinner sp[]=new JSpinner[5];
    JTextField tf[]=new JTextField[5];
    
    JButton processar,proximo;
     //Default
    Font Butoes_Font,label_Font,ComboBox_Font;
    Color blue,white,orange,gray;
    GridBagConstraints gbc= new GridBagConstraints();
    public Pagamento() {
        
        setTitle("Pagamento de Salario || S.G.R.H");
        setLocation(250,100);
        setSize(900,700);
        setExtendedState(MAXIMIZED_BOTH);
        
        //Layout
        setLayout(new GridBagLayout());
        gbc=new GridBagConstraints() ;
        gbc.insets= new Insets(10,5,10,5);
        
         //Incializando Variaveis
        Butoes_Font=new Font("SansSerif",Font.BOLD,13);
        label_Font=new Font("SansSerif",Font.BOLD,15);
        ComboBox_Font=new Font("SansSerif",Font.BOLD,12);
        blue=new Color(44,62,80);
        white =new Color(255,255,255);
        gray=new Color(149,156,147);
        orange=new Color(245,139,31); 
        
         //Image
        JLabel img=new JLabel("",new ImageIcon("src/images/d-2.jpg"),JLabel.CENTER);
        gbc.fill=GridBagConstraints.HORIZONTAL;
        gbc.gridwidth=2;
        gbc.gridx=0;
        gbc.gridy=0;
        add(img,gbc);
        
        //Imagem 2
        gbc.gridwidth=2;
        gbc.fill=GridBagConstraints.HORIZONTAL;
        JLabel img2=new JLabel("",new ImageIcon("src/images/n.jpg"),JLabel.LEFT);
        
        gbc.gridwidth=0;
        gbc.gridx=0;
        gbc.gridy=1;
        add(img2,gbc);
        pagamento();
        
        butoes();
        
        getContentPane().setBackground(Color.WHITE);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true); 
    }

    private void pagamento() {
        l[0] = new JLabel("Numero de BI     ");
        l[1] = new JLabel("Horas Extras       ");
        l[2] = new JLabel("Numero deFaltas ");
        l[3] = new JLabel("Bonificacão        ");
        l[4] = new JLabel("Desconto            ");
        l[5] = new JLabel("Nome Completo   ");
          //Label Propriedade
        for(int i=0;i<=5;i++){
         l[i].setFont(label_Font);
         l[i].setForeground(blue);
         l[i].setBackground(white);
        }
        
        for(int i=0;i<=4;i++){
            sp[i] = new JSpinner();
            sp[i].setPreferredSize(new Dimension(180,18));
            }
        //Linha 1
        p[1]=new JPanel(new FlowLayout(FlowLayout.LEFT,10,5));

        tf[0]=new JTextField("Número de BI",16);
        p[1].add(l[0]);
        p[1].add(tf[0]);
        
        p[1].setBackground(white);
        gbc.gridx=0;
        gbc.gridy=2;
        add(p[1],gbc);
    
        //Outras Linhas
        int j=1;
       
        for(int i=1;i<=4;i++){
        p[i+1]=new JPanel(new FlowLayout(FlowLayout.LEFT,10,5));
        p[i+1].add(l[i]);  
        p[i+1].add(sp[i]);
 
        p[i+1].setBackground(white);
        gbc.gridx=0;
        gbc.gridy++;
        add(p[i+1],gbc);}
    }
   
    private void butoes() {
        //Butoes
        p[6]=new JPanel(new FlowLayout(FlowLayout.LEFT,50,5));
        proximo=new JButton("Proximo");
        proximo.setBackground(orange);
        proximo.setPreferredSize(new Dimension(300,32));
        proximo.setFont(new Font("Sans Serif",Font.BOLD,14));
        proximo.addActionListener(new ActionListener(){ 
            public void actionPerformed(ActionEvent event){
               setVisible(false);
               Pagamento pg= new Pagamento();
                }
            });
  
        p[6].add(proximo);
        
        p[6].setBackground(white);
        gbc.fill=GridBagConstraints.NONE;
        gbc.gridwidth=3;
        gbc.gridx=0;
        gbc.gridy=7;
        add(p[6],gbc);
        
        p[7]=new JPanel(new FlowLayout(FlowLayout.LEFT,10,0));
        processar=new JButton("Processar");
        processar.setBackground(blue);
        processar.setForeground(white);
        processar.setPreferredSize(new Dimension(300,32));
        processar.setFont(new Font("Sans Serif",Font.BOLD,14));
        processar.addActionListener(new ActionListener(){ 
            public void actionPerformed(ActionEvent event){
                JOptionPane.showMessageDialog(null, "Foram Porcessados n Salarios");
                setVisible(false);
                MenuPrincipal mn=new MenuPrincipal();
                }
            });
  
        p[7].add(processar);
        
        p[7].setBackground(white);
        gbc.gridx=0;
        gbc.gridy=8;
        add(p[7],gbc);
    }
    
}
