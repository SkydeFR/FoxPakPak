/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foxpakpak.main.game.entites.characters;

import iut.Jeu;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Pacman
 * @author jp032952
 */
public class Pacman extends Character implements KeyListener{
    
    /**
     * Construction d'un pacman
     * @param g : l'interface graphique
     * @param nom : le nom du pacman
     * @param x : coordonnee x du pacman
     * @param y : coordonnee y du pacman
     */
    public Pacman(Jeu g, String nom, int x, int y, int v) {
        super(g, nom, x, y, v);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch(e.getKeyCode())
        {
            case KeyEvent.VK_LEFT:
                this.deplacerXY(-1, 0);
                break;
            case KeyEvent.VK_RIGHT:
                this.deplacerXY(+1, 0);
                break;
            case KeyEvent.VK_UP:
                this.deplacerXY(0, -1);
                break;
            case KeyEvent.VK_DOWN:
                this.deplacerXY(0, 1);
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }
    
}
