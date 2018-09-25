/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;
import main.Colisao;
import BulletHell.FrmJogo;
import java.util.List;
import model.Base;
import model.Enemy;
import model.Player;
import model.Shoot;

/**
 *
 * @author Edson
 */
public class GameController {
    private static int points=0;
    private static int level=1;

    public static int getPoints() {
        return points;
    }

    public static void setPoints(int points) {
        GameController.points = points;
    }

    public static int getLevel() {
        return level;
    }

    public static void setLevel(int level) {
        GameController.level = level;
    }
    
    public static void ColidiuAlgo(List<Base> lista,List<Base> lixo, Player player, int windowWidth, int windowHeigth){
                for (Base b : lista) {
                Colisao aux = b.trataColisao(windowWidth, windowHeigth);
                if (b!=player){
                    if (aux == Colisao.DOWN) {
                        lixo.add(b);
                    }
                    if (aux == Colisao.UP) {
                        lixo.add(b);
                    }
                    if (aux == Colisao.RIGHT) {
                        lixo.add(b);
                    }
                    if (aux == Colisao.LEFT) {
                        lixo.add(b);
                    }
                }
                if (b==player){
                    if (aux == Colisao.DOWN){
                        player.setY(windowHeigth-player.getAltura());
                    }
                    if (aux == Colisao.UP){
                        player.setY(player.getPlayerHeight()+30);
                    }
                    if (aux == Colisao.RIGHT){
                        player.setX(windowWidth-player.getLargura());
                    }
                    if (aux == Colisao.LEFT){
                        player.setX(player.getPlayerWidth());
                    }
                }
            }
}
    public static void TiroAcertou(List<Base> lista,List<Base> lixo ){
                    for (Base tiro : lista){
                if (Shoot.class.isInstance(tiro)){
                    for (Base inimigo : lista){
                        if (Enemy.class.isInstance(inimigo)){
                            if (inimigo.getX()+inimigo.getLargura()/2<tiro.getX()+tiro.getLargura()&&
                                inimigo.getX()-inimigo.getLargura()/2>tiro.getX()-tiro.getLargura()){
                                
                                if (inimigo.getY()+inimigo.getAltura()/2<tiro.getY()+tiro.getAltura()&&
                                    inimigo.getY()-inimigo.getAltura()/2>tiro.getY()-tiro.getAltura()){
                                    if (Enemy.class.isInstance(inimigo)){
                                        
                                        GameController.setPoints(GameController.getPoints()+1);
                                        lixo.add(tiro);
                                        lixo.add(inimigo);                               
                                    }
                                }
                            }
                        }
                    }
                }
            }

    }
}
