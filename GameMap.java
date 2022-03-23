public class GameMap {

        static char[][] map;
        private int width;
        private int height;
    
        public GameMap(int width, int height) {
            this.width = width;
            this.height = height;
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
    

