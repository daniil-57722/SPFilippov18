import java.util.Scanner;
class Scratch {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите первый множитель");
        int mn1 = in.nextInt();
        System.out.println("Введите второй множитель");
        int mn2 = in.nextInt();
        multiply(mn1, mn2);
    }
    public static void multiply(int mn1, int mn2){
        if (mn1==0||mn2==0){
            System.out.println(0);
        }
        else {
            double c = ((double) mn1/(1/(double)mn2) );
            System.out.println((long) c);
        }
    }
}
