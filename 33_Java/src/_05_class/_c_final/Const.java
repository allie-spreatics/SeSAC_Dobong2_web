package _05_class._c_final;

public class Const {
    // 정수형 상수 선언
    public static final int MAX_VALUE = 100;

    // 문자열 상수 선언
    public static final String GREETING = "Hello, World!";

    // only static
    // 수정 가능
    static int MIN_VALUE = 0;

    // only final
    // 인스턴스에 속해있는 변수 > 인스턴스 생성 후 사용할 수 있는 필드
    final String USER_NAME = "allie";
}
