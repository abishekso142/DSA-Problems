package leetcode;

//https://leetcode.com/problems/product-of-array-except-self/
public class ProductExceptSelf
{

    public static void main(String[] args)
    {
        int[] ans = productExceptSelf(new int[] { 1, 2, 3, 4 });
        for (int i = 0; i < ans.length; i++)
        {
            System.out.println(ans[i]);
        }

    }

    //Brute force
    public static int[] productExceptSelfBrute(int[] nums)
    {
        int[] product = new int[nums.length];

        for (int i = 0; i < nums.length; i++)
        {
            product[i] = 1;
            for (int j = 0; j < nums.length; j++)
            {
                if (j != i)
                {
                    product[i] = product[i] * nums[j];
                }
            }

        }
        return product;
    }
    
  
    public static int[] productExceptSelf(int[] nums)
    {
        int n = nums.length;
        int[] product = new int[n];
        int[] ls = new int[n];
        int[] rs = new int[n];

        ls[0] = 1;
        for (int i = 1; i < n; i++)
        {
            ls[i] = ls[i-1] * nums[i-1];
        }
        
        rs[n-1] = 1;
        for (int i = n-2; i >=0; i--)
        {
            rs[i] = rs[i+1] * nums[i+1];
        }
        
        for(int i = 0; i < n; i++){
            product[i] = ls[i] * rs[i];
        }
        return product;
    }

}
