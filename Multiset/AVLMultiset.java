package Multiset;

/**
 * Created by User on 10/28/2014.
 */
public class AVLMultiset<H extends Comparable<H>> extends AVLTree<MSContainer<H>> implements Multiset {

    public AVLMultiset(AVLMultiset right, AVLMultiset left, MSContainer data) {
        super(right, left, data);
    }

}
