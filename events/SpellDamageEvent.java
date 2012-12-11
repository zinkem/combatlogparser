package combatlogparser.events;

import combatlogparser.events.spell.SpellBaseEvent;

public abstract class SpellDamageEvent extends SpellBaseEvent {
	public SpellDamageEvent() {}

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