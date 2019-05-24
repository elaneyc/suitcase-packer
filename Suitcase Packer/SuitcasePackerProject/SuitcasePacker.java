
/**
 * The driver of the suitcase packer app
 *
 * @author Elaney Cheng (echeng5)
 * @version 5/14/2019
 */
import java.util.Scanner;

public class SuitcasePacker {
    // this will be filled with ICAO codes and corresponding locations
    public static final String[] LOCATIONS = {
            "KCLT: Charlotte Douglas International Airport, NC",
            "KCQT: USC Campus Downtown Airport, CA",
            "KHOU:  William P. Hobby Airport, Houston, TX",
            "KIND: Indianapolis International Airport, IN",
            "KJAX: Jacksonville International Airport, FL",
            "KMDW: Chicago Midway Airport, IL",
            "KNYC: Metropolitan Area, New York, New York",
            "KPHL:  Philadelphia International Airport, PA",
            "KPHX: Phoenix Sky Harbor International Airport, AZ",
            "KSEA: Seattle-Tacoma International Airport, WA"};

    public static void main (String[] args) {
        // Welcome the user and introduce them to the program
        System.out.println("CS230 Final Project. Suitcase Packer by " + 
            "Elaney Cheng, Christine Lam, and Eugenia Zhang \n");
        System.out.println("Welcome to the Suitcase Packer "
            + "- here to help you with all "
            + "of your packing needs!");
        System.out.println("First, you can enter your location and your "  
            + "day of travel.");
        System.out.println("Then, we'll return a list of recommended "
            + "items to pack.");
        System.out.println("Ready? Let's go!");     
        System.out.println("\nHere's a list of the locations and " 
            + "their corresponding ICAO codes:");
        
        // Iterate over locations and print it out
        for (int i = 0; i < LOCATIONS.length; i++) {
            System.out.println(i+1 + ". " + LOCATIONS[i]);
        }
        
        Scanner scanner = new Scanner(System.in);
        
        // Get the location from the user
        System.out.print("\nWhere are you going (enter ICAO code from list)? ");
        String location = scanner.nextLine();
        
        // Get the date from the user
        System.out.print("When will you be there (enter date in format M-D)? ");
        String date = scanner.nextLine();
        
        scanner.close();
        
        // Get the average temperature
        System.out.println("\nDetermining likely temperature...");
        WeatherData data = new WeatherData();
        int avgTemp = data.getAvgTemp(location, date);
        
        // Get the items to pack
        System.out.println("Getting clothes to pack...");
        HeatIndexGenerator generator = new HeatIndexGenerator(date, avgTemp);
        Closet closet = new Closet(generator.getHeatIndex());
        String outfit = closet.getMainOutfit();
        String accessories = closet.getAccessories();
        
        // Return results
        System.out.println("Your packing list is ready! "
                            + "\nIt will probably be around " + avgTemp 
                            + " degrees on " + date + " in " 
                            + location + ".\n\n" 
                            + outfit + "\n\n" + accessories);
                            
    }
}
