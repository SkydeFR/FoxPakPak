package foxpakpak.main.Game.Entites;

import foxpakpak.main.Game.Consumables.*;
import static foxpakpak.main.Game.Entites.Direction.AUCUNE;
import iut.Jeu;
import iut.Objet;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class PacMan extends Entite implements KeyListener {
    
    private Jeu g;
    private int vies;
    private int score;
    private boolean win;
    private long timer, elapsed;
    private boolean vDir;
    private Direction dA, dirTmp;
    private Objet tmpObjet;

    public PacMan(Jeu _g, String _nom, int _x, int _y) {
        super(_g, _nom, _x, _y);
        this.g = _g;
        this.vies = 3;
        this.score = 0;
        this.win = false;
        this.timer = 0;
        this.elapsed = 0;
        this.dirTmp = AUCUNE;
        setSpawn(_x, _y);
        dA = AUCUNE;
        vDir = true;
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
                switch (getDirection()) {
                    case HAUT:
                        deplacerXY(0, vitesse);
                        break;

                    case BAS:
                        deplacerXY(0, -vitesse);
                        break;

                    case DROITE:
                        deplacerXY(-vitesse, 0);
                        break;

                    case GAUCHE:
                        deplacerXY(vitesse, 0);
                        break;
                }
                setDirection(dirTmp);
                vDir = true;
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
        elapsed += dt;
        if (vDir) {
            dirTmp = dA;
            vDir = false;
        }
        if (elapsed > timer+80) {
            dirTmp = getDirection();
            elapsed = timer;
            setDirection(dA);
        }
    }

    public void perdreVie() {
        if (vies>0) {
            vies--;
            spawn();
        }
    }
    
    public int getVie() {
        return vies;
    }
    
    public int getScore() {
        return score;
    }
    
    public boolean getWin() {
        return win;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch(e.getKeyCode())
        {
            case KeyEvent.VK_LEFT:
                setDirection(Direction.GAUCHE);
                dA = Direction.GAUCHE;
                break;

            case KeyEvent.VK_RIGHT:
                setDirection(Direction.DROITE);
                dA = Direction.DROITE;
                break;

            case KeyEvent.VK_UP:
                setDirection(Direction.HAUT);
                dA = Direction.HAUT;
                break;

            case KeyEvent.VK_DOWN:
                setDirection(Direction.BAS);
                dA = Direction.BAS;
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
