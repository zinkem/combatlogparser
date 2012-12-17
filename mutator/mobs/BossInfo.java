package combatlogparser.mutator.mobs;

import java.util.*;

public class BossInfo {
	private double maxIdleTime;
	private String encounterName;
    private String encounterLocation;
	private List<NPCInfo> mobs;

	public BossInfo(String encounterName, String encounterLocation) {
		this.maxIdleTime = 15;
		this.encounterName = encounterName;
        this.encounterLocation = encounterLocation;
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

    public void setEncounterLocation(String encounterLocation) {
        this.encounterLocation = encounterLocation;
    }

    public String getEncounterLocation() {
        return this.encounterLocation;
    }

    public void setMobs(List<NPCInfo> mobs) {
        this.mobs = new ArrayList<NPCInfo>(mobs);
    }

    public List<NPCInfo> getMobs() {
        return this.mobs;
    }
}