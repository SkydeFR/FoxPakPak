package foxpakpak.main.game1.entites1;

import static foxpakpak.main.game1.entites1.Direction.*;
import iut.Jeu;
import iut.Objet;
import iut.ObjetTouchable;

abstract class Entite extends ObjetTouchable {
    
    protected int xSpawn, ySpawn;
    protected int vitesse;
    protected Direction direction, directionTMP;
    protected boolean collisionMur;
    protected long timer, elapsed;
    protected boolean vDir;
    protected Direction dA, dirTmp;
    
    /**
     * Construction d'un personnage
     * @param g : l'interface graphique
     * @param nom : le nom du personnage
     * @param x : coordonnee x du personnage
     * @param y : coordonnee y du personnage
     */
    public Entite(Jeu g, String nom, int x, int y) {
        super(g, nom, x, y);
        this.vitesse = 1;
        this.direction = AUCUNE;
        this.directionTMP = AUCUNE;
    }
    
    public void setCollisionMur(boolean collisionMur) {
        this.collisionMur = collisionMur;
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
        timer += dt;
        if (vDir) {
            dirTmp = dA;
            vDir = false;
        }
        if (elapsed > timer+200) {
            dirTmp = getDirection();
            elapsed = timer;
            setDirection(dA);
        }
    }

    @Override
    public void effetCollision(Objet o) {
        switch (o.getTypeObjet()) {
                
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
        }
    }
    
    public int getVitesse() {
        return vitesse;
    }
    
    public void setVitesse(int vitesse) {
        this.vitesse = vitesse;
    }
    
    public void setDirection(Direction direction) {
        this.direction = direction;
    }
    
    public Direction getDirection() {
        return this.direction;
    }
    
    public void spawn() {
        setDirection(AUCUNE);
        deplacerXY(xSpawn-posGauche(), ySpawn-posHaute());
    }
    
    public void setSpawn(int x, int y) {
        xSpawn = x;
        ySpawn = y;
    }
    

    
}
