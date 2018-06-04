/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foxpakpak.main.game.menu;

import java.awt.Color;
import java.awt.Graphics;

/**
 * Menu
 * @author jp032952
 */
public class Menu extends iut.Jeu {
    
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
     * @param largeur : la largeur du jeu
     * @param hauteur : la hauteur du jeu
     * @param title : le titre du jeu
     */
    public Menu(int largeur, int hauteur, String title, Menus _menu) {
        super(largeur, hauteur, title);
        menu = _menu;
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
        switch (menu) {
            case PRINCIPAL :
                Color black = new Color(0, 0, 0);

                g.setColor(black);
                g.fillRect(0, 0, largeur(), hauteur());
                break;
            case GAME :
                Color red = new Color(255, 0, 0);

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
