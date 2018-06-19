/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foxpakpak.main.game.level.cases;

import iut.Jeu;

/**
 * Sol
 * @author Ange Pagel
 */
public class Sol extends Case {
    
    public Sol(Jeu g, String nom, int x, int y) {
        super(g, nom, x, y);
    }
    
    @Override
    public String getTypeObjet() {
        return "SOL";
    }
    
}
