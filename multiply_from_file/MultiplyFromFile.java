import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class MultiplyFromFile {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("mult.txt"));
            String line =  reader.readLine();
            System.out.println(line);
            String[] znach = line.split(" ?\\* ?");
            multiply(znach);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void multiply(String[] arr){
        double res = 1;
        for (String i : arr){
            res /= 1/(double) Integer.parseInt(i);
        }
        System.out.printf("Ответ >> %d",(int)Math.round(res));
    }
}
