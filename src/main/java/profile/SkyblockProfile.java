package profile;

import fields.*;

public class SkyblockProfile {

    public String playerName;
    public String profileName;

    //ADD NEW FIELD
    public CatacombsField catacombs = new CatacombsField("data.dungeons.catacombs.level.xp");
    public GemstonePowderField gemstonePowder = new GemstonePowderField("data.mining.core.powder.gemstone.total");
    public MithrilPowderField mithrilPowder = new MithrilPowderField("data.mining.core.powder.mithril.total");
    public MinionSlotsField minionSlots = new MinionSlotsField("data.minion_slots.currentSlots");
    public MissingTalismansField missingTalismans = new MissingTalismansField("data.missingTalismans.missing");
    public MissingTalismanUpgradesField missingTalismanUpgrades = new MissingTalismanUpgradesField("data.missingTalismans.upgrades");
    public PetScoreField petScore = new PetScoreField("data.petScore");
    public SkillField taming = new SkillField("data.levels.taming.xp", 2);
    public SkillField farming = new SkillField("data.levels.farming.xp", 9);
    public SkillField mining = new SkillField("data.levels.mining.xp", 9);
    public SkillField combat = new SkillField("data.levels.combat.xp", 10);
    public SkillField foraging = new SkillField("data.levels.foraging.xp", 7);
    public SkillField fishing = new SkillField("data.levels.fishing.xp", 11);
    public SkillField enchanting = new SkillField("data.levels.enchanting.xp", 2);
    public SkillField alchemy = new SkillField("data.levels.alchemy.xp", 3);
    public SlayerField zombie = new SlayerField("data.slayers.zombie.level.xp", 12);
    public SlayerField spider = new SlayerField("data.slayers.spider.level.xp", 16);
    public SlayerField wolf = new SlayerField("data.slayers.wolf.level.xp", 20);
    public SlayerField enderman = new SlayerField("data.slayers.enderman.level.xp", 40);

    //ADD NEW PET FIELD
    public PetField[] pets = {
            new PetField("data.pets", "SCATHA", new double[]{0,0,30,35,40,0}),
            new PetField("data.pets", "BAL", new double[]{0,0,0,20,25,0}),
            new PetField("data.pets", "PHOENIX", new double[]{0,0,0,1,2,0}),
            new PetField("data.pets", "GOLDEN_DRAGON", new double[]{0,0,0,0,60,0}),
            new PetField("data.pets", "ENDER_DRAGON", new double[]{0,0,0,50,55,0}),
            new PetField("data.pets", "SNOWMAN", new double[]{0,0,0,0,5,0}),
            new PetField("data.pets", "SPIRIT", new double[]{0,0,0,0,5,0}),
            new PetField("data.pets", "GRIFFIN", new double[]{0,0,0,0,25,0}),
            new PetField("data.pets", "ELEPHANT", new double[]{0,0,0,0,5,0}),
            new PetField("data.pets", "MONKEY", new double[]{0,0,0,0,5,0}),
            new PetField("data.pets", "ENDERMAN", new double[]{0,0,0,0,15,16}),
            new PetField("data.pets", "BLUE_WHALE", new double[]{0,0,0,0,15,0}),
            new PetField("data.pets", "BABY_YETI", new double[]{0,0,0,20,20,0}),
            new PetField("data.pets", "BLACK_CAT", new double[]{0,0,0,0,10,0}),
            new PetField("data.pets", "LION", new double[]{0,0,0,0,5,0}),
            new PetField("data.pets", "BLAZE", new double[]{0,0,0,25,35,0}),
            new PetField("data.pets", "TIGER", new double[]{0,0,0,0,5,0}),
            new PetField("data.pets", "AMMONITE", new double[]{0,0,0,0,5,0}),
            new PetField("data.pets", "SQUID", new double[]{0,0,0,0,10,0}),
            new PetField("data.pets", "WOLF", new double[]{0,0,0,0,5,0}),
            new PetField("data.pets", "WITHER_SKELETON", new double[]{0,0,0,0,5,0}),
    };

