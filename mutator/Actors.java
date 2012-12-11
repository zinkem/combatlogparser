package combatlogparser.mutator;

import java.io.*;
import java.util.*;
import combatlogparser.*;
import combatlogparser.events.*;
import combatlogparser.events.swing.*;
import combatlogparser.events.range.*;
import combatlogparser.events.environmental.*;
import combatlogparser.events.spell.*;
import combatlogparser.events.spell.aura.*;
import combatlogparser.events.spell.cast.*;
import combatlogparser.events.spell.heal.*;
import combatlogparser.events.spell.periodic.*;
import combatlogparser.mutator.*;

public class Actors {
	private String name;
	private String guid;
    private List<BaseEvent> events;

	public Actors(String name, String guid) {
		this.name = name;
		this.guid = guid;
        events = new ArrayList<BaseEvent>();
        System.out.println(this.getClass());
	}

	public Actors(Actors a) {
		this.name = a.getName();
		this.guid = a.getGuid();
        events = new ArrayList<BaseEvent>();   
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
        return events.subList(i, i);
    }

    public List<BaseEvent> getEvents(int s, int e) {
        return events.subList(s, e);
    }

    @Override
    public boolean equals(Object other) {
    	if (other == null || !(other instanceof Actors))
    		return false;
    	if (other == this)
    		return true;

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