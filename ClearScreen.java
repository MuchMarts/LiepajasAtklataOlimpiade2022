public class ClearScreen{
    
    public static void ClearConsole(){
        try{
            String operatingSystem = System.getProperty("os.name"); //Check the current operating system
              
            if(operatingSystem.contains("Windows")){        
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                new ProcessBuilder("clear").inheritIO().start().waitFor();
            } 
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
