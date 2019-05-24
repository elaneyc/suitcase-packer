
/**
 * decides to what heat index an average temperature should map
 * the range of indices is from 1-16, with 1-4 mapping to winter
 * 5-8 mapping to fall, 9-12 mapping to spring, and 13-16
 * mapping to summer
 *
 * @author Elaney Cheng (echeng5)
 * @version 4/29/2019
 */
import javafoundations.LinkedBinaryTree;

public class HeatIndexGenerator {
    private String season;
    private int temperature;

    /**
     * constructor for objects of HeatIndexGenerator
     * 
     * @param date   the date 
     * @param avgTemp   the average temperature on date
     */
    public HeatIndexGenerator(String date, int avgTemp) {
        // initialize instance variables
        temperature = avgTemp;

        SeasonGenerator sGen = new SeasonGenerator(date);
        season = sGen.determineSeason();
    }

    /**
     * returns the related heat index to the temperature and season
     * 
     * @return   the related heat index to the temperature and season
     */
    public int getHeatIndex() {
        int index;
        
        if (temperature < 30) {
            index = 13;
        } else if (temperature >= 30 && temperature < 50) {
            index = 14;
        }  else if (temperature >= 50 && temperature < 70){
            index = 15;
        } else {
            index = 16;
        }
        // Scale index according to season
        if (season.equals("winter")){
            return index - 12;
        } else if (season.equals("fall")){
            return index - 8;
        } else if (season.equals("spring")){
            return index - 4;
        } else {
            return index;
        }
    }
    
    /**
     * main for testing
     */
    public static void main(String[] args) {
        // Test winter indices
        HeatIndexGenerator winterGen1 = new HeatIndexGenerator("12-31", 20);
        HeatIndexGenerator winterGen2 = new HeatIndexGenerator("1-11", 35);
        HeatIndexGenerator winterGen3 = new HeatIndexGenerator("1-26", 57);
        HeatIndexGenerator winterGen4 = new HeatIndexGenerator("2-18", 78);
        
        System.out.println("****************** Winter *******************");
        System.out.println("Heat index of below 30* (should be 1): "
                            + winterGen1.getHeatIndex());
        System.out.println("Heat index of betweeon 30* and 50* (should be 2): "
                            + winterGen2.getHeatIndex());
        System.out.println("Heat index of between 50* and 70* (should be 3): "
                            + winterGen3.getHeatIndex());
        System.out.println("Heat index of above 70* (should be 4): "
                            + winterGen4.getHeatIndex());
        
        // Test fall indices
        HeatIndexGenerator fallGen1 = new HeatIndexGenerator("11-30", 29);
        HeatIndexGenerator fallGen2 = new HeatIndexGenerator("11-15", 30);
        HeatIndexGenerator fallGen3 = new HeatIndexGenerator("10-1", 50);
        HeatIndexGenerator fallGen4 = new HeatIndexGenerator("9-1", 70);
        
        System.out.println("\n****************** Fall *******************");
        System.out.println("Heat index of below 30* (should be 5): "
                            + fallGen1.getHeatIndex());
        System.out.println("Heat index of betweeon 30* and 50* (should be 6): "
                            + fallGen2.getHeatIndex());
        System.out.println("Heat index of between 50* and 70* (should be 7): "
                            + fallGen3.getHeatIndex());
        System.out.println("Heat index of above 70* (should be 8): "
                            + fallGen4.getHeatIndex());
                            
        // Test spring indices
        HeatIndexGenerator springGen1 = new HeatIndexGenerator("3-1", 25);
        HeatIndexGenerator springGen2 = new HeatIndexGenerator("3-25", 32);
        HeatIndexGenerator springGen3 = new HeatIndexGenerator("4-2", 58);
        HeatIndexGenerator springGen4 = new HeatIndexGenerator("5-26", 76);
        
        System.out.println("\n****************** Spring *******************");
        System.out.println("Heat index of below 30* (should be 9): "
                            + springGen1.getHeatIndex());
        System.out.println("Heat index of betweeon 30* and 50* (should be 10): "
                            + springGen2.getHeatIndex());
        System.out.println("Heat index of between 50* and 70* (should be 11): "
                            + springGen3.getHeatIndex());
        System.out.println("Heat index of above 70* (should be 12): "
                            + springGen4.getHeatIndex());
                           
        // Test summer indices
        HeatIndexGenerator summerGen1 = new HeatIndexGenerator("6-1", -1);
        HeatIndexGenerator summerGen2 = new HeatIndexGenerator("6-23", 49);
        HeatIndexGenerator summerGen3 = new HeatIndexGenerator("7-15", 68);
        HeatIndexGenerator summerGen4 = new HeatIndexGenerator("8-26", 90);
        
        System.out.println("\n****************** Spring *******************");
        System.out.println("Heat index of below 30* (should be 13): "
                            + summerGen1.getHeatIndex());
        System.out.println("Heat index of betweeon 30* and 50* (should be 14): "
                            + summerGen2.getHeatIndex());
        System.out.println("Heat index of between 50* and 70* (should be 15): "
                            + summerGen3.getHeatIndex());
        System.out.println("Heat index of above 70* (should be 16): "
                            + summerGen4.getHeatIndex());
    }
}
