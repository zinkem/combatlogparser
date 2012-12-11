package combatlogparser.mutator;

import combatlogparser.events.BaseEvent;

public class Events {
	private List<BaseEvent> events;
	private boolean isFinsihed;
	private int startLine = 0;
	private int endLine = 0;
	private int curLine = 0;

	public Events() {
		events = new ArrayList<BaseEvent>();
	}

	public Events(List<BaseEvent> events) {
		this.events = events;
	}

	public void addEvent(BaseEvent be) {
		this.events.add(be);
	}
}