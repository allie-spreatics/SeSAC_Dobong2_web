package _01_basic_syntax;

public class Operator {
    public static void main(String[] args) {
        int x, y; // 초기화없이, 한꺼번에 선언 가능
        float a, b;

        // (=) 대입 연산자 이용해서 재할당 가능
        x = 11;
        y = 3;
        a = 11.0f; // float 초기화시, f 키워드 붙여서 float 임을 명시
        b = 3.0f;
        // a=5.6; // err

        System.out.println("==== 정수형 x, y ====");
        System.out.println("x = " + x);
        System.out.println("y = " + y);
        System.out.println("x + y = " + (x + y));
        System.out.println("x - y = " + (x - y));
        System.out.println("x * y = " + (x * y));
        System.out.println("x / y = " + (x / y)); // 몫
        System.out.println("x % y = " + (x % y)); // 나머지, js랑 동일
        // 제곱은  Math.pow(x,3) 사용: 출력 결과 double
        System.out.println("x^3= " + Math.pow(x, 3));


        System.out.println("==== 실수형 a, b ====");
        System.out.println("a = " + a);
        System.out.println("b = " + b);
        System.out.println("a + b = " + (a + b));
        System.out.println("a - b = " + (a - b));
        System.out.println("a * b = " + (a * b));
        System.out.println("a / b = " + (a / b)); // 나눗셈의 결과
        System.out.println("a % b = " + (a % b));


        x = 10;
        // 증가, 감소 연산자
        System.out.println("==== 증감 연산자 ====");
        System.out.println("x++ = " + x++ + ' ' + x); // 후위 증가
        System.out.println("++x = " + ++x + ' ' + x); // 전위 증가
        System.out.println("x-- = " + x-- + ' ' + x); // 후위 감소
        System.out.println("--x = " + --x + ' ' + x); // 전위 감소

        // 산술적인 대입 연산자
        System.out.println("==== 산술적인 대입 연산자 ====");
        System.out.println(x); // 10
        System.out.println("x += 5 >> " + (x += 5)); // 15
        System.out.println("x -= 5 >> " + (x -= 5)); // 10
        System.out.println("x *= 5 >> " + (x *= 5)); // 50
        System.out.println("x /= 5 >> " + (x /= 5)); // 10
        System.out.println("x %= 5 >> " + (x %= 5)); // 0
        System.out.println(x);

        // 비교 연산자: 연산 결과 불리언(true/false)
        System.out.println("==== 비교 연산자 ====");
        System.out.println("a > b >> " + (a > b));
        System.out.println("a >= b >> " + (a >= b)); // > =
        System.out.println("a < b >> " + (a < b));
        System.out.println("a <= b >> " + (a <= b)); // < =
        System.out.println("a == b >> " + (a == b)); // = =
        System.out.println("a != b >> " + (a != b)); // ! =

        // 논리 연산자: 연산 결과 불리언(true/false)
        boolean j = true;
        boolean k = false;
        boolean l = true;
        System.out.println("==== 논리 연산자 ====");
        System.out.println("j && k >> " + (j && k)); // AND: j, k 모두 참이면 참
        System.out.println("j && l >> " + (j && l));
        System.out.println("j || k >> " + (j || k)); // OR: j, k 둘 중 하나라도 참이면 참
        System.out.println("!j >> " + (!j)); // NOT: 부정

        // 삼항 연산자
        System.out.println("==== 삼항 연산자 ====");
        System.out.println(x > y ? "x는 y보다 큼" : "x는 y보다 크지 않음");

        // 연산자 우선 순위
        // : 암묵적으로 연산자 우선 순위에 따라서 계산. 하지만 명시적으로 지정하고 싶다면, 괄호로 묶어 우선순위 지정 가능
        // https://www.devkuma.com/docs/java/operator/
    }
}
