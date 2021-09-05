package collectionInterface.generic;

class GenericClass<A, B> implements GenericInterface<A, B> {  // 这里在实现接口时也可以确定泛型（下2）

    // 1 可在创建对象时确定泛型
    // 2 也可以在类实现接口时确定泛型：class GenericClass<String, int> implements GenericInterface<String, int> {}

    //属性上泛型
    public final A a;
    public final B b;

    //构造器上泛型
    public GenericClass(A a, B b) {
        this.a = a;
        this.b = b;
    }

    //泛型与类上一致的方法
    @Override
    public void love(A a, B b) {
        System.out.println(a + "===" + b); // 可以有返回值，也可以没有
    }

    //泛型与类上不一致的方法，要在前面加 <>，此方法有返回值类型，在方法调用传参时确定泛型，可以有返回值，也可以没有
    public <C> C like(C c) {
        return c;
    }
    public <C> void smile(C c) {
        System.out.println("=======smile：" + c);
    }
    
}
