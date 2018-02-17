import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class BruteForceMain {

	public static String[] mystr = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".split("");
	public static String start = "0";

	public static void main(String[] args) throws Exception {

		long counter = 0;
		while (true) {
			System.out.println(start);
			start = returner(start, null);
		}
	}

	public static String returner(String str, Integer i) {
		String[] s = str.split("");
		if (i == null) {
			String ss = s[str.length() - 1];
			if (ss.equals(mystr[mystr.length - 1])) {
				ss = mystr[0];
				s[str.length() - 1] = ss;
				s = returner(String.join("", s), (str.length() - 1)).split("");
			} else {
				int pos = getposition(ss);
				ss = mystr[pos];
				s[str.length() - 1] = ss;
			}
		} else {
			if (i != 0) {
				String ss = s[i - 1];
				if (ss.equals(mystr[mystr.length - 1])) {
					ss = mystr[0];
					s[i - 1] = ss;
					s = returner(String.join("", s), (i - 1)).split("");
				} else {
					int pos = getposition(ss);
					ss = mystr[pos];
					s[i - 1] = ss;
				}
			} else {
				String[] old = s;
				s = new String[(s.length + 1)];
				s[0] = mystr[0];
				s = fillUp(s, old);
			}
			return String.join("", s);
		}
		return String.join("", s);
	}

	public static int getposition(String ei) {
		int ii = 0;
		for (int i = 0; i < mystr.length; i++) {
			if (ei.equals(mystr[i])) {
				ii = (i + 1);
			}
		}
		return ii;
	}

	public static String[] fillUp(String[] latest, String[] old) {
		for (int i = 1; i < latest.length; i++) {
			latest[i] = old[(i - 1)];
		}
		return latest;
	}

}
