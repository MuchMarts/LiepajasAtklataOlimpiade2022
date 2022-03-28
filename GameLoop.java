public class GameLoop {

    public int startGame(Graphics graphics){
        CLIUtils.ClearConsole();

        int start_x = 0;
        int start_y = 0;

        Graphics gr = graphics;
        WorldMap gameMap = new WorldMap(GameSettings.w, GameSettings.h);
        Player player = new Player(start_x, start_y, gr, gameMap);

        while(player.batteryCharge > 0){
            Render.drawMap(player.playerMove(), gameMap, gr, player.batteryCharge);
        }

        return 1;
    }

}
