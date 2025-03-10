package _05_class._a_access_modifier.pack3;

// pack1 에 A 클래스가 있긴 하지만
// 서로 다른 패키지이기 때문에 똑같은 클래스 이름을 사용할 수 있다.
public class A {
    // 필드 (public, default, private)
    public int field1;
    int field2;
    private int field3;

    // 생성자
    public A(){
        this.field1=1;
        this.field2=2;
        this.field3=3; // private 이어도 같은 클래스 안에서는 접근 가능

        method1();
        method2();
        method3(); // 마찬가지 접근 가능..
    }

    // 메소드 (public, default, private)
    public void method1(){
        System.out.println("this is [A class-method1(public)] in [pack3]");
    }
    void method2(){
        System.out.println("this is [A class-method2(default)] in [pack3]");
    }
    private void method3(){
        System.out.println("this is [A class-method3(private)] in [pack3]");
    }
}
