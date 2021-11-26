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

    public void PrintTPPack(int amount)
    {
        for (int j = 0; j < tpPackList.size(); j++)
        {
            tpPackList.get(j).PrintValues(amount);
        }
    }


}
