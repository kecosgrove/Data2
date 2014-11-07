package Multiset;

/**
 * A generic interface to support the implementation of the Multiset interface using AVL Trees.
 * @author Kevin Cosgrove
 */

public interface AVLMultiset<D extends Comparable<D>> extends Multiset<D> {

    /**@return The height of the tree.*/
    public int height();
    /**@param toRight A boolean. If given true, the tree will rotate to the right. If given false, the tree will rotate
     *                to the left.
     * @return A tree rotated in the given direction in accordance with the rules governing AVL trees.*/
    public AVLMultiset rotate(boolean toRight);
    /**@return The right subtree. This function is only defined on non-empty instances of AVLMultiset.*/
    public AVLMultiset getRight();
    /**@return The left subtree. This function is only defined on non-empty instances of AVLMultiset.*/
    public AVLMultiset getLeft();
    /**@return An MSContainer holding data from the set. This function is only defined on non-empty instances of
     * AVLMultiset.*/
    public MSContainer<D> getData();
    public AVLMultiset add(D data);
    public AVLMultiset remove(D data);
    public AVLMultiset union(Multiset set);


}
