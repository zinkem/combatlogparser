package combatlogparser.events.spell.cast;

import combatlogparser.events.spell.SpellBaseEvent;

public class CastSuccess extends SpellBaseEvent {

	public CastSuccess() {}

	public int parse(String timeDate, String[] values) {
		int index = super.parse(timeDate, values);
		if (index < 0)
			return -1;

		return index;
	}

	public String toString() {
		return super.toString();
	}
}