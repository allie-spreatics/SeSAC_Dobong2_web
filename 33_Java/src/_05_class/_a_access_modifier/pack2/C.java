package _05_class._a_access_modifier.pack2;

import _05_class._a_access_modifier.pack1.B;

public class C {

    public static void main(String[] args) {
        System.out.println("this is [C class] in [pack2]");
        // A apple; // Cannot resolve symbol 'A', import 를 해도 "default" 로 선언된 A 클래스에는 접근 불가
        
        // 다른 패키지에 있는 B 클래스이지만, import 를 한다면 접근 가능 ("public" 접근제한자)
        B banana;
    }
}
