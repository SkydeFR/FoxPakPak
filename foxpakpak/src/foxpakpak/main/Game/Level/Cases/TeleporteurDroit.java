package foxpakpak.main.Game.Level.Cases;

import iut.Jeu;

public class TeleporteurDroit extends Case {

    public TeleporteurDroit(Jeu g, String nom, int x, int y) {
        super(g, nom, x, y);
    }

    @Override
    public String getTypeObjet() {
        return "TELEPORTEURDROIT";
    }

}