    //ADD NEW ITEM FIELD
    public ItemField[] items = {
            new ItemField("items.weapons", "ASPECT_OF_THE_END", 1),
            new ItemField("items.weapons", "ASPECT_OF_THE_VOID", 10),
            new ItemField(new String[]{"items.wardrobe_inventory", "items.armor", "items.inventory", "items.enderchest", "items.personal_vault", "items.storage"}, "POWER_WITHER_HELMET", 5),
            new ItemField(new String[]{"items.wardrobe_inventory", "items.armor", "items.inventory", "items.enderchest", "items.personal_vault", "items.storage"}, "POWER_WITHER_CHESTPLATE", 25),
            new ItemField(new String[]{"items.wardrobe_inventory", "items.armor", "items.inventory", "items.enderchest", "items.personal_vault", "items.storage"}, "POWER_WITHER_LEGGINGS", 15),
            new ItemField(new String[]{"items.wardrobe_inventory", "items.armor", "items.inventory", "items.enderchest", "items.personal_vault", "items.storage"}, "POWER_WITHER_BOOTS", 5),
            new ItemField(new String[]{"items.wardrobe_inventory", "items.armor", "items.inventory", "items.enderchest", "items.personal_vault", "items.storage"}, "SHARK_SCALE_HELMET", 2),
            new ItemField(new String[]{"items.wardrobe_inventory", "items.armor", "items.inventory", "items.enderchest", "items.personal_vault", "items.storage"}, "SHARK_SCALE_CHESTPLATE", 3),
            new ItemField(new String[]{"items.wardrobe_inventory", "items.armor", "items.inventory", "items.enderchest", "items.personal_vault", "items.storage"}, "SHARK_SCALE_LEGGINGS", 3),
            new ItemField(new String[]{"items.wardrobe_inventory", "items.armor", "items.inventory", "items.enderchest", "items.personal_vault", "items.storage"}, "SHARK_SCALE_BOOTS", 2),
            new ItemField(new String[]{"items.wardrobe_inventory", "items.armor", "items.inventory", "items.enderchest", "items.personal_vault", "items.storage"}, "WISE_WITHER_HELMET", 5),
            new ItemField(new String[]{"items.wardrobe_inventory", "items.armor", "items.inventory", "items.enderchest", "items.personal_vault", "items.storage"}, "WISE_WITHER_CHESTPLATE", 25),
            new ItemField(new String[]{"items.wardrobe_inventory", "items.armor", "items.inventory", "items.enderchest", "items.personal_vault", "items.storage"}, "WISE_WITHER_LEGGINGS", 15),
            new ItemField(new String[]{"items.wardrobe_inventory", "items.armor", "items.inventory", "items.enderchest", "items.personal_vault", "items.storage"}, "WISE_WITHER_BOOTS", 5),
            new ItemField(new String[]{"items.wardrobe_inventory", "items.armor", "items.inventory", "items.enderchest", "items.personal_vault", "items.storage"}, "WARDEN_HELMET", 40),
            new ItemField(new String[]{"items.wardrobe_inventory", "items.armor", "items.inventory", "items.enderchest", "items.personal_vault", "items.storage"}, "WITHER_GOGGLES", 5),
            new ItemField(new String[]{"items.wardrobe_inventory", "items.armor", "items.inventory", "items.enderchest", "items.personal_vault", "items.storage"}, "TANK_WITHER_HELMET", 5),
            new ItemField(new String[]{"items.wardrobe_inventory", "items.armor", "items.inventory", "items.enderchest", "items.personal_vault", "items.storage"}, "TANK_WITHER_CHESTPLATE", 25),
            new ItemField(new String[]{"items.wardrobe_inventory", "items.armor", "items.inventory", "items.enderchest", "items.personal_vault", "items.storage"}, "TANK_WITHER_LEGGINGS", 15),
            new ItemField(new String[]{"items.wardrobe_inventory", "items.armor", "items.inventory", "items.enderchest", "items.personal_vault", "items.storage"}, "TANK_WITHER_BOOTS", 5),
            new ItemField(new String[]{"items.wardrobe_inventory", "items.armor", "items.inventory", "items.enderchest", "items.personal_vault", "items.storage"}, "SPEED_WITHER_HELMET", 5),
            new ItemField(new String[]{"items.wardrobe_inventory", "items.armor", "items.inventory", "items.enderchest", "items.personal_vault", "items.storage"}, "SPEED_WITHER_CHESTPLATE", 25),
            new ItemField(new String[]{"items.wardrobe_inventory", "items.armor", "items.inventory", "items.enderchest", "items.personal_vault", "items.storage"}, "SPEED_WITHER_LEGGINGS", 15),
            new ItemField(new String[]{"items.wardrobe_inventory", "items.armor", "items.inventory", "items.enderchest", "items.personal_vault", "items.storage"}, "SPEED_WITHER_BOOTS", 5),
            new ItemField("items.weapons", "AXE_OF_THE_SHREDDED", 30),
            new ItemField("items.weapons", "SOUL_WHIP", 20),
            new ItemField("items.weapons", "GIANTS_SWORD", 50),
            new ItemField(new String[]{"items.wardrobe_inventory", "items.armor", "items.inventory", "items.enderchest", "items.personal_vault", "items.storage"}, "DIAMOND_BONZO_HEAD", 30),
            new ItemField(new String[]{"items.wardrobe_inventory", "items.armor", "items.inventory", "items.enderchest", "items.personal_vault", "items.storage"}, "DIAMOND_SCARF_HEAD", 30),
            new ItemField(new String[]{"items.wardrobe_inventory", "items.armor", "items.inventory", "items.enderchest", "items.personal_vault", "items.storage"}, "DIAMOND_PROFESSOR_HEAD", 30),
            new ItemField(new String[]{"items.wardrobe_inventory", "items.armor", "items.inventory", "items.enderchest", "items.personal_vault", "items.storage"}, "DIAMOND_THORN_HEAD", 30),
            new ItemField(new String[]{"items.wardrobe_inventory", "items.armor", "items.inventory", "items.enderchest", "items.personal_vault", "items.storage"}, "DIAMOND_LIVID_HEAD", 30),
            new ItemField(new String[]{"items.wardrobe_inventory", "items.armor", "items.inventory", "items.enderchest", "items.personal_vault", "items.storage"}, "DIAMOND_SADAN_HEAD", 30),
            new ItemField(new String[]{"items.wardrobe_inventory", "items.armor", "items.inventory", "items.enderchest", "items.personal_vault", "items.storage"}, "DIAMOND_NECRON_HEAD", 30),
            new ItemField(new String[]{"items.wardrobe_inventory", "items.armor", "items.inventory", "items.enderchest", "items.personal_vault", "items.storage"}, "GOLD_BONZO_HEAD", 15),
            new ItemField(new String[]{"items.wardrobe_inventory", "items.armor", "items.inventory", "items.enderchest", "items.personal_vault", "items.storage"}, "GOLD_SCARF_HEAD", 15),
            new ItemField(new String[]{"items.wardrobe_inventory", "items.armor", "items.inventory", "items.enderchest", "items.personal_vault", "items.storage"}, "GOLD_PROFESSOR_HEAD", 15),
            new ItemField(new String[]{"items.wardrobe_inventory", "items.armor", "items.inventory", "items.enderchest", "items.personal_vault", "items.storage"}, "GOLD_THORN_HEAD", 15),
            new ItemField(new String[]{"items.wardrobe_inventory", "items.armor", "items.inventory", "items.enderchest", "items.personal_vault", "items.storage"}, "GOLD_LIVID_HEAD", 15),
            new ItemField(new String[]{"items.wardrobe_inventory", "items.armor", "items.inventory", "items.enderchest", "items.personal_vault", "items.storage"}, "GOLD_SADAN_HEAD", 15),
            new ItemField(new String[]{"items.wardrobe_inventory", "items.armor", "items.inventory", "items.enderchest", "items.personal_vault", "items.storage"}, "GOLD_NECRON_HEAD", 15),
            new ItemField("items.weapons", "SCYLLA", 60),
            new ItemField("items.weapons", "HYPERION", 60),
            new ItemField("items.weapons", "VALKYRIE", 60),
            new ItemField("items.weapons", "ASTRAEA", 60),
            new ItemField(new String[]{"items.wardrobe_inventory", "items.armor", "items.inventory", "items.enderchest", "items.personal_vault", "items.storage"}, "SORROW_HELMET", 2),
            new ItemField(new String[]{"items.wardrobe_inventory", "items.armor", "items.inventory", "items.enderchest", "items.personal_vault", "items.storage"}, "SORROW_CHESTPLATE", 3),
            new ItemField(new String[]{"items.wardrobe_inventory", "items.armor", "items.inventory", "items.enderchest", "items.personal_vault", "items.storage"}, "SORROW_LEGGINGS", 3),
            new ItemField(new String[]{"items.wardrobe_inventory", "items.armor", "items.inventory", "items.enderchest", "items.personal_vault", "items.storage"}, "SORROW_BOOTS", 2),
            new ItemField(new String[]{"items.wardrobe_inventory", "items.armor", "items.inventory", "items.enderchest", "items.personal_vault", "items.storage"}, "DIVAN_HELMET", 5),
            new ItemField(new String[]{"items.wardrobe_inventory", "items.armor", "items.inventory", "items.enderchest", "items.personal_vault", "items.storage"}, "DIVAN_CHESTPLATE", 5),
            new ItemField(new String[]{"items.wardrobe_inventory", "items.armor", "items.inventory", "items.enderchest", "items.personal_vault", "items.storage"}, "DIVAN_LEGGINGS", 5),
            new ItemField(new String[]{"items.wardrobe_inventory", "items.armor", "items.inventory", "items.enderchest", "items.personal_vault", "items.storage"}, "DIVAN_BOOTS", 5),
            new ItemField("items.weapons", "SWORD_OF_REVELATIONS", 8),
            new ItemField("items.weapons", "TERMINATOR", 60),
            new ItemField("items.weapons", "JUJU_SHORTBOW", 30),
            new ItemField("items.weapons", "ATOMSPLIT_KATANA", 35),
            new ItemField("items.weapons", "VORPAL_KATANA", 25),
            new ItemField("items.weapons", "FLOWER_OF_TRUTH", 5),
            new ItemField("items.weapons", "LIVID_DAGGER", 5),
            new ItemField(new String[]{"items.wardrobe_inventory", "items.armor", "items.inventory", "items.enderchest", "items.personal_vault", "items.storage"}, "SHADOW_ASSASSIN_HELMET", 2),
            new ItemField(new String[]{"items.wardrobe_inventory", "items.armor", "items.inventory", "items.enderchest", "items.personal_vault", "items.storage"}, "SHADOW_ASSASSIN_CHESTPLATE", 5),
            new ItemField(new String[]{"items.wardrobe_inventory", "items.armor", "items.inventory", "items.enderchest", "items.personal_vault", "items.storage"}, "SHADOW_ASSASSIN_LEGGINGS", 3),
            new ItemField(new String[]{"items.wardrobe_inventory", "items.armor", "items.inventory", "items.enderchest", "items.personal_vault", "items.storage"}, "SHADOW_ASSASSIN_BOOTS", 2),
            new ItemField(new String[]{"items.wardrobe_inventory", "items.armor", "items.inventory", "items.enderchest", "items.personal_vault", "items.storage"}, "FINAL_DESTINATION_HELMET", 5),
            new ItemField(new String[]{"items.wardrobe_inventory", "items.armor", "items.inventory", "items.enderchest", "items.personal_vault", "items.storage"}, "FINAL_DESTINATION_CHESTPLATE", 5),
            new ItemField(new String[]{"items.wardrobe_inventory", "items.armor", "items.inventory", "items.enderchest", "items.personal_vault", "items.storage"}, "FINAL_DESTINATION_LEGGINGS", 5),
            new ItemField(new String[]{"items.wardrobe_inventory", "items.armor", "items.inventory", "items.enderchest", "items.personal_vault", "items.storage"}, "FINAL_DESTINATION_BOOTS", 5),
            new ItemField(new String[]{"items.wardrobe_inventory", "items.armor", "items.inventory", "items.enderchest", "items.personal_vault", "items.storage"}, "PRECURSOR_EYE", 40),
            new ItemField(new String[]{"items.wardrobe_inventory", "items.armor", "items.inventory", "items.enderchest", "items.personal_vault", "items.storage"}, "REAPER_MASK", 10),
            new ItemField("items.pickaxes", "TITANIUM_DRILL_4", 45),
            new ItemField("items.pickaxes", "TITANIUM_DRILL_3", 35),
            new ItemField("items.pickaxes", "TITANIUM_DRILL_2", 25),
            new ItemField("items.pickaxes", "TITANIUM_DRILL_1", 15),
            new ItemField("items.pickaxes", "DIVAN_DRILL", 60),
            new ItemField("items.weapons", "DEADALUS_AXE", 30),
            new ItemField(new String[]{"items.wardrobe_inventory", "items.armor", "items.inventory", "items.enderchest", "items.personal_vault", "items.storage"}, "RANCHER_BOOTS", 3),
            new ItemField("items.pickaxes", "GEMSTONE_GAUNTLET", 20),
            new ItemField(new String[]{"items.wardrobe_inventory", "items.armor", "items.inventory", "items.enderchest", "items.personal_vault", "items.storage"}, "WITHER_HELMET", 5),
            new ItemField(new String[]{"items.wardrobe_inventory", "items.armor", "items.inventory", "items.enderchest", "items.personal_vault", "items.storage"}, "WITHER_CHESTPLATE", 25),
            new ItemField(new String[]{"items.wardrobe_inventory", "items.armor", "items.inventory", "items.enderchest", "items.personal_vault", "items.storage"}, "WITHER_LEGGINGS", 15),
            new ItemField(new String[]{"items.wardrobe_inventory", "items.armor", "items.inventory", "items.enderchest", "items.personal_vault", "items.storage"}, "WITHER_BOOTS", 5),
            new ItemField("items.weapons", "MIDAS_STAFF", 3),
            new ItemField("items.rods", "ROD_OF_THE_SEA", 5),
            new ItemField("items.rods", "AUGER_ROD", 10),
            new ItemField(new String[]{"items.wardrobe_inventory", "items.armor", "items.inventory", "items.enderchest", "items.personal_vault", "items.storage"}, "YOUNG_DRAGON_HELMET", 1),
            new ItemField(new String[]{"items.wardrobe_inventory", "items.armor", "items.inventory", "items.enderchest", "items.personal_vault", "items.storage"}, "YOUNG_DRAGON_CHESTPLATE", 1),
            new ItemField(new String[]{"items.wardrobe_inventory", "items.armor", "items.inventory", "items.enderchest", "items.personal_vault", "items.storage"}, "YOUNG_DRAGON_LEGGINGS", 1),
            new ItemField(new String[]{"items.wardrobe_inventory", "items.armor", "items.inventory", "items.enderchest", "items.personal_vault", "items.storage"}, "YOUNG_DRAGON_BOOTS", 1),
            new ItemField(new String[]{"items.wardrobe_inventory", "items.armor", "items.inventory", "items.enderchest", "items.personal_vault", "items.storage"}, "SUPERIOR_DRAGON_HELMET", 3),
            new ItemField(new String[]{"items.wardrobe_inventory", "items.armor", "items.inventory", "items.enderchest", "items.personal_vault", "items.storage"}, "SUPERIOR_DRAGON_CHESTPLATE", 5),
            new ItemField(new String[]{"items.wardrobe_inventory", "items.armor", "items.inventory", "items.enderchest", "items.personal_vault", "items.storage"}, "SUPERIOR_DRAGON_LEGGINGS", 4),
            new ItemField(new String[]{"items.wardrobe_inventory", "items.armor", "items.inventory", "items.enderchest", "items.personal_vault", "items.storage"}, "SUPERIOR_DRAGON_BOOTS", 3),
            new ItemField(new String[]{"items.wardrobe_inventory", "items.armor", "items.inventory", "items.enderchest", "items.personal_vault", "items.storage"}, "ELEGANT_TUXEDO_CHESTPLATE", 5),
            new ItemField(new String[]{"items.wardrobe_inventory", "items.armor", "items.inventory", "items.enderchest", "items.personal_vault", "items.storage"}, "ELEGANT_TUXEDO_LEGGINGS", 5),
            new ItemField(new String[]{"items.wardrobe_inventory", "items.armor", "items.inventory", "items.enderchest", "items.personal_vault", "items.storage"}, "ELEGANT_TUXEDO_BOOTS", 5),
            new ItemField("items.weapons", "STARRED_SHADOW_FURY", 8),
            new ItemField("items.weapons", "SHADOW_FURY", 8),
            new ItemField(new String[]{"items.wardrobe_inventory", "items.armor", "items.inventory", "items.enderchest", "items.personal_vault", "items.storage"}, "STARRED_SHADOW_ASSASSIN_HELMET", 2),
            new ItemField(new String[]{"items.wardrobe_inventory", "items.armor", "items.inventory", "items.enderchest", "items.personal_vault", "items.storage"}, "STARRED_SHADOW_ASSASSIN_CHESTPLATE", 5),
            new ItemField(new String[]{"items.wardrobe_inventory", "items.armor", "items.inventory", "items.enderchest", "items.personal_vault", "items.storage"}, "STARRED_SHADOW_ASSASSIN_LEGGINGS", 3),
            new ItemField(new String[]{"items.wardrobe_inventory", "items.armor", "items.inventory", "items.enderchest", "items.personal_vault", "items.storage"}, "STARRED_SHADOW_ASSASSIN_BOOTS", 2),
            new ItemField(new String[]{"items.wardrobe_inventory", "items.armor", "items.inventory", "items.enderchest", "items.personal_vault", "items.storage"}, "FROZEN_BLAZE_HELMET", 15),
            new ItemField(new String[]{"items.wardrobe_inventory", "items.armor", "items.inventory", "items.enderchest", "items.personal_vault", "items.storage"}, "FROZEN_BLAZE_CHESTPLATE", 20),
            new ItemField(new String[]{"items.wardrobe_inventory", "items.armor", "items.inventory", "items.enderchest", "items.personal_vault", "items.storage"}, "FROZEN_BLAZE_LEGGINGS", 15),
            new ItemField(new String[]{"items.wardrobe_inventory", "items.armor", "items.inventory", "items.enderchest", "items.personal_vault", "items.storage"}, "FROZEN_BLAZE_BOOTS", 10),
            new ItemField(new String[]{"items.wardrobe_inventory", "items.armor", "items.inventory", "items.enderchest", "items.personal_vault", "items.storage"}, "TARANTULA_HELMET", 2),
            new ItemField("items.weapons", "ICE_SPRAY_WAND", 7),
            new ItemField("items.pickaxes", "GEMSTONE_DRILL_4", 25),
            new ItemField("items.hoes", "THEORETICAL_HOE_WHEAT_3", 5),
            new ItemField("items.hoes", "THEORETICAL_HOE_WARTS_3", 5),
            new ItemField("items.hoes", "THEORETICAL_HOE_CANE_3", 5),
            new ItemField("items.hoes", "THEORETICAL_HOE_CARROT_3", 5),
            new ItemField("items.hoes", "THEORETICAL_HOE_POTATO_3", 5),
            new ItemField(new String[]{"items.inventory", "items.enderchest", "items.personal_vault", "items.storage"}, "PLASMAFLUX_POWER_ORB", 50),
            new ItemField(new String[]{"items.inventory", "items.enderchest", "items.personal_vault", "items.storage"}, "OVERFLUX_POWER_ORB", 35),
            new ItemField("items.weapons", "NECROMANCER_SWORD", 10),
            new ItemField(new String[]{"items.inventory", "items.enderchest", "items.personal_vault", "items.storage"}, "SUMMONING_RING", 8),
            new ItemField(new String[]{"items.wardrobe_inventory", "items.armor", "items.inventory", "items.enderchest", "items.personal_vault", "items.storage"}, "NECROMANCER_LORD_HELMET", 2),
            new ItemField(new String[]{"items.wardrobe_inventory", "items.armor", "items.inventory", "items.enderchest", "items.personal_vault", "items.storage"}, "NECROMANCER_LORD_CHESTPLATE", 5),
            new ItemField(new String[]{"items.wardrobe_inventory", "items.armor", "items.inventory", "items.enderchest", "items.personal_vault", "items.storage"}, "NECROMANCER_LORD_LEGGINGS", 3),
            new ItemField(new String[]{"items.wardrobe_inventory", "items.armor", "items.inventory", "items.enderchest", "items.personal_vault", "items.storage"}, "NECROMANCER_LORD_BOOTS", 2),
            new ItemField("items.weapons", "WITHER_CLOAK", 5),
            new ItemField("items.rods", "ROD_OF_LEGENDS", 3),
    };

