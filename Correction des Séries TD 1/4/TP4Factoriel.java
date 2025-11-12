import java.util.Scanner;

public class TP4Factoriel {
    public static void main(String[] args) {
        // Créer un objet Scanner pour lire l'entrée de l'utilisateur
        Scanner scanner = new Scanner(System.in);

        // Demander à l'utilisateur de saisir un entier N
        System.out.print("Entrez un entier N : ");
        int N = scanner.nextInt();

        // Calculer la factorielle de N
        // Utiliser long pour éviter les débordements pour des grandes valeurs de N
        long resultat = 1;  

        // Si N est un entier positif ou nul, calculer la factorielle
        if (N >= 0) {
            for (int i = 1; i <= N; i++) {
                resultat *= i;
            }
            System.out.println("La factorielle de " + N + " est : " + resultat);
        } else {
            // Si N est négatif, afficher un message d'erreur
            System.out.println("Erreur : la factorielle n'est définie pour N<0");
        }

        // Fermer le scanner
        scanner.close();
    }
}
