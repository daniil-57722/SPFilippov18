package TurtleAndRabbit;

public class AnimalThread extends Thread {
    String Name;
    int Priority;
    int Distance = 40;

    public AnimalThread(String Name, int Priority) {
        this.Name = Name;
        this.Priority = Priority;
    }

    @Override
    public void run() {
    Thread.currentThread().setPriority(Priority);
    Thread.currentThread().setName(Name);
        for (int i = 1; i <= Distance; i++) {
            try {
                Thread.sleep( Thread.currentThread().getPriority() * 100 );
                System.out.println("Гонщик "+getName() + " преодолел   " + i + "   метров ");
            } catch (InterruptedException e) {
                System.out.println("похоже, что то мешает гонке");
            }
            if (i==Distance/2) {
                setRacerPriority(currentThread());
                }
        }
        System.out.println("🎇🎇🎇🎇" + getName() + " Закончил гонку 🎆🎆🎆🎆");
    }void setRacerPriority(Thread thread){
        if (thread.getName()=="Кролик"){
        currentThread().setPriority(8);
        System.out.println("Кролик, похоже, начал уставать");}
        else{
        currentThread().setPriority(4);
        System.out.println("а черепаха решила ускориться");}
    }
}

