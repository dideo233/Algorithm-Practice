package reviewing.step2.sec05accessmodifier.mainpackage;

public class AccessInnerEx {
    public static void main(String[] args) {
        AccessData data = new AccessData();

        // 1. public: 가능
        data.publicField = 1;

        // 2. default: 가능 (AccessData와 AccessInnerEx는 같은 'a' 패키지)
        data.defaultField = 2;

        // 3. private: 불가능 (컴파일 에러)
        // data.privateField = 3;

        data.innerAccess(); // 메서드를 통한 내부 접근은 가능
    }
}
