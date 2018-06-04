/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foxpakpak.main.game.map.cases;

/**
 * Porte pour cage a fantomes
 * @author Ange Pagel
 */
public class Door extends Case {
    
    public Door(int x, int y) {
        super(x, y, TypeCase.DOOR);
    }
    
    public void openDoor(boolean bool) {
        setFranchissable(bool);
    }
    
}
