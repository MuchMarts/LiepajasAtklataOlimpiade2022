public class World{
    public int width;
    public int height;
    public char[][] world_map;
    public int vision = 1;
    public int posx; //Needs to be in a seperate file
    public int posy;
    public int relPosx;
    public int relPosy;

    public World(int x, int y){
        width = x;
        height = y;
        world = new char[height][width];
        world_map = world;
    }

    public char[][] createWorld(){}

    public drawMap(){
        char[] line;
        line = new char[width];
        for(int i = 0, i < height, i++){
            for(int a = 0, a < width, a++) {
                line[a] = world_map[i][a];
            }
            System.out.printl(line);
        }
    }

    public playerVision(int x, int y){
        char[] line;
        line = new char[vision * 2 + 1];
        for(int i = -vision, i <= vision, i++){
            for(int a = -vision, a < vision, a++) {
                line[a] = world_map[y + i][x + a];
            }
            System.out.printl(line);
        }
    }

    public drawSeen(){
        int vision_state = 3;
        
        switch(vision_state) {
            case 0:
                playerVision(posx, posy);
                break;
            case 1:
                playerVision(relPosx, posy);
                break;
            case 2:
                playerVision(posx, relPosy);
                break;
            case 3:
                playerVision(relPosx, relPosy);
                break;
        }
    }

}