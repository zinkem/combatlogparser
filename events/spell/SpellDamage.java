package combatlogparser.events.spell;

import combatlogparser.events.SpellDamageEvent;
import combatlogparser.events.interfaces.DamageEventInterface;

public class SpellDamage extends SpellDamageEvent implements DamageEventInterface {

	public SpellDamage() {}

	public int parse(String timeDate, String[] values) {
		int index = super.parse(timeDate, values);
		if (index < 0 || values.length < index + 9) {
			return -1;
		}

		setAmount(Integer.valueOf(values[index++]));
		setOverkill(Integer.valueOf(values[index++]));
		setSchool(Integer.valueOf(values[index++]));
		setResisted(Integer.valueOf(values[index++]));
		setBlocked(Integer.valueOf(values[index++]));
		setAbsorbed(Integer.valueOf(values[index++]));
		setCritical(values[index++]);
		setGlancing(values[index++]);
		setCrushing(values[index++]);

		return index;
	}

	@Override
	public boolean equals(Object other) {
		if (other == null || !(other instanceof SpellDamage) || !super.equals(other))
			return false;
		if (other == this)
			return true;

		SpellDamage that = (SpellDamage)other;

		return (this.getAmount() == that.getAmount()) &&
				(this.getOverkill() == that.getOverkill()) &&
				(this.getSchool() == that.getSchool()) &&
				(this.getResisted() == that.getResisted()) &&
				(this.getBlocked() == that.getBlocked()) &&
				(this.getAbsorbed() == that.getAbsorbed()) &&
				(this.getCritical() == that.getCritical()) &&
				(this.getGlancing() == that.getGlancing()) &&
				(this.getCrushing() == that.getCrushing());
	}

	@Override
	public String toString() {
		char newLine = '\n';
		char tab = '\t';
		String s = super.toString();
		s += tab + "Amount = " + getAmount() + newLine;
		s += tab + "Overkill = " + getOverkill() + newLine;
		s += tab + "School = " + getSchool() + newLine;
		s += tab + "Resisted = " + getResisted() + newLine;
		s += tab + "Blocked = " + getBlocked() + newLine;
		s += tab + "Absorbed = " + getAbsorbed() + newLine;
		s += tab + "Critical = " + getCritical() + newLine;
		s += tab + "Glancing = " + getGlancing() + newLine;
		s += tab + "Crushing = " + getCrushing() + newLine;

		return s;
	}
}