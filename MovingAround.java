import java.util.Scanner;

public class MovingAround {

    Translate tr = new Translate();
    GameMap gm = new GameMap(GameTuning.w, GameTuning.w);

    public void scanning(){
        //receives and checks user input and refactors the game map accordingly
        Scanner sc = new Scanner(System.in);
        System.out.print("Ievadi koordinaatu, kur veelies doties: ");
        String input = sc.nextLine();
        try{
            int y = Integer.parseInt(input.substring(1));
            int x = tr.getInteger(input.substring(0,1).toUpperCase()); 
            if(x <= GameTuning.w && y <= GameTuning.h){
                gm.initMap(x, y - 1);
            }else{
                System.out.println("Taada koordinata neeksiste! Megini velreiz...");
                scanning();
            }
        } catch(NumberFormatException e){
            System.out.println("Koordinata jaievada atbilstosa formata! Brr...");
            scanning();
        }
    }
}
