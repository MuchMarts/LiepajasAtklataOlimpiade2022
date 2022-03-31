import java.io.FileReader;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;


public class Graphics {
    
    String[] Banner;
    String[] GameCreators;
    String[] rain;
    String[] sun;

    public Graphics(){
        
        JSONParser jsonParser = new JSONParser();
        //this could have been a loop but i cant bother
        try {
            FileReader reader = new FileReader("Graphics.json");
            //Read JSON file
            Object obj = jsonParser.parse(reader);
            JSONObject jsonObject = (JSONObject) obj;

            JSONArray banner = (JSONArray) jsonObject.get("banner");
            Object[] banner_arr = banner.toArray();
            String[] banner_str = new String[banner_arr.length];
            for(int i = 0; i < banner_arr.length; i++){
                banner_str[i] = banner_arr[i].toString();
            }
            this.Banner = banner_str;

            JSONArray creators = (JSONArray) jsonObject.get("creators");
            Object[] creators_arr = creators.toArray();
            String[] creators_str = new String[creators_arr.length];
            for(int i = 0; i < creators_arr.length; i++){
                creators_str[i] = creators_arr[i].toString();
            }
            this.GameCreators = creators_str;

            JSONArray rain_cloud = (JSONArray) jsonObject.get("rain");
            Object[] rain_arr = rain_cloud.toArray();
            String[] rain_str = new String[rain_arr.length];
            for(int i = 0; i < rain_arr.length; i++){
                rain_str[i] = rain_arr[i].toString();
            }
            this.rain = rain_str;

            JSONArray sunny = (JSONArray) jsonObject.get("sun");
            Object[] sun_arr = sunny.toArray();
            String[] sun_str = new String[sun_arr.length];
            for(int i = 0; i < sun_arr.length; i++){
                sun_str[i] = sun_arr[i].toString();
            }
            this.sun = sun_str;
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("something went poopy");
        }
        
        
    }
    
    public void IntroAnimation(){
        System.out.println("\n\n\n");
        gameCreators();
        System.out.println("\n\n\n");
        CLIUtils.wait(CLIUtils.sec(3));
        CLIUtils.ClearConsole();

        System.out.println("\n\n");
        banner();
        System.out.println("\n");
        CLIUtils.wait(CLIUtils.sec(1));
    }

    private void renderGraphics(String[] graphic){
        for(String line : graphic){
            System.out.println(line);
        }
    }
    
    private String resolveInt(int x){
        String line = "000";
        if(x > 99 && x < 999){
            line = String.valueOf(x);
        } else if ( x < 100 && x >= 10){
            line = "0" + String.valueOf(x);
        } else if (x < 10 && x >= 0){
            line = "00" + String.valueOf(x);
        } else {
            System.out.println("Ran out of batterry ;-;");
        }
        return ("  ###    "+line+"%    ### ");
    }

    private String[] setEnergy(String xx){
        String[] energyASCII = {
            "\nBattery Charge",
            "[=====================]",
            xx,
            "[=====================]\n"
        };
        return energyASCII;
    }

    public void banner(){
        //renderGraphics(setBanner());
        renderGraphics(this.Banner);
    }

    public void gameCreators(){
        //renderGraphics(setGameCreators());
        renderGraphics(this.GameCreators);
    }

    public void rainAnimation(){
        renderGraphics(this.rain);
    }

    public void sunAnimation(){
        renderGraphics(this.sun);
    }

    public void energyBar(int x){
        renderGraphics(setEnergy(resolveInt(x)));
    }

    public void colourRoad(){
        System.out.print(
            ConsoleColour.WHITE_BOLD_BRIGHT + GameSettings.road + " " + ConsoleColour.RESET
        );
    }
    public void colourCheckPoint(){
        System.out.print(
            ConsoleColour.YELLOW_BACKGROUND + GameSettings.checkPoint + " " + ConsoleColour.RESET
        );
    }
    public void colourChargePoint(){
        System.out.print(
            ConsoleColour.GREEN_BACKGROUND + GameSettings.chargePoint+ " " + ConsoleColour.RESET
        );
    }
    public void colourPlayer(){
        System.out.print(
            ConsoleColour.RED_BOLD + GameSettings.player + " " + ConsoleColour.RESET
        );
    }
    public void colourEmpty(){
        System.out.print(
            ConsoleColour.BLACK + GameSettings.empty + " " + ConsoleColour.RESET
        );
    }
}
