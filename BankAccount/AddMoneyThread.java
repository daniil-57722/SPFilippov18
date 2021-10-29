package BankAccount;

public class AddMoneyThread implements Runnable{
    Account account;
    Thread thread;
    AddMoneyThread(Account account){
        this.account = account;
        this.thread = new Thread(this, "addMoney");
    }

    @Override
    public void run() {
        while (account.balance<=Main.sum){
            account.addMoney();//метод на добавление денег
        }
        thread.interrupt();//завершение потока (на всякий)
    }
}
