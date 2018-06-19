/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foxpakpak.main.game.consumables;

import iut.Jeu;

/**
 * Point
 * @author jp032952
 */
public class Dot extends Consommable {
    
    /**
     * Construction d'un point
     * @param g : l'interface graphique
     * @param nom : le nom du point
     * @param x : coordonnee x du point
     * @param y : coordonnee y du point
     */
    public Dot(Jeu g, String nom, int x, int y) {
        super(g, nom, x, y);
        this.scorePts = 10;
    }
    
    @Override
    public String getTypeObjet() {
        return "DOT";
    }
    
}
