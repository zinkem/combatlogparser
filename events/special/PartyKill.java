package combatlogparser.events.special;

import combatlogparser.events.BaseEvent;

public class PartyKill extends BaseEvent {

	public PartyKill() {}

	public int parse(String timeDate, String[] values) {
		int index = super.parse(timeDate, values);
		if (index < 0)
			return -1;

		return index;
	}

	@Override
	public boolean equals(Object other) {
		if (other == null || !(other instanceof PartyKill))
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