package foxpakpak.main.Game.Entites;

import static foxpakpak.main.Game.Entites.Direction.*;
import iut.Jeu;
import iut.Objet;

public class Ghost_Blinky extends Ghost {
    
    private int variableDeTravail = 1;
    private Direction directionsEnMemoire [] = {HAUT,null,null,null};
    private boolean prochainATraiter[] = {true,true,false,false};
    
    public Ghost_Blinky(Jeu _g, String _nom, int _x, int _y) {
        super(_g, _nom, _x, _y);
        this.timer = 0;
        this.elapsed = 0;
        this.dA = DROITE;
        this.vDir = true;
        this.dirTmp = DROITE;
        setDirection(HAUT);
        setVitesse(2);
        setSpawn(_x, _y);
        this.directionsEnMemoire[0]=HAUT;
    }
    
    @Override
    public void effetCollision(Objet o) {
        switch (o.getTypeObjet()) {
            case "MUR":
                switch (getDirection()) {
                    case HAUT:
                        deplacerXY(0, vitesse);
                        if (!antiBoucle()){
                            if (this.variableDeTravail == 1){
                                setDirection(DROITE);
                                if (this.prochainATraiter[0] == true){
                                    directionsEnMemoire[0] = DROITE;
                                    prochainATraiter[0] = false;
                                    prochainATraiter[2] = true;
                                } else{
                                    directionsEnMemoire[2] = DROITE;
                                    prochainATraiter[0] = true;
                                    prochainATraiter[2] = false;
                                }
                            }
                            else {
                                setDirection(GAUCHE);
                                if (this.prochainATraiter[1] == true){
                                    directionsEnMemoire[1] = GAUCHE;
                                    prochainATraiter[1] = false;
                                    prochainATraiter[3] = true;
                                } else{
                                    directionsEnMemoire[3] = GAUCHE;
                                    prochainATraiter[1] = true;
                                    prochainATraiter[3] = false;
                                }
                            }
                        } else {
                            if (this.variableDeTravail == 1){
                                setDirection(BAS);
                                if (this.prochainATraiter[0] == true){
                                    directionsEnMemoire[0] = BAS;
                                    prochainATraiter[0] = false;
                                    prochainATraiter[2] = true;
                                } else{
                                    directionsEnMemoire[2] = BAS;
                                    prochainATraiter[0] = true;
                                    prochainATraiter[2] = false;
                                }
                            } else {
                                setDirection(HAUT);
                                if (this.prochainATraiter[1] == true){
                                    directionsEnMemoire[1] = HAUT; //a voir si c'est gauche ou haut
                                    prochainATraiter[1] = false;
                                    prochainATraiter[3] = true;
                                } else{
                                    directionsEnMemoire[3] = HAUT;
                                    prochainATraiter[1] = true;
                                    prochainATraiter[3] = false;
                                }
                            }                            
                        } 
          
                        this.variableDeTravail = -1*this.variableDeTravail;  
                        break;

                    case BAS:
                        deplacerXY(0, -vitesse);
                        if (!antiBoucle()){
                            System.out.println("Pas de boucle");
                            if (this.variableDeTravail == 1){
                                setDirection(DROITE);
                                if (this.prochainATraiter[0] == true){
                                    directionsEnMemoire[0] = DROITE;
                                    prochainATraiter[0] = false;
                                    prochainATraiter[2] = true;
                                    System.out.println("droite 1");
                                } else{
                                    directionsEnMemoire[2] = DROITE;
                                    prochainATraiter[0] = true;
                                    prochainATraiter[2] = false;
                                    System.out.println("droite 2");
                                }
                            } else {
                                setDirection(GAUCHE);
                                if (this.prochainATraiter[1] == true){
                                    directionsEnMemoire[1] = GAUCHE;
                                    prochainATraiter[1] = false;
                                    prochainATraiter[3] = true;
                                    System.out.println("gauche 1");
                                } else{
                                    directionsEnMemoire[3] = GAUCHE;
                                    prochainATraiter[1] = true;
                                    prochainATraiter[3] = false;
                                    System.out.println("gauche 2");
                                }
                            }
                        } else {
                            System.out.println("Boucle");
                            if (this.variableDeTravail == 1){
                                setDirection(HAUT);
                                if (this.prochainATraiter[0] == true){
                                    directionsEnMemoire[0] = HAUT;
                                    prochainATraiter[0] = false;
                                    prochainATraiter[2] = true;
                                } else{
                                    directionsEnMemoire[2] = HAUT;
                                    prochainATraiter[0] = true;
                                    prochainATraiter[2] = false;
                                }
                            } else {
                                setDirection(BAS);
                                if (this.prochainATraiter[1] == true){
                                    directionsEnMemoire[1] = BAS; //a voir si c'est gauche ou haut
                                    prochainATraiter[1] = false;
                                    prochainATraiter[3] = true;
                                } else{
                                    directionsEnMemoire[3] = BAS;
                                    prochainATraiter[1] = true;
                                    prochainATraiter[3] = false;
                                }
                            }                            
                        } 
          
                        this.variableDeTravail = -1*this.variableDeTravail;  
                        break;

                    case DROITE:
                        deplacerXY(-vitesse, 0);
                        if (!antiBoucle()){
                            if (this.variableDeTravail == 1){
                                setDirection(HAUT);
                                if (this.prochainATraiter[0] == true){
                                    directionsEnMemoire[0] = HAUT;
                                    prochainATraiter[0] = false;
                                    prochainATraiter[2] = true;
                                } else{
                                    directionsEnMemoire[2] = HAUT;
                                    prochainATraiter[0] = true;
                                    prochainATraiter[2] = false;
                                }
                            } else {
                                setDirection(BAS);
                                if (this.prochainATraiter[1] == true){
                                    directionsEnMemoire[1] = BAS;
                                    prochainATraiter[1] = false;
                                    prochainATraiter[3] = true;
                                } else{
                                    directionsEnMemoire[3] = BAS;
                                    prochainATraiter[1] = true;
                                    prochainATraiter[3] = false;
                                }
                            }
                        } else {
                            if (this.variableDeTravail == 1){
                                setDirection(DROITE);
                                if (this.prochainATraiter[0] == true){
                                    directionsEnMemoire[0] = DROITE;
                                    prochainATraiter[0] = false;
                                    prochainATraiter[2] = true;
                                } else{
                                    directionsEnMemoire[2] = DROITE;
                                    prochainATraiter[0] = true;
                                    prochainATraiter[2] = false;
                                }
                            } else {
                                setDirection(GAUCHE);
                                if (this.prochainATraiter[1] == true){
                                    directionsEnMemoire[1] = GAUCHE; //a voir si c'est gauche ou haut
                                    prochainATraiter[1] = false;
                                    prochainATraiter[3] = true;
                                } else{
                                    directionsEnMemoire[3] = GAUCHE;
                                    prochainATraiter[1] = true;
                                    prochainATraiter[3] = false;
                                }
                            }                            
                        }                            


                        this.variableDeTravail = -1*this.variableDeTravail;  
                        break;

                    case GAUCHE:
                        deplacerXY(vitesse, 0);
                        if (!antiBoucle()){
                            if (this.variableDeTravail == 1){
                                setDirection(HAUT);
                                if (this.prochainATraiter[0] == true){
                                    directionsEnMemoire[0] = HAUT;
                                    prochainATraiter[0] = false;
                                    prochainATraiter[2] = true;
                                } else{
                                    directionsEnMemoire[2] = HAUT;
                                    prochainATraiter[0] = true;
                                    prochainATraiter[2] = false;
                                }
                            } else {
                                setDirection(BAS);
                                if (this.prochainATraiter[1] == true){
                                    directionsEnMemoire[1] = BAS;
                                    prochainATraiter[1] = false;
                                    prochainATraiter[3] = true;
                                } else{
                                    directionsEnMemoire[3] = BAS;
                                    prochainATraiter[1] = true;
                                    prochainATraiter[3] = false;
                                }
                            }
                        } else {
                            if (this.variableDeTravail == 1){
                                setDirection(GAUCHE);
                                if (this.prochainATraiter[0] == true){
                                    directionsEnMemoire[0] = GAUCHE;
                                    prochainATraiter[0] = false;
                                    prochainATraiter[2] = true;
                                } else{
                                    directionsEnMemoire[2] = GAUCHE;
                                    prochainATraiter[0] = true;
                                    prochainATraiter[2] = false;
                                }
                            } else {
                                setDirection(DROITE);
                                if (this.prochainATraiter[1] == true){
                                    directionsEnMemoire[1] = DROITE; //a voir si c'est gauche ou haut
                                    prochainATraiter[1] = false;
                                    prochainATraiter[3] = true;
                                } else{
                                    directionsEnMemoire[3] = DROITE;
                                    prochainATraiter[1] = true;
                                    prochainATraiter[3] = false;
                                }
                            }                            
                        }                            


                        this.variableDeTravail = -1*this.variableDeTravail;  
                        break;
                }
                //setDirection(dirTmp);
                //System.out.println(this.variableDeTravail);
                //System.out.println("A traiter : "+ prochainATraiter[0] + ", "+ prochainATraiter[1] + ", "+prochainATraiter[2] + ", "+prochainATraiter[3]);
                //System.out.println("Deplacement en mémoire : "+directionsEnMemoire[0] + ", "+directionsEnMemoire[1] + ", "+directionsEnMemoire[2] + ", "+directionsEnMemoire[3]);
                vDir = true;
                break;
        }
    }    
     
