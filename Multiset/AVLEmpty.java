package Multiset;

/**
 * Created by User on 10/26/2014.
 */
public class AVLEmpty<D extends Comparable<D>> implements Multiset<D> {

    public static Multiset empty() {
        return new AVLEmpty();
    }

    public boolean isEmpty() {
        return true;
    }

    public int height() {
        return 0;
    }

    public Multiset rotate(boolean toRight) {
        return this;
    }

    public Multiset getRight() {
        throw new RuntimeException("getRight called on empty tree!");
    }

    public Multiset getLeft() {
        throw new RuntimeException("getLeft called on empty tree!");
    }

    public MSContainer<D> getData() {
        throw new RuntimeException("getData called on empty tree!");
    }

    public Multiset add(D data) {
        return new AVLTree(this, this, new MSContainer(data, 1));
    }

    public int multiplicity(D data) {
        return 0;
    }

    public int cardinality() {
        return 0;
    }

    public Multiset remove(D data) {
        return this;
    }

    public Multiset union(Multiset set) {
        return set;
    }

    public Multiset combine(Multiset set) {
        return set;
    }

    public Multiset difference(Multiset set) {
        return set;
    }

    public Multiset intersection(Multiset set ) {
        return this;
    }

    public Sequence seq() {
        return this;
    }

    public boolean notEmpty() {
        return false;
    }

    public D here() {
        throw new RuntimeException("here() called on an empty set!");
    }

    public Sequence next() {
        return this;
    }

}
