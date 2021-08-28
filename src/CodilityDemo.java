import java.util.Arrays;

public class CodilityDemo
{

    public static void main(final String[] args)
    {
        System.out.println(solution(new int[] { 1, 3, 6, 4, 1, 2 }));
    }

    public static int solution(final int[] A)
    {
        Arrays.sort(A);

        for (int i = 1; i <= 100000; i++)
        {
            if (Arrays.binarySearch(A, 0, A.length, i) < 0)
            {
                return i;
            }
        }
        return 100001;
    }
}
