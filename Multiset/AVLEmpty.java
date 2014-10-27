package Multiset;

/**
 * Created by User on 10/26/2014.
 */
public class AVLEmpty<D extends Comparable<D>> implements Multiset<D> {

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

    public Comparable<D> getData() {
        throw new RuntimeException("getData called on empty tree!");
    }

    public Multiset add(D data) {
        return new AVLTree(this, this, data);
    }

}
