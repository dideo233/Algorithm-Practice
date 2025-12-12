package reviewing.step2.sec05.accessmodifier.subpackage;

// 다른 패키지의 클래스를 쓰려면 import 필수
import reviewing.step2.sec05.accessmodifier.mainpackage.AccessData;

public class AccessOuterEx {
    public static void main(String[] args) {
        AccessData data = new AccessData();

        // 1. public: 가능 (어디서나 OK)
        data.publicField = 1;

        // 2. default: 불가능 (여긴 'b' 패키지, 쟤는 'a' 패키지)
        // data.defaultField = 2; // 컴파일 에러

        // 3. private: 불가능
        // data.privateField = 3; // 컴파일 에러

        data.innerAccess(); //data가 자기 내부의 있는 것 접근하는 셈이니 가능
    }
}
