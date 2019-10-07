import java.util.ArrayList;
import java.util.List;

public class StaircaseProblem {
    static int count=0;
    public static void main(String[] args) {
        waysToClimb(4,new ArrayList<>());
        System.out.println(count+"--");
    }
    private static void waysToClimb(int n, List<Integer> path)
    {
        if (n == 0)
        {
            //  print whole path
            count++;
            for (Integer i: path)
            {
                System.out.print(i + " ");
            }
            System.out.println();
        }
        else if (n == 1)
        {
            List<Integer> newPath = new ArrayList<Integer>(path);
            newPath.add(1);
            waysToClimb(n-1, newPath);
        }
        else if (n > 1)
        {
            List<Integer> newPath1 = new ArrayList<Integer>(path);
            newPath1.add(1);
            waysToClimb(n-1, newPath1);

            List<Integer> newPath2 = new ArrayList<Integer>(path);
            newPath2.add(2);
            waysToClimb(n-2, newPath2);


        }
    }

}

