package by.it.antipov.jd02_02;


import by.it.antipov.jd02_02.model.Manager;

public class Runner {
    public static void main(String[] args) {
        Manager manager = new Manager(10);
        Store store = new Store(manager);
        store.start();
    }
}
