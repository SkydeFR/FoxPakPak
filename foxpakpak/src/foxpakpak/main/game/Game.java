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
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JOptionPane;

/**
 * Jeu
 * @author jp032952
 */
public class Game extends iut.Jeu implements MouseListener, MouseMotionListener {
    
    /**
     *
     */
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
        this.ajouteEcouteurSouris(this); //On ecoute la souris
        Game.menu = PRINCIPAL; //Menu par defaut = menu principal
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
        /* On affiche le curseur */
        Cursor cursor=Cursor.getDefaultCursor();
        this.setCursor(cursor);
        
        switch (menu) {
            case PRINCIPAL :
                int xCoord;
                int yCoord;
                
                /* Afficher BACKGROUND */
                g.setColor(Color.BLACK);
                g.fillRect(0, 0, largeur(), hauteur());
                
                /* Afficher TITRE */
                g.setColor(Color.ORANGE);
                g.setFont(new Font("TimesRoman", Font.PLAIN, 100));
                xCoord = largeur()/2 - 330;
                yCoord = hauteur()/2 - 200;
                g.drawString("TheFoxPakpak",xCoord,yCoord);
                
                /* Afficher BOUTTON_01 */
                xCoord = largeur()/2 - 200;
                yCoord = hauteur()/2 - 100;
                g.setColor(Color.DARK_GRAY);
                g.draw3DRect(xCoord, yCoord, 400, 100, true);
                g.fill3DRect(xCoord+1, yCoord+1, 400-1, 100-1, true);
                /* --- */
                g.setColor(new Color(0,0,75,255));
                g.setFont(new Font("TimesRoman", Font.PLAIN, 50));
                xCoord = largeur()/2 - 200 + 30;
                yCoord = hauteur()/2 - 100 + 65;
                g.drawString("Nouvelle Partie",xCoord,yCoord);
                
                /* Afficher BOUTTON_02 */
                xCoord = largeur()/2 - 200;
                yCoord = hauteur()/2 + 50;
                g.setColor(Color.DARK_GRAY);
                g.draw3DRect(xCoord, yCoord, 400, 100, true);
                g.fill3DRect(xCoord+1, yCoord+1, 400-1, 100-1, true);
                /* --- */
                g.setColor(new Color(0,0,75,255));
                g.setFont(new Font("TimesRoman", Font.PLAIN, 50));
                xCoord = largeur()/2 - 200 + 120;
                yCoord = hauteur()/2 + 50 + 65;
                g.drawString("Quitter",xCoord,yCoord);
                break;
            case GAME :
                /* Afficher BACKGROUND */
                g.setColor(Color.BLACK);
                g.fillRect(0, 0, largeur(), hauteur());
                break;
            default :
                System.out.println("Type de menu non implémenté");
        }
    }
    
    /**
     * Fonction appelle lors d'un clic souris
     * @param e : l'evenement souris
     */
    @Override
    public void mouseClicked(MouseEvent e) {
        switch (e.getButton()) {
            case MouseEvent.BUTTON1 :
                /* Verifie si l'on a clique sur un bouton du menu */
                boolean onButton01 = e.getX() > largeur()/2 - 200 && e.getX() < largeur()/2 - 200 + 400 &&
                                    e.getY() > hauteur()/2 - 100 && e.getY() < hauteur()/2 - 100 + 100;
                boolean onButton02 = e.getX() > largeur()/2 - 200 && e.getX() < largeur()/2 - 200 + 400 &&
                                    e.getY() > hauteur()/2 + 50 && e.getY() < hauteur()/2 + 50 + 100;
                if (onButton01) {
                    menu = GAME; //Nouvelle partie : on affiche le jeu
                } else if (onButton02) {
                    System.exit(0); //Quitter : on quitte le jeu
                }
                break;
            case MouseEvent.BUTTON2 :
                //System.out.println("Click 2");
                break;
            case MouseEvent.BUTTON3 :
                //System.out.println("Click 3");
                break;
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
    
    /**
     * Fonction appelle lors d'un pressement d'un bouton de la souris
     * @param e : l'evenement souris
     */
    @Override
    public void mousePressed(MouseEvent e) {  
        
    }
    
    /**
     * Fonction appelle lors d'un relachement d'un bouton de la souris
     * @param e : l'evenement souris
     */
    @Override
    public void mouseReleased(MouseEvent e) {
        
    }
    
    /**
     * Fonction appelle lorsque la souris entre sur l'interface graphique
     * @param e : l'evenement souris
     */
    @Override
    public void mouseEntered(MouseEvent e) {
        
    }
    
    /**
     * Fonction appelle lorsque la souris quitte l'interface graphique
     * @param e : l'evenement souris
     */
    @Override
    public void mouseExited(MouseEvent e) {
        
    }
    
    /**
     * Fonction appelle lors d'un glisse-deposer de souris
     * @param e : l'evenement souris
     */
    @Override
    public void mouseDragged(MouseEvent e) {
        
    }
    
    /**
     * Fonction appelle lors d'un mouvement de souris
     * @param e : l'evenement souris
     */
    @Override
    public void mouseMoved(MouseEvent e) {
        
    }
    
}
