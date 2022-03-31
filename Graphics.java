import java.io.FileReader;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;


public class Graphics {
    
    String[] Banner;
    String[] GameCreators;

    public Graphics(){
        
        JSONParser jsonParser = new JSONParser();
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
            System.out.println("Something broke lmao ripaks");
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

    public void energyBar(int x){
        renderGraphics(setEnergy(resolveInt(x)));
    }
}
