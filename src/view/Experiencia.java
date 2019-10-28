package view;

import control.Validacoes;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.text.SimpleDateFormat;
import javax.swing.*;

public class Experiencia extends JFrame {

    private String empresa, anoForm, cargo, areaF, dataIE, dataFE, dataIC, dataFC;
    char tipo, crit;

    JButton b[] = new JButton[4];
    JPanel p[] = new JPanel[8];
    JLabel l[] = new JLabel[10];
    JTextField tf[] = new JTextField[5];
    JRadioButton rb[] = new JRadioButton[6];
    ButtonGroup bg[] = new ButtonGroup[2];
    JSpinner sp[] = new JSpinner[5];
    JComboBox cb[] = new JComboBox[5];
    //Default
    Font titulo_Font, Butoes_Font, label_Font, ComboBox_Font;
    Color blue, white, orange, gray;
    Dimension dimensao_Btn;
    GridBagConstraints gbc = new GridBagConstraints();

    String curso[] = {"Administracao", "Direito", "Economia", "Educacao", "Engenharia", "Gestao", "Psicologia", "Publicidade", "Saude", "Sociologia", "Transportes"};
    String nomeDe[] = {"A", "B", "C"};

    public Experiencia() {
        setTitle("Cadastro || S.G.R.H");
        setLocation(250, 100);
        setSize(900, 700);
        setExtendedState(MAXIMIZED_BOTH);

        //Layout
        setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 5, 10, 5);

        //Incializando Variaveis
        dimensao_Btn = new Dimension(120, 20);
        titulo_Font = new Font("SansSerif", Font.BOLD, 60);
        Butoes_Font = new Font("SansSerif", Font.BOLD, 13);
        label_Font = new Font("SansSerif", Font.BOLD, 15);
        ComboBox_Font = new Font("SansSerif", Font.BOLD, 12);

        blue = new Color(44, 62, 80);
        white = new Color(255, 255, 255);
        gray = new Color(149, 156, 147);
        orange = new Color(245, 139, 31);

        //Image
        JLabel img = new JLabel("", new ImageIcon("src/images/d.jpg"), JLabel.CENTER);

        gbc.gridwidth = 0;
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(img, gbc);

        //Imagem 2
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        JLabel img2 = new JLabel("", new ImageIcon("src/images/h.jpg"), JLabel.LEFT);

        gbc.gridwidth = 0;
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(img2, gbc);

        experiencia();

        //Imagem 3
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        JLabel img3 = new JLabel("", new ImageIcon("src/images/i.jpg"), JLabel.LEFT);

        gbc.gridwidth = 0;
        gbc.gridx = 0;
        gbc.gridy = 5;
        add(img3, gbc);

        contracto();

        //Imagem 4
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        JLabel img4 = new JLabel("", new ImageIcon("src/images/l.jpg"), JLabel.LEFT);

        gbc.gridwidth = 0;
        gbc.gridx = 0;
        gbc.gridy = 7;
        add(img4, gbc);

        Categoria();

        //Butoes
        butoes();

