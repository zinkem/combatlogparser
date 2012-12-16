package combatlogparser.events;

import combatlogparser.events.spell.SpellPeriodicBaseEvent;

public abstract class SpellPeriodicDamageEvent extends SpellPeriodicBaseEvent {
	private int amount;
	private int overkill;
	private int school;
	private int resisted;
	private int blocked;
	private int absorbed;
	private boolean critical;
	private boolean glancing;
	private boolean crushing;
	
	public SpellPeriodicDamageEvent() {}

	public int parse(String timeDate, String[] values) {
		return super.parse(timeDate, values);
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
	public boolean equals(Object other) {
		return super.equals(other);
	}

	@Override
	public String toString() {
		return super.toString();
	}
}