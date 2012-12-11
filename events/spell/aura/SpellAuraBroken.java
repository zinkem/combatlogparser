package combatlogparser.events.spell.aura;

import combatlogparser.events.spell.SpellBaseEvent;

public class SpellAuraBroken extends SpellBaseEvent {
	private String auraType;

	public SpellAuraBroken() {}

	public int parse(String timeDate, String[] values) {
		int index = super.parse(timeDate, values);
		if (index < 0 || values.length < index + 2)
			return -1;

		setAuraType(values[index++]);

		return index;
	}

	public void setAuraType(String s) { this.auraType = s; }
	public String getAuraType() { return this.auraType; }

	@Override
	public boolean equals(Object other) {
		if (other == null || !(other instanceof SpellAuraBroken) || !super.equals(other))
			return false;
		if (other == this)
			return true;

		SpellAuraBroken that = (SpellAuraBroken)other;

		return (this.getAuraType().equalsIgnoreCase(that.getAuraType()));
	}

	@Override
	public String toString() {
		char newLine = '\n';
		char tab = '\t';
		String s = super.toString();

		s += tab + "AuraType = " + getAuraType() + newLine;

		return s;
	}
}