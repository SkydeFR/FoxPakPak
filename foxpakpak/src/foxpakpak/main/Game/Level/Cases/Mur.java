/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foxpakpak.main.Game.Level.Cases;

import iut.Jeu;

/**
 * Mur
 * @author Ange Pagel
 */
public class Mur extends Case {

    public Mur(Jeu g, String nom, int x, int y) {
        super(g, nom, x, y);
    }

    @Override
    public String getTypeObjet() {
        return "MUR";
    }

}