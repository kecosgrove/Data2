package Multiset;

/**
 * A generic interface for objects implementing mutation-free iteration.
 * @author Kevin Cosgrove
 */

public interface Sequence<D> {
    /**@return An object of the type the Sequence is parametrized over.*/
    public D here();
    /**@return True if the Sequence has a next(). False otherwise.*/
    public boolean notEmpty();
    /**@return The next Sequence. Only defined if the parent Sequence is not empty.*/
    public Sequence next();
}