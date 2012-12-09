package combatlogparser.events.spell.aura;

import combatlogparser.events.spell.SpellBaseEvent;

public class SpellAuraAppliedDose extends SpellBaseEvent {
	private String auraType;

	public SpellAuraAppliedDose() {}

	public int parse(String timeDate, String[] values) {
		int index = super.parse(timeDate, values);
		if (index < 0 || values.length < index + 1)
			return -1;

		setAuraType(values[index++]);

		return index;
	}

	public void setAuraType(String s) { this.auraType = s; }
	public String getAuraType() { return this.auraType; }

	@Override
	public String toString() {
		char newLine = '\n';
		char tab = '\t';
		String s = super.toString();

		s += tab + "AuraType = " + getAuraType() + newLine;

		return s;
	}
}