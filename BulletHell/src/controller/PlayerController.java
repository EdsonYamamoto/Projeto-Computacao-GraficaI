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
import model.Player;

/**
 *
 * @author Edson
 */
public class PlayerController {
    public static Player InstanciarPlayer () throws IOException{
        Player player = new Player("img/player.png");        
        
        File f = new File("C:/Users/Edson/Documents/GIT/ProjetoComputacaoGrafica/BulletHell/src/img/player.png");
        BufferedImage image = ImageIO.read(f);
        int widthPlayer = image.getWidth();
        int heightPlayer = image.getHeight();        

        player.setLargura(widthPlayer);
        player.setAltura(heightPlayer);
        player.setIncY(0);
        player.setIncX(0);
        return player;
    }
    public static void PlayerPosition(Player player, boolean left, boolean right, boolean up, boolean down){
        if (left) {
            player.setIncX(-player.getVelocity());
        } else {
            if (right) {
                player.setIncX(player.getVelocity());
            } else {
                player.setIncX(0);
            }
        }
        if (up) {
            player.setIncY(-player.getVelocity());
        } else {
            if (down) {
                player.setIncY(player.getVelocity());
            } else {
                player.setIncY(0);
            }
        }    
    }
}
