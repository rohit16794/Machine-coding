package dao;

import model.Item;

import java.util.Map;
import java.util.UUID;

public class DealsDao {

    private Map<String, Item> dealIdToItemsMap;

    private Map<String, Item> itemNameToItemMap;

    public String createDeal(final Item item) {
        dealIdToItemsMap.put(item.getDealId(), item);
        itemNameToItemMap.put(item.getItemName(), item);
        return item.getDealId();
    }

    public Item getDeal(final String dealId) {
        final Item item = dealIdToItemsMap.getOrDefault(dealId, null);
        return item;
    }

    public String endDeal(final String dealId) {
        final Item item = dealIdToItemsMap.getOrDefault(dealId, null);

        if(item == null) {
            System.out.println("Deal ID to be deleted does not exist");
            return null;
        }

        dealIdToItemsMap.remove(dealId);
        itemNameToItemMap.remove(item.getItemName());
        return dealId;
    }

    public String updateDeal(final String dealId, final Item item) {
        dealIdToItemsMap.put(dealId, item);
        itemNameToItemMap.put(item.getItemName(), item);
        System.out.println("Successfully updated deal in database with dealId:" + dealId);
        return dealId;
    }

    public Item getItemForItemName(final String itemName) {
        return itemNameToItemMap.getOrDefault(itemName, null);
    }
}
