package Multiset;

/**
 * Created by User on 10/28/2014.
 */
public class MSContainer<H extends Comparable<H>> implements Comparable<MSContainer<H>> {

    private H data;
    private int count;

    public MSContainer(H data, int count) {
        this.data = data;
        this.count = count;
    }

    public H getData() {
        return data;
    }

    public int getCount() {
        return count;
    }

    public int compareTo(MSContainer container) {
        return data.compareTo((H)container.getData());
    }

}
