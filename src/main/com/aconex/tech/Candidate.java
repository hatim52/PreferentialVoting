package com.aconex.tech;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Candidate {
    //Creating a hashmap to store the candidates with their character notation.
    protected static HashMap<Character, String> candidates = new HashMap<> ();

    /**
     * Reads the candidates from a file location and updates the static candidates hashmap.
     * @param fileLocation
     */
    public static void readCandidateList (String fileLocation){
        char alphabet = 'A';
        try {
            //This java code reads in each word and puts it into the ArrayList:
            ArgumentValidator.checkArgumentNullOrEmpty (fileLocation);
            // Check if the location exits and is readable
            ArgumentValidator.checkLocationExists (fileLocation);
            ArgumentValidator.checkFileReadPermission (fileLocation);
            Scanner s = new Scanner (new File (fileLocation));
            while (s.hasNextLine( )) {
                String candidate = s.nextLine ( ).trim ( );
                if (candidate.equals ("")) {
                    continue;
                }
                candidates.put (alphabet,candidate );
                alphabet++;
            }
            s.close ( );
          //  for(String el : candidates){
            //    System.out.println(el);
            //}
        } catch (FileNotFoundException e) {
            e.printStackTrace ( );
        }
    }

    /**
     * Displays the candidate list on the console.
     */
    public static void displayCandidatesList(){
        for (Map.Entry<Character, String> entry : candidates.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue().toString());
        }
    }

    /**
     * Method returns the name of the candidate by passing the character which denotes the candidate int he candidate list.
     * @param candidateDenotor
     * @return
     */
    public static String getCandidateName(Character candidateDenotor){
        ArgumentValidator.checkArgumentNullOrEmpty (candidateDenotor);
        return candidates.get (candidateDenotor);
    }

    /**
     * Returns the number of candidates from the candidate list.
     * @return
     */
    public static int getCandidateCount(){
        return candidates.size ();
    }
}
