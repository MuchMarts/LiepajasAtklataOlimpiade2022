import GameSettings;

package oldFiles;
public class PlayerInfo {

    public String name;
    public String playedTime;
    public Boolean batteryDead;
    public Integer basicKmDriven;
    public Double kilometers;
    public Integer battery;
    public Integer lastMoveStepCount;


    public PlayerInfo(String name){
        this.name = name;
        this.battery = 100;
    }

    public void drive(){
        basicKmDriven = lastMoveStepCount * GameSettings.stepCost;
        useBattery(lastMoveStepCount);
    }

    public void chargeBattery(){
        this.battery = 100;
    }
    
    private void useBattery(int steps){
        this.battery = this.battery - GameSettings.stepCost * steps;
    }

    public void kilometersDriven(int ox, int oy, int nx, int ny){
        //calculates the kilometeres driven between two coordinates
        int distance = 224; //the distance(in km) between Riga and Liepaja
        double border = distance/Math.sqrt(2);
        double step_right = border/GameSettings.w; //the value of one square's edge(in km)
        double step_diag = step_right/Math.sqrt(2); //the value of one square's diagonal(in km)
        if(ox == nx){
            kilometers = kilometers + (step_right * Math.abs(nx-ox));
            System.out.println("Tu esi nobraucis " + kilometers + "km");
        }else if(oy == ny){
            kilometers = kilometers + (step_right * Math.abs(ny-oy));
            System.out.println("Tu esi nobraucis " + kilometers + "km");
        }else{
            System.out.println("Tu esi nobraucis pa pieskari es nemaku aprekinat brr...");
        }
    }
}
