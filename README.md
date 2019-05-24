# suitcase-packer
Uses us-weather-data dataset from 538 to return a recommended packing list for the specified date and location

## SuitcasePacker.java
Determines where the user is going, when they are going, and what clothes should
go in the suitcase based on the avg temp of the location on that day
## Closet.java
With the given heat index, this class will get the clothes (main outfit and
accessories).Uses hashtables which link heat indices to different outfits.
Has two different methods which use a heat index determined by the decision tree
in HeatIndexGenerator to decide which article of clothing to recommend within
the specified category of clothing.
## HeatIndexGenerator.java
Uses a SeasonGenerator to determine what season it is.
Contains a method that uses the average temperature in combination with the
season to determine the “heat index”, which is the key mapping to outfits in the
closet
## SeasonGenerator.java
Wrapper class for LinkedBinaryTree. Sets the decision nodes, pathways, and leaves in the constructor. 
Decision nodes help determine which season the date is in. The leaves represent
the season that the date falls in.
## WeatherData.java
Contains a method to return the average temperature at a specific airport on a
specific date. This is the method that other classes will call on.
Internally generates a map that contains airport codes as keys and its weather
hashtable as values. Takes the weather hashtables for each airport from the
CSVReader.
## CSVReader.java
Helps manipulates CSV files.
Creates a list of csv files & a list of strings where each string contains all the lines
in a single csv file. Generates a hashtable for a given CSV file where the date is the key and the
average temperature is its value.
