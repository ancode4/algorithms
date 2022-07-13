package interview_practice.multithreading.waitAndNotify;

public class Main {
    public static void main(String[] a) {
        Data data = new Data();
        Thread sender = new Thread(new Sender(data));
        Thread receiver = new Thread(new Receiver(data));

        sender.start();
        receiver.start();
    }
}
