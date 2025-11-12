import java.util.Scanner;

public class TP3Calculateur {
    public static void main(String[] args) {
        // Créer un objet Scanner pour lire les entrées de l'utilisateur
        Scanner scanner = new Scanner(System.in);

        // Demander à l'utilisateur de saisir les deux entiers
        System.out.print("Entrez le premier entier (A) : ");
        int A = scanner.nextInt();

        System.out.print("Entrez le deuxième entier (B) : ");
        int B = scanner.nextInt();

        // Demander à l'utilisateur de saisir l'opération
        System.out.print("Entrez l'opération ( + , - , * , / ) : ");
        char op = scanner.next().charAt(0); // Lecture de l'opération

        // Calcul et affichage du résultat selon l'opération
        switch (op) {
            case '+':
                System.out.println("Résultat : " + (A + B));
                break;
            case '-':
                System.out.println("Résultat : " + (A - B));
                break;
            case '*':
                System.out.println("Résultat : " + (A * B));
                break;
            case '/':
                // Vérification pour éviter la division par zéro
                if (B != 0) {
                    System.out.println("Résultat : " + (A / B));
                } else {
                    System.out.println("Erreur : Division par zéro impossible.");
                }
                break;
            default:
                System.out.println("Opération invalide.");
        }

        // Fermer le scanner
        scanner.close();
    }
}
