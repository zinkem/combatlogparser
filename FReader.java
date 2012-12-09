package combatlogparser;

import java.io.*;
import java.util.*;
import combatlogparser.events.*;
import combatlogparser.events.swing.*;
import combatlogparser.events.range.*;
import combatlogparser.events.spell.*;
import combatlogparser.events.spell.cast.*;
import combatlogparser.events.spell.heal.*;
import combatlogparser.events.spell.periodic.*;
//import org.json.simple.*;

public class FReader {
	private static HashMap<String, Class> classMap;

	public static void main(String[] args) {
		File testerLogFile = new File("Logs/CombatLog_01.txt");
		createClassHashMap();
		try {
			BufferedReader br = endOfFile(testerLogFile);
			while (true) {
				String s = br.readLine();
				if (s != null) {
					LineParser lp = new LineParser();
					lp.parse(s);
					Class c = getEventClass(lp.getValues());
					if (c != null) {
						BaseEvent be = (BaseEvent)c.newInstance();
						if (be.parse(lp.getTimeDate(), lp.getValues()) >= 1)
							System.out.println(be.toString());
						else
							System.exit(1);
					}
        			//System.exit(1);
					//System.out.println(i + " " + s.replace(System.getProperty("line.separator"), ""));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
	}

	public static BufferedReader endOfFile(File f) {
		try {
			long fileLength = f.length() - 1;
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(f), "UTF-8"));
			//br.skip(fileLength);

			return br;
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}

		return null;
	}

	public static Class getEventClass(String[] s) {
		return classMap.get(s[0].toUpperCase());
	}

	public static void createClassHashMap() {
		classMap = new HashMap<String, Class>();
		//Swing
		classMap.put("SWING_DAMAGE", SwingDamage.class);
		classMap.put("SWING_MISSED", SwingMissed.class);
		//Range
		classMap.put("RANGE_DAMAGE", RangeDamage.class);
		classMap.put("RANGE_MISSED", RangeMiss.class);
		//Spell Cast
		classMap.put("SPELL_CAST_FAILED", CastFailed.class);
		classMap.put("SPELL_CAST_START", CastStart.class);
		classMap.put("SPELL_CAST_SUCCESS", CastSuccess.class);
		//Spell Heal
		classMap.put("SPELL_HEAL", SpellHeal.class);
		classMap.put("SPELL_PERIODIC_HEAL", SpellPeriodicHeal.class);
		//Spell Damage
		classMap.put("SPELL_DAMAGE", SpellDamage.class);
		classMap.put("SPELL_DISPEL", SpellDispel.class);
		classMap.put("SPELL_DISPEL_FAILED", SpellDispelFailed.class);
		classMap.put("SPELL_DRAIN", SpellDrain.class);
		classMap.put("SPELL_ENERGIZE", SpellEnergize.class);
		classMap.put("SPELL_INTERRUPT", SpellInterrupt.class);
		classMap.put("SPELL_LEECH", SpellLeech.class);
		classMap.put("SPELL_MISSED", SpellMissed.class);
		classMap.put("SPELL_STOLEN", SpellStolen.class);
		//Spell Periodic
		classMap.put("SPELL_PERIODIC_DAMAGE", SpellPeriodicDamage.class);
		classMap.put("SPELL_PERIODIC_DRAIN", SpellPeriodicDrain.class);
		classMap.put("SPELL_PERIODIC_ENERGIZE", SpellPeriodicEnergize.class);
		classMap.put("SPELL_PERIODIC_LEECH", SpellPeriodicLeech.class);
		classMap.put("SPELL_PERIODIC_MISSED", SpellPeriodicMissed.class);
	}
}