package ParallelDownloading;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class launch {
    public static void main(String[] args) {

        String[] mas = new String[2];
        String extension = "/image.jpg";
        DownloadThread downloadThread = null;
        try {

            BufferedReader bufferedReader = new BufferedReader(new FileReader("files.txt"));
            for (int i = 0; i < 2; i++) {
                mas = bufferedReader.readLine().split(" ");
                //создание и запуск потоков
                downloadThread = new DownloadThread(mas[0], mas[1], extension);
                downloadThread.thread.start();
                extension = "/music.mp3";
            }
        } catch (IOException e) {
            System.out.println("проблемы со считыванием");
        }
        while (downloadThread.thread.isAlive()) {
        }

        //запуск музыки
        System.out.println("хочешь послушать музыку Д/Н >>");
        Scanner in = new Scanner(System.in);
        String accept = in.nextLine();

        if (accept.equals("Д") || accept.equals("д")) {
            System.out.println("^o^ а теперь музыкааааа ^o^");
            //тут сам запуск музыки. в этот метод улетает путь для музыки
            playmusic p = new playmusic();
            p.play(mas[1]);
        }
    }
}
