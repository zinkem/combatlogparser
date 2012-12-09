package combatlogparser.events.spell;

import combatlogparser.events.spell.SpellBaseEvent;

public class SpellDispelFailed extends SpellBaseEvent {
	private int extraSpellID;
	private String extraSpellName;
	private int extraSpellSchool;

	public SpellDispelFailed() {}

	public int parse(String dateTime, String[] values) {
		int index = super.parse(dateTime, values);
		if (index < 0 || values.length < index + 3)
			return -1;

		setExtraSpellID(Integer.valueOf(values[index++]));
		setExtraSpellName(values[index++]);
		setExtraSpellSchool((int)longParse(values[index++]));

		return index;
	}

	public void setExtraSpellID(int i) { this.extraSpellID = i; }
	public int getExtraSpellID() { return this.extraSpellID; }

	public void setExtraSpellName(String s) { this.extraSpellName = s; }
	public String getExtraSpellName() { return this.extraSpellName; }

	public void setExtraSpellSchool(int i) { this.extraSpellSchool = i; }
	public int getExtraSpellSchool() { return this.extraSpellSchool; }

	@Override
	public String toString() {
		char newLine = '\n';
		char tab = '\t';
		String s = super.toString();

		s += tab + "ExtraSpellID = " + getExtraSpellID() + newLine;
		s += tab + "ExtraSpellName = " + getExtraSpellName() + newLine;
		s += tab + "ExtraSpellSchool = " + getExtraSpellSchool() + newLine;

		return s;
	}
}