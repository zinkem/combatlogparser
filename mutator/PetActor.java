package combatlogparser.mutator;

import java.io.*;
import java.util.*;

public class PetActor extends Actors {
	private String ownerName;
	private String ownerGuid;

	public PetActor(String name, String guid) {
		super(name, guid);
	}

	public PetActor(String name, String guid, String ownerName) {
		super(name, guid);
		this.ownerName = ownerName;
	}

	public PetActor(String name, String guid, String ownerName, String ownerGUID) {
		super(name, guid);
		this.ownerName = ownerName;
		this.ownerGuid = ownerGuid;
	}

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getOwnerName() {
        return this.ownerName;
    }

    public void setOwnerGuid(String ownerGuid) {
        this.ownerGuid = ownerGuid;
    }

    public String getOwnerGuid() {
        return this.ownerGuid;
    }

    @Override
    public boolean equals(Object other) {
    	if (other == null || !(other instanceof PetActor) || !super.equals(other))
    		return false;
    	if (other == this)
    		return true;

    	PetActor that = (PetActor)other;

    	return (this.getOwnerName() == that.getOwnerName()) && (this.getOwnerGuid() == that.getOwnerGuid());
    }

    @Override
    public String toString() {
        char newLine = '\n';
        char tab = '\t';
        String s = "";

        s += tab + "Owner Name = " + getOwnerName() + newLine;
        s += tab + "Owner GUID = " + getOwnerGuid() + newLine;
        return s;
    }
}