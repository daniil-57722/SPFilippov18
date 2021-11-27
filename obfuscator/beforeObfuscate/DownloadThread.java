package ParallelDownloading;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

public class DownloadThread implements Runnable {

    String link;
    String path;
    String extension;
    Thread thread;

    public DownloadThread(String link, String path, String extension) {
        this.link = link;
        this.path = path;
        this.extension = extension;
        thread = new Thread (this);
    }

    @Override
    public void run() {
        System.out.println("процесс скачивания "+extension.substring(1)+" файла начался");
        try {
            //само скачивание
            URL url = new URL(link);
            ReadableByteChannel byteChannel = Channels.newChannel(url.openStream());
            FileOutputStream stream = new FileOutputStream(path+extension);
            stream.getChannel().transferFrom(byteChannel, 0, Long.MAX_VALUE);
            stream.close();
            byteChannel.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        //Вывод
        System.out.println("процесс скачивания "+extension.substring(1) +" файла завершился");
        System.out.println("файл находится по пути "+path);
    }
}