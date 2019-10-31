package view;

import java.sql.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import DAO.ModuloConexao.*;

public class Logn extends JFrame {

    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    JPanel p[] = new JPanel[5];
    GridBagConstraints gbc;
    Font label_Font;
    JTextField tf[] = new JTextField[4];
    JPasswordField ps;
    JLabel l[] = new JLabel[4];
    Color white, blue, gray, orange;

    Dimension d1;

    public Logn() {
        setTitle("LOGN IN PAGE");
        setLocation(250, 100);
        setSize(900, 700);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setExtendedState(MAXIMIZED_BOTH);

        //Inicializando Variaveis
        label_Font = new Font("Sans Serif", Font.BOLD, 14);
        d1 = new Dimension(380, 30);
        blue = new Color(44, 62, 80);
        white = new Color(247, 247, 247);
        gray = new Color(149, 156, 147);
        orange = new Color(245, 139, 31);
        conexao = DAO.ModuloConexao.conector();

        //Layout Sttings
        setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        //imagem
        JLabel img = new JLabel("", new ImageIcon("src/images/a.jpg"), JLabel.CENTER);
        img.setVerticalAlignment(JLabel.TOP);

        gbc.gridx = 0;
        gbc.gridy = 0;

        add(img, gbc);
        //
        logn();

        getContentPane().setBackground(Color.WHITE);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void logn() {

        l[0] = new JLabel("Usuário:");
        l[0].setFont(label_Font);
        l[0].setForeground(blue);
        tf[0] = new JTextField("Usuário", 26);
        tf[0].setForeground(gray);

        p[1] = new JPanel(new FlowLayout(FlowLayout.LEFT));
        p[1].add(l[0]);
        p[1].add(tf[0]);
        p[1].setBackground(white);
        p[1].setPreferredSize(d1);
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(p[1], gbc);

        l[1] = new JLabel("Senha:   ");
        l[1].setFont(label_Font);
        l[1].setForeground(new Color(44, 62, 80));
        ps = new JPasswordField("", 26);
        ps.setForeground(new Color(149, 156, 147));

        p[2] = new JPanel(new FlowLayout(FlowLayout.LEFT));
        p[2].setPreferredSize(d1);
        p[2].add(l[1]);
        p[2].add(ps);
        p[2].setBackground(white);
        gbc.gridx = 0;
        gbc.gridy = 2;
        add(p[2], gbc);

        p[3] = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton bt = new JButton("Entrar");
        bt.setBackground(orange);
        bt.setPreferredSize(new Dimension(380, 28));
        bt.setFont(new Font("Sans Serif", Font.BOLD, 14));
        bt.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent event) {
                //setVisible(false);
                logar();
            }
        });
        p[3].add(bt);

        p[3].setBackground(Color.WHITE);
        gbc.gridy = 3;
        add(p[3], gbc);

    }

    public void logar() {
        String sql = "select * from administrador where username=? and senha =?";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, tf[0].getText());
            pst.setString(2, ps.getText());
            rs = pst.executeQuery();
            if (rs.next()) {
                MenuPrincipal m = new MenuPrincipal();
                m.setVisible(true);
                this.dispose();
                conexao.close();
            } else {
                JOptionPane.showMessageDialog(null, "usuário e/ou senha inválido(s)","Erro", JOptionPane.ERROR_MESSAGE);
            }
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(this, e);
        }
    }

}
