package _01_basic_syntax;

public class DataTypes {
    public static void main(String[] args) {
        System.out.println("=== Primitive Type ===");

        int a = 11;
        long b = 10000; // long 타입은 뒤에 'L' 또는 'l'을 붙여야 함
        short c = 32767;
        byte d = 127;

        // 실수형 변수 선언
        float e = 3.14f; // float 타입은 뒤에 'f' 또는 'F'를 붙여야 함
        double f = 2.71828;

        // 문자형 변수 선언
        char ch = 'A';

        // 논리형 변수 선언
        boolean bool = true;

        // 변수 출력
        System.out.println("정수형 변수: " + a + ", " + b + ", " + c + ", " + d);
        System.out.println("실수형 변수: " + e + ", " + f);
        System.out.println("문자형 변수: " + ch);
        System.out.println("논리형 변수: " + bool);
        //        타입확인 getClass().getName 사용: null 에 사용하면 에러, primitive type에 사용 불가

        /////////////////////////////////////////////////////////////////////////
        // Reference Type(참조형)
        System.out.println("==== Reference Type ====");
        //        1. primitive 에도 있는 자료형
        //        굳이 필요한 경우가 아니라면 (generic, null 초기화의 경우) primitive 사용할 것
        Integer aa = 11;
        Long bb = 10L;
        Short cc = 30000;
        Byte dd = 127;
        Float ee = 3.141592f;
        Double ff = 2.7182888;
        Character chch = '@';
        Boolean boo = false;


        //        2. reference type에만 있는 자료형
        // String 참조형 변수 선언과 초기화
        // - Java 에서 String 타입은 특별함. 참조형이지만 기본형처럼 사용함. (불변(immutable) 객체-r.o)
        //     - https://mangkyu.tistory.com/131
        // - 기본 자료형은 "==" 연산자를 통해 비교하지만, String 객체간 비교는 .equals() 메서드 사용
        String greeting = "Hello, World!";


        // 배열 (Array) 참조형 변수 선언과 초기화
        int[] numbers = {1, 2, 3, 4, 5};

        // 클래스 (Class) 참조형 변수 선언과 초기화
        Person person = new Person("John Doe", 30);

        // 출력
        System.out.println("String 변수: " + greeting);

        // ver.1 일반 for 문
        System.out.print("배열 변수: ");
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i] + " ");
        }
        // ver.2 js의 for-of 문처럼 배열에 사용하는 반복문
        for (int num : numbers) {
            System.out.print(num + " ");
        }
        System.out.println("Person 객체: " + person.getName() + ", " + person.getAge() + " years old.");
    }
}

// 클래스 (추후 배울 예정)
class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
