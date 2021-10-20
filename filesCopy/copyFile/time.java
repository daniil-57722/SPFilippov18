package copyFile;

import java.io.IOException;

public class time extends Thread {
    public static void main(String[] args) throws IOException, InterruptedException {
        String waycopy1 = "files_for_copy/forCopy1.txt";
        String waypaste1 = "files_for_copy/forPaste1.txt";
        String waycopy2 = "files_for_copy/forCopy2.txt";
        String waypaste2 = "files_for_copy/forPaste2.txt";

        //копирование одного файла

        long bef = System.currentTimeMillis();
        CopyFile copyFile = new CopyFile(waycopy1, waypaste1);
        copyFile.copy();

        long aft = System.currentTimeMillis();

        System.out.print("время копирования 1 файла  ");
        System.out.print(aft-bef+" ms\n");

        /*Задание 2
        копирование 2х файлов последовательно
         */
        bef = System.currentTimeMillis();
        CopyFile copyFile1 = new CopyFile(waycopy1, waypaste1);
        copyFile1.copy();
        CopyFile copyFile2 = new CopyFile(waycopy2, waypaste2);
        copyFile2.copy();
        System.out.print("время копирования 2 файлов последовательно  ");
        sleep(2);
        aft = System.currentTimeMillis();
        System.out.print(aft-bef+"ms \n");

        /*Задание 3
        копирование 2х файлов параллельно*/
        bef = System.currentTimeMillis();
        CopyThread copy1 = new CopyThread(waycopy1, waypaste1);
        CopyThread copy2 = new CopyThread(waycopy2, waypaste2);
        //запуск потоков

        copy1.thread.start();
        copy2.thread.start();
        //ожидание завершения потоков

        copy1.thread.join();
        copy2.thread.join();

        aft = System.currentTimeMillis();

        System.out.print("время копирования 2 файлов параллельно  ");
        System.out.print(aft-bef + " ms \n");
    }
}
