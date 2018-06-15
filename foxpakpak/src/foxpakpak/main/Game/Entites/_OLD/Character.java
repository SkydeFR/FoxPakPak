/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foxpakpak.main.Game.Entites._OLD;

import iut.Jeu;
import iut.Objet;
import iut.ObjetTouchable;

/**
 * Personnage
 * @author jp032952
 */
public abstract class Character extends ObjetTouchable {
    private int vitesse; 
    /**
     * Construction d'un personnage
     * @param g : l'interface graphique
     * @param nom : le nom du personnage
     * @param x : coordonnee x du personnage
     * @param y : coordonnee y du personnage
     */
    public Character(Jeu g, String nom, int x, int y, int v) {
        super(g, nom, x, y);
        this.vitesse = v; 
    }
    
    /**
     * Effet lors d'une collision avec l'objet passe en parametre
     * @param o : l'objet en collision
     */
    @Override
    public void effetCollision(Objet o) {
        
    }
    
    /**
     * Renvoie le type du personnage
     * @return : le type du personnage
     */
    @Override
    public String getTypeObjet() {
        return null;
    }
    
    /**
     * Permet le deplacement du personnage
     * @param dt : le temps ecoule depuis le dernier deplacement
     */
    @Override
    public void evoluer(long dt) {
        
    }
    
}
