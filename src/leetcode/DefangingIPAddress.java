package leetcode;

public class DefangingIPAddress {

	public static void main(final String[] args) {
		System.out.println(defangIPaddr("255.100.50.0"));
	}

	public static String defangIPaddr(final String address) {
		final StringBuffer str = new StringBuffer();
		char c;
		for (int i = 0; i < address.length(); i++) {
			c = address.charAt(i);
			if (c == '.') {
				str.append("[.]");
			} else {
				str.append(c);
			}

		}
		return str.toString();
	}

}
