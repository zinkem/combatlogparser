package combatlogparser.mutator;

import java.io.*;
import java.util.*;
import java.text.*;
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

public class Fight {
	private ArrayList<BaseEvent> events;

	public Fight(ArrayList<BaseEvent> events) {
		this.events = events;
	}

	public long getFightDuration() {
		return unixTimeDate(this.events.get(this.events.size() - 1).getTimeStamp()) - unixTimeDate(this.events.get(0).getTimeStamp());
	}

	public long getTotalMeleeDamage() {
		long damage = 0;
		List<MeleeDamageEvent> mde = getMeleeDamageEvents();

		for (MeleeDamageEvent sd : mde) {
			if (sd instanceof MeleeDamageEvent)
				damage += sd.getAmount();
		}

		return damage;
	}

	public List<MeleeDamageEvent> getMeleeDamageEvents() {
		List<MeleeDamageEvent> outEvents = new ArrayList<MeleeDamageEvent>();
		for (BaseEvent be : this.events) {
			if (be instanceof MeleeDamageEvent)
				outEvents.add((MeleeDamageEvent)be);
		}

		return outEvents;
	}

	public long getTotalSpellDamage() {
		long damage = 0;
		List<SpellDamageEvent> sde = getSpellDamageEvents();

		for (SpellDamageEvent sd : sde) {
			if (sd instanceof SpellDamageEvent)
				damage += sd.getAmount();
		}

		return damage;
	}

	public List<SpellDamageEvent> getSpellDamageEvents() {
		List<SpellDamageEvent> outEvents = new ArrayList<SpellDamageEvent>();
		for (BaseEvent be : this.events) {
			if (be instanceof SpellDamageEvent)
				outEvents.add((SpellDamageEvent)be);
		}

		return outEvents;
	}

	public long getTotalSpellPeriodicDamage() {
		long damage = 0;
		List<SpellPeriodicDamageEvent> sde = getSpellPeriodicDamageEvents();

		for (SpellPeriodicDamageEvent sd : sde) {
			if (sd instanceof SpellPeriodicDamageEvent)
				damage += sd.getAmount();
		}

		return damage;
	}

	public List<SpellPeriodicDamageEvent> getSpellPeriodicDamageEvents() {
		List<SpellPeriodicDamageEvent> outEvents = new ArrayList<SpellPeriodicDamageEvent>();
		for (BaseEvent be : this.events) {
			if (be instanceof SpellPeriodicDamageEvent)
				outEvents.add((SpellPeriodicDamageEvent)be);
		}

		return outEvents;
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

	@Override
	public String toString() {
		char newLine = '\n';
		char tab = '\t';
		String s = "";

		s += tab + "Duration: " + getFightDuration() + newLine;
		s += tab + "Melee Damage: " + getTotalMeleeDamage() + newLine;
		s += tab + "Spell Damage: " + getTotalSpellDamage() + newLine;
		s += tab + "Spell Periodic Damage: " + getTotalSpellPeriodicDamage() + newLine;

		return s;
	}
}