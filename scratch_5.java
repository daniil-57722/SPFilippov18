
import java.util.Scanner;

class Scratch {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите выражение");
        String[] znach = in.nextLine().split(" ?\\* ?");
        multiply(znach);
    }
    public static void multiply(String[] arr){
        double res = 1;
        for (String i : arr){
            res /= 1/(double) Integer.parseInt(i);
        }
        System.out.printf("Ответ >> %d",(int)Math.round(res));
    }
}
