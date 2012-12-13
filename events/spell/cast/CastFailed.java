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

	@Override
	public boolean equals(Object other) {
		if (other == null || !(other instanceof CastFailed) || !super.equals(other))
			return false;
		if (other == this)
			return true;

		CastFailed that = (CastFailed)other;

		return (this.getFailedType().equalsIgnoreCase(that.getFailedType()));
	}

	@Override

	public String toString() {
		char newLine = '\n';
		char tab = '\t';
		String s = super.toString();

		s += tab + "FailedType = " + getFailedType() + newLine;

		return s;
	}
}