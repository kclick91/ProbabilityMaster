import org.bouncycastle.util.test.Test;

public class Main {

    public static void main(String[] args)
    {
        System.out.println("WELCOME TO A WEIGHTED RANDOM NUMBER GENERATOR: ");
        int[] pr = new int[]{1,1,1};
        int[] prTwo = new int[]{5,1,1};
        int[] prThree = new int[]{1,2,9,3,4};
        //Parameters are minimum, maximum, and weights
        TestProbability tp = new TestProbability(1,3,pr);
        TestProbability tpTwo = new TestProbability(1,3,prTwo);
        TestProbability tpThree = new TestProbability(1,5,prThree);
        tp.PrintValues(3);
        System.out.println();
        tpTwo.PrintValues(3);
        System.out.println();
        tpThree.PrintValues(4);


    }

}
