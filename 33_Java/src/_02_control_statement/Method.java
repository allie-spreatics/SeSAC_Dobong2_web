package _02_control_statement;

import java.util.Arrays;

// method: 객체가 갖는 기능?
// 정의 방법
/*
[접근제한자] [return type] 함수이름(인자1, 인자2, ..){
    return 반환값; // 함수의 리턴타입이 void 일 경우 리턴 생략 가능
}
 */
public class Method {

    // 가장 기본이 되는 main 도 함수
    public static void main(String[] args) {
        hello();
        System.out.print("sum1: ");
        System.out.println(sum1(1, 2));
        System.out.print("connect: ");
        System.out.println(connect("안녕", "하세요."));
        System.out.println();


        int number = 10; // primitive type
        int[] numbers = {10, 20}; // reference type
        int[] numbers2 = {10, 20, 30, 40};

        // === call by value
        System.out.println("=== call by value ===");
        System.out.println("함수 들어가기 전 value: " + number);
        System.out.println("함수의 리턴값: " + multi10(number));
        System.out.println("함수를 거치고난 후 value: " + number); // 실제 값 변경x

        // === call by address
        System.out.println("=== call by address===");
        // 리턴 타입 주소 확인
        System.out.println(numbers); // 이상한 문자열, 배열의 모양이 아닌 저장되어 있는 위치가 찍힘
        //  System.out.println(multi10_2(numbers)); // 함수의 return 은 numbers! 같은 주소값 저장되어 있음.

        // 실행후 결과 확인
        // (Arrays 임포트 해야합니다) Arrays.toString(배열) : 배열의 모습을 보기 위해서
        System.out.println("함수 들어가기 전 value: " + Arrays.toString(numbers2)); // [10, 20]
        System.out.println("함수의 리턴값: " + Arrays.toString(multi10_2(numbers2))); // [100, 200]
        System.out.println("함수를 거치고난 후 value: " + Arrays.toString(numbers2)); // 실제 값 변경됨

        // 똑같은 값 넘겨줘도 다른 주소.
        System.out.println(multi10_2(new int[]{10, 20})); // [I@6d03e736
        System.out.println(multi10_2(new int[]{10, 20})); // [I@568db2f2
    }

    // static 안붙이고 함수만들어도 괜찮지만
    // 일단 붙여서 만들어보세요. static 의 의미는 나중에 ~

    // 반환값이 없는 메서드: void
    public static void hello() {
        System.out.println("hello hello");
    }

    // 반환값이 있는 메서드
    // 함수의 리턴타입과 실제 리턴해주는 타입이 일치해야 함
    public static int sum1(int x, int y) {
        return x + y; // int
    }

    public static String connect(String a, String b) {
        return a + b;
    }

    // call by value
    // - primitive 타입을 함수의 인자로 전달
    // - 실제 값을 함수로 전달하는 것으로 원래의 값은 변경x

    // call by address
    // - reference 타입을 함수의 인자로 전달
    // - 변수가 저장되어있는 주소를 전달, 함수내부에서 전달된 변수를 바꾸는 부분이 있다면 원래의 값도 같이 변경
    //   - 같은 주소를 참조하고 있으므로.


    // ref. https://inpa.tistory.com/entry/JAVA-%E2%98%95-%EC%9E%90%EB%B0%94%EB%8A%94-Call-by-reference-%EA%B0%9C%EB%85%90%EC%9D%B4-%EC%97%86%EB%8B%A4-%E2%9D%93
    // call by value (값 전달)
    // stack frame: return value, int x, int y
    public static int multi10(int x) {
        x = x * 10;
        return x;
    }

    // call by address (주소 전달)
    // stack frame: int[] numbers, int mul, int n?
    public static int[] multi10_2(int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = numbers[i] * 10;
        }
        return numbers;
    }
}
