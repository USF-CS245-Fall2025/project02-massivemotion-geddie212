import java.awt.*;
/**
 * Represents a star in the simulation.
 * A {@code Star} is a type of {@link Body} that is drawn in red and does not move.
 */
public class Star extends Body{
    /**
     * Constructs a {@code Star} with a specified position and size.
     *
     * @param x         the x-coordinate of the star
     * @param y         the y-coordinate of the star
     * @param body_size the size (diameter) of the star
     */
    public Star (int x, int y, int body_size){
        super(x, y, body_size);
    }
    /**
     * Paints the star on the screen using red color.
     *
     * @param g the {@link Graphics} context to draw on
     */
    @Override
    public void paintBody(Graphics g) {
        g.setColor(Color.RED);
        super.paintBody(g);

    }
    /**
     * The star does not move. This method is intentionally left empty
     */
    public void move(){
        //in case it would ever need to move
    }

}
