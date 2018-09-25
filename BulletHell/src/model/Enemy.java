/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Random;




/**
 *
 * @author Edson
 */
public class Enemy extends Base{
    private String nome;
    public int type;
    public boolean soltouPoder;
    public long tempo;
    public Enemy(){
    }
    
    public Enemy(String url){
        super(url);
        Random r = new Random();
        type = r.nextInt(5);
        nome = url;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Enemy{" + "nome=" + nome + '}'+"Base{" + "x=" + x + ", y=" + y + ", incX=" + incX + ", incY=" + incY + ", cor=" + cor + ", borda=" + borda + ", largura=" + largura + ", altura=" + altura + ", rect=" + rect + ", img=" + img + '}';
        
    }
}
