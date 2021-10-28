package CopyFileNIO;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class CopyThreadNIO implements Runnable {
    Path WayToCopy;
    Path WayToPaste;
    Thread thread;

    public CopyThreadNIO(Path waycopy, Path waypaste) {
        WayToCopy = waycopy;
        WayToPaste = waypaste;
        thread = new Thread(this, "NIO");

    }

    @Override
    public void run() {
        try{
            Files.copy(WayToCopy, WayToPaste, StandardCopyOption.REPLACE_EXISTING);}
        catch (IOException e){
            e.printStackTrace();
        }
    }

}
