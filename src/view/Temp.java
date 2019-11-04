/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

/**
 *
 * @author Chigumane
 */
public class Temp {
    
}
/*

package view;

import DAO.ClienteDAO;
import VO.Cliente;
import javax.swing.JFrame;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;


public class Cadastrar extends JFrame{
    JLabel l[]=new JLabel[5];
    JTextField tf[]=new JTextField[5];
    JPanel p[]=new JPanel[3];
    JButton btn=new JButton("Inserir");
    JTable table;
    DefaultTableModel model;
    
    public Cadastrar(){ 
      setTitle("Cadastrar");
      setSize(500,400);
      setLocation(200,200);
      setLayout(new BorderLayout());
      p[0]=new JPanel();
      p[0].setLayout(new GridLayout(0,2));
      // line 0
       p[0].add(new JLabel("Matricula: ",JLabel.CENTER));
      tf[0]=new JTextField();p[0].add(tf[0]);
      //line 1
      p[0].add(new JLabel("Nome: ",JLabel.CENTER));
      tf[1]=new JTextField();p[0].add(tf[1]);
      //line 2
      p[0].add(new JLabel("Idade: ",JLabel.CENTER));
      tf[2]=new JTextField(); p[0].add(tf[2]);
        //line 3
      p[0].add(new JLabel("Sexo: ",JLabel.CENTER));
      tf[3]=new JTextField(); p[0].add(tf[3]);
      btn.addActionListener(new ActionListener(){

           @Override
           public void actionPerformed(ActionEvent e) {
               Cliente cl=new Cliente(Integer.parseInt(tf[0].getText()),tf[1].getText(),Integer.parseInt(tf[2].getText()),tf[3].getText());
               try {
                   ClienteDAO dao =new ClienteDAO();
                   dao.inserir(cl);
                   
                   String nome=cl.getNome(),matr=""+cl.getMatricula(),idade=""+cl.getIdade(),sexo=cl.getSexo();
                   String data[]={matr,nome,idade,sexo};
                   model.addRow(data);
               } catch (SQLException | ClassNotFoundException ex) {
                   Logger.getLogger(Cadastrar.class.getName()).log(Level.SEVERE, null, ex);
               }
               JOptionPane.showMessageDialog(rootPane, "Cadastrado com Sucesso");
               for(int i=0;i<=3;i++)
               {tf[i].setText("");}
           }
          
      });
      p[1]=new JPanel();
      // JTable
      
    model = new DefaultTableModel();
    model.addColumn("Matricula");
    model.addColumn("Nome");
    model.addColumn("idade");
    model.addColumn("Sexo");
    criartabela();
    table = new JTable(model);
      
      
      p[1].add(new JScrollPane(table));
      add(p[0],BorderLayout.NORTH); 
      add(btn,BorderLayout.SOUTH);
      add(p[1],BorderLayout.CENTER);
      setVisible(true);}

    public void criartabela()  {
        
        try {
            ClienteDAO dao =new ClienteDAO();
            ArrayList<Cliente> a = new ArrayList<>();
            a=(ArrayList<Cliente>) dao.todos();
            String[] dados=new String[4];
            for(int i=0;i<a.size();i++){
                dados[0]=""+a.get(i).getMatricula();
                dados[1]=a.get(i).getNome();
                dados[2]=""+a.get(i).getIdade();
                dados[3]=a.get(i).getSexo();
                model.addRow(dados);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Cadastrar.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Cadastrar.class.getName()).log(Level.SEVERE, null, ex);
        }
     
    }
}



*/