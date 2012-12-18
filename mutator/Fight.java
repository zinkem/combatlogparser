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
import combatlogparser.mutator.*;
import combatlogparser.mutator.mobs.*;
import combatlogparser.mutator.helpers.*;
import org.w3c.dom.Node;
import org.w3c.dom.NamedNodeMap;

public class Fight {
	private ArrayList<BaseEvent> events;
	private Map<String, String> actors;
	private Boolean isBoss = null;
	private String fightInstance;
	private String fightName;

	public Fight(ArrayList<BaseEvent> events) {
		this.events = events;
		this.actors = new HashMap<String, String>();
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

	public void mapActors() {
		for (BaseEvent be : events) {
			String name = actors.containsKey(be.getSourceGUID()) ? actors.get(be.getSourceGUID()) : be.getSourceName();
			actors.put(be.getSourceGUID(), be.getSourceName());
		}
	}

	public void printActors() {
		for (String key : actors.keySet())
			System.out.println(key + " -> " + actors.get(key));
	}

	public void checkForBoss() {
		ArrayList<BossInfo> bossInfoList = new ArrayList<BossInfo>();
		XmlInfoParser xip = new XmlInfoParser("EN");
		List<Node> bossNodes = xip.getChildNodes("boss");

		for (Node bn : bossNodes) {
			if (bn != null) {
				NamedNodeMap attrs = bn.getAttributes();
				Node encounterNode = attrs.getNamedItem("encounter");
				Node instanceNode = attrs.getNamedItem("instance");
				Node maxIdleTimeNode = attrs.getNamedItem("maxidletime");
				BossInfo boss = new BossInfo(encounterNode.getTextContent(), instanceNode.getTextContent());
				if (maxIdleTimeNode != null)
					boss.setMaxIdleTime(Double.parseDouble(maxIdleTimeNode.getTextContent()));

				List<Node> mobNodes = xip.getChildNodes(bn, "mob");

				for (Node mn : mobNodes) {
					attrs = mn.getAttributes();
					Node nameNode = attrs.getNamedItem("name");
					Node idNode = attrs.getNamedItem("id");
					Node isBossNode = attrs.getNamedItem("boss");
					boolean isNPCBoss = false;

					if (isBossNode != null) {
						if ("true".equalsIgnoreCase(isBossNode.getTextContent()))
							isNPCBoss = true;
					}

					boss.addMob(new NPCInfo(nameNode.getTextContent(), Integer.valueOf(idNode.getTextContent()), isNPCBoss));
				}

				bossInfoList.add(boss);
			}
		}
		
		setIsBoss(false);

		for (String key : this.actors.keySet()) {
			String actorName = this.actors.get(key);
			if (!getIsBoss()) {
				for (BossInfo bi : bossInfoList) {
					ArrayList<NPCInfo> mobs = new ArrayList<NPCInfo>(bi.getMobs());

					for (NPCInfo npc : mobs) {
						setIsBoss(npc.getName().equalsIgnoreCase(actorName));
					}
				}
			}
			else
				break;
		}
	}

    public void setIsBoss(boolean isBoss) {
        this.isBoss = isBoss;
    }

    public boolean getIsBoss() {
    	if (this.isBoss == null)
    		checkForBoss();

        return this.isBoss;
    }

    public void setFightInstance(String fightInstance) {
        this.fightInstance = fightInstance;
    }

    public String getFightInstance() {
        return this.fightInstance;
    }

    public void setFightName(String fightName) {
        this.fightName = fightName;
    }

    public String getFightName() {
        return this.fightName;
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