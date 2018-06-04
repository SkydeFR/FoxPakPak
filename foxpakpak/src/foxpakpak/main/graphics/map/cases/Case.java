/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foxpakpak.main.graphics.map.cases;

/**
 * Case
 * @author jp032952
 */
public abstract class Case {
    
    private Coordinates coord;
    private TypeCase type;
    private boolean franchissable;
        
    
    /**
     * Constructeur
     * @param x Coordonnée x de la case
     * @param y Coordonnée y de la case
     * @param type Type de la classe
     */
    public Case(int x, int y, TypeCase type) {
        this.coord = new Coordinates(x,y);
        this.type = type;
    }
    
    
    /**
     * Constructeur
     * @param coord Coordonnées de la case
     * @param type Type de la case
     */
    public Case(Coordinates coord, TypeCase type) {
        this.coord = coord;
        this.type = type;
    }
    
    public TypeCase getType() {
        return type;
    }
    
    
    public Coordinates getCoord() {
        return coord;
    }
    public int getX() {
        return coord.getX();
    }
    public int getY() {
        return coord.getY();
    }
    
    
    public boolean isFranchissable() {
        return franchissable;
    }
    public void setFranchissable(boolean bool) {
        franchissable = bool;
    }
}
