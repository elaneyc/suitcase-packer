
/**
 * Helper class for HeatIndexGenerator. Determines what season the provided
 * date is in
 * Note: Winter is 12/1 - 2/29
 *       Spring is 3/1- 5/31
 *       Summer is 6/1 - 8-31
 *       Fall is 9/1 - 11/30
 *
 * @author Elaney Cheng (echeng5)
 * @version 4/29/2019
 * 
 * */
import javafoundations.LinkedBinaryTree;
import java.text.SimpleDateFormat;
import java.text.ParseException;  
import java.util.Date;  

public class SeasonGenerator {
    // instance
    private Date date;
    private static LinkedBinaryTree<String> seasonTree;

    final private static SimpleDateFormat formatter = new SimpleDateFormat("MM-dd");  

    /**
     * Constructor for objects of class SeasonGenerator
     * 
     * @param date   the date for which you wish to determine what season it is
     */
    public SeasonGenerator(String date) {
        // Initialize instance vars
        try {
            this.date = formatter.parse(date);
        } catch (ParseException e) {
            System.out.println("Could not parse date" + e);
        }

        // Elements of the tree
        String date1 = "9-1";
        String date2 = "6-1";
        String date3 = "12-1";
        String date4 = "3-1";

        // Create the seasonTree
        LinkedBinaryTree<String> n1, n2, n3;
        n1 = new LinkedBinaryTree<String>(date4,
            new LinkedBinaryTree<String>("winter"),
            new LinkedBinaryTree<String>("spring"));
        n2 = new LinkedBinaryTree<String>(date3,
            new LinkedBinaryTree<String>("fall"),
            new LinkedBinaryTree<String>("winter"));
        n3 = new LinkedBinaryTree<String>(date2, n1,
            new LinkedBinaryTree<String>("summer"));
        seasonTree = new LinkedBinaryTree<String>(date1, n3, n2);                              
    }

    /** 
     * returns the season in which the date falls
     * 
     * @return   the season in which the date falls
     */
    public String determineSeason() {
        LinkedBinaryTree<String> current = seasonTree;

        // traverse the tree to determine what season it is
        while (current.size() > 1) { // not at a leaf (where the answer is stored)
            try {
                Date pivotDate = formatter.parse(current.getRootElement());

                if (date.compareTo(pivotDate) < 0)
                    current = current.getLeft();
                else
                    current = current.getRight();
            } catch (ParseException e) {
                // If there is an error with the date, break out of the loop
                System.out.println("Could not parse date" + e);
                break;
            }
        }
        return current.getRootElement();
    }
    
    /**
     * main for testing 
     */
    public static void main(String[] args) {
        // Cases that fall in the middle-ish of seasons
        SeasonGenerator winter1 = new SeasonGenerator("1-21");
        SeasonGenerator winter2 = new SeasonGenerator("12-15");
        SeasonGenerator spring = new SeasonGenerator("5-1");
        SeasonGenerator summer = new SeasonGenerator("6-23");
        SeasonGenerator fall = new SeasonGenerator("10-30");
        
        System.out.println("Should be winter: " + winter1.determineSeason());
        System.out.println("Should be winter: " + winter2.determineSeason());
        System.out.println("Should be spring: " + spring.determineSeason());
        System.out.println("Should be summer: " + summer.determineSeason());
        System.out.println("Should be fall: " + fall.determineSeason());
        
        // Edge cases
        SeasonGenerator winterStart = new SeasonGenerator("12-1");
        SeasonGenerator springEnd = new SeasonGenerator("5-31");
        SeasonGenerator summerStart = new SeasonGenerator("6-1");
        SeasonGenerator summerEnd = new SeasonGenerator("8-31");
        SeasonGenerator fallEnd = new SeasonGenerator("11-30");
        
        System.out.println("\n******************* Test starts/ends of"
                           + " seasons*******************");
        System.out.println("Should be winter: " + winterStart.determineSeason());
        System.out.println("Should be spring: " + springEnd.determineSeason());
        System.out.println("Should be summer: " + summerStart.determineSeason());
        System.out.println("Should be summer: " + summerEnd.determineSeason());
        System.out.println("Should be fall: " + fallEnd.determineSeason());
    }

}
