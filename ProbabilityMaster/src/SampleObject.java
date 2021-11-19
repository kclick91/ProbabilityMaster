public class SampleObject {
    private int integer;
    private String string;
    public SampleObject(int i, String s)
    {
        integer = i;
        string = s;
    }
    public String Print()
    {
        return integer + ": " + string;
    }

}
