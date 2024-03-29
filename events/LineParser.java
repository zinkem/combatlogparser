package combatlogparser.events;

public class LineParser {
	private String timeDate = null;
	private String[] eventValues = null;

	public void parse(String line) {
		int i = 0;
		char[] chars = line.toCharArray();

		while (i < chars.length) {
			if (chars[i] == ' ')
				++i;
			else
				break;
		}

		int startIndex = i;
		int endIndex = i;
		int numSpace = 0;

		while (i < chars.length) {
			if (chars[i] == ' ') {
				++numSpace;
				if (numSpace >= 2) {
					endIndex = i;
					break;
				}
				++i;
			}
			else {
				++i;
			}
		}

		timeDate = new String(line.substring(startIndex, endIndex));
		//eventValues = new String(line.substring(i).trim()).replace("\"","").replace("Invoke Xuen, the White Tiger", "Invoke Xuen the White Tiger").split(",");
		eventValues = new String(line.substring(i).trim()).split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)");
		for (i = 0; i < eventValues.length; ++i)
			eventValues[i] = eventValues[i].replace("\"", "");
	}

	public String getTimeDate() {
		return this.timeDate;
	}

	public String[] getValues() {
		return this.eventValues;
	}
}