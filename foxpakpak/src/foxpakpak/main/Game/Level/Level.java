/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foxpakpak.main.Game.Level;

import java.util.ArrayList;
import foxpakpak.main.Game.Consumables.Consommable;
import foxpakpak.main.Game.Consumables.Dot;
import foxpakpak.main.Game.Consumables.Fruit;
import foxpakpak.main.Game.Consumables.SuperDot;
import foxpakpak.main.Game.Level.Cases.Sol;
import foxpakpak.main.Game.Level.Cases.Mur;
import iut.Jeu;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Niveau
 * @author jp032952
 */
public class Level {
    
    private ArrayList<Consommable> consumables;
    private ArrayList<Character> characters;
    
    public void generateLevel(Jeu g, String filePath) {
        try {
            Scanner fichier = new Scanner(new File(filePath));
            String ligne;
            int y = 0;
            
            while (fichier.hasNext()) {
                ligne = fichier.nextLine();
                
                for (int x = 0; x < ligne.length() - 1; x++) {
                    switch (ligne.charAt(x)) {
                        
                        /* CASES */
                        case 'M':
                            g.ajouter(new Mur(g, "Sprites/Cases/Mur", x*32, y*32));
                            break;
                        case 'S':
                            g.ajouter(new Sol(g, "Sprites/Cases/Sol", x*32, y*32));
                            break;
                            
                        /* CONSOMMABLES */
                        case 'X':
                            g.ajouter(new Dot(g, "Sprites/Consumables/Dot", x*32+14, y*32+14));
                            break;
                        case 'D':
                            g.ajouter(new SuperDot(g, "Sprites/Consumables/SuperDot", x*32+12, y*32+12));
                            break;
                        case 'F':
                            g.ajouter(new Fruit(g, "Sprites/Consumables/Fruit", x*32+10, y*32+10));
                            break;
                    }
                }
                
                y++;
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Aucun fichier " + filePath + " n'a été trouvé");
            System.out.println(ex);
        }
    }
    
}
