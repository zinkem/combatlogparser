package combatlogparser.events.spell;

import combatlogparser.events.spell.SpellBaseEvent;

public class SpellResurrect extends SpellBaseEvent {

	public SpellResurrect() {}

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