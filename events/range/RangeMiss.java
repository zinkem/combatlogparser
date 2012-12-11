package combatlogparser.events.range;

import combatlogparser.events.range.RangeBaseEvent;

public class RangeMiss extends RangeBaseEvent {
	private String missType;

	public RangeMiss() {}

	public int parse(String timeDate, String[] values) {
		int index = super.parse(timeDate, values);
		if (index < 0 || values.length < index + 1)
			return -1;

		setMissType(values[index++]);

		return index;
	}

	public void setMissType(String s) { this.missType = s; }
	public String getMissType() { return this.missType; }

	@Override
	public boolean equals(Object other) {
		if (other == null || !(other instanceof RangeMiss) || !super.equals(other))
			return false;
		if (other == this)
			return true;

		RangeMiss that = (RangeMiss)other;

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