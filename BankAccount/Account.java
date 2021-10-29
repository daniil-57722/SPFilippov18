package BankAccount;

public class Account {
    static long balance;
    Account(){
        this(0);
    }

    Account(long balance){
        this.balance=balance;
    }

    //метод на добавление денег
    public void addMoney(){
        int money = (int) (Math.random()*1000);
        balance+=money;
    System.out.println("Было зачислено "+money+"руб   Текущий баланс "+ balance);}


    //метод на снятие денег
    public static void reduceMoney() {
            balance -= Main.sum;
            System.out.println("Было снято " + Main.sum + "руб   Текущий баланс " + balance);
    }
}
