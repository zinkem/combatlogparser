package combatlogparser.events.spell.aura;

import combatlogparser.events.spell.SpellBaseEvent;

public class SpellAuraBrokenSpell extends SpellBaseEvent {
	private int extraSpellID;
	private String extraSpellName;
	private int extraSpellSchool;
	private String auraType;

	public SpellAuraBrokenSpell() {}

	public int parse(String dateTime, String[] values) {
		int index = super.parse(dateTime, values);
		if (index < 0 || values.length < index + 3)
			return -1;

		setExtraSpellID(Integer.valueOf(values[index++]));
		setExtraSpellName(values[index++]);
		setExtraSpellSchool((int)longParse(values[index++]));
		setAuraType(values[index++]);

		return index;
	}

	public void setExtraSpellID(int i) { this.extraSpellID = i; }
	public int getExtraSpellID() { return this.extraSpellID; }

	public void setExtraSpellName(String s) { this.extraSpellName = s; }
	public String getExtraSpellName() { return this.extraSpellName; }

	public void setExtraSpellSchool(int i) { this.extraSpellSchool = i; }
	public int getExtraSpellSchool() { return this.extraSpellSchool; }

	public void setAuraType(String s) { this.auraType = s; }
	public String getAuraType() { return this.auraType; }

	@Override
	public boolean equals(Object other) {
		if (other == null || !(other instanceof SpellAuraBrokenSpell) || !super.equals(other))
			return false;
		if (other == this)
			return true;

		SpellAuraBrokenSpell that = (SpellAuraBrokenSpell)other;

		return (this.getExtraSpellID() == that.getExtraSpellID()) &&
				(this.getExtraSpellName().equalsIgnoreCase(that.getExtraSpellName())) &&
				(this.getExtraSpellID() == that.getExtraSpellID()) &&
				(this.getAuraType().equalsIgnoreCase(that.getAuraType()));
	}

	@Override
	public String toString() {
		char newLine = '\n';
		char tab = '\t';
		String s = super.toString();

		s += tab + "ExtraSpellID = " + getExtraSpellID() + newLine;
		s += tab + "ExtraSpellName = " + getExtraSpellName() + newLine;
		s += tab + "ExtraSpellSchool = " + getExtraSpellSchool() + newLine;
		s += tab + "AuraType = " + getAuraType() + newLine;

		return s;
	}
}