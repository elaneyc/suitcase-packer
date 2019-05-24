/**
 * Helper class for WeatherData. Reads in specific CSV files and can create hashtables with them.
 *
 * @author Christine Lam (clam4)
 * @version 4/29/2019
 */

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Scanner;

public class CSVReader {

    /**
     * Creates a list of csv files
     * 
     * @param String file path
     * @return List of Objects of type File
     */
    public static List<File> getFile(String path) { 
        List<File> result = new ArrayList<File>();
        File dir = new File(path);
        File[] csvDirectoryListing = dir.listFiles();
        if (csvDirectoryListing != null) {
            for (File child : csvDirectoryListing) {
                if (child.getName().endsWith(".csv")) { // checks if it's a .csv file
                    result.add(child);
                }
            }

        }
        return result;
    }

    /**
     * Returns a list of strings where each string contains all the lines
     * in a single csv file
     * 
     * @param File fileName
     * @return List of Objects of type String
     */
    public static List<String> getCSVLines(File fileName) {
        List<String> result = new ArrayList<String>();
        Scanner scan;
        try {
            scan = new Scanner(fileName);
            scan.useDelimiter(",");
            while (scan.hasNextLine()) {
                result.add(scan.nextLine());
            }
            scan.close();
        } catch (IOException e) {
            System.out.println(e);
        }
        return result;
    }

    /**
     * Generates a hashtable for a given CSV file where the date is the key and average temperature
     * is the value
     * 
     * @param List<String> List of Strings of lines in a CSV file
     * @return Hashtable that uses a date as the key and returns the average temperature 
     */
    public static Hashtable<String, Integer> getWeatherTable(List<String> csvLines) {
        Hashtable<String,Integer> weatherTable = new Hashtable<String,Integer>();
        csvLines.remove(0); // removes header of csv file that says 'date, mean_temp' etc
        for (String line : csvLines) {
            String[] splittedData = line.split(","); // spilts each line by comma
            weatherTable.put((splittedData[0]).substring(5), Integer.valueOf(splittedData[1])); // key = date (w/o year), value = temp
        }
        return weatherTable;
    }
    
    // testing for this file is within WeatherData
}