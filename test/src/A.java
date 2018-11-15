public interface A {
    public void method1();
    public void method2();

    default public void print(A a) {
        System.out.println("this is:A");
    }
}
