import javax.swing.*;
import java.awt.Color;
import java.awt.Container;

public class Spinner extends JPanel {
    public void Spinner(boolean bool){
/*         String[] numlist;
        for (int i = 1; i <= 100; i++){
            numlist[i - 1] = String.valueOf(i);
        }
        SpinnerListModel hModel = null;
        hModel = new SpinnerListModel(numlist); */
        SpinnerModel stepSpeedModel = new SpinnerNumberModel(1, 1, 100, 1); 
        JSpinner spinner = addLabeledSpinner(this, "Ändra hur stor chans det är att ett djur flyttar på sig.", stepSpeedModel);



       /*  if (stepSpeedModel instanceof hModel) {
            ((SpinnerListModel)stepSpeedModel);
        }
 */
    }

    static protected JSpinner addLabeledSpinner(Container c,
                                                String label,
                                                SpinnerModel model) {
        JLabel l = new JLabel(label);
        c.add(l);
 
        JSpinner spinner = new JSpinner(model);
        l.setLabelFor(spinner);
        c.add(spinner);
 
        return spinner;
    }
    public void createGUI(JFrame frame){

    }
}
/* System.out.println("Vad vill du ändra?");
System.out.println("Du kan välja mellan:");
System.out.println("1. Ändra hur stor chans det är att ett djur flyttar på sig. (Standard) " + Animal.whenToMove);
System.out.println("2. Ändra max mat. (Standard) " + Animal.maxFood);
System.out.println("3. Ändra när ett djur kan reprodusera (Ålder). (Standard) " + Animal.fertile);
System.out.println("4. Ändra när ett djur har mat nog för att reprodusera. (Standard) " + Animal.satisfied);
System.out.println("5. Ändra hur mycket enirgi det kräver för 2 vargar att slås (Standard) " + Animal.battleEnergyLoss);
System.out.println("6. Klar med ändrig");
System.out.println("7. Visa alla alternativ igen");
System.out.println("8. Reset"); */