package Multiset;

/**
 * Created by User on 10/31/2014.
 */
public interface Sequence<D> {
    public D here();
    public boolean notEmpty();
    public Sequence next();
}