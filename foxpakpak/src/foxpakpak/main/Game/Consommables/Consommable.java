/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foxpakpak.main.Game.Consommables;

import iut.Jeu;
import iut.Objet;
import iut.ObjetTouchable;

/**
 * Consommable
 * @author jp032952
 */
public abstract class Consommable extends ObjetTouchable {
    private int valScore; 
    /**
     * Construction d'un consommable
     * @param g : l'interface graphique
     * @param nom : le nom du consommable
     * @param x : coordonnee x du consommable
     * @param y : coordonnee y du consommable
     */
    public Consommable(Jeu g, String nom, int x, int y) {
        super(g, nom, x, y);
    }
    
    /**
     * Effet lors d'une collision avec l'objet passe en parametre
     * @param o : l'objet en collision
     */
    @Override
    public void effetCollision(Objet o) {
        
    }
    
    /**
     * Renvoie le type du consommable
     * @return : le type du consommable
     */
    @Override
    public String getTypeObjet() {
        return null;
    }
    
    /**
     * Permet le deplacement du consommable
     * @param dt : le temps ecoule depuis le dernier deplacement
     */
    @Override
    public void evoluer(long dt) {
        
    }
    
}
