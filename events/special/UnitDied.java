package combatlogparser.events.special;

import combatlogparser.events.DeathEvent;

public class UnitDied extends DeathEvent {

	public UnitDied() {}

	public int parse(String timeDate, String[] values) {
		int index = super.parse(timeDate, values);
		if (index < 0)
			return -1;

		return index;
	}

	@Override
	public boolean equals(Object other) {
		if (other == null || !(other instanceof UnitDied))
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