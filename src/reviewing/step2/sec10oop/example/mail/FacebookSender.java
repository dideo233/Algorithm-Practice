package reviewing.step2.sec10oop.example.mail;

public class FacebookSender implements Sender {

    @Override
    public void sendMail(String message) {
        System.out.println("FacebookSender : " + message);
    }

}
