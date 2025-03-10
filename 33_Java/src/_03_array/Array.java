package _03_array;

import java.util.Arrays; // Arrays.toString() 사용을 위해 import
import java.util.Collections;

public class Array {
    public static void main(String[] args) {
        // 배열 변수 선언
        // - 두 가지 방법이 있으나 관례적으로 첫 번째 방법 사용
        // 1. 타입[] 변수;
        // 2. 타입 변수[];
        int[] arr1;
        int arr2[];

        // - 배열 변수는 "참조 변수". 배열도 객체이므로 힙 영역에 생성되고,
        //   배열 변수는 힙 영역의 배열 주소를 저장.  따라서 참조할 배열이 없다면 null 로 초기화 가능
        // ex. 타입[] 변수 = null;
        // - 단, 배열 변수가 null 값을 가진 상태에서 변수[인덱스] 로 값을 읽거나 저장하게 되면 NullPointerException 발생()
        String[] temp = null;
        // System.out.println(temp[0]); // exception
        System.out.println(temp); // null

        int[] intArray = {10, 22, 25, 44, 55};
        System.out.println("intArray[0]" + intArray[0]);
        System.out.println("intArray" + intArray);
        intArray[1] = 20; // 값 변경
        System.out.println(Arrays.toString(intArray)); // arr to string, 실제로 변경됨


        char[] charArray;
        // charArray = {'A', 'a'}; // compile error, 선언시 초기화를 안했을 때.
        charArray = new char[]{'a', 'A', '2', 66};
        System.out.println(charArray[2]);
        System.out.println(charArray[3]); // B, ascii code, 저장된 값은 숫자 66이 아닌 아스키코드값.
        // ASCII code? (영문)키보드로 입력할 수 있는 모든 기호들이 숫자 하나에 할당 되어 있는 부호체계,
        // 한글도 되어 있다. 예> 50976, 51652, 54805 = 유진형


        //     ----- new 연산자로 배열 생성
        double[] doubleArray = new double[3]; // 개수까지 할당
        System.out.println("new 연자로 초기화된 값: " + doubleArray[0]); // 0.0으로 모두 다 초기화됨
        // https://hongong.hanbit.co.kr/java-%EC%9E%90%EB%B0%94-%EB%B0%B0%EC%97%B4array-%EC%84%A0%EC%96%B8%ED%95%98%EA%B3%A0-%EC%83%9D%EC%84%B1%ED%95%98%EA%B8%B0/
        doubleArray[0] = 0.1;
        doubleArray[1] = 2.4;
        doubleArray[2] = 1.8;
        System.out.println("doubleArray[0]: " + doubleArray[0]);
        System.out.println("doubleArray[1]: " + doubleArray[1]);
        System.out.println("doubleArray[2]: " + doubleArray[2]);


        // length
        System.out.println("doubleArray 배열 길이: " + doubleArray.length);
        // Arrays.toString(): 배열 내용을 문자열로 변환, toString 구현부 가서 문자열임을 확인시키기
        System.out.println("배열 내용 보고싶다면, " + Arrays.toString(doubleArray));
        // 배열의 길이를 벗어난 index 를 보려고하면?
        // System.out.println(doubleArray[doubleArray.length]); // .ArrayIndexOutOfBoundsException

        /////////////////////
        // 다차원 배열
        // 2X3 배열 생성 및 초기화
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}};

        // 3X2 배열 생성 및 초기화
        int[][] matrix2 = new int[3][2];
        matrix2[0][0] = 1;
        matrix2[0][1] = 2;
        matrix2[1][0] = 3;
        matrix2[1][1] = 4;
        matrix2[2][0] = 5;
        matrix2[2][1] = 6;

        // 3차원 배열 생성 및 초기화
        int[][][] threeDimensionalArray = {{{1, 2}, {3, 4}}, {{5, 6}, {7, 8}}};

        System.out.println("matrix:");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("\nmatrix2:");
        for (int i = 0; i < matrix2.length; i++) {
            for (int j = 0; j < matrix2[i].length; j++) {
                System.out.print(matrix2[i][j] + " ");
            }
            System.out.println();
        }

        // 3차원 배열의 값 출력
        System.out.println("\nmatrix3:");
        for (int i = 0; i < threeDimensionalArray.length; i++) {
            for (int j = 0; j < threeDimensionalArray[i].length; j++) {
                for (int k = 0; k < threeDimensionalArray[i][j].length; k++) {
                    System.out.print(threeDimensionalArray[i][j][k] + " ");
                }
                System.out.println();
            }
            System.out.println();
        }
        /////////////////////////////////////////////////////////////////////////
        // 객체를 참조하는 배열
        // - 기본 타입 배열은 각 항목에 값을 직접 저장
        // - 참조 타입 (클래스, 인터페이스) 배열은 각 항목에 객체의 번지를 저장
        String[] langs = new String[3];
        langs[0] = "Java";
        langs[1] = "Java";
        langs[2] = new String("Java");

        System.out.println(langs[0] == langs[1]); // 같은 객체 참조, true (리터럴 스트링)
        System.out.println(langs[1] == langs[2]); // 다른 객체 참조, false (리터럴과 객체)
        System.out.println(langs[0].equals(langs[2])); // 문자열이 동일, true (값비교)
        System.out.println();

        /////////////////////////////////////////////////////////////////////////
        // 배열 복사
        // - 배열은 초기화/선언과 동시에 크기가 고정됨
        // -> 더 많은 저장 공간 필요하다면 더 큰 길이의 배열을 "새로" 만들어 기존 배열을 "복사"해야 함

        // ver1. for문으로 요소를 하나씩 복사
        int[] originArray = {1, 2, 3}; // 기존 배열, length =5
        int[] newArray = new int[5]; // 배열의 크기를 키우기 위해, 새로운 배열 선언,
        System.out.println(Arrays.toString(newArray));// newArray는 모두 0으로 초기화되어있음
        for (int i = 0; i < originArray.length; i++) {
            newArray[i] = originArray[i];
        }
        System.out.println(Arrays.toString(newArray));// 복사후 결과: [1,2,3,0,0]

        // ver2. arrayCopy() 메소드 사용
        // : System.arrayCopy(Object src, int srcPos, Object dest, int destPos, int length);
        /*
         * Object src: 원본 배열
         * int srcPos: 원본배열 복사 시작 인덱스
         * Object dest: 새로운 배열
         * int destPos: 새 배열 붙여넣기 시작 인덱스
         * int length: 복사 항목 수
         *  */
        String[] originFruits = {"apple", "banana", "coconut"};
        String[] newFruits = new String[5];
        System.out.println(Arrays.toString(newFruits)); //[null, null, null, null, null]
        //    System.arraycopy(originFruits, 0, newFruits, 1, originFruits.length - 1);
        System.arraycopy(originFruits, 1, newFruits, 0, originFruits.length - 1);
        // 복사시작: originFruits 의 index1번("banana")부터,
        // 붙여넣기 시작: newFruits[0] 부터 붙여넣기
        // length: 복사 시작이 1번부터이기 때문에, 최대 복사개수는 length - 1 (2개)
        System.out.println(Arrays.toString(originFruits)); // [banana, coconut, null, null, null]
        System.out.println(Arrays.toString(newFruits));

        /////////////////////////////////////////////////////////////////////////
        /* array built in method~! */
        // 1. Arrays.copyOf(): 처음~배열의 길이 기준으로 배열 복사,
        // Arrays.copyOf() 구현부에 가보면 알겠지만 System.arraycopy 기반으로 만들어져 있음
        // - 원본 배열의 처음부터, 지정한 길이만큼 복사해옴.
        int[] originArr = {1, 2, 3, 4, 5};
        int[] copiedArray = Arrays.copyOf(originArr, 3); // [1,2,3]
        int[] copiedArray2 = Arrays.copyOf(originArr, 6); // [1,2,3,4,5,0] (원본 길이 넘는 요소에 대해서는 기본값으로 채워짐)
        System.out.println("copiedArray>> " + Arrays.toString(copiedArray));
        System.out.println("copiedArray2>> " + Arrays.toString(copiedArray2));

        // 2. Arrays.copyOfRange(arr, sIdx, eIdx): 인덱스범위를 기준으로 배열 복사
        // Arrays.copyOf와 마찬가지로 System.arraycopy 를 이용해서 구현되어 잇음
        int[] rangeArray = Arrays.copyOfRange(originArr, 1, 4); // startIndex <=copied <endIndex
        System.out.println("Range Array: " + Arrays.toString(rangeArray)); // [2,3,4]

        // 3. Arrays.fill(arr, val): arr 의 모든 요소를 val 로 채운다.
        int[] filledArray = new int[5];
        System.out.println("Filled Array (before): " + Arrays.toString(filledArray)); // 출력: [0, 0, 0, 0, 0]
        Arrays.fill(filledArray, 7); // 배열의 요소 모두 7로 채우기
        System.out.println("Filled Array (after): " + Arrays.toString(filledArray));

        // 4. Arrays.sort(arr): arr 오름차순 정렬
        int[] unsortedArray = {5, 3, 1, 4, 2};
        Arrays.sort(unsortedArray); // 실제 배열이 바뀐다.
        System.out.println("sorted array: " + Arrays.toString(unsortedArray));

        // **** 내림차순 정렬하고 싶다면?
        // 주의) int 타입이 아닌 Integer 타입 (no primitive)
        Integer[] intArr1 = new Integer[]{5, 6, 10, 0, 2};
        Integer[] intArr2 = new Integer[]{5, 6, 10, 0, 2};

        // (1) Collections.reverseOrder() 사용: Collections 임포트 필요
        Arrays.sort(intArr1, Collections.reverseOrder());

        // (2) 람다식 이용
        Arrays.sort(intArr2, (a, b) -> b - a);

        // 둘 다 내림차순 정렬됐는지 확인하기
        System.out.println("intArr1: " + Arrays.toString(intArr1));
        System.out.println("intArr2: " + Arrays.toString(intArr2));
        /*
        ==> (1),(2) 방법 모두 reference type 의 배열에서만 가능함(Integer 는 가능, int 는 불가능)
        - primitive type 배열은 Object 클래스를 상속하는 Wrapper 클래스로 Boxing 해준 뒤
          Collections.reverseOrder() 메서드를 사용할 수 있다.
        */


        // 5. Arrays.equals(arr1, arr2)
        // 배열의 주소가 아닌 배열의 순서에 대한 값이 일치하는지 검사
        int[] array1 = {1, 2, 3};
        int[] array2 = {1, 2, 3};
        int[] array3 = {4, 2, 3};
        boolean arraysEqual = Arrays.equals(array1, array2);
        boolean arraysEqual2 = Arrays.equals(array1, array3);
        System.out.println("Arrays Equal (1 vs 2): " + arraysEqual); // 출력: true
        System.out.println("Arrays Equal (1 vs 3): " + arraysEqual2); // 출력: false
        // == 비교
        System.out.println("Arrays == (1 vs 2): " + (array1 == array2)); // 출력: false
        System.out.println("Arrays == (1 vs 3): " + (array1 == array3)); // 출력: false

        // 6. Arrays.deepEquals(arr1, arr2)
        // vs. Arrays.equals?
        // 배열의 요소가 값으로 비교할 수 있는게 아닌 주소로 비교해야 한다면?
        int[][] deepArray1 = {{1, 2}, {3, 4}};
        int[][] deepArray2 = {{1, 2}, {3, 4}};
        int[][] deepArray3 = {{1, 2}, {3, 5}};

        // false, 내용은 같지만 배열의 요소가 배열(주소로 비교하는), false
        System.out.println("2차원 배열 비교(Equals): " + Arrays.equals(deepArray1, deepArray2));

        // 깊은 비교.. true, 배열 안에 주소값으로 비교가 들어가야한다면 deepEquals 사용
        System.out.println("2차원 배열 비교(deepEquals): " + Arrays.deepEquals(deepArray1, deepArray2));

        // 내용다름. false
        System.out.println("2차원 배열 비교(deepEquals): " + Arrays.deepEquals(deepArray1, deepArray3));

        // 7. binarySearch(arr, val) 메소드 예제 (단, 배열은 정렬된 상태여야 함)
        // 정렬된 배열에서 요소를 검색해주는 메소드, 오름차순/내림차순 상관없음
        int[] sortedArray = {10, 30, 50, 70, 90, 99, 102};
        int index = Arrays.binarySearch(sortedArray, 50); // 2
        int index2 = Arrays.binarySearch(sortedArray, 60);
        System.out.println("Index of 50: " + index); // 출력: 2
        System.out.println("Index of 60: " + index2); // 출력: -4, (-4로 정해진게 아니고 검색 결과가 없다면 무작위의 음수값 반환)
    }
}
