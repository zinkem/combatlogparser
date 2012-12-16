package combatlogparse.mutator.mobs;

import java.util.*;

public class BossInfo {
	private double maxIdleTime;
	private String encounterName;
	private List<NPCInfo> mobs;

	public BossInfo(String encounterName) {
		this.maxIdleTime = 15;
		this.encounterName = encounterName;
		this.mobs = new ArrayList<NPCInfo>();
	}

	public void addMob(NPCInfo mob) {
		this.mobs.add(mob);
	}

    public void setMaxIdleTime(double maxIdleTime) {
        this.maxIdleTime = maxIdleTime;
    }

    public double getMaxIdleTime() {
        return this.maxIdleTime;
    }

    public void setEncounterName(String encounterName) {
        this.encounterName = encounterName;
    }

    public String getEncounterName() {
        return this.encounterName;
    }

    public void setMobs(List<NPCInfo> mobs) {
        this.mobs = new ArrayList<NPCInfo>(mobs);
    }

    public List<NPCInfo> getMobs() {
        return this.mobs;
    }
}