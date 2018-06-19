/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foxpakpak.main.Game;

import static foxpakpak.main.Game.Menus.*;

import foxpakpak.main.Game.Entites.*;
import foxpakpak.main.game.Level.Level;
import foxpakpak.main.AudioThread;
import foxpakpak.main.Game.Level.Cases.Case;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 * Jeu
 * @author jp032952
 */
public class Game extends iut.Jeu implements MouseListener, MouseMotionListener {
    
    private Menus menu; // Menu a afficher
    private int action; // Action a effectuer dans le menu principal
    private boolean newGame;
    
    private Level level;
    private PacMan player;
    
    private Ghost blinky;
    private Ghost pinky;
    private Ghost inky;
    private Ghost clyde;
    
    /**
     * Constructeur du jeu
     * @param width : la largeur du jeu
     * @param height : la hauteur du jeu
     * @param title : le titre du jeu
     */
    public Game(int width, int height, String title) {
        super(width, height, title);
        this.setLocation(5, 5); // On centre l'interface graphique
        this.ajouteEcouteurSouris(this); // On ecoute la souris
        this.menu = PRINCIPAL; // Menu par defaut = menu principal
        this.newGame = true;
    }
    
    /**
     * Creation des objets en jeu
     */
    @Override
    protected void creeObjets() {
        this.level = new Level();
        this.player = new PacMan(this,"Sprites/PacMan/normal/PacMan_d1", 32+1, 32*4+6);
        this.blinky = new Ghost_Blinky(this,"Sprites/Ghosts/Blinky", 32*15+1, 32*12);
        this.pinky = new Ghost_Pinky(this,"Sprites/Ghosts/Pinky", 32*15+1, 32*13+9);
        this.inky = new Ghost_Inky(this,"Sprites/Ghosts/Inky", 32*15+1, 32*13+9+18);
        this.clyde = new Ghost_Clyde(this,"Sprites/Ghosts/Clyde", 32*15+1, 32*13+18+18);    
        AudioThread mySound = new AudioThread("Music/background_music");
        Thread t = new Thread(mySound);
        t.start();
    }

    /**
     * Dessine l'arriere plan du jeu
     * @param g : l'interface graphique
     */
    @Override
    protected void dessinerArrierePlan(Graphics g) {
        /* On affiche le curseur */
        Cursor cursor = Cursor.getDefaultCursor();
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
                if (action == 1) {
                    g.draw3DRect(xCoord, yCoord, 400, 100, false);
                    g.fill3DRect(xCoord, yCoord, 400, 100, false);
                } else {
                    g.draw3DRect(xCoord, yCoord, 400, 100, true);
                    g.fill3DRect(xCoord, yCoord, 400, 100, true);
                }
                /* --- */
                g.setColor(new Color(0,0,100,255));
                g.setFont(new Font("TimesRoman", Font.PLAIN, 50));
                xCoord = largeur()/2 - 200 + 30;
                yCoord = hauteur()/2 - 100 + 65;
                g.drawString("Nouvelle Partie",xCoord,yCoord);
                
                /* Afficher BOUTTON_02 */
                xCoord = largeur()/2 - 200;
                yCoord = hauteur()/2 + 50;
                g.setColor(Color.DARK_GRAY);
                if (action == 2) {
                    g.draw3DRect(xCoord, yCoord, 400, 100, false);
                    g.fill3DRect(xCoord, yCoord, 400, 100, false);
                } else {
                    g.draw3DRect(xCoord, yCoord, 400, 100, true);
                    g.fill3DRect(xCoord, yCoord, 400, 100, true);
                }
                /* --- */
                g.setColor(new Color(100,0,0,255));
                g.setFont(new Font("TimesRoman", Font.PLAIN, 50));
                xCoord = largeur()/2 - 200 + 120;
                yCoord = hauteur()/2 + 50 + 65;
                g.drawString("Quitter",xCoord,yCoord);
                
                /* Lors d'un clic sur le boutton 01 */
                if (action == 1) {
                    action = 10; // Permet d'afficher le nouvel etat du bouton
                } else if (action == 10) {
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException ex) {
                        System.out.println(ex);
                    }
                    menu = GAME; //Nouvelle partie : on affiche le jeu
                    newGame = true;
                }
                
