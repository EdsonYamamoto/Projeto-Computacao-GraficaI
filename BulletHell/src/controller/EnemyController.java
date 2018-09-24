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
import model.EnemyData;
import service.Parser;

/**
 *
 * @author Edson
 */
public class EnemyController {
    public static Enemy InstanciarInimigo(EnemyData Inimigo) throws IOException{
        Enemy inimigo = new Enemy(Inimigo.nome);
                
        File f = new File(Inimigo.src);
        
        BufferedImage image = ImageIO.read(f);
       
        return inimigo;
    }
}

