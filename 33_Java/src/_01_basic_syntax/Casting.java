package _01_basic_syntax;

public class Casting {
    public static void main(String[] args) {
        // 1. 묵시적 형변환 (Wider Conversion)
        // - 더 작은 타입에서 더 큰 타입으로의 자동 형변환
        // - 반대의 경우는 묵시적 형변환 불가능 -> 명시적으로 변환해야 함
        int smallNumber = 10;
        double bigNumber = smallNumber; // int > double 자동 형변환
        System.out.println("bigNumber: " + bigNumber); // 10.0


        // 2. 명시적 형변환
        // - 더 큰 타입에서 더 작은 타입으로의 강제 형변환
        double anotherBigNumber = 20.5;
        int anotherSmallNumber = (int) anotherBigNumber; // double을 int로 강제 형변환

        System.out.println("anotherBigNumber: " + anotherBigNumber); // 20.5 (double)
        System.out.println("anotherSmallNumber: " + anotherSmallNumber); // 20 (double > int)

        // 데이터 손실이 발생할 수 있는 경우 주의해야 함
        int largeNumber = 1000;
        byte smallByte = (byte) largeNumber; // int를 byte로 강제 형변환

        System.out.println("largeNumber: " + largeNumber); // 1000 (int)
        System.out.println("smallByte: " + smallByte); // -24 (int > byte) 데이터 유실됨
    }
}
