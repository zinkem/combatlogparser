package combatlogparser.events.environmental;

import combatlogparser.events.BaseEvent;

public class EnvironmentalBaseEvent extends BaseEvent {
	private String environmentalType;

	public EnvironmentalBaseEvent() {}

	public int parse(String dateTime, String[] values) {
		int index = super.parse(dateTime, values);
		if (index < 0 || values.length < index + 1)
			return -1;

		setEnvrimonmentalType(values[index++]);

		return index;
	}

	public void setEnvrimonmentalType(String s) { this.environmentalType = s; }
	public String getEnvironmentalType() { return this.environmentalType; }

	@Override
	public boolean equals(Object other) {
		if (other == null || !(other instanceof EnvironmentalBaseEvent) || !super.equals(other))
			return false;
		if (other == this)
			return true;

		EnvironmentalBaseEvent that = (EnvironmentalBaseEvent)other;

		return (this.getEnvironmentalType().equalsIgnoreCase(that.getEnvironmentalType()));
	}

	@Override
	public String toString() {
		char newLine = '\n';
		char tab = '\n';
		String s = super.toString();

		s += tab + "EnvironmentalType = " + getEnvironmentalType() + newLine;

		return s;
	}
}