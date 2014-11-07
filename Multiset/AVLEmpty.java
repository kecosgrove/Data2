package Multiset;

/**
 * An empty AVL tree.
 * @author Kevin Cosgrove
 */

public class AVLEmpty<D extends Comparable<D>> implements Multiset<D>, AVLMultiset<D> {

    public static AVLMultiset empty() {
        return new AVLEmpty();
    }

    public boolean isEmpty() {
        return true;
    }

    public int height() {
        return 0;
    }

    public AVLMultiset rotate(boolean toRight) {
        return this;
    }

    public AVLMultiset getRight() {
        throw new RuntimeException("getRight called on empty tree!");
    }

    public AVLMultiset getLeft() {
        throw new RuntimeException("getLeft called on empty tree!");
    }

    public MSContainer<D> getData() {
        throw new RuntimeException("getData called on empty tree!");
    }

    public AVLMultiset add(D data) {
        return new AVLTree(this, this, new MSContainer(data, 1));
    }

    public int multiplicity(D data) {
        return 0;
    }

    public int cardinality() {
        return 0;
    }

    public AVLMultiset remove(D data) {
        return this;
    }

    public boolean subset(Multiset set) {
        return false;
    }

    public AVLMultiset union(Multiset set) {
        Sequence<D> sequence = set.seq();
        AVLMultiset newSet = this;
        while (sequence.notEmpty()) {
            newSet = newSet.add(sequence.here());
            sequence = sequence.next();
        }
        return newSet;
    }

    public Multiset combine(Multiset set) {
        return set;
    }

    public Multiset difference(Multiset set) {
        return this;
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
