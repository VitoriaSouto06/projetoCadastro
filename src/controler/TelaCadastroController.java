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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextField;
import model.UsuarioCadastro;
import view.TelaCadastro;

/**
 *
 * @author carlos
 */
public class TelaCadastroController {
    
    private TelaCadastro view;

    public TelaCadastroController(TelaCadastro view) {
        this.view = view;
    }
    
    
    public void CadastraUsuario(){
    
       String nome = view.getTxtNomeCadastro().getText();
       
       String telefone =view.getTxtTelefoneCadastro().getText();
       telefone = telefone.replace("(","");
       telefone = telefone.replace(")","");
       telefone = telefone.replace("-","");
 
       String email = view.getTxtEmailCadastro().getText();
       
       int idade = Integer.parseInt(view.getTxtIdadeCadastro().getText());
       
       String cpf = view.getTxtCPFCadastro().getText();
       cpf = cpf.replace(".","");
       cpf = cpf.replace("-","");
      
       
       UsuarioCadastro usuario =  new UsuarioCadastro(nome,telefone,email,idade,cpf);
      
       
        try {
            Connection conexao = new Conexao().getConnection();
            ComandosSQL c = new ComandosSQL(conexao);
            c.Insert(usuario);
            System.out.print(cpf);
            
        } catch (SQLException ex) {
            Logger.getLogger(TelaCadastro.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    
    }
    
}
