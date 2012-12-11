package combatlogparser.events.spell.heal;

import combatlogparser.events.HealEvent;

public class SpellPeriodicHeal extends HealEvent {
	private int amount;
	private int overhealing;
	private int absorbed;
	private boolean critical;

	public SpellPeriodicHeal() {}

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

	public void setAmount(int i) { this.amount = i; }
	public int getAmount() { return this.amount; }

	public void setOverhealing(int i) { this.overhealing = i; }
	public int getOverhealing() { return this.overhealing; }

	public void setAbsorbed(int i) { this.absorbed = i; }
	public int getAbsorbed() { return this.absorbed; }

	public void setCritical(boolean b) { this.critical = b; }
	public boolean getCritical() { return this.critical; }

	@Override
	public boolean equals(Object other) {
		if (other == null || !(other instanceof SpellPeriodicHeal) || !super.equals(other))
			return false;
		if (other == this)
			return true;

		SpellPeriodicHeal that = (SpellPeriodicHeal)other;

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