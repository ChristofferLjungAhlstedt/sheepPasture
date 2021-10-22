import java.util.concurrent.ThreadLocalRandom;
import java.awt.Point;
import java.util.Iterator;

public abstract class Animal extends LivingThing {
    public static int maxFood = 100; // ska vara 100
    int currentFood = maxFood;
    int[] possibleMovesX = {-1,
        0,
        1,
    };
    int[] possibleMovesY = {-1,
        0,
        1
    };
    int choosenDirX;
    int choosenDirY;
    int borderMin = 0;
    int borderMaxY = 19; //Border -1
    int borderMaxX = 24; //Border -1
    int lifetime = 0;
    
    public static int whenToMove = 3; // valfri om dom ska flytta på sig eller ej. Nu är det 1/3
    public static int fertile = 20;
    public static int satisfied = 90;
    public static int minSpeed = 0;
    public static int maxSpeed = whenToMove;
    public static int battleEnergyLoss = 5; //How much energy it looses on every battle
    

    public void move() {
        setPosition(position);//it will be hidden in plants otherwise but its stupid :P
        if (toMove() == whenToMove) {
            setPosition(new Point((int) getPosition().getX() + chooseDirX(), (int) getPosition().getY() + chooseDirY()));
        }
        starv();
        lifetime++;
    }

    public void starv(){
        currentFood--;
        if (!enoughFood()) {
            die();
        }
    }

    public boolean enoughFood() {
        if (currentFood <= 0) {
            return false;
        } else {
            return true;
        }
    }

    public boolean canMakeBebe() {
        if (lifetime >= fertile && currentFood >= satisfied) {
            if (successfulBebeMaking()) {
                return true;
            } else {
                return false;
            }
        } else {
            return false; 
        }
        
    }

    public boolean successfulBebeMaking() {
        int sucsessRate = ThreadLocalRandom.current().nextInt(0, 5 + 1);
        int success = ThreadLocalRandom.current().nextInt(0, 5 + 1);
        if(sucsessRate == success) {
            return true;
        } else {
            return false;
        }
        
    }

    public void onEntityAndEatIfFood(String food){
        Iterator<Entity> it = this.pasture.getEntities().iterator(); //Lös sen
        while (it.hasNext()) {
            Entity collision = (Entity) it.next();
            if(collision.type().equals(food)) {
                if(collision.getPosition().equals(this.position)){
                    this.pasture.removeEntity(collision);
                    this.currentFood = maxFood;
                } else{
                    continue;
                }
            } else{
                continue;
            }
        }
    }

    public void battleForLivingSpace(){
        if (occupied()) {
            this.currentFood = currentFood - 2;
        }
    }

    public int toMove(){
        int speed = ThreadLocalRandom.current().nextInt(minSpeed, maxSpeed + 1);
        return speed;
    }

    public int chooseDirX() {
        int randomX = ThreadLocalRandom.current().nextInt(0, 2 + 1);
        if ((int) getPosition().getX() == borderMaxX) {
            choosenDirX = -1;
        } else if ((int) getPosition().getX() == borderMin) {
            choosenDirX = 1;
        } else {
            choosenDirX = possibleMovesX[randomX];
        }
        return choosenDirX;
    }

    public int chooseDirY() {
        int randomY = ThreadLocalRandom.current().nextInt(0, 2 + 1);
        if ((int) getPosition().getY() == borderMaxY) {
            choosenDirY = -1;
        } else if ((int) getPosition().getY() == borderMin) {
            choosenDirY = 1;
        } else {
            choosenDirY = possibleMovesX[randomY];
        }

        return choosenDirY;
    }
}