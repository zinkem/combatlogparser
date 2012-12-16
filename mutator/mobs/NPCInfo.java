package combatlogparse.mutator.mobs;

public class NPCInfo {
	private String name;
	private int id;
	private boolean isBoss;

	public NPCInfo(String name, int id) {
		this.name = name;
		this.id = id;
		this.isBoss = false;
	}

	public NPCInfo(String name, int id, boolean isBoss) {
		this.name = name;
		this.id = id;
		this.isBoss = isBoss;
	}
	
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public void setIsBoss(boolean isBoss) {
        this.isBoss = isBoss;
    }

    public boolean getIsBoss() {
        return this.isBoss;
    }
}