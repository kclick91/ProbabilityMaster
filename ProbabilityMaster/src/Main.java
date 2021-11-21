import org.bouncycastle.util.test.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Main {

    public static void main(String[] args)
    {
        System.out.println("WELCOME TO A NON-UNIFORM RANDOM NUMBER GENERATOR: ");
        int[] pr = new int[]{1,1,1};
        int[] prTwo = new int[]{5,1,1};
        int[] prThree = new int[]{1,2,9,3,4};
        int[] prFour = new int[1000];
        for (int j= 0; j < 1000; j++)
        {
            prFour[j] = j + 1;
        }
        int[] prFive = new int[1000];
        for (int j = 0; j < 1000; j++)
        {
            if (j < 500)
            {
                prFive[j] = 500 - (500 - (j + 1));
            }
            else if (j >= 500)
            {
                prFive[j] = 500 - ((j + 1) - 500);
            }

        }
        //Parameters are minimum, maximum, and weights
        TestProbability tp = new TestProbability(1,3,pr, "TP");
        TestProbability tpTwo = new TestProbability(1,3,prTwo, "TP Two");
        TestProbability tpThree = new TestProbability(1,5,prThree, "TP Three");
        //Numbers closer to 1000 have greater weight
        TestProbability tpFour = new TestProbability(1, 1000, prFour, "TP Four");
        //Numbers closest to 500 have the greatest weight
        TestProbability tpFive = new TestProbability(1, 1000, prFive, "TP Five");

        System.out.println("Example 1");
        tp.PrintValues(3);
        tp.PrintWeight();

        System.out.println();

        System.out.println("Example 2");
        tpTwo.PrintValues(3);
        tpTwo.PrintWeight();

        System.out.println();

        System.out.println("Example 3");
        tpThree.PrintValues(4);
        tpThree.PrintWeight();

        System.out.println();

        System.out.println("Example 4");
        tpFour.PrintValues(5);
        tpFour.PrintWeight();
        System.out.println();
        System.out.println("Example 5");
        tpFour.PrintValues(20);
        System.out.println("Example 6");
        tpFour.PrintValues(20);

        System.out.println("Example 7");
        tpFive.PrintWeight();
        tpFive.PrintValues(10);

        HashMap<Integer, Object> mapIS = new HashMap<Integer, Object>();
        mapIS.put(1, "First");
        mapIS.put(2, "Second");
        mapIS.put(3, "Third");
        TestProbability tpSix = new TestProbability(1,3,prTwo, mapIS);
        System.out.println("Example 8");
        tpSix.PrintValues(3);
        //Sample game with two players and each with a randomized hand of 10 and a max of attack capability 5
        HashMap<Integer, Object> gameMap = new HashMap<Integer, Object>();
        gameMap.put(1, "Capability One");
        gameMap.put(2, "Capability Two");
        gameMap.put(3, "Capability Three");
        gameMap.put(4, "Capability Four");
        gameMap.put(5, "Capability Five");
        int[] attackWeights = new int[]{16,8,4,2,1};
        TestProbability playerOne = new TestProbability(1, 5, attackWeights, gameMap);
        TestProbability playerTwo = new TestProbability(1, 5, attackWeights, gameMap);
        System.out.println();
        System.out.println("Example 9");
        System.out.println("Sample game with two players and each with a randomized hand of 10 and a max of attack capability 5: ");
        System.out.println("First Player Hand");
        playerOne.PrintValues(10);
        System.out.println("Example 10");
        System.out.println("Second Player Hand");
        playerTwo.PrintValues(10);

        int[] weightForTPML = new int[]{3,2,4,4,4,9,7,8,2,7};
        // 2 examples of the
        //object tpML with 3 inputs
        //ranging from 1 to 10
        TestProbability tpML = new TestProbability(1, 10, weightForTPML);
        System.out.println("2 Examples of Object 1");
        System.out.println("Example 11");
        tpML.PrintValues(3);
        System.out.println("Example 12");
        tpML.PrintValues(3);
        System.out.println("FINISHED with 2 examples listed.");



        //Atmosphere Composition of Earth//
        int[] atmosphereWeights = new int[]{7808, 2095, 93, 4};

        System.out.println("Samples from Earth's atmosphere by mole fraction: ");
        HashMap<Integer, Object> mapAtmosphere = new HashMap<Integer, Object>();
        mapAtmosphere.put(1, "Nitrogen");
        mapAtmosphere.put(2, "Oxygen");
        mapAtmosphere.put(3, "Argon");
        mapAtmosphere.put(4, "Carbon Dioxide");
        TestProbability tpAtmosphere = new TestProbability(1, 4, atmosphereWeights,mapAtmosphere);
        System.out.println("Example 13,14,15");
        System.out.println("Sample 1: ");
        tpAtmosphere.PrintValues(20);
        System.out.println("Sample 2: ");
        tpAtmosphere.PrintValues(20);
        System.out.println("Sample 3: ");
        tpAtmosphere.PrintValues(20);
        tpAtmosphere.PrintWeight();

        //Random Initial Positions Chess Pieces with a required additional King at the same spot
        int[] randomWeights = new int[]{8,2,2,2,1};
        HashMap<Integer, Object> chessPieces = new HashMap<Integer, Object>();
        chessPieces.put(1, "Pawn");
        chessPieces.put(2, "Rook");
        chessPieces.put(3, "Knight");
        chessPieces.put(4, "Bishop");
        chessPieces.put(5, "Queen");
        TestProbability tpChess = new TestProbability(1,5, randomWeights, chessPieces);
        System.out.println("Example 16");
        System.out.println("Random pieces to be placed on chess board.");
        tpChess.PrintValues(15);


        HashMap<Integer, Object> random = new HashMap<Integer, Object>();
        SampleObject so = new SampleObject(1, "Object One");
        SampleObject st = new SampleObject(2, "Object Two");
        random.put(1, so.Print());//Object should replace String
        random.put(2, st.Print());//Object should replace String
        int[] weights = new int[]{4,1};
        TestProbability tpFlip = new TestProbability(1,2, weights, random);

        System.out.println("Example 17");
        tpFlip.PrintValues(20);
        System.out.println("Example 18");
        //Hitter in Baseball
        //HR, 3B, 2B, 1B, walks, strikeouts
        int[] hittingPlayerOne = new int[]{1, 3, 4, 9, 9, 20};
        HashMap<Integer, Object> outcomes = new HashMap<Integer, Object>();
        outcomes.put(1, "HR");
        outcomes.put(2, "3B");
        outcomes.put(3, "2B");
        outcomes.put(4, "1B");
        outcomes.put(5, "Walk");
        outcomes.put(6, "Strikeout");
        TestProbability tpBatter = new TestProbability(1, 6, hittingPlayerOne, outcomes, "Baseball");
        //10 At Bats
        tpBatter.PrintValues(10);
        //Randomized problems/challenges
        System.out.println("Example 19");
        int[] difficulty = new int[]{1,3,1};
        HashMap<Integer,Object> diffMap = new HashMap<Integer, Object>();
        diffMap.put(1, "Easy");
        diffMap.put(2, "Medium");
        diffMap.put(3, "Hard");
        TestProbability tpDifficulty = new TestProbability(1,3,difficulty, diffMap);
        //10 problems
        tpDifficulty.PrintValues(10);

        //DNA-like weights
        System.out.println("Example 20(Focused on One at a Time)");
        int[] fivePersonality = new int[]{4,7,8,7,8};
        HashMap<Integer, Object> personalities = new HashMap<>();
        personalities.put(1, "Openness to Experience");
        personalities.put(2, "Conscientiousness");
        personalities.put(3, "Extraversion");
        personalities.put(4, "Agreeableness");
        personalities.put(5, "Neuroticism");
        TestProbability tpPersonalities = new TestProbability(1, 5, fivePersonality, personalities);
        //This shows a sample of how much of each one is shown at an instant
        //So, add up each instance Ex. There are 5 instances of Conscientiousness exhibited
        System.out.println("Day 1");
        tpPersonalities.PrintValues(20);
        System.out.println("Day 20(19 days later)");
        tpPersonalities.PrintValues(20);

        TPPack tpp = new TPPack();
        tpp.AddTP(tp);
        tpp.AddTP(tpAtmosphere);
        tpp.AddTP(tpBatter);
        tpp.AddTP(tpChess);
        tpp.AddTP(tpDifficulty);
        tpp.AddTP(tpFive);
        tpp.AddTP(tpFlip);
        tpp.AddTP(tpFlip);
        tpp.AddTP(tpFour);
        tpp.AddTP(tpML);
        tpp.AddTP(tpPersonalities);
        tpp.AddTP(tpSix);
        tpp.AddTP(tpThree);
        tpp.AddTP(tpTwo);
        tpp.AddTP(tp);
        tpp.GetTP().get(0).PrintValues(5);
        tpp.GetTP().get(3).PrintValues(5);











    }

}
