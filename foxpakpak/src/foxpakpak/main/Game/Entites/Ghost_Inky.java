package foxpakpak.main.Game.Entites;

import static foxpakpak.main.Game.Entites.Direction.DROITE;
import static foxpakpak.main.Game.Entites.Direction.HAUT;
import iut.Jeu;

public class Ghost_Inky extends Ghost {

    public Ghost_Inky(Jeu _g, String _nom, int _x, int _y) {
        super(_g, _nom, _x, _y);
        this.timer = 0;
        this.elapsed = 0;
        this.dA = DROITE;
        this.vDir = true;
        this.dirTmp = DROITE;
        setDirection(HAUT);
        setVitesse(1);
        setSpawn(_x, _y);
        //directionsEnMemoire[0]=HAUT;
    }
    
    
    
    @Override
    public void evoluer(long dt) { 
        System.out.println("blabla");
        if (!collisionMur) {
            this.vitesse = 1;
            switch (getDirection()) {
                case HAUT:
                    deplacerXY(0, -vitesse);
                    break;

                case DROITE:
                    deplacerXY(vitesse, 0);
                    break;

                case BAS:
                    deplacerXY(0, vitesse);
                    break;

                case GAUCHE:
                    deplacerXY(-vitesse, 0);
                    break;
            }
        }
        collisionMur = false;
    } 
}
