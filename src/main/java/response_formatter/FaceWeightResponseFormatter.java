package response_formatter;

import profile.SkyblockProfile;

import java.text.DecimalFormat;

public class FaceWeightResponseFormatter implements IResponseFormatter {

    private static final DecimalFormat weightFormat = new DecimalFormat("0.00");

    @Override
    public String format(SkyblockProfile profile) {
        double weight = profile.faceFields.getWeight();
        return ":pick: " + profile.playerName + " | " + profile.profileName + " " + getGameModeEmoji(profile.gameMode) +
                "\n**Total Weight:** " + weightFormat.format(weight) + "\n" +
                "\n**Skills:** " + weightFormat.format(profile.faceSkills.getWeight()) +
                "\n - Taming: " + weightFormat.format(profile.faceTaming.getWeight()) +
                "\n - Farming: " + weightFormat.format(profile.faceFarming.getWeight()) +
                "\n - Mining: " + weightFormat.format(profile.faceMining.getWeight()) +
                "\n - Combat: " + weightFormat.format(profile.faceCombat.getWeight()) +
                "\n - Foraging: " + weightFormat.format(profile.faceForaging.getWeight()) +
                "\n - Fishing: " + weightFormat.format(profile.faceFishing.getWeight()) +
                "\n - Enchanting: " + weightFormat.format(profile.faceEnchanting.getWeight()) +
                "\n - Alchemy: " + weightFormat.format(profile.faceAlchemy.getWeight()) +
                "\n**Catacombs:** " + weightFormat.format(profile.faceCatacombs.getWeight()) +
                "\n**Slayers:** " + weightFormat.format(profile.faceSlayers.getWeight()) +
                "\n - Zombie: " + weightFormat.format(profile.faceZombie.getWeight()) +
                "\n - Spider: " + weightFormat.format(profile.faceSpider.getWeight()) +
                "\n - Wolf: " + weightFormat.format(profile.faceWolf.getWeight()) +
                "\n - Enderman: " + weightFormat.format(profile.faceEnderman.getWeight());
    }

    private String getGameModeEmoji(String gameMode) {
        if(gameMode == null) {
            return "";
        }
        return switch (gameMode) {
            case "ironman" -> ":recycle:";
            case "bingo" -> "Ⓑ";
            default -> "";
        };
    }
}
