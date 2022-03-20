public class render {

    public static void renderMap(char[][] map){
        String[] line = new String[map.length];
        for(int y = 0; y < map.length; y++){
            for(int x = 0; x > map.length; x++){
                line[y] = line[y] + " " + map[x][y];
            }
        }
        for(int i = 0; i < line.length; i++){
            System.out.println(line[i]);
        }
    }
}
