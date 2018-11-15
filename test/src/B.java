public class B implements A {
    @Override
    public void method1() {

    }

    @Override
    public void method2() {

    }
    /* this is overload not over ride*/
    public void print(B b) {
        System.out.println("this is B");
    }

    @Override
    public void print(A a) {
        System.out.println("this is A");
    }

    /**
     *  the method selection algorithms
     * */
    public static void main(String[] args) {
        B b= new B();
        A a= b;
        // When Java checks to see which method to call, it checks the static type and calls the method with the parameter of the same type.5

        a.print(a);
    }
}
