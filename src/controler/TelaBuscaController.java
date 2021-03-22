/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

import model.UsuarioVerificar;
import view.TelaBusca;
import dao.Conexao;
import dao.ComandosSQL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import model.UsuarioBuscar;


/**
 *
 * @author carlos
 */
public class TelaBuscaController {

    private TelaBusca view;
      public TelaBuscaController(TelaBusca view) {
        this.view = view;
    }
      
      public void BuscarUsuario(){
      String cpf = view.getTxtCPFBusca().getText();
      cpf = cpf.replace(".","");
      cpf = cpf.replace("-","");
 
      UsuarioVerificar usuario =  new UsuarioVerificar(cpf);
        
      
            Connection conexao;
        try {
            conexao = new Conexao().getConnection();
              ComandosSQL c = new ComandosSQL(conexao);
              UsuarioBuscar usuarioSelecionado = c.BuscarEspecifico(usuario);
              
              System.out.print(usuarioSelecionado.getTelefone());
              view.getLblID().setText("ID "+Integer.toString(usuarioSelecionado.getId()));
              view.getLblNome().setText("Nome "+usuarioSelecionado.getNome());
              view.getLblTelefone().setText("Telefone "+usuarioSelecionado.getTelefone());
              view.getLblEmail().setText("Email "+usuarioSelecionado.getEmail());
              view.getLblIdade().setText("Idade "+Integer.toString(usuarioSelecionado.getIdade()));
              view.getLblData().setText("Data de cadastro "+usuarioSelecionado.getData());
              }
                     
              
        catch (SQLException ex) {
            Logger.getLogger(TelaBuscaController.class.getName()).log(Level.SEVERE, null, ex);
        }
          
            
     
      
      
      }
      
    
}
