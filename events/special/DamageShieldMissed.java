package combatlogparser.events.special;

import combatlogparser.events.spell.SpellBaseEvent;
import combatlogparser.events.interfaces.EventInterface;

public class DamageShieldMissed extends SpellBaseEvent implements EventInterface {
	private String missType;
	private int amountMissed = -1;

	public DamageShieldMissed() {}

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
	public boolean equals(Object other) {
		if (other == null || !(other instanceof DamageShield) || !super.equals(other))
			return false;
		if (other == this)
			return true;

		DamageShieldMissed that = (DamageShieldMissed)other;

		return (this.getMissType().equalsIgnoreCase(that.getMissType())) &&
				(this.getAmountMissed() == this.getAmountMissed());
	}

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