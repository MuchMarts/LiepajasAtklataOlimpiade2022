import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Leaderboard {
    
    private String doc = "Leaderboard.txt";
    private Boolean validFile = true;
    private ArrayList<String> allResults = new ArrayList<>();
    private String[] rankedScores;
    
    public void addResult(String gameTime, String name){
        try {
            File leaderboard = new File(doc);
            
            if (leaderboard.createNewFile()) {
                } else {
                    }
            }   
        catch (IOException e) {
            e.printStackTrace();
            }
        try {
            FileWriter resultWriter = new FileWriter(doc, true);
            
            resultWriter.write(name + " > " + gameTime + "\n");
            resultWriter.close();
            } 
        catch (IOException e) {
            e.printStackTrace();
            }
    }
    public void deleteResult() {
        try {
            File leaderboard = new File(doc); 
            leaderboard.delete();
            leaderboard.createNewFile();
            }
        catch (IOException e) {
            e.printStackTrace();
            }
    }        
        
    private void bestTimes() {
        try {
            File rDoc = new File(doc);
            Scanner rRead = new Scanner(rDoc);
            
            while (rRead.hasNextLine()) {
                String temp_thing = rRead.nextLine();
                allResults.add(temp_thing);
                }

                rRead.close();
            } 
        catch (FileNotFoundException e){
            e.printStackTrace();
            }

        int[] formatedData = new int[allResults.size()];
        int[] ascendIndex = new int[allResults.size()];

        for (int i = 0; i < allResults.size(); i++) {

            String laiks = allResults.get(i);
            int index = laiks.indexOf(">") + 2;
            
            try {
                String min_sek = laiks.substring(index);
                LocalTime localTime = LocalTime.parse(min_sek);
                int millis = localTime.toSecondOfDay() * 1000;
                formatedData[i] = millis;
                ascendIndex[i] = i;
                } 
            catch (StringIndexOutOfBoundsException e) {
                validFile = false;
                break;
                }  
            }
        int n = formatedData.length; 
        for (int i = 0; i < n-1; i++)
            { 
            for (int j = 0; j < n-i-1; j++)
                { 
                if (formatedData[j] > formatedData[j+1]) 
                    { 
                    int temp = formatedData[j]; 
                    formatedData[j] = formatedData[j+1]; 
                    formatedData[j+1] = temp;
                    
                    temp = ascendIndex[j];
                    ascendIndex[j] = ascendIndex[j+1];
                    ascendIndex[j+1] = temp; 
                    }
                }
            }
            rankedScores = new String[allResults.size()];
        
        for (int i = 0; i < allResults.size(); i++){
            rankedScores[i] = allResults.get(ascendIndex[i]);
            }
    }

    public void showBestTimes(){
        bestTimes();

        if (validFile){
            if ( 0 < rankedScores.length && rankedScores.length < 5){
                System.out.println((rankedScores.length) + " fastest times.");
                for (int i = 0; i < rankedScores.length; i++){
                    System.out.println((1 + i)+ ". " + rankedScores[i]);
                    }
                } 
            else if (rankedScores.length >= 5){
                System.out.print(5 + " fastest times.\n");
                for (int i = 0; i < 5; i++){
                System.out.println((1 + i)+ ". " + rankedScores[i]);
                } 
            } else {
                System.out.print("Leaderboard not found!");
                } 
            }
    }

}