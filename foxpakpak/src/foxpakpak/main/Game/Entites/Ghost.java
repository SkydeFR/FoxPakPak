package foxpakpak.main.Game.Entites;

import static foxpakpak.main.Game.Entites.Direction.*;
import iut.Jeu;

public class Ghost extends Entite {

    public Ghost(Jeu g, String nom, int x, int y) {
        super(g, nom, x, y);
        setDirection(AUCUNE);
        setVitesse(2);
    }

    @Override
    public String getTypeObjet() {
        return "GHOST";
    }
    
}
