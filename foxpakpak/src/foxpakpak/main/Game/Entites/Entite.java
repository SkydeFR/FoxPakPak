package foxpakpak.main.Game.Entites;

import static foxpakpak.main.Game.Entites.Direction.BAS;
import static foxpakpak.main.Game.Entites.Direction.HAUT;
import iut.Jeu;
import iut.Objet;
import iut.ObjetTouchable;

abstract class Entite extends ObjetTouchable {
    
    int vitesse;
    private Direction direction;
    boolean collisionMur;
    
    /**
     * Construction d'un personnage
     * @param g : l'interface graphique
     * @param nom : le nom du personnage
     * @param x : coordonnee x du personnage
     * @param y : coordonnee y du personnage
     */
    public Entite(Jeu g, String nom, int x, int y) {
        super(g, nom, x, y);
        this.vitesse = 2;
        this.direction = Direction.DROITE;
    }
    
    public void setCollisionMur(boolean collisionMur) {
        this.collisionMur = collisionMur;
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
    
    @Override
    public void effetCollision(Objet objet) {

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
    
}
