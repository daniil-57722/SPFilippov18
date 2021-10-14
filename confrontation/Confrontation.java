public class Confrontation{

    public static void main(String[] args) throws InterruptedException {
        Thread egg = new voice("яйцо");
        Thread chicken = new voice("курица");
        egg.start();
        chicken.start();

        chicken.join();

        if (egg.isAlive()) {
            egg.join();
            output("яйцо");
        } else {
            output("курица");
        }
    }
    static void output(String winner) {
        System.out.println("Спор окончен! \n" + winner + " одержало(а) победу");
    }
}