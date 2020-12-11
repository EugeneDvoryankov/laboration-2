package Model;
import Vehicle.*;

public interface IWorld {
    /** Updates the drawPanel based on vehicles movement
     * Assuming each image has x(width) = 100, and y(height) = 60.
     * The green frame they're in has the dimensions x = 684 X 500 = y.
     *
     */
    //public void update();

    /** Checks whether the x coordinate of a vehicle is less than zero pixels.
     *
     * @param vehicle
     * @return true if the x coordinate of a vehicle is less than zero, otherwise false
     */
    boolean isOutOfBoundsLeft(Vehicle vehicle);

    /** Checks whether the x coordinate of a vehicle is greater than 684 pixels.
     *
     * @param vehicle
     * @return true if the x coordinate of a vehicle is greater than 684 pixels, otherwise false
     */
    boolean isOutOfBoundsRight(Vehicle vehicle);

    /** Checks whether the y coordinate of a vehicle is less than 0 pixels.
     *
     * @param vehicle
     * @return true if the y coordinate of a vehicle is less than zero, otherwise false
     */
    boolean isOutOfBoundsUp(Vehicle vehicle);

    /** Checks whether the y coordinate of a vehicle is greater than 500 pixels.
     *
     * @param vehicle
     * @return true if the y coordinate of a vehicle is greater than 500 pixels, otherwise false
     */
    boolean isOutOfBoundsDown(Vehicle vehicle);

}
