package Multiset;

/**
 * Created by User on 10/26/2014.
 */
public class AVLEmpty<D extends Comparable<D>> implements AVL<D> {

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

    public AVL add(D data) {
        return new AVLTree(this, this, data);
    }

    public boolean member(D data) {
        return false;
    }

}
