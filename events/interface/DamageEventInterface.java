package combatlogparser.events.interface;

public interface DamageEventInterface extends EventInterface {
	public void setAmount(int i);
	public int getAmount();
	public void setOverkill(int i);
	public int getOverkill();
	public void setSchool(int i);
	public int getSchool();
	public void setResisted(int i);
	public int getResisted();
	public void setBlocked(int i);
	public int getBlocked();
	public void setAbsorbed(int i);
	public int getAbsorbed();
	public void setCritical(String s);
	public boolean getCritical();
	public void setGlancing(String s);
	public boolean getGlancing();
	public void setCrushing(String s);
	public boolean getCrushing();
}