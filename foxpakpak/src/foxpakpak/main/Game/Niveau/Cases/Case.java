/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foxpakpak.main.Game.Niveau.Cases;

import iut.Jeu;
import iut.Objet;
import iut.ObjetTouchable;

/**
 * Case
 * @author jp032952
 */
public abstract class Case extends ObjetTouchable {
    
    private boolean franchissable;

    /**
     * Constructeur
     * @param x Coordonnée x de la case
     * @param y Coordonnée y de la case
     */
    public Case(Jeu g, String nom, int x, int y) {
        super(g, nom, x, y);
    }
    
    

    public boolean isFranchissable() {
        return franchissable;
    }
    public void setFranchissable(boolean bool) {
        franchissable = bool;
    }





    @Override
    public void evoluer(long dt) {

    }

    @Override
    public void effetCollision(Objet objet) {

    }
}
