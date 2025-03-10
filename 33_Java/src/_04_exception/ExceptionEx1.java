package _04_exception;
// - Error (Error): 시스템에 비정상적인 상황이 발생한 경우
//   - 코드에 의해 수습할 수 없는 심각한 오류
//   - OutOfMemoryError(메모리 부족), ThreadDeath, StackOverflowError, ...

// 개발자는 예외 처리(exception handling)를 통해 언제나예외 상황을 처리하여 프로그램이 종료되는 일이 없록 코드의 흐름을 바꿀 필요가 있다.
// 출처: https://inpa.tistory.com/entry/JAVA-☕-에러Error-와-예외-클래스Exception-💯-총정리#논리_에러_logic_error [Inpa Dev 👨‍💻:티스토리]

// - 일반 예외 (Exception/checked exception): 컴파일러가 예외 처리 코드 여부를 검사하는 예외
//    - 확인시점: 컴파일 시점, 명시적으로 반드시 예외처리 해줘야 함
//    - IOException, FileNotFoundException

// - 실행 예외 (Runtime Exception/unchecked exception): 컴파일러가 예외 처리 코드 여부를 검사하지 않는 예외
//   - 확인시점: 런타임 시점, 예외처리 강제하지 않음
//   - NullPointerException

// https://chanhuiseok.github.io/posts/java-3/
// https://hahahoho5915.tistory.com/67

import java.util.InputMismatchException;
import java.util.Scanner;

// 예외 발생시 프로그램의 갑작스러운 종료를 막고 정상 실행이 될 수 있도록 try-catch-finally 를 통해서 "예외처리"를 해준다.
public class ExceptionEx1 {

    // 미리 함수를 몇 개 만들어놓습니다.
    // 1. 나누기 함수 - 0으로 나누는 경우 예외 발생
    public static String divide(int x, int y) {
        return x + " / " + y + " = " + (x / y);
    }

    // 2. 문자열의 길이 반환 함수 - 문자열이 아닌 null 에 length 를 거는 경우 예외 발생
    public static int getLength(String str) {
        return str.length();
    }

    // 3. 배열의 길이 반환 함수 - 배열의 길이보다 큰 인덱스에 접근하려고 할 때 예외 발생
    public static int getValueByIdx(int[] arr, int idx) {
        return arr[idx];
    }
    public static void main(String[] args) {
        System.out.println(divide(6, 2)); // 정상 작동
        // System.out.println(divide(6, 0)); // Exception (0으로 나누기)으로 코드 중단
        // System.out.println("여기까지 도착하나요?"); // Exception 발생으로 해당 부분 실행 안됨

        // ########## case1. 0으로 나누기 [ArithmeticException]
        try {
            System.out.println("나누기 연산 시작");
            System.out.println(divide(6, 0)); // Exception (0으로 나누기)으로 코드 중단 > catch로 이동
            System.out.println("나누기 연산이 잘 끝났나요?"); // 윗줄에서 exception 발생으로 해당 라인 출력 안됨.
        } catch (ArithmeticException e) { // js처럼 e만 쓴다고 에러가 받아지는게 아니고 어떤 에러인지 명시(에러의 종류 명시)
            System.out.println("나누기 중 에러 발생 >>" + e.getMessage()); // 방법1: 예외 발생한 이유만 보여줌
            // 출력: / by zero

            System.out.println("나누기 중 에러 발생 >>" + e.toString()); // 방법2: 예외 종류 리턴
            // 출력: java.lang.ArithmeticException: / by zero

            // e.printStackTrace(); // 방법3: 예외가 어디서 발생했는지 추적한 내용 출력
            // 출력:
            // java.lang.ArithmeticException: / by zero
            // at _04_exception.ExceptionEx.divide(ExceptionEx.java:25)
            // at _04_exception.ExceptionEx.main(ExceptionEx.java:44)
        } finally {
            System.out.println("나누기 연산 종료!\n\n");
        }

        // ########## case2. null 에 접근 [NullPointerException]
        // System.out.println("단어 길이: " + getLength(new String("Hello")));
        // System.out.println("단어 길이: " + getLength(null)); // 에러: NullPointerException
        try {
            System.out.println("단어의 길이: " + getLength(null));
        } catch (NullPointerException e) {
            // null 을 가진 객체에 접근하려고 할 때 발생하는 예외 (null.length 는 불가능하다.)
            System.out.println("단어 길이 연산 중 에러 발생>> " + e.getMessage());
            System.out.println("단어 길이 연산 중 에러 발생>> " + e.toString());
        }

        // ########## case3. index 값으로 배열 접근시 범위에 없는 값으로 접근 [NullPointerException]
        int[] numbers = {10, 20, 30, 40, 50}; // 해당 배열의 가장 끝 인덱스는 4
        System.out.println(getValueByIdx(numbers, 1)); // 20
        // System.out.println(getValueByIdx(numbers, numbers.length)); // 에러: ArrayIndexOutOfBoundsException

        try {
            System.out.println(getValueByIdx(numbers, numbers.length));
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("배열 인덱싱 중 에러 발생 >>" + e.getMessage());
            System.out.println("배열 인덱싱 중 에러 발생 >>" + e.toString());
        }

        // ########## case4. 입력 형식 오류 [InputMismatchException] - import 필요
        Scanner scan = new Scanner(System.in);
        try {
            System.out.print("정수를 입력하세요: "); // >> 정수가 아닌 "abc" 등의 문자열 입력하면 exception 발생
            int number = scan.nextInt(); // 정수만 입력받을 수 있음
            System.out.println("입력한 정수: " + number);
            // System.out.println("boolean 값을 입력하세요.");
            // boolean bool = scan.nextBoolean();
            // System.out.println("is it true?" + bool);
        } catch (InputMismatchException e) { // 해당 에러는 import 가 필요함.
            System.out.println("입력 형식 에러 발생: " + e.getMessage()); // null
            System.out.println("입력 형식 에러 발생: " + e.toString());
        }

    }
}
// 다양한 예외처리 사항 참고
// https://velog.io/@jollyn/Java-18-1
/*
* 1. catch 여러 개 이어서 쓰기 가능함 try{..} catch(){} catch(){} 
* 2. catch 문 하나에 error 여러 개 받는 것 가능함 try(예외1 | 예외2 e) {...}
*      - 예외 처리 구문이 비슷할 때
*      - 두 예외가 상속 관계에 있지 않을 때
* */