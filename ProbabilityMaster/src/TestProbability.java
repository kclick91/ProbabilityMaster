import java.util.HashMap;
import java.util.Random;

public class TestProbability {

    public int min;
    public int max;
    public int[] probabilities;//decided by an integer Weight
    public HashMap<Integer, String> mapValues = new HashMap<>();//the values

    public TestProbability(int mn, int mx, int[] probs)
    {
        min = mn;
        max = mx;
        probabilities = probs;
    }

    public TestProbability(int mn, int mx, int[] probs, HashMap<Integer, String> hm)
    {
        min = mn;
        max = mx;
        probabilities = probs;
        mapValues = hm;

    }

    public void PrintWeight()
    {
        for (int i = 0; i < probabilities.length;i++)
        {
            System.out.println("Weight: " + probabilities[i] + " for number " + (i + 1));
        }
    }

    //return returnedCount values
    public void PrintValues(int returnedCount)
    {
        System.out.println("Random numbers with different weights: ");
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


}
