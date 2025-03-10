package _05_class._c_final;

public class FinalUpgrade {
    public static void main(String[] args) {

    }
    // 1. 클래스 선언 후 final 메소드 생성
    class ClassWithFinalMethod {
        // final 메서드 선언
        final void showMessage() {
            System.out.println("final 이 붙은 이 메소드는 오버라이딩 할 수 없습니다!!");
        }
    }

    // 2. 상속받아서 메소드 오버라이딩 해보기
    class SubClass extends ClassWithFinalMethod {
        //  메소드 재정의
        // void showMessage() {} // final 키워드가 붙은 메소드의 경우 오버라이딩 불가(메소드 재정의 불가)
    }


    //=========== 클래스에 final 사용할 수 있음 ========
    final class FinalClassEx1 {
    }

// compile error! > final 붙어있는 클래스는 상속 불가
// class SubClass2 extends FinalClassEx1 {
// }

}
