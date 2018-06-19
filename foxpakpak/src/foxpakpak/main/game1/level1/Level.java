/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foxpakpak.main.game1.level1;

import java.util.ArrayList;
import foxpakpak.main.game.consumables.Consommable;
import foxpakpak.main.game.consumables.Dot;
import foxpakpak.main.game.consumables.Fruit;
import foxpakpak.main.game.consumables.SuperDot;
import foxpakpak.main.game.level.cases.*;
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
    private int nbConsumables;
    private ArrayList<Case> cases;
    
    public Level() {
        this.nbConsumables = 0;
        this.cases = new ArrayList<>();
    }
    
    public void generateLevel(Jeu g, String filePath) {
        nbConsumables = 0;
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
                            Mur mur = new Mur(g, "Sprites/Cases/Mur", x*32, y*32);
                            cases.add(mur);
                            g.ajouter(mur);
                            break;
                        case ' ':
                            /*
                            Sol sol = new Sol(g, "Sprites/Cases/Sol", x*32, y*32);
                            cases.add(sol);
                            g.ajouter(sol);
                            */
                            break;
                            
                        /* CONSOMMABLES */
                        case 'X':
                            nbConsumables++;
                            g.ajouter(new Dot(g, "Sprites/Consumables/Dot", x*32+14, y*32+14));
                            break;
                        case 'D':
                            nbConsumables++;
                            g.ajouter(new SuperDot(g, "Sprites/Consumables/SuperDot", x*32+12, y*32+12));
                            break;
                        case 'F':
                            nbConsumables++;
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
    
    public int getNbConsumables() {
        return nbConsumables;
    }
    
    public ArrayList<Case> getCases() {
        return cases;
    }
    
}
