package combatlogparser.events;

import combatlogparser.events.BaseEvent;

public abstract class DeathEvent extends BaseEvent {
	public DeathEvent() {}

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