package profile;

import profile.fields.*;

public class SkyblockProfile {

    public String playerName;
    public String profileName;
    public String gameMode;

    //ADD NEW FIELD
    public CatacombsField catacombs = new CatacombsField("data.dungeons.catacombs.level.xp");
    public GemstonePowderField gemstonePowder = new GemstonePowderField("data.mining.core.powder.gemstone.total");
    public MithrilPowderField mithrilPowder = new MithrilPowderField("data.mining.core.powder.mithril.total");
    public MinionSlotsField minionSlots = new MinionSlotsField("data.minion_slots.currentSlots");
    public TalismansField talismans = new TalismansField("items.talismans");
    public PetScoreField petScore = new PetScoreField("data.petScore");
    public SkillField taming = new SkillField("data.levels.taming.xp", 2);
    public SkillField farming = new FarmingSkillField("data.levels.farming.xp", 9);
    public SkillField mining = new SkillField("data.levels.mining.xp", 9);
    public SkillField combat = new SkillField("data.levels.combat.xp", 10);
    public SkillField foraging = new SkillField("data.levels.foraging.xp", 9);
    public SkillField fishing = new SkillField("data.levels.fishing.xp", 11);
    public SkillField enchanting = new SkillField("data.levels.enchanting.xp", 2);
    public SkillField alchemy = new SkillField("data.levels.alchemy.xp", 3);
    public SlayerField zombie = new SlayerField("data.slayers.zombie.level.xp", 10, 1);
    public SlayerField spider = new SlayerField("data.slayers.spider.level.xp", 11.1, 2.6);
    public SlayerField wolf = new SlayerField("data.slayers.wolf.level.xp", 13.2, 3.1);
    public SlayerField enderman = new SlayerField("data.slayers.enderman.level.xp", 16.9, 2);

    //ADD NEW PET FIELD
    public FieldCollection pets = new FieldCollection(new PetField[]{
            new PetField("data.pets", "SCATHA", new double[]{0, 0, 30, 35, 40, 0}),
            new PetField("data.pets", "BAL", new double[]{0, 0, 0, 10, 15, 0}),
            new PetField("data.pets", "PHOENIX", new double[]{0, 0, 0, 15, 20, 0}),
            new PetField("data.pets", "GOLDEN_DRAGON", new double[]{0, 0, 0, 0, 35, 0}),
            new PetField("data.pets", "ENDER_DRAGON", new double[]{0, 0, 0, 40, 45, 0}),
            new PetField("data.pets", "SNOWMAN", new double[]{0, 0, 0, 0, 5, 0}),
            new PetField("data.pets", "SPIRIT", new double[]{0, 0, 0, 0, 5, 0}),
            new PetField("data.pets", "GRIFFIN", new double[]{0, 0, 0, 0, 25, 0}),
            new PetField("data.pets", "ELEPHANT", new double[]{0, 0, 0, 0, 10, 0}),
            new PetField("data.pets", "MONKEY", new double[]{0, 0, 0, 0, 10, 0}),
            new PetField("data.pets", "ENDERMAN", new double[]{0, 0, 0, 0, 15, 16}),
            new PetField("data.pets", "BLUE_WHALE", new double[]{0, 0, 0, 0, 15, 0}),
            new PetField("data.pets", "BABY_YETI", new double[]{0, 0, 0, 20, 20, 0}),
            new PetField("data.pets", "BLACK_CAT", new double[]{0, 0, 0, 0, 10, 0}),
            new PetField("data.pets", "LION", new double[]{0, 0, 0, 0, 5, 0}),
            new PetField("data.pets", "BLAZE", new double[]{0, 0, 0, 25, 35, 0}),
            new PetField("data.pets", "TIGER", new double[]{0, 0, 0, 0, 15, 0}),
            new PetField("data.pets", "AMMONITE", new double[]{0, 0, 0, 0, 5, 0}),
            new PetField("data.pets", "SQUID", new double[]{0, 0, 0, 0, 10, 0}),
            new PetField("data.pets", "WOLF", new double[]{0, 0, 0, 0, 5, 0}),
            new PetField("data.pets", "WITHER_SKELETON", new double[]{0, 0, 0, 0, 5, 0}),
    });

