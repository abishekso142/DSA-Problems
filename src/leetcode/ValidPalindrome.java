package leetcode;

//https://leetcode.com/problems/valid-palindrome/
public class ValidPalindrome
{

    public static void main(String[] args)
    {
        System.out.println(isPalindrome("rat ab ba   tar"));

    }

    public static boolean isPalindrome(String s)
    {
        s = s.toLowerCase();
        int start = 0, end = s.length() - 1;

        while (start <= end)
        {

            char left  = s.charAt(start);
            char right = s.charAt(end);

            if ((left < 'a' || left > 'z') && (left < '0' || left > '9'))
            {
                start++;
                continue;
            }

            if ((right < 'a' || right > 'z') && (right < '0' || right > '9'))
            {
                end--;
                continue;
            }

            if (left != right) {
                return false;
            }

            start++;
            end--;

        }

        return true;

    }

}
