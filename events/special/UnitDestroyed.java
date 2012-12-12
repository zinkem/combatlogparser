package combatlogparser.events.special;

import combatlogparser.events.BaseEvent;
import combatlogparser.events.interfaces.EventInterface;

public class UnitDestroyed extends BaseEvent implements EventInterface {

	public UnitDestroyed() {}

	public int parse(String timeDate, String[] values) {
		int index = super.parse(timeDate, values);
		if (index < 0)
			return -1;

		return index;
	}

	@Override
	public boolean equals(Object other) {
		if (other == null || !(other instanceof UnitDestroyed))
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