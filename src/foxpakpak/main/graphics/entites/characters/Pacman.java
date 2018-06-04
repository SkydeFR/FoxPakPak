/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foxpakpak.main.graphics.entites.characters;

import iut.Jeu;

/**
 * Pacman
 * @author jp032952
 */
public class Pacman extends Character {
    
    /**
     * Construction d'un pacman
     * @param g : l'interface graphique
     * @param nom : le nom du pacman
     * @param x : coordonnee x du pacman
     * @param y : coordonnee y du pacman
     */
    public Pacman(Jeu g, String nom, int x, int y) {
        super(g, nom, x, y);
    }
    
}
