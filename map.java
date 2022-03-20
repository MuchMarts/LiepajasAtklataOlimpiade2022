public class map {

    static char[][] map;
    static int width;
    static int height;

    public map(int x, int y) {
        width = x;
        height = y; 
        initMap();
    }
    
    public void initMap() {
        map = new char[width][height];
        for(int cx = 0; cx < width; cx++){
            for(int cy = 0; cy < height; cy++){
                map[cx][cy] = '-';
            }
        }
    }

    
}