    //ADD NEW ITEM FIELD
    public FieldCollection items = new FieldCollection(new ItemField[]{
            new ItemField("items.weapons", "ASPECT_OF_THE_END", 1),
            new ItemField("items.weapons", "ASPECT_OF_THE_VOID", 6),
            new ItemField(new String[]{"items.wardrobe_inventory", "items.armor", "items.inventory", "items.enderchest", "items.personal_vault", "items.storage"}, "POWER_WITHER_HELMET", 4),
            new ItemField(new String[]{"items.wardrobe_inventory", "items.armor", "items.inventory", "items.enderchest", "items.personal_vault", "items.storage"}, "POWER_WITHER_CHESTPLATE", 12),
            new ItemField(new String[]{"items.wardrobe_inventory", "items.armor", "items.inventory", "items.enderchest", "items.personal_vault", "items.storage"}, "POWER_WITHER_LEGGINGS", 7),
            new ItemField(new String[]{"items.wardrobe_inventory", "items.armor", "items.inventory", "items.enderchest", "items.personal_vault", "items.storage"}, "POWER_WITHER_BOOTS", 4),
            new ItemField(new String[]{"items.wardrobe_inventory", "items.armor", "items.inventory", "items.enderchest", "items.personal_vault", "items.storage"}, "SHARK_SCALE_HELMET", 2),
            new ItemField(new String[]{"items.wardrobe_inventory", "items.armor", "items.inventory", "items.enderchest", "items.personal_vault", "items.storage"}, "SHARK_SCALE_CHESTPLATE", 3),
            new ItemField(new String[]{"items.wardrobe_inventory", "items.armor", "items.inventory", "items.enderchest", "items.personal_vault", "items.storage"}, "SHARK_SCALE_LEGGINGS", 3),
            new ItemField(new String[]{"items.wardrobe_inventory", "items.armor", "items.inventory", "items.enderchest", "items.personal_vault", "items.storage"}, "SHARK_SCALE_BOOTS", 2),
            new ItemField(new String[]{"items.wardrobe_inventory", "items.armor", "items.inventory", "items.enderchest", "items.personal_vault", "items.storage"}, "WISE_WITHER_HELMET", 3),
            new ItemField(new String[]{"items.wardrobe_inventory", "items.armor", "items.inventory", "items.enderchest", "items.personal_vault", "items.storage"}, "WISE_WITHER_CHESTPLATE", 11),
            new ItemField(new String[]{"items.wardrobe_inventory", "items.armor", "items.inventory", "items.enderchest", "items.personal_vault", "items.storage"}, "WISE_WITHER_LEGGINGS", 6),
            new ItemField(new String[]{"items.wardrobe_inventory", "items.armor", "items.inventory", "items.enderchest", "items.personal_vault", "items.storage"}, "WISE_WITHER_BOOTS", 4),
            new ItemField(new String[]{"items.wardrobe_inventory", "items.armor", "items.inventory", "items.enderchest", "items.personal_vault", "items.storage"}, "WARDEN_HELMET", 28),
            new ItemField(new String[]{"items.wardrobe_inventory", "items.armor", "items.inventory", "items.enderchest", "items.personal_vault", "items.storage"}, "WITHER_GOGGLES", 3),
            new ItemField(new String[]{"items.wardrobe_inventory", "items.armor", "items.inventory", "items.enderchest", "items.personal_vault", "items.storage"}, "TANK_WITHER_HELMET", 3),
            new ItemField(new String[]{"items.wardrobe_inventory", "items.armor", "items.inventory", "items.enderchest", "items.personal_vault", "items.storage"}, "TANK_WITHER_CHESTPLATE", 11),
            new ItemField(new String[]{"items.wardrobe_inventory", "items.armor", "items.inventory", "items.enderchest", "items.personal_vault", "items.storage"}, "TANK_WITHER_LEGGINGS", 6),
            new ItemField(new String[]{"items.wardrobe_inventory", "items.armor", "items.inventory", "items.enderchest", "items.personal_vault", "items.storage"}, "TANK_WITHER_BOOTS", 4),
            new ItemField(new String[]{"items.wardrobe_inventory", "items.armor", "items.inventory", "items.enderchest", "items.personal_vault", "items.storage"}, "SPEED_WITHER_HELMET", 3),
            new ItemField(new String[]{"items.wardrobe_inventory", "items.armor", "items.inventory", "items.enderchest", "items.personal_vault", "items.storage"}, "SPEED_WITHER_CHESTPLATE", 11),
            new ItemField(new String[]{"items.wardrobe_inventory", "items.armor", "items.inventory", "items.enderchest", "items.personal_vault", "items.storage"}, "SPEED_WITHER_LEGGINGS", 6),
            new ItemField(new String[]{"items.wardrobe_inventory", "items.armor", "items.inventory", "items.enderchest", "items.personal_vault", "items.storage"}, "SPEED_WITHER_BOOTS", 4),
            new ItemField("items.weapons", "AXE_OF_THE_SHREDDED", 15),
            new ItemField("items.weapons", "SOUL_WHIP", 4),
            new ItemField("items.weapons", "GIANTS_SWORD", 30),
            new ItemField(new String[]{"items.wardrobe_inventory", "items.armor", "items.inventory", "items.enderchest", "items.personal_vault", "items.storage"}, "DIAMOND_BONZO_HEAD", 25),
            new ItemField(new String[]{"items.wardrobe_inventory", "items.armor", "items.inventory", "items.enderchest", "items.personal_vault", "items.storage"}, "DIAMOND_SCARF_HEAD", 25),
            new ItemField(new String[]{"items.wardrobe_inventory", "items.armor", "items.inventory", "items.enderchest", "items.personal_vault", "items.storage"}, "DIAMOND_PROFESSOR_HEAD", 25),
            new ItemField(new String[]{"items.wardrobe_inventory", "items.armor", "items.inventory", "items.enderchest", "items.personal_vault", "items.storage"}, "DIAMOND_THORN_HEAD", 25),
            new ItemField(new String[]{"items.wardrobe_inventory", "items.armor", "items.inventory", "items.enderchest", "items.personal_vault", "items.storage"}, "DIAMOND_LIVID_HEAD", 28),
            new ItemField(new String[]{"items.wardrobe_inventory", "items.armor", "items.inventory", "items.enderchest", "items.personal_vault", "items.storage"}, "DIAMOND_SADAN_HEAD", 29),
            new ItemField(new String[]{"items.wardrobe_inventory", "items.armor", "items.inventory", "items.enderchest", "items.personal_vault", "items.storage"}, "DIAMOND_NECRON_HEAD", 30),
            new ItemField(new String[]{"items.wardrobe_inventory", "items.armor", "items.inventory", "items.enderchest", "items.personal_vault", "items.storage"}, "GOLD_BONZO_HEAD", 6),
            new ItemField(new String[]{"items.wardrobe_inventory", "items.armor", "items.inventory", "items.enderchest", "items.personal_vault", "items.storage"}, "GOLD_SCARF_HEAD", 6),
            new ItemField(new String[]{"items.wardrobe_inventory", "items.armor", "items.inventory", "items.enderchest", "items.personal_vault", "items.storage"}, "GOLD_PROFESSOR_HEAD", 6),
            new ItemField(new String[]{"items.wardrobe_inventory", "items.armor", "items.inventory", "items.enderchest", "items.personal_vault", "items.storage"}, "GOLD_THORN_HEAD", 6),
            new ItemField(new String[]{"items.wardrobe_inventory", "items.armor", "items.inventory", "items.enderchest", "items.personal_vault", "items.storage"}, "GOLD_LIVID_HEAD", 6),
            new ItemField(new String[]{"items.wardrobe_inventory", "items.armor", "items.inventory", "items.enderchest", "items.personal_vault", "items.storage"}, "GOLD_SADAN_HEAD", 7),
            new ItemField(new String[]{"items.wardrobe_inventory", "items.armor", "items.inventory", "items.enderchest", "items.personal_vault", "items.storage"}, "GOLD_NECRON_HEAD", 7),
            new ItemField("items.weapons", "SCYLLA", 32),
            new ItemField("items.weapons", "HYPERION", 32),
            new ItemField("items.weapons", "VALKYRIE", 32),
            new ItemField("items.weapons", "ASTRAEA", 32),
            new ItemField(new String[]{"items.wardrobe_inventory", "items.armor", "items.inventory", "items.enderchest", "items.personal_vault", "items.storage"}, "SORROW_HELMET", 3),
            new ItemField(new String[]{"items.wardrobe_inventory", "items.armor", "items.inventory", "items.enderchest", "items.personal_vault", "items.storage"}, "SORROW_CHESTPLATE", 4),
            new ItemField(new String[]{"items.wardrobe_inventory", "items.armor", "items.inventory", "items.enderchest", "items.personal_vault", "items.storage"}, "SORROW_LEGGINGS", 4),
            new ItemField(new String[]{"items.wardrobe_inventory", "items.armor", "items.inventory", "items.enderchest", "items.personal_vault", "items.storage"}, "SORROW_BOOTS", 3),
            new ItemField(new String[]{"items.wardrobe_inventory", "items.armor", "items.inventory", "items.enderchest", "items.personal_vault", "items.storage"}, "DIVAN_HELMET", 8),
            new ItemField(new String[]{"items.wardrobe_inventory", "items.armor", "items.inventory", "items.enderchest", "items.personal_vault", "items.storage"}, "DIVAN_CHESTPLATE", 9),
            new ItemField(new String[]{"items.wardrobe_inventory", "items.armor", "items.inventory", "items.enderchest", "items.personal_vault", "items.storage"}, "DIVAN_LEGGINGS", 9),
            new ItemField(new String[]{"items.wardrobe_inventory", "items.armor", "items.inventory", "items.enderchest", "items.personal_vault", "items.storage"}, "DIVAN_BOOTS", 7),
            new ItemField("items.weapons", "SWORD_OF_REVELATIONS", 3),
            new ItemField("items.weapons", "TERMINATOR", 46),
            new ItemField("items.weapons", "JUJU_SHORTBOW", 11),
            new ItemField("items.weapons", "ATOMSPLIT_KATANA", 20),
            new ItemField("items.weapons", "VORPAL_KATANA", 8),
            new ItemField("items.weapons", "FLOWER_OF_TRUTH", 2),
            new ItemField("items.weapons", "LIVID_DAGGER", 2),
            new ItemField(new String[]{"items.wardrobe_inventory", "items.armor", "items.inventory", "items.enderchest", "items.personal_vault", "items.storage"}, "SHADOW_ASSASSIN_HELMET", 2),
            new ItemField(new String[]{"items.wardrobe_inventory", "items.armor", "items.inventory", "items.enderchest", "items.personal_vault", "items.storage"}, "SHADOW_ASSASSIN_CHESTPLATE", 7),
            new ItemField(new String[]{"items.wardrobe_inventory", "items.armor", "items.inventory", "items.enderchest", "items.personal_vault", "items.storage"}, "SHADOW_ASSASSIN_LEGGINGS", 3),
            new ItemField(new String[]{"items.wardrobe_inventory", "items.armor", "items.inventory", "items.enderchest", "items.personal_vault", "items.storage"}, "SHADOW_ASSASSIN_BOOTS", 2),
            new ItemField(new String[]{"items.wardrobe_inventory", "items.armor", "items.inventory", "items.enderchest", "items.personal_vault", "items.storage"}, "FINAL_DESTINATION_HELMET", 2),
            new ItemField(new String[]{"items.wardrobe_inventory", "items.armor", "items.inventory", "items.enderchest", "items.personal_vault", "items.storage"}, "FINAL_DESTINATION_CHESTPLATE", 2),
            new ItemField(new String[]{"items.wardrobe_inventory", "items.armor", "items.inventory", "items.enderchest", "items.personal_vault", "items.storage"}, "FINAL_DESTINATION_LEGGINGS", 2),
            new ItemField(new String[]{"items.wardrobe_inventory", "items.armor", "items.inventory", "items.enderchest", "items.personal_vault", "items.storage"}, "FINAL_DESTINATION_BOOTS", 2),
            new ItemField(new String[]{"items.wardrobe_inventory", "items.armor", "items.inventory", "items.enderchest", "items.personal_vault", "items.storage"}, "PRECURSOR_EYE", 18),
            new ItemField(new String[]{"items.wardrobe_inventory", "items.armor", "items.inventory", "items.enderchest", "items.personal_vault", "items.storage"}, "REAPER_MASK", 10),
            new ItemField("items.mining_tools", "TITANIUM_DRILL_4", 27),
            new ItemField("items.mining_tools", "TITANIUM_DRILL_3", 18),
            new ItemField("items.mining_tools", "TITANIUM_DRILL_2", 9),
            new ItemField("items.mining_tools", "TITANIUM_DRILL_1", 5),
            new ItemField("items.mining_tools", "DIVAN_DRILL", 42),
            new ItemField("items.weapons", "DEADALUS_AXE", 14),
            new ItemField(new String[]{"items.wardrobe_inventory", "items.armor", "items.inventory", "items.enderchest", "items.personal_vault", "items.storage"}, "RANCHER_BOOTS", 2),
            new ItemField("items.mining_tools", "GEMSTONE_GAUNTLET", 8),
            new ItemField(new String[]{"items.wardrobe_inventory", "items.armor", "items.inventory", "items.enderchest", "items.personal_vault", "items.storage"}, "WITHER_HELMET", 2),
            new ItemField(new String[]{"items.wardrobe_inventory", "items.armor", "items.inventory", "items.enderchest", "items.personal_vault", "items.storage"}, "WITHER_CHESTPLATE", 10),
            new ItemField(new String[]{"items.wardrobe_inventory", "items.armor", "items.inventory", "items.enderchest", "items.personal_vault", "items.storage"}, "WITHER_LEGGINGS", 5),
            new ItemField(new String[]{"items.wardrobe_inventory", "items.armor", "items.inventory", "items.enderchest", "items.personal_vault", "items.storage"}, "WITHER_BOOTS", 2),
            new ItemField("items.weapons", "MIDAS_STAFF", 3),
            new ItemField("items.fishing_tools", "ROD_OF_THE_SEA", 5),
            new ItemField("items.fishing_tools", "AUGER_ROD", 8),
            new ItemField(new String[]{"items.wardrobe_inventory", "items.armor", "items.inventory", "items.enderchest", "items.personal_vault", "items.storage"}, "YOUNG_DRAGON_HELMET", 1),
            new ItemField(new String[]{"items.wardrobe_inventory", "items.armor", "items.inventory", "items.enderchest", "items.personal_vault", "items.storage"}, "YOUNG_DRAGON_CHESTPLATE", 1),
            new ItemField(new String[]{"items.wardrobe_inventory", "items.armor", "items.inventory", "items.enderchest", "items.personal_vault", "items.storage"}, "YOUNG_DRAGON_LEGGINGS", 1),
            new ItemField(new String[]{"items.wardrobe_inventory", "items.armor", "items.inventory", "items.enderchest", "items.personal_vault", "items.storage"}, "YOUNG_DRAGON_BOOTS", 1),
            new ItemField(new String[]{"items.wardrobe_inventory", "items.armor", "items.inventory", "items.enderchest", "items.personal_vault", "items.storage"}, "SUPERIOR_DRAGON_HELMET", 2),
            new ItemField(new String[]{"items.wardrobe_inventory", "items.armor", "items.inventory", "items.enderchest", "items.personal_vault", "items.storage"}, "SUPERIOR_DRAGON_CHESTPLATE", 3),
            new ItemField(new String[]{"items.wardrobe_inventory", "items.armor", "items.inventory", "items.enderchest", "items.personal_vault", "items.storage"}, "SUPERIOR_DRAGON_LEGGINGS", 2),
            new ItemField(new String[]{"items.wardrobe_inventory", "items.armor", "items.inventory", "items.enderchest", "items.personal_vault", "items.storage"}, "SUPERIOR_DRAGON_BOOTS", 2),
            new ItemField(new String[]{"items.wardrobe_inventory", "items.armor", "items.inventory", "items.enderchest", "items.personal_vault", "items.storage"}, "ELEGANT_TUXEDO_CHESTPLATE", 10),
            new ItemField(new String[]{"items.wardrobe_inventory", "items.armor", "items.inventory", "items.enderchest", "items.personal_vault", "items.storage"}, "ELEGANT_TUXEDO_LEGGINGS", 3),
            new ItemField(new String[]{"items.wardrobe_inventory", "items.armor", "items.inventory", "items.enderchest", "items.personal_vault", "items.storage"}, "ELEGANT_TUXEDO_BOOTS", 2),
            new ItemField("items.weapons", "STARRED_SHADOW_FURY", 8),
            new ItemField("items.weapons", "SHADOW_FURY", 8),
            new ItemField(new String[]{"items.wardrobe_inventory", "items.armor", "items.inventory", "items.enderchest", "items.personal_vault", "items.storage"}, "STARRED_SHADOW_ASSASSIN_HELMET", 2),
            new ItemField(new String[]{"items.wardrobe_inventory", "items.armor", "items.inventory", "items.enderchest", "items.personal_vault", "items.storage"}, "STARRED_SHADOW_ASSASSIN_CHESTPLATE", 7),
            new ItemField(new String[]{"items.wardrobe_inventory", "items.armor", "items.inventory", "items.enderchest", "items.personal_vault", "items.storage"}, "STARRED_SHADOW_ASSASSIN_LEGGINGS", 3),
            new ItemField(new String[]{"items.wardrobe_inventory", "items.armor", "items.inventory", "items.enderchest", "items.personal_vault", "items.storage"}, "STARRED_SHADOW_ASSASSIN_BOOTS", 2),
            new ItemField(new String[]{"items.wardrobe_inventory", "items.armor", "items.inventory", "items.enderchest", "items.personal_vault", "items.storage"}, "FROZEN_BLAZE_HELMET", 7),
            new ItemField(new String[]{"items.wardrobe_inventory", "items.armor", "items.inventory", "items.enderchest", "items.personal_vault", "items.storage"}, "FROZEN_BLAZE_CHESTPLATE", 10),
            new ItemField(new String[]{"items.wardrobe_inventory", "items.armor", "items.inventory", "items.enderchest", "items.personal_vault", "items.storage"}, "FROZEN_BLAZE_LEGGINGS", 8),
            new ItemField(new String[]{"items.wardrobe_inventory", "items.armor", "items.inventory", "items.enderchest", "items.personal_vault", "items.storage"}, "FROZEN_BLAZE_BOOTS", 6),
            new ItemField(new String[]{"items.wardrobe_inventory", "items.armor", "items.inventory", "items.enderchest", "items.personal_vault", "items.storage"}, "TARANTULA_HELMET", 1),
            new ItemField("items.weapons", "ICE_SPRAY_WAND", 15),
            new ItemField("items.mining_tools", "GEMSTONE_DRILL_4", 9),
            new ItemField("items.farming_tools", "THEORETICAL_HOE_WHEAT_3", 15),
            new ItemField("items.farming_tools", "THEORETICAL_HOE_WARTS_3", 8),
            new ItemField("items.farming_tools", "THEORETICAL_HOE_CANE_3", 7),
            new ItemField("items.farming_tools", "THEORETICAL_HOE_CARROT_3", 7),
            new ItemField("items.farming_tools", "THEORETICAL_HOE_POTATO_3", 7),
            new ItemField(new String[]{"items.inventory", "items.enderchest", "items.personal_vault", "items.storage"}, "PLASMAFLUX_POWER_ORB", 26),
            new ItemField(new String[]{"items.inventory", "items.enderchest", "items.personal_vault", "items.storage"}, "OVERFLUX_POWER_ORB", 18),
            new ItemField("items.weapons", "NECROMANCER_SWORD", 6),
            new ItemField(new String[]{"items.inventory", "items.enderchest", "items.personal_vault", "items.storage"}, "SUMMONING_RING", 6),
            new ItemField(new String[]{"items.wardrobe_inventory", "items.armor", "items.inventory", "items.enderchest", "items.personal_vault", "items.storage"}, "NECROMANCER_LORD_HELMET", 2),
            new ItemField(new String[]{"items.wardrobe_inventory", "items.armor", "items.inventory", "items.enderchest", "items.personal_vault", "items.storage"}, "NECROMANCER_LORD_CHESTPLATE", 7),
            new ItemField(new String[]{"items.wardrobe_inventory", "items.armor", "items.inventory", "items.enderchest", "items.personal_vault", "items.storage"}, "NECROMANCER_LORD_LEGGINGS", 3),
            new ItemField(new String[]{"items.wardrobe_inventory", "items.armor", "items.inventory", "items.enderchest", "items.personal_vault", "items.storage"}, "NECROMANCER_LORD_BOOTS", 2),
            new ItemField("items.weapons", "WITHER_CLOAK", 2),
            new ItemField("items.fishing_tools", "ROD_OF_LEGENDS", 3),
            new ItemField("items.weapons", "REAPER_SCYTHE", 6),
            new ItemField(new String[]{"items.inventory", "items.enderchest", "items.personal_vault", "items.storage"}, "SUMMONING_RING", 7),
            new ItemField(new String[]{"items.inventory", "items.enderchest", "items.personal_vault", "items.storage"}, "GYROKINETIC_WAND", 15),
            new ItemField("items.weapons", "BONEMERANG", 2),
            new ItemField("items.weapons", "BAT_WAND", 5),
            new ItemField(new String[]{"items.inventory", "items.enderchest", "items.personal_vault", "items.storage"}, "GLOOMLOCK_GRIMOIRE", 4),
            new ItemField("items.weapons", "BONZO_STAFF", 2),
            new ItemField("items.weapons", "STARRED_BONZO_STAFF", 2),
            new ItemField("items.weapons", "LAST_BREATH", 6),
            new ItemField("items.weapons", "STARRED_LAST_BREATH", 6),
            new ItemField("items.weapons", "FROZEN_SCYTHE", 6),
            new ItemField("items.fishing_tools", "PHANTOM_ROD", 2),
            new ItemField("items.weapons", "RUNAANS_BOW", 1),
            new ItemField(new String[]{"items.inventory", "items.enderchest", "items.personal_vault", "items.storage"}, "VOODOO_DOLL", 2),
            new ItemField("items.weapons", "SOULS_REBOUND", 2),
            new ItemField(new String[]{"items.wardrobe_inventory", "items.armor", "items.inventory", "items.enderchest", "items.personal_vault", "items.storage"}, "BAT_PERSON_HELMET", 1),
            new ItemField(new String[]{"items.wardrobe_inventory", "items.armor", "items.inventory", "items.enderchest", "items.personal_vault", "items.storage"}, "BAT_PERSON_CHESTPLATE", 1),
            new ItemField(new String[]{"items.wardrobe_inventory", "items.armor", "items.inventory", "items.enderchest", "items.personal_vault", "items.storage"}, "BAT_PERSON_LEGGINGS", 1),
            new ItemField(new String[]{"items.wardrobe_inventory", "items.armor", "items.inventory", "items.enderchest", "items.personal_vault", "items.storage"}, "BAT_PERSON_BOOTS", 1),
            new ItemField(new String[]{"items.wardrobe_inventory", "items.armor", "items.inventory", "items.enderchest", "items.personal_vault", "items.storage"}, "MASTIFF_HELMET", 1),
            new ItemField(new String[]{"items.wardrobe_inventory", "items.armor", "items.inventory", "items.enderchest", "items.personal_vault", "items.storage"}, "MASTIFF_CHESTPLATE", 1),
            new ItemField(new String[]{"items.wardrobe_inventory", "items.armor", "items.inventory", "items.enderchest", "items.personal_vault", "items.storage"}, "MASTIFF_LEGGINGS", 1),
            new ItemField(new String[]{"items.wardrobe_inventory", "items.armor", "items.inventory", "items.enderchest", "items.personal_vault", "items.storage"}, "MASTIFF_BOOTS", 1),
            new ItemField(new String[]{"items.wardrobe_inventory", "items.armor", "items.inventory", "items.enderchest", "items.personal_vault", "items.storage"}, "DCTR_SPACE_HELM", 1),
            new ItemField("items.talismans", "MASTER_SKULL_TIER_7", 4),
            new ItemField("items.talismans", "JERRY_TALISMAN_GOLDEN", 3),
            new ItemField("items.talismans", "HEGEMONY_ARTIFACT", 3),
            new ItemField("items.talismans", "PERSONAL_COMPACTOR_7000", 1),
            new ItemField("items.talismans", "CATACOMBS_EXPERT_RING", 2),
            new ItemField("items.talismans", "AUTO_RECOMBOBULATOR", 2),
            new ItemField("items.talismans", "TREASURE_ARTIFACT", 3),
            new ItemField("items.talismans", "SEAL_OF_THE_FAMILY", 3),
            new ItemField("items.talismans", "ENDER_RELIC", 3),
            new ItemField("items.talismans", "HUNTER_RING", 2),
            new ItemField("items.talismans", "SOULFLOW_SUPERCELL", 2),
            new ItemField("items.talismans", "SPIKED_ATROCITY", 1),

    });

