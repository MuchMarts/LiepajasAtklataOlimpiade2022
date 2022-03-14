public class World{
    public int width;
    public int height;
    public char[][] world_map;      //2d array containing map info
    public char[][] player_vision;  //2d array player visible map info
    public int R;
    
    public World(int x, int y, int vision){
        width = x;
        height = y;
        R = vision;
        world_map = new char[height][width];
        player_vision = new char[R*2+1][R*2+1];
    }
    
    private boolean validCoordinate(int x, int y){
        //[TODO]optimize
        boolean valid = true;
        if(y < 0 || y > (height - 1)){
            return !valid;
        }
        if(x < 0 || x > (width - 1)){
            return !valid;
        }
        return valid;
    }

    //cx, cy current player cords
    //Creates array with player seen map tiles
    public void updatePlayerVision(int cx, int cy){ 
        for(int y = -R; y <= R; y++){
            for(int x = -R; x <= R; x++){
                if (validCoordinate(cx + x, cy + y)){
                    player_vision[y][x] = world_map[cy + R][cx + x];
                } else {
                    player_vision[y][x] = 1; // = -1; cannot put int in a char array
                }
            }
        }
    }

}