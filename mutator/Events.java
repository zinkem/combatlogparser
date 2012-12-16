package combatlogparser.mutator;

import java.io.*;
import java.util.*;
import java.text.*;
import combatlogparser.*;
import combatlogparser.events.BaseEvent;
import combatlogparser.mutator.EventsThread;

public class Events {
	private List<BaseEvent> events;
	private long lastUpdate = 0;

	public Events() {
		this.events = new ArrayList<BaseEvent>();
	}

	public Events(List<BaseEvent> events) {
		this.events = events;
	}

	public void addEvent(String timeDate, BaseEvent be, int line) {
			long thisUpdate = unixTimeDate(timeDate);

			if (this.lastUpdate == 0)
				this.lastUpdate = thisUpdate;

			if ((thisUpdate - this.lastUpdate) >= Constants.FIGHT_TIME_DELTA_MILLISECONDS) {
				//Send the fight into EventsThread for processing
				//Reset startLine and endLine
				//System.out.println(this.startLine + " => " + line);
				this.lastUpdate = thisUpdate;
				//System.out.println(be.toString());
				Thread t = new EventsThread(new ArrayList<BaseEvent>(this.events.subList(0, this.events.size() - 1)));
				t.start();
				//System.out.println("Fight lines: " + this.startLine + " to " + line);
				this.events = new ArrayList<BaseEvent>();
			}
			else
				this.lastUpdate = thisUpdate;

			this.events.add(be);
			//System.out.println(thisUpdate + " - " + this.lastUpdate + " = " + (thisUpdate - this.lastUpdate));
	}

	public void finishEvent() {
		Thread t = new EventsThread(new ArrayList<BaseEvent>(this.events.subList(0, this.events.size() - 1)));
		t.start();
	}

	private long unixTimeDate(String timeDate) {
		//12/1 20:48:28.306
		Date d = null;

		try {
			DateFormat df = new SimpleDateFormat("M/d HH:mm:ss.SSS");
			d = df.parse(timeDate);
		} catch (ParseException e) {
			System.out.println("ParseException in " + this.getClass());
			e.printStackTrace();
			System.exit(1);
		}
		return (long)d.getTime();
	}
}