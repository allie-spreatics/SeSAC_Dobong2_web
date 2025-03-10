package _05_class._a_access_modifier.pack3;

public class B {
    public static void main(String[] args) {
        A a = new A(); // pack3의 A 클래스를 이용해서 인스턴스 생성
        // 생성자에 method1, method2, method3 호출해둔 상태이기 때문에 생성만 해둬도 터미널에 method 실행되는 것 보임
        System.out.println(a.field1); // public 같은 패키지, 접근 가능
        System.out.println(a.field2); // default 같은 패키지, 접근 가능
        // System.out.println(a.field3); // private 같은패키지, 다른 클래스 > 접근 불가
        // 'field3' has private access in '_05_class._a_access_modifier. pack3.A'

        a.field1=11;
        a.field2=22;
        // a.field3=33; // 변경도 당연히 안됨!
        
        // method 호출해보기
        a.method1();
        a.method2();
        // a.method3(); // private 메소드 호출 안됨
    }
}
