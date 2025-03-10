package _05_class._a_access_modifier.pack5;

public class PersonEx {
    // Person 클래스 사용해보기.
    public static void main(String[] args) {
        Person p1 = new Person("pooh");
        Person p2 = new Person("eeyore");

        System.out.println(p1.getAge()); // 0, int 이기 때문에 생성자를 통해서 설정하지 않아도 0 으로 초기화 되어 있음
        // p1.age = 5; // age 필드는 private 이기 때문에 직접 접근해서 변경할 수 없음 >> 변경시 setter 사용
        p1.setAge(5); // 변경 가능!
        System.out.println(p1.getName() + "의 나이: " + p1.getAge()); // 푸의 나이: 5
        p2.setAge(-5); // 악의적으로(?) 음수값 나이로 설정했을 때는 음수 설정 불가능하도록 setter 에 처리가 되어 있음 >> 0
        System.out.printf("%s의 나이: %d", p2.getName(), p2.getAge()); // 이요르의 나이: 0


    }
}