                /* Lors d'un clic sur le boutton 02 */
                if (action == 2) {
                    action = 20; // Permet d'afficher le nouvel etat du bouton
                } else if (action == 20) {
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException ex) {
                        System.out.println(ex);
                    }
                    System.exit(0); //Quitter : on quitte le jeu
                }
                break;
            case GAME :
                /* Afficher BACKGROUND */
                g.setColor(Color.BLACK);
                g.fillRect(0, 0, largeur(), hauteur());
                
                /* Générer le niveau */
                if (newGame) {
                    this.ajouteEcouteurClavier(player);
                    this.level.generateLevel(this, "res\\Levels\\lvl_1.txt");
                    this.ajouter(blinky);
                    this.ajouter(pinky);
                    this.ajouter(inky);
                    this.ajouter(clyde);
                    this.ajouter(player);
                    newGame = false;
                }
                
                /* Afficher panel joueur */
                g.setColor(Color.BLACK);
                g.fillRect(0, 0, largeur(), 32*2);
                g.setColor(Color.WHITE);
                g.drawRect(0, 0, largeur(), 32*2-1);
                
                /* Afficher vies */
                g.setColor(Color.ORANGE);
                g.setFont(new Font("TimesRoman", Font.PLAIN, 20));
                g.drawString("Vie restantes : ",40,40);
                if (player.getVie() > 1) {
                    g.setColor(Color.GREEN);                  
                } else {
                    g.setColor(Color.RED); 
                }
                g.setFont(new Font("TimesRoman", Font.PLAIN, 18));
                g.drawString(String.valueOf(player.getVie()),175,40);
                
                /* Afficher niveau */
                g.setColor(Color.ORANGE);
                g.setFont(new Font("TimesRoman", Font.PLAIN, 20));
                g.drawString("Niveau : ",200+40,40);
                g.setColor(Color.BLUE);
                g.setFont(new Font("TimesRoman", Font.PLAIN, 18));
                g.drawString(String.valueOf(player.getLvl()),205+110,40);
                
                /* Afficher score */
                g.setColor(Color.ORANGE);
                g.setFont(new Font("TimesRoman", Font.PLAIN, 20));
                g.drawString("Score : ",340+40,40);
                g.setColor(Color.YELLOW);
                g.setFont(new Font("TimesRoman", Font.PLAIN, 18));
                g.drawString(String.valueOf(player.getScore()),342+110,40);
                break;
            default :
                System.out.println("Type de menu non implémenté");
        }
    }
    
    public void newLevel(int level) {
        for (Case c : this.level.getCases()) {
            this.supprimer(c);
        }
        player.spawn();
        blinky.spawn();
        clyde.spawn();
        inky.spawn();
        pinky.spawn();
        this.level.generateLevel(this, "res\\Levels\\lvl_"+level+".txt");
    }
    
    public int getNbConsumables() {
        return this.level.getNbConsumables();
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
                    action = 1;
                } else if (onButton02) {
                    action = 2;
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
    
    public void changeImmunityState(String name, boolean state) {
        switch (name) {
            case "GHOST_BLINKY":
                blinky.setImmunityState(state);
                break;
            case "GHOST_CLYDE":
                clyde.setImmunityState(state);
                break;
            case "GHOST_INKY":
                inky.setImmunityState(state);
                break;
            case "GHOST_PINKY":
                pinky.setImmunityState(state);
                break;
        }
    }
    
    public Boolean checkImmunityState(String name) {
        switch (name) {
            case "GHOST_BLINKY":
                return blinky.getImmunityState();
            case "GHOST_CLYDE":
                return clyde.getImmunityState();
            case "GHOST_INKY":
                return inky.getImmunityState();
            case "GHOST_PINKY":
                return pinky.getImmunityState();
        }
        return null;
    }
    
    public void eatGhost(String name) {
        switch (name) {
            case "GHOST_BLINKY":
                blinky.spawn();
                break;
            case "GHOST_CLYDE":
                clyde.spawn();
                break;
            case "GHOST_INKY":
                inky.spawn();
                break;
            case "GHOST_PINKY":
                pinky.spawn();
                break;
        }
    }
    
    /**
     * Fonction appelee lorsque pacman n'a plus de vie
     */
    @Override
    protected void perdu() {
        JOptionPane.showMessageDialog(this, "Vous avez perdu !\nScore final : "+player.getScore());
        System.exit(0);
    }

    /**
     * Fonction appelee lorsque pacman finit les 3 premiers niveaux !
     */
    @Override
    protected void gagne() {
        JOptionPane.showMessageDialog(this, "Vous avez gagné !\nVie restantes : "+player.getVie()+"\nScore final : "+player.getScore());
        System.exit(0);
    }

    /**
     * Renvoie vrai si pacman finit le niveau, sinon renvoie faux
     * @return : vrai si pacman finit le niveau, sinon renvoie faux
     */
    @Override
    protected boolean aGagne() {
        return player.getWin();
    }

    /**
     * Renvoie vrai si pacman n'a plus de vie, sinon renvoie faux
     * @return : vrai si pacman n'a plus de vie, sinon renvoie faux
     */
    @Override
    protected boolean aPerdu() {
       return player.getVie()==0;
    }
    
    /**
     * Fonction appellee lors d'un pressement d'un bouton de la souris
     * @param e : l'evenement souris
     */
    @Override
    public void mousePressed(MouseEvent e) {  
        
    }
    
    /**
     * Fonction appellee lors d'un relachement d'un bouton de la souris
     * @param e : l'evenement souris
     */
    @Override
    public void mouseReleased(MouseEvent e) {
        
    }
    
    /**
     * Fonction appellee lorsque la souris entre sur l'interface graphique
     * @param e : l'evenement souris
     */
    @Override
    public void mouseEntered(MouseEvent e) {
        
    }
    
    /**
     * Fonction appellee lorsque la souris quitte l'interface graphique
     * @param e : l'evenement souris
     */
    @Override
    public void mouseExited(MouseEvent e) {
        
    }
    
    /**
     * Fonction appellee lors d'un glisse-deposer de souris
     * @param e : l'evenement souris
     */
    @Override
    public void mouseDragged(MouseEvent e) {
        
    }
    
    /**
     * Fonction appellee lors d'un mouvement de souris
     * @param e : l'evenement souris
     */
    @Override
    public void mouseMoved(MouseEvent e) {
        
    }
    
}
