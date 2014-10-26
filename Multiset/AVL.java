package Multiset;

/**
 * Created by User on 10/26/2014.
 */
public interface AVL<D> {
    public boolean isEmpty();
    public int height();
    public AVL rotate(boolean toRight);
    public AVL getRight();
    public AVL getLeft();
    public D getData();
}
