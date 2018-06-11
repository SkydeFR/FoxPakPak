/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foxpakpak.main.game.entites.characters;

import iut.Jeu;
import iut.Objet;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Pacman
 * @author jp032952
 */
public class Pacman extends Character implements KeyListener{
    
    private int score;
    private int life;
    private int xSpawn, ySpawn;
    
    /**
     * Construction d'un pacman
     * @param g : l'interface graphique
     * @param nom : le nom du pacman
     * @param x : coordonnee x du pacman
     * @param y : coordonnee y du pacman
     * @param v : la vitesse
     */
    public Pacman(Jeu g, String nom, int x, int y, int v) {
        super(g, nom, x, y, v);
        this.score = 0;
        this.life = 3;
        this.xSpawn = 350;
        this.ySpawn = 350;
        System.out.println("Vie restantes : "+life);
    }
    
    @Override
    public void effetCollision(Objet o) {
        if ("Ghost".equals(o.getTypeObjet())) {
            perdreVie();
        }
    }
    
    public void perdreVie() {
        if (life>0) {
            life--;
            spawn();
        }
        System.out.println("Vie restantes : "+life);
    }
    
    public int getLife() {
        return life;
    }
    
    public void spawn() {
        deplacerXY(xSpawn-milieuX(), ySpawn-milieuY());
    }
    
    public void setSpawn(int x, int y) {
        xSpawn = x;
        ySpawn = y;
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch(e.getKeyCode())
        {
            case KeyEvent.VK_LEFT:
                if(posGauche()>0) {
                    deplacerXY(-10, 0);
                }
                break;
            case KeyEvent.VK_RIGHT:
                if(posDroite()<leJeu().largeur()) {
                    deplacerXY(+10, 0);
                }
                break;
            case KeyEvent.VK_UP:
                if(posHaute()>0) {
                    deplacerXY(0, -10);
                }
                break;
            case KeyEvent.VK_DOWN:
                if(posBasse()<leJeu().hauteur()) {
                    deplacerXY(0, +10);
                }
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }

    @Override
    public String getTypeObjet() {
        return "Pacman";
    }
    
}
