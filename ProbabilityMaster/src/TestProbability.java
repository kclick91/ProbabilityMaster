import java.util.HashMap;
import java.util.Random;

public class TestProbability {

    private int min;
    private int max;
    private int[] probabilities;//decided by an integer Weight
    private HashMap<Integer, Object> mapValues = new HashMap<>();//the values
    private String name;

    public TestProbability(int mn, int mx, int[] probs)
    {
        min = mn;
        max = mx;
        probabilities = probs;
    }
    public TestProbability(int mn, int mx, int[] probs,String nm)
    {
        min = mn;
        max = mx;
        probabilities = probs;
        name = nm;
    }

    public TestProbability(int mn, int mx, int[] probs, HashMap<Integer, Object> hm)
    {
        min = mn;
        max = mx;
        probabilities = probs;
        mapValues = hm;

    }

    public TestProbability(int mn, int mx, int[] probs, HashMap<Integer, Object> hm, String nm)
    {
        min = mn;
        max = mx;
        probabilities = probs;
        mapValues = hm;
        name = nm;
    }

    public void PrintWeight()
    {
        for (int i = 0; i < probabilities.length;i++)
        {
            System.out.println("Weight: " + probabilities[i] + " for number " + (i + 1) + " or " + mapValues.get(i + 1));
        }
    }
    //return returnedCount values
    public void PrintValues(int returnedCount)
    {
        System.out.println("Random numbers with different weights for " + name + ": ");
        int finalNumber = 0;
        int[] count = new int[returnedCount];
        int j = 0;
        do
        {
            Random r = new Random();
            int sum = 0;
            int[] sums = new int[probabilities.length];
            for (int k = 0; k < probabilities.length; k++)
            {
                sums[k] = 0;
            }
            for (int k = 0; k < probabilities.length; k++)
            {
                sum = sum + probabilities[k];
                sums[k] = sums[k] + sum;
            }
            int rand = r.nextInt(sum);
            //System.out.println("Rand " + rand);
            finalNumber = rand + min;
            int countT = 0;
            for (int i = min; i < max + 1; i++)
            {
                countT = countT + probabilities[i - 1];
                if (finalNumber <= countT)
                {
                    count[j] = i;
                    break;
                }
            }

            System.out.println(count[j] + " ");
            if (mapValues.get(count[j]) != null)
            {
                System.out.println(mapValues.get(count[j]));
            }

            j = j + 1;

        }while (j < returnedCount);

    }

    //Used for redistribution
    public int[] MoveWeights(int i, int j, int amount)
    {
        probabilities[i] = probabilities[i] - amount;
        probabilities[j] = probabilities[j] + amount;


        return probabilities;
    }
    public int[] MoveWeights(int i, int[] j, int amount) {
        probabilities[i] = probabilities[i] - amount;
        for (int p = 0; p < j.length; p++) {
            probabilities[p] = probabilities[p] + j[p];
        }
        return probabilities;
    }
    public void SetWeights(int[] probs)
    {
        probabilities = probs;
    }
    public int GetTotal()
    {
        int Sum = 0;
        for (int i = 0; i < probabilities.length; i++)
        {
            Sum = Sum + probabilities[i];

        }
        return Sum;
    }



}
