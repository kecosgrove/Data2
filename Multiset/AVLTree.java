package Multiset;

/**
 * Created by User on 10/26/2014.
 */
public class AVLTree<D> implements Multiset {

    private AVL right;
    private AVL left;
    private D data;

    public AVLTree(AVL right, AVL left, D data) {
        this.right = right;
        this.left = left;
        this.data = data;
    }

    public boolean isEmpty() {
        return false;
    }

    public int height() {
        if (right.height() > left.height())
            return 1 + right.height();
        else
            return 1 + left.height();
    }

    public AVL rotate(boolean toRight) {
        if (toRight) {
            if (!left.isEmpty()) {
                return new AVLTree(new AVLTree(left.getRight(), right, data),left.getLeft(), left.getData());
            } else {
                throw new RuntimeException("AVLTree cannot rotate in that direction!");
            }
        } else {
            if (!right.isEmpty()) {
                return new AVLTree(right.getRight(), new AVLTree(right.getLeft(), left, data), right.getData());
            } else {
                throw new RuntimeException("AVLTree cannot rotate in that direction!");
            }
        }
    }

    public AVL getRight() {
        return right;
    }

    public AVL getLeft() {
        return left;
    }

    public D getData() {
        return data;
    }

}
