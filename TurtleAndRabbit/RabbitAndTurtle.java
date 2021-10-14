package TurtleAndRabbit;

public class RabbitAndTurtle {
    public static void main(String[] args) {
    AnimalThread RabbitThread = new AnimalThread("Кролик", 5);
    AnimalThread TurtleThread = new AnimalThread("Черепаха", 7);
    RabbitThread.start();
    TurtleThread.start();
    }
}
