package reviewing.step2.sec10oop.noseperate;

/**
 * 역할-구현 문제 확인 예제
 */
public class CarEx {

    public static void main(String[] args) {

        // 예제1
        Driver driver = new Driver();
        K3Car k3Car = new K3Car();

        driver.setK3Car(k3Car);
        driver.drive();

        // Model3Car 추가
        // [문제] 구현이 하나 추가될 때마다 Main 뿐 아니라 Driver 내 코드도 수정해야 했다.
        Model3Car model3Car = new Model3Car();
        driver.setK3Car(null);
        driver.setModel3Car(model3Car);
        driver.drive();

    }
}
