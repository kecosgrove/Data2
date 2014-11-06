package Multiset;

import java.util.Random;

/**
 * Created by User on 11/4/2014.
 */
public class Testing {

    public static Multiset randomSet(int treeSize) {
        Multiset set = AVLEmpty.empty();
        Random rng = new Random();
        for (int j = 0; j < treeSize; j++) {
            set = set.add(rng.nextInt());
        }
        return set;
    }

    public static Multiset monoSet(int treeSize) {
        Multiset set = AVLEmpty.empty();
        int element = 0;
        for (int j = 0; j < treeSize; j++) {
            set = set.add(element);
            element++;
        }
        return set;
    }

    public static void treeBalanceTest(int treeSize, int repeat) {
        for (int i = 0; i < repeat; i++) {
            Multiset set = randomSet(treeSize);
            if (tBTHelper(set)) {
                System.out.println("Height: " + set.height() + " Elements: " + treeSize + " All nodes are balanced.");
            }
        }
    }

    //Tests if set is balanced
    private static boolean tBTHelper(Multiset set) {
        return (set.isEmpty() ||
                (Math.abs(set.getLeft().height() - set.getRight().height()) <= 1
                && tBTHelper(set.getLeft())
                && tBTHelper(set.getRight())));
    }

    public static void main(String[] args) {
        treeBalanceTest(100, 10);
        /*
        for (int i = 0; i < 10; i++) {
            Multiset randSet = randomSet(100);
            System.out.println("" + randSet.height());
            System.out.println("" + randSet.getRight().height());
            System.out.println("" + randSet.getLeft().height());
            System.out.println("-");
        }
        for (int i = 0; i < 10; i++) {
            Multiset nonrandSet = uniqueSet(100);
            System.out.println("" + nonrandSet.height());
            System.out.println("" + nonrandSet.getRight().height());
            System.out.println("" + nonrandSet.getLeft().height());
            System.out.println("-");
        }
        */
    }

}
