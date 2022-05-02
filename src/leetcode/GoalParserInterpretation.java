package leetcode;

//https://leetcode.com/problems/goal-parser-interpretation/
public class GoalParserInterpretation {

	public static void main(final String[] args) {
		System.out.println(interpret("G()(al)"));
		System.out.println(interpret("G()()()()(al)"));
	}

	public static String interpret(final String command) {
		final StringBuffer str = new StringBuffer();
		for (int i = 0; i < command.length(); i++) {
			if (command.charAt(i) == 'G') {
				str.append('G');
			} else if (command.charAt(i) == '(' && command.charAt(i + 1) == ')') {
				str.append('o');
				++i;
			} else if (command.charAt(i) == '(' && command.charAt(i + 1) == 'a' && command.charAt(i + 2) == 'l'
					&& command.charAt(i + 3) == ')') {
				str.append("al");
				i = i + 3;
			}
		}
		return str.toString();
	}

}
