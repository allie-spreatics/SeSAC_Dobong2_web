package _05_class._b_static;

public class CalculatorEx {
    public static void main(String[] args) {
        int num1 = 10;
        int num2 = 5;

        // new Calculator()를 이용해 인스턴스를 만들지 않아도 pi 변수 사용 가능
        double circleArea = num1 * num1 * Calculator.pi; // 바로 접근 가능

        int plusResult = Calculator.plus(num1, num2);
        int minusResult = Calculator.minus(num1, num2);
        double lengthCircleResult = Calculator.circumference(num1);

        System.out.println("원의 넓이: " + circleArea);
        System.out.println("원의 둘레: " + lengthCircleResult);
        System.out.println("덧셈 결과: " + plusResult);
        System.out.println("뺄셈 결과: " + minusResult);

        // --- 참고)) static 변수 재할당 가능 ~
        System.out.println(a); // 10
        a = 21;
        System.out.println(a); // 21
    }

    static int a = 10;
}
