public class PlayerInfo {
    public String name;
    public String playedTime;
    public Boolean batteryDead;
    public Integer kilometers;
    public Integer battery;

    public PlayerInfo(String name){
        this.name = name;
        this.battery = 100;
    }

    public void chargeBattery(){
        this.battery = 100;
    }
    
    public void useBattery(int steps){
        this.battery = this.battery - GameTuning.stepCost * steps;
    }

}
