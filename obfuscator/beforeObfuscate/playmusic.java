package ParallelDownloading;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;
import java.io.FileInputStream;
import java.io.IOException;
//класс для проигрывания музыки
public class playmusic {
    void play(String path){
        //магия
        try (FileInputStream inputStream = new FileInputStream(path+"/music.mp3")) {
            try {
                Player p = new Player(inputStream);
                p.play();
            } catch (JavaLayerException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}