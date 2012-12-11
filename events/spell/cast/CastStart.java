package combatlogparser.events.spell.cast;

import combatlogparser.events.spell.SpellBaseEvent;

public class CastStart extends SpellBaseEvent {

	public CastStart() {}

	public int parse(String timeDate, String[] values) {
		int index = super.parse(timeDate, values);
		if (index < 0)
			return -1;

		return index;
	}

	@Override
	public boolean equals(Object other) {
		if (other == null || !(other instanceof CastStart))
			return false;
		if (other == this)
			return true;

		return super.equals(other);
	}

	@Override
	public String toString() {
		return super.toString();
	}
}