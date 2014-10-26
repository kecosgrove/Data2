package Multiset;

/**
 * Created by User on 10/26/2014.
 */
public class AVLEmpty<D> implements Multiset {

    public boolean isEmpty() {
        return true;
    }

    public int height() {
        return 0;
    }

    public AVL rotate(boolean toRight) {
        return this;
    }

    public AVL getRight() {
        throw new RuntimeException("getRight called on empty tree!");
    }

    public AVL getLeft() {
        throw new RuntimeException("getLeft called on empty tree!");
    }

    public D getData() {
        throw new RuntimeException("getData called on empty tree!");
    }

}
