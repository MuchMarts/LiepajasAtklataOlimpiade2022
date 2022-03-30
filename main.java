public class main {
    public static void main(String[] args){

        boolean gameActive = true;
        GameLoop game = new GameLoop();
        Graphics gr = new Graphics();
        CheckpointParser ch = new CheckpointParser();
        CLIUtils.ClearConsole();

        //GameLoop
        gr.IntroAnimation();
        
        while(gameActive){
            int choice = StartScreen.validChoice(gr);
            switch(choice){
                case -1: 
                    System.out.println("Error: Can not choose an option... Try again"); break;
                case 1:
                    game.startGame(gr, ch); break; //start game
                case 2: break; //leaderboard
                case 3: break; //edit tasks
                case 4: break; // edit map
                case 5: gameActive = false; break;
            }
            CLIUtils.exitGame();
        }

    }
    
}