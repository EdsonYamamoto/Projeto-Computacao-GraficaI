/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.Shoot;
import model.Player;

/**
 *
 * @author Edson
 */
public class ShootController {
        public static Shoot InstanciarShoot (Player player){                
            Shoot t = new Shoot();
            t.setIncX(0);
            t.setIncY(-5);
            t.setX(player.getX()+ player.getLargura()/2);
            t.setY(player.getY() -t.getAltura()/2);
            t.setAltura(4);
            t.setLargura(2);
        return t;
    }

}