    @Override
    public void evoluer(long dt) {
        tSprite += dt;
        Boolean animation = tSprite > delaySprite+250;
        if (immunityState) {
            this.changeSprite("Sprites/Ghosts/Blinky");
        } else {  
            if (animation) {
                tSprite = delaySprite;
                selectedSprite = !selectedSprite;
            }
            if (selectedSprite) {
                this.changeSprite("Sprites/Ghosts/EdibleState_1");
            } else {
                this.changeSprite("Sprites/Ghosts/EdibleState_2");
            }
        }
        
        if (!collisionMur) {
            this.vitesse = 1;
            switch (getDirection()) {
                case HAUT:
                    deplacerXY(0, -vitesse);
                    break;

                case DROITE:
                    deplacerXY(vitesse, 0);
                    break;

                case BAS:
                    deplacerXY(0, vitesse);
                    break;

                case GAUCHE:
                    deplacerXY(-vitesse, 0);
                    break;
            }
        }
        collisionMur = false;
    }  
    
    
    public boolean antiBoucle(){
        boolean rep = false;
        if ((directionsEnMemoire[0] == null) || (directionsEnMemoire[1] == null) || (directionsEnMemoire[2] == null) || (directionsEnMemoire[3] == null)){
            rep = false;
        }else {
            if (directionsEnMemoire[0] == directionsEnMemoire[2]){
                if (directionsEnMemoire[1] == directionsEnMemoire[3]){
                    rep = true;
                }
            }
        }
        return rep;
    }

    @Override
    public String getTypeObjet() {
        return "GHOST_BLINKY";
    }
    
}