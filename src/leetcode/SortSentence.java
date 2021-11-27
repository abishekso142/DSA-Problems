package leetcode;

public class SortSentence {

	public static void main(final String[] args) {
		System.out.println(sortSentence("is2 sentence4 This1 a3"));
		System.out.println(sortSentence("Myself2 Me1 I4 and3"));
	}

	public static String sortSentence(final String s) {
		final StringBuffer sentence = new StringBuffer();
		for (int i = 1; i < 10; i++) {
			final String num = Integer.toString(i);
			if (s.indexOf(num) > -1) {
				final StringBuffer word = new StringBuffer();
				final int pos = s.indexOf(num);
				for (int j = pos - 1; j > -1; j--) {
					if (s.charAt(j) != ' ') {
						word.append(s.charAt(j));
					} else {
						break;
					}
				}
				sentence.append(word.reverse());
				sentence.append(' ');
			}
		}
		return sentence.deleteCharAt(sentence.length() - 1).toString();
	}

}
