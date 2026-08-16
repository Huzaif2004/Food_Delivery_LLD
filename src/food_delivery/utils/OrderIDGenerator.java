package food_delivery.utils;

public class OrderIDGenerator {
	private int nextId = 1;

    public int generate() {
        return nextId++;
    }

}
