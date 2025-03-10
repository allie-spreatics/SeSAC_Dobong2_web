package _05_class._a_access_modifier.pack5;

public class Person {
    // 필드는 보통 private 으로,
    private int age;
    private String name;

    // constructor, 생성자
    public Person(String name){
        this.name = name; // 생성하면서 name 만 초기화, age 는 setter 로 추후에 초기화
    }

    // 필드에 직접 접근할 수 없기 때문에
    // 접근을 도와주는 getter 함수와 setter 함수를 선언해서 사용
    
    // ---- getter ----
    public String getName(){
        return name;
    }
    
    public int getAge(){
        return age;
    }
    
    // ---- setter ----
    public void setName (String name){
        this.name=name; // this.name 은 필드, name 은 setName 메소드로 들어오는 인자
    }

    public void setAge (int age){
        // setter 함수를 사용함으로써 필드에 이상한 값이 들어올 수 없도록 제어 가능하다.
        // 함수기 때문에 로직 작성 가능!
        if(age < 0){
            // '나이' 필드에 음수가 들어오려고 하면 0으로 초기화
            this.age=0;
            return;
        }else{
            this.age = age;
        }
    }
}
