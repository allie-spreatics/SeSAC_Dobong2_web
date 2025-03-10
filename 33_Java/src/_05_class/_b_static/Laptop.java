package _05_class._b_static;

public class Laptop {
    static String company = "LG"; // 클래스 변수의 명시적 초기화
    static String model = "Gram";
    // static String info = company + " " + model;
    static String info;

    static {
        // 초기화를 여기에서 할 수도 있다.
        // why?
        /*
         * - 복잡한 초기화를 하고 싶을 때,
         * - 초기화 하는 순서를 제어하고 싶을 때, 등
         *  */
        if (true) {
            info = company + " " + model;
        } else {
            info = "(not LG)> " + model;
        }
    }
}
