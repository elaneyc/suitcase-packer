
/**
 * Creates an outfit for user based on temperature/heat index information.
 *
 * @author ezhang5
 * @version 04/30/19
 */
import java.util.Hashtable; 
public class Closet {
    // instance variables
    private Hashtable<Integer, String> mainOutfit = new Hashtable<Integer, String>();
    private Hashtable<Integer, String> accessory = new Hashtable<Integer, String>();
    
    private int heatIndex;
    // Constructor
    /**
     * Constructor for objects of class Closet
     * 
     * @param 
     */
    public Closet(int heatNum) {
        // provide error message if heatNum is not valid
        if (heatNum < 1 || heatNum > 16) {
            System.out.println("This number is not valid. A number between"
                               + " 1 and 16 and required.");
        }
        
        
        // initialize inst var
        heatIndex = heatNum;
        
        
        // populate hashtables
        
        // main outfit Hashtable
        // winter
        for (int i = 1; i <= 2; i++) {
            mainOutfit.put(i, "snow/fleece pants, long sleeved shirts, "
                           + "down/puffer jacket, weather-proof boots");
        }
        for (int i = 3; i <= 4; i++) {
            mainOutfit.put(i, "snow/long pants, long sleeved shirts, "
                           + "down/puffer jacket, "
                           + "boots (snow, fur-lined, rain), sneakers");
        }
        // fall
        for (int i = 5; i <= 6; i++) {
            mainOutfit.put(i, "long sleeved shirts, down jacket, long "
                           + "pants, boots (rain, combat, leather), "
                           + "sneakers");
        }
        for (int i = 7; i <= 8; i++) {
            mainOutfit.put(i, "long sleeved shirt, sweater/jacket, long "
                           + "pants, jeans, boots (combat, leather), "
                           + "sneakers");
        }
        // spring
        for (int i = 9; i <= 10; i++) {
            mainOutfit.put(i, "short/long sleeved shirts, sweater/jacket"
                           + ", mid-length/short/long pants, closed-toe "
                           + "shoes (booties, flats, etc.), sneakers");
        }
        for (int i = 11; i <= 12; i++) {
            mainOutfit.put(i, "short sleeved shirts, light outerwear"
                           + ", mid-length/short pants, closed-toe "
                           + "shoes (booties, flats, etc.), sneakers");
        }
        // summer
        for (int i = 13; i <= 14; i++) {
            mainOutfit.put(i, "short sleeved shirts, short pants"
                           + ", sandals, sneakers");
        }
        for (int i = 15; i <= 16; i++) {
            mainOutfit.put(i, "high ventilation clothing material, tank "
                           + "top, short pants, sandals, sneakers");
        }
        
        
        // accessory hastable
        // winter
        for (int i = 1; i <= 4; i++) {
            accessory.put(i, "cozy hat, gloves, fuzzy socks, scarf");
        }
        // fall
        for (int i = 5; i <= 8; i++) {
            accessory.put(i, "lightweight scarf, gloves");
        }
        // spring
        for (int i = 9; i <= 12; i++) {
            accessory.put(i, "lightweight scarf");
        }
        // summer
        for (int i = 13; i <= 16; i++) {
            accessory.put(i, "sunglasses, fan, hat with a rim");
        }
    }

    /**
     * Traverses through the mainOutfit hashtable to retrieve 
     * clothing choice.
     * 
     * @return String - the value corresponding to given heat index number
     * from mainOutfit hashtable
     */
    public String getMainOutfit() {
        return "You should pack these clothing items:\n" + mainOutfit.get(heatIndex);
    }

    /**
     * Traverses through the accessory hashtable to retrieve 
     * accessory choice.
     * 
     * @return String - the value corresponding to given heat index number
     * from accessory hashtable
     */
    public String getAccessories() {
        return "You should pack these accessory items:\n" + accessory.get(heatIndex);
    }

