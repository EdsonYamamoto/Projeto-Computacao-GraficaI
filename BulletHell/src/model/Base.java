/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import main.Colisao;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;
import javax.swing.ImageIcon;


/**
 *
 * @author glauc
 */
public abstract class Base {
    
    protected int x = 0;
    protected int y = 0;
    protected int incX = 1;
    protected int incY = 1;
    protected Color cor = Color.BLACK;
    protected Color borda = Color.GREEN;
    protected int largura=30;
    protected int altura=30;
    protected Rectangle rect = new Rectangle(0,0,30,30);
    protected ImageIcon img;
    
    
    public Base(){
    }
    public Base(String url){
       img     = new ImageIcon(this.getClass().getResource("/").getPath()+ url);
       largura = img.getIconWidth();
       altura  = img.getIconHeight();
       rect.height = altura;
       rect.width = largura;
    }

    public int getLargura() {
        return largura;
    }

    public int getAltura() {
        return altura;
    }
    
    
    

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
        this.rect.x = x;
        
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
        this.rect.y =y;
    }

    public int getIncX() {
        return incX;
    }

    public void setIncX(int incX) {
        this.incX = incX;
    }

    public int getIncY() {
        return incY;
    }

    public void setIncY(int incY) {
        this.incY = incY;
    }

    public Color getCor() {
        return cor;
    }

    public void setCor(Color cor) {
        this.cor = cor;
    }

    public void setLargura(int largura) {
        this.largura = largura;
        this.rect.width = largura;      
    }
    
    public void setAltura(int altura) {
        this.altura = altura;
        this.rect.height = altura;
    }

    public void desenhar(Graphics g){
       
        if(img != null){
         g.drawImage(img.getImage(), x, y, null);
        }
       
    }
       
    public void enemyMove(String nome) {
        Random r = new Random();
        int valor = r.nextInt(100);
        if (valor>0&&valor<25){
            x = x + incX+2;
        }
        if (valor>25&&valor<50){
            x = x - incX-2;
        }
        if (valor>50&&valor<75){
            y = y + incY+2;
        }
        if (valor>75&&valor<100){
            y = y - incY-2;
        }
        this.rect.x= x;
        this.rect.y = y;
    }
    
    public void mover() {
        x = x + incX;
        y = y + incY;
        this.rect.x= x;
        this.rect.y = y;
    }

    public Colisao trataColisao(int width, int height) {
        Colisao resp = Colisao.NONE;
        
        if (x < 0) {
            incX = 1;
            resp = Colisao.LEFT;
        } else if (x > width - 30) {
            incX = -1;
            resp = Colisao.RIGHT;
        }

        if (y < 28) {
            incY = 1;
            resp = Colisao.UP;
        } else if (y > height - altura) {
            incY = -1;
            resp = Colisao.DOWN;
        }
        
        return resp;
    }
    
    public boolean colisao(Base outraBase){
        if(this.equals(outraBase))
            return false;
        else            
            return rect.intersects(outraBase.rect);
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 47 * hash + this.x;
        hash = 47 * hash + this.y;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Base other = (Base) obj;
        if (this.x != other.x) {
            return false;
        }
        if (this.y != other.y) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Base{" + "x=" + x + ", y=" + y + ", incX=" + incX + ", incY=" + incY + ", cor=" + cor + ", borda=" + borda + ", largura=" + largura + ", altura=" + altura + ", rect=" + rect + ", img=" + img + '}';
    }
    
    

}
