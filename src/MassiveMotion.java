import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
/**
 * The {@code MassiveMotion} class represents a simulation of moving celestial bodies
 * on a 2D plane. It uses a timer to update and render the simulation using different list implementations.
 * <p>
 * Configuration is loaded from a properties file, allowing customization
 * of the window size, body properties, and list implementation.
 *
 * @author Paul Gedrimas
 */
public class MassiveMotion extends JPanel implements ActionListener {
    /** Timer triggering animation updates. */
    protected Timer tm;
    /** List storing all body objects in the simulation. This will depend on the propfile */
    protected List<Body> bodies;
    /** Random number generator for body creation and movement/velocity. */
    protected Random rand;
    /** Width of the screen. */
    protected static int window_size_x;
    /** Height of the screen. */
    protected static int window_size_y;
    /** Probability of generating body top or bottom of screen*/
    protected double gen_x;
    /** Probability of generating a body on each side of screen */
    protected double gen_y;
    /** Velocity of generated bodies. */
    protected int body_velocity;
    /** Diameter of each body. */
    protected int body_size;
    /** X-coordinate for placing central star. */
    protected int star_position_x;
    /** Y-coordinate for placing central star. */
    protected int star_position_y;
    /** Diameter of star. */
    protected int star_size;
    /** Type of list implementation used (arraylist, single, double, dummyhead). */
    protected String list; //arraylist, single, double, dummyhead
    /** Delay between animation frames, in milliseconds. */
    protected int timer_delay;

    /**
     * Constructs a {@code MassiveMotion} object using configuration from a property file.
     *
     * @param propfile the path to the configuration file.
     */
    public MassiveMotion(String propfile) {
//    public MassiveMotion() {
        // propfile read and variables set
        ConfigReader config = new ConfigReader(propfile);
        timer_delay = config.getInt("timer_delay");
        list = config.get("list");
        switch (list){
            case "arraylist":
                bodies = new ArrayList<>();
                break;
            case "single":
                bodies = new LinkedList<>();
                break;
            case "double":
                bodies = new DoublyLinkedList<>();
                break;
            case "dummyhead":
                bodies = new DummyHeadLinkedList<>();
                break;
        }

        window_size_x = config.getInt("window_size_x");
        window_size_y = config.getInt("window_size_y");
        gen_x = config.getDouble("gen_x");
        gen_y = config.getDouble("gen_y");
        body_size = config.getInt("body_size");
        body_velocity = config.getInt("body_velocity");
        star_position_x = config.getInt("star_position_x");
        star_position_y = config.getInt("star_position_y");
        star_size = config.getInt("star_size");
        rand = new Random();
        tm = new Timer(timer_delay, this);

        //Initial star is generated
        GenerateStar();
    }
    /**
     * Adds the central star to the simulation.
     */
    public void GenerateStar(){
        Star sun = new Star(star_position_x, star_position_y, star_size);
        bodies.add(sun);
    }
    /**
     * Paints the bodies on the simulation panel based on the list implementation chosen
     *
     * @param g the graphics context to draw on
     */
    public void paintComponent(Graphics g) {
        super.paintComponent(g); // Probably best you leave this as is.

        for (int i = 0; i < bodies.size(); i++){
            bodies.get(i).paintBody(g);
        }

        // Recommend you leave the next line as is
        tm.start();
    }
    /**
     * Randomly generates a new body from one edge of the screen depending on the axis.
     *
     * @param isGenX if true, generate along top or bottom; otherwise, on either side.
     */
    private void bodyGenerator(boolean isGenX){
        double gen;
        int x1, y1, vx1, vy1;
        if (isGenX){
            gen = gen_x;
        }
        else{
            gen = gen_y;
        }

        if (rand.nextDouble() <= gen){
            if (rand.nextDouble() < 0.5){
                if (isGenX){
                    x1 = window_size_x/2;
                    y1 = 0;
                }
                else
                {
                    x1 = 0;
                    y1 = window_size_y/2;
                }
            }
            else{
                if (isGenX){
                    x1 = window_size_x/2;
                    y1 = window_size_y;
                }
                else{
                    x1 = window_size_x;
                    y1 = window_size_y/2;
                }
            }
            // velocity is randomly generated by multiplying twice then subtracting the original velocity to make
            // either positive or negative value
            vx1 = (int) (rand.nextDouble() * (body_velocity*2)+1) - body_velocity;
            while (vx1 == 0){
                vx1 = (int) (rand.nextDouble() * (body_velocity*2)+1) - body_velocity;
            }
            vy1 = (int) (rand.nextDouble() * (body_velocity*2)+1) - body_velocity;
            while (vy1 == 0){
                vy1 = (int) (rand.nextDouble() * (body_velocity*2)+1) - body_velocity;
            }
            //celestial object created and added to chosen implemented list.
            MotionBody body = new MotionBody(x1, y1, vx1, vy1, body_size);
            bodies.add(body);
        }
    }

    /**
     * Called automatically by the timer to update the simulation.
     *
     * @param actionEvent the triggering event (unused)
     */
    @Override
    public void actionPerformed(ActionEvent actionEvent) {

        //random generator for celestial bodies
        bodyGenerator(true);
        bodyGenerator(false);

        //move each body and/or remove body from list if it's outside the bounds of the screen
        for (int i = 0; i < bodies.size(); i++){
            bodies.get(i).move();
            if (bodies.get(i).isOutOfBounds(window_size_x, window_size_y)){
                bodies.remove(i);
            }
            //System.out.println("Bodies Array Size:"+bodies.size());
        }

        // Keep this at the end of the function (no matter what you do above):
        repaint();
    }
    /**
     * Entry point for running the simulation.
     *
     * @param args command line arguments; expects the first argument to be the config file path
     */
    public static void main(String[] args) {
        System.out.println("Massive Motion starting...");
        MassiveMotion mm = new MassiveMotion(args[0]);
//        MassiveMotion mm = new MassiveMotion();
        JFrame jf = new JFrame();
        jf.setTitle("Massive Motion");
        jf.setSize(window_size_x, window_size_y);
        jf.add(mm);
        jf.setVisible(true);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
