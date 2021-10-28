package CopyFileNIO;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class Main {

    public static void main(String[] args) throws InterruptedException, IOException {
        Path waycopy1 = Path.of("files_for_copy/forCopy1.txt");
        Path waypaste1 = Path.of("files_for_copy/forPaste1.txt");
        Path waycopy2 = Path.of("files_for_copy/forCopy2.txt");
        Path waypaste2 = Path.of("files_for_copy/forPaste2.txt");


        CopyThreadNIO CopyNIO1 = new CopyThreadNIO(waycopy1, waypaste1);
        CopyThreadNIO CopyNIO2 = new CopyThreadNIO(waycopy2, waypaste2);

//параллельное копирование
        long a = System.currentTimeMillis();
        //запуск потоков
        CopyNIO1.thread.start();
        CopyNIO2.thread.start();
        CopyNIO1.thread.join();
        CopyNIO2.thread.join();

        long b = System.currentTimeMillis();
        System.out.println("Время параллельного копирования " + (b-a)+ " ms");
        //последоваельное копирование
        a = System.currentTimeMillis();
        Files.copy(waycopy1, waypaste1, StandardCopyOption.REPLACE_EXISTING);
        Files.copy(waycopy2, waypaste2, StandardCopyOption.REPLACE_EXISTING);
        b = System.currentTimeMillis();
        System.out.println("Время последовательного копирования " + (b-a)+ " ms");



    }
}
