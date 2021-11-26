import javax.print.attribute.HashAttributeSet;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Main {


    public static int[] Pay(int payerTotal, int recipientTotal, int amount)
    {
        payerTotal = payerTotal - amount;
        recipientTotal = recipientTotal + amount;

        return new int[]{payerTotal, recipientTotal};
    }
    public static void main(String[] args)
    {
        System.out.println("WELCOME TO A NON-UNIFORM RANDOM NUMBER GENERATOR: ");
        Examples();

    }

    public static void Examples()
    {
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
        TPPack tppAll = new TPPack();
        System.out.println("EXAMPLE 1");
        System.out.println("==========");
        tppAll.AddTP(tp);
        tppAll.AddTP(tpTwo);
        tppAll.AddTP(tpThree);
        tppAll.AddTP(tpFour);
        tppAll.AddTP(tpFive);
        tp.PrintValues(3);
        //tp.PrintWeight();

        System.out.println();

        System.out.println("EXAMPLE 2");
        System.out.println("==========");
        tpTwo.PrintValues(3);
        //tpTwo.PrintWeight();

        System.out.println();

        System.out.println("EXAMPLE 3");
        System.out.println("==========");
        tpThree.PrintValues(4);
        //tpThree.PrintWeight();

        System.out.println();

        System.out.println("EXAMPLE 4");
        System.out.println("==========");
        tpFour.PrintValues(5);
        //tpFour.PrintWeight();
        System.out.println();
        System.out.println("EXAMPLE 5");
        System.out.println("==========");
        tpFour.PrintValues(20);
        System.out.println("EXAMPLE 6");
        System.out.println("==========");
        tpFour.PrintValues(20);

        System.out.println("EXAMPLE 7");
        System.out.println("==========");
        //tpFive.PrintWeight();
        tpFive.PrintValues(10);

        HashMap<Integer, Object> mapIS = new HashMap<Integer, Object>();
        mapIS.put(1, "First");
        mapIS.put(2, "Second");
        mapIS.put(3, "Third");
        TestProbability tpSix = new TestProbability(1,3,prTwo, mapIS);
        System.out.println("EXAMPLE 8");
        System.out.println("==========");
        tpSix.PrintValues(3);
        tppAll.AddTP(tpSix);
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
        System.out.println("EXAMPLE 9");
        System.out.println("==========");
        System.out.println("Sample game with two players and each with a randomized hand of 10 and a max of attack capability 5: ");
        System.out.println("First Player Hand");
        playerOne.PrintValues(10);
        System.out.println("EXAMPLE 10");
        System.out.println("==========");
        System.out.println("Second Player Hand");
        playerTwo.PrintValues(10);

        int[] weightForTPML = new int[]{3,2,4,4,4,9,7,8,2,7};
        // 2 examples of the
        //object tpML with 3 inputs
        //ranging from 1 to 10
        TestProbability tpML = new TestProbability(1, 10, weightForTPML);
        System.out.println("2 Examples of Object 1");
        System.out.println("EXAMPLE 11");
        System.out.println("==========");
        tpML.PrintValues(3);
        System.out.println("EXAMPLE 12");
        System.out.println("==========");
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
        System.out.println("EXAMPLES 13,14,15");
        System.out.println("==========");
        System.out.println("Sample 1: ");
        tpAtmosphere.PrintValues(20);
        System.out.println("Sample 2: ");
        tpAtmosphere.PrintValues(20);
        System.out.println("Sample 3: ");
        tpAtmosphere.PrintValues(20);
        //tpAtmosphere.PrintWeight();

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
        System.out.println("==========");
        System.out.println("Random pieces to be placed on chess board.");
        tpChess.PrintValues(15);


        HashMap<Integer, Object> random = new HashMap<Integer, Object>();
        SampleObject so = new SampleObject(1, "Object One");
        SampleObject st = new SampleObject(2, "Object Two");
        random.put(1, so);
        random.put(2, st);
        int[] weights = new int[]{4,1};
        TestProbability tpFlip = new TestProbability(1,2, weights, random);

        System.out.println("EXAMPLE 17");
        System.out.println("==========");
        tpFlip.PrintValues(20);
        System.out.println("EXAMPLE 18");
        System.out.println("==========");
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
        System.out.println("EXAMPLE 19");
        System.out.println("==========");
        int[] difficultyLevelOne = new int[]{1,3,1};
        int[] difficultyLevelTwo = new int[]{1,1,3};
        Weights cwLevelOne = new Weights(3, difficultyLevelOne, "Level One");
        Weights cwLevelTwo = new Weights(3, difficultyLevelTwo, "Level Two");

        HashMap<Integer,Object> diffMap = new HashMap<Integer, Object>();
        diffMap.put(1, "Easy");
        diffMap.put(2, "Medium");
        diffMap.put(3, "Hard");
        TestProbability tpDifficulty = new TestProbability(1,3,cwLevelOne.GetWeights(), diffMap);
        TestProbability tpDifficultyTwo = new TestProbability(1,3,cwLevelTwo.GetWeights(), diffMap);
        //10 problems
        System.out.println("Level One");
        tpDifficulty.PrintValues(10);
        System.out.println("Level Two");
        tpDifficultyTwo.PrintValues(10);

        //DNA-like weights
        System.out.println("EXAMPLE 20(Focused on One at a Time)");
        System.out.println("==========");
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
        System.out.println("EXAMPLE 21");
        System.out.println("==========");
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

        System.out.println("EXAMPLE 22");
        System.out.println("==========");
        int[] decisionSet1 = new int[]{3,5,3};
        HashMap<Integer, Object> hashMap = new HashMap<>();

        hashMap.put(1, "Decision A");
        hashMap.put(2, "Decision B");
        hashMap.put(3, "Decision C");


        int[] decisionSet2 = new int[]{2,3,2};
        HashMap<Integer, Object> hashMapTwo = new HashMap<>();

        hashMapTwo.put(1, "Decision 1");
        hashMapTwo.put(2, "Decision 2");
        hashMapTwo.put(3, "Decision 3");
        TestProbability tpDecOne = new TestProbability(1, 3, decisionSet1, hashMap, "First Decision");
        TestProbability tpDecTwo = new TestProbability(1, 3, decisionSet2, hashMapTwo, "Second Decision");

        TPPack tppTwo = new TPPack();
        tppTwo.AddTP(tpDecOne);
        tppTwo.AddTP(tpDecTwo);
        tppTwo.GetTP().get(0).PrintValues(1);
        tppTwo.GetTP().get(1).PrintValues(1);

        int count = 15;
        int countTwo = 5;
        int countThree = 10;
        int[] weightsPay = new int[]{5,6,5,2,9,9};
        //simulate economic activity
        //count --> countTwo
        //countTwo --> countThree
        //countThree --> count
        //count --> countThree
        //countThree --> countTwo
        //countTwo --> count
        //int[] afterPayment = Pay(count, countTwo, 7);
        //count = afterPayment[0];
        //countTwo = afterPayment[1];
        HashMap hmPayments = new HashMap<>();
        hmPayments.put(1, "Account One pays Two");
        hmPayments.put(2, "Account Two pays Three");
        hmPayments.put(3, "Account Three pays One");
        hmPayments.put(4, "Account One pays Three");
        hmPayments.put(5, "Account Three pays Two");
        hmPayments.put(6, "Account Two pays One");
        TestProbability tpPay = new TestProbability(1, 6, weightsPay, hmPayments, "EconActivitySimulation");
        tpPay.PrintValues(5);//5 transactions

        //Different stages of development of a project
        System.out.println("EXAMPLE 22");
        System.out.println("==========");
        HashMap hmStages = new HashMap<>();
        hmStages.put(1, "Plan");
        hmStages.put(2, "Requirements");
        hmStages.put(3, "Design");
        hmStages.put(4, "Implementation");
        hmStages.put(5, "Test");
        hmStages.put(6, "Maintenance");
        int[] weightStages = new int[]{5,3,2,1,1,0};
        TestProbability tpStages = new TestProbability(1,6,weightStages, hmStages, "PROJECT");
        //Stages decided at random
        tpStages.PrintValues(20);
        //Adjust weights
        int[] weightStagesTwo = new int[]{2,2,6,1,1,0};
        TestProbability tpStages2 = new TestProbability(1,6,weightStagesTwo, hmStages, "PROJECT");
        tpStages2.PrintValues(20);

        System.out.println("EXAMPLE 23");
        System.out.println("==========");
        //Fiction writing
        HashMap<Integer, Object> hmWriting = new HashMap<>();
        int[] weightsWriting = new int[]{2,3,5,5,4};
        hmWriting.put(1, "Create New City");
        hmWriting.put(2, "Create New Character");
        hmWriting.put(3, "Create New Conflict");
        hmWriting.put(4, "Revise");
        hmWriting.put(5, "Create New Fictional Technology");
        TestProbability tpWriting = new TestProbability(1,5, weightsWriting, hmWriting, "Novel");
        tpWriting.PrintValues(10);
        System.out.println("Total: " + tpWriting.GetTotal());

        //Example 23 using Example class
        System.out.print("Example 23 using Example class");
        Example examp = new Example(tpWriting, 5);
        examp.PrintExample();
    }
}
