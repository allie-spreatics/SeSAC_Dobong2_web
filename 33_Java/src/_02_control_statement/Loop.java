package _02_control_statement;

import java.util.ArrayList;
import java.util.List;

public class Loop {
    public static void main(String[] args) {
        // 기본 for 문
        for (int i = 1; i <= 10; i++) {
            System.out.println(i);
        }

        // while 문
        // - 조건식이 참일 동안 while 블럭 실행
        System.out.println("===========");
        int i = 1;
        while (i <= 10) {
            System.out.println(i);
            i++;
        }

        // do - while 문
        // - 적어도 한 번은 수행되는 반복문
        // - while 문과 다르게 조건식이 뒤에 배치
        System.out.println("===========");
        int j = 1;
        do {
            System.out.println(j); // 일단 do 이후 실행하고
            j++;
        } while (j <= 10); // 조건 검사는 나중에


        /////////////////////////////////////////////////////////////////////
        // for ~ each 문 (배열은 추후 배울 예정)
        // - collection type 데이터에서 데이터가 존재하는 횟수만큼 반복 실행
        // * collection type: 데이터 저장하고 관리하는 자료구조를 제공하는 클래스 모음
        // ex. List, Set, Map, Stack, Vector 등
        System.out.println("===========");
        String[] array = {"A", "B", "C"}; // 배열

        for (String a : array) {
            System.out.println("a=" + a);
        }

        // arrayList 라는 자료구조 선언하는 방법, 자세한 것은 나중에~
        List<String> list = new ArrayList<>(); // 리스트 中 arraylist
        list.add("A"); // list 에 추가하는 법
        list.add("B");
        list.add("C");
        for (String l : list) {
            System.out.println("l=" + l);
        }

        // forEach with lamda (람다? 익명함수!) : ()-> {}의 꼴.자스의 ()=>{}처럼,
        list.forEach(data -> System.out.println("data: " + data));
        list.forEach(data -> {
            System.out.print("data: ");
            System.out.println(data);
        });
    }
}
