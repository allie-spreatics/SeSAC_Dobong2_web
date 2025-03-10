package _03_array;

/*
  js 애서 제공하는 여러개의 데이터를 담아두는 자료 구조가 배열과 객체(object) 가 있었지만
  java 에서는 객체를 효율적으로 추가, 삭제, 검색할 수 있도록 관련 인터페이스 & 클래스를 java.util 에 포함 시켜 놓음 == collection
 *  */

// [Java 의 Collection]
// ㄴ List
//   ㄴ ArrayList
//   ㄴ Vector
//   ㄴ LinkedList
// ㄴ Set
//   ㄴ HashSet
//   ㄴ TreeSet
// Map
// ㄴ HashMap
// ㄴ Hashtable
// ㄴ TreeMap
// ㄴ Properties

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 많은 컬렉션 중에 아래는 어레이리스트 클래스에 대한 내용
/*
* ArrayList class?!
* - List Collection 에서 가장 많이 사용되는 컬렉션
* - 표준 배열보다는 느리지만, 많은 조작이 필요한 경우 배열보다 유용함
* - 표준 배열과 달리 크기를 미리 지정하지 않아도 됨
*   - 표준배열은 정적할당, ArrayList 는 동적할당 (동적으로 크기가 변경)
* */
public class ArrayListEx {
    public static void main(String[] args) {
        // 제네릭 이용하여 ArrayList 선언
        // List<E> list = new ArrayList<E>(); // E에 지정된 타입의 객체만 저장 가능
        // List<E> list = new ArrayList<>(); // E에 지정된 타입의 객체만 저장
        // List list = new ArrayList(); // 모든 타입의 객체 저장

        // 1. ArrayList 생성 (정수형 요소를 저장하는 예제)
        // <generic> 에는 타입이 들어가는데 [primitive type] 은 들어가지 못함
        // int, double, .. 이더라도 [reference type] 으로 <generic> 을 할당해줘야 합니다.
        List<Integer> numbers = new ArrayList<>(); // List 와 ArrayList 클래스 import!!!!

        System.out.println(numbers); // [] 빈배열, 표준 배열처럼 Arrays.toString 사용하지 않아도 돼요.

        // 참고) Arrays.toString(배열) 메서드는 "배열"을 인자로 받음.
        // 따라서 numbers 는 ArrayList 이므로 toArray()를 이용해 배열 변환 필요
        System.out.println(Arrays.toString(numbers.toArray())); // 출력: [10, 77, 30, 40, 50]

        // isEmpty()사용해보기
        System.out.println("isEmpty? " + numbers.isEmpty()); // true, 빈배열
        // 2. 요소 추가
        numbers.add(10); // [10]
        numbers.add(20); // [10, 20]
        numbers.add(30); // [10, 20, 30]
        numbers.add(40);
        numbers.add(50);
        System.out.println(numbers); // [10,20,30,40,50]
        System.out.println("isEmpty? " + numbers.isEmpty()); // false
        System.out.println("contains 사용: " + numbers.contains(10)); // true
        System.out.println("contains 사용: " + numbers.contains(11)); // false

        // 3. 요소 접근 get()
        // System.out.println(numbers[0]); // 표준 배열과 달리, ArrayList 에는 이렇게 접근 안돼요.
        System.out.println("첫번째 요소: " + numbers.get(0)); // 출력: 10

        // 4. 요소 수정 set()
        numbers.set(1, 77); // 1번 인덱스 77로 변경
        System.out.println(numbers);

        // 5. 요소 삽입(끝이 아닌 중간에 요소 삽입)
        numbers.add(1, 7); // 1번 인덱스에 요소 삽입되고 나머지는 뒤로 한 칸씩 밀림
        System.out.println(Arrays.toString(numbers.toArray())); // 출력: [10, 7, 77, 30, 40, 50]
    }
}
