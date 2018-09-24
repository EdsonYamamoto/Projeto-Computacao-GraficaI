/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author Edson
 */
public class EnemyData {
    public ArrayList<EnemyDataPosition> enemyPosition;
    public String nome;
    public String src;

    public EnemyData() {
        enemyPosition = new ArrayList<EnemyDataPosition>();
    }

    @Override
    public String toString() {
        return "EnemyData{" + "enemyPosition=" + enemyPosition + ", nome=" + nome + ", src=" + src + '}';
    }
    
    
}
