/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foxpakpak.main.game.map;

import java.util.ArrayList;
import foxpakpak.main.game.entites.consumables.Consumable;
import foxpakpak.main.game.map.cases.Door;
import foxpakpak.main.game.map.cases.Floor;
import foxpakpak.main.game.map.cases.TypeCase;
import foxpakpak.main.game.map.cases.Wall;
import foxpakpak.main.game.map.graphes.Graph;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


/**
 * Carte
 * @author jp032952
 */
public class Map {
    
    private ArrayList<Consumable> consumables;
    private ArrayList<Character> characters;
    
    
    public void generateMap(String filePath) {
        try {
            Scanner file = new Scanner(new File(filePath));  
            
            String letter;
            int x=0;
            int y=0;
            
            
            /* NON FONCTIONNEL ! */
            
            while (file.hasNext()) {
               letter = file.next();
               
               switch (letter) {
                   
                   case "W":
                       new Wall(x, y);
                       break;   
                       
                   case "F":
                       new Floor(x, y);
                       break;
                       
                   case "D" :
                       new Door(x, y);
                       break;
                                              
               }
               System.out.println(letter);
               
            }
            
        } catch (FileNotFoundException e) {
            System.out.println("Aucun fichier " + filePath + " n'a été trouvé");
            e.printStackTrace();
        }
        
    }
    
    
}
