package foxpakpak.main.Game.Entites;

import foxpakpak.main.Game.Consumables.*;
import iut.Jeu;
import iut.Objet;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class PacMan extends Entite implements KeyListener {
    
    private Jeu g;
    private int vies;
    private int score;
    private Objet tmpObjet;

    public PacMan(Jeu _g, String _nom, int _x, int _y) {
        super(_g, _nom, _x, _y);
        this.g = _g;
        this.vies = 3;
        this.score = 0;
    }
    
    public void mangerConsommable(Consommable o) {
        if (tmpObjet != o) {
            tmpObjet = o;
            g.supprimer(o);
            score += o.getScorePts();
        }
    }

    @Override
    public void effetCollision(Objet o) {
        switch (o.getTypeObjet()) {
            case "GHOST":
                perdreVie();
                break;
                
            case "MUR":
                setCollisionMur(true);
                switch (getDirection()) {
                    case HAUT:
                        deplacerXY(0, 1);
                        break;

                    case BAS:
                        deplacerXY(0, -1);
                        break;

                    case DROITE:
                        deplacerXY(-1, 0);
                        break;

                    case GAUCHE:
                        deplacerXY(1, 0);
                        break;
                }
                break;
                
            case "DOT":
                mangerConsommable((Dot)o);
                break;
                
            case "SUPERDOT":
                mangerConsommable((SuperDot)o);
                break;
                
            case "FRUIT":
                mangerConsommable((Fruit)o);
                break;
        }
    }
    
    @Override
    public void evoluer(long dt) {       
        if (!collisionMur) {
            this.vitesse = 2;
            switch (getDirection()) {
                case HAUT:
                    deplacerXY(0, -vitesse);
                    break;

                case BAS:
                    deplacerXY(0, vitesse);
                    break;

                case DROITE:
                    deplacerXY(vitesse, 0);
                    break;

                case GAUCHE:
                    deplacerXY(-vitesse, 0);
                    break;
            }
        }
        collisionMur = false;
    }

    public void perdreVie() {
        if (vies>0) {
            vies--;
            //spawn();
        }
        System.out.println("Vie restantes : "+vies);
    }
    
    public int getVie() {
        return vies;
    }
    
    public int getScore() {
        return score;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch(e.getKeyCode())
        {
            case KeyEvent.VK_LEFT:
                setDirection(Direction.GAUCHE);
                break;

            case KeyEvent.VK_RIGHT:
                setDirection(Direction.DROITE);
                break;

            case KeyEvent.VK_UP:
                setDirection(Direction.HAUT);
                break;

            case KeyEvent.VK_DOWN:
                setDirection(Direction.BAS);
                break;
        }
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
    
    }
    
    @Override
    public void keyReleased(KeyEvent e) {
    
    }
    
    @Override
    public String getTypeObjet() {
        return "PACMAN";
    }
}
