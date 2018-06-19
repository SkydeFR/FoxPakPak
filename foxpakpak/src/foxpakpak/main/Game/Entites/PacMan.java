package foxpakpak.main.Game.Entites;

import foxpakpak.main.Game.Consumables.*;
import static foxpakpak.main.Game.Entites.Direction.*;
import iut.Jeu;
import iut.Objet;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class PacMan extends Entite implements KeyListener {
    
    private Jeu g;
    private int vies;
    private int score;
    private int lvl;
    private boolean win;
    private boolean superDot;
    private double tSuperDot;
    private Objet tmpObjet;
    private double tSprite, delaySprite;
    private int selectedSprite;

    public PacMan(Jeu _g, String _nom, int _x, int _y) {
        super(_g, _nom, _x, _y);
        this.g = _g;
        this.vies = 3;
        this.score = 0;
        this.lvl = 1;
        this.win = false;
        this.superDot = false;
        this.tSuperDot = 0;
        this.timer = 0;
        this.elapsed = 0;
        this.dA = AUCUNE;
        this.vDir = true;
        this.dirTmp = AUCUNE;
        setDirection(AUCUNE);
        setVitesse(2);
        setSpawn(_x, _y);
        this.tSprite = 0;
        this.delaySprite = 0;
        this.selectedSprite = 1;
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
                setVitesse(3);
                superDot = true;
                tSuperDot = 10000;
                break;
                
            case "FRUIT":
                mangerConsommable((Fruit)o);
                break;
        }
    }
    
    @Override
    public void evoluer(long dt) {
        tSprite += dt;
        Boolean animation = tSprite > delaySprite+175;
        if (getDirection() != null && animation) {
            switch (getDirection()) {
                case AUCUNE:
                case DROITE:
                    delaySprite = tSprite;
                    selectedSprite++;
                    if (selectedSprite>3) {
                        selectedSprite = 1;
                    }
                    if (superDot) {
                        this.changeSprite("Sprites/PacMan/super/PacMan_d"+selectedSprite);
                    } else {
                        this.changeSprite("Sprites/PacMan/normal/PacMan_d"+selectedSprite);
                    }
                    break;
                case GAUCHE:
                    delaySprite = tSprite;
                    selectedSprite++;
                    if (selectedSprite>3) {
                        selectedSprite = 1;
                    }
                    if (superDot) {
                        this.changeSprite("Sprites/PacMan/super/PacMan_g"+selectedSprite);
                    } else {
                        this.changeSprite("Sprites/PacMan/normal/PacMan_g"+selectedSprite);
                    }
                    break;
                case HAUT:
                    delaySprite = tSprite;
                    selectedSprite++;
                    if (selectedSprite>3) {
                        selectedSprite = 1;
                    }
                    if (superDot) {
                        this.changeSprite("Sprites/PacMan/super/PacMan_h"+selectedSprite);
                    } else {
                        this.changeSprite("Sprites/PacMan/normal/PacMan_h"+selectedSprite);
                    }
                    break;
                case BAS:
                    delaySprite = tSprite;
                    selectedSprite++;
                    if (selectedSprite>3) {
                        selectedSprite = 1;
                    }
                    if (superDot) {
                        this.changeSprite("Sprites/PacMan/super/PacMan_b"+selectedSprite);
                    } else {
                        this.changeSprite("Sprites/PacMan/normal/PacMan_b"+selectedSprite);
                    }
                    break;
            }
        }
        
        if (superDot) {
            tSuperDot -= dt;
            if (tSuperDot <= 0) {
                setVitesse(2);
                superDot = false;
                tSuperDot = 0;
            }
        }
        
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
    
    public int getLvl() {
        return lvl;
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
