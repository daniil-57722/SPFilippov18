public class voice extends Thread {
    Thread thread;
    public voice(String Name) {
        thread = new Thread(Name);
    }
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            try {
                sleep(100); }
            catch (InterruptedException e) { }
            System.out.println(thread.getName());
        }
    }
}
