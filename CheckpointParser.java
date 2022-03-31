import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class CheckpointParser {
    //parses the info in Checkpoints.json from JSON to java data structure(Map)

    private HashMap<String, HashMap<String, String>> checkpointMap = new HashMap<>();
    private HashMap<String, HashMap<String, String>> chargerMap = new HashMap<>();
    private Map<Integer, Character> alphabet;


    public CheckpointParser(){
        translate();
        //reads JSON file and returns Map<key = coordinate(X0), value = Map<key = attribute, value = value>>
        JSONParser jsonParser = new JSONParser();
        try(FileReader reader = new FileReader("Checkpoints.json");) {

            Object obj = jsonParser.parse(reader);
            JSONObject jsonObject = (JSONObject) obj;

            //READS CHECKPOINTS
            JSONArray checkpointsJSON = (JSONArray) jsonObject.get("checkpoints");    

            for(int i = 0; i < checkpointsJSON.size(); i++){
                int string = checkpointsJSON.get(i).toString().length() - 1;
                String[] jsonPart = checkpointsJSON.get(i).toString().substring(1, string).split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
                
                HashMap<String, String> attributes = new HashMap<>();
                for(int j = 0; j < jsonPart.length; j++){
                    String temp = jsonPart[j].substring(1, jsonPart[j].length() - 1);
                    String[] values = temp.split("\":\"");
            
                    if(values[0].charAt(0) != 'p'){
                        attributes.put(values[0], values[1]);
                    }else{
                        checkpointMap.put(values[1], attributes);
                    }
                }

            }

            //READS CHARGING STATIONS
            JSONArray chargersJSON = (JSONArray) jsonObject.get("chargers");

            for(int i = 0; i < chargersJSON.size(); i++){
                int string = chargersJSON.get(i).toString().length() - 1;
                String[] jsonPart = chargersJSON.get(i).toString().substring(1, string).split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
                
                HashMap<String, String> attributes = new HashMap<>();
                for(int j = 0; j < jsonPart.length; j++){
                    String temp = jsonPart[j].substring(1, jsonPart[j].length() - 1);
                    String[] values = temp.split("\":\"");
                    if(values[0].charAt(0) != 'p'){
                        attributes.put(values[0], values[1]);
                    }else{
                        chargerMap.put(values[1], attributes);
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Oh oh file not found this will be poopy...");
            e.printStackTrace();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public boolean isCheckPoint(String point){
        //returns true if a given coordinate(X0) is a check point
        boolean check = false;
        if(checkpointMap.containsKey(point)){check = true;}
        return check;
    }

    public boolean isChargeStation(String point){
        //returns true if a given coordinate(X0) is a charge station
        boolean check = false;
        if(chargerMap.containsKey(point)){check = true;}
        return check;
    }

    public HashMap <String, HashMap<String, String>> checkpointsInAMap(){
        return this.checkpointMap;
    }

    public HashMap <String, HashMap<String, String>> chargeStationsInAMap(){
        return this.chargerMap;
    }

    
    //HANDLING COORDINATE HUMAN FORMAT PARSING TO COMPUTER FORMAT
    public void translate(){
        alphabet = new HashMap<>();
        for(int i = 0; i < 26; i++){ 
            //creates a map where every letter of the alphabet has an according integer(1-26)
            alphabet.put(i, (char)(i + 17 + '0'));
        }
    }

    public int getInteger(String letter){
        int i = 0;
        while(alphabet.get(i) != letter.charAt(0)){
            i++;
            if(i == 26){
                i = -1;
                break;
            }
        }
        return i;
    }

    public char getLetter(int number){
        return alphabet.get(number);
    }
}
