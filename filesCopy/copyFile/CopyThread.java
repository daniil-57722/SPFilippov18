package copyFile;

import java.io.IOException;

public class CopyThread implements Runnable{
    private String way1;
    private String way2;
    Thread thread;
    CopyThread(String way1, String way2){
        this.way1=way1;
        this.way2=way2;
        thread = new Thread (this);
    }


    @Override
    public void run() {
        CopyFile cf = new CopyFile(way1, way2);
        try {
            cf.copy();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

