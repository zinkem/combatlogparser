package combatlogparser.events.swing;

import combatlogparser.events.BaseEvent;

public class SwingMissed extends BaseEvent {
	private String missType;

	public SwingMissed() {}

	public int parse(String timeDate, String[] values) {
		int index = super.parse(timeDate, values);
		if (index < 0 | index < index + 1)
			return -1;

		return index;
	}

	public void setMissType(String s) { this.missType = s.trim(); }
	public String getMissType() { return this.missType; }

	public String toString() {
		char newLine = '\n';
		char tab = '\t';
		String s = super.toString();

		s += tab + "MissType = " + getMissType() + newLine;

		return s;
	}
}