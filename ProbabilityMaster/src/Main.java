import org.bouncycastle.util.test.Test;

import java.util.HashMap;
import java.util.Map;

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
        TestProbability tp = new TestProbability(1,3,pr);
        TestProbability tpTwo = new TestProbability(1,3,prTwo);
        TestProbability tpThree = new TestProbability(1,5,prThree);
        //Numbers closer to 1000 have greater weight
        TestProbability tpFour = new TestProbability(1, 1000, prFour);
        //Numbers closest to 500 have the greatest weight
        TestProbability tpFive = new TestProbability(1, 1000, prFive);
        tp.PrintValues(3);
        tp.PrintWeight();
        System.out.println();
        tpTwo.PrintValues(3);
        tpTwo.PrintWeight();
        System.out.println();
        tpThree.PrintValues(4);
        tpThree.PrintWeight();
        System.out.println();
        tpFour.PrintValues(5);
        tpFour.PrintWeight();
        System.out.println();
        tpFour.PrintValues(20);
        tpFour.PrintValues(20);
        tpFive.PrintWeight();
        tpFive.PrintValues(10);
        HashMap<Integer, String> mapIS = new HashMap<Integer, String>();
        mapIS.put(1, "First");
        mapIS.put(2, "Second");
        mapIS.put(3, "Third");
        TestProbability tpSix = new TestProbability(1,3,prTwo, mapIS);
        tpSix.PrintValues(3);
        //Sample game with two players and each with a randomized hand of 10 and a max of attack capability 5
        HashMap<Integer, String> gameMap = new HashMap<Integer, String>();
        gameMap.put(1, "Capability One");
        gameMap.put(2, "Capability Two");
        gameMap.put(3, "Capability Three");
        gameMap.put(4, "Capability Four");
        gameMap.put(5, "Capability Five");
        int[] attackWeights = new int[]{16,8,4,2,1};
        TestProbability playerOne = new TestProbability(1, 5, attackWeights, gameMap);
        TestProbability playerTwo = new TestProbability(1, 5, attackWeights, gameMap);
        System.out.println();
        System.out.println("Sample game with two players and each with a randomized hand of 10 and a max of attack capability 5: ");
        System.out.println("First Player Hand");
        playerOne.PrintValues(10);
        System.out.println("Second Player Hand");
        playerTwo.PrintValues(10);

        int[] weightForTPML = new int[]{3,2,4,4,4,9,7,8,2,7};
        // 2 examples of the
        //object tpML with 3 inputs
        //ranging from 1 to 10
        TestProbability tpML = new TestProbability(1, 10, weightForTPML);
        System.out.println("2 Examples of Object 1");
        tpML.PrintValues(3);
        tpML.PrintValues(3);
        System.out.println("FINISHED with 2 examples listed.");
        //Atmosphere Composition of Earth//
        int[] atmosphereWeights = new int[]{7808, 2095, 93, 4};

        HashMap<Integer, String> mapAtmosphere = new HashMap<Integer, String>();
        mapAtmosphere.put(1, "Nitrogen");
        mapAtmosphere.put(2, "Oxygen");
        mapAtmosphere.put(3, "Argon");
        mapAtmosphere.put(4, "Carbon Dioxide");
        TestProbability tpAtmosphere = new TestProbability(1, 4, atmosphereWeights,mapAtmosphere);
        tpAtmosphere.PrintValues(20);




    }

}
