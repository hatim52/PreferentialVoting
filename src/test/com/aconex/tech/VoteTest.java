package com.aconex.tech;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.util.HashMap;

public class VoteTest {
    File resourcesDirectory = new File("src/test/com/aconex/tech/resources/CandidateList.txt");

    @Test
    public void casteVoteTest1() {
        Candidate.readCandidateList (resourcesDirectory.getAbsolutePath ());
        String sampleVote = "ABCD";
        Vote v1=Vote.casteVote (sampleVote);
        if (v1 instanceof Vote) {
            Assert.assertEquals (v1.voteNumber, 1);
        }
    }

    @Test
    public void casteVoteTest2() {
        Candidate.readCandidateList (resourcesDirectory.getAbsolutePath ());
        String sampleVote = "ABCD";
        Vote v2=Vote.casteVote (sampleVote);
        Assert.assertEquals (Integer.parseInt (String.valueOf (v2.voteMap.get ('A'))), 1);
        Assert.assertEquals (Integer.parseInt (String.valueOf (v2.voteMap.get ('B'))), 2);
        Assert.assertEquals (Integer.parseInt (String.valueOf (v2.voteMap.get ('C'))), 3);
        Assert.assertEquals (Integer.parseInt (String.valueOf (v2.voteMap.get ('D'))), 4);
    }

    @Test
    public void casteVoteTest3() {
        Candidate.readCandidateList (resourcesDirectory.getAbsolutePath ());
        String sampleVote = "BA";
        Vote v3=Vote.casteVote (sampleVote);
        Assert.assertEquals (Integer.parseInt (String.valueOf (v3.voteMap.get ('A'))), 2);
        Assert.assertEquals (Integer.parseInt (String.valueOf (v3.voteMap.get ('B'))), 1);
        System.out.println (String.valueOf (v3.voteMap.get ('C')));
        Assert.assertEquals (Integer.parseInt (String.valueOf (v3.voteMap.get ('C'))), 0);
        Assert.assertEquals (Integer.parseInt (String.valueOf (v3.voteMap.get ('D'))), 0);
    }

    @Test
    public void casteVoteTest4() {
        Candidate.readCandidateList (resourcesDirectory.getAbsolutePath ());
        String sampleVote = "";
        Vote v4=Vote.casteVote (sampleVote);
        Assert.assertEquals (Integer.parseInt (String.valueOf (v4.voteMap.get ('A'))), 0);
        Assert.assertEquals (Integer.parseInt (String.valueOf (v4.voteMap.get ('B'))), 0);
        Assert.assertEquals (Integer.parseInt (String.valueOf (v4.voteMap.get ('C'))), 0);
        Assert.assertEquals (Integer.parseInt (String.valueOf (v4.voteMap.get ('D'))), 0);
    }

    @Test
    public void validateVoteSequenceTest() {
        Candidate.readCandidateList (resourcesDirectory.getAbsolutePath ());

        String sampleVote = "ABCD";
        Assert.assertEquals (Vote.validateVoteSequence (sampleVote),true);

        String sampleVotea = "A";
        Assert.assertEquals (Vote.validateVoteSequence (sampleVotea),true);

        String sampleVoteb = "D";
        Assert.assertEquals (Vote.validateVoteSequence (sampleVoteb),true);

        String sampleVotec = "AC";
        Assert.assertEquals (Vote.validateVoteSequence (sampleVotec),true);

        String sampleVoted = "BAD";
        Assert.assertEquals (Vote.validateVoteSequence (sampleVoted),true);

        String sampleVote1 = "AABC";
        Assert.assertEquals (Vote.validateVoteSequence (sampleVote1),false);

        String sampleVote2 = "XAFK";
        Assert.assertEquals (Vote.validateVoteSequence (sampleVote2),false);

        String sampleVote3 = "XAFK";
        Assert.assertEquals (Vote.validateVoteSequence (sampleVote3),false);

        String sampleVote4 = "!#^*&(*^($";
        Assert.assertEquals (Vote.validateVoteSequence (sampleVote4),false);

        String sampleVote5 = "1234";
        Assert.assertEquals (Vote.validateVoteSequence (sampleVote5),false);

        String sampleVote6 = "XAFK";
        Assert.assertEquals (Vote.validateVoteSequence (sampleVote6),false);
    }

    @Test
    public void getCandidateFromPreferenceTest(){
        Candidate.readCandidateList (resourcesDirectory.getAbsolutePath ());
        String sampleVote = "ABCD";
        Vote v1=Vote.casteVote (sampleVote);
        System.out.println (v1.getCandidateFromPreference (1) );
        Assert.assertEquals (String.valueOf (v1.getCandidateFromPreference (1)).charAt (0),'A');
        Assert.assertEquals (String.valueOf (v1.getCandidateFromPreference (2)).charAt (0),'B');
        Assert.assertEquals (String.valueOf (v1.getCandidateFromPreference (3)).charAt (0),'C');
        Assert.assertEquals (String.valueOf (v1.getCandidateFromPreference (4)).charAt (0),'D');
    }
}