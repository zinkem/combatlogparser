package combatlogparser;

public interface Constants {
    public static final int UNIT_TYPE_PLAYER = 0;
    public static final int UNIT_TYPE_WORLD_OBJECT = 1;
    public static final int UNIT_TYPE_NPC = 3;
    public static final int UNIT_TYPE_PERMANENT_PETS = 4;
    public static final int UNIT_TYPE_VEHICLES = 5;
    
    public static final long FLAGS_OBJECT_AFFILIATION_MASK = 15;
    public static final long FLAGS_OBJECT_AFFILIATION_MINE = 1;
    public static final long FLAGS_OBJECT_AFFILIATION_OUTSIDER = 8;
    public static final long FLAGS_OBJECT_AFFILIATION_PARTY = 2;
    public static final long FLAGS_OBJECT_AFFILIATION_RAID = 4;
    public static final long FLAGS_OBJECT_CONTROL_MASK = 768;
    public static final long FLAGS_OBJECT_CONTROL_NPC = 512;
    public static final long FLAGS_OBJECT_CONTROL_PLAYER = 256;
    public static final long FLAGS_OBJECT_FOCUS = 131072;
    public static final long FLAGS_OBJECT_MAINASSIST = 524288;
    public static final long FLAGS_OBJECT_MAINTANK = 262144;
    public static final long FLAGS_OBJECT_NONE = -2147483648;
    public static final long FLAGS_OBJECT_RAIDTARGET1 = 1048576;
    public static final long FLAGS_OBJECT_RAIDTARGET2 = 2097152;
    public static final long FLAGS_OBJECT_RAIDTARGET3 = 4194304;
    public static final long FLAGS_OBJECT_RAIDTARGET4 = 8388608;
    public static final long FLAGS_OBJECT_RAIDTARGET5 = 16777216;
    public static final long FLAGS_OBJECT_RAIDTARGET6 = 33554432;
    public static final long FLAGS_OBJECT_RAIDTARGET7 = 67108864;
    public static final long FLAGS_OBJECT_RAIDTARGET8 = 134217728;
    public static final long FLAGS_OBJECT_REACTION_FRIENDLY = 16;
    public static final long FLAGS_OBJECT_REACTION_HOSTILE = 64;
    public static final long FLAGS_OBJECT_REACTION_MASK = 240;
    public static final long FLAGS_OBJECT_REACTION_NEUTRAL = 32;
    public static final long FLAGS_OBJECT_SPECIAL_MASK = -65536;
    public static final long FLAGS_OBJECT_TARGET = 65536;
    public static final long FLAGS_OBJECT_TYPE_GUARDIAN = 8192;
    public static final long FLAGS_OBJECT_TYPE_MASK = 64512;
    public static final long FLAGS_OBJECT_TYPE_NPC = 2048;
    public static final long FLAGS_OBJECT_TYPE_OBJECT = 16384;
    public static final long FLAGS_OBJECT_TYPE_PET = 4096;
    public static final long FLAGS_OBJECT_TYPE_PLAYER = 1024;

    public static final int POWER_TYPE_UNKNOWN = -10;
    public static final int POWER_TYPE_HEALTH = -2;
    public static final int POWER_TYPE_MANA = 0;
    public static final int POWER_TYPE_RAGE = 1;
    public static final int POWER_TYPE_FOCUS = 2;
    public static final int POWER_TYPE_ENERGY = 3;
    //public static final int POWER_TYPE_PETHAPPINESS = 4;
    public static final int POWER_TYPE_RUNES = 5;
    public static final int POWER_TYPE_RUNIC_POWER = 6;
    public static final int POWER_TYPE_SOUL_SHARD = 7;
    public static final int POWER_TYPE_ECLIPSE_ENERGY = 8; //Solar > 0 && Lunar < 0
    public static final int POWER_TYPE_HOLY_POWER = 9;
    public static final int POWER_TYPE_ALTERNATE_POWER = 10;
    public static final int POWER_TYPE_DARK_FORCE = 11;
    public static final int POWER_TYPE_LIGHT_FORCE = 12;
    public static final int POWER_TYPE_SHADOW_ORBS = 13;
    public static final int POWER_TYPE_BURNING_EMBERS = 14;
    public static final int POWER_TYPE_DEMONIC_FURY = 15;
    
    public static final int SCHOOL_NONE = 0;
    public static final int SCHOOL_PHYSICAL = 1;
    public static final int SCHOOL_HOLY = 2;
    public static final int SCHOOL_FIRE = 4;
    public static final int SCHOOL_NATURE = 8;
    public static final int SCHOOL_FROST = 16;
    public static final int SCHOOL_SHADOW = 32;
    public static final int SCHOOL_ARCANE = 64;

    public static final int GUID_MASK_PLAYER = 0;
    public static final int GUID_MASK_WORLD_OBJECT = 1;
    public static final int GUID_MASK_NPC = 3;
    public static final int GUID_MASK_PERMANENT_PET = 4;
    public static final int GUID_MASK_VEHICLE = 5;

    public static final int CLASS_WARRIOR = 1;
    public static final int CLASS_PALADIN = 2;
    public static final int CLASS_HUNTER = 3;
    public static final int CLASS_ROGUE = 4;
    public static final int CLASS_PRIEST = 5;
    public static final int CLASS_DEATH_KNIGHT = 6;
    public static final int CLASS_SHAMAN = 7;
    public static final int CLASS_MAGE = 8;
    public static final int CLASS_WARLOCK = 9;
    public static final int CLASS_MONK = 10;
    public static final int CLASS_DRUID = 11;

    public static final int FIGHT_TIME_DELTA_SECONDS = 15;
    public static final int FIGHT_TIME_DELTA_MILLISECONDS = 15000;

    public static final String BOSS_XML_BASE = "mutator\\helpers\\bossXML\\BossListREGION.xml";
    public static final String BOSS_XML_DEFAULT = "mutator\\helpers\\bossXML\\ossListEN.xml";
    public static final String BOSS_XML_EN = "mutator\\helpers\\bossXML\\BossListEN.xml";
}