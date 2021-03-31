package coreJava.inheritance;

public class Car implements Interface3 {

    public void doS(){

    }

    @Override
    public void method1() {
        System.out.println("In class car method1");
    }

    @Override
    public void method2() {
        System.out.println("In class car method2");
    }

    @Override
    public void method3() {
        System.out.println("In class car method3");
    }

    public static void main(String[] args) {
        Car car = new Car();
        car.method1();
        car.method2();
        car.method3();
        car.method4();
    }

}
