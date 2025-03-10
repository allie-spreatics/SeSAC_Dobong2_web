package _01_basic_syntax;
import java.util.Scanner; // Scanner 사용시 import 필수

public class InputOutput {
    public static void main(String[] args) {
        // 출력
        System.out.print("안녕하세요.. \n"); // 다음줄로 이동
        System.out.print("제 이름은 allie 입니다. \t"); // 탭
        System.out.println("잘부탁드립니다."); // \n 포함
        System.out.println("^^");

        // 입력
        // Scanner 사용시 import 필요
        Scanner scan = new Scanner(System.in);
        System.out.println("공백으로 구분하여, 이름/나이/키/결혼여부를 입력해주세요.");
        String name = scan.next();
        int age = scan.nextInt();
        System.out.println(name);

        double height = scan.nextDouble();
        boolean single = scan.nextBoolean();

        System.out.println("====입력 결과 출력====");
        System.out.println("이름: " + name);
        System.out.println("나이: " + age);
        System.out.println("키: " + height);
        System.out.println("결혼 여부: " + single);


        // nextLine() 사용
        // scanner 2개 쓴 이유: https://ontheway.tistory.com/65, next가 먼저 있을 때 버퍼에 \n이 저장된 상태.
        // Scanner scan2 = new Scanner(System.in);
        // System.out.println("자기 소개 한 마디");
        // String introduce = scan2.nextLine();
        // System.out.println(name + "소개입니다." + introduce);
        // scan2.close();
        scan.close(); // scanner 닫기
    }
}
