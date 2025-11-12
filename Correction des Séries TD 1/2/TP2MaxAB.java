import java.util.Scanner;

public class TP2MaxAB {
    public static void main(String[] args) {
        // Créer un objet Scanner pour lire les entrées de l'utilisateur
        Scanner scanner = new Scanner(System.in);

        // Demander à l'utilisateur de saisir les deux valeurs
        System.out.print("Entrez la première valeur (A) : ");
        int A = scanner.nextInt();
        
        System.out.print("Entrez la deuxième valeur (B) : ");
        int B = scanner.nextInt();
        
        // Comparer les deux valeurs et afficher la plus grande
        if (A > B) {
            System.out.println("La plus grande valeur est : " + A);
        } else if (B > A) {
            System.out.println("La plus grande valeur est : " + B);
        } else {
            System.out.println("Les deux valeurs sont égales.");
        }

        // Fermer le scanner
        scanner.close();
    }
}
