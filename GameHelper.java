public class GameHelper {
    public static Integer calculateDistanceTraveled(int lx, int ly, int x, int y){        
        //TODO: Advanced distance traveled calc (Take in mind roads)
        int steps = Math.abs(x - lx) + Math.abs(y - ly);
        return steps * GameSettings.stepSize;
    }
}
