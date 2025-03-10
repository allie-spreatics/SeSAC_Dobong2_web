package _05_class._a_access_modifier.pack1;

public class B {
    public static void main(String[] args) {
        System.out.println("this is [B class] in [pack1]");
        A instanceA = new A(); // 같은 패키지 안에 있는 A 클래스에 접근해서 인스턴스 생성 가능
        instanceA.printA(); // default 로 구현되어있는 printA() 메소드에 접근 가능
    }
}
