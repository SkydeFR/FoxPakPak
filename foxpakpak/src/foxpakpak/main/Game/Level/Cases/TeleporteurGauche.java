package foxpakpak.main.Game.Level.Cases;

import iut.Jeu;

public class TeleporteurGauche extends Case {

    public TeleporteurGauche(Jeu g, String nom, int x, int y) {
        super(g, nom, x, y);
    }

    @Override
    public String getTypeObjet() {
        return "TELEPORTEURGAUCHE";
    }

}
