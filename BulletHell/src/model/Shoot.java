/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import model.Base;
import java.awt.Graphics;

/**
 *
 * @author glauc
 */
public class Shoot extends Base {
    
    @Override
    public void desenhar(Graphics g){
        g.setColor(cor);
        g.fillRect(x, y, largura, altura);
    }
    
}