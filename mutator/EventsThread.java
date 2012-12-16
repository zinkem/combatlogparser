package combatlogparser.mutator;

import java.io.*;
import java.util.*;
import java.text.*;
import combatlogparser.*;
import combatlogparser.events.BaseEvent;
import combatlogparser.mutator.Fight;

public class EventsThread extends Thread {
	private ArrayList<BaseEvent> events;

	public EventsThread(ArrayList<BaseEvent> events) {
		this.events = events;
	}

	public void run() {
		//Deal with fight shit here
		Fight f = new Fight(this.events);
		System.out.println(f.toString());
	}
}