    //ADD NEW FIELD
    public Field<?>[] getFields() {
        return new Field[]{catacombs, gemstonePowder, mithrilPowder, minionSlots, missingTalismans,
                missingTalismanUpgrades, petScore, taming, farming, mining, combat, foraging, fishing, enchanting,
                alchemy, zombie, spider, wolf, enderman};
    }

    public PetField[] getPetFields() {
        return pets;
    }

    public double getPetsWeight() {
        double total = 0;
        for(PetField petField : getPetFields()) {
            total += petField.getWeight();
        }
        return total;
    }

    public ItemField[] getItemFields() {
        return items;
    }

    public double getItemsWeight() {
        double total = 0;
        for(ItemField itemField : getItemFields()) {
            total += itemField.getWeight();
        }
        return total;
    }

    public double getSkillsWeight() {
        double total = 0;
        Field<?>[] skillFields = new Field[]{taming, farming, mining, combat, foraging, fishing, enchanting, alchemy};
        for(Field<?> skill : skillFields) {
            total += skill.getWeight();
        }
        return total;
    }

    public double getSlayersWeight() {
        double total = 0;
        Field<?>[] slayerFields = new Field[]{zombie, spider, wolf, enderman};
        for(Field<?> slayer : slayerFields) {
            total += slayer.getWeight();
        }
        return total;
    }

    public double getTotalWeight() {
        double total = 0;
        for(Field<?> field : getFields()) {
            total += field.getWeight();
        }
        total += getItemsWeight();
        total += getPetsWeight();
        return total;
    }

}