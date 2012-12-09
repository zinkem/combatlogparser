package combatlogparser.events.spell.periodic;

import combatlogparser.events.spell.SpellPeriodicBaseEvent;

public class SpellPeriodicDrain extends SpellPeriodicBaseEvent {
	private int amount;
	private int powerType;
	private int extraAmount;

	public SpellPeriodicDrain() {}

	public int parse(String timeDate, String[] values) {
		int index = super.parse(timeDate, values);
		if (index < 0 || values.length < index + 3)
			return -1;

		setAmount(Integer.valueOf(values[index++]));
		setPowerType(Integer.valueOf(values[index++]));
		setExtraAmount(Integer.valueOf(values[index++]));

		return index;
	}

	public void setAmount(int i) { this.amount = i; }
	public int getAmount() { return this.amount; }

	public void setPowerType(int i) { this.powerType = i; }
	public int getPowerType() { return this.powerType; }

	public void setExtraAmount(int i) { this.extraAmount = i; }
	public int getExtraAmount() { return this.extraAmount; }

	@Override
	public String toString() {
		char newLine = '\n';
		char tab = '\t';
		String s = super.toString();

		s += tab + "Amount = " + getAmount() + newLine;
		s += tab + "PowerType = " + getPowerType() + newLine;
		s += tab + "ExtraAmount = " + getExtraAmount() + newLine;

		return s;
	}
}