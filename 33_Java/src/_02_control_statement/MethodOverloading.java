package _02_control_statement;
/*
 * 하나의 클래스에서 동일한 이름의 메서드 여러 개 정의할 수 있음
   (cf. typescript method overloading)

 *  함수의 이름은 같으나 매개변수의 타입, 리턴타입, 매개변수의 개수, 순서를 다르게 할 수 있음
 * "함수의 동작이 유사할 때" 사용
 *  */
public class MethodOverloading {
    public static void main(String[] args) {
        // (2)  non-static method 사용을 위해서 인스턴스 생성
        // - non static 인 메소드를 사용하기 위해서는 인스턴스를 생성하고 만들어야 함
        // - add라는 메소드는 MethodOverloading 클래스 내부에 선언되어 있기 때문에
        //   MethodOverloading 클래스를 기반으로 하는 인스턴스를 생성하고 사용
        MethodOverloading ol = new MethodOverloading();

        // ol.add(1, 2); // 가능! > none-static method 사용법
        // add(1,2); // 불가능!
        System.out.println(ol.add(1, 2));
        System.out.println(ol.add(1.2, 2.3));
        System.out.println(ol.add("1", "2"));

        System.out.println(ol.add(1.1, 2.2, 3.3)); // 기댓값 6.6, 정상 출력
        System.out.println(ol.add(1.1, 2.2, 4.4)); // 기댓값: 7.7, 출력: 7.700000000000001

        // 왜 이런가요? > 부동소수의 한계
        // ref. https://inpa.tistory.com/entry/JAVA-%E2%98%95-%EC%8B%A4%EC%88%98-%ED%91%9C%ED%98%84%EB%B6%80%EB%8F%99-%EC%86%8C%EC%88%98%EC%A0%90-%EC%9B%90%EB%A6%AC-%ED%95%9C%EB%88%88%EC%97%90-%EC%9D%B4%ED%95%B4%ED%95%98%EA%B8%B0#thankYou

    }

    ///  (1) 메소드 선언
    // 아래 함수 목록은 non static 메소드,
    // 덧셈(add)과 관련해서 다양한 타입과 서로 다른 매개변수 개수를 받아준다.
    public int add(int a, int b) {
        return a + b;
    }

    public double add(double a, double b) {
        return a + b;
    }

    public int add(int a, int b, int c) {
        return a + b + c;
    }

    public double add(double a, double b, double c) {
        return a + b + c;
    }

    public String add(String a, String b) {
        return a + b;
    }
}
