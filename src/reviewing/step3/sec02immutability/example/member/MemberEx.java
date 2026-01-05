package reviewing.step3.sec02immutability.example.member;

import reviewing.step3.sec02immutability.Address;
import reviewing.step3.sec02immutability.ImmutableAddress;

public class MemberEx {
    public static void main(String[] args) {
        // 1. 가변 객체 - 공유 참조 문제 발생
        Address address = new Address("서울");
        MemberV1 memberA = new MemberV1("회원A", address);
        MemberV1 memberB = new MemberV1("회원B", address);

        memberB.getAddress().setValue("부산");
        System.out.println("memberA = " + memberA);  // 서울 -> 부산으로 변경됨!
        System.out.println("memberB = " + memberB);

        // 2. 불변 객체 - 안전하게 공유 가능
        ImmutableAddress immutableAddr = new ImmutableAddress("서울");
        MemberV2 memberC = new MemberV2("회원C", immutableAddr);
        MemberV2 memberD = new MemberV2("회원D", immutableAddr);

        memberD.setAddress(new ImmutableAddress("부산"));  // 새 객체 생성 필요
        System.out.println("memberC = " + memberC);  // 서울 유지
        System.out.println("memberD = " + memberD);
    }
}
