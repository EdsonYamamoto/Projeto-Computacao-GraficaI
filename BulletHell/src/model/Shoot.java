/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import model.Base;
import java.awt.Graphics;
import java.util.Random;

/**
 *
 * @author Edson
 */
public class Shoot extends Base {
    
    public Shoot(String url){
        super(url);
    }
    
    public Shoot(){
    }
    /*
    @Override
    public void desenhar(Graphics g){
        g.setColor(cor);
        g.fillRect(x, y, largura, altura);
    }
    */
}
