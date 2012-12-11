package combatlogparser;

import java.io.*;
import java.util.*;
import java.util.zip.DeflaterOutputStream;
import combatlogparser.events.*;
import combatlogparser.events.swing.*;
import combatlogparser.events.range.*;
import combatlogparser.events.environmental.*;
import combatlogparser.events.spell.*;
import combatlogparser.events.spell.aura.*;
import combatlogparser.events.spell.cast.*;
import combatlogparser.events.spell.heal.*;
import combatlogparser.events.spell.periodic.*;
//import org.json.simple.*;

public class FReader {
	private static HashMap<String, Class> classMap;
	
	public static void main(String[] args) {
		File testerLogFile = new File("Logs/CombatLog_02.txt");
		//File def = new File("report.dat");
		createClassHashMap();
		long sT = System.currentTimeMillis();
		long lines = 0;
		try {
			/*if (!def.exists())
				def.createNewFile();*/
			//DataOutputStream out = new DataOutputStream(new DeflaterOutputStream(new FileOutputStream(def)));
			BufferedReader br = endOfFile(testerLogFile);
			//while (true) {
				String s;// = br.readLine();
				while ((s = br.readLine()) != null) {
				//if (s != null) {
					LineParser lp = new LineParser();
					lp.parse(s);
					//System.out.println(s);
					Class c = getEventClass(lp.getValues());
					if (c != null) {
						BaseEvent be = (BaseEvent)c.newInstance();
						if (be.parse(lp.getTimeDate(), lp.getValues()) >= 1) {
							//System.out.println(be.toString());
							//out.writeBytes(s);
						}
						else {
							long fT = (System.currentTimeMillis() - sT);
							System.out.println(fT + " " + lines);
							System.exit(1);
						}
					}
					++lines;
        			//System.exit(1);
					//System.out.println(i + " " + s.replace(System.getProperty("line.separator"), ""));
				}
				br.close();
				//out.close();
			//}
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
		long fT = (System.currentTimeMillis() - sT);
		System.out.println(fT + "ms " + lines + " lines");
	}

	public static BufferedReader endOfFile(File f) {
		try {
			long fileLength = f.length() - 1;
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(f), "UTF-8"));
			//br.skip(200000);

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
		classMap.put("SPELL_EXTRA_ATTACKS", SpellExtraAttacks.class);
		classMap.put("SPELL_INSTAKILL", SpellInstaKill.class);
		classMap.put("SPELL_CREATE", SpellCreate.class);
		classMap.put("SPELL_SUMMON", SpellSummon.class);
		classMap.put("SPELL_RESURRECT", SpellResurrect.class);
		//Spell Aura
		classMap.put("SPELL_AURA_APPLIED", SpellAuraApplied.class);
		classMap.put("SPELL_AURA_REMOVED", SpellAuraRemoved.class);
		classMap.put("SPELL_AURA_APPLIED_DOSE", SpellAuraAppliedDose.class);
		classMap.put("SPELL_AURA_REMOVED_DOSE", SpellAuraRemovedDose.class);
		classMap.put("SPELL_AURA_REFRESH", SpellAuraRefresh.class);
		classMap.put("SPELL_AURA_BROKEN", SpellAuraBroken.class);
		classMap.put("SPELL_AURA_BROKEN_SPELL", SpellAuraBrokenSpell.class);
		//Spell Periodic
		classMap.put("SPELL_PERIODIC_DAMAGE", SpellPeriodicDamage.class);
		classMap.put("SPELL_PERIODIC_DRAIN", SpellPeriodicDrain.class);
		classMap.put("SPELL_PERIODIC_ENERGIZE", SpellPeriodicEnergize.class);
		classMap.put("SPELL_PERIODIC_LEECH", SpellPeriodicLeech.class);
		classMap.put("SPELL_PERIODIC_MISSED", SpellPeriodicMissed.class);
		//Environmental
		classMap.put("ENVIRONMENTAL_DAMAGE", EnvironmentalDamage.class);
	}
}