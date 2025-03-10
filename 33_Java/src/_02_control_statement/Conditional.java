package _02_control_statement;

import java.util.Scanner;

public class Conditional {
    public static void main(String[] args) {
        // 기본 if ~ else 문
        int number = 10;
        if (number % 2 == 0) {
            System.out.println("짝수");
        } else {
            System.out.println("홀수");
        }

        // if ~ else if 문
        // - top down 방식으로 처음 조건 식이 참으로 평가되면 해당 식 수행 후, if 절 빠져나감
        if (number % 3 == 0) {
            System.out.println("3의 배수");
        } else if (number % 5 == 0) {
            System.out.println("5의 배수");
        } else {
            System.out.println("3의 배수도 5의 배수도 아님");
        }

        // switch ~ case 문
        // - 각 case 문의 break 문은 선택 사항으로 break 문 생략시 바로 밑의 case 문으로 넘어감. 
        //   (여러 case 문으로 하나의 시행문 지정 가능)
        String dayOfWeek;
        int day = 4; // or 4

        switch (day) {
            case 1:
                dayOfWeek = "일요일";
                break;
            case 2:
                dayOfWeek = "월요일";
                break;
            case 3:
                dayOfWeek = "화요일";
                break;
            case 4:
            case 5:
            case 6:
            case 7:
                dayOfWeek = "수~일요일";
                break;
            default:
                dayOfWeek = "잘못된 입력입니다.";
                break;
        }
        System.out.println(dayOfWeek + " 입니다.");

        ////////////String 비교해보기//////////////
        // js 에서는? "hello" == "hello" >> true!
        // Java 에서는 문자열 비교시 연산자가 아닌 equals 메소드를 통해서 비교

        System.out.println("이름을 입력해주세요.");
        Scanner scan = new Scanner(System.in);
        String name = scan.nextLine();
        scan.close(); // 다쓰고 닫아주기

        System.out.println("name 확인: " + name);

        //  BAD
       /*  System.out.println(name == "allie"); // false
        if (name == "allie") {
            System.out.println("allie 님 환영합니다.");
        } else {
            System.out.println("이름을 다시 확인해주세요");
        } */

        // GOOD~ string type 비교할 땐 String1.equals(String2) 사용,
        if (name.equals("allie")) {
            System.out.println("allie 입니다.");
        } else {
            System.out.println("이름을 다시 확인해주세요.");
        }

        // == 는 왜 안될까요?
        /* == 연산자는 두 객체의 값을 비교하는 것이 아닌 "주소"를 비교함(동일한 메모리 위치인지)
        .equals 는 두 객체의 "내용"이 동일한지 비교 */
        String str1 = "hello, world";
        String str2 = "hello, world"; // 문자열 리터럴
        // -> 총 두 개의 스트링객체가 생기는 것
        /* "문자열 리터럴"의 경우, Java 에서 특별한 취급.
        동일한 문자열 리터럴이 사용될 경우, Java 컴파일러는 string pool 이라는 공유된 메모리 영역에 문자열 저장
        즉, str1 과 str2가 같은 문자열이므로 공유된 메모리 영역에 문자열 저장.
        따라서 '==' 연산자 비교시 true
         */
        String str3 = new String("hello, world"); // 문자열 객체
        String str4 = new String("hello, world");
        /* 문자열 객체의 경우, `new String(...)`을 사용해 새로운 문자열 객체를 생성하므로 서로 다른 객체를 가리킴
        즉, str3과 str4가 다른 객체이므로 `==` 연사자로 비교시 false.
        따라서 문자열을 비교할 때는 `.equals()` 메서드로 비교하는 것이 바람직
         참고: new 를 이용한 객체 생성(동적할당)의 경우, 힙 메모리 영역에 저장됨
         */
        if (str1 == str2) {
            // 값을 비교하는 것이 아닌 주소를 비교하는데,
            // str1 과 str2는 string pool 이라는 공유된 메모리 영역에 저장되어 있음
            System.out.println("같은 참조를 가리킵니다."); // 출력
        } else {
            System.out.println("서로 다른 참조를 가리킵니다.");
        }

        if (str1.equals(str2)) {
            System.out.println("내용이 같습니다."); // 출력
        } else {
            System.out.println("내용이 다릅니다.");
        }


        if (str3 == str4) {
            // 문자열 리터럴이 아닌 문자열 객체의 경우
            // 다른 주소를 가지고 있어서 else 로 빠짐
            System.out.println("같은 참조를 가리킵니다.");
        } else {
            System.out.println("서로 다른 참조를 가리킵니다."); // 출력
        }

        if (str3.equals(str4)) {
            System.out.println("내용이 같습니다."); // 출력
        } else {
            System.out.println("내용이 다릅니다.");
        }
        System.out.println(str1 == str2); // true
        System.out.println(str1 == str3); // false
    }
}
