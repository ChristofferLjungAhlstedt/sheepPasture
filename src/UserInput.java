
import java.util.Scanner;

public class UserInput {

    int newWhenToMove = 3; // valfri om dom ska flytta på sig eller ej. Nu är det 1/3
    int newFertile = 20;
    int newSatisfied = 90;
    int newBattleEnergyLoss = 5;
    int newMaxFood = Animal.maxFood;
    int listOfChanges;
    Scanner scanner = new Scanner(System.in);
    public int getInputType(){
        int value = scanner.nextInt();
        return value;
    }
    public void implementInput(){
        int newValue = getInputType();
        Animal.whenToMove = newValue;
    }
    public void whatToChange(){
        System.out.println("Vad vill du ändra?");
        System.out.println("Du kan välja mellan:");
        System.out.println("1. Ändra hur stor chans det är att ett djur flyttar på sig. (Standard) " + Animal.whenToMove);
        System.out.println("2. Ändra max mat. (Standard) " + Animal.maxFood);
        System.out.println("3. Ändra när ett djur kan reprodusera (Ålder). (Standard) " + Animal.fertile);
        System.out.println("4. Ändra när ett djur har mat nog för att reprodusera. (Standard) " + Animal.satisfied);
        System.out.println("5. Ändra hur mycket enirgi det kräver för 2 vargar att slås (Standard) " + Animal.battleEnergyLoss);
        System.out.println("6. Klar med ändrig");
        System.out.println("7. Visa alla alternativ igen");
        System.out.println("8. Reset");
    }
    public void runTime(){
        whatToChange();
        listOfChanges = getInputType();
        while (listOfChanges != 6) {
            changeScreen();
            implementChanges();
            listOfChanges = getInputType();
        }
        scanner.close();
    }
    public void implementChanges(){
        Animal.whenToMove = newWhenToMove;
        Animal.fertile = newFertile;
        Animal.satisfied = newSatisfied;
        Animal.maxFood = newMaxFood;
        Animal.battleEnergyLoss = newBattleEnergyLoss;
    }
    public void standard() {
        newWhenToMove = Animal.whenToMove;
        newFertile = Animal.fertile;
        newSatisfied = Animal.satisfied;
        newBattleEnergyLoss = Animal.battleEnergyLoss;
    }
    public void changeScreen(){
        int valueChange = 0;
        int activeChange;
        activeChange = listOfChanges;
        valueChange = getInputType();
        if (activeChange == 1) {
            newWhenToMove = valueChange;
        } else if (activeChange == 2) {
            newMaxFood = valueChange;
        } else if (activeChange == 3) {
            newFertile = valueChange;
        } else if (activeChange == 4) {
            newSatisfied = valueChange;
        } else if (activeChange == 5) {
            newBattleEnergyLoss = valueChange;
        } else if (activeChange == 6) {
            return;
        } else if (activeChange == 7) {
            whatToChange();
        } else if (activeChange == 8) {
            standard();
            System.out.println("Återgår till standard");
            return;
        } else if (activeChange == 9) {
            return;
        }

    }
}
