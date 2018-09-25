/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import BulletHell.FrmJogo;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import model.Base;
import model.Player;
import model.Enemy;
import model.EnemyData;
import model.Shoot;
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
    public static void InimigoFazAlgo(List<Base> lista, Graphics g, long tempo, Player player) throws IOException{
        for (Base inimigo : lista) {
            if(Enemy.class.isInstance(inimigo)){            
                g.setColor(Color.BLACK);
                g.drawString( Enemy.class.cast(inimigo).getNome() , inimigo.getX()-inimigo.getLargura()/2, inimigo.getY()-inimigo.getAltura());
            }
        }
        for (int i = 0; i < lista.size(); i++) {
            Random r = new Random();
            if(Enemy.class.isInstance(lista.get(i))){            
                Enemy inimigo = Enemy.class.cast(lista.get(i));
                if (r.nextInt(100)==0){                   
                    if(tempo > Enemy.class.cast(inimigo).tempo + 1000){
                        Enemy.class.cast(inimigo).tempo = tempo;
                        Enemy.class.cast(inimigo).soltouPoder=true;
                        lista.add(instanciarTirosInimigos(Enemy.class.cast(inimigo), player));
                    }
                }
                if(Enemy.class.cast(inimigo).soltouPoder){
                    g.setColor(Color.BLACK);
                    g.drawString( "Solta PODER!!!" , inimigo.getX()-inimigo.getLargura()/2, inimigo.getY()+inimigo.getAltura()*2);
                }
                if(tempo > Enemy.class.cast(inimigo).tempo + 1000){
                    Enemy.class.cast(inimigo).soltouPoder=false;
                }
            }
        }
    }
    public static Shoot instanciarTirosInimigos(Enemy inimigo, Player player) throws IOException{
        return ShootController.TiroInimigo(inimigo, player);
    }
}

