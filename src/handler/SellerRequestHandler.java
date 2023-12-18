package handler;

import dao.DealsDao;
import worker.SellerRequestWorker;

import java.util.Date;

public class SellerRequestHandler {

    private SellerRequestWorker sellerRequestWorker;

    public SellerRequestHandler() {
        this.sellerRequestWorker = new SellerRequestWorker(new DealsDao());
    }

    /**
     * This method creates a deal given the price, itemName and itemCount
     * @param price
     * @param itemName
     * @param itemCount
     * @return return the dealId which seller needs to keep track to update or end a deal
     */
    public String createDeal(final int price, final String itemName, final int itemCount, final Date dealExpirationTime) {
        String dealId;
        try {
            dealId = sellerRequestWorker.createDeal(price, itemName, itemCount, dealExpirationTime);
        } catch (Exception e) {
            // did not setup up log4j, adding System output log
            System.out.println("Encountered exception while creating deal for itemName:" + itemName);
            throw e;
        }
        System.out.println("Successfully created deal with dealId:" + dealId);
        return dealId;
    }

    public void endDeal(final String dealId) {
        try {
            sellerRequestWorker.endDeal(dealId);
        } catch (Exception e) {
            // did not setup up log4j, adding System output log
            System.out.println("Encountered exception while ending dealId: " + dealId);
            throw e;
        }
        System.out.println("Successfully ended deal with dealId:" + dealId);
    }

    public void updateDeal(final String dealId, final int newItemCount, final Date newDealExpirationTime) throws Exception {
        try {
            sellerRequestWorker.updateDeal(dealId, newItemCount, newDealExpirationTime);
        } catch (Exception e) {
            // did not setup up log4j, adding System output log
            System.out.println("Encountered exception while updating dealId: " + dealId);
            throw e;
        }
        System.out.println("Successfully updated deal with dealId:" + dealId);
    }

}
