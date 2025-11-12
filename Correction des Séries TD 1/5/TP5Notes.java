import java.util.Scanner;

public class TP5Notes {
    public static void main(String[] args) {
        // Créer un objet Scanner pour lire l'entrée de l'utilisateur
        Scanner scanner = new Scanner(System.in);

        // Déclaration de la variable pour stocker la somme des notes
        double somme = 0;
        int nombreEtudiants = 05;

        // Saisie des notes pour les 20 étudiants
        for (int i = 1; i <= nombreEtudiants; i++) {
            System.out.print("Entrez la note de l'étudiant " + i + ": ");
            double note = scanner.nextDouble();
            somme += note;  // Ajouter la note à la somme totale
        }

        // Calcul de la moyenne
        double moyenne = somme / nombreEtudiants;

        // Affichage de la moyenne
        System.out.println("La moyenne des notes est : " + moyenne);

        // Fermer le scanner
        scanner.close();
    }
}
