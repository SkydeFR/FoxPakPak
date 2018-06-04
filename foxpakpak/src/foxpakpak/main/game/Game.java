/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foxpakpak.main.game;

import static foxpakpak.main.game.Game.Menus.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

/**
 * Jeu
 * @author jp032952
 */
public class Game extends iut.Jeu {
      
    public static Menus menu;
    
    /**
     * Liste des différents menus
     */
    public enum Menus {

        /**
         * Menu principal
         */
        PRINCIPAL,
        
        /**
         * Le jeu
         */
        GAME
    }
    
    /**
     * Constructeur du jeu
     * @param width : la largeur du jeu
     * @param height : la hauteur du jeu
     * @param title : le titre du jeu
     */
    public Game(int width, int height, String title) {
        super(width, height, title);
        this.setLocation(5, 5); //On centre l'interface graphique
        this.menu = PRINCIPAL; //Menu par défaut = menu principal
    }

    /**
     * Creation des objets en jeu
     */
    @Override
    protected void creeObjets() {
        
    }

    /**
     * Dessine l'arriere plan du jeu
     * @param g : l'interface graphique
     */
    @Override
    protected void dessinerArrierePlan(Graphics g) {
        Color black = new Color(0, 0, 0);
        Color red = new Color(255, 0, 0);
        
        switch (menu) {
            case PRINCIPAL :
                /* Afficher background */
                g.setColor(black);
                g.fillRect(0, 0, largeur(), hauteur());
                
                /* Afficher texte */
                g.setColor(red);
                g.setFont(new Font("TimesRoman", Font.PLAIN, 100));
                g.drawString("Hello World",200,200);
                break;
            case GAME :
                g.setColor(red);
                g.fillRect(0, 0, largeur(), hauteur());
            default :
                System.out.println("Type de menu non implémenté");
        }
    }

    /**
     * Fonction appelee lorsque pacman n'a plus de vie
     */
    @Override
    protected void perdu() {
        
    }

    /**
     * Fonction appelee lorsque pacman finit le niveau
     */
    @Override
    protected void gagne() {
        
    }

    /**
     * Renvoie vrai si pacman finit le niveau, sinon renvoie faux
     * @return : vrai si pacman finit le niveau, sinon renvoie faux
     */
    @Override
    protected boolean aGagne() {
        return true;
    }

    /**
     * Renvoie vrai si pacman n'a plus de vie, sinon renvoie faux
     * @return : vrai si pacman n'a plus de vie, sinon renvoie faux
     */
    @Override
    protected boolean aPerdu() {
        return true;
    }
    
}
