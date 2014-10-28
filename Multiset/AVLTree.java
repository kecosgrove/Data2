package Multiset;

/**
 * Created by User on 10/26/2014.
 */
public class AVLTree<D extends Comparable<D>> implements AVL<D> {

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
        return 1 + Math.max(right.height(), left.height());
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

    public AVL add(D data) {
        AVL newSet;
        if (this.data.compareTo(data) == 0) {
            newSet = this;
        } else if (this.data.compareTo(data) > 0) {
            newSet = new AVLTree(right.add(data), left, this.data);
        } else {
            newSet = new AVLTree(right, left.add(data), this.data);
        }
        return balance(newSet);
    }

    public boolean member(D data) {
        if (this.data.compareTo(data) > 0) return right.member(data);
        else if (this.data.compareTo(data) < 0) return left.member(data);
        else return true;
    }

    private static AVL balance(AVL tree) {
        if (!tree.isEmpty()) {
            AVL newSet = new AVLTree(balance(tree.getRight()), balance(tree.getLeft()), tree.getData());
            if ((newSet.getLeft().height() - newSet.getRight().height()) > 1) {
                //left is overweight
                if (newSet.getLeft().getLeft().height() > newSet.getLeft().getRight().height()) {
                    //left left case
                    newSet = newSet.rotate(true);
                } else {
                    //left right case
                    newSet = new AVLTree(newSet.getRight(),
                                         newSet.getLeft().rotate(false),
                                         newSet.getData()).rotate(true);
                }
            } else if (newSet.getLeft().height() - newSet.getRight().height() < -1) {
                //right is overweight
                if (newSet.getRight().getRight().height() > newSet.getRight().getLeft().height()) {
                    //right right case
                    newSet = newSet.rotate(false);
                } else {
                    //right left case
                    newSet = new AVLTree(newSet.getRight().rotate(true),
                                         newSet.getLeft(),
                                         newSet.getData()).rotate(false);
                }
            }
            return newSet;
        } else {
            return tree;
        }
    }

}
