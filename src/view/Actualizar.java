package view;
import DAO.DadosPessoaisDAO;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import javax.swing.*;
import control.Validacoes;
import VO.DadosPessoaisVO;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Actualizar extends JFrame {
    private String nome, apelido,nacionalidade, bi, estCivil, data, sexo;
    private int nib, nuit;
    private  DadosPessoaisVO dp;
    JButton b[] = new JButton[4];
    
    JPanel p[] = new JPanel[8];
    JLabel l[] = new JLabel[10];
    JTextField tf[] = new JTextField[10];
    JRadioButton rb[] = new JRadioButton[10];
    ButtonGroup bg[] = new ButtonGroup[2];
    JSpinner sp[] = new JSpinner[5];
    JComboBox cb[] = new JComboBox[5];
    //Default
    Font titulo_Font, Butoes_Font, label_Font, ComboBox_Font;
    Color blue, white, orange, gray;
    Dimension dimensao_Btn;
    GridBagConstraints gbc = new GridBagConstraints();

    public Actualizar() {
        setTitle("Actualizar || S.G.R.H");
        setLocation(250, 100);
        setSize(900, 700);
        setExtendedState(MAXIMIZED_BOTH);

        //Layout
        setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 5, 10, 5);

        //Incializando Variaveis
        dimensao_Btn = new Dimension(180, 60);
        titulo_Font = new Font("SansSerif", Font.BOLD, 60);
        Butoes_Font = new Font("SansSerif", Font.BOLD, 13);
        label_Font = new Font("SansSerif", Font.BOLD, 14);
        ComboBox_Font = new Font("SansSerif", Font.BOLD, 12);

        blue = new Color(44, 62, 80);
        white = new Color(255, 255, 255);
        gray = new Color(149, 156, 147);
        orange = new Color(245, 139, 31);

        //Imagem 
        JLabel img = new JLabel("", new ImageIcon("src/images/d.jpg"), JLabel.CENTER);

        gbc.gridwidth = 0;
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(img, gbc);

        //Imagem 2
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        JLabel img2 = new JLabel("", new ImageIcon("src/images/e.jpg"), JLabel.LEFT);

        gbc.gridwidth = 0;
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(img2, gbc);

        dadosPessoais();

        getContentPane().setBackground(Color.WHITE);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
    
    private void dadosPessoais() {
        //Todas As Labels
        l[0] = new JLabel("Nome: ");
        l[1] = new JLabel("Apelido: ");
        l[2] = new JLabel("Bilhete de Identidade: ");
        l[3] = new JLabel("Sexo");
        l[4] = new JLabel("Data de Nascimento:");
        l[5] = new JLabel("NIB");
        l[6] = new JLabel("Nacionalidade:");
        l[7] = new JLabel("NUIT");
        l[8] = new JLabel("Estado Civil");
        l[9] = new JLabel("ID:");
        //Label Propriedade
        for (int i = 0; i <= 9; i++) {
            l[i].setFont(label_Font);
            l[i].setForeground(blue);
            l[i].setBackground(white);
        }

        // Linha 1
        tf[0] = new JTextField("Nome", 16);
        tf[9] = new JTextField("ID", 16);
        //Nome Placeholder
        tf[0].addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if(tf[0].getText().equalsIgnoreCase("Nome")){
                    tf[0].setText("");
                    tf[0].setForeground(Color.BLACK);
                }
            }
            @Override
            public void focusLost(FocusEvent e) {
                if(tf[0].getText().equals("")){
                    tf[0].setText("Nome");
                    tf[0].setForeground(Color.GRAY);
                }
            }
        });
        
             //Nome Placeholder ID
        tf[0].addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if(tf[0].getText().equalsIgnoreCase("ID")){
                    tf[0].setText("");
                    tf[0].setForeground(Color.BLACK);
                }
            }
            @Override
            public void focusLost(FocusEvent e) {
                if(tf[0].getText().equals("")){
                    tf[0].setText("ID");
                    tf[0].setForeground(Color.GRAY);
                }
            }
        });
        
        tf[1] = new JTextField("Apelido", 16);
        tf[1].setForeground(Color.GRAY);
        //Apelido Placeholder
        tf[1].addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if(tf[1].getText().equalsIgnoreCase("Apelido")){
                    tf[1].setText("");
                    tf[1].setForeground(Color.BLACK);
                }
            }
            @Override
            public void focusLost(FocusEvent e) {
                if(tf[1].getText().equals("")){
                    tf[1].setText("Apelido");
                    tf[1].setForeground(Color.GRAY);
                }
            }
        });
        p[1] = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 5));

        for (int i = 0; i < 2; i++) {
            tf[i].setForeground(gray);
            p[1].add(l[i]);
            p[1].add(tf[i]);
        }
        tf[9].setForeground(gray);
        p[1].add(l[9]);
        p[1].add(tf[9]);

        p[1].setBackground(white);
        gbc.gridx = 0;
        gbc.gridy = 2;
        add(p[1], gbc);

        // Linha 2
        p[2] = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 5));
        tf[2] = new JTextField("Número de Bilhete de Identidade", 20);
        tf[2].setForeground(Color.GRAY);
        //BI Placeholder
        tf[2].addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if(tf[2].getText().equalsIgnoreCase("Número de Bilhete de Identidade")){
                    tf[2].setText("");
                    tf[2].setForeground(Color.BLACK);
                }
            }
            @Override
            public void focusLost(FocusEvent e) {
                if(tf[2].getText().equals("")){
                    tf[2].setText("Número de Bilhete de Identidade");
                    tf[2].setForeground(Color.GRAY);
                }
            }
        });

        p[2].add(l[2]);
        p[2].add(tf[2]);

        l[3].setFont(label_Font);
        l[3].setForeground(blue);

        p[2].add(l[3]);

        rb[0] = new JRadioButton("M");
        rb[1] = new JRadioButton("F");
        rb[1].setSelected(true);

        bg[0] = new ButtonGroup();
        for (int i = 0; i < 2; i++) {
            rb[i].setFont(label_Font);
            rb[i].setBackground(white);
            rb[i].setForeground(blue);

            bg[0].add(rb[i]);
            p[2].add(rb[i]);

        }

        l[4].setFont(label_Font);
        l[4].setForeground(blue);

        p[2].setBackground(white);

        gbc.gridx = 0;
        gbc.gridy = 3;
        add(p[2], gbc);

        //Linha 3
        p[3] = new JPanel(new FlowLayout(FlowLayout.LEFT, 16, 5));

        sp[0] = new JSpinner(new SpinnerDateModel());
        SimpleDateFormat model = new SimpleDateFormat("dd/MM/yyyy");
        sp[0].setEditor(new JSpinner.DateEditor(sp[0], model.toPattern()));
        sp[0].setFont(label_Font);
        sp[0].setForeground(blue);

        p[3].add(l[4]);
        p[3].add(sp[0]);

        tf[3] = new JTextField("NIB", 20);
        tf[3].setForeground(Color.GRAY);
        //NIB Placeholder
        tf[3].addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if(tf[3].getText().equalsIgnoreCase("NIB")){
                    tf[3].setText("");
                    tf[3].setForeground(Color.BLACK);
                }
            }
            @Override
            public void focusLost(FocusEvent e) {
                if(tf[3].getText().equals("")){
                    tf[3].setText("NIB");
                    tf[3].setForeground(Color.GRAY);
                }
            }
        });

        p[3].add(l[5]);
        p[3].add(tf[3]);

        p[3].setBackground(white);
        gbc.gridx = 0;
        gbc.gridy = 4;
        add(p[3], gbc);

        //Linha 4
        p[4] = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 5));
        String nacionalidades[] = {"Seleccione uma opção", "Alemão", "Angolano",
            "Brasileiro", "Chinês", "Cubano", "Dinamarquês", "Espanhol", "Francês", "Grego",
            "Holandês", "Indiano", "Inglês", "Japonês", "Mexicano", "Moçambicano", "Português",
            "Russo", "Sul-Africano"};
        cb[0] = new JComboBox(nacionalidades);
        cb[0].setFont(ComboBox_Font);
        cb[0].setForeground(blue);
        cb[0].setBackground(white);

        p[4].add(l[6]);
        p[4].add(cb[0]);

        tf[4] = new JTextField("NUIT", 20);
        tf[4].setForeground(Color.GRAY);
        //NUIT Placeholder
        tf[4].addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if(tf[4].getText().equalsIgnoreCase("NUIT")){
                    tf[4].setText("");
                    tf[4].setForeground(Color.BLACK);
                }
            }
            @Override
            public void focusLost(FocusEvent e) {
                if(tf[4].getText().equals("")){
                    tf[4].setText("NUIT");
                    tf[4].setForeground(Color.GRAY);
                }
            }
        });
        p[4].add(l[7]);
        p[4].add(tf[4]);

        p[4].setBackground(white);
        gbc.gridx = 0;
        gbc.gridy = 5;
        add(p[4], gbc);

        //linha 5
        p[5] = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 5));
        p[5].add(l[8]);
        rb[3] = new JRadioButton("Solteiro");
        rb[3].setSelected(true);
        rb[4] = new JRadioButton("Casado");
        //rb[5] = new JRadioButton("Outros");
        for (int i = 3; i <= 4; i++) {
            rb[i].setFont(label_Font);
            rb[i].setForeground(blue);
            rb[i].setBackground(white);
            p[5].add(rb[i]);
        }
        bg[1] = new ButtonGroup();
        gbc.fill = GridBagConstraints.VERTICAL;
        p[5].setBackground(white);
        gbc.gridx = 0;
        gbc.gridy = 6;
        add(p[5], gbc);

        //Butoes
        p[6] = new JPanel(new FlowLayout(FlowLayout.CENTER, 50, 25));
        JButton cancelar = new JButton("Cancelar");
        cancelar.setBackground(orange);
        cancelar.setPreferredSize(new Dimension(120, 32));
        cancelar.setFont(new Font("Sans Serif", Font.BOLD, 14));
        cancelar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                setVisible(false);
                MenuPrincipal m = new MenuPrincipal();
            }
        });

        JButton proximo = new JButton("Proximo");
        proximo.setBackground(blue);
        proximo.setForeground(white);
        proximo.setPreferredSize(new Dimension(120, 32));
        proximo.setFont(new Font("Sans Serif", Font.BOLD, 14));
        proximo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                cadastro();
            }
        });
        p[6].add(cancelar);
        p[6].add(proximo);

        p[6].setBackground(white);
        gbc.fill = GridBagConstraints.NONE;
        gbc.gridwidth = 0;
        gbc.gridx = 0;
        gbc.gridy = 7;
        add(p[6], gbc);
    }
    public void cadastro() {
        try {
            Boolean isEmpty=false;
            
            //Check if is Empty
            if(tf[0].getText().equalsIgnoreCase("Nome")){isEmpty=true;}//username
            if(tf[1].getText().equalsIgnoreCase("Apelido")){isEmpty=true;}//apelido
            if(tf[2].getText().equalsIgnoreCase("Número de Bilhete de Identidade")){isEmpty=true;}//BI
            if(tf[3].getText().equalsIgnoreCase("NIB")){isEmpty=true;}//NIB
            if(cb[0].getSelectedItem().equals("Seleccione uma opção")){isEmpty=true;}//Nacionalidade
            if(tf[4].getText().equalsIgnoreCase("NUIT")){isEmpty=true;}//NUIT
            if(isEmpty){
                JOptionPane.showMessageDialog(null, "Por favor! Preencha todos campos de dado.", "Erro!", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            //Validacoes
            Validacoes v = new Validacoes();
            if(!v.validarNome(tf[0].getText(), 3, 40, "Nome de usuário")){return;} else{nome=tf[0].getText();}//username
            if(!v.validarNome(tf[1].getText(), 3, 40, "Apelido")){return;} else{apelido=tf[1].getText();}//apelido
            if(!v.validarBI(tf[2].getText())){return;} else{bi=tf[2].getText();}//BI
            if(rb[0].isSelected()) sexo = "M"; else if (rb[0].isSelected()) sexo =  "F";//Sexo
            //Data
            data = new SimpleDateFormat("dd/MM/yyyy").format(sp[0].getValue());
            if(!v.validarData(data, 1900, 2001, "Data de nascimento")){return;}
            if(!v.validarIntLength(tf[3].getText(), 5, "NIB")){return;} else{nib=Integer.parseInt(tf[3].getText());}//NIB
            nacionalidade = cb[0].getSelectedItem().toString();//Nacionalidade
            if(!v.validarIntLength(tf[4].getText(), 9, "NUIT")){return;} else{nuit=Integer.parseInt(tf[4].getText());}//NUIT
            if (rb[3].isSelected()) estCivil = "Solteiro"; else if(rb[4].isSelected())estCivil = "Casado";//Estado civil
            
            dp = new DadosPessoaisVO(nome,apelido,nacionalidade,bi,estCivil, data, sexo, nib, nuit);
            DadosPessoaisDAO dao = new DadosPessoaisDAO();
            dao.inserir(dp);
            setVisible(false);
            PlanoDeSaude pn = new PlanoDeSaude();
        } catch (ParseException ex) {
            Logger.getLogger(Actualizar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}