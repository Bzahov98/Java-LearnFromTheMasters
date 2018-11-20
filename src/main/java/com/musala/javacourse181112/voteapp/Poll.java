package com.musala.javacourse181112.voteapp;

// :)
public class Poll {
    static int votesYes = 0, votesNo = 0, i =0;
    public static void main(final String[] args) {
        final int maxVoters = 30;
        final int maxQuestions = 2;

        final String[][] voters = new String[maxVoters][maxQuestions];

        System.out.println("Welcome!!!");

        PrintIn(1, "Do you like pizza?");

        // populate data
        for (int j = 0; j < maxQuestions; j++) {
            for (int i = 0; i < maxVoters; i++) {
                voters[i][j] = String.valueOf((i % 2) == 0 ? Vote.YES : Vote.NO);
            }
        }
        VoteCounter(maxVoters, voters,0);

        // count votes





        PrintIn(2, "Do you like snow?");
        VoteCounter(maxVoters, voters,1);
        System.out.println(maxVoters + " voted out of which " + votesYes + " voted Yes \nThe remaining " + votesNo + " voted NO.");
    }
    private static void PrintIn(int questionNumber, String questionContent){
        System.out.println("\nQuestion number: " + questionNumber + "  "+ questionContent);
    }
    private static void VoteCounter(int maxVoters, String[][] voters, int m){
        for (i = 0; i < maxVoters; i++) {
            if (String.valueOf(Vote.YES).equals(voters[i][m])) {
                votesYes++;
            } else {
                votesNo++;
            }
        }
     System.out.println(maxVoters + " voted out of which " + votesYes + " voted " + Vote.YES + " \nThe remaining " + votesNo + " voted " + Vote.NO + ".");
     }
}

