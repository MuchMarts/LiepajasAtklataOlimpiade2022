import java.util.Scanner;

public class MovingAround {

    Translate tr = new Translate();
    GameMap gm = new GameMap(GameSettings.w, GameSettings.w);

    public void scanning(int vec_x, int vec_y){
        //receives and checks user input and refactors the game map accordingly
        Scanner sc = new Scanner(System.in);
        System.out.println("Tu tagad atrodies: " + tr.getLetter(vec_x) + vec_y);
        System.out.print("Ievadi koordinaatu, kur veelies doties: ");
        String input = sc.nextLine();
        try{
            int y = Integer.parseInt(input.substring(1));
            int x = tr.getInteger(input.substring(0,1).toUpperCase()); 
            if(x <= GameSettings.w && y <= GameSettings.h){
                GameRender.calculateSteps(x, y);
                gm.initMap(x, y - 1);
                GameRender.koord(x, y);
            }else{
                System.out.println("Taada koordinata neeksiste! Megini velreiz...");
                scanning(vec_x, vec_y);
            }
        } catch(NumberFormatException e){
            System.out.println("Koordinata jaievada atbilstosa formata! Brr...");
            scanning(vec_x, vec_y);
        }
    }
}


//MASSIVE TODO: REFACTOR EVERYTHING