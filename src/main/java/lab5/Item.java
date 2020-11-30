package lab5;

public class Item implements Comparable<Item> {

    double weight, value, ratio;

    public Item(int weight, int value) {
        this.weight = weight;
        this.value = value;
        this.ratio = value / weight;
    }

    @Override
    public int compareTo(Item item) {
        if (this.ratio > item.ratio) return 1;
        if (this.ratio < item.ratio) return -1;
        return 0;
    }
}
