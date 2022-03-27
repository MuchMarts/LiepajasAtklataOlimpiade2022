public class main {
    public static void main(String[] args){

        boolean gameActive = true;
        GameLoop game = new GameLoop();

        CLIUtils.ClearConsole();

        //GameLoop

        while(gameActive){
            int choice = StartScreen.validChoice();
            switch(choice){
                case -1: 
                    System.out.println("Error: Can not choose an option");break;
                case 1:
                    game.startGame(); break; //start game
                case 2: break; //leaderboard
                case 3: break; //edit tasks
                case 4: break; // edit map
                case 5: gameActive = false; break;
            }
            CLIUtils.exitGame();
        }

        /*
        PlayerInfo player = new PlayerInfo("Banana Man1");

        StartScreen.IntroAnimation();
        int choice = StartScreen.validChoice();
        switch(choice){ //TODO: This needs to be recursive => move to Start screen or a game options class and make a method thats recursive
            case -1: System.out.println("Error");
            case 1:
                GameLoop.initGame(player); 
                break; //start game
            case 2: break; //leaderboard
            case 3: break; //edit tasks
            case 4: break; // edit map
            case 5: CLIUtils.exitGame();
        }
        /*
        GameMap m = new GameMap(GameTuning.w, GameTuning.h);
        GameRender gr = new GameRender();
        m.initMap(0,0);
        GameRender.renderMap(GameMap.map);
        gr.gamePlay();
        */
}
    
}