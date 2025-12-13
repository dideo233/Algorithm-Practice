package reviewing.step2.sec09polymorphism.example.poly;

/**
 * 다형성 적용 예제
 * - AnimalMonoEx 문제점 개선
 *   1. 다형적 참조: 부모 타입(Animal)으로 자식 객체들을 한 번에 처리(배열 등).
 *   2. 메서드 오버라이딩: 부모 타입으로 메서드를 호출해도, 실제 인스턴스(자식)의 메서드가 실행됨.
 *   -> Mono 예제의 중복 및 확장성 문제를 개선.
 */
public class AnimalPolyEx {

    public static void main(String[] args) {
        // 부모 타입인 Animal 배열에 자식 객체들을 담음
        Animal[] animals = {new Dog(),new Cow(),new Cat()};

        for (Animal animal : animals) {
            soundAnimal(animal);
        }
    }

    /**
     * [남은 문제점 / 한계]
     * 1. 인스턴스 생성 문제:
     *    'Animal'은 추상적인 개념이라 직접 생성할 일이 없지만, 현재 new Animal()이 가능함.
     *    > 실체 없는 껍데기 객체가 생성되어, 로직상 불필요한 오류를 유발할 수 있다.
     * 2. 오버라이딩 강제성 부재:
     *    이번 개선은 자식 클래스의 오버라이딩을 전제로 한다.
     *    > 현재 개발자가 실수로 자식 클래스에서 sound()를 오버라이딩하지 않을 수 있다.
     *
     * [해결 방향]
     *   인스턴스 생성을 막고, 오버라이딩을 강제해야 한다.
     *   추상 클래스(Abstract Class)와 추상 메서드(Abstract Method) 도입 필요!
     */

    private static void soundAnimal(Animal animal) {
        System.out.println("===== 동물 소리 테스트 시작 =====");
        animal.sound(); // 메서드 오버라이딩에 의해 실제 인스턴스(Dog, Cat 등)의 메서드가 호출됨 (우선권)
        System.out.println("===== 동물 소리 테스트 종료 =====");
    }
}


