package reviewing.step2.sec09polymorphism.example.mono;

/**
 * [목차]
 * Mono: "타입이 달라서 중복 코드 발생" (문제 인식)
 * Poly: "상속으로 타입 통일, 근데 부모 객체가 생성되고 오버라이딩 강제가 안 됨" (해결 및 한계)
 * Abstract: "추상 클래스로 생성 막고 오버라이딩 강제, 근데 순수 껍데기만 필요하다면?" (제약 강화)
 * Interface: "순수 껍데기(규격) 전용 문법 사용, 다중 구현이라는 이점 발견" (추상화, 다중 상속)
 * Diamond: "근데 왜 다중 구현은 되고 다중 상속은 안 됨?" (심화 학습)
 */

/**
 * 다형성이 적용되지 않은 예제
 */
public class AnimalMonoEx {

    public static void main(String[] args) {
        Dog dog = new Dog();
        Cat cat = new Cat();
        Cow cow = new Cow();

        // [문제 1] 코드 중복 발생
        // 동물이 늘어날 때마다 호출 코드를 계속 복사/붙여넣기 해야 함.
        System.out.println("===== 동물 소리 테스트 시작 =====");
        dog.sound();
        System.out.println("===== 동물 소리 테스트 종료 =====");

        // System.out.println("===== 동물 소리 테스트 시작 =====");
        // cat.sound();
        // System.out.println("===== 동물 소리 테스트 종료 =====");
        // ... (반복)

        // [시도 1] 메서드 추출을 통한 중복 제거 시도
        // [한계] 매개변수의 타입이 다르기 때문에, 동물 종류별로 메서드를 따로 만들어야 함 (soundCat, soundCow...).
        soundCat(cat);
        soundCow(cow);

        // [시도 2] 배열을 통한 일괄 처리 시도
        // [한계] 배열은 같은 타입만 담을 수 있으므로, 서로 다른 타입의 객체(Dog, Cat, Cow)를 하나의 배열에 담을 수 없음.
        // Cow[] cowArr = {cat, dog, cow}; // 컴파일 오류 발생!

        // [결론]
        // 객체의 구체적인 타입(Dog, Cat)이 서로 달라 호환되지 않는 것이 근본적인 원인.
        // 해결책: 이들을 아우르는 상위 타입이 있다면? -> 다형성 필요!
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
