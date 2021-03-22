/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

import dao.ComandosSQL;
import dao.Conexao;
import java.sql.Connection;
import java.sql.SQLException;
import view.TelaDelete;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import model.UsuarioVerificar;

/**
 *
 * @author carlos
 */
public class TelaDeleteController {
    private final TelaDelete view;

public TelaDeleteController(TelaDelete view){
    this.view = view;

}

  public void Deletar(){
        String cpf =view.getTxtCPFDelete().getText();
        cpf = cpf.replace(".","");
        cpf = cpf.replace("-","");
        UsuarioVerificar usuario = new UsuarioVerificar(cpf);
    
        try {
            Connection conexao = new Conexao().getConnection();
            ComandosSQL c =  new ComandosSQL(conexao);
            if (c.Verificar(usuario)==true){
            c.Excluir(usuario);
            }
            else{
            JOptionPane.showMessageDialog(null, "Esse CPF não está cadastrado");
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(TelaDeleteController.class.getName()).log(Level.SEVERE, null, ex);
        }
      
      
      
  }
    
    
}
