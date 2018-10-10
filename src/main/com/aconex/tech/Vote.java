package com.aconex.tech;
import jdk.nashorn.api.tree.EmptyStatementTree;

import java.util.HashMap;
import java.util.Map;

/**
 * Class to capture the operations on each Vote
 */
public class Vote {

    public static int voteCount;
    public static int candidateCount = Candidate.getCandidateCount ( );
    private static HashMap<Character, Integer> voteMapTemplate = new HashMap<Character, Integer> (generateEmptyVoteMap ( ));

    public int voteNumber;
    public HashMap<Character, Integer> voteMap;

    public static Vote casteVote(String votingSequence) {
        Vote thisInstance = new Vote (votingSequence);
        voteCount++;
        System.out.println ("Vote count is : " + voteCount);
        return thisInstance;
    }

    /**
     * Prints the vote result on the console
     */
    public void printVote() {
        for (Map.Entry<Character, Integer> entry : this.voteMap.entrySet ( )) {
            System.out.println (entry.getKey ( ) + ":" + entry.getValue ( ).toString ( ));
        }
    }

    /**
     * Generates an empty hasmap as a tempalte for voteMap
     * @return
     */
    private static HashMap<Character,Integer> generateEmptyVoteMap() {
        HashMap<Character, Integer> EmptyVoteMap = new HashMap<> ( );
        char alphabet = 'A';
        for (int i = 0; i < candidateCount; i++) {
            EmptyVoteMap.put (alphabet, 0);
            alphabet++;
        }
        return EmptyVoteMap;
    }

    /**
     * Private Constructor of Vote class which created a new voteMap for each vote
     * @param voteseq
     */
    private Vote(String voteseq) {
        voteMap = new HashMap<Character, Integer> (voteMapTemplate );
        //voteMap.putAll (voteMapTemplate);
        char alphabet = 'A';
        System.out.println ("Candidate count is "+Integer.toString (candidateCount) );
        char[] eachVote = voteseq.toCharArray ( );
        for (int j = 0; j < eachVote.length; j++) {
            voteMap.put (eachVote[j], j + 1);
        }
        printVote ();
        voteNumber = voteCount + 1;
    }

    /**
     * Validates whether the votesequence provided by user is valid or not.
     * @param voteseq
     * @return
     */
    public static boolean validateVoteSequence(String voteseq) {
        //Check if vote has any duplicate characters
        // An integer to store presence/absence
        // of 26 characters using its 32 bits.
        int checker = 0;
        for (int i = 0; i < voteseq.length ( ); ++i) {
            int val = (voteseq.charAt (i) - 'a');
            // If bit corresponding to current
            // character is already set
            if ((checker & (1 << val)) > 0)
                return false;
            // set bit in checker
            checker |= (1 << val);
            //Check if vote has any characters other than candidate list
            if (!voteMapTemplate.containsKey (voteseq.charAt (i)))
                return false;
        }
        return true;
    }

    /**
     * Provides the vote preference of the candidate based on the candinate denoter
     * @param preference
     * @return
     */
    public Character getCandidateFromPreference(Integer preference) {
        for (Map.Entry<Character, Integer> entry : voteMap.entrySet ( )) {
            if (entry.getValue ( ) == preference) {
                return entry.getKey ( );
            }
        }
        return null;
    }

}
