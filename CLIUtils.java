public class CLIUtils{
    
    //helper returns ms
    public static int sec(int s){
        return s * 1000;
    }

    //helper pauses programs for x time
    public static void wait(int ms){
        try{
            Thread.sleep(ms);
        }
        catch(InterruptedException ex){
            Thread.currentThread().interrupt();
        }
    }

    //helper clears console
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

    public static void exitGame(){
        System.out.println("Thank you for playing!");
        System.exit(0);
    }
}
