package combatlogparser.events.swing;

import combatlogparser.events.BaseEvent;

public class SwingMissed extends BaseEvent {
	private String missType;

	public SwingMissed() {}

	public int parse(String timeDate, String[] values) {
		int index = super.parse(timeDate, values);
		if (index < 0 || values.length < index + 1)
			return -1;

		setMissType(values[index++]);
		
		return index;
	}

	public void setMissType(String s) { this.missType = s.trim(); }
	public String getMissType() { return this.missType; }

	@Override
	public boolean equals(Object other) {
		if (other == null || !(other instanceof SwingMissed) || !super.equals(other))
			return false;
		if (other == this)
			return true;

		SwingMissed that = (SwingMissed)other;

		return (this.getMissType().equalsIgnoreCase(that.getMissType()));
	}

	@Override
	public String toString() {
		char newLine = '\n';
		char tab = '\t';
		String s = super.toString();

		s += tab + "MissType = " + getMissType() + newLine;

		return s;
	}
}