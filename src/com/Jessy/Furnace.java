package com.Jessy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;

/**
 * Created by Jessy on 11/21/2015.
 */


// Furnace class extends ServiceCall class
public class Furnace extends ServiceCall{

    private int furnaceType;    // declaring furnaceType variable

    private static FurnaceTypeManager furnaceTypeManager;


    // Constructor for a Furnace class object
    public Furnace(String serviceAddress, String problemDescription, Date date, int furnaceType) {

        super(serviceAddress, problemDescription, date);   // address, description and date data comes from ServiceCall class

        this.furnaceType = furnaceType;   // Initializing furnaceType variable
    }


    // Using toString method to make variables get ready for a display
    @Override
    public String toString() {

        // if resolvedDate or resolution is null...  than display "Unresolved" otherwise, initialize a variables
        String typeString = furnaceTypeManager.getTypeString(furnaceType);
        String resolvedDateString = ( resolvedDate == null) ? "Unresolved" : this.resolvedDate.toString();
        String resolutionString = ( this.resolution == null) ? "Unresolved" : this.resolution;
        String feeString = (fee == UNRESOLVED) ? "Unresolved" : "$" + Double.toString(fee);


        return "Furnace " + "\n" +
                "Service Address= " + serviceAddress + "\n" +
                "Problem Description = " + problemDescription  + "\n" +
                "Furnace Type = " + typeString + "\n" +
                "Reported Date = " + reportedDate + "\n" +
                "Resolved Date = " + resolvedDateString + "\n" +
                "Resolution = " + resolutionString + "\n" +
                "Fee = " + feeString ;

    }


    //Inner class to collect the different varieties of furnace
    //When we ask for the type, we'll use the constants from this class to display the choice of types.

    protected static class FurnaceTypeManager {

        protected static final int FORCED_AIR = 1;
        protected static final int BOILER = 2;
        protected static final int OCTOPUS = 3;

        static HashMap<Integer, String> furnaceTypes;

        //Static initialization block
        static {
            furnaceTypes = new HashMap<Integer, String>();
            furnaceTypes.put(FORCED_AIR,"Forced Air");
            furnaceTypes.put(BOILER,"Boiler/Radiators");
            furnaceTypes.put(OCTOPUS,"Older 'Octopus' Style");
        }

        public static String getTypeString(int typeInt) {

            if (furnaceTypes.containsKey(typeInt)) {
                return furnaceTypes.get(typeInt);
            }
            else {
                return "Unknown type";
            }

        }

        public static String furnaceTypeUserChoices() {

            //Get all of the keys from the Hashmap and sort them in order
            ArrayList<Integer> keys = new ArrayList<Integer>(furnaceTypes.keySet());
            Collections.sort(keys);


            //Build and return a string of all the keys and their values
            String userChoices = "";
            for (Integer k : keys) {

                userChoices = userChoices + k + " : " + furnaceTypes.get(k) + "\n";

            }

            return userChoices;
        }

    }

}


