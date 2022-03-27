public class GameSettings {
    public static int w = 14;   // World width (x)
    public static int h = 14;   // World height (y)
    public static int visionRad = 1;    // Player vision radius
    public static int pxy = 2 * visionRad + 1;
    //To move 1 tile costs stepSize * distanceCost
    public static double distanceCost = 1; // % of battery used to move 1 km
    public static int stepSize = 5; // size of one tile km

    public static int start_x = 0;
    public static int start_y = 0;

}
