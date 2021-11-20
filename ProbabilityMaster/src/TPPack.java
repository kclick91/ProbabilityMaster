import org.bouncycastle.util.test.Test;

import java.util.List;

public class TPPack {
    private List<TestProbability> tpPackList;

    public TPPack()
    {

    }

    public void AddTP(TestProbability tp)
    {
        tpPackList.add(tp);
    }

    public List<TestProbability> GetTP()
    {
        return tpPackList;
    }


}
