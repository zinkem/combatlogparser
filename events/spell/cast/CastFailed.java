package combatlogparser.events.spell.cast;

import combatlogparser.events.spell.SpellBaseEvent;

public class CastFailed extends SpellBaseEvent {
	private String failedType;

	public CastFailed() {}

	public int parse(String timeDate, String[] values) {
		int index = super.parse(timeDate, values);
		if (index < 0 || values.length < index + 1)
			return -1;

		setFailedType(values[index++]);

		return index;
	}

	public void setFailedType(String s) { this.failedType = s; }
	public String getFailedType() { return this.failedType; }

	public String toString() {
		char newLine = '\n';
		char tab = '\t';
		String s = super.toString();

		s += tab + "FailedType = " + getFailedType() + newLine;

		return s;
	}
}