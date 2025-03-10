package _05_class._a_access_modifier.pack5;

// 참고~~~
public class SingletonEx {
    public static void main(String[] args) {
        // Singleton s1 = new Singleton(); // 생성자가 private, 생성자에 접근 불가 > 생성자를 통해서 인스턴스 생성할 수 없음

        // 그렇다면.???
        // public 에 있는 getInstance() method를 통해서 만들어진 인스턴스 반환 가능
        // 인스턴스를 만들지 않아도 static 선언되어 있는 getInstance()는 바로 접근 가능
        Singleton s2 = Singleton.getInstance();
        Singleton s3 = Singleton.getInstance();

        if(s2 == s3){
            System.out.println("같은 Singleton 객체");
            System.out.println(s2);
            System.out.println(s3);
        }else{
            System.out.println("다른 Singleton 객체");
        }

        /*
        * 언제 쓰나요?
          - 어떤 클래스의 인스턴스가 시스템 전반에 걸쳐 하나만 존재해야 하는 경우
          - 애플리케이션의 설정을 관리하는 클래스에서 사용하면, 어디에서든 해당 설정에 접근해서 수정할 수 있음
          - 싱글턴 패턴을 사용하면 다른 객체들이 해당 인스턴스에 쉽게 접근하여 의존성을 관리할 수 있음.
        * */
    }
}
