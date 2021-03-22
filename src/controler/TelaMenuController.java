/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

import view.TelaBusca;
import view.TelaCadastro;
import view.TelaDelete;
import view.TelaMenu;


public class TelaMenuController {
    private TelaMenu view;
    
    public TelaMenuController(TelaMenu view){
        this.view = view;
    
    }

    public void Cadastrar() {
        TelaCadastro c = new TelaCadastro();
        c.setVisible(true);
    }
    
    public void Deletar(){
        TelaDelete d = new TelaDelete();
        d.setVisible(true);
    
    }
    public void BuscarUsuario(){
        TelaBusca b = new TelaBusca();
        b.setVisible(true);
    
    }
    
    
    
    
    
}
