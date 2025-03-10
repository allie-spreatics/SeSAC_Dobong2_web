package _05_class._a_access_modifier.pack5;

// 참고~~~
public class Singleton {
    private static Singleton singleton = new Singleton(); // Singleton 클래스 내부에서 Singleton 인스턴스 생성,
    // Singleton() 생성자는 private 이기 때문에 내부에서만 선언 가능
    
    // private 생성자 > 외부에서 사용 불가
    private Singleton(){}

    public static Singleton getInstance(){
        return singleton; // 만들어진 Singleton 의 인스턴스 singleton 객체 반환
    }

    public void say(){
        System.out.println("hi~~ singleton ~~");
    }
}
