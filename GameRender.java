public class GameRender {

    public static void renderMap(char[][] map){
        String[] line = new String[map.length];
        for(int y = 0; y < map.length; y++){
            for(int x = 0; x < map.length; x++){
               System.out.print(map[x][y] + " ");
            }
            System.out.println();
        }
    }
}
