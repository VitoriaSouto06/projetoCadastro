/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import model.UsuarioBuscar;
import model.UsuarioCadastro;
import model.UsuarioVerificar;
/**
 *
 * @author carlos
 */
public class ComandosSQL {
    private final Connection connection;
    
    public ComandosSQL(Connection connection){
        this.connection = connection;
    
    } 
    
    
    public void Insert (UsuarioCadastro usuario) throws SQLException{
         DateFormat datef = new SimpleDateFormat("yyyy/MM/dd");
         Date now = new Date();
         String data =(datef.format(now));
      
      String sql = "INSERT INTO CADASTRO (NOME,TELEFONE,EMAIL,IDADE,CPF,DATA) values (' "+usuario.getNome()+" ',' "+usuario.getTelefone()+" ',' "+usuario.getEmail()+" ',' "+usuario.getIdade()+" ',' "+usuario.getCpf()+" ',' "+data+" ');";
       PreparedStatement statement = connection.prepareStatement(sql);
       statement.execute();
       JOptionPane.showMessageDialog(null, "Cadastro efetuado com sucesso");
       
     
     
    }
    public boolean Verificar(UsuarioVerificar usuario) throws SQLException{
        
      String sql = "SELECT *  FROM CADASTRO WHERE CPF LIKE '%"+usuario.getCpf()+"%'; ";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.execute();
        ResultSet r = statement.getResultSet();
       return r.next();
    }
    
    public void Excluir(UsuarioVerificar usuario) throws SQLException{
    
        String sql = "DELETE FROM CADASTRO WHERE CPF LIKE  '%"+usuario.getCpf()+"%';";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.execute();
        JOptionPane.showMessageDialog(null,"Cliente deletado com sucesso");
        
    }
    
    public UsuarioBuscar BuscarEspecifico(UsuarioVerificar usuario)throws SQLException{
        String sql = "SELECT * FROM CADASTRO WHERE CPF LIKE '%"+usuario.getCpf()+"%' ";
        PreparedStatement statement = connection.prepareStatement(sql);
        ArrayList <UsuarioBuscar> usuarioResultado = new ArrayList<UsuarioBuscar>();
         
        statement.execute();
        ResultSet r = statement.getResultSet();
        while(r.next()){
            int id = r.getInt("ID");
            String nome =r.getString("NOME") ;
           String telefone = r.getString("TELEFONE");
            String email =r.getString("EMAIL");
            int idade = r.getInt("IDADE");
            String cpf= r.getString("CPF") ;
            String data= r.getString("DATA");
            
            UsuarioBuscar resposta = new UsuarioBuscar(id,nome,telefone,email,idade,cpf,data);
            usuarioResultado.add(resposta);
            
            
        }
        return usuarioResultado.get(0);
    }
    
    
    
    
    }
  
    
  
    

