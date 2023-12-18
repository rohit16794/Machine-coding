package worker;

import dao.DealsDao;
import dao.UsersDao;
import model.Item;

import java.time.Instant;
import java.util.Date;

public class CustomerRequestWorker {

    private final DealsDao dealsDao;

    private final UsersDao usersDao;

    public CustomerRequestWorker(DealsDao dealsDao, UsersDao usersDao) {
        this.dealsDao = dealsDao;
        this.usersDao = usersDao;
    }

    public String claimDeal(final String itemName) {
        final Item itemForGivenItemName = dealsDao.getItemForItemName(itemName);
        if(itemForGivenItemName == null) {
            System.out.println("Item to be claimed not found!!!");
            throw new RuntimeException("Item to be claimed not found");
        }

        final boolean isDealValid = checkIfDealIsValid(itemForGivenItemName);
        if(isDealValid) {
            itemForGivenItemName.setCount(itemForGivenItemName.getCount() - 1);
            dealsDao.updateDeal(itemForGivenItemName.getDealId(), itemForGivenItemName);
            usersDao.updateItemCountForUser("12345", 1);
        }
        return null;
    }

    private boolean checkIfDealIsValid(final Item item) {
        final Date currentDate = Date.from(Instant.now());

        if(currentDate.after(item.getDealTime())) {
            return false;
        }

        if(item.getCount() == 0) {
            return false;
        }

        final int itemCountForUser = usersDao.getItemCountForUser("12345");
        if (itemCountForUser > 0) {
            return false;
        }
        return true;
    }
}
