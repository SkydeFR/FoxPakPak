package foxpakpak.main.Game.Entites;

import static foxpakpak.main.Game.Entites.Direction.*;
import iut.Jeu;

public class Ghost extends Entite {
    
    protected boolean immunityState;
    protected int tSprite, delaySprite;
    protected boolean selectedSprite;
    private boolean reborn = false;    
    
    public Ghost(Jeu g, String nom, int x, int y) {
        super(g, nom, x, y);
        setDirection(AUCUNE);
        setVitesse(2);
        this.immunityState = true;
        this.tSprite = 0;
        this.delaySprite = 0;
        this.selectedSprite = true;
    }

    @Override
    public String getTypeObjet() {
        return "GHOST";
    }
    
    public void setImmunityState(boolean newState) {
        immunityState = newState;
    }
    
    public boolean getImmunityState() {
        return immunityState;
    }
    
    public void setReborn(boolean newValue){
        this.reborn = newValue;
    }

    public boolean isReborn() {
        return reborn;
    }
    
    @Override
    public void spawn() {
        setDirection(AUCUNE);
        deplacerXY(xSpawn-posGauche(), ySpawn-posHaute());
        this.setReborn(true);
        this.setImmunityState(true);
    }
    
}
