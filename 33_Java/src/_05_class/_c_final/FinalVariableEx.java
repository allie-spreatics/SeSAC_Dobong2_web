package _05_class._c_final;

public class FinalVariableEx {
    public static void main(String[] args) {
        final int finalNumber = 10; // final 변수 선언 및 초기화

        // 초기화된 값을 변경하려고 하면 컴파일 오류 발생
        // finalNumber = 20; // 에러 발생!

        // final 변수는 읽기 전용이기 때문에 값을 사용할 수는 있습니다.
        System.out.println("Final Number: " + finalNumber);
    }
}
