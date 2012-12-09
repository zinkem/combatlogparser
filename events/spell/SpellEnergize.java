package combatlogparser.events.spell;

import combatlogparser.events.spell.SpellBaseEvent;

public class SpellEnergize extends SpellBaseEvent {
	private int amount;
	private int powerType;

	public SpellEnergize() {}

	public int parse(String timeDate, String[] values) {
		int index = super.parse(timeDate, values);
		if (index < 0 || values.length < index + 2)
			return -1;

		setAmount(Integer.valueOf(values[index++]));
		setPowerType(Integer.valueOf(values[index++]));

		return index;
	}

	public void setAmount(int i) { this.amount = i; }
	public int getAmount() { return this.amount; }

	public void setPowerType(int i) { this.powerType = i; }
	public int getPowerType() { return this.powerType; }

	@Override
	public String toString() {
		char newLine = '\n';
		char tab = '\t';
		String s = super.toString();

		s += tab + "Amount = " + getAmount() + newLine;
		s += tab + "PowerType = " + getPowerType() + newLine;

		return s;
	}
}