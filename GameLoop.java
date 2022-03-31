import java.util.Random;

public class GameLoop {

    public int startGame(Graphics graphics, CheckpointParser ch, Leaderboard banana){
        CLIUtils.ClearConsole();

        int start_x = GameSettings.start_x;
        int start_y = GameSettings.start_y;

        Graphics gr = graphics;
        WorldMap gameMap = new WorldMap(GameSettings.w, GameSettings.h, ch);
        Leaderboard lead = banana;
        Player player = new Player(start_x, start_y, gr, gameMap, ch, lead);


        Random rd = new Random();
        boolean rain = rd.nextBoolean();
        player.setRain(rain);
        player.startTime();

        while(player.answeredQuestions < 10){
            Render.drawMap(gameMap, gr, player.batteryCharge, rain);
            
            player.manageLocations();
            
            player.playerMove();
        }

        player.endGame();
        Render.gameWin(player);

        return 1;
    }

}
