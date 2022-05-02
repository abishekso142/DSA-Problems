package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//https://leetcode.com/problems/group-anagrams/
public class GroupAnagram
{

    public static void main(String[] args)
    {
        String[] arr = { "eat", "tea", "tan", "ate", "nat", "bat" };

        List<List<String>> ans = groupAnagrams(arr);

        System.out.println(ans);
    }

    public static List<List<String>> groupAnagrams(String[] strs)
    {
        String[] sort = new String[strs.length];
        for (int i = 0; i < strs.length; i++)
        {
            char[] arr = strs[i].toCharArray();
            Arrays.sort(arr);
            sort[i] = new String(arr);
        }

        Map<String, List<String>> map = new HashMap<>();

        for (int j = 0; j < sort.length; j++)
        {
            if (map.containsKey(sort[j]))
            {
                map.get(sort[j]).add(strs[j]);
            }
            else
            {
                map.put(sort[j], new ArrayList<String>(Arrays.asList(strs[j])));
            }
        }

        List<List<String>> res = new ArrayList<>();
        for (List<String> list : map.values())
        {
            res.add(list);
        }

        return res;

    }
}
