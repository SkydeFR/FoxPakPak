/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foxpakpak.main;

import foxpakpak.main.game.Game;

/**
 *
 * @author jp032952
 */
public class FoxPakPak {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String title = "TheFoxPakPak";
        int width = 720;
        int height = 400;
        int scale = 2;        
        
        Game myFoxPakPak = new Game(width*scale, height*scale, title);
        myFoxPakPak.jouer();
    }
    
}
