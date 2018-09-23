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

/**
 *
 * @author Edson
 */
public class Parser {
    public static List Parser(String pathArquivo){
        File file = new File(pathArquivo);
        List movimentos = new ArrayList();
        InputStream input;
 
        try {
            Scanner scanner = new Scanner(file);

            scanner.useDelimiter("(?m:^$)");
            int ntoken = 0;
            while (scanner.hasNext()) {
                String token = scanner.next();
                ntoken++;
                //System.out.println(token);
                String[] tempStr = token.split(":");
                
                EnemyData movimento = new EnemyData();
                if (tempStr.length>2) {      
                    movimento.x = Integer.parseInt(tempStr[1]);
                    movimento.y = Integer.parseInt(tempStr[2]);
                }
                else{
                    movimento.nome=token;
                }
                
                movimentos.add(movimento);
            }
            //System.out.println(movimentos);
        } catch (Exception e) {
            System.out.println(e);
        }
        return movimentos;
    }
}
