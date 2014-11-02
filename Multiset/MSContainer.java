package Multiset;

/**
 * Created by User on 10/28/2014.
 */
public class MSContainer<D extends Comparable<D>> implements Comparable<MSContainer<D>> {

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

    public int compareTo(MSContainer container) {
        return data.compareTo((D)container.getData());
    }

}
