import java.awt.*;
/**
 * An abstract class representing a generic body in a simulation or graphical environment.
 * <p>
 * Each body has a position (x, y) and a defined size. Subclasses must define how the body moves.
 */
public abstract class Body {
    /** The x-coordinate of the body's position. */
    protected int x;
    /** The y-coordinate of the body's position. */
    protected int y;
    /** The diameter of the body. */
    protected int body_size;
    /**
     * Constructs a Body object with specified position and size.
     *
     * @param x          the initial x-coordinate
     * @param y          the initial y-coordinate
     * @param body_size  the size (diameter) of the body
     */
    public Body(int x, int y, int body_size) {
        this.x = x;
        this.y = y;
        this.body_size = body_size;
    }
    /**
     * Renders the body as a filled oval at its current position and size.
     *
     * @param g the Graphics context used to draw the body
     */
    public void paintBody(Graphics g){
        g.fillOval(x, y, body_size, body_size);
    }
    /**
     * Moves the body according to its own rules.
     * <p>
     * This method must be implemented by subclasses to define specific movement behavior.
     */
    public abstract void move();
    /**
     * Determines whether the body is out of the given window bounds.
     *
     * @param window_size_x the width of the window
     * @param window_size_y the height of the window
     * @return {@code true} if the body is out of bounds; {@code false} otherwise
     */
    public boolean isOutOfBounds(int window_size_x, int window_size_y){
        if (x < 0 || x >= window_size_x || y < 0 || y >= window_size_y) {
            return true;
        }
        else{
            return false;
        }
    }
}
