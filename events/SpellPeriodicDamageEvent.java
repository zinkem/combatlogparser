package combatlogparser.events;

import combatlogparser.events.spell.SpellPeriodicBaseEvent;

public abstract class SpellPeriodicDamageEvent extends SpellPeriodicBaseEvent {
	public SpellPeriodicDamageEvent() {}

	public int parse(String timeDate, String[] values) {
		return super.parse(timeDate, values);
	}

	@Override
	public boolean equals(Object other) {
		return super.equals(other);
	}

	@Override
	public String toString() {
		return super.toString();
	}
}