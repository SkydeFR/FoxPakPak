/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foxpakpak.main;

import iut.Audio;

/**
 *
 * @author jp032952
 */
public class AudioThread implements Runnable {

    private String filePath;

    public AudioThread(String _filePath) {
        this.filePath = _filePath;
    }
    
    @Override
    public void run() {
        Audio myAudio = new Audio(filePath);
        myAudio.run();
    }
}
