import TurtleAndRabbit.AnimalThread;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class MultiplyFromFile {
    private static String message;
    private static Logger log;

    public static void main(String[] args) {

        log = Logger.getLogger(AnimalThread.class.getName());
        log.setUseParentHandlers(false);
    //логирование
        try {
            //привязка файла
            FileHandler fh = new FileHandler("D:\\SystemPr\\logging.txt");
            SimpleFormatter formatter = new SimpleFormatter();
            fh.setFormatter(formatter);
            log.addHandler(fh);
            log.info("Program started");
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            BufferedReader reader = new BufferedReader(new FileReader("mult.txt"));
            String line =  reader.readLine();
            System.out.println(line);

            //запись в лог

            message = "File reading: " + line;
            log.info(message);
            String[] znach = line.split(" ?\\* ?");
            multiply(znach);
        }
        catch (IOException e) {
            // если не получится найти файл
            log.log(Level.WARNING, "Exception: ", e);
            e.printStackTrace();
        }
    }
    public static void multiply(String[] arr){
        double res = 1;
        try {


            for (String i : arr) {
                res /= 1 / (double) Integer.parseInt(i);
            }
        }
        catch (NumberFormatException e){
            //если не число запись в лог
            log.log(Level.WARNING, "no int ", e);
        }
        System.out.printf("Ответ >> %d",(int)Math.round(res));

        //запись в лог

        message = "result >>  "+(int)Math.round(res);
        log.info(message);
    }
}
