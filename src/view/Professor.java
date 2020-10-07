package view;

import DAO.ProfessorDAO;
import VO.ProfessorVO;
import java.awt.*;
import static java.awt.Frame.MAXIMIZED_BOTH;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.sql.Connection;
import java.sql.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class Professor extends JFrame {
    private String disciplina;
    private int totalTurma;
    private ProfessorVO pr;
    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    JLabel l[] = new JLabel[5];
    JComboBox cb[] = new JComboBox[5];
    JPanel p[] = new JPanel[8];
    JTextField tf[]=new JTextField[5];
    JSpinner sp[]=new JSpinner[5];

    String cargoDe[] = {"Matemática", "Português", "Historia","Química","Geografia", "Empreendedorismo", "Física", "Química", "Biologia"};

    //Default
    Font Butoes_Font, label_Font, ComboBox_Font;
    Color blue, white, orange, gray;
    GridBagConstraints gbc = new GridBagConstraints();

    public Professor() {
        setTitle("Cadastro || S.G.R.H");
        setLocation(250, 100);
        setSize(900, 700);
        setExtendedState(MAXIMIZED_BOTH);

        //Layout
        setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 5, 10, 5);

        //Incializando Variaveis
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
        JLabel img2 = new JLabel("", new ImageIcon("src/images/o.png"), JLabel.LEFT);

        gbc.gridwidth = 0;
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(img2, gbc);

        prof();

        butoes();

        getContentPane().setBackground(Color.WHITE);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void prof() {
        l[1] = new JLabel("Disciplina");
        l[2] = new JLabel("Nr de Turmas: ");
        //Label Propriedade
        for (int i = 1; i <= 2; i++) {
            l[i].setFont(label_Font);
            l[i].setForeground(blue);
            l[i].setBackground(white);
        }

        //Linha 1
        p[1] = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 5));
        p[1].add(l[1]);

        cb[1] = new JComboBox(cargoDe);
        cb[1].setFont(ComboBox_Font);
        cb[1].setForeground(blue);
        cb[1].setBackground(white);
        cb[1].setPreferredSize(new Dimension(180, 20));
        p[1].add(cb[1]);

        p[1].setBackground(white);
        gbc.gridx = 0;
        gbc.gridy = 2;
        add(p[1], gbc);
        
        
        //Linha #2        
        p[2] = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 5));
        
        p[2].add(l[2]);
        sp[2] = new JSpinner();
        sp[2].setPreferredSize(new Dimension(50,20));
        p[2].add(sp[2]);
        
        p[2].setBackground(white);
        gbc.gridx = 0;
        gbc.gridy = 4;
        add(p[2], gbc);
    }

    private void butoes() {
        //Butoes
        p[6] = new JPanel(new FlowLayout(FlowLayout.CENTER, 50, 25));
        JButton anterior = new JButton("Anterior");
        anterior.setBackground(orange);
        anterior.setPreferredSize(new Dimension(120, 32));
        anterior.setFont(new Font("Sans Serif", Font.BOLD, 14));
        anterior.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                setVisible(false);
                Experiencia ex = new Experiencia();
            }
        });

        JButton proximo = new JButton("Finalizar");
        proximo.setBackground(blue);
        proximo.setForeground(white);
        proximo.setPreferredSize(new Dimension(120, 32));
        proximo.setFont(new Font("Sans Serif", Font.BOLD, 14));
        proximo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                cadastro4();
            }
        });
        p[6].add(anterior);
        p[6].add(proximo);

        p[6].setBackground(white);
        gbc.fill = GridBagConstraints.NONE;
        gbc.gridwidth = 0;
        gbc.gridx = 0;
        gbc.gridy = 6;
        add(p[6], gbc);
    }
    public void cadastro4(){
        disciplina = cb[1].getSelectedItem().toString();
        totalTurma = Integer.parseInt(sp[2].getValue().toString());
        
        pr = new ProfessorVO(disciplina, totalTurma);
        ProfessorDAO daopr = new ProfessorDAO();
        daopr.inserir(pr);
        setVisible(false);
        MenuPrincipal mn = new MenuPrincipal();
        JOptionPane.showMessageDialog(null, " Cadastrado Com Sucesso! ");
    }
}