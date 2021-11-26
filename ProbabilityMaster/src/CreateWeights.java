public class CreateWeights {

    private int numberOfWeights;
    private int[] weights;

    public CreateWeights(int now,int[] arr)
    {
        numberOfWeights = now;
        weights = arr;
    }

    public int[] GetWeights()
    {
        return weights;
    }

}
