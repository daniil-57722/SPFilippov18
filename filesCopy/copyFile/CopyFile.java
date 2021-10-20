package copyFile;

import java.io.*;

public class CopyFile {
    String WayToCopy1;
    String WayToPaste1;


    CopyFile(String WayToCopy1, String WayToPaste1) {
        this.WayToCopy1 = WayToCopy1;
        this.WayToPaste1 = WayToPaste1;

    }

    void copy() throws IOException {
        try (BufferedWriter fw = new BufferedWriter(new FileWriter(WayToPaste1))) {
            try (BufferedReader br = new BufferedReader(new FileReader(WayToCopy1))) {
                String line;
                while ((line = br.readLine()) != null) {
                    fw.write(line + "\n");
                }
                fw.flush();
                fw.close();

            } catch (IOException e) {
            }
        }
    }
}