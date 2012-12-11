package combatlogparser.events;

public abstract class BaseEvent {
	private String[] values = null;
	private String timeStamp;
	private String event;
	private String sourceGUID;
	private String sourceName;
	private long sourceFlag;
	private long sourceRaidFlag;
	private String destGUID;
	private String destName;
	private long destFlag;
	private long destRaidFlag;

	public BaseEvent() {}

	public BaseEvent(String timeDate, String[] values) {
		this.timeStamp = timeDate;
		this.values = values;
	}

	public int parse() {
		return parse(this.timeStamp, this.values);
	}

	public int parse(String timeDate, String[] values) {
		int index = 0;
		if (values.length < 9)
			return -1;

		setTimeStamp(timeDate);
		setEvent(values[index++]);
		setSourceGUID(values[index++]);
		setSourceName(values[index++]);
		setSourceFlag(longParse(values[index++]));
		setSourceRaidFlag(longParse(values[index++]));
		setDestGUID(values[index++]);
		setDestName(values[index++]);
		setDestFlag(longParse(values[index++]));
		setDestRaidFlag(longParse(values[index++]));

		return index;
	}

	public void setTimeStamp(String s) { this.timeStamp = s; }
	public String getTimeStamp() { return this.timeStamp; }

	public void setEvent(String s) { this.event = s; }
	public String getEvent() { return this.event; }

	public void setSourceGUID(String s) { this.sourceGUID = s; }
	public String getSourceGUID() { return this.sourceGUID; }

	public void setSourceName(String s) { this.sourceName = s; }
	public String getSourceName() { return this.sourceName; }

	public void setSourceFlag(long l) { this.sourceFlag = l; }
	public long getSourceFlag() { return this.sourceFlag; }

	public void setSourceRaidFlag(long l) { this.sourceRaidFlag = l; }
	public long getSourceRaidFlag() { return this.sourceRaidFlag; }

	public void setDestGUID(String s) { this.destGUID = s; }
	public String getDestGUID() { return this.destGUID; }

	public void setDestName(String s) { this.destName = s; }
	public String getDestName() { return this.destName; }

	public void setDestFlag(long l) { this.destFlag = l; }
	public long getDestFlag() { return this.destFlag; }

	public void setDestRaidFlag(long l) { this.destRaidFlag = l; }
	public long getDestRaidFlag() { return this.destRaidFlag; }

	public long longParse(String s) {
		return Long.parseLong(s.replace("0x",""), 16);
	}

	@Override
	public boolean equals(Object other) {
		if (other == null)
			return false;
		if (other == this)
			return true;
		if (!(other instanceof BaseEvent))
			return false;

		BaseEvent that = (BaseEvent)other;

		return (this.getTimeStamp().equalsIgnoreCase(that.getTimeStamp())) &&
				(this.getEvent().equalsIgnoreCase(this.getEvent())) &&
				(this.getSourceGUID().equalsIgnoreCase(that.getSourceGUID())) &&
				(this.getSourceName().equalsIgnoreCase(that.getSourceName())) &&
				(this.getSourceFlag() == that.getSourceFlag()) &&
				(this.getSourceRaidFlag() == that.getSourceRaidFlag()) &&
				(this.getDestGUID().equalsIgnoreCase(that.getDestGUID())) &&
				(this.getDestName().equalsIgnoreCase(that.getDestName())) &&
				(this.getDestFlag() == that.getDestFlag()) &&
				(this.getDestRaidFlag() == that.getDestRaidFlag());
	}

	@Override
	public String toString() {
		char newLine = '\n';
		char tab = '\t';
		String s = "";
		s += "TimeStamp = " + getTimeStamp() + newLine;
		s += tab + "Event = " + getEvent() + newLine;
		s += tab + "SourceGUID = " + getSourceGUID() + newLine;
		s += tab + "SourceName = " + getSourceName() + newLine;
		s += tab + "SourceFlag = " + getSourceFlag() + newLine;
		s += tab + "SourceRaidFlag = " + getSourceRaidFlag() + newLine;
		s += tab + "DestGUID = " + getDestGUID() + newLine;
		s += tab + "DestName = " + getDestName() + newLine;
		s += tab + "DestFlag = " + getDestFlag() + newLine;
		s += tab + "DestRaidFlag = " + getDestRaidFlag() + newLine;
		return s;
	}
}