package foxpakpak.main.Game.Entites;

import iut.Jeu;

public class Ghost extends Entite {

    private boolean edible;


    public Ghost(Jeu g, String nom, int x, int y) {
        super(g, nom, x, y);
        setVitesse(1);
    }


    @Override
    public String getTypeObjet() {
        return "GHOST";
    }


}
