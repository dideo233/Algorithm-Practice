package reviewing.step2.sec09polymorphism.example.mono;

/**
 * 다형성 미적용 예제
 */
public class AnimalMonoEx {

    public static void main(String[] args) {
        Dog dog = new Dog();
        Cat cat = new Cat();
        Cow cow = new Cow();

        // [문제] 중복
        // [해결] 메서드로 중복 제거 시도
        System.out.println("===== 동물 소리 테스트 시작 =====");
        dog.sound();
        System.out.println("===== 동물 소리 테스트 종료 =====");
        // System.out.println("===== 동물 소리 테스트 시작 =====");
        // dog.sound();
        // System.out.println("===== 동물 소리 테스트 종료 =====");
        // System.out.println("===== 동물 소리 테스트 시작 =====");
        // dog.sound();
        // System.out.println("===== 동물 소리 테스트 종료 =====");

        // [문제] 매개 변수 클래스가 달라 동물 타입별로 메서드 하나 만들어짐.
        soundCat(cat);
        soundCow(cow);

        // [해결 시도] 배열을 통해 처리 시도 
        // [문제] 배열 타입은 여러 객체 처리 불가능
        //Cow[] cowArr = {cat, dog, cow}; //컴파일 오류 발생!

        // [공통 문제] 객체 타입이 달라 호환 안 된다는 점
        // [해결] 같은 타입을 사용할 수 있다면? > 다형성!
    }

    public static void soundCat(Cat cat) {
        System.out.println("===== 동물 소리 테스트 시작 =====");
        cat.sound();
        System.out.println("===== 동물 소리 테스트 종료 =====");
    }

    public static void soundCow(Cow cow) {
        System.out.println("===== 동물 소리 테스트 시작 =====");
        cow.sound();
        System.out.println("===== 동물 소리 테스트 종료 =====");
    }
}
