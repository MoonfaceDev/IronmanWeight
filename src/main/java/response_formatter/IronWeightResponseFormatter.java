package response_formatter;

import profile.SkyblockProfile;

import java.text.DecimalFormat;

public class IronWeightResponseFormatter implements IResponseFormatter {

    private static final DecimalFormat weightFormat = new DecimalFormat("0.00");

    @Override
    public String format(SkyblockProfile profile) {
        double weight = profile.fields.getWeight();
        return ":pick: " + profile.playerName + " | " + profile.profileName + " " + getGameModeEmoji(profile.gameMode) +
                "\n**Total Weight:** " + weightFormat.format(weight) + "\n" +
                "\n**Skills:** " + weightFormat.format(profile.skills.getWeight()) +
                "\n - Taming: " + weightFormat.format(profile.taming.getWeight()) +
                "\n - Farming: " + weightFormat.format(profile.farming.getWeight()) +
                "\n - Mining: " + weightFormat.format(profile.mining.getWeight()) +
                "\n - Combat: " + weightFormat.format(profile.combat.getWeight()) +
                "\n - Foraging: " + weightFormat.format(profile.foraging.getWeight()) +
                "\n - Fishing: " + weightFormat.format(profile.fishing.getWeight()) +
                "\n - Enchanting: " + weightFormat.format(profile.enchanting.getWeight()) +
                "\n - Alchemy: " + weightFormat.format(profile.alchemy.getWeight()) +
                "\n**Catacombs:** " + weightFormat.format(profile.catacombs.getWeight()) +
                "\n**Slayers:** " + weightFormat.format(profile.slayers.getWeight()) +
                "\n - Zombie: " + weightFormat.format(profile.zombie.getWeight()) +
                "\n - Spider: " + weightFormat.format(profile.spider.getWeight()) +
                "\n - Wolf: " + weightFormat.format(profile.wolf.getWeight()) +
                "\n - Enderman: " + weightFormat.format(profile.enderman.getWeight()) +
                "\n**Items:** " + weightFormat.format(profile.items.getWeight() + profile.pets.getWeight()) +
                "\n**Talismans:** " + weightFormat.format(profile.talismans.getWeight()) +
                "\n**Mithril Powder:** " + weightFormat.format(profile.mithrilPowder.getWeight()) +
                "\n**Gemstone Powder:** " + weightFormat.format(profile.gemstonePowder.getWeight()) +
                "\n**Pet Score:** " + weightFormat.format(profile.petScore.getWeight()) +
                "\n**Minion Slots:** " + weightFormat.format(profile.minionSlots.getWeight());
    }

    private String getGameModeEmoji(String gameMode) {
        if(gameMode == null) {
            return "";
        }
        return switch (gameMode) {
            case "ironman" -> ":recycle:";
            case "bingo" -> "???";
            default -> "";
        };
    }
}
