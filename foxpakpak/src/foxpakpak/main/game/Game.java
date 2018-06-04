/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foxpakpak.main.game;

import static foxpakpak.main.game.Game.Menus.*;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JOptionPane;

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
        Game.menu = PRINCIPAL; //Menu par défaut = menu principal
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
                int xCoord;
                int yCoord;
                
                /* On affiche le curseur */
                Cursor cursor=Cursor.getDefaultCursor();
                this.setCursor(cursor);
                
                /* Afficher background */
                g.setColor(Color.BLACK);
                g.fillRect(0, 0, largeur(), hauteur());
                
                /* Afficher texte */
                g.setColor(Color.ORANGE);
                g.setFont(new Font("TimesRoman", Font.PLAIN, 100));
                xCoord = largeur()/2 - 330;
                yCoord = hauteur()/2 - 200;
                g.drawString("TheFoxPakpak",xCoord,yCoord);
                
                /* Afficher boutton */
                xCoord = largeur()/2 - 200;
                yCoord = hauteur()/2 - 100;
                g.setColor(Color.DARK_GRAY);
                g.draw3DRect(xCoord, yCoord, 400, 100, true);
                g.fill3DRect(xCoord+1, yCoord+1, 400-1, 100-1, true);
                
                /* Afficher boutton */
                xCoord = largeur()/2 - 200;
                yCoord = hauteur()/2 + 50;
                g.setColor(Color.DARK_GRAY);
                g.draw3DRect(xCoord, yCoord, 400, 100, true);
                g.fill3DRect(xCoord+1, yCoord+1, 400-1, 100-1, true);
                break;
            case GAME :
                g.setColor(Color.RED);
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
        JOptionPane.showMessageDialog(this, "Vous avez perdu");        
    }

    /**
     * Fonction appelee lorsque pacman finit le niveau
     */
    @Override
    protected void gagne() {
        JOptionPane.showMessageDialog(this, "Vous avez gagné");
    }

    /**
     * Renvoie vrai si pacman finit le niveau, sinon renvoie faux
     * @return : vrai si pacman finit le niveau, sinon renvoie faux
     */
    @Override
    protected boolean aGagne() {
        return false;
    }

    /**
     * Renvoie vrai si pacman n'a plus de vie, sinon renvoie faux
     * @return : vrai si pacman n'a plus de vie, sinon renvoie faux
     */
    @Override
    protected boolean aPerdu() {
       return false;
    }
    
}
