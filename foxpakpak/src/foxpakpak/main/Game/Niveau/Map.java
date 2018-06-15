/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foxpakpak.main.Game.Niveau;

import java.util.ArrayList;
import foxpakpak.main.Game.Consommables.Consommable;
import foxpakpak.main.Game.Niveau.Cases.Sol;
import foxpakpak.main.Game.Niveau.Cases.Mur;
import iut.Jeu;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


/**
 * Carte
 * @author jp032952
 */
public class Map {
    
    private ArrayList<Consommable> consumables;
    private ArrayList<Character> characters;
    
    
    public void generateMap(Jeu g, String filePath) {
        try {
            Scanner fichier = new Scanner(new File(filePath));
            String ligne;

            int y = 0;


            while (fichier.hasNext()) {
                ligne = fichier.nextLine();


                for (int x = 0; x < ligne.length() - 1; x++) {
                    switch (ligne.charAt(x)) {

                        /* CASES */
                        case 'M': g.ajouter(new Mur(g, "Sprites/Cases/Mur", x*32, y*32)); break;
                        case 'S': g.ajouter(new Sol(g, "Sprites/Cases/Mur.png", x*32, y*32)); break;

                        /* CONSOMMABLES */
                        //case 'F': g.ajouter(new Fruit(g, "Sprites/Cases/Mur", x*32, y*32)); break;

                    }
                }
                y++;

            }


        } catch (FileNotFoundException e) {
            System.out.println("Aucun fichier " + filePath + " n'a été trouvé");
            e.printStackTrace();
        }
        
    }
    
    
}
