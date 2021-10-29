package BankAccount;

import copyFile.time;

import java.util.Scanner;

public class Main {
    static int sum;
    public static void main(String[] args) throws InterruptedException {
        Account account = new Account();
        System.out.println("сколько раз вы хотите снять деньги");
        Scanner in = new Scanner(System.in);
        int count = in.nextInt();
        for(int i = 0; i < count; i++) {
                System.out.println("Какую сумму вы хотите снять?");
                sum = in.nextInt();

                //создание потока

                Thread threadAdd = new Thread(new AddMoneyThread(account));//поток на добавление денег

                //старт потока
                threadAdd.start();

                //ожидание завершения потока
                threadAdd.join();

                //метод списывания денег
                Account.reduceMoney();

            }
        }
    }

