package personal.model;

import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

public class UserMapperJSON extends UserMapper{

    public String map(User user) {

        Gson gson = new Gson();

        HashMap<String, String> map = new HashMap();
        map.put("id", user.getId());
        map.put("firstName", user.getFirstName());
        map.put("lastName", user.getLastName());
        map.put("phone", user.getPhone());

        return gson.toJson(map);

    }

    public User map(String line) {

        Gson gson = new Gson();

        Map<String, String> map = gson.fromJson(line, HashMap.class);

        return new User(map.get("id"), map.get("firstName"), map.get("lastName"), map.get("phone"));
    }

}
