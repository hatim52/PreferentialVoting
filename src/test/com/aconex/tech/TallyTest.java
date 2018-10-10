package com.aconex.tech;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.sql.SQLOutput;
import java.util.ArrayList;

public class TallyTest {
    File resourcesDirectory = new File("src/test/com/aconex/tech/resources/CandidateList.txt");

    @Test
    public void getWinnerTest1(){
        Candidate.readCandidateList (resourcesDirectory.getAbsolutePath ());
        ArrayList<Vote> voteList = new ArrayList<Vote> ();
        voteList.add (Vote.casteVote ("ABCD"));
        voteList.add (Vote.casteVote ("BAD"));
        voteList.add (Vote.casteVote ("CABD"));
        voteList.add (Vote.casteVote ("CDAB"));
        voteList.add (Vote.casteVote ("DA"));
        voteList.add (Vote.casteVote ("DB"));
        voteList.add (Vote.casteVote ("BAC"));
        voteList.add (Vote.casteVote ("CBAD"));

        String Win = new Tally(voteList).getWinner();
        ArgumentValidator.checkArgumentNullOrEmpty (Win);
        System.out.println ("Winner is "+Win );
        Assert.assertEquals (Win,"Ten pin bowling");
    }

    @Test
    public void getWinnerTest2(){
        Candidate.readCandidateList (resourcesDirectory.getAbsolutePath ());
        ArrayList<Vote> voteList = new ArrayList<Vote> ();
        voteList.add (Vote.casteVote ("ACD"));
        voteList.add (Vote.casteVote ("BD"));
        voteList.add (Vote.casteVote ("ABC"));
        voteList.add (Vote.casteVote ("CD"));
        voteList.add (Vote.casteVote ("B"));
        voteList.add (Vote.casteVote ("ACDB"));
        String Win = new Tally(voteList).getWinner();
        ArgumentValidator.checkArgumentNullOrEmpty (Win);
        Assert.assertEquals (Win,"Winery tour");
    }
}
