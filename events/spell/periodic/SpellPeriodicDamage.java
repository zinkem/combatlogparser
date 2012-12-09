package combatlogparser.events.spell.periodic;

import combatlogparser.events.spell.SpellPeriodicBaseEvent;

public class SpellPeriodicDamage extends SpellPeriodicBaseEvent {
	private int amount;
	private int overkill;
	private int school;
	private int resisted;
	private int blocked;
	private int absorbed;
	private boolean critical;
	private boolean glancing;
	private boolean crushing;

	public SpellPeriodicDamage() {}

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

	public void setAmount(int i) { this.amount = i; }
	public int getAmount() { return this.amount; }

	public void setOverkill(int i) { this.overkill = i; }
	public int getOverkill() { return this.overkill; }

	public void setSchool(int i) { this.school = i; }
	public int getSchool() { return this.school; }

	public void setResisted(int i) { this.resisted = i; }
	public int getResisted() { return this.resisted; }

	public void setBlocked(int i) { this.blocked = i; }
	public int getBlocked() { return this.blocked; }

	public void setAbsorbed(int i) { this.absorbed = i; }
	public int getAbsorbed() { return this.absorbed; }

	public void setCritical(String s) { this.critical = s.contains("nil"); }
	public boolean getCritical() { return this.critical; }

	public void setGlancing(String s) { this.glancing = s.contains("nil"); }
	public boolean getGlancing() { return this.glancing; }

	public void setCrushing(String s) { this.crushing = s.contains("nil"); }
	public boolean getCrushing() { return this.crushing; }

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