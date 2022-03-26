public class GameSettings {
    public static int w = 14;   // World width (x)
    public static int h = 14;   // World height (y)
    public static int visionRad = 1;    // Player vision radius
    public static int pxy = 2 * visionRad + 1;
    public static double distanceCost = 0.2; // % of battery used to move 1 km
    public static int stepSize = 5; // size of one tile km
}
