package combatlogparser.events.spell.heal;

import combatlogparser.events.HealEvent;

public class SpellHeal extends HealEvent {
	
	public SpellHeal() {}

	public int parse(String timeDate, String[] values) {
		int index = super.parse(timeDate, values);
		if (index < 0 || values.length < index + 4)
			return -1;

		setAmount(Integer.valueOf(values[index++]));
		setOverhealing(Integer.valueOf(values[index++]));
		setAbsorbed(Integer.valueOf(values[index++]));
		setCritical(values[index++].contains("nil"));

		return index;
	}

	@Override
	public boolean equals(Object other) {
		if (other == null || !(other instanceof SpellHeal) || !super.equals(other))
			return false;
		if (other == this)
			return true;

		SpellHeal that = (SpellHeal)other;

		return (this.getAmount() == that.getAmount()) &&
				(this.getOverhealing() == that.getOverhealing()) &&
				(this.getAbsorbed() == that.getAbsorbed()) &&
				(this.getCritical() == that.getCritical());
	}

	@Override
	public String toString() {
		char newLine = '\n';
		char tab = '\t';
		String s = super.toString();

		s += tab + "Amount = " + getAmount() + newLine;
		s += tab + "Overhealing = " + getOverhealing() + newLine;
		s += tab + "Absorbed = " + getAbsorbed() + newLine;
		s += tab + "Critical = " + getCritical() + newLine;

		return s;
	}
}