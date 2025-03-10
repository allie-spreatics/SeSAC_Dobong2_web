package _05_class._c_final;

public class ConstEx {
    public static void main(String[] args) {
        System.out.println(Const.MAX_VALUE); // static final
        System.out.println(Const.GREETING); // static final

        // 상수는 값을 변경할 수 없기 때문에 아래와 같이 할당하려고 하면 오류 발생
        // Const.MAX_VALUE = 200; // 에러 발생!
        // Const.GREETING = "Hi"; // 에러 발생!

        // only static
        Const.MIN_VALUE = 10; // final 이 붙어있지 않으면 변경할 수 있음(not read only)
        System.out.println(Const.MIN_VALUE);

        // only final
        // System.out.println(Const.USER_NAME); // instance 없이 접근하려 하면 error
        Const c1 = new Const();
        System.out.println(c1.USER_NAME);
        // c1.USER_NAME="rr"; // final 변수 변경 불가
    }
}
