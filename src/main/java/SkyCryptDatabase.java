import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import fields.Field;
import fields.ItemField;
import fields.PetField;
import net.minidev.json.JSONArray;

import java.io.IOException;
import java.util.Map;
import java.util.Set;

public class SkyCryptDatabase implements IDatabase {

    public static final String SKY_CRYPT_URL = "https://sky.shiiyu.moe/api/v2/profile/";

    public static String getAPIRaw(String playerName) throws IOException {
        HttpGetRequest request = new HttpGetRequest(SKY_CRYPT_URL+playerName);
        return request.get();
    }

    @Override
    public SkyblockProfile getProfile(String playerName, String profileName) throws DatabaseException {
        try {
            String rawData = getAPIRaw(playerName);
            if(((Map<String, Object>)JsonPath.parse(rawData).read("@")).containsKey("error")) {
                throw new DatabaseException("Couldn't find the player '"+playerName+"'");
            }
            return getProfileFromMap(rawData, profileName);
        } catch (IOException e) {
            throw new DatabaseException("Could not retrieve API data");
        }
    }

    private SkyblockProfile getProfileFromMap(String rawData, String profileName) throws DatabaseException {
        DocumentContext document = JsonPath.parse(rawData);
        String profileID = getProfileIDByName(document, profileName);
        SkyblockProfile skyblockProfile = new SkyblockProfile();
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
        JSONArray matchingArray = document.read("$.profiles." + profileID + "." + jsonPath + "[*][?(@.type == \""+petID+"\")]", JSONArray.class);
        if(matchingArray.size() > 0) {
            return (Map<String, Object>) matchingArray.get(0);
        }
        return null;
    }

    private String getProfileIDByName(DocumentContext jsonDocument, String profileName) throws DatabaseException {
        Set<String> keys = ((Map<String, Object>) jsonDocument.read("$.profiles")).keySet();
        for(String key : keys) {
            Map<String, Object> jsonProfile = jsonDocument.read("$.profiles."+key);
            if(jsonProfile.get("cute_name").toString().equalsIgnoreCase(profileName)) {
                return key;
            }
        }
        if(keys.toArray().length == 0) {
            throw new DatabaseException("Couldn't find the profile '"+profileName+"'");
        }
        return (String) keys.toArray()[0];
    }
}
