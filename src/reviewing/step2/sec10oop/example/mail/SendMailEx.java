package reviewing.step2.sec10oop.example.mail;

/**
 * 예제 1
 */
public class SendMailEx {
    public static void main(String[] args) {
        Sender[] senders = new Sender[]{new EmailSender(), new SmsSender(), new FacebookSender()};
        for (Sender sender : senders) {
            sender.sendMail("Hello");
        }
    }
}
