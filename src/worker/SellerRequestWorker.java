package worker;

import dao.DealsDao;
import model.Item;

import java.util.Date;
import java.util.UUID;

public class SellerRequestWorker {

    private DealsDao dealsDao;

    public SellerRequestWorker(DealsDao dealsDao) {
        this.dealsDao = dealsDao;
    }

    public String createDeal(final int price, final String itemName, final int itemCount, final Date dealTime) {
        final String dealId = UUID.randomUUID().toString();
        final Item item = new Item(price, itemName, itemCount, dealTime, dealId);
        dealsDao.createDeal(item);
        System.out.println("Successfully added deal in database with dealId:" + dealId);
        return dealId;
    }

    public void endDeal(final String dealId) {
        final String dealid = dealsDao.endDeal(dealId);

        if (dealid == null) {
            System.out.println("Deal to be deleted not found");
            return;
        }
        System.out.println("Successfully removed deal in database with dealId:" + dealId);
    }

    public void updateDeal(final String dealId, final int newItemCount, final Date newDealExpirationTime)  {
        final Item item = dealsDao.getDeal(dealId);

        if (item == null) {
           System.out.println("Deal with dealId:" + dealId + " does not exist");
           throw new RuntimeException("Deal not found");
        }
        // TODO : Validation on inputs.

        item.setCount(newItemCount);
        item.setDealTime(newDealExpirationTime);

        dealsDao.updateDeal(dealId, item);
    }
}
