package reviewing.step3.sec05enum.example;

import java.util.Scanner;

/**
 * Enum 활용 연습 문제
 * 1. 인증 등급(AuthGrade) 조회 및 권한 확인
 * 2. HTTP 상태 코드(HttpStatus) 검색 및 성공 여부 확인
 */
public class AuithGradeEx {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // [문제 1 & 2] 인증 등급 열거형 정의 및 전체 조회
        // - 등급(grade), 레벨(level), 설명(description) 출력
        AuthGrade[] values = AuthGrade.values();
        for (AuthGrade value : values) {
            System.out.println("grade=" + value.name() + ", level=" + value.getLevel()
                    + ", description=" + value.getDescription());
        }

        // [문제 3] 인증 등급에 따른 차등 메뉴 조회
        // - 입력받은 등급의 레벨에 따라 접근 가능한 메뉴를 출력한다.
        System.out.print("\n당신의 등급을 입력하세요[GUEST, LOGIN, ADMIN]: ");
        String gradeInput = sc.nextLine();

        AuthGrade authGrade = AuthGrade.valueOf(gradeInput.toUpperCase());
        System.out.println("당신의 등급은 " + authGrade.getDescription() + "입니다.");

        System.out.println("== 메뉴 목록 ==");
        if (authGrade.getLevel() > 0) {
            System.out.println("- 메인 화면");
        }
        if (authGrade.getLevel() > 1) {
            System.out.println("- 이메일 관리 화면");
        }
        if (authGrade.getLevel() > 2) {
            System.out.println("- 관리자 화면");
        }

        // [문제 4] HTTP 상태 코드 검색
        // - 입력받은 숫자로 HttpStatus를 찾고, 성공 여부를 판단한다.
        System.out.print("HTTP CODE 입력: ");
        int httpCodeInput = sc.nextInt();

        HttpStatus status = HttpStatus.findByCode(httpCodeInput);

        if (status == null) {
            System.out.println("정의되지 않은 코드입니다.");
        } else {
            System.out.println("Code: " + status.getCode() + ", Msg: " + status.getMessage());
            System.out.println("isSuccess: " + status.isSuccess());
        }

        sc.close();
    }
}
