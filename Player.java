public class Player {
    public String name;
    public Integer batteryCharge;
    private Integer distanceTraveled;
    private Map GameMap;
    private PlayerMovement movement;
    
    public Integer lastx;
    public Integer lasty;

    public Player(String name, int start_x, int start_y, Map map){
        this.name = name;
        this.batteryCharge = 100;
        this.distanceTraveled = 0;
        this.lastx = start_x;
        this.lasty = start_y;
        this.GameMap = map;
        this.movement = new PlayerMovement(map);
    }

    public void chargeBattery(){
        this.batteryCharge = 100;
    }

    private void useBattery(int distance){
        this.batteryCharge = (int) (this.batteryCharge - distance * GameSettings.distanceCost);
    }

    public Integer getDistanceTraveled(){
        return distanceTraveled;
    }

    private void updateDistanceTraveled(int distance){
        this.distanceTraveled = this.distanceTraveled + distance;
    }

    public void drive(){
        int[] playerMove = movement.getPlayerInput();
        int x = playerMove[0];
        int y = playerMove[1];
        
        movement.movePlayer(playerMove, GameMap);

        int distance = GameHelper.calculateDistanceTraveled(lastx, lasty, x, y);
        updateDistanceTraveled(distance);
        useBattery(distance);

        this.lastx = x;
        this.lasty = y;
    }

}
