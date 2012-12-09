package combatlogparser.events.spell;

import combatlogparser.events.spell.SpellBaseEvent;

public class SpellDispel extends SpellBaseEvent {
	private int extraSpellID;
	private String extraSpellName;
	private int extraSpellSchool;
	private String auraType;

	public SpellDispel() {}

	public int parse(String dateTime, String[] values) {
		int index = super.parse(dateTime, values);
		if (index < 0 || values.length < index + 4)
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