package combatlogparser.events.spell;

import combatlogparser.events.spell.SpellBaseEvent;

public class SpellExtraAttacks extends SpellBaseEvent {
	private int amount;

	public SpellExtraAttacks() {}

	public int parse(String timeDate, String[] values) {
		int index = super.parse(timeDate, values);
		if (index < 0 || values.length < index + 1)
			return -1;

		setAmount(Integer.valueOf(values[index++]));

		return index;
	}

	public void setAmount(int i) { this.amount = i; }
	public int getAmount() { return this.amount; }

	@Override
	public String toString() {
		char newLine = '\n';
		char tab = '\t';
		String s = super.toString();

		s += tab + "Amount = " + getAmount() + newLine;

		return s;
	}
}