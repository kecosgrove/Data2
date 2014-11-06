package Multiset;

/**
 * Created by User on 10/26/2014.
 */
public class AVLTree<D extends Comparable<D>> implements Multiset<D> {

    private Multiset right;
    private Multiset left;
    private MSContainer<D> data;

    public AVLTree(Multiset right, Multiset left, MSContainer<D> data) {
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

    public Multiset rotate(boolean toRight) {
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

    public Multiset getRight() {
        return right;
    }

    public Multiset getLeft() {
        return left;
    }

    public MSContainer<D> getData() {
        return data;
    }

    public Multiset add(D data) {
        Multiset newSet;
        if (this.data.getData().compareTo(data) == 0) {
            newSet = this;
        } else if (this.data.getData().compareTo(data) > 0) {
            newSet = new AVLTree(right.add(data), left, this.data);
        } else {
            newSet = new AVLTree(right, left.add(data), this.data);
        }
        return balance(newSet);
    }

    public int multiplicity(D data) {
        if (data.compareTo(this.data.getData()) == 0) {
            return this.data.getCount();
        } else if (data.compareTo(this.data.getData()) > 0) {
            return right.multiplicity(data);
        } else {
            return left.multiplicity(data);
        }
    }

    public int cardinality() {
        return data.getCount() + right.cardinality() + left.cardinality();
    }

    public Multiset remove(D data) {
        if (data.compareTo(this.data.getData()) == 0) {
            if (this.data.getCount() <= 1) {
                return right.union(left);
            } else {
                return new AVLTree(right, left, new MSContainer(data, this.data.getCount() - 1));
            }
        } else if (data.compareTo(this.data.getData()) > 0) {
            return new AVLTree(right.remove(data), left, this.data);
        } else {
            return new AVLTree(right, left.remove(data), this.data);
        }
    }

    public Multiset union(Multiset set) {
        while (set.multiplicity(data.getData()) < data.getCount()) {
            set = set.add(data.getData());
        }
        return set.union(right).union(left);
    }

    public Multiset combine(Multiset set) {
        int count = data.getCount();
        for (int i = 0; i < count; i++) {
            set = set.add(data.getData());
        }
        return set.combine(right).combine(left);
    }

    public Multiset difference(Multiset set) {
        Sequence<D> sequence = this.seq();
        while (sequence.notEmpty()) {
            set = set.remove(sequence.here());
            sequence = sequence.next();
        }
        return set;
    }

    public Multiset intersection(Multiset set) {
        while (set.multiplicity(data.getData()) > data.getCount()) {
            set = set.remove(data.getData());
        }
        return set.intersection(right).intersection(left);
    }

    public Sequence seq() {
        return this;
    }

    public boolean notEmpty() {
        return true;
    }

    public D here() {
        return data.getData();
    }

    public Sequence next() {
        return new HeadlessTree(this.getRight(), this.getLeft());
    }

    private static Multiset balance(Multiset tree) {
        if (!tree.isEmpty()) {
            Multiset newSet = new AVLTree(balance(tree.getRight()), balance(tree.getLeft()), tree.getData());
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
