package leetcode;

import java.util.List;

//https://leetcode.com/problems/count-items-matching-a-rule/
public class CountItemsMatchingRule {

	public static void main(final String[] args) {
		System.out.println();

	}

	public static int countMatches(final List<List<String>> items, final String ruleKey, final String ruleValue) {
		int ctr = 0;
		int index = -1;
		switch (ruleKey) {
		case "type":
			index = 0;
			break;
		case "color":
			index = 1;
			break;
		case "name":
			index = 2;
			break;
		default:
			break;
		}
		for (final List<String> item : items) {
			if (item.contains(ruleValue) && item.get(index).equals(ruleValue)) {
				ctr++;
			}
		}
		return ctr;
	}
}
