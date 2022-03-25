package database;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.PathNotFoundException;
import profile.SkyblockProfile;
import profile.fields.IField;
import profile.fields.ItemField;
import profile.fields.PetField;
import profile.fields.SimpleField;
import utils.HttpGetRequest;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;

public class SkyCryptDatabase implements IDatabase {

    public static final String SKY_CRYPT_URL = "https://sky.shiiyu.moe/api/v2/profile/";
    private static final String ERROR_KEY = "error";
    private static final String PROFILE_NAME_KEY = "cute_name";
    private static final String PROFILE_CURRENT_KEY = "current";

    private static final Logger logger = Logger.getLogger(SkyCryptDatabase.class.getName());

    public static String getAPIRaw(String playerName) throws IOException {
        HttpGetRequest request = new HttpGetRequest(SKY_CRYPT_URL + playerName);
        return request.get();
    }

    @Override
    public SkyblockProfile getProfile(String playerName) throws DatabaseException {
        return getProfile(playerName, null);
    }

    @Override
    public SkyblockProfile getProfile(String playerName, String profileName) throws DatabaseException {
        try {
            String rawData = getAPIRaw(playerName);
            DocumentContext document = JsonPath.parse(rawData);
            if (hasErrorKey(document)) {
                throw new DatabaseException(playerName, profileName, "Couldn't find the player '" + playerName + "'");
            }
            if (profileName == null) {
                profileName = getCurrentProfileName(document);
            }
            SkyblockProfile profile = getProfileFromDocument(document, playerName, profileName);
            if (profile == null) {
                throw new DatabaseException(playerName, profileName, "Couldn't find the profile '" + profileName + "'");
            }
            return profile;
        } catch (IOException e) {
            throw new DatabaseException(playerName, profileName, "Could not retrieve API data");
        }
    }

    private String getCurrentProfileName(DocumentContext document) {
        Map<String, Object> profileMap = document.read("$.profiles");
        Set<String> keys = profileMap.keySet();
        for (String key : keys) {
            Map<String, Object> jsonProfile = document.read("$.profiles." + key);
            if ((boolean) jsonProfile.get(PROFILE_CURRENT_KEY)) {
                return jsonProfile.get(PROFILE_NAME_KEY).toString();
            }
        }
        return null;
    }

    private boolean hasErrorKey(DocumentContext document) {
        Map<String, Object> map = document.read("@");
        return map.containsKey(ERROR_KEY);
    }

    private SkyblockProfile getProfileFromDocument(DocumentContext document, String playerName, String profileName) {
        String profileID = getProfileIDByName(document, profileName);
        if (profileID == null) {
            return null;
        }
        SkyblockProfile skyblockProfile = new SkyblockProfile();
        skyblockProfile.playerName = playerName;
        skyblockProfile.profileName = profileName;
        skyblockProfile.gameMode = document.read("$.profiles." + profileID + ".data.profile.game_mode");
        for (SimpleField<?> field : skyblockProfile.simpleFields) {
            try {
                field.setValue(document.read("$.profiles." + profileID + "." + field.jsonPath));
            } catch (PathNotFoundException e) {
                logger.info(e.getMessage());
            }
        }
        for (IField field : skyblockProfile.items.getFields()) {
            if (field instanceof ItemField itemField) {
                itemField.setValue(hasItem(document, profileID, itemField.jsonPaths, itemField.itemID));
            }
        }
        for (IField field : skyblockProfile.pets.getFields()) {
            if (field instanceof PetField petField) {
                petField.setValue(getPet(document, profileID, petField.jsonPath, petField.petID));
            }
        }
        return skyblockProfile;
    }


    private boolean hasItem(DocumentContext document, String profileID, String[] jsonPaths, String itemID) {
        for (String jsonPath : jsonPaths) {
            if (document.read("$.profiles." + profileID + "." + jsonPath + "[*][?(@.tag.ExtraAttributes.id == \"" + itemID + "\")]", List.class).size() > 0) {
                return true;
            }
        }
        return false;
    }

    private Map<String, Object> getPet(DocumentContext document, String profileID, String jsonPath, String petID) {
        List<Map<String, Object>> matchingArray =
                document.read("$.profiles." + profileID + "." + jsonPath + "[*][?(@.type == \"" + petID + "\")]");
        if (matchingArray.size() > 0) {
            return matchingArray.get(0);
        }
        return null;
    }

    private String getProfileIDByName(DocumentContext document, String profileName) {
        Map<String, Object> profileMap = document.read("$.profiles");
        Set<String> keys = profileMap.keySet();
        for (String key : keys) {
            Map<String, Object> jsonProfile = document.read("$.profiles." + key);
            if (jsonProfile.get(PROFILE_NAME_KEY).toString().equalsIgnoreCase(profileName)) {
                return key;
            }
        }
        return null;
    }
}
