import org.bouncycastle.util.test.Test;

public class Example {

    TestProbability tprob;
    int count;
    public Example(TestProbability tp, int c)
    {
        tprob= tp;
        count = c;
    }

    public void PrintExample()
    {
        tprob.PrintValues(count);
    }
}
