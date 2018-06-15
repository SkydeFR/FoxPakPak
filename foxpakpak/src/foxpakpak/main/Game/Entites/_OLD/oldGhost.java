/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foxpakpak.main.Game.Entites._OLD;

import foxpakpak.main.Game.ia.IA;
import iut.Jeu;

/**
 * Fantome
 * @author jp032952
 */
public class oldGhost extends Character {
    private IA ia; 
    private boolean mangeable; 
    private int valScore; 
    
    /**
     * Construction d'un fantome
     * @param g : l'interface graphique
     * @param nom : le nom du fantome
     * @param x : coordonnee x du fantome
     * @param y : coordonnee y du fantome
     * @param v : la vitesse
     * @param _ia : inteligence artificiel associé au fantôme
     */
    public oldGhost(Jeu g, String nom, int x, int y, int v) {
        super(g, nom, x, y, v);
        this.ia = null;
        this.mangeable = false;
        this.valScore = 1000;
    }
    
    @Override
    public String getTypeObjet() {
        return "Ghost";
    }
    
}
