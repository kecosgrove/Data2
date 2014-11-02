package Multiset;

/**
 * Created by User on 10/26/2014.
 */
public interface Multiset<D extends Comparable<D>> extends Sequenced, Sequence<D> {

    public boolean isEmpty();
    public int height();
    public Multiset rotate(boolean toRight);
    public Multiset getRight();
    public Multiset getLeft();
    public MSContainer<D> getData();
    public Multiset add(D data);
    //public Multiset remove(D data);

}
