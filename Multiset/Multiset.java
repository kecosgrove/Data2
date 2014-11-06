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

    public int multiplicity(D data);
    public int cardinality();
    public Multiset add(D data);
    public Multiset remove(D data);
    public Multiset union(Multiset set);
    public Multiset combine(Multiset set);
    public Multiset difference(Multiset set);
    public Multiset intersection(Multiset set);


}