        getContentPane().setBackground(Color.WHITE);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void experiencia() {
        //Todas As Labels
        l[0] = new JLabel("Ano de Formacao:");
        l[1] = new JLabel("Área de Formação:");
        l[2] = new JLabel("Nome da Empresa:");
        l[3] = new JLabel("Cargo:");
        l[4] = new JLabel("Data Inicio:");
        l[5] = new JLabel("Data Fim:");
        l[6] = new JLabel("Tipo: ");
        l[7] = new JLabel("Data Inicio:");
        l[8] = new JLabel("                               Data Fim:");
        //Label Propriedade
        for (int i = 0; i <= 8; i++) {
            l[i].setFont(label_Font);
            l[i].setForeground(blue);
            l[i].setBackground(white);
        }

        //Linha 1
        p[1] = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 5));
        tf[0] = new JTextField("Nome da Empresa", 20);
        //Nome da Empresa Placeholder
        tf[0].addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if(tf[0].getText().equalsIgnoreCase("Nome da Empresa")){
                    tf[0].setText("");
                    tf[0].setForeground(Color.BLACK);
                }
            }
            @Override
            public void focusLost(FocusEvent e) {
                if(tf[0].getText().equals("")){
                    tf[0].setText("Nome da Empresa");
                    tf[0].setForeground(Color.GRAY);
                }
            }
        });
        p[1].add(l[2]);
        p[1].add(tf[0]);

        p[1].add(l[0]);

        sp[0] = new JSpinner(new SpinnerDateModel());
        SimpleDateFormat model = new SimpleDateFormat("dd/MM/yyyy");
        sp[0].setEditor(new JSpinner.DateEditor(sp[0], model.toPattern()));
        //sp[0].setPreferredSize(new Dimension());
        p[1].add(sp[0]);

        p[1].setBackground(white);
        gbc.gridx = 0;
        gbc.gridy = 2;
        add(p[1], gbc);

        //Linha 2
        p[2] = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 5));
        tf[1] = new JTextField("Cargo", 20);
        tf[1].setForeground(Color.GRAY);
        //Cargo Placeholder
        tf[1].addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if(tf[1].getText().equalsIgnoreCase("Cargo")){
                    tf[1].setText("");
                    tf[1].setForeground(Color.BLACK);
                }
            }
            @Override
            public void focusLost(FocusEvent e) {
                if(tf[1].getText().equals("")){
                    tf[1].setText("Cargo");
                    tf[1].setForeground(Color.GRAY);
                }
            }
        });
        p[2].add(l[3]);
        p[2].add(tf[1]);

        p[2].add(l[1]);
        cb[0] = new JComboBox(curso);
        cb[0].setFont(ComboBox_Font);
        cb[0].setForeground(blue);
        cb[0].setBackground(white);
        cb[0].setPreferredSize(new Dimension(180, 20));
        p[2].add(cb[0]);

        p[2].setBackground(white);
        gbc.gridx = 0;
        gbc.gridy = 3;
        add(p[2], gbc);

        //linha 3
        p[3] = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 5));
        p[3].add(l[7]);
        model = new SimpleDateFormat("dd/MM/yyyy");
        sp[1] = new JSpinner(new SpinnerDateModel());
        sp[1].setEditor(new JSpinner.DateEditor(sp[1], model.toPattern()));
        //sp[1].setPreferredSize(new Dimension());
        p[3].add(sp[1]);

        p[3].add(l[8]);
        sp[2] = new JSpinner(new SpinnerDateModel());
        sp[2].setEditor(new JSpinner.DateEditor(sp[2], model.toPattern()));
        //sp[2].setPreferredSize(new Dimension());
        p[3].add(sp[2]);

        p[3].setBackground(white);
        gbc.gridx = 0;
        gbc.gridy = 4;
        add(p[3], gbc);

    }

    public void contracto() {
        //linha 4
        p[4] = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 5));
        p[4].add(l[4]);
        SimpleDateFormat model = new SimpleDateFormat("dd/MM/yyyy");
        sp[3] = new JSpinner(new SpinnerDateModel());
        sp[3].setEditor(new JSpinner.DateEditor(sp[3], model.toPattern()));
        //sp[1].setPreferredSize(new Dimension());
        p[4].add(sp[3]);

        p[4].add(l[5]);
        sp[4] = new JSpinner(new SpinnerDateModel());
        sp[4].setEditor(new JSpinner.DateEditor(sp[4], model.toPattern()));
        //sp[2].setPreferredSize(new Dimension());
        p[4].add(sp[4]);

        rb[0] = new JRadioButton("A");
        rb[1] = new JRadioButton("B");
        rb[2] = new JRadioButton("C");
        rb[3] = new JRadioButton("D");
        bg[0] = new ButtonGroup();
        p[4].add(l[6]);

        for (int i = 0; i <= 3; i++) {
            rb[i].setBackground(white);
            rb[i].setFont(label_Font);
            rb[i].setForeground(blue);
            bg[0].add(rb[i]);
            p[4].add(rb[i]);
        }
        rb[0].setSelected(true);

        p[4].setBackground(white);
        gbc.gridx = 0;
        gbc.gridy = 6;
        add(p[4], gbc);

    }

    private void butoes() {
        //Butoes
        p[5] = new JPanel(new FlowLayout(FlowLayout.CENTER, 50, 25));
        JButton anterior = new JButton("Anterior");
        anterior.setBackground(orange);
        anterior.setPreferredSize(new Dimension(120, 32));
        anterior.setFont(new Font("Sans Serif", Font.BOLD, 14));
        anterior.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                setVisible(false);
                PlanoDeSaude pn = new PlanoDeSaude();
            }
        });

        JButton proximo = new JButton("Proximo");
        proximo.setBackground(blue);
        proximo.setForeground(white);
        proximo.setPreferredSize(new Dimension(120, 32));
        proximo.setFont(new Font("Sans Serif", Font.BOLD, 14));
        proximo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                cadastro3();
            }
        });
        p[5].add(anterior);
        p[5].add(proximo);

        p[5].setBackground(white);
        gbc.fill = GridBagConstraints.NONE;
        gbc.gridwidth = 0;
        gbc.gridx = 0;
        gbc.gridy = 9;
        add(p[5], gbc);
    }

    private void Categoria() {
        //linha 5
        p[6] = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 5));

        rb[4] = new JRadioButton("Administrador");
        rb[5] = new JRadioButton("Professor");
        rb[5].setSelected(true);
        bg[1] = new ButtonGroup();
        for (int i = 4; i <= 5; i++) {
            rb[i].setBackground(white);
            rb[i].setFont(label_Font);
            rb[i].setForeground(blue);
            bg[1].add(rb[i]);
            p[6].add(rb[i]);
        }

        p[6].setBackground(white);
        gbc.fill = GridBagConstraints.NONE;
        gbc.gridwidth = 0;
        gbc.gridx = 0;
        gbc.gridy = 8;
        add(p[6], gbc);
    }

    public void cadastro3() {
        Boolean isEmpty=false;
        //Check if is Empty
        if(tf[0].getText().equalsIgnoreCase("Nome da Empresa")){isEmpty=true;}//Nome da Empresa
        if(tf[1].getText().equalsIgnoreCase("Cargo")){isEmpty=true;}//Cargo
        if(isEmpty){
            JOptionPane.showMessageDialog(null, "Por favor! Preencha todos campos de dado.", "Erro!", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        //Validacoes
        Validacoes v = new Validacoes();
        if(!v.validarSemNr(tf[0].getText(), 3, 40, "Nome da Empresa")){return;} else{empresa=tf[0].getText();}//Nome da Empresa
        //Ano de Formacao
        anoForm = new SimpleDateFormat("dd/MM/yyyy").format(sp[0].getValue());
        if(!v.validarData(anoForm, 2019, 2050, "Ano de Formacao")){return;}
        if(!v.validarSemNr(tf[1].getText(), 3, 40, "Cargo")){return;} else{cargo=tf[1].getText();}//Cargo
        areaF = cb[0].getSelectedItem().toString();//Area de Formacao
        //Data Inicio Experiencia
        dataIE = new SimpleDateFormat("dd/MM/yyyy").format(sp[0].getValue());
        if(!v.validarData(dataIE, 2000, 2019, "Data Inicio de Experiencia")){return;}
        //Data Fim Experiencia
        dataFE = new SimpleDateFormat("dd/MM/yyyy").format(sp[1].getValue());
        if(!v.validarData(dataFE, 2019, 2050, "Data Fim de Experiencia")){return;}
        //Data Inicio
        dataIC = new SimpleDateFormat("dd/MM/yyyy").format(sp[0].getValue());
        if(!v.validarData(dataIC, 2000, 2019, "Data Inicio do Contracto")){return;}
        //Data Fim
        dataFC = new SimpleDateFormat("dd/MM/yyyy").format(sp[1].getValue());
        if(!v.validarData(dataFC, 2019, 2050, "Data Fim do Contracto")){return;}
        //Tipo
        if (rb[0].isSelected()) {tipo = 'A';}
        else if (rb[1].isSelected()) {tipo = 'B';}
        else if (rb[2].isSelected()) {tipo = 'C';}
        else if (rb[3].isSelected()) {tipo = 'D';}
        //Funcao
        if (rb[4].isSelected()) {crit = 'A';}
        else if (rb[5].isSelected()) {crit = 'P';}
        
        setVisible(false);
        Admin a = new Admin();
    }
}