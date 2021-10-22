import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;


public class PastureGUI extends JFrame implements ActionListener {

    public static void main(String[] args) {
        PastureGUI gui = new PastureGUI();  // gör en pointer till gui objekt
    }
    //sätt ut knappar
    /** Icon for an empty position in the pasture */
    JFrame frame = new JFrame("Spinner");
    private final ImageIcon II_EMPTY = new ImageIcon("empty.gif");
    /** The pasture this class should display */
    private Pasture pasture;
    /** The grid, i.e., the field containing the images to display. */
    private JLabel[][] grid;
    /** The button for STARTING the simulation. */
    private JButton startButton = new JButton("Start");
    /** The button for STOPPING the simulation. */
    private JButton stopButton = new JButton("Stop");
    /** The button for CLOSING the simulation. */
    private JButton exitButton = new JButton("Exit");

    /*
    Första funktionen callad från init.
    Callar initPastureGUI()
    Returnar Void
    */

    public PastureGUI() { 
        pasture = new Pasture(this);
        initPastureGUI();
    }
    /*
    initPastureGUI() 
    Call från PastureGUI()
    Implamenterar JFrame Från extend
    Knapp Logik samt Skapar knapp objekt
     */
    private void initPastureGUI() {
        setSize(pasture.getWidth() * 30, pasture.getHeight() * 30);

        startButton.addActionListener(this);

        JPanel buttons = new JPanel();

        buttons.setLayout(new GridLayout(1, 1));
        buttons.add(startButton);

        stopButton.addActionListener(this);

        buttons.setLayout(new GridLayout(2, 1));
        buttons.add(stopButton);

        exitButton.addActionListener(this);

        buttons.setLayout(new GridLayout(2, 1));
        buttons.add(exitButton);

        frame.add(new Spinner(false));
        frame.pack();
        frame.setVisible(true);
        

        JPanel field = new JPanel();
        field.setBackground(new Color(27, 204, 89));
        field.setLayout(new GridLayout(pasture.getHeight(),
            pasture.getWidth()));
        grid = new JLabel[pasture.getWidth()][pasture.getHeight()];

        for (int y = 0; y < pasture.getHeight(); y++) {
            for (int x = 0; x < pasture.getWidth(); x++) {
                grid[x][y] = new JLabel(II_EMPTY);
                grid[x][y].setVisible(true);
                field.add(grid[x][y]);
            }
        }

        Container display = getContentPane();
        display.setBackground(new Color(27, 204, 89));
        display.setLayout(new BorderLayout());
        display.add(field, BorderLayout.CENTER);
        display.add(buttons, BorderLayout.SOUTH);
  

        startButton.setEnabled(true);
        stopButton.setEnabled(false);
        updateAll();
        setVisible(true);
    }

    /*
    Call från inget?
    
     */

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == startButton) {
            startButton.setEnabled(false);
            stopButton.setEnabled(true);
            pasture.start();
        }
        if (e.getSource() == stopButton) {
            startButton.setEnabled(true);
            stopButton.setEnabled(false);
            pasture.stop();
        }
        if (e.getSource() == exitButton) {
            System.out.println("Stänger av");
            System.exit(69);
        }
    }

    //Vad rutor gör

    


    public void updateAll() {
        int width = pasture.getWidth();
        int height = pasture.getHeight();

        Entity[][] tempGrid =
            new Entity[width][height];


        for (int y = 0; y < height; y++)
            for (int x = 0; x < width; x++)
                tempGrid[x][y] = null;

        Collection world = pasture.getEntities();
        Iterator it = world.iterator();

        while (it.hasNext()) {
            Entity e = (Entity) it.next();
            int x = (int) e.getPosition().getX();
            int y = (int) e.getPosition().getY();

        if (tempGrid[x][y] == null) tempGrid[x][y] = e;
        }

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                ImageIcon icon;
                Entity e = tempGrid[x][y];

                if (e == null) icon = II_EMPTY;
                else icon = e.getImage();
                grid[x][height - y - 1].setIcon(icon);
            }
        }
    }
}