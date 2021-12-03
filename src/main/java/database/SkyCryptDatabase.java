package database;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import profile.fields.Field;
import profile.fields.ItemField;
import profile.fields.PetField;
import net.minidev.json.JSONArray;
import profile.SkyblockProfile;
import utils.HttpGetRequest;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SkyCryptDatabase implements IDatabase {

    public static final String SKY_CRYPT_URL = "https://sky.shiiyu.moe/api/v2/profile/";
    private static final String ERROR_KEY = "error";
    private static final String PROFILE_NAME_KEY = "cute_name";

    public static String getAPIRaw(String playerName) throws IOException {
        HttpGetRequest request = new HttpGetRequest(SKY_CRYPT_URL+playerName);
        return request.get();
    }

    @Override
    public SkyblockProfile getProfile(String playerName, String profileName) throws DatabaseException {
        try {
            String rawData = getAPIRaw(playerName);
            DocumentContext document = JsonPath.parse(rawData);
            if(hasErrorKey(document)) {
                throw new DatabaseException(playerName, profileName, "Couldn't find the player '"+playerName+"'");
            }
            SkyblockProfile profile = getProfileFromDocument(document, playerName, profileName);
            if(profile == null) {
                throw new DatabaseException(playerName, profileName, "Couldn't find the profile '"+profileName+"'");
            }
            return profile;
        } catch (IOException e) {
            throw new DatabaseException(playerName, profileName, "Could not retrieve API data");
        }
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
        for (Field<?> field : skyblockProfile.getFields()) {
            field.setValue(document.read("$.profiles." + profileID + "." + field.jsonPath));
        }
        for (ItemField itemField : skyblockProfile.getItemFields()) {
            itemField.setValue(hasItem(document, profileID, itemField.jsonPaths, itemField.itemID));
        }
        for (PetField petField : skyblockProfile.getPetFields()) {
            petField.setValue(getPet(document, profileID, petField.jsonPath, petField.petID));
        }
        return skyblockProfile;
    }


    private boolean hasItem(DocumentContext document, String profileID, String[] jsonPaths, String itemID) {
        for(String jsonPath : jsonPaths) {
            if(document.read("$.profiles." + profileID + "." + jsonPath + "[*][?(@.tag.ExtraAttributes.id == \""+itemID+"\")]", JSONArray.class).size() > 0) {
                return true;
            }
        }
        return false;
    }

    private Map<String, Object> getPet(DocumentContext document, String profileID, String jsonPath, String petID) {
        List<Map<String, Object>> matchingArray =
                document.read("$.profiles." + profileID + "." + jsonPath + "[*][?(@.type == \""+petID+"\")]");
        if(matchingArray.size() > 0) {
            return matchingArray.get(0);
        }
        return null;
    }

    private String getProfileIDByName(DocumentContext jsonDocument, String profileName) {
        Map<String, Object> profileMap = jsonDocument.read("$.profiles");
        Set<String> keys = profileMap.keySet();
        for(String key : keys) {
            Map<String, Object> jsonProfile = jsonDocument.read("$.profiles."+key);
            if(jsonProfile.get(PROFILE_NAME_KEY).toString().equalsIgnoreCase(profileName)) {
                return key;
            }
        }
        return null;
    }
}
