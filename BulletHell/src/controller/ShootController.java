/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import model.Enemy;
import model.Shoot;
import model.Player;

/**
 *
 * @author Edson
 */
public class ShootController {
        public static Shoot InstanciarShoot (Player player) throws IOException{                
            Shoot t = new Shoot("/img/power.png");
            
            File f = new File("C:/Users/Edson/Documents/GIT/ProjetoComputacaoGrafica/BulletHell/src/img/power.png");
            BufferedImage image = ImageIO.read(f);
            
            t.setAltura(image.getHeight());
            t.setLargura(image.getWidth());
            
            t.setIncX(0);
            t.setIncY(-5);
            t.setX(player.getX());
            t.setY(player.getY() - t.getAltura()-5);
        return t;
    }
        public static Shoot TiroInimigo(Enemy inimigo, Player player) throws IOException{
            Shoot t = new Shoot("/img/enemyPower.png");
            
            File f = new File("C:/Users/Edson/Documents/GIT/ProjetoComputacaoGrafica/BulletHell/src/img/enemyPower.png");
            BufferedImage image = ImageIO.read(f);
            
            t.setAltura(image.getHeight());
            t.setLargura(image.getWidth());
            int incX = player.getX()-inimigo.getX();
            int incY = player.getY()-inimigo.getY();
            t.setIncX(incX/100);
            t.setIncY(incY/100);
            if (t.getIncX()==0 &&t.getIncY()==0){
                t.setIncX(2);
                t.setIncY(2);
            }
            if(incX>=0)
                t.setX(inimigo.getX()+inimigo.getLargura()+t.getLargura());
            if(incX<0)
                t.setX(inimigo.getX()-inimigo.getLargura()-t.getLargura());
            if(incY>=0)
                t.setY(inimigo.getY()+inimigo.getAltura()+t.getAltura());
            if(incY<0)
                t.setY(inimigo.getY()-inimigo.getAltura()-t.getAltura());
            return t;
        }
}
