package reviewing.step2.sec10oop.example.mail;

public class EmailSender implements Sender {

    @Override
    public void sendMail(String message) {
        System.out.println("Email Sender : " + message);
    }

}
