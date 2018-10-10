package com.aconex.tech;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;

public class CandidateTest {

    File resourcesDirectory = new File("src/test/com/aconex/tech/resources/CandidateList.txt");
    @Test
    public void readCandidateListTest(){
        Candidate.readCandidateList (resourcesDirectory.getAbsolutePath ());
        Assert.assertEquals (Candidate.candidates.get ('A'),"Winery tour" );
        Assert.assertEquals (Candidate.candidates.get ('B'),"Ten pin bowling" );
        Assert.assertEquals (Candidate.candidates.get ('C'),"Movie night" );
        Assert.assertEquals (Candidate.candidates.get ('D'),"Museum visit" );
        Assert.assertEquals (Candidate.candidates.get ('E'),null);
    }

    @Test
    public void getCandidateNameTest(){
        Candidate.readCandidateList (resourcesDirectory.getAbsolutePath ());
        Assert.assertEquals (Candidate.getCandidateName ('A'),"Winery tour" );
        Assert.assertEquals (Candidate.getCandidateName ('B'),"Ten pin bowling" );
        Assert.assertEquals (Candidate.getCandidateName ('C'),"Movie night" );
        Assert.assertEquals (Candidate.getCandidateName ('D'),"Museum visit" );
        Assert.assertEquals (Candidate.getCandidateName ('E'),null );
    }

    @Test
    public void getCandidateCountTest(){
        Assert.assertEquals (Candidate.getCandidateCount (),4);
    }
}
