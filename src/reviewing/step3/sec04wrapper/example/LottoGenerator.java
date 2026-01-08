package reviewing.step3.sec04wrapper.example;

import java.util.Random;

/**
 * 로또 번호 생성기 (1~45 중복 없는 숫자 6개)
 *
 * [구현 포인트 및 주의사항]
 * - 중첩 반복문 지양 (메서드 분리):
 *   중복 체크 로직을 `isUnique()` 메서드로 분리하여, 복잡한 중첩 for문과 break/continue 사용을 제거함.
 *
 * - while문 사용 이유:
 *   중복이 발생하면 인덱스를 증가시키지 않고 다시 뽑아야 함.
 *   반복 횟수가 명확하지 않으므로, 유효한 숫자가 뽑혔을 때만 인덱스를 직접 제어하기 위해 while문이 적합함.
 *
 * - 인덱스 변수 분리:
 *   for문의 i를 사용하는 대신, `count` 변수를 따로 두어 숫자가 정상적으로 등록되었을 때만 증가시킴.
 */
public class LottoGenerator {
    private final Random random = new Random();
    private int[] numbers;
    private int count; // 현재까지 생성된 번호의 개수 (인덱스 역할)

    public int[] generate(){
        numbers = new int[6];
        count = 0;

        while (count < 6) {
            int number = random.nextInt(45) + 1; // 1 ~ 45 난수 생성
            if(isUnique(number)){
                numbers[count] = number;
                count++;
            }
        }

        return numbers;
    }

    // 배열 내 중복 체크
    private boolean isUnique(int number) {
        for (int i = 0; i < count; i++) {
            if (numbers[i] == number) {
                return false;
            }
        }
        return true;
    }
}