    /**
     * Driver method - for testing purposes
     */
    public static void main (String[] args) {
        System.out.println("Creating Valid Closet Objects...\n\n");
        // Create Closet Objects (make one closet (4) for each index range, 
        //and a couple for some "border" (4) cases, and 2 for invalid heat 
        // indices)
        Closet rangeWinter = new Closet(2);
        Closet rangeWinterAgain = new Closet(4);
        Closet rangeFall = new Closet(5);
        Closet rangeSpring = new Closet(11);
        Closet rangeSummer = new Closet(14);
        
        Closet borderWinter = new Closet(1);
        Closet borderFall = new Closet(8);
        Closet borderSpring = new Closet(9);
        Closet borderSummer = new Closet(16);
        
        // range tests
        System.out.println("******************* Testing"
                           + " Heat Index Ranges *******************\n");
                           
        System.out.println("Should print out:\nYou should pack these "
                           + "clothing items:\nsnow/fleece pants, long sleeved shirts, "
                           + "down/puffer jacket, weather-proof boots\nYou "
                           + "should pack these accessory items:\ncozy hat, "
                           + "gloves,fuzzy socks, scarf\n");
        System.out.println(rangeWinter.getMainOutfit());
        System.out.println(rangeWinter.getAccessories());
        
        System.out.println("\n\nShould print out:\nYou should pack these "
                           + "clothing items:\nsnow/long pants, long sleeved shirts, "
                           + "down/puffer jacket, boots (snow, fur-lined, "
                           + "rain), sneakers\nYou should pack "
                           + "these accessory items:\ncozy hat, gloves, "
                           + "fuzzy socks, scarf\n");
        System.out.println(rangeWinterAgain.getMainOutfit());
        System.out.println(rangeWinterAgain.getAccessories());
        
        System.out.println("\n\nShould print out:\nlong sleeved shirts, down jacket, long "
                           + "pants, boots (rain, combat, leather), "
                           + "sneakers\nYou should pack "
                           + "these accessory items:\nlightweight scarf, "
                           + "gloves\n");
        System.out.println(rangeFall.getMainOutfit());
        System.out.println(rangeFall.getAccessories());
        
        System.out.println("\n\nShould print out:\nYou should pack these "
                           + "clothing items:\nshort sleeved shirts, light outerwear"
                           + ", mid-length/short pants, closed-toe "
                           + "shoes (booties, flats, etc.), sneakers\nYou"
                           + "should pack these accessory "
                           + "items:\nlightweight scarf\n");
        System.out.println(rangeSpring.getMainOutfit());
        System.out.println(rangeSpring.getAccessories());
        
        System.out.println("\n\nShould print out:\nYou should pack these "
                           + "clothing items:\nshort sleeved shirts, short pants"
                           + ", sandals, sneakers\nYou "
                           + "should pack these accessory items:\n"
                           + "sunglasses, fan, hat with a rim\n");
        System.out.println(rangeSummer.getMainOutfit());
        System.out.println(rangeSummer.getAccessories());
        
        // border tests
        System.out.println("\n\n******************* Testing"
                           + " Border Heat Indices *******************\n");
        
        System.out.println("Should print out:\nYou should pack these "
                           + "clothing items:\nsnow/fleece pants, long sleeved shirts, "
                           + "down/puffer jacket, weather-proof boots\nYou "
                           + "should pack these accessory items:\ncozy hat, "
                           + "gloves,fuzzy socks, scarf\n");
        System.out.println(borderWinter.getMainOutfit());
        System.out.println(borderWinter.getAccessories());
        
        System.out.println("\n\nShould print out:\nYou should pack these "
                           + "clothing items:\nlong sleeved shirt, sweater/jacket, long "
                           + "pants, jeans, boots (combat, leather), "
                           + "sneakers\nYou should pack "
                           + "these accessory items:\nlightweight scarf, "
                           + "gloves\n");
        System.out.println(borderFall.getMainOutfit());
        System.out.println(borderFall.getAccessories());
        
        System.out.println("\n\nShould print out:\nYou should pack these "
                           + "clothing items:\nshort/long sleeved shirts, sweater/jacket"
                           + ", mid-length/short/long pants, closed-toe "
                           + "shoes (booties, flats, etc.), sneakers\nYou"
                           + "should pack these accessory "
                           + "items:\nlightweight scarf\n");
        System.out.println(borderSpring.getMainOutfit());
        System.out.println(borderSpring.getAccessories());
        
        System.out.println("\n\nShould print out:\nYou should pack these "
                           + "clothing items:\nhigh ventilation clothing material, tank "
                           + "top, short pants, sandals, sneakers\nYou "
                           + "should pack these accessory items:\n"
                           + "sunglasses, fan, hat with a rim\n");
        System.out.println(borderSummer.getMainOutfit());
        System.out.println(borderSummer.getAccessories());
        
        // error tests
        System.out.println("\n\n******************** Testing"
                           + " Error Heat Index ********************\n");
                           
        System.out.println("Should print out:\nThis number is not valid. "
                           + "A number between 1 and 16 and required.\n");
        Closet error2 = new Closet(20);
        System.out.println("\n\nShould print out:\nThis number is not valid. "
                           + "A number between 1 and 16 and required.\n");
        Closet error1 = new Closet(0);
    }
}
