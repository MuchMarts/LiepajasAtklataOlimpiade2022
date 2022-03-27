public class Player {
    public String name;
    public Integer batteryCharge;
    private Integer distanceTraveled;
    private PlayerMovement movement;
    
    public Integer lastx;
    public Integer lasty;

    public Player(String name, int start_x, int start_y, Graphics gr){
        this.name = name;
        this.batteryCharge = 100;
        this.distanceTraveled = 0;
        this.lastx = start_x;
        this.lasty = start_y;
        this.movement = new PlayerMovement(gr);
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

    public char[][] playerMove(){
        int[] playerCordinates = movement.getPlayerInput(lastx, lasty);
        
        int x = playerCordinates[0];
        int y = playerCordinates[1];
        
        char[][] playerLocation = movement.movePlayer(playerCordinates);

        int distance = GameHelper.calculateDistanceTraveled(lastx, lasty, x, y);
        updateDistanceTraveled(distance);
        useBattery(distance);

        this.lastx = x;
        this.lasty = y;

        return playerLocation;
    }

}
