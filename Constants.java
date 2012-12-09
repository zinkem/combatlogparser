package combatlogparser;

public interface Constants {
    public static final long FLAGS_ALL = -1;
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
}