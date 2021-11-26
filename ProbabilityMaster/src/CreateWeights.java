public class CreateWeights {

    private int numberOfWeights;
    private int[] weights;
    private String name;

    public CreateWeights(int now,int[] arr)
    {
        numberOfWeights = now;
        weights = arr;
    }

    public CreateWeights(int now,int[] arr, String s)
    {
        numberOfWeights = now;
        weights = arr;
        name = s;
    }

    public int[] GetWeights()
    {
        return weights;
    }

    public void SetWeights(int[] arr)
    {
        weights = arr;
    }

}
