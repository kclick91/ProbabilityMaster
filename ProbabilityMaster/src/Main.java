import org.bouncycastle.util.test.Test;

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



    }

}
