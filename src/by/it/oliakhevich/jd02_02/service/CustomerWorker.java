package by.it.oliakhevich.jd02_02.service;

import by.it.oliakhevich.jd02_02.helper.Randomize;
import by.it.oliakhevich.jd02_02.model.*;


public class CustomerWorker extends Thread implements CustomerAction, ShoppingCardAction {
    private final Customer customer;
    Queue queue;
    Manager manager;

    public CustomerWorker()  {
        throw new StoreException("customer is not existed");
    }
    public CustomerWorker(Customer customer,Queue queue,Manager manager){
        this.customer=customer;this.queue=queue;this.manager=manager; manager.addOneCustomer();
    }

    public void run() {
        enteredStore();
        int b= Randomize.Randomize(2,5);
        takeCart();
        if (customer.isHasCart()){
            GoodCreator goodCreator = new GoodCreator();
            for (int i = 0; i <b; i++) {putToCart(goodCreator.addGood());}}
        getIntoQueue();
        goOut();
        manager.goOutOneCustomer();
    }
    @Override
    public void enteredStore() {
        System.out.println(customer+" entered the store");
    }

    @Override
    public Good chooseGood() {
        try {
            Thread.sleep(Randomize.Randomize(500,2000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        GoodCreator goodCreator = new GoodCreator();
        System.out.println(customer+" chose "+goodCreator.addGood());
        return goodCreator.addGood();
    }

    @Override
    public void goOut() {
        System.out.println(customer+" left the store");
    }

    public void getIntoQueue() {
        synchronized (customer.getMonitor()){
            queue.addCustomer(customer);
            customer.setWaiting(true);
            while (customer.isWaiting())
                try {
                    customer.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
        }
    }



    @Override
    public void takeCart() {
        customer.setHasCart(true);
        System.out.println(customer+" took cart ");
    }

    @Override
    public int putToCart(Good good) {
        ShoppingCard customerCart= customer.getCustomerCart();
        customerCart.cartAdd(good);
        System.out.println(customer+" put "+good+" into cart");
        return customerCart.cartSize();
    }
}
