package reviewing.step2.sec10oop.seperate;

/**
 * noseperate 문제 해결 예제 (역할-구현 분리)
 */
public class CarEx {

    public static void main(String[] args) {

        // 예제2
        Driver driver = new Driver();

        K3Car k3Car = new K3Car();
        driver.setCar(k3Car);
        driver.drive();

        System.out.println();

        // Model3Car 추가
        Model3Car model3Car = new Model3Car();
        driver.setCar(model3Car);
        driver.drive();

        System.out.println();

        // NewCar 추가
        NewCar newCar = new NewCar();
        driver.setCar(newCar);
        driver.drive();

        // [해결] 역할-구현 분리
        //   Driver: 자동차 구현에 의존하지 않도록 수정한다. Car 인터페이스만 참조한다.
        //   Car : 자동차는 인터페이스다. K3Car, Model3Car는 구현한다.

    }
}
