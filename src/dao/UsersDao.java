package dao;

import java.util.HashMap;
import java.util.Map;

public class UsersDao {

    private Map<String, Integer> userIdToItemCountMap;

    public UsersDao() {
        userIdToItemCountMap = new HashMap<>();
        userIdToItemCountMap.put("123", 0);
    }

    public int getItemCountForUser(final String userId) {
        return userIdToItemCountMap.get(userId);
    }

    public Integer updateItemCountForUser(final String userId, final int count) {
        return userIdToItemCountMap.put(userId, count);
    }
}
