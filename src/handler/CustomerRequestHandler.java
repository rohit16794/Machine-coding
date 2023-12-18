package handler;

import dao.DealsDao;
import dao.UsersDao;
import worker.CustomerRequestWorker;

public class CustomerRequestHandler {

    private CustomerRequestWorker customerRequestWorker;

    public CustomerRequestHandler() {
        this.customerRequestWorker = new CustomerRequestWorker(new DealsDao(), new UsersDao());
    }

    public void claimDeal(final String itemName) {
        try {
            customerRequestWorker.claimDeal(itemName);
        } catch (Exception e) {
            System.out.println("Exception while claiming deal for item:" + itemName);
        }
    }
}
