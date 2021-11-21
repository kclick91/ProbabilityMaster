import org.bouncycastle.util.test.Test;

import java.util.ArrayList;
import java.util.List;

public class TPPack {
    private ArrayList<TestProbability> tpPackList;

    public TPPack()
    {
        tpPackList = new ArrayList<TestProbability>();
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
