/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;




/**
 *
 * @author glauc
 */
public class Enemy extends Base{
    private String nome;
    public Enemy(){
    }
    
    public Enemy(String url){
        super(url);
        
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
}
