import java.util.LinkedList;

public class shortestPathBetweenPoints {
    
    private static class Cell {
        
        int x, y, distance;
        Cell parentCell;

        Cell(int x , int y, int distance, Cell parentCell) {
            this.x = x;
            this.y = y;
            this.distance = distance;
            this.parentCell = parentCell;
        }
    }

    //BFS Algo
    public static int[][] findShortestPath(int[][] gameMap, int[] start, int[] end) {
        
        int sx = start[0];  int sy = start[1];
        int dx = end[0];    int dy = end[1];

        //Double checks if path is possible. If end or start cordinates on a square that is not a path big bad.
        if(gameMap[sx][sy] == 0 && gameMap[dx][dy] == 0){
            System.out.println("Invalid start/end location");
            return null;
        }

        //init Cells <= Path objects used to find shortest path. Each cell is a Verteci
        int mx = gameMap.length;
        int my = gameMap[0].length;
        Cell[][] cells = new Cell[mx][my];
        for(int a = 0; a < mx; a++){
            for(int b = 0; b < my; b++){
                //Check if path exists => create path object
                if(gameMap[a][b] != 0){
                    // Init path objects with default values
                    cells[a][b] = new Cell(a, b, Integer.MAX_VALUE, null);
                }
            }
        }

        //First Search
        LinkedList<Cell> queue = new LinkedList<>();
        
        //Create Start Cell
        Cell starCell = cells[sx][sy];
        starCell.distance = 0;
        queue.add(starCell);
        
        //Create Destination cell and Cell to use whilst seraching
        Cell destCell = null;
        Cell checkCell;

        while((checkCell = queue.poll()) != null){

            //check if destination
            if(checkCell.x == dx && checkCell.y == dy){
                destCell = checkCell;
                break;
            }

        //Movement TODO: Understand how works
            //8 Direction
            //N
            visit(cells, queue, checkCell.x - 1, checkCell.y, checkCell);
            //S
            visit(cells, queue, checkCell.x + 1, checkCell.y, checkCell);
            //W
            visit(cells, queue, checkCell.x, checkCell.y - 1, checkCell);
            //E
            visit(cells, queue, checkCell.x, checkCell.y + 1, checkCell);
            //NW
            visit(cells, queue, checkCell.x - 1, checkCell.y - 1, checkCell);
            //NE
            visit(cells, queue, checkCell.x - 1, checkCell.y + 1, checkCell);
            //SW
            visit(cells, queue, checkCell.x + 1, checkCell.y - 1, checkCell);
            //SE
            visit(cells, queue, checkCell.x + 1, checkCell.y + 1, checkCell);
        }

        //Check if path found and if yes then create it
        if( destCell == null){
            System.out.println("Can't get to desired location");
        } else {
            LinkedList<Cell> path = new LinkedList<>();
            checkCell = destCell;
            //Create path info from cell parents same vibe as blockchains
            do {
                path.addFirst(checkCell);
            } while ((checkCell = checkCell.parentCell) != null);
            //TODO: This info needs to go somewhere to be *animated*
            int[][] output = new int[path.size()][2];            
            //Create output info int[][] first element is distance rest is path
            for(int i = 0; i < path.size(); i++){
    
                //Cords swapped from yx to xy
                output[i][1] = path.get(i).x;
                output[i][0] = path.get(i).y;
        
             }
            return output;
        }
        System.out.println("I broke");
        return null;
    }

    //Update Cell visit status
    private static void visit(Cell[][] cells, LinkedList<Cell> queue, int x, int y, Cell parent){
        
        //Check if out of bounds
        if(x < 0|| x >= cells.length || y < 0|| y >= cells[0].length || cells[x][y] == null ){
            return;
        }
    
        //Update distance and parent node
        int dist = parent.distance + 1;
        Cell p = cells[x][y];
        
        //Find smallest dist between vertices and explore that
        if(dist < p.distance){
            p.distance = dist;
            p.parentCell = parent;
            queue.add(p);
        }
    }
/*
    public static void main(String[] args) {
        int[][] matrix = {
            {1, 0, 1},
            {0, 1, 1},
            {0, 0, 1}};
            
            //case1, there is no path
            int[] start = {0, 0};
            int[] end = {1, 2};
            System.out.print("case 1: ");
            System.out.println(findShortestPath(matrix, start, end));
        
            //case 2, there is path
            int[] start1 = {0, 2};
            int[] end1 = {2, 2};
            System.out.print("case 2: ");
            System.out.println(Arrays.deepToString(findShortestPath(matrix, start1, end1)));     
    */
}
