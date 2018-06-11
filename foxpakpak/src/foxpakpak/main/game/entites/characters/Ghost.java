/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foxpakpak.main.game.entites.characters;

import foxpakpak.main.graphics.map.ia.IA;
import iut.Jeu;

/**
 * Fantome
 * @author jp032952
 */
public class Ghost extends Character {
    private String color;
    private IA ia; 
    /**
     * Construction d'un fantome
     * @param g : l'interface graphique
     * @param nom : le nom du fantome
     * @param x : coordonnee x du fantome
     * @param y : coordonnee y du fantome
     */
    public Ghost(Jeu g, String nom, int x, int y, String _color, IA _ia) {
        super(g, nom, x, y);
        this.color = _color; 
        this.ia = _ia; 
    }
    
}
