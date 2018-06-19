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
    
    private String fruit;
    
    /**
     * Construction d'un fruit
     * @param g : l'interface graphique
     * @param nom : le nom du fruit
     * @param x : coordonnee x du fruit
     * @param y : coordonnee y du fruit
     */
    public Fruit(Jeu g, String nom, int x, int y) {
        super(g, nom, x, y);
        int random = (int)(1+Math.random()*3);
        switch (random) {
            case 1:
                this.changeSprite("Sprites/Consumables/Cerise");
                this.fruit = "CERISE";
                this.scorePts = 50;
                break;
            case 2:
                this.changeSprite("Sprites/Consumables/Orange");
                this.fruit = "ORANGE";
                this.scorePts = 100;
                break;
            case 3:
                this.changeSprite("Sprites/Consumables/Fraise");
                this.fruit = "FRAISE";
                this.scorePts = 150;
                break;
        }
    }
    
    @Override
    public String getTypeObjet() {
        return "FRUIT";
    }
    
}
