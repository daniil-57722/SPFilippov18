package ParallelDownloading;import java.io.FileOutputStream;import java.io.IOException;import java.net.URL;import java.nio.channels.Channels;import java.nio.channels.ReadableByteChannel;public class D implements Runnable {String l1k;String p1h;String e1n;Thread t1d;public D(String l1k, String p1h, String e1n) {this.l1k = l1k;this.p1h = p1h;this.e1n = e1n;t1d = new Thread (this);}@Override public void run() {System.out.println("процесс скачивания "+e1n.substring(1)+" файла начался");try {URL u1l = new URL(l1k);ReadableByteChannel b1l = Channels.newChannel(u1l.openStream());FileOutputStream s1m = new FileOutputStream(p1h+e1n);s1m.getChannel().transferFrom(b1l, 0, Long.MAX_VALUE);s1m.close();b1l.close();} catch (IOException e) {e.printStackTrace();}System.out.println("процесс скачивания "+e1n.substring(1) +" файла завершился");System.out.println("файл находится по пути "+p1h);}}