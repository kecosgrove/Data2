package Testing;

import Multiset.*;

import java.util.BitSet;
import java.util.Random;

/**
 * Created by User on 11/4/2014.
 */
public class Testing {

    //Generates a random Multiset
    public static Multiset randomMSet(int cardinality, int bound) {
        Multiset set = AVLEmpty.empty();
        Random rng = new Random();
        for (int j = 0; j < cardinality; j++) {
            set = set.add(rng.nextInt(bound));
        }
        return set;
    }

    //Generates a random Multiset with no duplicates (for tree testing)
    public static AVLMultiset randomSet(int cardinality) {
        AVLMultiset set = AVLEmpty.empty();
        Random rng = new Random();
        for (int j = 0; j < cardinality; j++) {
            int theInt = rng.nextInt();
            if (set.multiplicity(theInt) == 0) {
                set = set.add(rng.nextInt());
            } else j--;
        }
        return set;
    }

    //Tests the self balancing properties of the tree
    public static void treeBalanceTest(int treeSize, int repeat) {
        int fail = 0;
        for (int i = 0; i < repeat; i++) {
            AVLMultiset set = randomSet(treeSize);
            if (!tBTHelper(set)) {
                fail++;
            }
        }
        System.out.println("Testing tree balance. " + repeat + " tests ran. " + fail + " fails.");
    }

    //Tests that Strings can be added and retrieved from the set.
    public static void genericTest(int repeat) {
        int fail = 0;
        for (int i = 0; i < repeat; i++) {
            Multiset newSet = AVLEmpty.empty();
            newSet = newSet.add("a a a");
            if (newSet.multiplicity("a a a") != 1) {
                fail++;
            }
        }
        System.out.println("Testing for the proper functioning of add and multiplicity in a Multiset of strings. " +
                           repeat + " tests ran. " + fail + " fails.");
    }

    //Tests if a set is balanced
    private static boolean tBTHelper(AVLMultiset set) {
        return (set.isEmpty() ||
                (Math.abs(set.getLeft().height() - set.getRight().height()) <= 1
                && tBTHelper(set.getLeft())
                && tBTHelper(set.getRight())));
    }

    //The cardinality of the empty set is 0
    public static void emptyCardTest(int repeat) {
        int fail = 0;
        for (int i = 0; i < repeat; i++) {
            if (AVLEmpty.empty().cardinality() != 0) fail++;
        }
        System.out.println("Testing the cardinality of the empty set. " + repeat + " tests ran. " + fail + " fails.");
    }

    //The cardinality of a set created by adding x elements to the empty set is x
    public static void nonemptyCardTest(int repeat) {
        Random rng = new Random();
        int fail = 0;
        for (int i = 0; i < repeat; i++) {
            int anInt = rng.nextInt(100);
            Multiset newSet = randomMSet(anInt, 100);
            if (newSet.cardinality() != anInt) fail++;
        }
        System.out.println("Testing the cardinality of a set of various numbers of elements. " + repeat +
                " tests ran. " + fail + " fails.");
    }

    //The multiplicity for all elements in a set should be greater than 0
    public static void positiveMultiplicityTest(int repeat) {
        int fail = 0;
        for (int i = 0; i < repeat; i++) {
            Multiset set = randomMSet(100, 100);
            Sequence<Integer> sequence = set.seq();
            while (sequence.notEmpty()) {
                if (set.multiplicity(sequence.here()) == 0) {
                    fail++;
                }
                sequence = sequence.next();
            }
        }
        System.out.println("Testing the multiplicity of known elements of the set. " + (repeat*100) + " tests ran. " +
                           fail + " fails.");
    }

    //The multiplicity of an element in the union of sets A and B is equal to the max of the multiplicity of that
    //element in A and in B.
    public static void unionMultiplicityTest(int repeat) {
        int fail = 0;
        for (int i = 0; i < repeat; i++) {
            Multiset A = randomMSet(10, 10);
            Multiset B = randomMSet(10, 10);
            Multiset union = A.union(B);
            Sequence<Integer> sequence = union.seq();
            while (sequence.notEmpty()) {
                if (union.multiplicity(sequence.here()) != Math.max(A.multiplicity(sequence.here()), B.multiplicity(sequence.here()))) {
                    fail++;
                }
                sequence = sequence.next();
            }
        }
        System.out.println("Testing the multiplicity of two sets vs. their union. " + (repeat*10) + " tests ran. " +
                           fail + " fails.");
    }

