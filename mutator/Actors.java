package combatlogparser.mutator;

public class Actors {
	private String name;
	private String guid;
    private List<BaseEvent> events;

	public Actors(String name, String guid) {
		this.name = name;
		this.guid = guid;
	}

	public Actors(Actors a) {
		this.name = a.getName();
		this.guid = a.getGuid();
	}

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getGuid() {
        return this.guid;
    }

    public void addEvents(BaseEvent b) {
        if (!events.contains(b))
            events.add(b);
    }

    public List<BaseEvent> getEvents() {
        return this.events;
    }

    public List<BaseEvent> getEvents(int i) {
        return events.sublist(i, i);
    }

    public List<BaseEvent> getEvents(int s, int e) {
        return events.sublist(s, e);
    }

    @Override
    public boolean equals(Object other) {
    	if (other == null)
    		return false;
    	if (other == this)
    		return true;
    	if (!(other instanceof Actors))
    		return false;

    	Actors that = (Actors)other;

    	return (this.getName() == that.getName()) && (this.getGuid() == that.getGuid());
    }

    @Override
    public String toString() {
        char newLine = '\n';
        char tab = '\t';
        String s = "";

        s += "Name = " + getName() + newLine;
        s += tab + "GUID = " + getGuid() + newLine;

        return s;
    }
}