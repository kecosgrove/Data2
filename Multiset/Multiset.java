package Multiset;

/**
 * An interface for implementing A multiset data structure. Includes various common operations on multisets.
 * @author Kevin Cosgrove
 */

public interface Multiset<D extends Comparable<D>> extends Sequenced, Sequence<D> {

    /**@return True if the tree is empty. False otherwise.*/
    public boolean isEmpty();
    /**@param data An object of the type the Multiset is Parametrized over. The type must be Comparable with itself.
     * @return The number of instances of data in the set.*/
    public int multiplicity(D data);
    /**@return The number of elements in the set.*/
    public int cardinality();
    /**@param data An object of the type the Multiset is Parametrized over. The type must be Comparable with itself.
     * @return A new Multiset, same as the parent but with one more instance of data.*/
    public Multiset add(D data);
    /**@param data An object of the type the Multiset is Parametrized over. The type must be Comparable with itself.
     * @return A new Multiset, same as the parent but with one less instance of data. No effect if there are no
     * instances of data in the parent.*/
    public Multiset remove(D data);
    /**@param set A Multiset parametrized over the same type.
     * @return True if set is a subset of the parent. False otherwise.*/
    public boolean subset(Multiset set);

    /**@param set A Multiset parameterized over the same type.
     * @return A Multiset possessing multiplicity for every element in the parent or the input set equal to the
     * maximum of the multiplicity of that element in the parent and the input set.*/
    public Multiset union(Multiset set);

    /**@param set A Multiset parameterized over the same type.
     * @return A Multiset possessing multiplicity for every element in the parent or the input set equal to the
     * multiplicity of that element in the parent added to the multiplicity of that element in the input.*/
    public Multiset combine(Multiset set);

    /**@param set A Multiset parameterized over the same type.
     * @return A Multiset possessing multiplicity for every element in the parent equal to the multiplicity of that
     * element in the parent minus the multiplicity of that element in the input; not less than 0.*/
    public Multiset difference(Multiset set);

    /**@param set A Multiset parameterized over the same type.
     * @return A Multiset possessing multiplicity for every element in the parent or the input set equal to the
     * minimum of the multiplicity of that element in the parent and the input set.*/
    public Multiset intersection(Multiset set);


}
