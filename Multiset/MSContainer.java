package Multiset;

/**
 * A container which stores an item and a count of how many items the container represents.
 */
public class MSContainer<D extends Comparable<D>> {

    private D data;
    private int count;

    public MSContainer(D data, int count) {
        this.data = data;
        this.count = count;
    }

    public D getData() {
        return data;
    }

    public int getCount() {
        return count;
    }

    public int compareTo(MSContainer<D> container) {
        return data.compareTo(container.getData());
    }

}
