package Multiset;

/**
 * Created by User on 11/2/2014.
 */
class HeadlessTree<D> implements Sequence<D> {
    Sequence<D> left;
    Sequence<D> right;

    HeadlessTree(Sequence right, Sequence left) {
        this.right = right;
        this.left = left;
    }

    public boolean notEmpty() {
        return this.left.notEmpty() || this.right.notEmpty();
    }

    public D here() {
        if ( this.left.notEmpty() ) {
            return this.left.here();
        } else {
            return this.right.here();
        }
    }
    public Sequence next() {
        if ( this.left.notEmpty() ) {
            return new HeadlessTree( this.left.next(), this.right );
        } else {
            return this.right.next();
        }
    }
}