/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import model.Enemy;
import model.EnemyData;
import model.EnemyDataPosition;

/**
 *
 * @author Edson
 */
public class Parser {
    public static List<EnemyData> listaInimigos;
    
    public static void Parser(String pathArquivo){
        listaInimigos = new ArrayList<EnemyData>();
        File file = new File(pathArquivo);
        List movimentos = new ArrayList();
        InputStream input;
 
        try {
            Scanner scanner = new Scanner(file);

            scanner.useDelimiter("(?m:^$)");
            int ntoken = 0;
            while (scanner.hasNext()) {
                
                EnemyData inimigo = new EnemyData();
                do{
                    String token = scanner.next();
                    ntoken++;
                    //System.out.println(token);
                    String[] tempStr = token.split(":");

                    if (tempStr.length>2) {      
                        EnemyDataPosition position = new EnemyDataPosition();
                        
                        position.x = Integer.parseInt(tempStr[1]);
                        position.y = Integer.parseInt(tempStr[2]);
                        inimigo.enemyPosition.add(position);
                    }
                    
                    else{
                        String teste = token.replace("\n", "").trim();
                        String[] tempStr2 = teste.split("[|]");
                        if ("src".equals(tempStr2[0])){
                            inimigo.src=tempStr2[1];
                        }
                        if ("nome".equals(tempStr2[0])){
                            inimigo.nome=tempStr2[1];
                        }
                    }
                }while(inimigo.enemyPosition.size()!=6 || inimigo.nome==null || inimigo.src==null);
                
                listaInimigos.add(inimigo);
            }
            
        } catch (Exception e) {
            System.out.println(e);
            return;
        }
    }
}
