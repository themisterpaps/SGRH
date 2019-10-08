
package view;

import java.awt.*;
import static java.awt.Frame.MAXIMIZED_BOTH;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import javax.swing.*;
public class PlanoDeSaude extends JFrame{
    JButton b[]=new JButton[5];
    JPanel p[]= new JPanel[8];
    JLabel l[]=new JLabel[10];
    JRadioButton rb[]=new JRadioButton[5];
    ButtonGroup bg[]=new ButtonGroup[5];
    JSpinner sp[]=new JSpinner[5];
    JComboBox cb[]=new JComboBox[5];
    
    //Default
    Font titulo_Font,Butoes_Font,label_Font,ComboBox_Font;
    Color blue,white,orange,gray;
    Dimension dimensao_Btn;
    GridBagConstraints gbc= new GridBagConstraints();

    String cargos[]={"Chefe","Gerente","Faxineiro"};
    String curso[]={"Engenharia Informatica","Engenharia Civil","Portugues"};
    String nivel[]={"Medio","Superior","Mestrado"};

    public PlanoDeSaude() {
        setTitle("Cadastro || S.G.R.H");
        setLocation(250,100);
        setSize(900,700);
        setExtendedState(MAXIMIZED_BOTH);
        
        //Layout
        setLayout(new GridBagLayout());
        gbc=new GridBagConstraints() ;
        gbc.insets= new Insets(10,5,10,5);
        
          //Incializando Variaveis
        dimensao_Btn=new Dimension(120,20);
        titulo_Font= new Font("SansSerif",Font.BOLD,60);
        Butoes_Font=new Font("SansSerif",Font.BOLD,13);
        label_Font=new Font("SansSerif",Font.BOLD,15);
        ComboBox_Font=new Font("SansSerif",Font.BOLD,12);
        
        blue=new Color(44,62,80);
        white =new Color(255,255,255);
        gray=new Color(149,156,147);
        orange=new Color(245,139,31);
       
         //Image
        JLabel img=new JLabel("",new ImageIcon("src/images/d.jpg"),JLabel.CENTER);

        
        gbc.gridwidth=0;
        gbc.gridx=0;
        gbc.gridy=0;
        add(img,gbc);
        
        //Image 2
        gbc.gridwidth=2;
        gbc.fill=GridBagConstraints.HORIZONTAL;
        JLabel img2=new JLabel("",new ImageIcon("src/images/f.jpg"),JLabel.LEFT);
        
        gbc.gridwidth=0;
        gbc.gridx=0;
        gbc.gridy=1;
        add(img2,gbc);
        
        planoDeSaude();
        
         //Image 3
        gbc.gridwidth=2;
        gbc.fill=GridBagConstraints.HORIZONTAL;
        JLabel img3=new JLabel("",new ImageIcon("src/images/g.jpg"),JLabel.LEFT);

        
        gbc.gridwidth=0;
        gbc.gridx=0;
        gbc.gridy=3;
        add(img3,gbc);
        
        formacao();
        
        butoes();
        getContentPane().setBackground(Color.WHITE);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void planoDeSaude() {
         //Todas As Labels
        l[0] = new JLabel("Data Inicio: ");
        l[1] = new JLabel("Data Fim: ");
        l[2] = new JLabel("Agregado Familiar: "); 
        l[3] = new JLabel("Curso:");
        l[4] = new JLabel("          Nivel Academico:"); 
        l[5] = new JLabel("Ano Inicio:");
        l[6] = new JLabel("                   Ano Fim/Previsao:");
        //Label Propriedade
        for(int i=0;i<=6;i++){
         l[i].setFont(label_Font);
         l[i].setForeground(blue);
         l[i].setBackground(white);
        }
        
        //Linha 1
        p[1]=new JPanel(new FlowLayout(FlowLayout.LEFT,10,5));
        
        p[1].add(l[0]);
        sp[0] = new JSpinner(new SpinnerDateModel());
        SimpleDateFormat model = new SimpleDateFormat("dd/MM/yyyy");
        sp[0].setEditor(new JSpinner.DateEditor(sp[0], model.toPattern()));
        sp[0].setPreferredSize(dimensao_Btn);
        sp[0].setBackground(white);
        sp[0].setForeground(blue);
        p[1].add(sp[0]);
        
        p[1].add(l[1]);
        sp[1] = new JSpinner(new SpinnerDateModel());
        sp[1].setEditor(new JSpinner.DateEditor(sp[1], model.toPattern()));
        sp[1].setPreferredSize(dimensao_Btn);
        sp[1].setBackground(white);
        sp[1].setForeground(blue);
        p[1].add(sp[1]);
        
        p[1].add(l[2]);
        sp[1] = new JSpinner();
        sp[1].setPreferredSize(new Dimension(50,20));
        p[1].add(sp[1]);
        
        p[1].setBackground(white);
        gbc.gridx=0;
        gbc.gridy=2;
        add(p[1],gbc);       
        
    }

    private void formacao() {
         //Linha 3
        p[3]=new JPanel(new FlowLayout(FlowLayout.LEFT,10,5));
        p[3].add(l[3]);
        cb[0] = new JComboBox(curso);
        cb[0].setFont(ComboBox_Font);
        cb[0].setForeground(blue);
        cb[0].setBackground(white);
        cb[0].setPreferredSize(new Dimension(180,20));
        p[3].add(cb[0]);

        p[3].add(l[4]);
        cb[1] = new JComboBox(nivel);
        cb[1].setFont(ComboBox_Font);
        cb[1].setForeground(blue);
        cb[1].setBackground(white);
        cb[1].setPreferredSize(new Dimension(180,20));
        p[3].add(cb[1]);
        
        p[3].setBackground(white);
        gbc.gridx=0;
        gbc.gridy=4;
        add(p[3],gbc);
        //Linha 4
        p[4]=new JPanel(new FlowLayout(FlowLayout.LEFT,10,5));

        
        p[4].add(l[5]);
        sp[3] = new JSpinner(new SpinnerDateModel());
        SimpleDateFormat model = new SimpleDateFormat("dd/MM/yyyy");
        sp[3].setEditor(new JSpinner.DateEditor(sp[3], model.toPattern()));
        sp[3].setPreferredSize(dimensao_Btn);
        sp[3].setBackground(white);
        sp[3].setForeground(blue);
        p[4].add(sp[3]);
        
        p[4].add(l[6]);
        sp[4] = new JSpinner(new SpinnerDateModel());
        sp[4].setEditor(new JSpinner.DateEditor(sp[4], model.toPattern()));
        sp[4].setPreferredSize(dimensao_Btn);
        sp[4].setBackground(white);
        sp[4].setForeground(blue);
        p[4].add(sp[4]);
        
        p[4].setBackground(white);
        gbc.gridx=0;
        gbc.gridy=5;
        add(p[4],gbc);
    }

    private void butoes() {
        //Butoes
        p[5]=new JPanel(new FlowLayout(FlowLayout.CENTER,50,25));
        JButton anterior=new JButton("Anterior");
        anterior.setBackground(orange);
        anterior.setPreferredSize(new Dimension(120,32));
        anterior.setFont(new Font("Sans Serif",Font.BOLD,14));
        anterior.addActionListener(new ActionListener(){ 
            public void actionPerformed(ActionEvent event){
                setVisible(false);
               DadosPessoais dv=new DadosPessoais();
                }
            });
        

        JButton proximo=new JButton("Proximo");
        proximo.setBackground(blue);
        proximo.setForeground(white);
        proximo.setPreferredSize(new Dimension(120,32));
        proximo.setFont(new Font("Sans Serif",Font.BOLD,14));
        proximo.addActionListener(new ActionListener(){ 
            public void actionPerformed(ActionEvent event){
                    Experiencia ex=new Experiencia();
                }
            }); 
        p[5].add(anterior);
        p[5].add(proximo);
      
        
        p[5].setBackground(white);
        gbc.fill=GridBagConstraints.NONE;
        gbc.gridwidth=0;
        gbc.gridx=0;
        gbc.gridy=6;
        add(p[5],gbc);
    }
    
    
}
