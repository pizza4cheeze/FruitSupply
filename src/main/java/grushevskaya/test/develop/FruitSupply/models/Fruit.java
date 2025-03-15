package grushevskaya.test.develop.FruitSupply.models;

public abstract class Fruit {
    Integer id;
    String type;
    String sort;

    public Fruit() {}

    public Fruit(String type, String sort) {
        this.type = type;
        this.sort = sort;
    }

    public Fruit (Integer id, String type, String sort) {
        this.id = id;
        this.type = type;
        this.sort = sort;
    }
}
