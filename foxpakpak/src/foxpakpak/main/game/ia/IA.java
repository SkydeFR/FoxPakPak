/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foxpakpak.main.Game.IA;

import iut.Jeu;
import iut.ObjetTouchable;

/**
 *
 * @author jp032952
 */
public abstract class IA extends ObjetTouchable {
    
    public IA(Jeu g, String nom, int x, int y) {
        super(g, nom, x, y);
    }
    
}
