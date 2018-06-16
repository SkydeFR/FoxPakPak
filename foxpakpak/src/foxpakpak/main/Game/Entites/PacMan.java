package foxpakpak.main.Game.Entites;

import iut.Jeu;
import iut.Objet;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class PacMan extends Entite implements KeyListener {

    private int vies;


    public PacMan(Jeu g, String nom, int x, int y) {
        super(g, nom, x, y);
        this.vies = 3;
    }





    @Override
    public void effetCollision(Objet o) {
        if ("GHOST".equals(o.getTypeObjet())) {
            perdreVie();
        }

        if ("MUR".equals(o.getTypeObjet())) {
            setCollisionMur(true);
            switch (getDirection()) {
                case HAUT:
                    deplacerXY(0, 1);
                    break;

                case BAS:
                    deplacerXY(0, -1);
                    break;

                case DROITE:
                    deplacerXY(-1, 0);
                    break;

                case GAUCHE:
                    deplacerXY(1, 0);
                    break;
            }
        this.setVitesse(0);
        }
    }

    public void perdreVie() {
        if (vies>0) {
            vies--;
            //spawn();
        }
        System.out.println("Vie restantes : "+vies);
    }






    @Override
    public void keyPressed(KeyEvent e) {
        switch(e.getKeyCode())
        {
            case KeyEvent.VK_LEFT:
                setDirection(Direction.GAUCHE);
                break;

            case KeyEvent.VK_RIGHT:
                setDirection(Direction.DROITE);
                break;

            case KeyEvent.VK_UP:
                setDirection(Direction.HAUT);
                break;

            case KeyEvent.VK_DOWN:
                setDirection(Direction.BAS);
                break;
        }
    }


    @Override
    public void keyTyped(KeyEvent e) {}
    @Override
    public void keyReleased(KeyEvent e) {}






    @Override
    public String getTypeObjet() {
        return "PACMAN";
    }
}
