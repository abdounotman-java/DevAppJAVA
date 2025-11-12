import java.util.Arrays;
import java.util.Scanner;

public class TP6 {
    private static final int MAX_ETUDIANTS = 30;
    private static double[] notes = new double[MAX_ETUDIANTS];
    private static int nombreEtudiants = 0;

    // Méthode pour saisir la note d'un seul étudiant
    public static void saisirNote() {
        if (nombreEtudiants < MAX_ETUDIANTS) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Saisir la note de l'étudiant " + (nombreEtudiants + 1) + ": ");
            double note = scanner.nextDouble();
            while (note < 0 || note > 20) {
                System.out.println("Veuillez saisir une note valide entre 0 et 20.");
                note = scanner.nextDouble();
            }
            notes[nombreEtudiants] = note;
            nombreEtudiants++;
        } else {
            System.out.println("Capacité maximale atteinte !");
        }
    }

    // Méthode pour calculer la moyenne des notes
    public static double calculerMoyenne() {
        if (nombreEtudiants == 0) {
            System.out.println("Aucune note n'a été saisie.");
            return 0;
        }
        double somme = 0;
        for (int i = 0; i < nombreEtudiants; i++) {
            somme += notes[i];
        }
        return somme / nombreEtudiants;
    }

    // Méthode pour trier les notes dans l'ordre décroissant
    public static void trierNotes() {
        Arrays.sort(notes, 0, nombreEtudiants); // Tri croissant
        // Inversion pour obtenir le tri décroissant
        for (int i = 0; i < nombreEtudiants / 2; i++) {
            double temp = notes[i];
            notes[i] = notes[nombreEtudiants - 1 - i];
            notes[nombreEtudiants - 1 - i] = temp;
        }
    }

    // Méthode principale
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choix;
        do {
            System.out.println("\n--- Menu ---");
            System.out.println("1. Saisir une note");
            System.out.println("2. Calculer la moyenne des notes");
            System.out.println("3. Trier les notes (ordre décroissant)");
            System.out.println("4. Afficher les notes");
            System.out.println("5. Quitter");
            System.out.print("Votre choix : ");
            choix = scanner.nextInt();

            switch (choix) {
                case 1:
                    saisirNote();
                    break;
                case 2:
                    double moyenne = calculerMoyenne();
                    System.out.println("La moyenne des notes est : " + moyenne);
                    break;
                case 3:
                    trierNotes();
                    System.out.println("Les notes ont été triées dans l'ordre décroissant.");
                    break;
                case 4:
                    System.out.println("Notes : " + Arrays.toString(Arrays.copyOf(notes, nombreEtudiants)));
                    break;
                case 5:
                    System.out.println("Au revoir !");
                    break;
                default:
                    System.out.println("Choix invalide.");
            }
        } while (choix != 5);
        scanner.close();
    }
}