import java.util.Random;

public class GameLoop {

    public int startGame(Graphics graphics, CheckpointParser ch){
        CLIUtils.ClearConsole();

        int start_x = GameSettings.start_x;
        int start_y = GameSettings.start_y;

        Graphics gr = graphics;
        WorldMap gameMap = new WorldMap(GameSettings.w, GameSettings.h, ch);
        Player player = new Player(start_x, start_y, gr, gameMap, ch);

        Random rd = new Random();
        boolean rain = rd.nextBoolean();
        player.setRain(rain);

        while(player.batteryCharge > 0){
            Render.drawMap(gameMap, gr, player.batteryCharge, rain);
            
            player.manageLocations();
            player.playerMove();
        }

        return 1;
    }

}
