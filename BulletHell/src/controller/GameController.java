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
}
