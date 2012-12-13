package combatlogparser.events.spell;

import combatlogparser.events.BaseEvent;

public class SpellBaseEvent extends BaseEvent {
	private int spellID;
	private String spellName;
	private int spellSchool;

	public SpellBaseEvent() {}

	public int parse(String timeDate, String values[]) {
		int index = super.parse(timeDate, values);
		if (index < 0 | values.length < index + 3)
			return -1;

		setSpellID(Integer.valueOf(values[index++]));
		setSpellName(values[index++]);
		setSpellSchool((int)longParse(values[index++]));

		return index;
	}

	public void setSpellID(int i) { this.spellID = i; }
	public int getSpellID() { return this.spellID; }

	public void setSpellName(String s) { this.spellName = s; }
	public String getSpellName() { return this.spellName; }

	public void setSpellSchool(int i) { this.spellSchool = i; }
	public int getSpellSchool() { return this.spellSchool; }

	@Override
	public boolean equals(Object other) {
		if (other == null || !(other instanceof SpellBaseEvent) || !super.equals(other))
			return false;
		if (other == this)
			return true;

		SpellBaseEvent that = (SpellBaseEvent)other;

		return (this.getSpellID() == that.getSpellID()) &&
				(this.getSpellName().equalsIgnoreCase(that.getSpellName())) &&
				(this.getSpellSchool() == that.getSpellSchool());
	}

	@Override
	public String toString() {
		char newLine = '\n';
		char tab = '\t';
		String s = super.toString();

		s += tab + "SpellID = " + getSpellID() + newLine;
		s += tab + "SpellName = " + getSpellName() + newLine;
		s += tab + "SpellSchool = " + getSpellSchool() + newLine;

		return s;
	}
}