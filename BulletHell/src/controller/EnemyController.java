/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import BulletHell.FrmJogo;
import java.awt.Color;
import java.awt.List;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import model.Enemy;

/**
 *
 * @author Edson
 */
public class EnemyController {
    public static Enemy InstanciarInimigo(String nome) throws IOException{
        Random r = new Random();
        Enemy inimigo = new Enemy("img/enemy.png");

        File f = new File("C:/Users/Edson/Documents/GIT/ProjetoComputacaoGrafica/BulletHell/src/img/enemy.png");
        
        BufferedImage image = ImageIO.read(f);
        int widthEnemy = image.getWidth();
        int heightEnemy = image.getHeight();        
        inimigo.setX(r.nextInt());
        inimigo.setY(r.nextInt());
        
        return inimigo;
    }
}

