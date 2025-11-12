import java.util.Scanner;

public class TP1 {
    public static void main(String[] args) {
        float PN, PB;
        final int TVA = 20;
        System.out.println("Donner le PrixNet : ");
        Scanner sc=new Scanner(System.in);
        PN = sc.nextFloat();
        PB = PN + (PN*TVA/100);
        System.out.println("Le PrixBrut : ");
        System.out.println(PB);
    }
}
