package _05_class._a_access_modifier.pack4;

import _05_class._a_access_modifier.pack3.A;

// pack3의 A 클래스에 다시 접근해보기!
public class C {
    public static void main(String[] args) {
        A a= new A(); // A 클래스가 public 으로 선언되어 있긴 하지만, 다른 패키지이기 때문에 import 해야함.
        System.out.println(a.field1);
        // System.out.println(a.field2); // 다른 패키지이기 때문에 default 접근 안됨
        // System.out.println(a.field3); // private 당연히 접근 안됨
        a.method1();
        // a.method2(); // default 접근 안됨
        // a.method3(); // private 접근 안됨
        // method2(), method3() is not public


    }
}
