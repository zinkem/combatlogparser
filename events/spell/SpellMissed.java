package combatlogparser.events.spell;

import combatlogparser.events.spell.SpellBaseEvent;

public class SpellMissed extends SpellBaseEvent {
	private String missType;
	private int amountMissed = -1;

	public SpellMissed() {}

	public int parse(String timeDate, String[] values) {
		int index = super.parse(timeDate, values);
		if (index < 0 || values.length < index + 1)
			return -1;

		setMissType(values[index++]);
		if (values.length == 16)
			setAmountMissed(Integer.valueOf(values[index++]));

		return index;
	}

	public void setMissType(String s) { this.missType = s.trim(); }
	public String getMissType() { return this.missType; }

	public void setAmountMissed(int i) { this.amountMissed = i; }
	public int getAmountMissed() { return this.amountMissed; }

	@Override
	public String toString() {
		char newLine = '\n';
		char tab = '\t';
		String s = super.toString();

		s += tab + "MissType = " + getMissType() + newLine;
		if (getAmountMissed() >= 0)
			s += tab + "AmountMissed = " + getAmountMissed() + newLine;

		return s;
	}
}