package reviewing.step2.sec09polymorphism.example.poly;

/**
 * 다형성 적용 예제
 * - AnimalMonoEx를 개선햇따!
 */
public class AnimalPolyEx {

    /**
     * 다형적 참조를 통해 객체를 하나로 처리할 수 있었고,
     * 메서드 오버라이딩을 통해 각각의 인스턴스 메서드를 호출할 수 있었다
     * > mono 문제를 해결했다!
     */
    public static void main(String[] args) {
        Animal[] animals = {new Dog(),new Cow(),new Cat()};

        for (Animal animal : animals) {
            soundAnimal(animal);
        }
    }

    // [문제 제기]
    // - animals은 추상적인 개념. class로 정의되었으니 객체 생성은 된다. (인스턴스를 생성할 일 없는 클래스)
    // - 아래 코드는 자식 클래스가 오버라이딩을 하는 걸 전제로 한다. (오버라이딩을 하지 않을 가능성 존재)
    // > 그런데 부모 클래스로 객체를 생성할 수 있고, 자식 클래스에서 오버라이딩을 하지 않을 수 있다!
    // > 이를 해결하기 위해 추상 클래스라는 걸 쓴다

    private static void soundAnimal(Animal animal) {
        System.out.println("===== 동물 소리 테스트 시작 =====");
        animal.sound(); // 메서드 오버라이딩 (우선권)
        System.out.println("===== 동물 소리 테스트 종료 =====");
    }
}

