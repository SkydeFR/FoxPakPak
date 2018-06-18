/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foxpakpak.main;

import foxpakpak.main.Game.Game;

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
        int width = 1024;
        int height = 768;
        int scale = 1;
        
        Game myFoxPakPak = new Game(width*scale, height*scale, title);
        myFoxPakPak.jouer();
    }
    
    /*
    A rendre :
    - groupe
    - zip avec :
        - le code avec javadoc
        - executable
        - doc utilisateur
        - doc installation
    */
    
}