    //ADD NEW SKILL
    public FieldCollection skills = new FieldCollection(new IField[] {
            taming,
            farming,
            mining,
            combat,
            foraging,
            fishing,
            enchanting,
            alchemy,
    });

    //ADD NEW SLAYER
    public FieldCollection slayers = new FieldCollection(new IField[] {
            zombie,
            spider,
            wolf,
            enderman,
    });

    //ADD NEW FIELD
    public FieldCollection fields = new FieldCollection(new IField[] {
            catacombs,
            gemstonePowder,
            mithrilPowder,
            minionSlots,
            talismans,
            petScore,
            skills,
            slayers,
            items,
            pets,
    });

    //ADD SIMPLE FIELDS (DIRECTLY DERIVED FROM DATABASE)
    public SimpleField<?>[] simpleFields = new SimpleField[] {
            catacombs,
            gemstonePowder,
            mithrilPowder,
            minionSlots,
            talismans,
            petScore,
            taming,
            farming,
            mining,
            combat,
            foraging,
            fishing,
            enchanting,
            alchemy,
            zombie,
            spider,
            wolf,
            enderman,
    };

    //FACE FIELDS
    public ScaledField faceTaming = new ScaledField(taming, 8);
    public ScaledField faceFarming = new ScaledField(farming, 9);
    public ScaledField faceMining = new ScaledField(mining, 8);
    public TransformedField faceCombat = new TransformedField(combat, (input -> Math.pow(input, 1.8) / 16));
    public ScaledField faceForaging = new ScaledField(foraging, 12);
    public ScaledField faceFishing = new ScaledField(fishing, 9);
    public ScaledField faceEnchanting = new ScaledField(enchanting, 8);
    public ScaledField faceAlchemy = new ScaledField(alchemy, 9);

    public FieldCollection faceSkills = new FieldCollection(new IField[] {
            faceTaming,
            faceFarming,
            faceMining,
            faceCombat,
            faceForaging,
            faceFishing,
            faceEnchanting,
            faceAlchemy,
    });

    public ScaledField faceZombie = new ScaledField(zombie, 9);
    public ScaledField faceSpider = new ScaledField(spider, 12);
    public ScaledField faceWolf = new ScaledField(wolf, 14);
    public ScaledField faceEnderman = new ScaledField(enderman, 9);

    public FieldCollection faceSlayers = new FieldCollection(new IField[] {
            faceZombie,
            faceSpider,
            faceWolf,
            faceEnderman,
    });

    public ScaledField faceCatacombs = new ScaledField(catacombs, 7);

    public FieldCollection faceFields = new FieldCollection(new IField[] {
            faceCatacombs,
            faceSkills,
            faceSlayers,
    });
}