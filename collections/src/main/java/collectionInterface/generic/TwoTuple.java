package collectionInterface.generic;

/**
 * 适用于需要返回两个参数的情形
 */
class TwoTuple<A, B> {

    public final A a;
    public final B b;

    public TwoTuple(A a, B b) {
        this.a = a;
        this.b = b;
    }

    public A getA() {
        return a;
    }

    public B getB() {
        return b;
    }


}