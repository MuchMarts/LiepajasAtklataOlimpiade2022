public class main {
    public static void main(String[] args){

        boolean gameActive = true;
        GameLoop game = new GameLoop();
        Graphics gr = new Graphics();
        CheckpointParser ch = new CheckpointParser();
        Leaderboard lead = new Leaderboard();

        CLIUtils.ClearConsole();

        //GameLoop
        gr.IntroAnimation();
        
        while(gameActive){
            int choice = StartScreen.validChoice(gr);
            switch(choice){
                case -1: 
                    System.out.println("Error: Can not choose an option... Try again"); break;
                case 1:
                    game.startGame(gr, ch, lead); break; //start game
                case 2: lead.showBestTimes();break; //leaderboard
                case 3: gameActive = false; break;
            }
            CLIUtils.exitGame();
        }

    }
    
}