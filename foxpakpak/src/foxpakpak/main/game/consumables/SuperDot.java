/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foxpakpak.main.game.consumables;

import iut.Jeu;

/**
 *
 * @author ml809201
 */
public class SuperDot extends Consommable {
    /**
     * Construction d'un super point
     * @param g : l'interface graphique
     * @param nom : le nom du point
     * @param x : coordonnee x du point
     * @param y : coordonnee y du point
     */
    public SuperDot(Jeu g, String nom, int x, int y) {
        super(g, nom, x, y);
        this.scorePts = 30;
    }
    
    @Override
    public String getTypeObjet() {
        return "SUPERDOT";
    }
    
}