    //The multiplicity of an element in the intersection of sets A and B is equal to the min of the multiplicity of
    // that element in A and in B.
    public static void intersectionMultiplicityTest(int repeat) {
        int fail = 0;
        for (int i = 0; i < repeat; i++) {
            Multiset A = randomMSet(10, 10);
            Multiset B = randomMSet(10, 10);
            Multiset intersect = A.intersection(B);
            Sequence<Integer> sequence = intersect.seq();
            while (sequence.notEmpty()) {
                if (intersect.multiplicity(sequence.here()) !=
                        Math.min(A.multiplicity(sequence.here()), B.multiplicity(sequence.here()))) {
                    fail++;
                }
                sequence = sequence.next();
            }
        }
        System.out.println("Testing the multiplicity of two sets vs. their intersection. " + (repeat*10) +
                           " tests ran. " + fail + " fails.");
    }

    //The multiplicity of an element in the combination of sets A and B is equal to the min of the multiplicity of
    // that element in A and in B.
    public static void combinationMultiplicityTest(int repeat) {
        int fail = 0;
        for (int i = 0; i < repeat; i++) {
            Multiset A = randomMSet(10, 10);
            Multiset B = randomMSet(10, 10);
            Multiset combination = A.combine(B);
            Sequence<Integer> sequence = combination.seq();
            while (sequence.notEmpty()) {
                if (combination.multiplicity(sequence.here()) !=
                        A.multiplicity(sequence.here()) + B.multiplicity(sequence.here())) {
                    fail++;
                }
                sequence = sequence.next();
            }
        }
        System.out.println("Testing the multiplicity of two sets vs. their combination. " + (repeat*10) +
                " tests ran. " + fail + " fails.");
    }

    //The difference of two sets A and B should have a smaller or equal cardinality to the set A
    public static void differenceCardinalityTest(int repeat) {
        int fail = 0;
        for (int i = 0; i < repeat; i++) {
            Multiset A = randomMSet(100, 10);
            Multiset B = randomMSet(100, 10);
            Multiset difference = A.difference(B);
            if (difference.cardinality() > A.cardinality()) {
                fail++;
            }
        }
        System.out.println("Testing the relative cardinalities of a set and its difference with a third set. " + repeat
                           + " tests ran. " + fail + " fails.");
    }

    //The sets A and B should both be a subset of the union of A and B.
    public static void subsetUnionRelnTest(int repeat) {
        int fail = 0;
        for (int i = 0; i < repeat; i++) {
            Multiset A = randomMSet(100, 100);
            Multiset B = randomMSet(100, 100);
            Multiset union = A.union(B);
            if (!(union.subset(A) && union.subset(B))) {
                fail++;
            }
        }
        System.out.println("Testing the subset inclusion of sets A and B in their union. " + repeat + " tests ran. " +
                           fail + " fails.");
    }

    //The intersection of A and B should be a subset of both A and B.
    public static void subsetIntersectRelnTest(int repeat) {
        int fail = 0;
        for (int i = 0; i < repeat; i++) {
            Multiset A = randomMSet(100, 100);
            Multiset B = randomMSet(100, 100);
            Multiset intersect = A.intersection(B);
            if (!(A.subset(intersect) && B.subset(intersect))) {
                fail++;
            }
        }
        System.out.println("Testing the subset inclusion of the intersection of A and B in A and B. " + repeat +
                " tests ran. " + fail + " fails.");
    }

    public static void main(String[] args) {
        treeBalanceTest(100, 10);
        genericTest(50);
        emptyCardTest(50);
        nonemptyCardTest(20);
        positiveMultiplicityTest(10);
        unionMultiplicityTest(10);
        intersectionMultiplicityTest(10);
        combinationMultiplicityTest(10);
        differenceCardinalityTest(20);
        subsetUnionRelnTest(10);
        subsetIntersectRelnTest(10);
    }

}
