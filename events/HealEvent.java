package combatlogparser.events;

import combatlogparser.events.spell.SpellBaseEvent;

public abstract class HealEvent extends SpellBaseEvent {
	private int amount;
	private int overhealing;
	private int absorbed;
	private boolean critical;
	
	public HealEvent() {}

	public int parse(String timeDate, String[] values) {
		return super.parse(timeDate, values);
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
		return super.equals(other);
	}

	@Override
	public String toString() {
		return super.toString();
	}
}