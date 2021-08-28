import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UrlValidate {

	public static void main(final String[] args) {
		/*
		 * final String proj = "c50a14fa-f3aa-406f-a731-172dfd44c422"; final String inp
		 * = "/Large folder/doc1"; final String[] parts = inp.split("/"); final String
		 * pathWithoutName = inp.substring(0, inp.lastIndexOf("/")); final String
		 * docName = inp.substring(inp.lastIndexOf("/") + 1);
		 * System.out.println(pathWithoutName); System.out.println(docName); final
		 * String actualPath = "/" + proj + pathWithoutName;
		 */

		/*
		 * final String filter =
		 * "cmis:versionSeriesId eq 'abc' AND cmis:versionSeriesId eq 'nmvbhgj' AND cmis:name EQ 'RedHerring'"
		 * ; final String whereClause = getWhereClauseFromfilter(filter);
		 * System.out.println(whereClause);
		 */

		/*
		 * System.out.println(validateUrl("WWW.google.com"));
		 * System.out.println(validateUrl("www.google.com"));
		 */

		final String abc = "bpns-copin-i327849";
		System.out.println(abc.startsWith("bpns-copin-i327849"));

	}

	@SuppressWarnings("unused")
	private static String getWhereClauseFromfilter(final String filterStatement) {

		final String[] args = filterStatement.split("\s");

		final Map<String, List<String>> queryMap = new HashMap<>();

		int i = 0;

		final List<String> filterableCmisProperties = new ArrayList<>();

		filterableCmisProperties.add("cmis:versionSeriesId");
		filterableCmisProperties.add("cmis:path");
		filterableCmisProperties.add("cmis:name");

		while (i < args.length && args[i] != null) {
			final String propName = args[i];
			if (filterableCmisProperties.contains(propName)) {
				if (!queryMap.containsKey(propName)) {
					queryMap.put(propName, new ArrayList<String>());
				}
				if (args[i + 1].equalsIgnoreCase("EQ")) {

					if (args[i + 2].startsWith("'") && args[i + 2].endsWith("'")) {
						String value = args[i + 2];
						value = value.substring(1, value.length() - 1);
						final List<String> values = queryMap.get(propName);
						values.add(value);
						queryMap.put(propName, values);
					}

				}
			}

			++i;
		}

		String whereClause = "";
		for (final Map.Entry<String, List<String>> entry : queryMap.entrySet()) {
			if (!entry.getValue().isEmpty()) {
				final String prefix = entry.getKey() + " IN (";

				String inStatement = "";
				for (final String val : entry.getValue()) {
					inStatement = inStatement + "'" + val + "',";

				}
				inStatement = inStatement.substring(0, inStatement.lastIndexOf(","));
				whereClause = whereClause + " " + prefix + inStatement + ") AND";
			}
		}

		whereClause = whereClause.substring(0, whereClause.lastIndexOf("AND"));

		return whereClause;

	}

	/**
	 * Check if the URL provided is a valid one Currently the same set of
	 * validations are also done in the COPIN UI already: Adding https if no scheme
	 * present, same regex for validation
	 *
	 * @param url
	 * @return true or false
	 */
	public static boolean validateUrl(final String urlToBeUpdated) {
		System.out.print("URL " + urlToBeUpdated + " is ");
		String url = urlToBeUpdated.toLowerCase();
		try {
			final URI uri = new URI(url);
			if (uri.getScheme() == null) // If there is no scheme add the https scheme to the URL
			{
				url = "https://" + url;
			}
		} catch (final URISyntaxException e) {
			return false;
		}

		final String urlRegex = "^" +
		// protocol identifier (optional)
		// short syntax // still required
				"(?:(?:(?:https?|ftp):)?\\/\\/)?" +
				// user:pass BasicAuth (optional)
				"(?:\\S+(?::\\S*)?@)?" + "(?:" +
				// IP address exclusion
				// private & local networks
				"(?!(?:10|127)(?:\\.\\d{1,3}){3})" + "(?!(?:169\\.254|192\\.168)(?:\\.\\d{1,3}){2})"
				+ "(?!172\\.(?:1[6-9]|2\\d|3[0-1])(?:\\.\\d{1,3}){2})" +
				// IP address dotted notation octets
				// excludes loopback network 0.0.0.0
				// excludes reserved space >= 224.0.0.0
				// excludes network & broadcast addresses
				// (first & last IP address of each class)
				"(?:[1-9]\\d?|1\\d\\d|2[01]\\d|22[0-3])" + "(?:\\.(?:1?\\d{1,2}|2[0-4]\\d|25[0-5])){2}"
				+ "(?:\\.(?:[1-9]\\d?|1\\d\\d|2[0-4]\\d|25[0-4]))" + "|" +
				// host & domain names, may end with dot
				// can be replaced by a shortest alternative
				// (?![-_])(?:[-\\w\\u00a1-\\uffff]{0,63}[^-_]\\.)+
				"(?:" + "(?:" + "[a-z0-9\\u00a1-\\uffff]" + "[a-z0-9\\u00a1-\\uffff_-]{0,62}" + ")?"
				+ "[a-z0-9\\u00a1-\\uffff]\\." + ")+" +
				// TLD identifier name, may end with dot
				"(?:[a-z\\u00a1-\\uffff]{2,}\\.?)" + ")" +
				// port number (optional)
				"(?::\\d{2,5})?" +
				// resource path (optional)
				"(?:[/?#]\\S*)?" + "$";

		final Pattern urlPattern = Pattern.compile(urlRegex);
		final Matcher matcher = urlPattern.matcher(url);
		final boolean isRegexValid = matcher.matches();

		return isRegexValid;
	}

}
