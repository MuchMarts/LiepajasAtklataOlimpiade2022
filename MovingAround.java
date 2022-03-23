import java.util.Scanner;

public class MovingAround {

    Translate tr = new Translate();
    GameMap gm = new GameMap(GameTuning.w, GameTuning.w);

    public char[][] moving(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Ievadi koordinaatu, kur veelies doties: ");
        String input = sc.nextLine();
        int x = tr.getInteger(input.substring(0,1));
        int y = Integer.parseInt(input.substring(1));
        gm.initMap(x, y);
        //sc.close();
        return GameMap.map;
    }
}
