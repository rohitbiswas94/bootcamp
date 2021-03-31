package coreJava.inheritance;

public interface Interface3 extends Interface1, Interface2 {

    void method3();

    @Override
    default void method2() {
        System.out.println("In Interface3 method2");
    }

    default void method4() {
        System.out.println("In Interface3 default method4");
    }
}
