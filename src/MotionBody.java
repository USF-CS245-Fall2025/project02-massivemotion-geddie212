import java.awt.*;
import java.util.*;

/**
 * Represents a moving body in the simulation, extending the {@link Body} class.
 * <p>
 * Each {@code MotionBody} has a position (inherited from {@code Body}) and
 * a velocity in both the x and y directions. The body updates its position
 * based on its velocity when {@code move()} is called.
 */
public class MotionBody extends Body {
    /**
     * The velocity of the body in the x-direction.
     */
    int vx;
    /**
     * The velocity of the body in the y-direction.
     */
    int vy;
    /**
     * Constructs a new {@code MotionBody} with specified position, velocity, and size.
     *
     * @param x         the initial x-coordinate of the body
     * @param y         the initial y-coordinate of the body
     * @param vx        the velocity in the x-direction
     * @param vy        the velocity in the y-direction
     * @param body_size the diameter of the body when drawn
     */
    public MotionBody(int x, int y, int vx, int vy, int body_size) {
        super(x, y, body_size);
        this.vx = vx;
        this.vy = vy;
    }
    /**
     * Updates the body's position based on its velocity.
     * Called during each frame of animation to simulate motion.
     */
    public void move(){
        x += vx;
        y += vy;
    }
    /**
     * Paints the body using the provided {@link Graphics} object.
     * This implementation sets the color to black before drawing the shape.
     *
     * @param g the {@code Graphics} object used for rendering
     */
    @Override
    public void paintBody(Graphics g) {
        g.setColor(Color.BLACK);
        super.paintBody(g);
    }

}
