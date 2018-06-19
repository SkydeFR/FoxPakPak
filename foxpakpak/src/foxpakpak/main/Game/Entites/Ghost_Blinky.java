package foxpakpak.main.Game.Entites;

import static foxpakpak.main.Game.Entites.Direction.*;
import iut.Jeu;

public class Ghost_Blinky extends Ghost {

    public Ghost_Blinky(Jeu _g, String _nom, int _x, int _y) {
        super(_g, _nom, _x, _y);
        this.timer = 0;
        this.elapsed = 0;
        this.dA = AUCUNE;
        this.vDir = true;
        this.dirTmp = AUCUNE;
        setDirection(AUCUNE);
        setVitesse(1);
        setSpawn(_x, _y);
    }

}
