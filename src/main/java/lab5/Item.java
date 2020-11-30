package lab5;

public class Item implements Comparable<Item> {

    int weight, value, index;
    double ratio;

    public Item(int weight, int value, int index) {
        this.weight = weight;
        this.value = value;
        this.index = index;
        this.ratio = value / weight;
    }

    @Override
    public int compareTo(Item item) {
        if (this.ratio > item.ratio) {
            return -1;
        } else if (this.ratio < item.ratio) {
            return 1;
        } else {
            if (this.weight >= item.weight) {
                return -1;
            } else {
                return 1;
            }
        }
    }
}
