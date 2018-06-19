/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foxpakpak.main.game.consumables;

import iut.Jeu;

/**
 * Fruit
 * @author jp032952
 */
public class Fruit extends Consommable {
    
    /**
     * Construction d'un fruit
     * @param g : l'interface graphique
     * @param nom : le nom du fruit
     * @param x : coordonnee x du fruit
     * @param y : coordonnee y du fruit
     */
    public Fruit(Jeu g, String nom, int x, int y) {
        super(g, nom, x, y);
        this.scorePts = 100;
    }
    
    @Override
    public String getTypeObjet() {
        return "FRUIT";
    }
    
}
