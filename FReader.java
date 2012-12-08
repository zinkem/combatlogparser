package combatlogparser;

import java.io.*;
import java.util.*;
import combatlogparser.events.*;
//import org.json.simple.*;

public class FReader {
	public static void main(String[] args) {
		File testerLogFile = new File("Logs/CombatLog_01.txt");
		try {
			BufferedReader br = endOfFile(testerLogFile);
			while (true) {
				String s = br.readLine();
				if (s != null) {
					LineParser lp = new LineParser();
					lp.parse(s);
					BaseEvent be = new BaseEvent();
					for (String ss : lp.getValues())
						System.out.println(ss);
					be.parse(lp.getTimeDate(), lp.getValues());
					System.out.println(be.toString());
        			System.exit(1);
					//System.out.println(i + " " + s.replace(System.getProperty("line.separator"), ""));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
	}

	public static BufferedReader endOfFile(File f) {
		try {
			long fileLength = f.length() - 1;
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(f), "UTF-8"));
			//br.skip(fileLength);

			return br;
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}

		return null;
	}
}